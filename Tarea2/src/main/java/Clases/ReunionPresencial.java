package Clases;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Invitacion invitacion, String sala){
        super(invitacion);
        this.sala = sala;
    }

    @Override
    public String getAcceso() {
        return sala;
    }

    @Override
    public void iniciar() {
        setHoraInicio(Instant.now());
    }

    @Override
    public void finalizar() {
        setHoraFinal(Instant.now());
    }
}
