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
    

    /**
     * El metodo devuelve true si el arbol es binario de busqueda y false si no.
     * Este proceso lo realiza recorriendo el arbol de forma recursiva en 
     * preorder, comparando los nodos hijos con el padre teniendo que ser el 
     * hijo izquierdo siempre inferior y el derecho siempre mayor. El recorrido
     * se hace completo mientras sea "busqueda" sea true y devuelve este 
     * booleano. En caso de que que en cualquier momento se incumpla la 
     * condición, este valor false será el que se devuelva, independientemente 
     * del resto de comprobaciones.
     * @param a
     * @param busqueda
     * @return 
     */
    private boolean esABB(ArbolBinario<Integer> a, boolean busqueda) {
        if(busqueda){
            if(!a.esVacio()){
                if(!a.hijoIzq().esVacio()){
                    if(a.raiz()>=a.hijoIzq().raiz()){ 
                        busqueda = esABB(a.hijoIzq(), busqueda);
                    } else return false;
                } else return true;
                if(!a.hijoDer().esVacio()){
                    if(a.raiz()<a.hijoDer().raiz()){ 
                        busqueda = esABB(a.hijoDer(), busqueda);
                    } else return false;
                } else return true;
            }
        }
        return busqueda;
    }
    
    /**
     * Nos indica si el árbol es o no binario de busqueda.
     * @return 
     */
    public boolean esABB(){ 
       boolean busqueda = true;
       busqueda = esABB(this,busqueda);
       return busqueda;
    }
    
    /**
     * El método calcula si el valor contenido en la raíz es igual al numero de
     * nodos internos del arbol. Para esto, recorre el arbol de forma recursiva
     * contando el numero de nodos internos del arbol, sumando uno si el nodo 
     * tiene hijo izquierdo o hijo derecho. Como siempre hay nodo raiz, y este 
     * no es un nodo interno, le restaremos uno al final del proceso, y este 
     * numero será el que se compare con el nodo raíz.
     * @param a
     * @param cont
     * @return 
     */
    private int raizIgualNodosInternos(ArbolBinario<Integer> a, int cont){ 
        if(!a.esVacio()){
            if(!a.hijoIzq().esVacio() || !a.hijoDer().esVacio()){
                cont = raizIgualNodosInternos(a.hijoIzq(), cont+1);
                cont = raizIgualNodosInternos(a.hijoDer(), cont);
            } else return cont;
        }
        return cont;
    }
    
    /**
     * Nos indica si el valor de la raíz es o no igual al numero de nodos
     * internos
     * @return Si la raíz es o no igual al numero de nodos internos
     */
    public boolean RaizIgualNodosInternos(){ 
        int cont = 0;
        cont = raizIgualNodosInternos(this, cont);
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
    public int maxValor(ArbolBinario<Integer> a,int max ){

        if(!a.esVacio()){                            
            if(a.raiz()>=max) max = a.raiz();           
            max = maxValor(a.hijoIzq(), max);
            max = maxValor(a.hijoDer(), max);
            return max;         
        }else return max;     
    }
    
    
    /**
     * Metodo lanzadera de MinimoValorNivel,
     * @param nivel
     * @return Un entero el cual es el valor minimo del valor en el nivel
     * indicado previamente.
     */
    public int minimoValorNivel(int nivel){
        
        return minimoValorNivel(this, 0, nivel, maxValor(this, (int)raiz()));
              
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
    public int minimoValorNivel(ArbolBinario<Integer> a, int cont,int nivel,int min ){
 
        if(!a.esVacio() && cont<= nivel){
                
            if (cont == nivel){
                if(a.raiz()<=min) min = a.raiz();
                else min = min;
            }               
            min = minimoValorNivel(a.hijoIzq(), cont+1, nivel, min);
            min = minimoValorNivel(a.hijoDer(), cont+1, nivel, min);
            return min;

        }else return min;     
    }
    
   
    /**
     * Metodo lanzadera de NivelesAB
     * @return Los niveles de un arbol dado.
     */
    public int nivelesAB(){
        
        return nivelesAB(this, 0, 0);
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
    public int nivelesAB(ArbolBinario<Integer> a, int cont, int nivel){
        
        if(!a.esVacio()){
            if(cont>=nivel) nivel = cont;          
            nivel = nivelesAB(a.hijoIzq(),cont+1,nivel);
            nivel = nivelesAB(a.hijoDer(),cont+1,nivel);
            return nivel;
        }
        return nivel;
    }
    
    
  
    
}
