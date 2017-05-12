package AB;

import excepciones.ArbolVacioExcepcion;

public interface ArbolBinario<E> {
    
    public abstract boolean esVacio();
    public abstract E raiz() throws ArbolVacioExcepcion;
    public abstract ArbolBinario<E>hijoIzq() throws ArbolVacioExcepcion;
    public abstract ArbolBinario<E>hijoDer() throws ArbolVacioExcepcion;
    public abstract boolean esta(E elemento);
    public abstract void setRaiz(E elemRaiz) throws ArbolVacioExcepcion;
    public abstract void setHijoIzq(ArbolBinario<E> hi)
            throws ArbolVacioExcepcion;
    public abstract void setHijoDer(ArbolBinario<E> hd)
            throws ArbolVacioExcepcion;
    public abstract void suprimir();
    public abstract void EliminarNodosInferiores(int nivel);
}
