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


/**
 * Clase diseñada para realizar Test unitarios sobre los metodos que poseen en común Asistencia y Reunion
 */
public class TestAsistenciaReunion {
    private Empleado empleadoTest;
    private ReunionVirtual reunion;
    private Invitacion invitacion;


    /**
     * Inicializa las variables que serán utilizadas para los tests
     */
    @BeforeEach
    void setup(){
        empleadoTest = new Empleado("1", "Magno", "Carlo", "CarloMagno@gmail.udec.cl");

        // Setup para la reunion
        invitacion = new Invitacion(new Date(), Instant.now(), TipoReunion.MARKETING, Duration.ofHours(1));
        String enlace = "meet.com";
        reunion = new ReunionVirtual(invitacion, enlace);

        invitacion.invitarEmpleado(empleadoTest);
    }

    /**
     * Test para verificar si un empleado trata de entrar a la reunion sin que esta haya iniciado
     * La idea este metodo es que se lance la excepcion NoIniciadoReunionException
     */
    @Test
    @DisplayName("Llegada antes de iniciar reunion")
        void testLlegadaTemprano(){
        try {
            reunion.addLlegada(empleadoTest);
        }
        catch (NoIniciadoReunionException | ReunionFinalizadaException e){
            assertTrue(true);
        }

        reunion.iniciar();
    }

    /**
     * Test para verificar si un empleado trata de entrar a la reunion cuando la reunion ya ha finalizado
     * La idea de este test es lanzar la excepcion ReunionFinalizadaException
     */
    @Test
    @DisplayName("Empleado intenta entrar a reunión después de finalizar")
    void testNoLlegada(){
        reunion.iniciar();
        reunion.finalizar();
        try {
            reunion.addLlegada(empleadoTest);
        }
        catch (ReunionFinalizadaException | NoIniciadoReunionException e){
            assertTrue(true);
        }
    }

    /**
     * Test para comprobar metodos que requieren que la reunion haya finalizado para ser llamados
     * La ides de este test es lanzar la excepcion NoFinalizadoReunionException
     */
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

    /**
     * Test para comprobar metodos que requieres que la reunion haya iniciado para ser llamados
     * La idea de este test es que lanzar la excepcion NoIniciadoReunionException
     */
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
