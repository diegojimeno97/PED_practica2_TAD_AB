/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB;

import java.io.IOException;

/**
 *
 * @author Home
 */
public class ABEnteros<E extends Integer> extends EnlazadoArbolBinario implements ArbolBinario{
    
    public ABEnteros(E elemRaiz, ArbolBinario<E> hi,
            ArbolBinario<E> hd) {
        super(elemRaiz,hi,hd);
    }
    
    public ABEnteros(E elemRaiz) {
        super(elemRaiz);
    }
    

    private boolean EsABB(ArbolBinario<Integer> a, boolean busqueda) {
        if(busqueda){
            if(!a.esVacio()){
                if(!a.hijoIzq().esVacio()){
                    if(a.raiz()>=a.hijoIzq().raiz()){ 
                        busqueda = EsABB(a.hijoIzq(), busqueda);
                    } else return false;
                } else return true;
                if(!a.hijoDer().esVacio()){
                    if(a.raiz()<a.hijoDer().raiz()){ 
                        busqueda = EsABB(a.hijoDer(), busqueda);
                    } else return false;
                } else return true;
            }
        }
        return busqueda;
    }
    
    public boolean EsABB(){ 
       boolean busqueda = true;
       busqueda = EsABB(this,busqueda);
       return busqueda;
    }
    
    private int RaizIgualNodosInternos(ArbolBinario<Integer> a, int cont){ 
        if(!a.esVacio()){
            if(!a.hijoIzq().esVacio() || !a.hijoDer().esVacio()){
                cont = RaizIgualNodosInternos(a.hijoIzq(), cont+1);
                cont = RaizIgualNodosInternos(a.hijoDer(), cont);
            } else return cont;
        }
        return cont;
    }
    
    public boolean RaizIgualNodosInternos(){ 
        int cont = 0;
        cont = RaizIgualNodosInternos(this, cont);
        if((Integer)raiz() == cont-1) return true;
        else return false;
    }
    
    
     /**
     * Metodo calcula el valor maximo de todo el AB.
     * Mediante recursividad recorre todo los nodos del AB, comprobando el valor
     * de cada uno de los nodos con que recibe como parametro, si el nodo actual
     * es mayor se sobreescribe y este nuevo valor se pasa como parametro en la
     * siguiente llamada recursiva.
     * @param a
     * @param max
     * @return El valor maximo contenido en los nodos del AB.
     */
    public int MaxValor(ArbolBinario<Integer> a,int max ){

        if(!a.esVacio()){                            
            if(a.raiz()>=max) max = a.raiz();           
            max = MaxValor(a.hijoIzq(), max);
            max = MaxValor(a.hijoDer(), max);
            return max;         
        }else return max;     
    }
    
    
    /**
     * Metodo lanzadera de MinimoValorNivel,
     * @param nivel
     * @return Un entero el cual es el valor minimo del valor en el nivel
     * indicado previamente.
     */
    public int MinimoValorNivel(int nivel){
        
        return MinimoValorNivel(this, 0, nivel, MaxValor(this, (int)raiz()));
              
    }
    
    
    /**
     * Metodo que busca en el AB el valor minimo del nivel indicado.
     * Para ello se llama recursivamente recorriendo los nodos hasta llegar al 
     * caso base, este es que el arbol este vacio y que este en un nivel 
     * superior al indicado. Sino esta en el caso base y se esta en el nivel
     * deseado del arbol comprueba el valor del nodo actual con el que se le 
     * pasa como parametro, si el valor actual es menor lo sobreescribe y lo 
     * pasa como parametro a la siguiente llamada recursiva.
     * El metodo en la primera llamada tiene como parametro min el maximo valor
     * del árbol (MaxValor())evitando asi pasar como primer parametro un valor 
     * aleatorio que pueda suponer un  problema o error en el metodo.
     * @param a
     * @param cont
     * @param nivel
     * @param min
     * @return El valor minimo del arbol.
     */
    public int MinimoValorNivel(ArbolBinario<Integer> a, int cont,int nivel,int min ){
 
        if(!a.esVacio() && cont<= nivel){
                
            if (cont == nivel){
                if(a.raiz()<=min) min = a.raiz();
                else min = min;
            }               
            min = MinimoValorNivel(a.hijoIzq(), cont+1, nivel, min);
            min = MinimoValorNivel(a.hijoDer(), cont+1, nivel, min);
            return min;

        }else return min;     
    }
    
   
    /**
     * Metodo lanzadera de NivelesAB
     * @return Los niveles de un arbol dado.
     */
    public int NivelesAB(){
        
        return NivelesAB(this, 0, 0);
    }
    
    
    /**
     * Metodo que cuenta los niveles que tiene un AB, mediante recursividad
     * va sumando 1 al contador por cada nivel que baja hasta llegar al
     * caso base, de esta forma siempre que el contador sea mayor al nivel que
     * se pasa como parametro este lo sobreescribe, asi el valor del nivel
     * se conserva durante todo el replegado y desplegado del metodo.
     * @param a
     * @param cont
     * @param nivel
     * @return 
     */
    public int NivelesAB(ArbolBinario<Integer> a, int cont, int nivel){
        
        if(!a.esVacio()){
            if(cont>=nivel) nivel = cont;          
            nivel = NivelesAB(a.hijoIzq(),cont+1,nivel);
            nivel = NivelesAB(a.hijoDer(),cont+1,nivel);
            return nivel;
        }
        return nivel;
    }
    
    
  
    
}
