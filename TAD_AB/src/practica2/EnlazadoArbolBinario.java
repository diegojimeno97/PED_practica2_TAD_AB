/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import excepciones.ArbolVacioExcepcion;

/**
 *
 * @author Home
 */
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
    
    
    private EnlazadoArbolBinario<E>(NodoBinario<E> raiz){
        this.nodoRaiz = raiz;
    }
    
    
    public E raiz() throws ArbolVacioExcepcion{
        if(esVacio()) 
            throws new ArbolVacioExcepcion("raiz: Árbol vacio");
            //incompleto
    }
    
    
    @Override
    public boolean esVacio() {
        return nodoRaiz==null;
    }

    @Override
    public Object raiz() throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArbolBinario hijoIzq() throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArbolBinario hijoDer() throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esta(Object elmento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRaiz(Object elemRaiz) throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHijoIzq(ArbolBinario hi) throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHijoDer(ArbolBinario hd) throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarNodosInferiores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
