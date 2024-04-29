package Clases;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Instant horaInicio;
    private Instant horaFinal;
    private TipoReunion tipoReunion;


    public Reunion(){

    }
    public ArrayList<Empleado> obtenerAsistencia(){

    }
    public ArrayList<Empleado> obtenerAusencias(){

    }
    public ArrayList<Empleado> obtenerRetrasos(){

    }
    public int obtenerTotalAsistencia(){

    }
    public float PorcentajeAsistencia(){
        // Tomar cantidad de invitados, cantidad de asistencias de obtTotalAsistencia, con eso calcular %
    }
    public float calcularTiempoReal(){
        // concepto: Hora inicio - hora final
    }
    public void iniciar(){
        // Declara hora inicio
    }
    public void finalizar(){
        // Declara hora final
    }
}
