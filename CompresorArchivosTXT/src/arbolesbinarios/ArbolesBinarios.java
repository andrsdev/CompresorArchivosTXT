/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.Scanner;
/**
 *
 * @author Andrés Sanabria & Erick Salazar
 */
public class ArbolesBinarios {

    public static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {
        
        ArbolBinario arbol = new ArbolBinario();

        //Insertamos algunos elementos al árbol
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(1);     
        
  
        System.out.println("El formato inOrder es: " + arbol.inOrder());
        System.out.println("El formato preOrder es: " + arbol.preOrder());
        System.out.println("El formato postOrder es: " + arbol.postOrder());
        
        System.out.println();
        
        System.out.println("La cantidad de nodos son: " + arbol.contar());
        System.out.println("La cantidad de hojas es: " + arbol.hojas());
        System.out.println("La profundidad del árbol es: " + arbol.profundidad());
        
        System.out.println();
             
        System.out.println("Ingrese un número que desea buscar: ");
        Integer num = read.nextInt();
        
        if(arbol.buscar(num))
            System.out.println("Se ha encontrado el número");
        else
            System.out.println("No se ha encontrado el número");
    }
    
}
