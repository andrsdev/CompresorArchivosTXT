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
public class Sort {

    /*Esta implementación del quicksort permite hacer su llamada pasando
    * como parámetro únicamente el vector a ordenar en su llamada principal.
    * quicksortHelper hace el procedimiento recursivo típico del alogrimto.
    */
    
    public static void quicksort(ListaSE v) {
        quicksortHelper(v, 0, v.lenght - 1);
    }
    
    private static void quicksortHelper(ListaSE v, int p, int n)
    {
        int pos;
        if (p < n)
        {
            pos = p;
            for (int i = p; i <= n; i++){
                if (v.getNodo(i).conteo < v.getNodo(n).conteo)
                {
                    intercambiar(v, i, pos);
                    pos++;
                }
            }

            intercambiar(v, pos, n);
           
            quicksortHelper(v, p, pos - 1);
            quicksortHelper(v, pos + 1, n);

        }
    }
        

    
    public static void selectionSort1(ListaSE v){
        int n = v.lenght;
        int pos;
        
        for (int i = 0; i < n; i++) {
            pos = i;
            for (int j = i + 1; j < n; j++) {
                if(v.getNodo(pos).conteo <v.getNodo(j).conteo)
                    pos = j;
            }
            
            intercambiar(v, i, pos);

        }
    }
    
   
    
    public static void intercambiar(ListaSE v,int a, int b)
    {
        Nodo t = v.getNodo(a);
        v.setNodo(a, v.getNodo(b));
        v.setNodo(b, t); 
    }
}
