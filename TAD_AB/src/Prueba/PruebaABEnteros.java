/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import AB.ABEnteros;
import AB.NodoBinario;

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
        //TODO
    }
    
    public void comprobarABB(){
        //TODO
    }
    
    public void siRaizIgualNodosInternos(){
        //TODO
    }
    
    public void eliminarNodosInferiores(int nivel){
        //TODO
    }
    
    public void mostrarMinimoValorNivel(){
        //TODO
    }
    
    public void preorden(){
        System.out.println("AB1 en preorden: ");
        aB1.preorden(aB1);
    }
    
}
