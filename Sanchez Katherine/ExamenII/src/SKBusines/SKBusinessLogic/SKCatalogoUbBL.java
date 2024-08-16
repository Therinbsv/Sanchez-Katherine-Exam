package SKBusines.SKBusinessLogic;

import java.util.List;
import SKDAC.SKCatalogoUbDAO;
import SKDAC.SKDTO.SKCatalogoUbDTO;

public class SKCatalogoUbBL {
    private SKCatalogoUbDTO SKCatalogoUb;
    private SKCatalogoUbDAO SKCatalogoUbDAO = new SKCatalogoUbDAO();

    public SKCatalogoUbBL(){}

    public List<SKCatalogoUbDTO> getAll() throws Exception {
        List<SKCatalogoUbDTO> lst = SKCatalogoUbDAO.readALL();
        for (SKCatalogoUbDTO dto : lst) {
            dto.setSKLugar(dto.getSKLugar().toUpperCase());
        }
        return lst;
    }

    public SKCatalogoUbDTO getBy(int idSKCatalogoUb) throws Exception {
        SKCatalogoUb = SKCatalogoUbDAO.readBy(idSKCatalogoUb);
        return SKCatalogoUb;
    }

    public boolean add(SKCatalogoUbDTO SKCatalogoUbDTO) throws Exception {
        return SKCatalogoUbDAO.create(SKCatalogoUbDTO);
    }

    public boolean update(SKCatalogoUbDTO SKCatalogoUbDTO) throws Exception {
        return SKCatalogoUbDAO.update(SKCatalogoUbDTO);
    }

    public boolean delete(SKCatalogoUbDTO idSKCatalogoUb) throws Exception {
        return SKCatalogoUbDAO.delete(idSKCatalogoUb);
    }

    public Integer getRowCount() throws Exception {
        return SKCatalogoUbDAO.getRowCount();
    }
}

