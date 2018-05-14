/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresorarchivostxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//import arbolesbinarios.*;
import ListasSE.*;

/**
 *
 * @author Andrés Sanabria y Erick Salazar
 */
public class CompresorArchivosTXT {
   
 
    
    public static void main(String[] args) {
        
        ListaSE lista = new ListaSE();
        String inputPath = System.getProperty("user.dir") + "\\files\\archivo.txt";
     
        BufferedReader br = null;
        
        //Lectura de archivo.txt y creación de la lista.
        try {      
            br = new BufferedReader(new FileReader(inputPath));   
            String line = br.readLine();
            
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    lista.insertar(line.charAt(i));                  
                }
                
                line = br.readLine();    
            }

            br.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");
        }
   

       
        
        Sort.quicksort(lista);  
        
        lista.mostrar();
        System.out.println(); 
        
        lista.fusionar();
        lista.codificar();
        lista.mostrar();
           
    }
    
}
