
package AB;

import excepciones.ArbolVacioExcepcion;

public class EnlazadoArbolBinario<E> implements ArbolBinario {

    private NodoBinario<E> nodoRaiz;
    
    public EnlazadoArbolBinario(){
        nodoRaiz = null;
    }
    
    
    public EnlazadoArbolBinario(E elemRaiz, ArbolBinario<E> hi,
            ArbolBinario<E> hd) throws NullPointerException{
      
        if(hi==null||hd==null) throw new NullPointerException();
        nodoRaiz = new NodoBinario<E>(elemRaiz,
                ((EnlazadoArbolBinario<E>)hi).nodoRaiz,
                ((EnlazadoArbolBinario<E>)hd).nodoRaiz);
    }
    
    
    private EnlazadoArbolBinario (NodoBinario<E> raiz){ //EnlazadoArbolBinario<E> 
        this.nodoRaiz = raiz;
    }
    
    @Override
    public E raiz() throws ArbolVacioExcepcion{
        if(esVacio()) throw new ArbolVacioExcepcion("raiz:Árbol vacío");
        return nodoRaiz.getElemento();
    }
    
    
    @Override
    public boolean esVacio() {
        return nodoRaiz==null;
    }


   

    @Override
    public ArbolBinario hijoIzq() throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("hijoIzq: Árbol vacio");
        return new EnlazadoArbolBinario<E>(nodoRaiz.getIzq());
    }

    @Override
    public ArbolBinario hijoDer() throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("hijoDer: Árbol vacio");
        return new EnlazadoArbolBinario<E>(nodoRaiz.getDer());
    }
    
    
    
    private boolean esta(NodoBinario<E> raiz, E elemento){
        if(raiz==null) return false;
        if(raiz.getElemento().equals(elemento)) return true;
        boolean temp = esta(raiz.getIzq(),elemento);
        return temp;
    }
    
    @Override
    public boolean esta(Object elemento) {
        return esta(nodoRaiz, (E)elemento);
    }

   
    

    @Override
    public void setHijoIzq(ArbolBinario hi) throws ArbolVacioExcepcion {
        if(hi==null) throw new NullPointerException();
        if(esVacio()) throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacio");
        nodoRaiz.setIzq(((EnlazadoArbolBinario<E>)hi).nodoRaiz);
    }

    @Override
    public void setHijoDer(ArbolBinario hd) throws ArbolVacioExcepcion {
        if(hd==null) throw new NullPointerException();
        if(esVacio()) throw new ArbolVacioExcepcion("setHijoDer: Árbol vacio");
        nodoRaiz.setIzq(((EnlazadoArbolBinario<E>)hd).nodoRaiz);
    }

    @Override
    public void suprimir() {
        nodoRaiz = null;
    }

    @Override
    public void EliminarNodosInferiores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void setRaiz(Object elemRaiz) throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("raiz: Árbol vacio");
        nodoRaiz.setElemento((E) elemRaiz);
    }
  
    
}
