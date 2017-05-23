
package AB;

public class NodoBinario<E> {
    
    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;
    
    public NodoBinario(E e, NodoBinario<E> hi, NodoBinario<E> hd){
        this.elemento = e;
        this.izq = hi;
        this.der = hd;
    }
    
    //FALTA TAD
    /**
     * Constructor que nos permite tener un nodo sin hijos, por lo que sus
     * referencias a los mismos es null.
     * @param e 
     */
    public NodoBinario(E e){
        this.elemento = e;
        this.izq = null;
        this.der = null;
    }
    
    public E getElemento(){
        return elemento;
    }
    
    public NodoBinario<E> getIzq(){
        return izq;
    }
    
    public NodoBinario<E> getDer(){
        return der;
    }
    
    public void setElemento(E e){
        this.elemento = e;
    }
    
    public void setIzq(NodoBinario<E> hi){
        this.izq = hi;
    }
    
    public void setDer(NodoBinario<E> hd){
        this.der = hd;
    }
    
    
}
