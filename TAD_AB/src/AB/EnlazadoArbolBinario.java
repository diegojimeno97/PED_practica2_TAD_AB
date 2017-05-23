
package AB;

import excepciones.ArbolVacioExcepcion;
import java.util.LinkedList;

public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    protected NodoBinario<E> nodoRaiz;
    
    
    public EnlazadoArbolBinario(E elemRaiz, ArbolBinario<E> hi,
            ArbolBinario<E> hd) throws NullPointerException{
      
        //if(hi==null||hd==null) throw new NullPointerException();
        if (hi == null){
            this.nodoRaiz = new NodoBinario<E>(elemRaiz,null,
                ((EnlazadoArbolBinario<E>)hd).nodoRaiz);
        } else if(hd == null){
            this.nodoRaiz = new NodoBinario<E>(elemRaiz,
                ((EnlazadoArbolBinario<E>)hi).nodoRaiz,null);
        }else{
            this.nodoRaiz = new NodoBinario<E>(elemRaiz,
                    ((EnlazadoArbolBinario<E>)hi).nodoRaiz,
                    ((EnlazadoArbolBinario<E>)hd).nodoRaiz);
        }
        
    }
    
    
    //FALTA TAD
    public EnlazadoArbolBinario(E elemRaiz){
        this.nodoRaiz = new NodoBinario<E>(elemRaiz);
    }
    
    
    private EnlazadoArbolBinario (NodoBinario<E> raiz){ //EnlazadoArbolBinario<E> 
        this.nodoRaiz = raiz;
    }
    
    /**
     * Devuelve el elemento almacenado en el nodo raíz del árbol.
     * @return
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public E raiz() throws ArbolVacioExcepcion{
        if(esVacio()) throw new ArbolVacioExcepcion("raiz:Árbol vacío");
        return nodoRaiz.getElemento();
    }
    
    /**
     * Indica si el arbol es o no un árbol vacio.
     * @return 
     */
    @Override
    public boolean esVacio() {
        return nodoRaiz==null;
    }

    /**
     * Devuelve un subarbol con el nodo raíz como el hijo derecho del nodo 
     * raíz anterior.
     * @return
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public ArbolBinario hijoIzq() throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("hijoIzq: Árbol vacio");
        return new EnlazadoArbolBinario<E>(nodoRaiz.getIzq());
    }
    
    /**
     * Devuelve un subarbol con el nodo raíz como el hijo derecho del nodo 
     * raíz anterior.
     * @return
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public ArbolBinario hijoDer() throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("hijoDer: Árbol vacio");
        return new EnlazadoArbolBinario<E>(nodoRaiz.getDer());
    }
    
    /**
     * Indica si el elemento que se le pasa como parámetro se encuentra en el 
     * árbol.
     * @param raiz
     * @param elemento
     * @return 
     */
    private boolean esta(NodoBinario<E> raiz, E elemento){
        if(raiz==null) return false;
        if(raiz.getElemento().equals(elemento)) return true;
        boolean temp = esta(raiz.getIzq(),elemento);
        return temp;
    }
    
    /**
     * Indica si el elemento que se le pasa como parámetro se encuentra en el 
     * árbol.
     * @param elemento
     * @return 
     */
    @Override
    public boolean esta(E elemento) {
        return esta(nodoRaiz, elemento);
    }

   
    
    /**
     * Introduce el Arbol pasado como parámetro en el árbol como hijo izquierdo
     * del nodo raíz.
     * @param hi
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public void setHijoIzq(ArbolBinario hi) throws ArbolVacioExcepcion {
        if(hi==null) throw new NullPointerException();
        if(esVacio()) throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacio");
        nodoRaiz.setIzq(((EnlazadoArbolBinario<E>)hi).nodoRaiz);
    }
    /**
     * Introduce el Arbol pasado como parámetro en el árbol como hijo derecho
     * del nodo raíz.
     * @param hd
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public void setHijoDer(ArbolBinario hd) throws ArbolVacioExcepcion {
        if(hd==null) throw new NullPointerException();
        if(esVacio()) throw new ArbolVacioExcepcion("setHijoDer: Árbol vacio");
        nodoRaiz.setIzq(((EnlazadoArbolBinario<E>)hd).nodoRaiz);
    }
    
    /**
     * Pone a null el nodo raíz del arbol.
     */
    @Override
    public void suprimir() {
        this.nodoRaiz = null;
    }

    /*
    private static <E> void EliminarNodosInferiores(ArbolBinario<E> a, int cont, 
            int nivel) throws ArbolVacioExcepcion {
        if(!a.esVacio()&&cont<=nivel){
            EliminarNodosInferiores(a.hijoIzq(), cont+1, nivel);
            EliminarNodosInferiores(a.hijoDer(), cont+1, nivel);
            if(cont == nivel){
                a.setHijoDer(null);
                a.setHijoIzq(null);
            }
        }
    }
    
    @Override
    public void EliminarNodosInferiores(int nivel) {
        if(!esVacio()){
            EliminarNodosInferiores(
                    ((ArbolBinario<E>)nodoRaiz).hijoIzq(), 1, nivel);
            EliminarNodosInferiores(
                    ((ArbolBinario<E>)nodoRaiz).hijoDer(), 1, nivel);
        }
    }*/
    
    
    /**
     * Metodo lanzadera de EliminarNodosInferiores que pasa como parametro
     * el nivel dado por el usuario para eliminar los nodos.
     * @param nivel 
     */
     @Override
    public void EliminarNodosInferiores(int nivel){
        
        EliminarNodosInferiores(this,0,nivel);
       
    }
    
    
    /**
     * Metodo Eliminar nodos Inferiores. Mediante recursividad elimina las
     * referencias a sus hijos de cada nodo que se encuentre en el nivel dado.
     * @param <E>
     * @param a
     * @param cont
     * @param nivel
     * @throws ArbolVacioExcepcion 
     */
    public static <E> void EliminarNodosInferiores(ArbolBinario<E> a, int cont, 
            int nivel)throws ArbolVacioExcepcion {
        
        if(!a.esVacio() && cont <= nivel){
            
            if(cont == nivel){
                if(!a.hijoIzq().esVacio()) 
                ((EnlazadoArbolBinario<E>)a).nodoRaiz.setIzq(null);
                if(!a.hijoDer().esVacio())
                ((EnlazadoArbolBinario<E>)a).nodoRaiz.setDer(null);                       
            }              
            EliminarNodosInferiores(a.hijoIzq(),cont+1,nivel);
            EliminarNodosInferiores(a.hijoDer(),cont+1,nivel); 
                   
        }
               
    }
     
    /**
     * Pone como raíz del arbol el elemento pasado como parámetro.
     * @param elemRaiz
     * @throws ArbolVacioExcepcion 
     */
    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("raiz: Árbol vacio");
        nodoRaiz.setElemento(elemRaiz);
    }
    
    public static <E> void anchura(ArbolBinario<E> a) 
            throws ArbolVacioExcepcion {
        LinkedList<ArbolBinario<E>> c = 
                (LinkedList<ArbolBinario<E>>) new LinkedList<E>();
        c.offer(a);
        do{
            a = c.remove();
            if(!a.esVacio()){
                System.out.println(a.raiz());           
                c.offer(a.hijoIzq());
                c.offer(a.hijoDer());               
            }
            
        }while(!c.isEmpty());
    }
  
    
    
    /**
     * Metodo generico preorder que muestra por pantalla el listado de un árbol
     * en PreOrden.
     * @param <E>
     * @param a
     * @throws ArbolVacioExcepcion 
     */
    public static <E> void preorden(ArbolBinario<E> a) 
            throws ArbolVacioExcepcion {
        if(!a.esVacio()){
            System.out.print(a.raiz() +" ");
            preorden(a.hijoIzq());
            preorden(a.hijoDer());
        }
    }
    
    
    /**
     * Metodo generico inorden que muestra por pantalla el listado de un árbol
     * en InOrden.
     * @param <E>
     * @param a
     * @throws ArbolVacioExcepcion 
     */
    public static <E> void inorden(ArbolBinario<E> a) 
            throws ArbolVacioExcepcion {
        if(!a.esVacio()){
            inorden(a.hijoIzq());
            System.out.print(a.raiz() +" ");
            inorden(a.hijoDer());
        }
    }
    
    /**
     * Metodo generico postorden que muestra por pantalla el listado de un árbol
     * en PostOrden.
     * @param <E>
     * @param a
     * @throws ArbolVacioExcepcion 
     */
    public static <E> void postorden(ArbolBinario<E> a) 
            throws ArbolVacioExcepcion {
        if(!a.esVacio()){
            postorden(a.hijoIzq());
            postorden(a.hijoDer());
            System.out.print(a.raiz() +" ");
        }
    }
    
}
