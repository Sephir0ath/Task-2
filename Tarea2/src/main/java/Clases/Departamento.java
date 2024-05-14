package Clases;

import java.util.ArrayList;

/**
 * Departamento representa un departamento conformado por un grupo de empleados, el cual puede ser invitado a la reunión.
 */
public class Departamento {
    private String nombreDepartamento;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    /**
     * Constructor de Departamento.
     *
     * @param nombre Nombra al departamento.
     */
    public Departamento(String nombre){
        this.nombreDepartamento = nombre;
    }

    /**
     * Método que añade empleados para que sean parte del departamento.
     *
     * @param empleado Empleado que se añadirá al departamento.
     */
    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    /**
     * Método que permite expulsar empleados del departamento.
     *
     * @param empleado Empleado a eliminar del departamento.
     */
    public void deleteEmpleado(Empleado empleado){
        empleados.remove(empleados.indexOf(empleado));
    }

    /**
     * Método getter para obtener el ArrayList con los empleados del departamento.
     *
     * @return ArrayList de empleados.
     */
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }

    /**
     * Método getter para obtener el nombre del departamento.
     *
     * @return nombreDepartamento Nombre del departmento.
     */
    public String getNombreDepartamento(){
        return nombreDepartamento;
    }
}
