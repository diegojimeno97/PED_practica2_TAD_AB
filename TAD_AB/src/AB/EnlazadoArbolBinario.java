
package AB;

import excepciones.ArbolVacioExcepcion;
import java.util.LinkedList;

public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodoRaiz;
    
    //FALTA TAD
    public EnlazadoArbolBinario(){
        nodoRaiz = null;
    }
    
    
    public EnlazadoArbolBinario(E elemRaiz, ArbolBinario<E> hi,
            ArbolBinario<E> hd) throws NullPointerException{
      
        //if(hi==null||hd==null) throw new NullPointerException();
        if (hi == null){
            nodoRaiz = new NodoBinario<E>(elemRaiz,null,
                ((EnlazadoArbolBinario<E>)hd).nodoRaiz);
        } else if(hd == null){
            nodoRaiz = new NodoBinario<E>(elemRaiz,
                ((EnlazadoArbolBinario<E>)hi).nodoRaiz,null);
        }else{
            nodoRaiz = new NodoBinario<E>(elemRaiz,
                    ((EnlazadoArbolBinario<E>)hi).nodoRaiz,
                    ((EnlazadoArbolBinario<E>)hd).nodoRaiz);
        }
        
    }
    
    
    //FALTA TAD
    public EnlazadoArbolBinario(E elemRaiz){
        nodoRaiz = new NodoBinario<E>(elemRaiz);
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
    public boolean esta(E elemento) {
        return esta(nodoRaiz, elemento);
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

    
    private static <E> void EliminarNodosInferiores(ArbolBinario<E> a, int cont, int nivel) throws ArbolVacioExcepcion {
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
            EliminarNodosInferiores(((ArbolBinario<E>)nodoRaiz).hijoIzq(), 1, nivel);
            EliminarNodosInferiores(((ArbolBinario<E>)nodoRaiz).hijoDer(), 1, nivel);
        }
    }

    

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if(esVacio()) throw new ArbolVacioExcepcion("raiz: Árbol vacio");
        nodoRaiz.setElemento(elemRaiz);
    }
    
    public static <E> void anchura(ArbolBinario<E> a) throws ArbolVacioExcepcion {
        LinkedList<ArbolBinario<E>> c = (LinkedList<ArbolBinario<E>>) new LinkedList<E>();
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
  
    
    public static <E> void preorden(ArbolBinario<E> a) throws ArbolVacioExcepcion {
        if(!a.esVacio()){
            System.out.print(a.raiz() +" ");
            preorden(a.hijoIzq());
            preorden(a.hijoDer());
        }
    }
    
    
    public static <E> void inorden(ArbolBinario<E> a) throws ArbolVacioExcepcion {
        if(!a.esVacio()){
            preorden(a.hijoIzq());
            System.out.print(a.raiz() +" ");
            preorden(a.hijoDer());
        }
    }
    
    
    public static <E> void postorden(ArbolBinario<E> a) throws ArbolVacioExcepcion {
        if(!a.esVacio()){
            preorden(a.hijoIzq());
            preorden(a.hijoDer());
            System.out.print(a.raiz() +" ");
        }
    }
    
}
