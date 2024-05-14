package Clases;

import Excepciones.NoFinalizadoReunionException;
import Excepciones.NoIniciadoReunionException;
import Excepciones.ReunionFinalizadaException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Asistencia se encarga de gestionar la asistencia de los empleados, si están a tiempo, atrasados o no llegan a la reunión.
 */
public class Asistencia{
    private final ArrayList<Empleado> listaAsistencia;
    private final ArrayList<Empleado> listaAusencia;
    private final ArrayList<Instant> listaHoraLlegada;
    private final ArrayList<Empleado> listaAtraso;

    /**
     * Constructor de Asistencia
     * Inicializa los ArrayLists para las asistencias
     */
    public Asistencia() {
        listaAsistencia = new ArrayList<>();
        listaAusencia = new ArrayList<>();
        listaHoraLlegada = new ArrayList<>();
        listaAtraso = new ArrayList<>();
    }

    /**
     * Método para obtener la lista de empleados que llegan tarde a la reunión.
     * Se considerará "tarde" 5 minutos después de la hora de inicio.
     *
     * @param horaInicio Instant que indica el momento en el que se inicia la reunión.
     * @return ArrayList de empleados que llegaron tarde.
     * @throws NoIniciadoReunionException Se lanza si la reunión no ha iniciado.
     */
    public ArrayList<Empleado> getListaAtraso(Instant horaInicio) throws NoIniciadoReunionException{
        if (horaInicio == null || horaInicio.isAfter(Instant.now())){
            throw new NoIniciadoReunionException();
        }

        Instant horaAusencia = horaInicio.plus(5, ChronoUnit.MINUTES);
        for (int i = 0; i < listaHoraLlegada.size(); i++) {
            if(horaAusencia.isBefore(listaHoraLlegada.get(i))){
                listaAtraso.add(listaAsistencia.get(i));
            }
        }
        return listaAtraso;
    }

    /**
     * Método para obtener la lista de empleados que no asistieron a la reunión.
     * Para iniciar este método la reunión debe haber finalizado.
     *
     * @param listaInvitados Lista de empleados invitados a la reunión.
     * @param horaInicio Instant que indica el momento en el que se inicia la reunión.
     * @param horaFinal Instant que indica el momento en el que se termina la reunión
     * @return ArrayList de empleados que no llegaron.
     * @throws NoIniciadoReunionException Se lanza si la reunión no ha iniciado.
     * @throws NoFinalizadoReunionException Se lanza si la reunión no ha terminado.
     */
    public ArrayList<Empleado> getListaAusencia(ArrayList<Empleado> listaInvitados, Instant horaInicio, Instant horaFinal) throws NoIniciadoReunionException, NoFinalizadoReunionException {
        if(horaInicio == null || horaInicio.isAfter(Instant.now())){
            throw new NoIniciadoReunionException();
        }

        else if (horaFinal == null){
            throw new NoFinalizadoReunionException();
        }

        for (int i = 0; i < listaInvitados.size(); i++) {
            if (!listaAsistencia.contains(listaInvitados.get(i))){
                listaAusencia.add(listaInvitados.get(i));
            }
        }
        return listaAusencia;
    }

    /**
     * Método para obtener la lista de empleados que asistieron a la reunión.
     * No hace diferencia entre atrasados y puntuales.
     *
     * @param horaInicio Instant que indica el momento en el que se inicia la reunión.
     * @return ArrayList de empleados que asistieron.
     * @throws NoIniciadoReunionException Se lanza si la reunión no ha iniciado.
     */
    public ArrayList<Empleado> getListaAsistencia(Instant horaInicio) throws NoIniciadoReunionException{
        if (horaInicio == null || horaInicio.isAfter(Instant.now())){
            throw new NoIniciadoReunionException();
        }

        return listaAsistencia;
    }

    /**
     * Método que registra la llegada de un empleado a la reunión junto a su hora.
     *
     * @param empleado Empleado que llega a la reunión.
     * @param horaInicio Instant que indica el momento en el que se inicia la reunión.
     * @param horaFinal Instant que indica el momento en el que se termina la reunión.
     * @throws NoIniciadoReunionException Se lanza si la reunión no ha iniciado.
     * @throws ReunionFinalizadaException Se lanza si la reunión no ha terminado.
     */
    public void addLlegada(Empleado empleado, Instant horaInicio, Instant horaFinal) throws NoIniciadoReunionException, ReunionFinalizadaException {
        if (horaInicio == null || Instant.now().isBefore(horaInicio)){
            throw new NoIniciadoReunionException();
        }
        else if(horaFinal != null){
            throw new ReunionFinalizadaException();
        }
        listaHoraLlegada.add(Instant.now());
        listaAsistencia.add(empleado);
    }
    
}
