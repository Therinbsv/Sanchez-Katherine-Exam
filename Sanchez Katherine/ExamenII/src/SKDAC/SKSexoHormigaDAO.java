package SKDAC;

import SKDAC.SKDTO.SKSexoHormigaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SKSexoHormigaDAO extends SKDataHelper implements SKIDAO<SKSexoHormigaDTO> {

    @Override
    public List<SKSexoHormigaDTO> readALL() throws Exception {
        List<SKSexoHormigaDTO> SKlist = new ArrayList<>();
        String SKquery = "SELECT idSKSexoHormiga    "
                        +",SKSexo                   "
                        +",SKEstado                 "
                        +",SKFechaModificacion      " 
                        +"FROM SKSexoHormiga        "
                        +"WHERE SKEstado = 'A'      ";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery);
             ResultSet SKrs = SKpstmt.executeQuery()) {

            while (SKrs.next()) {
                SKSexoHormigaDTO SKdto = new SKSexoHormigaDTO(
                    SKrs.getInt("idSKSexoHormiga"),            // idSKSexoHormiga
                    SKrs.getString("SKSexo"),                   // SKSexo
                    SKrs.getString("SKEstado"),                 // SKEstado
                    SKrs.getString("SKFechaModificacion")      // SKFechaModificacion
                );
                SKlist.add(SKdto);
            }
        } catch (SQLException SKe) {
            throw new Exception("Error al leer todos los registros: " + SKe.getMessage(), SKe);
        }
        return SKlist;
    }

    @Override
    public boolean create(SKSexoHormigaDTO SKentity) throws Exception {
        String SKquery = "INSERT INTO SKSexoHormiga (SKSexo, SKEstado, SKFechaModificacion) VALUES (?, ?, ?)";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setString(1, SKentity.getSKSexo());
            SKpstmt.setString(2, SKentity.getSKEstado());
            SKpstmt.setString(3, SKentity.getSKFechaModificacion());
            SKpstmt.executeUpdate();
            return true;
        } catch (SQLException SKe) {
            throw new Exception("Error al crear el registro: " + SKe.getMessage(), SKe);
        }
    }

    @Override
    public boolean delete(SKSexoHormigaDTO SKentity) throws Exception {
        String SKquery = "UPDATE SKSexoHormiga SET SKEstado = 'X' WHERE idSKSexoHormiga = ?";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setInt(1, SKentity.getIdSKSexoHormiga());
            int SKrowsAffected = SKpstmt.executeUpdate();
            return SKrowsAffected > 0;
        } catch (SQLException SKe) {
            throw new Exception("Error al eliminar el registro: " + SKe.getMessage(), SKe);
        }
    }

    @Override
    public SKSexoHormigaDTO readBy(Integer SKid) throws Exception {
        SKSexoHormigaDTO SKdto = null;
        String SKquery = "SELECT idSKSexoHormiga    "
                        +", SKSexo                  "
                        +", SKEstado                "
                        +", SKFechaModificacion     "
                        +" FROM SKSexoHormiga       "
                        +"WHERE idSKSexoHormiga = ? ";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setInt(1, SKid);
            try (ResultSet SKrs = SKpstmt.executeQuery()) {
                if (SKrs.next()) {
                    SKdto = new SKSexoHormigaDTO(
                        SKrs.getInt("idSKSexoHormiga"),            // idSKSexoHormiga
                        SKrs.getString("SKSexo"),                   // SKSexo
                        SKrs.getString("SKEstado"),                 // SKEstado
                        SKrs.getString("SKFechaModificacion")      // SKFechaModificacion
                    );
                }
            }
        } catch (SQLException SKe) {
            throw new Exception("Error al leer el registro: " + SKe.getMessage(), SKe);
        }
        return SKdto;
    }

    @Override
    public boolean update(SKSexoHormigaDTO SKentity) throws Exception {
        String SKquery = "UPDATE SKSexoHormiga SET SKSexo = ?"
                        +", SKEstado = ?"
                        +", SKFechaModificacion = ? "
                        +"WHERE idSKSexoHormiga = ?";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setString(1, SKentity.getSKSexo());
            SKpstmt.setString(2, SKentity.getSKEstado());
            SKpstmt.setString(3, SKentity.getSKFechaModificacion());
            SKpstmt.setInt(4, SKentity.getIdSKSexoHormiga());
            int SKrowsAffected = SKpstmt.executeUpdate();
            return SKrowsAffected > 0;
        } catch (SQLException SKe) {
            throw new Exception("Error al actualizar el registro: " + SKe.getMessage(), SKe);
        }
    }

    public Integer getRowCount() throws Exception {
        String SKquery = "SELECT COUNT(*) AS TotalReg FROM SKSexoHormiga WHERE SKEstado = 'A'";
        
        try (Connection SKconn = openConnection();
             Statement SKstmt = SKconn.createStatement();
             ResultSet SKrs = SKstmt.executeQuery(SKquery)) {
             
            if (SKrs.next()) {
                return SKrs.getInt("TotalReg");
            }
        } catch (SQLException SKe) {
            throw new Exception("Error al obtener el conteo de registros: " + SKe.getMessage(), SKe);
        }
        
        return 0;
    }
}

