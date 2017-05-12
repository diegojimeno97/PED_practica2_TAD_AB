
package excepciones;

/**
 * Clase para las excepciones personalizadas.
 */
public class ArbolVacioExcepcion extends RuntimeException {
    
    
    public ArbolVacioExcepcion() {      
        super();
    }
    
    public ArbolVacioExcepcion(String message) {

       super(message);

    }
    
}
