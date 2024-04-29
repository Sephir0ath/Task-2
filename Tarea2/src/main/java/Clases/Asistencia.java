package Clases;
import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    ArrayList<Empleado> listaAsistencia;
    ArrayList<Instant> listaHoraLlegada;


    public Asistencia(){}

    public void addEmpleado(Empleado empleado){
        listaAsistencia.add(empleado);
    }

}


