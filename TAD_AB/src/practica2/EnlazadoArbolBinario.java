/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Diego
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E>{
    
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
    
    
    public boolean esVacio(){
        return nodoRaiz==null;
    }
    
    
    public E raiz() throws ArbolVacioExcepcion{
        if(esVacio()) 
            throws new ArbolVacioExcepcion("raiz: Árbol vacio");
    }
}
