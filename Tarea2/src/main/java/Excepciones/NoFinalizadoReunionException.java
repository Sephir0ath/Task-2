package Excepciones;

/**
 * Excepcion creada en el caso que se traten de llamar metodos y no ha finalizado la reunion
 */
public class NoFinalizadoReunionException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public NoFinalizadoReunionException(){
        super();
    }
}
