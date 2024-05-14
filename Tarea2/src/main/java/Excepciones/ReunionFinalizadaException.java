package Excepciones;

/**
 * Excepcion creada para el caso en que se intente llegar a una reunion que ya finalizo
 */
public class ReunionFinalizadaException extends Exception{
    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public ReunionFinalizadaException(){
        super();
    }
}