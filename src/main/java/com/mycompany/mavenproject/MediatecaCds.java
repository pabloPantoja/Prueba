/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Juanan
 */
public class MediatecaCds {
    
     private ArrayList <CD> miLista = null;

     public MediatecaCds(){
         miLista= new ArrayList<CD>();
         
     }
    public ArrayList<CD> getMiLista() {
        return miLista;
    }
     
     
     public  void leerFichero(String fichero){
         //String Separador=System.getProperty("file.separator");
        // C:\Users\Juanan\Documents\NetBeansProjects\Practica 5\ficheros
         //String fentrada =System.getProperty("user.dir")+"ficheros"+System.getProperty("file.separator")+"todo.txt";
         String interprete=null;
         String idalbum=null;
         String cancion=null;
         String calificacion=null;
         String album=null;
         String idcancion=null;
         CD disc=null;
         Cancion pista=null;
         
        String fentrada = "ficheros"+System.getProperty("file.separator")+fichero;
        try {
        String linea;
        BufferedReader flec;
        flec = new BufferedReader (new FileReader (fentrada));
        while(((linea = flec.readLine())!= null)){
         int inicio =0;
         boolean compositor = false;
                    boolean    idc =false;
                     boolean    ida =false;
                     boolean titulo = false;
                     boolean disco = false;
                     boolean nota = false;
         
                   
               for (int contador=0; contador < linea.length(); contador++){
                   
                   
                   
                    if ((linea.charAt(contador)=='\t') && !compositor){
                         interprete=linea.substring(inicio, contador).replace('_',' ');
                        
                         compositor=true;
                         
                         
                                }
                    else if ((linea.charAt(contador)=='\t')&& !ida){
                        
                         idalbum=linea.substring(inicio, contador);
                         ida=true;
                         
                                }
                    else if ((linea.charAt(contador)=='\t')&& !titulo){
                         
                         cancion=linea.substring(inicio, contador).replace('_',' ');
                         
                         titulo=true;
                        
                                }
                    
                    else if ((linea.charAt(contador)=='\t')&& !nota){
                         
                         calificacion=linea.substring(inicio, contador);
                         nota=true;
                         
                                }
                    else  if ((linea.charAt(contador)=='\t')&& !disco){
                         
                         album=linea.substring(inicio, contador).replace('_',' ');
                         
                         disco=true;
                       
                                }
                    else if ((contador == linea.length()-1)&& !idc){
                        
                         idcancion=linea.substring(inicio, contador+1);
                         idc=true;
                         
                                }
                    while (linea.charAt(contador)=='\t'){ //quita los espacios en blanco (tabuladores) para empezar a leer desde el siguiente caracter
                             contador++;
                             inicio=contador;
                         }
                   
}
                disc=new CD(album,interprete,Integer.parseInt(idalbum)); 
                pista=new Cancion(cancion,Double.parseDouble(calificacion));  
                   
                if (!miLista.contains(disc)){
                miLista.add(disc);
                miLista.get(miLista.indexOf(disc)).añadirCancion(pista);
                }   
                else if (!miLista.get(miLista.indexOf(disc)).incluidaCancion(pista)){
                    miLista.get(miLista.indexOf(disc)).añadirCancion(pista);
                }
                    
               
              // System.out.println(interprete.toString()+'\t'+idalbum.toString()+'\t'+cancion.toString()+'\t'+calificacion.toString()+'\t'+album.toString()+'\t'+idcancion.toString());
           
        }
        
         flec.close();
        }//try
        catch (IOException e){
        System.err.println(e);}

     }
     
      public void escribirFichero(String fichero){
         String interprete=null;
         String idalbum=null;
         String cancion=null;
         String calificacion=null;
         String album=null;
         String idcancion=null;
       
         
         String fcds = "ficheros" + System.getProperty("file.separator") + fichero;
         try{
            PrintWriter faux = new PrintWriter(new BufferedWriter(new FileWriter(fcds)));
            Iterator <CD> i = miLista.iterator();
            Iterator <Cancion> h;
            StringBuilder linea;
            CD disc;
            Cancion pista;
           
            while (i.hasNext()){
                linea=new StringBuilder();
                disc=i.next();
                idalbum=Integer.toString(disc.getIdentificador());
                interprete=disc.getInterprete().replace(' ','_');
                album=disc.getTitulo().replace(' ','_');
                h=disc.getMiLista().iterator();
                while (h.hasNext()){
                    pista=h.next();
                    cancion=pista.getTitulo().replace(' ','_');
                    calificacion=Double.toString(pista.getCalificacion());
                }
                linea.append(interprete);
                linea.append("\t");
                linea.append(idalbum);
                linea.append("\t");
                linea.append(cancion);
                linea.append("\t");
                linea.append(calificacion);
                linea.append("\t");
                linea.append(album);
                linea.append("\t");
                linea.append(idcancion);
                faux.println(linea.toString());
                }
            faux.close();
            }
        catch (IOException e){
            System.err.println(e);
        }
     }
     
