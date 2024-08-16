package SKDAC.SKDTO;

public class SKHormigueroDTO {
    private int idSKHormiguero;
    private String SKTipoHormiga;
    private int idSKSexoHormiga;
    private int idSKIngestaNativa;
    private int idSKGenoAlimento;
    private int idSKCatalogoUb;
    private String SKEstado;
    private String SKFechaModificacion;

    public SKHormigueroDTO(){}
    public SKHormigueroDTO( int    idSKHormiguero
                          ,String  SKTipoHormiga
                          ,int     idSKSexoHormiga
                          ,int     idSKIngestaNativa
                          ,int     idSKGenoAlimento
                          ,int     idSKCatalogoUb
                          ,String  SKEstado
                          ,String  SKFechaModificacion
                          )
    {
        this.idSKHormiguero      = idSKHormiguero;
        this.SKTipoHormiga       = SKTipoHormiga;
        this.idSKSexoHormiga     = idSKSexoHormiga;
        this.idSKIngestaNativa   = idSKIngestaNativa;
        this.idSKGenoAlimento    = idSKGenoAlimento;
        this.idSKCatalogoUb      = idSKCatalogoUb;
        this.SKEstado            = SKEstado;
        this.SKFechaModificacion = SKFechaModificacion;
    }

    public int getSKId() {
        return idSKHormiguero;
    }

    
    public String getSKTipoHormiga() {
        return SKTipoHormiga;
    }

    public void setSKTipoHormiga(String SKTipoHormiga) {
        this.SKTipoHormiga = SKTipoHormiga;
    }

    public int getIdSKSexoHormiga() {
        return idSKSexoHormiga;
    }

    public void setIdSKSexoHormiga(int idSKSexoHormiga) {
        this.idSKSexoHormiga = idSKSexoHormiga;
    }

    public int getIdSKIngestaNativa() {
        return idSKIngestaNativa;
    }

    public void setIdSKIngestaNativa(int idSKIngestaNativa) {
        this.idSKIngestaNativa = idSKIngestaNativa;
    }

    public int getIdSKGenoAlimento() {
        return idSKGenoAlimento;
    }

    public void setIdSKGenoAlimento(int idSKGenoAlimento) {
        this.idSKGenoAlimento = idSKGenoAlimento;
    }

    public int getIdSKCatalogoUb() {
        return idSKCatalogoUb;
    }

    public void setIdSKCatalogoUb(int idSKCatalogoUb) {
        this.idSKCatalogoUb = idSKCatalogoUb;
    }

    public String getSKEstado() {
        return SKEstado;
    }

    public void setSKEstado(String SKEstado) {
        this.SKEstado = SKEstado;
    }
    public int getIdSKHormiguero() {
        return idSKHormiguero;
    }
    public void setIdSKHormiguero(int idSKHormiguero) {
        this.idSKHormiguero = idSKHormiguero;
    }
    public String getSKFechaModificacion() {
        return SKFechaModificacion;
    }
    public void setSKFechaModificacion(String sKFechaModificacion) {
        SKFechaModificacion = sKFechaModificacion;
    }
}
