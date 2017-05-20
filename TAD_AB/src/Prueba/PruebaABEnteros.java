/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;


import AB.*;

/**
 *
 * @author Diego
 */
public class PruebaABEnteros {
    
    
    private ABEnteros<Integer> aB1;
    private ABEnteros<Integer> aB2;
    
    public PruebaABEnteros(){}
    
    public void CrearAB1(){
        
        ABEnteros hd2 = new ABEnteros(18);
        ABEnteros hi2 = new ABEnteros(3);
        ABEnteros hi1 = new ABEnteros(17,hi2,hd2);
        ABEnteros hd1 = new ABEnteros(19);
        ABEnteros hi = new ABEnteros(71,hi1,hd1);
        ABEnteros hd4 = new ABEnteros(110);
        ABEnteros hi3 = new ABEnteros(108,null,hd4);
        ABEnteros hd3 = new ABEnteros(245);
        ABEnteros hd = new ABEnteros(240,hi3,hd3);
        aB1 = new ABEnteros(104, hi, hd);
        
    }
    
    public void CrearAB2(){
        aB2 = new ABEnteros();
        aB2 = aB2.crearAB2();
    }
    
    public void comprobarABB(){
        System.out.print("AB1");
        if(!aB1.EsABB()) System.out.print("No ");
        System.out.println("Es Árbol Binario de Búsqueda");
        System.out.print("AB2");
        if(!aB2.EsABB()) System.out.print("No ");
        System.out.println("Es Árbol Binario de Búsqueda");
        
    }
    
    public void siRaizIgualNodosInternos(){
        System.out.print("AB1: ");
        if(aB1.RaizIgualNodosInternos()) 
          System.out.println("Raiz igual al número de nodos internos");
        else 
          System.out.println("La raíz no es igual al numero de nodos internos");
        
        System.out.print("AB2: ");
        if(aB2.RaizIgualNodosInternos()) 
          System.out.println("Raiz igual al número de nodos internos");
        else 
          System.out.println("La raíz no es igual al numero de nodos internos");
    }
    
    public void eliminarNodosInferiores(int nivel){
        //TODO
    }
    
    public void mostrarMinimoValorNivel(){
        System.out.println("El minimo valor de AB1 en el nivel"+2+" es: "
                +aB1.MinimoValorNivel(2));
        System.out.println("El minimo valor de AB1 en el nivel"+1+" es: "
                +aB2.MinimoValorNivel(1));
        
    }
    
    public void preordenAB1(){
        System.out.println("AB1 en preorden: ");
        aB1.preorden(this.aB1);
        System.out.println("");
    }
    
    
    public void inordenAB2(){
        System.out.println("AB2 en inorden: ");
        aB2.inorden(this.aB2);
        System.out.println("");
    }
    
}
