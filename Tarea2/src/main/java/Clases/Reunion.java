package Clases;

import Excepciones.NoFinalizadoReunionException;
import Excepciones.NoIniciadoReunionException;
import Excepciones.ParametrosInvalidosException;
import Excepciones.ReunionFinalizadaException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;

/**
 * Clase abstracta que representa una Reunion
 */
public abstract class Reunion{
    private Instant horaPrevista;
    private Date fecha;
    private Instant horaInicio;
    private Instant horaFinal;
    private TipoReunion tipo;
    private Duration duracionPrevista;
    private Duration duracionReunion;
    private Invitacion invitacionReunion;
    private ArrayList<Nota> notas;
    private Asistencia asistencia;

    /**
     * Constructor de la clase Reunion
     *
     * @param invitacion Instancia de clase Invitacion que es usada para obtener informacion de los Empleados invitados
     */
    public Reunion(Invitacion invitacion){
        this.invitacionReunion = invitacion;
        this.duracionPrevista = invitacionReunion.getDuracionPrevista();
        this.fecha= invitacionReunion.getFecha();
        this.horaPrevista = invitacionReunion.getHoraPrevista();
        this.tipo = invitacionReunion.getTipo();
        notas = new ArrayList<>();
        this.asistencia = new Asistencia();
    }

    /**
     * Metodo para revisar que la instancia de Invitacion que se pasa por Reunion no sea nula
     *
     * @throws ParametrosInvalidosException excepcion por si invitacion es null
     */
    public void checkParameters() throws ParametrosInvalidosException {
        if (invitacionReunion == null){
            throw new ParametrosInvalidosException();
        }
    }

    /**
     * Metodo abstracto que obtiene el enlace/sala de las reuniones
     *
     * @return String con el enlace
     */
    public abstract String getAcceso();

    /**
     * Metodo para iniciar la reunion
     */
    public abstract void iniciar();

    /**
     * Metodo para finalizar la reunion
     */
    public abstract void finalizar();

