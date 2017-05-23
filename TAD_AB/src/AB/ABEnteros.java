
package AB;

public class ABEnteros<E extends Integer> extends EnlazadoArbolBinario{
    
    
    
    /**
     * Constructor de ABEnteros que pasa todos los parametros a su clase padre
     * @param elemRaiz valor del elemento
     * @param hi hijo izquierdo
     * @param hd hijo derecho
     */
    public ABEnteros(E elemRaiz, ArbolBinario<E> hi,
            ArbolBinario<E> hd) {
        super(elemRaiz,hi,hd);
    }
    
    /**
     * Constructor de ABEnteros que pasa el parametro a su clase padre, permite
     * construir un ABEnteros sin hijos.
     * @param elemRaiz 
     */
    public ABEnteros(E elemRaiz) {
        super(elemRaiz);
    }
    


    private boolean esABB(NodoBinario<E> raiz, boolean busqueda) {

        if(busqueda){
            if(raiz!=null){
                if(raiz.getIzq()!=null){
                    if(raiz.getElemento()>=raiz.getIzq().getElemento()){ 
                        busqueda = esABB(raiz.getIzq(), busqueda);
                    } else return false;
                } else return true;
                if(raiz.getDer()!=null){
                    if(raiz.getElemento()<raiz.getDer().getElemento()){ 
                        busqueda = esABB(raiz.getDer(), busqueda);
                    } else return false;
                } else return true;
            }
        }
        return busqueda;
    }
    
    /**
     * El método devuelve true si el arbol es binario de busqueda y false si no.
     * Este proceso lo realiza recorriendo el arbol de forma recursiva en 
     * preorder, comparando los nodos hijos con el padre teniendo que ser el 
     * hijo izquierdo siempre inferior y el derecho siempre mayor. El recorrido
     * se hace completo mientras sea "busqueda" sea true y devuelve este 
     * booleano. En caso de que que en cualquier momento se incumpla la 
     * condición, este valor false será el que se devuelva, independientemente 
     * del resto de comprobaciones.
     * @return si es o no ABB.

     */
    public boolean esABB(){ 
       boolean busqueda = true;
       busqueda = esABB(nodoRaiz,busqueda);
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
     * El método calcula si el valor contenido en la raíz es igual al numero de
     * nodos internos del arbol. Para esto, recorre el arbol de forma recursiva
     * contando el numero de nodos internos del arbol, sumando uno si el nodo 
     * tiene hijo izquierdo o hijo derecho. Como siempre hay nodo raíz, y este 
     * no es un nodo interno, le restaremos uno al final del proceso, y este 
     * numero será el que se compare con el nodo raíz.
     * @return Si la raís es o no igual al numero de nodos internos
     */
    public boolean RaizIgualNodosInternos(){ 
        int cont = 0;
        cont = raizIgualNodosInternos(this, cont);
        if((Integer)nodoRaiz.getElemento() == cont-1) return true;
        else return false;
    }
    
    
     /**
     * Método calcula el valor maximo de todo el AB.
     * Mediante recursividad recorre todo los nodos del AB, comprobando el valor
     * de cada uno de los nodos que recibe como parametro, si el nodo actual
     * es mayor se sobreescribe y este nuevo valor se pasa como parametro en la
     * siguiente llamada recursiva.
     * @param a
     * @param max
     * @return El valor maximo contenido en los nodos del AB.
     */
    public int maxValor(NodoBinario<E> nodo,int max ){

        if(nodo!=null){                            
            if(nodo.getElemento()>=max) max = nodo.getElemento();           
            max = maxValor(nodo.getIzq(), max);
            max = maxValor(nodo.getIzq(), max);
            return max;         
        }else return max;     
    }
    
    
    /**
     * Método lanzadera de MinimoValorNivel,
     * @param nivel
     * @return Un entero el cual es el valor minimo del valor en el nivel
     * indicado previamente.
     */
    public int minimoValorNivel(int nivel){
        
        return minimoValorNivel(nodoRaiz, 0, nivel, 
                maxValor(nodoRaiz, (int)nodoRaiz.getElemento()));
              
    }
    
    
    /**
     * Método que busca en el AB el valor minimo del nivel indicado.
     * Para ello se llama recursivamente recorriendo los nodos hasta llegar al 
     * caso base, que es cuando el nodo este vacio y tambien que este en un nivel 
     * superior al indicado. Si no se ha llegado al caso base y en la 
     * recursividad esta en el nivel deseado del arbol, comprueba el valor del 
     * nodo actual con el que se le pasa como parametro, si el valor actual es 
     * menor lo sobreescribe y lo pasa como parametro en la siguiente llamada.
     * El método en la primera llamada tiene como parametro min el maximo valor
     * del árbol (MaxValor())evitando asi pasar como primer parametro un valor 
     * aleatorio que pueda suponer un  problema o error en el método).
     * @param a
     * @param cont
     * @param nivel
     * @param min
     * @return El valor minimo del arbol.
     */
    public int minimoValorNivel(NodoBinario<E> nodo, int cont,int nivel,int min ){
 
        if(nodo!=null && cont<= nivel){
                
            if (cont == nivel){
                if(nodo.getElemento()<=min) min = nodo.getElemento();
                else min = min;
            }               
            min = minimoValorNivel(nodo.getIzq(), cont+1, nivel, min);
            min = minimoValorNivel(nodo.getDer(), cont+1, nivel, min);
            return min;

        }else return min;     
    }
    
   
    /**
     * Método lanzadera de NivelesAB
     * @return Los niveles de un arbol dado.
     */
    public int nivelesAB(){
        
        return nivelesAB(this, 0, 0);
    }
    
    
    /**
     * Método que cuenta los niveles que tiene un AB, mediante recursividad
     * va sumando 1 al contador por cada nivel que baja hasta llegar al
     * caso base, de esta forma siempre que el contador sea mayor al nivel que
     * se pasa como parametro este lo sobreescribe, asi el valor del nivel
     * se conserva durante todo el replegado y desplegado del método.
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
