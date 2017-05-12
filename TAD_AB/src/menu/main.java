/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;
import excepciones.*;
/**
 *
 * @author Diego
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    /**
     * Main muestra por pantalla de forma repetitiva el menú de opciones.
     * En el metodo se controla que las opciones 2..8 del menú sólo puedan
     * ser ejecutadas si con anterioridad se ha ejecutado la opción 1.
     * @param args Main
     */
    
   
       
        Scanner entrada = new Scanner (System.in);
        //PruebaABEnteros operacion = new PruebaABEnteros();
        boolean continuar = true;
        boolean listaCreada = false;
        
        do{
            System.out.println("\t+++++ MENÚ AB +++++");
            System.out.println("1. Crear AB1 y AB2");
            System.out.println("2. Listado claves AB1 PreOrder");
            System.out.println("3. Listado claves AB2 InOrder");
            System.out.println("4. Comprobar si AB1 y AB2 son ABB");
            System.out.println("5. Mostrar si Raiz es igual a Nodos Internos en "
                    + "AB1 y AB2");
            System.out.println("6. En AB1 Eliminar los nodos por debajo del "
                    + "Nivel 2 y Mostrar listado claves InOrder");
            System.out.println("7. En AB2 Eliminar los nodos por debajo del "
                    + "Nivel 3 y Mostrar listado claves InOrder");
            System.out.println("8. Mostrar el valor minimo en el "
                    + "nivel indicado de AB1 y AB2");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            String opcion = entrada.nextLine ();
            
            try{
                if(opcion.isEmpty()||opcion.matches(".*[^0-9].*")) 
                  throw new ArbolVacioExcepcion("\t->Seleccionar una opción [0-8].");

                else if(!listaCreada&&Integer.parseInt(opcion)>1){ 
                  opcion = "9";
                  throw new ArbolVacioExcepcion("\t->¡Primero debe crear los AB!");
                }
            }catch(ArbolVacioExcepcion ex){
                System.out.println(ex.getMessage());
                //prueba.pausa();
            }
            
            switch(opcion){
                
                case "1": ;break;
                            
                case "2":  break;
                
                case "3":  break;
                
                case "4":  break;
            
                case "5": break;
                
                case "6":  break;
                
                case "7": break;
            
                case "8":  break;
                
                case "0":  break;
                
                default: continuar = true; break;
                               
            }
            
        }while(continuar); 
    }
    
    
    
}
