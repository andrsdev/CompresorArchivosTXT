/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresorarchivostxt;

import java.io.*;
import java.util.Scanner;
import ListasSE.*;


/**
 *
 * @author Andrés Sanabria y Erick Salazar
 */
public class CompresorArchivosTXT {
    
    public static ListaSE lista = new ListaSE();
    public static String inputPath = System.getProperty("user.dir") + "\\files\\archivo.txt";
    public static String outputPath = System.getProperty("user.dir") + "\\files\\archivoComprimido.txt";
    
    public static String txtOriginal = "";
    public static String txtBinario = "";
    
    
    public static long tamanoOriginal =0;
    public static long tamanoCompreso =0;
    
    
    public static void main(String[] args) {

        leer();
        Sort.quicksort(lista);  
        lista.fusionar();        
        escribir();

    }
    
    public static void leer(){
        BufferedReader br = null;
        //Lectura de archivo.txt y creación de la lista.
        try {      
            File inputFile = new File(inputPath);
            br = new BufferedReader(new FileReader(inputFile));   
            String line = br.readLine();
            
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    lista.insertar(line.charAt(i)); 
                    txtOriginal+= line.charAt(i);
                }
                
                line = br.readLine();    
            }
            tamanoOriginal = inputFile.length();
            br.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");
        }
        
    }
    
    public static void escribir(){
        FileOutputStream bw= null;
        
       
        //COnvertimos el texto original a binario
        for (int i = 0; i < txtOriginal.length(); i++) {
            txtBinario+=lista.obtenerCodigo(lista.cabeza,txtOriginal.charAt(i)) ;
        }
        
        
        //Escribimos en el nuevo archivo en bytes el texto binario
        try {       
            File outputFile = new File(outputPath);
            bw = new FileOutputStream(outputFile);
            
            for (int i = 0; i < txtBinario.length()-8; i+= 8) {
                byte b = (byte) Integer.parseInt(txtBinario.substring(i, i+8));
                bw.write(b);
            }
            tamanoCompreso = outputFile.length();
            bw.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");           
        }    
        

                   
        
        System.out.println("El texto original es: ");
        System.out.println(txtOriginal);
        System.out.println("Tamaño en bytes: " + tamanoOriginal);
        
        System.out.println();
        
        System.out.println("El texto en bits es: ");
        System.out.println(txtBinario);
        System.out.println("Tamaño en bytes: " + tamanoCompreso);
        
        
        
    }
    
}
