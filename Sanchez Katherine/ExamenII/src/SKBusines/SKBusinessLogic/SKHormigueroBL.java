package SKBusines.SKBusinessLogic;

import SKDAC.SKDTO.SKHormigueroDTO;
import SKDAC.SKHormigueroDAO;
import java.util.List;

public class SKHormigueroBL {
    private SKHormigueroDTO SKHormiguero;
    private SKHormigueroDAO SKhDAO = new SKHormigueroDAO();

    public SKHormigueroBL() {}

    public List<SKHormigueroDTO> getAll() throws Exception {
        List<SKHormigueroDTO> SKlst = SKhDAO.readALL();
        for (SKHormigueroDTO SKhormigueroDTO : SKlst) {
            SKhormigueroDTO.setSKTipoHormiga(SKhormigueroDTO.getSKTipoHormiga().toUpperCase());
        }
        return SKlst;
    }

    public SKHormigueroDTO getBy(int idSKHormiguero) throws Exception {
        SKHormiguero = SKhDAO.readBy(idSKHormiguero);
        return SKHormiguero;
    }

    public boolean add(SKHormigueroDTO SKhormigueroDTO) throws Exception {
        return SKhDAO.create(SKhormigueroDTO);
    }

    public boolean update(SKHormigueroDTO SKhormigueroDTO) throws Exception {
        return SKhDAO.update(SKhormigueroDTO);
    }

    public boolean delete(SKHormigueroDTO idSKHormiguero) throws Exception {
        return SKhDAO.delete(idSKHormiguero);
    }

    public Integer getRowCount() throws Exception {
        return SKhDAO.getRowCount();
    }

    public String getUbicacion(int idSKCatalogoUb) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
