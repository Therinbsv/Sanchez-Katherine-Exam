package SKDAC.SKDTO;

public class SKGenoAlimentoDTO {
    private  Integer idSKGenoAlimento;
    private  String SKGenoAlimento;
    private  String SKEstado;
    private  String SKFechaModificacion;

    public SKGenoAlimentoDTO(){}
    public SKGenoAlimentoDTO(int idSKGenoAlimento
                            ,String SKGenoAlimento
                            ,String SKEstado
                            ,String SKFechaModificacion
    )
    {
        this.idSKGenoAlimento    = idSKGenoAlimento;
        this.SKGenoAlimento      = SKGenoAlimento;
        this.SKEstado            = SKEstado;
        this.SKFechaModificacion = SKFechaModificacion;
    }

    public Integer getIdSKGenoAlimento() {
        return idSKGenoAlimento;
    }


    public void setIdSKGenoAlimento(Integer idSKGenoAlimento) {
        this.idSKGenoAlimento = idSKGenoAlimento;
    }


    public String getSKGenoAlimento() {
        return SKGenoAlimento;
    }


    public void setSKGenoAlimento(String sKGenoAlimento) {
        SKGenoAlimento = sKGenoAlimento;
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
            + "\n idSKGenoAlimento:     " + getIdSKGenoAlimento()
            + "\n SKGenoAlimento:       " + getSKGenoAlimento()
            + "\n SKEstado:             " + getSKEstado()
            + "\n SKFechaModificacion:  " + getSKFechaModificacion();
            
    }
}
