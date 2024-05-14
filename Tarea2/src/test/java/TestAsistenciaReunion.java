import Clases.*;
import Excepciones.NoFinalizadoReunionException;
import Excepciones.NoIniciadoReunionException;
import Excepciones.ReunionFinalizadaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;




public class TestAsistenciaReunion {
    private Empleado delMes;
    private ReunionVirtual reunion;
    private Invitacion invitacion;


    @BeforeEach
    void setup(){
        delMes = new Empleado("1", "Magno", "Carlo", "CarloMagno@gmail.udec.cl");

        // Setup para la reunion
        invitacion = new Invitacion(new Date(), Instant.now(), TipoReunion.MARKETING, Duration.ofHours(1));
        String enlace = "meet.com";
        reunion = new ReunionVirtual(invitacion, enlace);

        invitacion.invitarEmpleado(delMes);
    }

    // Casos en donde la idea es lanzar excepciones
    @Test
    @DisplayName("Llegada antes de iniciar reunion")
        void testLlegadaTemprano() throws NoIniciadoReunionException, ReunionFinalizadaException {
        try {
            reunion.addLlegada(delMes);
        }
        catch (NoIniciadoReunionException e){
            assertTrue(true);
        }

        reunion.iniciar();
    }

    @Test
    @DisplayName("Empleado intenta entrar a reunión después de finalizar")
    void testNoLlegada() throws ReunionFinalizadaException, NoIniciadoReunionException {
        reunion.iniciar();
        reunion.finalizar();
        try {
            reunion.addLlegada(delMes);
        }
        catch (ReunionFinalizadaException e){
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Llamar metodos antes de que finalice la reunion")
    void testMetodosSinFinalizarReunion(){
        reunion.iniciar();

        try {
            reunion.getAusencias();
        }
        catch (NoIniciadoReunionException | NoFinalizadoReunionException e){
            assertTrue(true);
        }

    }

    @Test
    @DisplayName("Llamar metodos sin que inicie la reunion")
    void testMetodosSinIniciarReunion(){
        try {
            reunion.getAsistencias();
            reunion.getDuracionReunion();
            reunion.getAtrasos();
        }
        catch (NoIniciadoReunionException e){
            assertTrue(true);
        } catch (NoFinalizadoReunionException e) {
            throw new RuntimeException(e);
        }

    }
}
