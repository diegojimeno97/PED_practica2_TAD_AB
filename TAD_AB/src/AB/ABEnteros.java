/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB;

/**
 *
 * @author Home
 */
public class ABEnteros<E extends Integer> extends EnlazadoArbolBinario{
    
    public ABEnteros(E elemRaiz, ArbolBinario<E> hi,
            ArbolBinario<E> hd) {
        super(elemRaiz,hi,hd);
    }
    
    public void crearAB1(){
        
    }
    
    public void crearAB2(){
        //TODO
    }
    
    
    private boolean EsABB(ArbolBinario<Integer> a, boolean busqueda) { //comprobar
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
    
    public boolean EsABB(ArbolBinario<Integer> a){
       boolean busqueda = true;
       busqueda = EsABB(a,busqueda);
       return busqueda;
    }
    
    private int RaizIgualNodosInternos(ArbolBinario<Integer> a, int cont){
        if(!a.esVacio()){
            if(!a.hijoIzq().esVacio() && !a.hijoDer().esVacio()){
                    cont = RaizIgualNodosInternos(a.hijoIzq(), cont+1);
                    cont = RaizIgualNodosInternos(a.hijoDer(), cont+1);
            } else return cont;
        }
        return cont;
    }
    
    public boolean RaizIgualNodosInternos(){
        int cont = 0;
        cont = RaizIgualNodosInternos((ArbolBinario<Integer>)raiz(), cont);
        if((Integer)raiz() == cont) return true;
        else return false;
    }
    
    public void MinimoValorNivel(){
        //TODO
    }
    
    public int NivelesAB(){
        //TODO
        return 1;
    }
    
    
    
    
}
