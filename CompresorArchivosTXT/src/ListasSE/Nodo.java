/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasSE;

/**
 *
 * @author Andrés
 */
public class Nodo {
    public char caracter;
    public int conteo;
    public Nodo siguiente;
    
    public Nodo(char caracter){
        this.caracter = caracter;
        this.conteo = 1;
        this.siguiente = null;
    }
    
    public Nodo(Nodo n){
        this.caracter = n.caracter;
        this.conteo = n.conteo;
        this.siguiente = n.siguiente;      
    }
 
    
}