    /**
     * Metodo setter para la variable horaInicio
     *
     * @param horaInicio Hora inicial de la reunion
     */
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Metodo setter para la variable horaFinal
     *
     * @param horaFinal Hora final de la reunion
     */
    public void setHoraFinal(Instant horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * Metodo getter para obtener la hora de inicio de la reunion
     *
     * @return horaInicio de Reunion
     * @throws NoIniciadoReunionException Excepcion si no se ha iniciado la reunion
     */
    public Instant getHoraInicio() throws NoIniciadoReunionException{
        if (horaInicio == null){
            throw new NoIniciadoReunionException();
        }

        return horaInicio;
    }

    /**
     * Metodo getter para obtener la hora final de la reunion
     *
     * @return horaFinal de Reunion
     * @throws NoFinalizadoReunionException Excepcion si no ha finalizado la reunion
     */
    public Instant getHoraFinal() throws NoFinalizadoReunionException{
        if (horaFinal == null){
            throw new NoFinalizadoReunionException();
        }

        return horaFinal;
    }

    /**
     * Metodo para crear una instancia de Nota y luego añadirla al ArrayList de notas
     *
     * @param contenido String que contiene la informacion de la nota
     * @throws NoIniciadoReunionException Excepcion si no ha iniciado la reunion
     */
    public void createNota(String contenido) throws NoIniciadoReunionException {
        if (horaInicio != null){
        notas.add(new Nota(contenido));
        }
        else{
            throw new NoIniciadoReunionException();
        }
    }

    /**
     * Metodo getter para obtener el ArrayList con las notas
     *
     * @return ArrayList de objeto Nota
     */
    public ArrayList<Nota> getNotas(){
        return notas;
    }

    /**
     * Metodo getter para obtener la Fecha de la reunion
     *
     * @return variable Fecha de tipo Date
     */
    public Date getFecha(){
        return fecha;
    }

    /**
     * Metodo getter para obtener el tipo de reunion qu ese está realizando
     *
     * @return variable tipo de tipo TipoReunion
     */
    public TipoReunion getTipo(){
        return tipo;
    }

    /**
     * Metodo getter para obtener la hora prevista de la reunion
     *
     * @return variable horaPrevista de tipo Instant
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * Metodo getter para obtener la duracion total de la reunion
     *
     * @return duracionReunion de tipo Duration
     * @throws NoFinalizadoReunionException Excepcion si no ha finalizado la reunion
     */
    public Duration getDuracionReunion() throws NoFinalizadoReunionException{
        if (horaInicio != null && horaFinal != null) {
            duracionReunion = Duration.between(horaInicio, horaFinal);
        }
        else {
            throw new NoFinalizadoReunionException(); // Exception
        }
        return duracionReunion;
    }

    /**
     * Metodo getter para obtener la duracion prevista de la reunion
     *
     * @return variable duracionPrevista de tipo Duration
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }

    /**
     * Metodo getter para obtener el ArrayList con los empleados que están asistiendo actualmente a la reunion
     *
     * @return ArrayList de Empleados
     * @throws NoIniciadoReunionException Excepcion por si no ha iniciado la reunion
     */
    public ArrayList<Empleado> getAsistencias() throws NoIniciadoReunionException {
        return asistencia.getListaAsistencia(this.horaInicio);
    }

    /**
     * Metodo getter para obtener el ArrayList con los empleados que no asistieron a la reunion
     *
     * @return Arraylist de Empleados
     * @throws NoFinalizadoReunionException Excepcion por si no ha finalizado la reunion
     * @throws NoIniciadoReunionException Excepcion por si no ha iniciado la reunion
     */
    public ArrayList<Empleado> getAusencias() throws NoFinalizadoReunionException, NoIniciadoReunionException {
        return asistencia.getListaAusencia(invitacionReunion.getListaInvitados(), this.horaInicio, this.horaFinal);
    }

    /**
     * Metodo getter para obtener el ArrayList con los empleados que han llegado atrasados actualmente
     *
     * @return ArrayList de Empleados
     * @throws NoIniciadoReunionException Excepcion por si no ha iniciado la reunion
     */
    public ArrayList<Empleado> getAtrasos() throws NoIniciadoReunionException {
        return asistencia.getListaAtraso(this.horaInicio);
    }

    /**
     * Metodo getter para obtener la cantidad de Empleados que asistieron a la reunion
     *
     * @return Entero con la cantidad de Empleados
     * @throws NoIniciadoReunionException Excepcion por si no ha iniciado la reunion
     * @throws NoFinalizadoReunionException Excepcion por si no ha finalizado la reunion
     */
    public int getTotalAsistencia() throws NoIniciadoReunionException, NoFinalizadoReunionException {
        if (horaFinal == null){
            throw new NoFinalizadoReunionException();
        }
        return getAsistencias().size();
    }

    /**
     * Metodo getter para obtener el porcentaje de Empleados que asistieron a la reunion en comparacion del total invitado
     *
     * @return un numero flotante que representa el porcentaje
     * @throws NoIniciadoReunionException Excepcion por si no ha iniciado la reunion
     * @throws NoFinalizadoReunionException Excepcion por si no ha finalizado la reunion
     */
    public float getPorcentajeAsistencia() throws NoIniciadoReunionException, NoFinalizadoReunionException {
        int cantidadAsistentes = getTotalAsistencia();
        int cantidadInvitados = invitacionReunion.getListaInvitados().size();

        return (100 * (float)cantidadAsistentes) / (float)cantidadInvitados;
    }

    /**
     * Metodo getter para obtener el la duracion de la reunion en segundos
     *
     * @return la duracion de la reunion
     */
    public float getTiempoReal(){
        return (float)duracionReunion.toSeconds();
    }

    /**
     * Metodo para añadir empleados a la lista de asistencia
     *
     * @param empleado Empleado que se añade
     * @throws ReunionFinalizadaException Excepcion por si ya finalizo la reunion
     * @throws NoIniciadoReunionException Excepcion por si no ha iniciado la reunion
     */
    public void addLlegada(Empleado empleado) throws ReunionFinalizadaException, NoIniciadoReunionException {
        asistencia.addLlegada(empleado, horaInicio, horaFinal);
    }
}
