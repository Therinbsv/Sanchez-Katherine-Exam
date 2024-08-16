package SKBusines.SKBusinessLogic;

import SKDAC.SKSexoHormigaDAO;
import SKDAC.SKDTO.SKSexoHormigaDTO;
import java.util.List;

public class SKSexoHormigaBL {

    private SKSexoHormigaDAO SKsDAO = new SKSexoHormigaDAO();

    public SKSexoHormigaBL() {}

    // Obtener todos los registros
    public List<SKSexoHormigaDTO> getAll() throws Exception {
        List<SKSexoHormigaDTO> SKlst = SKsDAO.readALL();
        for (SKSexoHormigaDTO SKdto : SKlst) {
            SKdto.setSKSexo(SKdto.getSKSexo().toUpperCase()); // Ejemplo de transformación
        }
        return SKlst;
    }

    // Obtener un registro por ID
    public SKSexoHormigaDTO getBy(int idSKSexoHormiga) throws Exception {
        return SKsDAO.readBy(idSKSexoHormiga);
    }

    // Agregar un nuevo registro
    public boolean add(SKSexoHormigaDTO sexoHormigaDTO) throws Exception {
        return SKsDAO.create(sexoHormigaDTO);
    }

    // Actualizar un registro existente
    public boolean update(SKSexoHormigaDTO sexoHormigaDTO) throws Exception {
        return SKsDAO.update(sexoHormigaDTO);
    }

    // Eliminar un registro por ID
    public boolean delete(SKSexoHormigaDTO idSKSexoHormiga) throws Exception {
        return SKsDAO.delete(idSKSexoHormiga);
    }

    // Obtener el conteo de registros
    public Integer getRowCount() throws Exception {
        return SKsDAO.getRowCount();
    }
}

