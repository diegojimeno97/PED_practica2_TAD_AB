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
        ABEnteros hd2 = new ABEnteros(18);
        ABEnteros hi2 = new ABEnteros(3);
        ABEnteros hi1 = new ABEnteros(17,hi2,hd2);
        ABEnteros hd1 = new ABEnteros(19);
        ABEnteros hi = new ABEnteros(71,hi1,hd1);
        ABEnteros hd4 = new ABEnteros(110);
        ABEnteros hi3 = new ABEnteros(108,null,hd4);
        ABEnteros hd3 = new ABEnteros(245);
        ArbolBinario hd = new ABEnteros(240,hi3,hd3);//revisar
        /*ABEnteros hi = new ABEnteros(71);
        ABEnteros hd = new ABEnteros(240);*/
        aB1 = new ABEnteros(104, hi, hd);
        return aB1;
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
    
    public boolean EsABB(ArbolBinario<Integer> a){ //comprobar
       boolean busqueda = true;
       busqueda = EsABB(a,busqueda);
       return busqueda;
    }
    
    private int RaizIgualNodosInternos(ArbolBinario<Integer> a, int cont){ //comprobar
        if(!a.esVacio()){
            if(!a.hijoIzq().esVacio() && !a.hijoDer().esVacio()){
                    cont = RaizIgualNodosInternos(a.hijoIzq(), cont+1);
                    cont = RaizIgualNodosInternos(a.hijoDer(), cont+1);
            } else return cont;
        }
        return cont;
    }
    
    public boolean RaizIgualNodosInternos(){ //comprobar
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
