package Clases;

public class Empleado {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getCorreo(){
        return correo;
    }

}
