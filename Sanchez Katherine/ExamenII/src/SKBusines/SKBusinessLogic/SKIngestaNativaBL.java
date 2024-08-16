package SKBusines.SKBusinessLogic;

import java.util.List;

import SKDAC.SKIngestaNativaDAO;
import SKDAC.SKDTO.SKIngestaNativaDTO;

public class SKIngestaNativaBL {
    private SKIngestaNativaDTO SKIngestaNativa;
    private SKIngestaNativaDAO SKIngestaNativaDAO = new SKIngestaNativaDAO();

    public SKIngestaNativaBL() {}

    public List<SKIngestaNativaDTO> getAll() throws Exception {
        List<SKIngestaNativaDTO> lst = SKIngestaNativaDAO.readALL();
        for (SKIngestaNativaDTO dto : lst) {
            dto.setSKClasificacion(dto.getSKClasificacion().toUpperCase());
        }
        return lst;
    }

    public SKIngestaNativaDTO getBy(int idSKIngestaNativa) throws Exception {
        SKIngestaNativa = SKIngestaNativaDAO.readBy(idSKIngestaNativa);
        return SKIngestaNativa;
    }

    public boolean add(SKIngestaNativaDTO SKIngestaNativaDTO) throws Exception {
        return SKIngestaNativaDAO.create(SKIngestaNativaDTO);
    }

    public boolean update(SKIngestaNativaDTO SKIngestaNativaDTO) throws Exception {
        return SKIngestaNativaDAO.update(SKIngestaNativaDTO);
    }

    public boolean delete(SKIngestaNativaDTO idSKIngestaNativa) throws Exception {
        return SKIngestaNativaDAO.delete(idSKIngestaNativa);
    }

    public Integer getRowCount() throws Exception {
        return SKIngestaNativaDAO.getRowCount();
    }
}

