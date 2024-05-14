package Clases;

/**
 * Clase que representa una nota
 */
public class Nota {
    private String contenido;

    /**
     * Constructor de la clase
     *
     * @param contenido String que contiene el contenido de la nota
     */
    public Nota(String contenido){
        this.contenido = contenido;
    }

    /**
     * Metodo getter para obtener el contenido de la nota
     *
     * @return variable contenido de tipo String
     */
    public String getContenidoNota(){
        return contenido;
    }
}
