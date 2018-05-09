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
public class ListaSE {
    Nodo cabeza;
    
    public ListaSE(){
        cabeza = null;
    }
    
    public boolean estaVacia(){
        return cabeza == null;
    }
    
    public void insertar(char c){
        if(estaVacia()){
            cabeza = new Nodo(c);
        }else if(!encontrado(c)) {
            Nodo nuevo = new Nodo(c);            
            nuevo.siguiente = cabeza;
            cabeza = nuevo;          
        } 
    }
    
    public boolean encontrado(char c){
        Nodo aux = cabeza;        
        while(aux != null){
            if(aux.caracter == c){
                aux.conteo++;
                return true;
            }               
            aux = aux.siguiente;
        }
        
        return false;
    }
    
    public void mostrar(){
        Nodo aux = cabeza;
        while(aux != null){
            System.out.print(aux.caracter +": "+aux.conteo +", ");
            aux = aux.siguiente;
        }
    }
    
}
