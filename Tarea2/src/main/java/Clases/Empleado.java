package Clases;

/**
 * Empleado representa un empleado el cual puede ser invitado a la reunión.
 */
public class Empleado {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * Constructor de Empleado.
     * Asigna los valores a las variables privadas.
     * @param id ID del empleado.
     * @param apellidos Apellidos del empleado.
     * @param nombre Nombre del empleado.
     * @param correo Correo del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Método getter para obtener el ID del empleado.
     * @return id ID del empleado.
     */
    public String getId(){
        return id;
    }

    /**
     * Método getter para obtener el nombre del empleado.
     * @return nombre Nombre del empleado.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método getter para obtener el/los apellidos del empleado.
     * @return apellidos Apellidos del empleado.
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     * Método getter para obtener el correo del empleado.
     * @return correo Correo del empleado.
     */
    public String getCorreo(){
        return correo;
    }

}