
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
        elemento = e;
    }
    
    public void setIzq(NodoBinario<E> hi){
        izq = hi;
    }
    
    public void setDer(NodoBinario<E> hd){
        der = hd;
    }
    
    
}
