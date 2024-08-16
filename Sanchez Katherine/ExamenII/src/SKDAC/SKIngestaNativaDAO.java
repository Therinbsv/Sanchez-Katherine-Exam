package SKDAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import SKDAC.SKDTO.SKIngestaNativaDTO;

public class SKIngestaNativaDAO extends SKDataHelper implements SKIDAO<SKIngestaNativaDTO> {

    @Override
    public boolean create(SKIngestaNativaDTO entity) throws Exception {
        String SKquery = "INSERT INTO SKIngestaNativa (SKClasificacion, SKDescripcion, SKEstado, SKFechaModificacion) VALUES (?, ?, ?, ?)";
        try (Connection SKConn = openConnection();
        PreparedStatement SKpstmt = SKConn.prepareStatement(SKquery)){ 
            
            SKpstmt.setString(1, entity.getSKClasificacion());
            SKpstmt.setString(2, entity.getSKDescripcion());
            SKpstmt.setString(3, entity.getSKEstado());
            SKpstmt.setString(4, entity.getSKFechaModificacion());
            
            return SKpstmt.executeUpdate() > 0;
        }
    }

    @Override
    public SKIngestaNativaDTO readBy(Integer id) throws Exception {
        String SKquery = "SELECT * FROM SKIngestaNativa WHERE idSKIngestaNativa = ?";
        try (Connection SKconn = openConnection();
        PreparedStatement SKpstmt = SKconn.prepareStatement(SKquery)) {
            
            SKpstmt.setInt(1, id);
            try (ResultSet SKrs = SKpstmt.executeQuery()) {
                if (SKrs.next()) {
                    return new SKIngestaNativaDTO(
                        SKrs.getInt("idSKIngestaNativa"),
                        SKrs.getString("SKClasificacion"),
                        SKrs.getString("SKDescripcion"),
                        SKrs.getString("SKEstado"),
                        SKrs.getString("SKFechaModificacion")
                    );
                }
                return null;
            }
        }
    }

    @Override
    public List<SKIngestaNativaDTO> readALL() throws Exception {
        String SKquery = "SELECT * FROM SKIngestaNativa";
        List<SKIngestaNativaDTO> list = new ArrayList<>();
        try (Connection SKconn = openConnection();
        PreparedStatement SKStmt = SKconn.prepareStatement(SKquery);
        ResultSet SKrs = SKStmt.executeQuery()) {
            
            while (SKrs.next()) {
                list.add(new SKIngestaNativaDTO(
                    SKrs.getInt("idSKIngestaNativa"),
                    SKrs.getString("SKClasificacion"),
                    SKrs.getString("SKDescripcion"),
                    SKrs.getString("SKEstado"),
                    SKrs.getString("SKFechaModificacion")
                ));
            }
        }
        return list;
    }

    @Override
    public boolean update(SKIngestaNativaDTO entity) throws Exception {
        DateTimeFormatter SKdtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime SKnow = LocalDateTime.now();
        String SKquery = "UPDATE SKIngestaNativa SET SKClasificacion = ?, SKDescripcion = ?, SKEstado = ?, SKFechaModificacion = ? WHERE idSKIngestaNativa = ?";
        try (Connection SKConn = openConnection();
        PreparedStatement SKpstmt = SKConn.prepareStatement(SKquery)) {
            
            SKpstmt.setString(1, entity.getSKClasificacion());
            SKpstmt.setString(2, entity.getSKDescripcion());
            SKpstmt.setString(3, entity.getSKEstado());
            SKpstmt.setString(7, SKdtf.format(SKnow));
            SKpstmt.setInt(5, entity.getIdSKIngestaNativa());
            
            return SKpstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(SKIngestaNativaDTO entity) throws Exception {
        String SKquery = "DELETE FROM SKIngestaNativa WHERE idSKIngestaNativa = ?";
        try (Connection SKConn = openConnection();
        PreparedStatement SKpstmt = SKConn.prepareStatement(SKquery)) {
            
            SKpstmt.setInt(1, entity.getIdSKIngestaNativa());
            return SKpstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el registro: " + e.getMessage(), e);
        }
    }

    public Integer getRowCount() throws Exception {
        String SKquery = "SELECT COUNT(*) FROM SKIngestaNativa";
        try (Connection SKConn = openConnection(); 
             Statement SKstmt = SKConn.createStatement();
             ResultSet SKrs = SKstmt.executeQuery(SKquery)) { 
            
            if (SKrs.next()) {
                return SKrs.getInt(1);
            }
            return 0;
        }
    }

}
