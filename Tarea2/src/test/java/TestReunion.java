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

/**
 * Clase diseñada para realizar Test unitarios la clase Reunion
 */
public class TestReunion {
    private Empleado delMes;
    private ReunionVirtual reunion;
    private Invitacion invitacion;

    /**
     * Inicializa las variables que serán utilizadas para los tests
     */
    @BeforeEach
    void setup(){
        delMes = new Empleado("1", "Magno", "Carlo", "CarloMagno@gmail.udec.cl");

        // Setup para la reunion
        invitacion = new Invitacion(new Date(), Instant.now(), TipoReunion.MARKETING, Duration.ofHours(1));
        String enlace = "meet.com";
        reunion = new ReunionVirtual(invitacion, enlace);

        invitacion.invitarEmpleado(delMes);

    }

    /**
     * Test para iniciar una reunion
     */
    @Test
    @DisplayName("Iniciar una reunion")
    void testIniciarReunion(){
        reunion.iniciar();
    }

    /**
     * Test para obtener las horas de inicio y fin de una reunion
     *
     * @throws NoIniciadoReunionException Se lanza si no se inicia la reunion (Si no se llama la funcion reunion.iniciar())
     * @throws NoFinalizadoReunionException Se lanza si no se finaliza la reunion (Si no se llama la funcion reunion.finalizar())
     */
    @Test
    @DisplayName("Obtener Hora inicio y hora Final de reunion")
    void testGetHoras() throws NoIniciadoReunionException, NoFinalizadoReunionException {
        reunion.iniciar();
        reunion.finalizar();
        reunion.getHoraInicio();
        reunion.getHoraFinal();
    }

    /**
     * Test para tratar de crear una Nota antes de iniciar una reunion
     * La idea de este test es lanzar la excepcion NoIniciadoReunionException
     */
    @Test
    @DisplayName("Crear notas antes de iniciar reunion")
    void testCrearNotaErronea(){
        try{
            reunion.createNota("Contenido de la nota");
        }
        catch (NoIniciadoReunionException e){
            assertTrue(true);
        }

        reunion.iniciar();
    }

    /**
     * Test para crear correctamente una Nota
     *
     * @throws NoIniciadoReunionException Se lanza si no se inicia la reunion (Si no se llama la funcion reunion.iniciar())
     */
    @Test
    @DisplayName("Crear notas")
    void testCrearNota() throws NoIniciadoReunionException {
        reunion.iniciar();
        reunion.createNota("Contenido de la nota");
    }

    /**
     * Test para obtener el porcentaje de asistencia actual de una reunion que ya ha iniciado
     *
     * @throws NoIniciadoReunionException Se lanza si no se inicia la reunion (Si no se llama la funcion reunion.iniciar())
     * @throws NoFinalizadoReunionException Se lanza si no se finaliza la reunion (Si no se llama la funcion reunion.finalizar())
     */
    @Test
    @DisplayName("Test del metodo getPorcentajeAsistencia")
    void testPorcentajeAsistencia() throws NoIniciadoReunionException, NoFinalizadoReunionException {
        reunion.iniciar();
        reunion.getPorcentajeAsistencia();
    }

    /**
     * Test que comprueba que los parametros del constructor de reunion no sean nulos
     *
     * @throws ParametrosInvalidosException se lanzza si algun parametro del constructor es nulo
     */
    @Test
    @DisplayName("Test Parametros Invalidos en reunion")
    void testParametrosInvalidos() throws ParametrosInvalidosException {
        reunion.checkParameters();
    }
}
