/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Andrés Sanabria & Erick Daniel Salazar
 */
public class Nodo {
    public Integer dato;
    public Nodo izq;
    public Nodo der;
    
    //Constructor
    public Nodo(Integer dato){
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
    
}
