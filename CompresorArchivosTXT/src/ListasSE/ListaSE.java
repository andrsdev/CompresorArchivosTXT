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
    
    //Inserta un nuevo nodo en la cabeza de la lista
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
    
    //Elimina un nodo de la lista
    public void eliminar(Nodo n){
        if (n!= null){
            Nodo aux = cabeza;
            Nodo anterior = null;
            while(aux != null && aux.caracter != n.caracter){
                anterior = aux;
                aux = aux.siguiente;
            }

            if (aux != null && anterior != null){
                anterior.siguiente = aux.siguiente; 
            }else if (anterior == null){
                cabeza = aux.siguiente;
            }else{
                anterior.siguiente = null;    
            }
        }
    
    }
    
    //Inserta un nodo en su posición ordenada de acuerdo al conteo de caracteres
    public void insertarPos(Nodo n, int p){
        Nodo aux = cabeza;
        Nodo anterior = null;
        while(aux != null && aux.conteo < n.conteo){
            anterior = aux;
            aux = aux.siguiente;
        }
        
        if (anterior != null){
            anterior.siguiente = n;
            n.siguiente = aux;
        } else{
            n.siguiente = aux;
            cabeza = n;
        }
        
    }
    
    //Devuelve una copia de un nodo por medio de su índice
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
    
    //Modifica los valores de un nodo por medio de su índice
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
    
    //Verifica si un nodo ya existe denro de la lista. Si ya existe, se suma
    //Al conteo de ese nodo.
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
    
    //Fusiona la lista de acuerdo al algoritmo de Hoffman creando un árbol bianrio
    public void fusionar(){
        Nodo aux = cabeza;   
        while(lenght>1){
            aux = cabeza;
            Nodo nuevo = new Nodo();
            nuevo.izq = aux;
            nuevo.der = aux.siguiente;
            nuevo.conteo = nuevo.izq.conteo + nuevo.der.conteo;         
            eliminar(aux);
            eliminar(aux.siguiente);          
            insertarPos(nuevo, nuevo.conteo); 
            
            lenght--;
        }
        
    }
    
    //Muestra la lista con los contes de cada nodo
    public void mostrar(){
        System.out.println();
        Nodo aux = cabeza;
        while(aux != null){
            System.out.print(aux.caracter +": "+aux.conteo +", ");
            aux = aux.siguiente;
        }
    }
    
}
