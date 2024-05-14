import Clases.*;
import Excepciones.NoFinalizadoReunionException;
import Excepciones.NoIniciadoReunionException;
import Excepciones.ParametrosInvalidosException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestReunion {
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

    @Test
    @DisplayName("Iniciar una reunion")
    void testIniciarReunion(){
        reunion.iniciar();
    }

    @Test
    @DisplayName("Obtener Hora inicio y hora Final de reunion")
    void testGetHoras() throws NoIniciadoReunionException, NoFinalizadoReunionException {
        reunion.iniciar();
        reunion.finalizar();
        reunion.getHoraInicio();
        reunion.getHoraFinal();
    }

    @Test
    @DisplayName("Crear notas antes de iniciar reunion")
    void testCrearNotaErronea() throws NoIniciadoReunionException {
        try{
            reunion.createNota("Contenido de la nota");
        }
        catch (NoIniciadoReunionException e){
            assertTrue(true);
        }

        reunion.iniciar();
    }

    @Test
    @DisplayName("Crear notas")
    void testCrearNota() throws NoIniciadoReunionException {
        reunion.iniciar();
        reunion.createNota("Contenido de la nota");
    }

    @Test
    @DisplayName("Test del metodo getPorcentajeAsistencia")
    void testPorcentajeAsistencia() throws NoIniciadoReunionException, NoFinalizadoReunionException {
        reunion.iniciar();
        reunion.getPorcentajeAsistencia();
    }

    @Test
    @DisplayName("Test Parametros Invalidos en reunion")
    void testParametrosInvalidos() throws ParametrosInvalidosException {
        reunion.checkParameters();
    }
}
