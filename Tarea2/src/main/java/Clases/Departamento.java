package Clases;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<String> empleadosId = new ArrayList<>();

    public Departamento(){
    }

    public void addEmpleado(Empleado empleado){
        empleadosId.add(empleado.getId());
    }

    public void deleteEmpleado(Empleado empleado){
        empleadosId.remove(empleado.getId());
    }



}
