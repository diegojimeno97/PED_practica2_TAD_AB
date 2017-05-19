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
    
    public ABEnteros(E elemRaiz) {
        super(elemRaiz);
    }
    
    public ABEnteros() {}
    
    public ABEnteros crearAB1(){
        ABEnteros aB1;
        ArbolBinario hd2 = new ABEnteros(18);
        ArbolBinario hi2 = new ABEnteros(3);
        ArbolBinario hi1 = new ABEnteros(17,hi2,hd2);
        ArbolBinario hd1 = new ABEnteros(19);
        ArbolBinario hi = new ABEnteros(71,hi1,hd1);
        ArbolBinario hd4 = new ABEnteros(110);
        ArbolBinario hi3 = new ABEnteros(108,null,hd4);
        ArbolBinario hd3 = new ABEnteros(245);
        ArbolBinario hd = new ABEnteros(240,hi3,hd3);
        aB1 = new ABEnteros(104, hi, hd);
        return aB1;
    }
    
    public ABEnteros crearAB2(){
        ABEnteros aB2;
        ArbolBinario hi1 = new ABEnteros(0);
        ArbolBinario hi = new ABEnteros(1,hi1,null);
        ArbolBinario hi3 = new ABEnteros(3);
        ArbolBinario hd3 = new ABEnteros(7);
        ArbolBinario hd = new ABEnteros(5,hi3,hd3);
        aB2 = new ABEnteros(2, hi, hd);
        return aB2;
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
    
    public boolean EsABB(ArbolBinario<Integer> a){ 
       boolean busqueda = true;
       busqueda = EsABB(a,busqueda);
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
    
    public boolean RaizIgualNodosInternos(ArbolBinario<Integer> a){ 
        int cont = 0;
        cont = RaizIgualNodosInternos(a, cont);
        if((Integer)raiz() == cont-1) return true;
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
