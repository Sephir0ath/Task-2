package Clases;

/**
 * Subclase de Reunion, representa una reunion presencial
 */
public class ReunionPresencial extends Reunion{
    private String sala;

    /**
     * Método constructor de ReunionPresencial
     *
     * @param invitacion Instancia de la clase Invitacion que contiene información sobre la invitación a la reunión presencial
     * @param sala String con la sala donde se realizara la reunion presencial
     */
    public ReunionPresencial(Invitacion invitacion, String sala){
        super(invitacion);
        this.sala = sala;
    }

    /**
     * Metodo getter, obtiene el acceso donde se llevara a cabo la reunion presencial
     *
     * @return sala tipo String de ReunionPresencial
     */
    @Override
    public String getAcceso() {
        return sala;
    }

    /**
     * Metodo que incia la reunion presencial tomando en cuenta la hora actual del momento que se inicia
     */
    @Override
    public void iniciar() {
        setHoraInicio(Instant.now());
    }

    /**
     * Metodo que finaliza la reunion presencial tomando en cuenta la hora actual del momento que se finaliza
     */
    @Override
    public void finalizar() {
        setHoraFinal(Instant.now());
    }
}
