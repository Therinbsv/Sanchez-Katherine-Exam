package SKDAC;

import SKDAC.SKDTO.SKGenoAlimentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SKGenoAlimentoDAO extends SKDataHelper implements SKIDAO<SKGenoAlimentoDTO> {

    @Override
    public List<SKGenoAlimentoDTO> readALL() throws Exception {
        List<SKGenoAlimentoDTO> SKlist = new ArrayList<>();
        String SKquery = "SELECT idSKGenoAlimento, SKGenoAlimento, SKEstado, SKFechaModificacion FROM SKGenoAlimento WHERE SKEstado = 'A'";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery);
             ResultSet SKrs = SKpstmt.executeQuery()) {

            while (SKrs.next()) {
                SKGenoAlimentoDTO SKdto = new SKGenoAlimentoDTO(
                    SKrs.getInt("idSKGenoAlimento"),            // idSKGenoAlimento
                    SKrs.getString("SKGenoAlimento"),            // SKGenoAlimento
                    SKrs.getString("SKEstado"),                  // SKEstado
                    SKrs.getString("SKFechaModificacion")       // SKFechaModificacion
                );
                SKlist.add(SKdto);
            }
        } catch (SQLException SKe) {
            throw new Exception("Error al leer todos los registros: " + SKe.getMessage(), SKe);
        }
        return SKlist;
    }

    @Override
    public boolean create(SKGenoAlimentoDTO SKentity) throws Exception {
        String SKquery = "INSERT INTO SKGenoAlimento (SKGenoAlimento, SKEstado, SKFechaModificacion) VALUES (?, ?, ?)";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setString(1, SKentity.getSKGenoAlimento());
            SKpstmt.setString(2, SKentity.getSKEstado());
            SKpstmt.setString(3, SKentity.getSKFechaModificacion());
            SKpstmt.executeUpdate();
            return true;
        } catch (SQLException SKe) {
            throw new Exception("Error al crear el registro: " + SKe.getMessage(), SKe);
        }
    }

    @Override
    public boolean delete(SKGenoAlimentoDTO SKentity) throws Exception {
        String SKquery = "UPDATE SKGenoAlimento SET SKEstado = 'X' WHERE idSKGenoAlimento = ?";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setInt(1, SKentity.getIdSKGenoAlimento());
            int SKrowsAffected = SKpstmt.executeUpdate();
            return SKrowsAffected > 0;
        } catch (SQLException SKe) {
            throw new Exception("Error al eliminar el registro: " + SKe.getMessage(), SKe);
        }
    }

    @Override
    public SKGenoAlimentoDTO readBy(Integer SKid) throws Exception {
        SKGenoAlimentoDTO SKdto = null;
        String SKquery = "SELECT idSKGenoAlimento, SKGenoAlimento, SKEstado, SKFechaModificacion FROM SKGenoAlimento WHERE idSKGenoAlimento = ?";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setInt(1, SKid);
            try (ResultSet SKrs = SKpstmt.executeQuery()) {
                if (SKrs.next()) {
                    SKdto = new SKGenoAlimentoDTO(
                        SKrs.getInt("idSKGenoAlimento"),            // idSKGenoAlimento
                        SKrs.getString("SKGenoAlimento"),            // SKGenoAlimento
                        SKrs.getString("SKEstado"),                  // SKEstado
                        SKrs.getString("SKFechaModificacion")       // SKFechaModificacion
                    );
                }
            }
        } catch (SQLException SKe) {
            throw new Exception("Error al leer el registro: " + SKe.getMessage(), SKe);
        }
        return SKdto;
    }

    @Override
    public boolean update(SKGenoAlimentoDTO SKentity) throws Exception {
        String SKquery = "UPDATE SKGenoAlimento SET SKGenoAlimento = ?, SKEstado = ?, SKFechaModificacion = ? WHERE idSKGenoAlimento = ?";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
             
            SKpstmt.setString(1, SKentity.getSKGenoAlimento());
            SKpstmt.setString(2, SKentity.getSKEstado());
            SKpstmt.setString(3, SKentity.getSKFechaModificacion());
            SKpstmt.setInt(4, SKentity.getIdSKGenoAlimento());
            int SKrowsAffected = SKpstmt.executeUpdate();
            return SKrowsAffected > 0;
        } catch (SQLException SKe) {
            throw new Exception("Error al actualizar el registro: " + SKe.getMessage(), SKe);
        }
    }

    public Integer getRowCount() throws Exception {
        String SKquery = "SELECT COUNT(*) AS TotalReg FROM SKGenoAlimento WHERE SKEstado = 'A'";
        
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
