package Clases;

import Excepciones.ParametrosInvalidosException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;

public class Invitacion{
    private Instant horaPrevista;
    private Date fecha;
    private TipoReunion tipo;
    private Duration duracionPrevista;
    ArrayList<Empleado> listaInvitados;

    public Invitacion(Date fecha, Instant horaPrevista, TipoReunion tipo, Duration duracionPrevista){
        this.fecha = fecha;
        this.tipo = tipo;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        listaInvitados = new ArrayList<>();
    }

    public void checkParameters() throws ParametrosInvalidosException {
        if (fecha == null || horaPrevista == null || tipo == null || duracionPrevista == null){
            throw new ParametrosInvalidosException();
        }
    }

    public void invitarDepartamento(Departamento departamentoInvitado){
        ArrayList<Empleado> invitarEmpleadosList = departamentoInvitado.getEmpleados();
        for (int i = 0; i < invitarEmpleadosList.size(); i++){
            if (!listaInvitados.contains(invitarEmpleadosList.get(i))) {
                listaInvitados.add(invitarEmpleadosList.get(i));
            }
        }
    }

    public void invitarEmpleado(Empleado empleadoInvitado) {
        if (!listaInvitados.contains(empleadoInvitado)) {
            listaInvitados.add(empleadoInvitado);
        }
    }

    public ArrayList<Empleado> getListaInvitados(){
        return listaInvitados;
    }

    public Date getFecha(){
        return fecha;
    }

    public TipoReunion getTipo(){
        return tipo;
    }

    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
}
