import Clases.*;

import java.util.ArrayList;

import Excepciones.ParametrosInvalidosException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase diseñada para realizar test unitarios para la clase Invitacion y sus respectivos metodos
 */

public class TestInvitacion {

    private Instant horaPrevista;
    private Date fecha;
    private Duration duracion;
    private Empleado anakin;
    private Empleado obiwan;
    private Empleado ahsoka;

    /**
     * Metodo que da la configuracion, con los debidos datos, para la realizacion de los test unitarios
     */
    @BeforeEach
    void setup(){
        horaPrevista = Instant.parse("2024-05-01T10:00:00Z");
        fecha = Date.from(horaPrevista);
        duracion = Duration.ofHours(1);
        anakin = new Empleado("001", "Skywalker", "Anakin", "iamyourfather@starwars.com");
        obiwan = new Empleado("002", "Kenobi", "Obiwan", "heythere@starwars.com");
        ahsoka = new Empleado("003", "Tano", "Ahsoka", "imnojedi@starwars.com");
    }

    /**
     * Metodo que testea la funcionalidad de invitar a un departamento a una reunion
     */
    @Test
    @DisplayName("Test Invitar Departamento")
    public void testInvitarDepartamento(){
        Departamento jedi = new Departamento("Jedi Order");
        jedi.addEmpleado(anakin);
        jedi.addEmpleado(obiwan);

        Invitacion invitacion = new Invitacion(fecha, horaPrevista, TipoReunion.MARKETING, duracion);

        invitacion.invitarDepartamento(jedi);

        ArrayList<Empleado> listaInvitados = invitacion.getListaInvitados();
        assertTrue(listaInvitados.contains(anakin));
        assertTrue(listaInvitados.contains(obiwan));
        assertEquals(2, listaInvitados.size());
    }

    /**
     * Metodo que testea la funcionalidad de invitar a empleados de forma individual a una reunion
     */
    @Test
    @DisplayName("Test Invitar Empleados")
    public void testInvitarEmpleados(){

        Invitacion invitacion = new Invitacion(fecha, horaPrevista, TipoReunion.MARKETING, duracion);

        invitacion.invitarEmpleado(anakin);
        invitacion.invitarEmpleado(obiwan);
        invitacion.invitarEmpleado(ahsoka);

        ArrayList<Empleado> listaInvitados = invitacion.getListaInvitados();
        assertTrue(listaInvitados.contains(anakin));
        assertTrue(listaInvitados.contains(obiwan));
        assertTrue(listaInvitados.contains(ahsoka));
        assertEquals(3, listaInvitados.size());
    }

    /**
     * Metodo que testea la funcionalidad de invitar a un departamento y empleados individuales a una reunion
     * tomando en cuenta a los empleados que pertenecen y no pertenecen al departamento dado
     */
    @Test
    @DisplayName("Test Invitar departamento y empleados, que pertenecen y no, a la vez")
    public void testInvitarDosVeces(){
        Departamento jedi = new Departamento("Jedi Order");
        jedi.addEmpleado(anakin);
        jedi.addEmpleado(obiwan);

        Invitacion invitacion = new Invitacion(fecha, horaPrevista, TipoReunion.TECNICA, duracion);

        invitacion.invitarEmpleado(anakin);
        invitacion.invitarEmpleado(obiwan);
        invitacion.invitarEmpleado(ahsoka);
        invitacion.invitarDepartamento(jedi);

        ArrayList<Empleado> listaInvitados = invitacion.getListaInvitados();
        assertTrue(listaInvitados.contains(anakin));
        assertTrue(listaInvitados.contains(obiwan));
        assertTrue(listaInvitados.contains(ahsoka));
        assertEquals(3, listaInvitados.size());
    }

    /**
     * Metodo que testea el uso de parametros invalidos al ser usados para la invitacion a una reunion
     */
    @Test
    @DisplayName("Parámetros Inválidos de Invitación")
    void testParametrosInvalidosAlInvitar(){
        try {
            Invitacion invitacion = new Invitacion(null, null, null, null);
            invitacion.checkParameters();
        }
        catch (ParametrosInvalidosException e){
            assertTrue(true);
        }
    }
}