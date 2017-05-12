package AB;

import excepciones.ArbolVacioExcepcion;

public interface ArbolBinario<E> {
    
    public boolean esVacio();
    public E raiz() throws ArbolVacioExcepcion;
    public ArbolBinario<E>hijoIzq() throws ArbolVacioExcepcion;
    public ArbolBinario<E>hijoDer() throws ArbolVacioExcepcion;
    public boolean esta(E elmento);
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion;
    public void setHijoIzq(ArbolBinario<E> hi)
            throws ArbolVacioExcepcion;
    public void setHijoDer(ArbolBinario<E> hd)
            throws ArbolVacioExcepcion;
    public void suprimir();
    public void EliminarNodosInferiores();
}
