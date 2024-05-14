package Clases;

import java.util.ArrayList;

public class Departamento {
    private String nombreDepartamento;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public Departamento(String nombre){
        this.nombreDepartamento = nombre;
    }

    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void deleteEmpleado(Empleado empleado){
        empleados.remove(empleados.indexOf(empleado));
    }

    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }

    public String getNombreDepartamento(){
        return nombreDepartamento;
    }
}
