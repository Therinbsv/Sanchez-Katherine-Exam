package SKDAC.SKDTO;

public class SKCatalogoUbDTO {
    private Integer idSKCatalogoUb;
    private int     SKNrCategoria;
    private String  SKLugar;
    private String  SKEstado;
    private String  SKFechaModificacion;

    public SKCatalogoUbDTO(){}    
    public SKCatalogoUbDTO(int idSKCatalogoUb
                          ,int SKNrCategoria
                          ,String SKLugar
                          ,String SKEstado
                          ,String SKFechaModificacion
    )
    {
        this.idSKCatalogoUb = idSKCatalogoUb;
        this.SKNrCategoria = SKNrCategoria;
        this.SKLugar = SKLugar;
        this.SKEstado = SKEstado;
        this.SKFechaModificacion = SKFechaModificacion;
        
    }    

    public Integer getIdSKCatalogoUb() {
        return idSKCatalogoUb;
    }
    public void setIdSKCatalogoUb(Integer idSKCatalogoUb) {
        this.idSKCatalogoUb = idSKCatalogoUb;
    }
    public int getSKNrCategoria() {
        return SKNrCategoria;
    }
    public void setSKNrCategoria(int sKNrCategoria) {
        SKNrCategoria = sKNrCategoria;
    }
    public String getSKLugar() {
        return SKLugar;
    }
    public void setSKLugar(String sKLugar) {
        SKLugar = sKLugar;
    }
    public String getSKEstado() {
        return SKEstado;
    }
    public void setSKEstado(String sKEstado) {
        SKEstado = sKEstado;
    }
    public String getSKFechaModificacion() {
        return SKFechaModificacion;
    }
    public void setSKFechaModificacion(String sKFechaModificacion) {
        SKFechaModificacion = sKFechaModificacion;
    }
    @Override
    public String toString() {
        return getClass().getName()
            + "\n idSKCatalogoUb:       " + getIdSKCatalogoUb() 
            + "\n SKNrCategoria:        " + getSKNrCategoria() 
            + "\n SKLugar:              " + getSKLugar() 
            + "\n SKEstado:             " + getSKEstado() 
            + "\n SKFechaModificacion:  " + getSKFechaModificacion();
    }


}
