package Clases;

/**
 * Subclase de Reunion, representa una reunion virtual
 */
public class ReunionVirtual {
    private String enlace;

    /**
     * Método constructor de ReunionVirtual
     *
     * @param invitacion Instancia de la clase Invitacion que contiene información sobre la invitación a la reunión virtual
     * @param enlace String con el enlace o link donde se realizara la reunion virtual
     */
    public ReunionVirtual(Invitacion invitacion, String enlace){
        super(invitacion);
        this.enlace = enlace;
    }

    /**
     * Metodo getter, obtiene el acceso donde se llevara a cabo la reunion virtual
     *
     * @return enlace tipo String de la ReunionVirtual
     */
    public String getEnlace(){
        return enlace;
    }

    /**
     * Metodo que incia la reunion virtual tomando en cuenta la hora actual del momento que se inicia
     */
    @Override
    public void iniciar() {
        setHoraInicio(Instant.now());
    }
    /**
     * Metodo que finaliza la reunion virtual tomando en cuenta la hora actual del momento que se finaliza
     */
    @Override
    public void finalizar() {
        setHoraFinal(Instant.now());
    }
}
