package Excepciones;

/**
 * Excepcion creada para el caso en que ciertos parametros sean nulos en los constructores de ciertas clases
 */
public class ParametrosInvalidosException extends Exception{

    /**
     * Metodo constructor de la clase, hereda los datos de la clase Exception
     */
    public ParametrosInvalidosException(){
        super();
    }
}
