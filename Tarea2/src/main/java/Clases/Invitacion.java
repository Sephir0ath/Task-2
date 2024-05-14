package Clases;

import Excepciones.ParametrosInvalidosException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;

/**
 * Invitacion representa una invitacion a una reunión específica con fecha, hora, duración y tipo.
 */
public class Invitacion{
    private Instant horaPrevista;
    private Date fecha;
    private TipoReunion tipo;
    private Duration duracionPrevista;
    ArrayList<Empleado> listaInvitados;

    /**
     * Constructor de Invitación.
     * Asigna valores a las variables privadas.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista de la reunión.
     * @param tipo Tipo de la reunión, debe ser de los declarados en el enum.
     * @param duracionPrevista Duración prevista de la reunión.
     */
    public Invitacion(Date fecha, Instant horaPrevista, TipoReunion tipo, Duration duracionPrevista){
        this.fecha = fecha;
        this.tipo = tipo;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        listaInvitados = new ArrayList<>();
    }

    /**
     * Método que se encarga de la verificación de validez en los parámetros de la invitación,
     * @throws ParametrosInvalidosException Si alguno de los parámetros no es válido, es nulo.
     */
    public void checkParameters() throws ParametrosInvalidosException {
        if (fecha == null || horaPrevista == null || tipo == null || duracionPrevista == null){
            throw new ParametrosInvalidosException();
        }
    }

    /**
     * Método que permite invitar un departamento a la reunión.
     * @param departamentoInvitado Departamento a invitar.
     */
    public void invitarDepartamento(Departamento departamentoInvitado){
        ArrayList<Empleado> invitarEmpleadosList = departamentoInvitado.getEmpleados();
        for (int i = 0; i < invitarEmpleadosList.size(); i++){
            if (!listaInvitados.contains(invitarEmpleadosList.get(i))) {
                listaInvitados.add(invitarEmpleadosList.get(i));
            }
        }
    }

    /**
     * Método que permite invitar un empleado a la reunión.
     * @param empleadoInvitado Empleado a invitar.
     */
    public void invitarEmpleado(Empleado empleadoInvitado) {
        if (!listaInvitados.contains(empleadoInvitado)) {
            listaInvitados.add(empleadoInvitado);
        }
    }

    /**
     * Método getter que obtiene la lista de los empleados invitados.
     * @return listaInvitados ArrayList de Empleados invitados.
     */
    public ArrayList<Empleado> getListaInvitados(){
        return listaInvitados;
    }

    /**
     * Método getter que obtiene la fecha de la reunión.
     * @return fecha Date de la reunión.
     */
    public Date getFecha(){
        return fecha;
    }

    /**
     * Método getter que obtiene el tipo de reunión.
     * @return tipo TipoReunion perteneciente al enum.
     */
    public TipoReunion getTipo(){
        return tipo;
    }

    /**
     * Método getter que obtiene la hora prevista de la reunión.
     * @return horaPrevista Instant donde se prevee que se realizará la reunión.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * Método getter que obtiene la duración prevista de la reunión.
     * @return duracionPrevista Duration que se prevee que durará la reunión.
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
}