/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.util.ArrayList;

/**
 *
 * @author Juanan
 */
public class Practica5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         MediatecaCds mediateca= new MediatecaCds();
         MediatecaCds mediateca2= new MediatecaCds();
         MediatecaCds mediateca3= new MediatecaCds();
        mediateca.leerFichero("todo2.txt");
      //  System.out.println(mediateca);
        
        mediateca.escribirCds("cds.txt");
        System.out.println(1);
        mediateca.mejoresCanciones("mejorescanciones.txt");
        mediateca.escribirFicheroBin("cd.dat");
        System.out.println(2);
        mediateca2.leerFicheroBin("cd.dat");
         System.out.println(3);
        // System.out.println(mediateca2);
          System.out.println(4);
         mediateca2.escribirFichero("todo2.txt");
          System.out.println(5);
          mediateca3.leerFichero("todo2.txt");
          System.out.println(6);
           mediateca3.escribirCds("cds2.txt");
           Cancion prueba = new Cancion("where eagles dare",5.6);
           System.out.println(4);
         
        
    }
}
