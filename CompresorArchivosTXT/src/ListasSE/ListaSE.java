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
    int lenght;
    
    public ListaSE(){
        cabeza = null;
        lenght = 0;
    }
    
    public boolean estaVacia(){
        return cabeza == null;
    }
    
    public void insertar(char c){
        if(estaVacia()){
            cabeza = new Nodo(c);
            lenght++;
        }else if(!encontrado(c)) {
            Nodo nuevo = new Nodo(c);            
            nuevo.siguiente = cabeza;
            cabeza = nuevo;   
            lenght++;
        } 
    }
    
    public Nodo getNodo(int index){
        Nodo aux = cabeza; 
        if(index<lenght){
            for (int i = 0; i < index; i++) {
                aux = aux.siguiente;
            }
            Nodo r = new Nodo(aux);
            return r;
        } else{
            return null;
        }      
    }
    
    public void setNodo(int index, Nodo n){
        Nodo aux = cabeza; 
        if(index<lenght){
            for (int i = 0; i < index; i++) {  
                aux = aux.siguiente;
            }
            aux.caracter = n.caracter;
            aux.conteo = n.conteo;     
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
