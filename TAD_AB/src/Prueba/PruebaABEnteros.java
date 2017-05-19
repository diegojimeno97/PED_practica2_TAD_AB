/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import AB.ABEnteros;

/**
 *
 * @author Diego
 */
public class PruebaABEnteros {
    
    
    private ABEnteros<Integer> aB1;
    private ABEnteros<Integer> aB2;
    
    public PruebaABEnteros(){}
    
    public void CrearAB1(){
        aB1 = new ABEnteros();
        aB1 = aB1.crearAB1();
    }
    
    public void CrearAB2(){
        aB2 = new ABEnteros();
        aB2 = aB2.crearAB2();
    }
    
    public void comprobarABB(){
        System.out.print("AB1");
        if(!aB1.EsABB(aB1)) System.out.print(" no");
        System.out.println(" es Árbol Binario de Búsqueda");
        System.out.print("AB2");
        if(!aB2.EsABB(aB2)) System.out.print(" no");
        System.out.println(" es Árbol Binario de Búsqueda");
        
    }
    
    public void siRaizIgualNodosInternos(){
        System.out.print("AB1: ");
        if(aB1.RaizIgualNodosInternos(aB1)) System.out.println(" Raiz igual al número de nodos internos");
        else System.out.println("La raíz no es igual al numero de nodos internos");
        System.out.print("AB2: ");
        if(aB2.RaizIgualNodosInternos(aB2)) System.out.println(" Raiz igual al número de nodos internos");
        else System.out.println("La raíz no es igual al numero de nodos internos");
    }
    
    public void eliminarNodosInferiores(int nivel){
        //TODO
    }
    
    public void mostrarMinimoValorNivel(){
        //TODO
    }
    
    public void preordenAB1(){
        System.out.println("AB1 en preorden: ");
        aB1.preorden(aB1);
        System.out.println("");
    }
    
    
    public void inordenAB2(){
        System.out.println("AB2 en inorden: ");
        aB2.inorden(aB2);
        System.out.println("");
    }
    
}
