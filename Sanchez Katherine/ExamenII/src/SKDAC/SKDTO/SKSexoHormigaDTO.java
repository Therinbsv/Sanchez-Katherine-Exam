package SKDAC.SKDTO;

public class SKSexoHormigaDTO {
    private Integer idSKSexoHormiga;
    private String SKSexo;
    private String SKEstado;
    private String SKFechaModificacion;

    public SKSexoHormigaDTO(){}
    public SKSexoHormigaDTO(int idSKSexoHormiga
                            ,String SKSexo
                            ,String SKEstado
                            ,String SKFechaModificacion

    )
    {
        this.idSKSexoHormiga     = idSKSexoHormiga;
        this.SKSexo              = SKSexo;
        this.SKEstado            = SKEstado;
        this.SKFechaModificacion = SKFechaModificacion;
    }
    public Integer getIdSKSexoHormiga() {
        return idSKSexoHormiga;
    }
    public void setIdSKSexoHormiga(Integer idSKSexoHormiga) {
        this.idSKSexoHormiga = idSKSexoHormiga;
    }
    public String getSKSexo() {
        return SKSexo;
    }
    public void setSKSexo(String sKSexo) {
        SKSexo = sKSexo;
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
            + "\n idSKSexoHormiga:      " + getIdSKSexoHormiga()
            + "\n SKSexo:               " + getSKSexo()
            + "\n SKEstado:             " + getSKEstado()
            + "\n SKFechaModificacion:  " + getSKFechaModificacion();
    }
}
