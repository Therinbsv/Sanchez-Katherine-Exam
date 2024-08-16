package SKDAC;

import SKDAC.SKDTO.SKHormigueroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SKHormigueroDAO extends SKDataHelper implements SKIDAO<SKHormigueroDTO> {

    @Override
    public List<SKHormigueroDTO> readALL() throws Exception {
        List<SKHormigueroDTO> SKlst = new ArrayList<>();
        String SKquery = "SELECT h.idSKHormiguero, h.SKTipoHormiga, "
                       + "h.idSKSexoHormiga AS idSKSexoHormiga, "
                       + "h.idSKIngestaNativa AS idSKIngestaNativa, "
                       + "h.idSKGenoAlimento AS idSKGenoAlimento, "
                       + "h.idSKCatalogoUb AS idSKCatalogoUb, "
                       + "h.SKEstado, h.SKFechaModificacion "
                       + "FROM SKHormiguero h "
                       + "JOIN SKSexoHormiga s ON h.idSKSexoHormiga = s.idSKSexoHormiga "
                       + "JOIN SKIngestaNativa i ON h.idSKIngestaNativa = i.idSKIngestaNativa "
                       + "JOIN SKGenoAlimento g ON h.idSKGenoAlimento = g.idSKGenoAlimento "
                       + "JOIN SKCatalogoUb c ON h.idSKCatalogoUb = c.idSKCatalogoUb "
                       + "WHERE h.SKEstado = 'V'";
    
        try (Connection SKconn = openConnection();
             PreparedStatement SKStmt = SKconn.prepareStatement(SKquery);
             ResultSet SKrs = SKStmt.executeQuery()) {
            
            while (SKrs.next()) {
                SKHormigueroDTO SKhormiga = new SKHormigueroDTO(
                        SKrs.getInt("idSKHormiguero"),              // idSKHormiguero
                        SKrs.getString("SKTipoHormiga"),             // SKTipoHormiga
                        SKrs.getInt("idSKSexoHormiga"),              // idSKSexoHormiga
                        SKrs.getInt("idSKIngestaNativa"),            // idSKIngestaNativa
                        SKrs.getInt("idSKGenoAlimento"),             // idSKGenoAlimento
                        SKrs.getInt("idSKCatalogoUb"),               // idSKCatalogoUb
                        SKrs.getString("SKEstado"),                  // SKEstado
                        SKrs.getString("SKFechaModificacion")        // SKFechaModificacion
                );
                SKlst.add(SKhormiga);
            }
        } catch (SQLException e) {
            throw new Exception("Error al leer todos los registros: " + e.getMessage(), e);
        }
        return SKlst;
    }




    @Override
    public boolean create(SKHormigueroDTO entity) throws Exception {
        String SKquery = "INSERT INTO SKHormiguero (SKTipoHormiga, idSKSexoHormiga, idSKIngestaNativa, idSKGenoAlimento, idSKCatalogoUb, SKEstado, SKFechaModificacion) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection SKConn = openConnection();
             PreparedStatement SKpstmt = SKConn.prepareStatement(SKquery)) {

            SKpstmt.setString(1, entity.getSKTipoHormiga());
            SKpstmt.setInt(2, entity.getIdSKSexoHormiga());
            SKpstmt.setInt(3, entity.getIdSKIngestaNativa());
            SKpstmt.setInt(4, entity.getIdSKGenoAlimento());
            SKpstmt.setInt(5, entity.getIdSKCatalogoUb());
            SKpstmt.setString(6, entity.getSKEstado());
            SKpstmt.setString(7, entity.getSKFechaModificacion());
            SKpstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al crear el registro: " + e.getMessage(), e);
        }
    }


    @Override
    public boolean delete(SKHormigueroDTO entity) throws Exception {
        String SKquery = "UPDATE SKHormiga SET SKEstado = 'X' WHERE idSKHormiga = ?";
        
        try (Connection SKConn = openConnection();
             PreparedStatement SKpstmt = SKConn.prepareStatement(SKquery)) {
             
            SKpstmt.setInt(1, entity.getIdSKHormiguero());
            int rowsAffected = SKpstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el registro: " + e.getMessage(), e);
        }
    }

    @Override
    public SKHormigueroDTO readBy(Integer id) throws Exception {
        SKHormigueroDTO SKhormiga = null;
        String SKquery = "SELECT h.idSKHormiguero, h.SKTipoHormiga, "
                       + "h.idSKSexoHormiga AS idSKSexoHormiga, "
                       + "h.idSKIngestaNativa AS idSKIngestaNativa, "
                       + "h.idSKGenoAlimento AS idSKGenoAlimento, "
                       + "h.idSKCatalogoUb AS idSKCatalogoUb, "
                       + "h.SKEstado, h.SKFechaModificacion "
                       + "FROM SKHormiguero h "
                       + "JOIN SKSexoHormiga s ON h.idSKSexoHormiga = s.idSKSexoHormiga "
                       + "JOIN SKIngestaNativa i ON h.idSKIngestaNativa = i.idSKIngestaNativa "
                       + "JOIN SKGenoAlimento g ON h.idSKGenoAlimento = g.idSKGenoAlimento "
                       + "JOIN SKCatalogoUb c ON h.idSKCatalogoUb = c.idSKCatalogoUb "
                       + "WHERE h.idSKHormiguero = ?";

        try (Connection SKconn = openConnection();
             PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {

            SKpstmt.setInt(1, id);
            try (ResultSet SKrs = SKpstmt.executeQuery()) {
                if (SKrs.next()) {
                    SKhormiga = new SKHormigueroDTO(
                            SKrs.getInt("idSKHormiguero"),              // idSKHormiguero
                            SKrs.getString("SKTipoHormiga"),             // SKTipoHormiga
                            SKrs.getInt("idSKSexoHormiga"),              // idSKSexoHormiga
                            SKrs.getInt("idSKIngestaNativa"),            // idSKIngestaNativa
                            SKrs.getInt("idSKGenoAlimento"),             // idSKGenoAlimento
                            SKrs.getInt("idSKCatalogoUb"),               // idSKCatalogoUb
                            SKrs.getString("SKEstado"),                  // SKEstado
                            SKrs.getString("SKFechaModificacion")        // SKFechaModificacion
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al leer el registro: " + e.getMessage(), e);
        }
        return SKhormiga;
    }

    

    @Override
public boolean update(SKHormigueroDTO entity) throws Exception {
    DateTimeFormatter SKdtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime SKnow = LocalDateTime.now();
    String query = "UPDATE SKHormiguero SET "
            + "SKTipoHormiga = ?, "
            + "idSKSexoHormiga = ?, "
            + "idSKIngestaNativa = ?, "
            + "idSKGenoAlimento = ?, "
            + "idSKCatalogoUb = ?, "
            + "SKEstado = ?, "
            + "SKFechaModificacion = ? "
            + "WHERE idSKHormiguero = ?";

    try (Connection SKConn = openConnection();
         PreparedStatement SKpstmt = SKConn.prepareStatement(query)) {

        SKpstmt.setString(1, entity.getSKTipoHormiga());
        SKpstmt.setInt(2, entity.getIdSKSexoHormiga());
        SKpstmt.setInt(3, entity.getIdSKIngestaNativa());
        SKpstmt.setInt(4, entity.getIdSKGenoAlimento());
        SKpstmt.setInt(5, entity.getIdSKCatalogoUb());
        SKpstmt.setString(6, entity.getSKEstado());
        SKpstmt.setString(7, SKdtf.format(SKnow)); // Fecha de modificación
        SKpstmt.setInt(8, entity.getIdSKHormiguero()); // ID del registro a actualizar

        int rowsAffected = SKpstmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        throw new Exception("Error al actualizar el registro: " + e.getMessage(), e);
    }
}


    public Integer getRowCount() throws Exception {
        String query = "SELECT COUNT(*) AS TotalReg "
                     + "FROM SKHormiguero "
                     + "WHERE SKEstado = 'V'"; // Cambia el criterio si es necesario
    
        try (Connection SKConn = openConnection();
             Statement SKstmt = SKConn.createStatement();
             ResultSet SKrs = SKstmt.executeQuery(query)) {
    
            if (SKrs.next()) {
                return SKrs.getInt("TotalReg");
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener el conteo de registros: " + e.getMessage(), e);
        }
    
        return 0;
    }
    
    
}