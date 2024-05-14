package Excepciones;

/**
 * Excepcion creada en el caso en que se intente llamar a un metodo cuando la reunion no ha inicializado
 */
public class NoIniciadoReunionException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public NoIniciadoReunionException(){
        super();
    }
}
