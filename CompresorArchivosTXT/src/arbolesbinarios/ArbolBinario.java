/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Andrés Sanabria & Erick Salazar
 */
public class ArbolBinario {
    
    //Declaración de nodo raiz.
    private Nodo nodo;
    
    //Constructor
    public ArbolBinario(){
        this.nodo = null;       
    }
    
    public boolean estaVacio(){
        return nodo == null;
    }
    
    //Procedimiento para insertar un elemento
    public void insertar(Integer dato){
        if(estaVacio()){
            nodo = new Nodo(dato);
            
        } else {
            Nodo nuevo = new Nodo(dato);          
            Nodo aux = nodo;

            //Recorremos el árbol para insertar el nodo en la posición adecuada.  
            while((aux.izq != nuevo) && (aux.der != nuevo)){
                if(aux.dato > dato){                   
                    if (aux.izq != null)
                        aux = aux.izq;
                    else
                        aux.izq = nuevo;                       
                }                                     
                else{                
                    if (aux.der != null)
                        aux = aux.der;
                    else
                        aux.der = nuevo;                      
                }               
            }
        }              
    }
    
    //Búsqueda de un elemento por las ramas del árbol.
    public boolean buscar(Integer dato){
        Nodo aux = nodo;
        
        while(aux != null){          
            if(aux.dato == dato){                   
                return true;
            }                                     
            else{                
                if (aux.dato > dato)
                    aux = aux.izq;
                else
                    aux = aux.der;                      
            }               
        }      
        return false;       
    }
    
    //Mostrar el árbol en formato "inOrder"
    public String inOrder(){
        return inOrderH(this.nodo);
    }
    
    private String inOrderH(Nodo n){    
        if (n == null)
            return "";
        else
            return inOrderH(n.izq) + n.dato + ", " + inOrderH(n.der);
    }
    
    //Mostrar el árbol en formato "preOrder"
    public String preOrder(){
        return preOrderH(this.nodo);
    }
   
    private String preOrderH(Nodo n){
        
        if (n == null)
            return "";
        else
            return n.dato + ", " + preOrderH(n.izq) + preOrderH(n.der);
    }
    
    //Mostrar el árbol en formato "postOrder"
    public String postOrder(){
        return postOrderH(this.nodo);
    }
       
    private String postOrderH(Nodo n){
        
        if (n == null)
            return "";
        else
            return  postOrderH(n.izq) + postOrderH(n.der) + n.dato + ", ";
    }
    
    //Devuelve el conteo de la cantidad de elementos del árbol.
    public Integer contar(){
        return contarH(this.nodo);
    }
    
    private Integer contarH(Nodo n){
        if(n == null)
            return 0;
        else
            return 1 + contarH(n.izq) + contarH(n.der);       
    }
    
    //Devuelve el conteo de la cantidad de hojas del árbol.
    public Integer hojas(){
        return hojasH(this.nodo);
    }
      
    private Integer hojasH(Nodo n){   
        if(n == null)
            return 0;
        else if((n.izq == null) && (n.der == null))
            return 1;
        else
            return hojasH(n.izq) + hojasH(n.der);
    }
    
    //Devuelve el nivel máximo de profundidad del árbol.
    public Integer profundidad(){
        return profundidadH(this.nodo);
    }
    
    private Integer profundidadH(Nodo n){
        if (n== null)
            return 0;
        else if(profundidadH(n.izq) > profundidadH(n.der))
            return 1 + profundidadH(n.izq);
        else
            return 1 + profundidadH(n.der);
    }
    
    
}
