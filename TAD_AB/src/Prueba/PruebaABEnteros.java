
package Prueba;


import AB.*;
import excepciones.ArbolVacioExcepcion;
import java.io.IOException;
import java.util.Scanner;

public class PruebaABEnteros {
    
    
    private ABEnteros<Integer> AB1;
    private ABEnteros<Integer> AB2;
    
    public PruebaABEnteros(){}
    
    /**
     * Crear el arbol AB1 propuesto en la práctica.
     */
    public void crearAB1(){
        
        ABEnteros hd2 = new ABEnteros(18);
        ABEnteros hi2 = new ABEnteros(3);
        ABEnteros hi1 = new ABEnteros(17,hi2,hd2);
        ABEnteros hd1 = new ABEnteros(19);
        ABEnteros hi = new ABEnteros(71,hi1,hd1);
        ABEnteros hd4 = new ABEnteros(110);
        ABEnteros hi3 = new ABEnteros(108,null,hd4);
        ABEnteros hd3 = new ABEnteros(245);
        ABEnteros hd = new ABEnteros(240,hi3,hd3);
        AB1 = new ABEnteros(104, hi, hd);
        System.out.println("\nÀrbol AB1 creado.");
        
    }
    
    
    /**
     * Crear el arbol AB2 propuesto en la práctica.
     */
    public void crearAB2(){
        
        ArbolBinario hi1 = new ABEnteros(0);
        ArbolBinario hi = new ABEnteros(1,hi1,null);
        ArbolBinario hi3 = new ABEnteros(3);
        ArbolBinario hd3 = new ABEnteros(7);
        ArbolBinario hd = new ABEnteros(5,hi3,hd3);
        AB2 = new ABEnteros(2, hi, hd);
        System.out.println("\nÀrbol AB2 creado.");
    }
    
    /**
     * Metodo que llama a la función EsABB para los arboles AB1 y AB2 de la 
     * clase ABEnteros, y nos indica si los arboles son o no árboles binarios de
     * búsqueda.
     */
    public void comprobarABB(){
        System.out.print("\nAB1 ");
        if(!AB1.esABB()) System.out.print("No ");
        System.out.println("es Árbol Binario de Búsqueda");
        System.out.print("\nAB2 ");
        if(!AB2.esABB()) System.out.print("No ");
        System.out.println("es Árbol Binario de Búsqueda");
        pausa();
    }
    
    /**
     * Método que llama a la función raizIgualNodosInternos de la clase 
     * ABEnteros, y nos indica para AB1 y AB2 si la raíz es igual al numero de 
     * nodos internos.
     */
    public void siRaizIgualNodosInternos(){
        System.out.print("\nAB1: ");
        if(AB1.RaizIgualNodosInternos()) 
          System.out.println("Raiz igual al número de nodos internos.");
        else 
         System.out.println("La raíz no es igual al numero de nodos internos.");
        
        System.out.print("\nAB2: ");
        if(AB2.RaizIgualNodosInternos()) 
          System.out.println("Raiz igual al número de nodos internos.");
        else 
         System.out.println("La raíz no es igual al numero de nodos internos.");
        
        pausa();
    }
    
    public void eliminarNodosInferiores(String s,int nivel){
        
        //int nivel = indicarNivel("para eliminar sus nodos inferiores");
        switch(s){
            case "AB1" : AB1.EliminarNodosInferiores(nivel);
            System.out.println("\n->Nodos Inferiores al nivel "+nivel+" del "
                    + "árbol AB1 eliminados!");
            System.out.println("AB1 en InOrden: ");
            AB1.inorden(this.AB1); break;
   
            case "AB2" : AB2.EliminarNodosInferiores(nivel);
            System.out.println("\n->Nodos Inferiores al nivel "+nivel+" del "
                    + "árbol AB2 eliminados!");
            System.out.println("AB1 en InOrden: ");
            AB2.inorden(this.AB2); break;
        }
        pausa();
    }
    
  
    /**
     * Metodo que muestra por pantalla el valor minimo de los árboles AB1 y AB2,
     * para ello previamente pide introducir el nivel deseado.
     */
    public void mostrarMinimoValorNivel(){
        int nivel = indicarNivel("para mostra su valor minimo");
        
        if(nivel<=AB1.nivelesAB())
        System.out.println("Árbol AB1: El valor mínimo obtenido en el nivel "
                +nivel+" es: "+AB1.minimoValorNivel(nivel));
        else System.out.println("ERROR: no existen "+nivel+" niveles en el "
                + "árbol AB1. El árbol tiene "+AB1.nivelesAB()+" niveles");
        
        if(nivel<=AB2.nivelesAB())
        System.out.println("Árbol AB2: El valor mínimo obtenido en el nivel "
                +nivel+" es: "+AB2.minimoValorNivel(nivel));
        else System.out.println("ERROR: no existen "+nivel+" niveles en el "
                + "árbol AB2. El árbol tiene "+AB2.nivelesAB()+" niveles");
        
        pausa();
        
    }
    
    /**
     * Imprime en preorden de forma recursiva el árbol AB1.
     */
    public void preordenAB1(){
        System.out.println("\nAB1 en PreOrden: ");
        AB1.preorden(this.AB1);
        pausa();

    }
    
    /**
     * Imprime en inorden de forma recursiva el árbol AB2.
     */
    public void inordenAB2(){
        System.out.println("\nAB2 en InOrden: ");
        AB2.inorden(this.AB2);
        pausa();
    }
    
    
    
    /**
     * Metodo auxiliar que pide introducir un nivel.
     * @param s
     * @return Un int que representa al nivel del arbol.
     */
    public int indicarNivel(String s){
        boolean continuar = true;
        String opcion = "";
        do{
        Scanner entrada = new Scanner (System.in);
        System.out.println("\nIndique el nivel para "+s+" : ");
        opcion = entrada.nextLine ();
        try{
            if(opcion.isEmpty()||opcion.matches(".*[^0-9].*"))
              throw new ArbolVacioExcepcion("\t->El nivel debe ser un número.");  
            continuar = false;
                
            }catch(ArbolVacioExcepcion ex){
                System.out.println(ex.getMessage());
                continuar = true;
            }
        }while(continuar);
        
        return Integer.parseInt(opcion);
    }
    
    
    
    
     /**
     * Método que muestra por pantalla un mensaje de salia.
     */
    public void salir(){
        System.out.println
        ("\n\tGracias por utilizar nuestro TAD ");
    }
    
     
    /**
     * Método que nos sirve para realizat la función de pausa.
     */ 
    public void pausa(){
        try {
           System.out.println("\nPulse <Intro> para continuar...");
           int read = System.in.read();
        } catch (IOException ex) {}
        System.out.println("\n");
    }
    
}
