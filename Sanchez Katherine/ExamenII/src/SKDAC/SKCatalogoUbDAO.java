package SKDAC;

import SKDAC.SKDTO.SKCatalogoUbDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class SKCatalogoUbDAO extends SKDataHelper implements SKIDAO<SKCatalogoUbDTO> {

    @Override
    public List<SKCatalogoUbDTO> readALL() throws Exception {
        List<SKCatalogoUbDTO> list = new ArrayList<>();
        String query = "SELECT idSKCatalogoUb   "
                        + ",SKNrCategoria       " 
                        + ",SKLugar             "
                        + ",SKEstado            "
                        + ",SKFechaModificacion "
                        + "FROM SKCatalogoUb    "
                        + "WHERE SKEstado = 'A' "; 
        
        try {Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet SKrs = pstmt.executeQuery(query); 
             
            while (SKrs.next()) {
                SKCatalogoUbDTO SKC = new SKCatalogoUbDTO(SKrs.getInt("idSKCatalogoUb")            // idSKCatalogoUb
                                                            ,SKrs.getInt("SKNrCategoria")           // SKNrCategoria
                                                            ,SKrs.getString("SKLugar")                 // SKLugar
                                                            ,SKrs.getString("SKEstado")                // SKEstado
                                                            ,SKrs.getString("SKFechaModificacion"));     // SKFechaModificacion
                    list.add(SKC);
                
            }
        } catch (SQLException e) {
            throw new Exception("Error al leer todos los registros: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public boolean create(SKCatalogoUbDTO entity) throws Exception {
        String query = "INSERT INTO SKCatalogoUb (SKNrCategoria, SKLugar, SKEstado, SKFechaModificacion) "
                     + "VALUES (?, ?, ?, ?)";
        
        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(query)) {
            SKpstmt.setInt(1, entity.getSKNrCategoria());
            SKpstmt.setString(2, entity.getSKLugar());
            SKpstmt.setString(3, entity.getSKEstado());
            SKpstmt.setString(4, entity.getSKFechaModificacion());
            SKpstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al crear el registro: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(SKCatalogoUbDTO entity) throws Exception {
        String query = "UPDATE SKCatalogoUb SET SKEstado = 'X' WHERE idSKCatalogoUb = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, entity.getIdSKCatalogoUb());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el registro: " + e.getMessage(), e);
        }
    }

    @Override
    public SKCatalogoUbDTO readBy(Integer id) throws Exception {
        SKCatalogoUbDTO item = null;
        String query = "SELECT idSKCatalogoUb, SKNrCategoria, SKLugar, SKEstado, SKFechaModificacion "
                     + "FROM SKCatalogoUb "
                     + "WHERE idSKCatalogoUb = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    item = new SKCatalogoUbDTO(
                            rs.getInt("idSKCatalogoUb"),            // idSKCatalogoUb
                            rs.getInt("SKNrCategoria"),              // SKNrCategoria
                            rs.getString("SKLugar"),                 // SKLugar
                            rs.getString("SKEstado"),                // SKEstado
                            rs.getString("SKFechaModificacion")     // SKFechaModificacion
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al leer el registro: " + e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean update(SKCatalogoUbDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String query = "UPDATE SKCatalogoUb SET "
            + "SKNrCategoria = ?, "
            + "SKLugar = ?, "
            + "SKEstado = ?, "
            + "SKFechaModificacion = ? "
            + "WHERE idSKCatalogoUb = ?";

        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, entity.getSKNrCategoria());
            pstmt.setString(2, entity.getSKLugar());
            pstmt.setString(3, entity.getSKEstado());
            pstmt.setString(4, dtf.format(now)); // Fecha de modificación
            pstmt.setInt(5, entity.getIdSKCatalogoUb()); // ID del registro a actualizar
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el registro: " + e.getMessage(), e);
        }
    }

    public Integer getRowCount() throws Exception {
        String query = "SELECT COUNT(*) AS TotalReg "
                     + "FROM SKCatalogoUb "
                     + "WHERE SKEstado = 'A'"; // Solo activos
        
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            if (rs.next()) {
                return rs.getInt("TotalReg");
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener el conteo de registros: " + e.getMessage(), e);
        }
        
        return 0;
    }
}

