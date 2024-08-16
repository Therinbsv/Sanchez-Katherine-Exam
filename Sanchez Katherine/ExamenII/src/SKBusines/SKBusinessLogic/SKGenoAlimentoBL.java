package SKBusines.SKBusinessLogic;

import SKDAC.SKGenoAlimentoDAO;
import SKDAC.SKDTO.SKGenoAlimentoDTO;
import java.util.List;

public class SKGenoAlimentoBL {
    private SKGenoAlimentoDTO SKGenoAlimento;
    private SKGenoAlimentoDAO SKGenoAlimentoDAO = new SKGenoAlimentoDAO();

    public SKGenoAlimentoBL(){}

    public List<SKGenoAlimentoDTO> getAll() throws Exception {
        List<SKGenoAlimentoDTO> lst = SKGenoAlimentoDAO.readALL();
        for (SKGenoAlimentoDTO dto : lst) {
            dto.setSKGenoAlimento(dto.getSKGenoAlimento().toUpperCase());
        }
        return lst;
    }

    public SKGenoAlimentoDTO getBy(int idSKGenoAlimento) throws Exception {
        SKGenoAlimento = SKGenoAlimentoDAO.readBy(idSKGenoAlimento);
        return SKGenoAlimento;
    }

    public boolean add(SKGenoAlimentoDTO SKGenoAlimentoDTO) throws Exception {
        return SKGenoAlimentoDAO.create(SKGenoAlimentoDTO);
    }

    public boolean update(SKGenoAlimentoDTO SKGenoAlimentoDTO) throws Exception {
        return SKGenoAlimentoDAO.update(SKGenoAlimentoDTO);
    }

    public boolean delete(SKGenoAlimentoDTO idSKGenoAlimento) throws Exception {
        return SKGenoAlimentoDAO.delete(idSKGenoAlimento);
    }

    public Integer getRowCount() throws Exception {
        return SKGenoAlimentoDAO.getRowCount();
    }
}