     public void escribirCds(String fichero){
         
         String fcds = "ficheros" + System.getProperty("file.separator") + fichero;
         try{
            PrintWriter faux = new PrintWriter(new BufferedWriter(new FileWriter(fcds)));
            Iterator <CD> i = miLista.iterator();
            StringBuilder linea;
            CD disc;
           
            while (i.hasNext()){
                linea=new StringBuilder();
                disc=i.next();
                linea.append(disc.getIdentificador());
                linea.append("\t");
                 linea.append(disc.getInterprete());
                 linea.append("\t");
                 linea.append(disc.getTitulo());
                
                faux.println(linea);
                }
            faux.close();
            }
        catch (IOException e){
            System.err.println(e);
        }
     }
     
      public void escribirFicheroBin(String fichero){
         String fsalida = "ficheros" + System.getProperty("file.separator") + fichero;
            try {
            FileOutputStream out = new FileOutputStream(fsalida);
            ObjectOutputStream so= new ObjectOutputStream(out);
            Iterator <CD> i = miLista.iterator();
           
            CD disc;
            
            while (i.hasNext()){
                disc=i.next();
                
                so.writeObject(disc);
            
            }
            so.close();
            }
            catch (IOException ex) {
            System.err.println(ex);
            }
        
      }

      
      public void leerFicheroBin(String fichero){
        String fentrada = "ficheros" + System.getProperty("file.separator") + fichero;
        FileInputStream in = null;
        ObjectInputStream si = null;
        CD disc = null;
        
        try {
        in = new FileInputStream(fentrada);
        si = new ObjectInputStream(in);
        
              
        }
        catch (FileNotFoundException ex) {
            System.out.println("a");
        System.err.println(ex);
        }
        catch (IOException ex) {
             System.out.println("b");
        System.err.println(ex);
        }
        try {
         
        disc=(CD)si.readObject();
        while(disc!=null){
        miLista.add(disc);
        disc=(CD)si.readObject();
        
        }
        }
        catch (IOException ex) {
             System.out.println("c");
        System.err.println(ex);
        }
        catch (ClassNotFoundException ex) {
             System.out.println("d");
        System.err.println(ex);
        }
        try {
        si.close();
        }
        catch (IOException ex) {
             System.out.println("f");
        System.err.println(ex);
        }

      }       
     public void mejoresCanciones(String fichero){
         
         String fcds = "ficheros" + System.getProperty("file.separator") + fichero;
         try{
            PrintWriter faux = new PrintWriter(new BufferedWriter(new FileWriter(fcds)));
            Iterator <CD> i = miLista.iterator();
            StringBuilder linea;
            ArrayList<Cancion> lista;
            Cancion pista;
           CD disc;
            while (i.hasNext()){
                
                disc=i.next();
                lista=disc.obtenerLista(disc.mediaCalificaion(disc));
                Iterator <Cancion>h=lista.iterator();
                while (h.hasNext()){
                    linea=new StringBuilder();
                    pista=h.next();
                    linea.append(pista.getTitulo());
                    linea.append("\t");
                    linea.append(String.format("%.2f",pista.getDuracion()));
                    linea.append("\t");
                    linea.append(String.format("%.1f",pista.getCalificacion()));
                    linea.append("\t");
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    linea.append(df.format(pista.getFecha().getTime()));
                    faux.println(linea);
                    }
                }
            faux.close();
            }
        catch (IOException e){
            System.err.println(e);
        }
     }
     
      public String toString(){  
          String info;
          StringBuilder infoBuilder= new StringBuilder();
          Iterator <CD>i = miLista.iterator();
          CD disc;
          int numcd;
          
          numcd=1;
          while(i.hasNext()){ 
            disc=i.next();
          infoBuilder.append("CD ");
          infoBuilder.append(String.valueOf(numcd++));
          infoBuilder.append(":");
          infoBuilder.append("\n");
          infoBuilder.append(disc.toString());
          
          infoBuilder.append("\n");
          infoBuilder.append("\n");
          }
          info=infoBuilder.toString();
          return info;
          }
      
}
        