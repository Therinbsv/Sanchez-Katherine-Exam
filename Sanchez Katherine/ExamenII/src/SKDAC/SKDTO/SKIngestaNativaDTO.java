package SKDAC.SKDTO;

public class SKIngestaNativaDTO {
    private Integer idSKIngestaNativa;
    private String SKClasificacion;
    private String SKDescripcion;
    private String SKEstado;
    private String SKFechaModificacion;

    public SKIngestaNativaDTO(){}
    public SKIngestaNativaDTO( int idSKIngestaNativa
                              ,String SKClasificacion
                              ,String SKDescripcion
                              ,String SKEstado
                              ,String SKFechaModificacion

    )
    {
        this.idSKIngestaNativa   =  idSKIngestaNativa;
        this.SKClasificacion     = SKClasificacion;
        this.SKDescripcion       = SKDescripcion;
        this.SKEstado            = SKEstado;
        this.SKFechaModificacion = SKFechaModificacion;
    }

    public Integer getIdSKIngestaNativa() {
        return idSKIngestaNativa;
    }
    public void setIdSKIngestaNativa(Integer idSKIngestaNativa) {
        this.idSKIngestaNativa = idSKIngestaNativa;
    }
    public String getSKClasificacion() {
        return SKClasificacion;
    }
    public void setSKClasificacion(String sKClasificacion) {
        SKClasificacion = sKClasificacion;
    }
    public String getSKDescripcion() {
        return SKDescripcion;
    }
    public void setSKDescripcion(String sKDescripcion) {
        SKDescripcion = sKDescripcion;
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
            + "\n idSKIngestaNativa:    " +  getIdSKIngestaNativa()
            + "\n SKClasificacion:      " + getSKClasificacion()
            + "\n SKDescripcion:        " + getSKDescripcion()
            + "\n SKEstado:             " + getSKEstado()
            + "\n SKFechaModificacion:  " + getSKFechaModificacion();
    }
}
