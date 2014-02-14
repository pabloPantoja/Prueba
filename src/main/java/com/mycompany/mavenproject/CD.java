/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
 *
 * @author Juanan
 */
public class CD implements Serializable{
    
    private String titulo;
    private String interprete;
    private int identificador;
    private int año;
    private String Compañia;
    private ArrayList <Cancion> miLista = null;
    
    
    
    
    public CD (String titulo, String interprete, int identificador){
       this.titulo=titulo;
       this.interprete=interprete;
       this.identificador=identificador;
       miLista= new ArrayList <Cancion>();
    }
    
      public CD (String titulo, String interprete, int identificador,ArrayList <Cancion> lista){
       this.titulo=titulo;
       this.interprete=interprete;
       this.identificador=identificador;
       
       miLista= new ArrayList <Cancion>();
       if (lista!=null){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
        Iterator <Cancion>i = lista.iterator();
        Iterator <Cancion>h;
        Cancion pistaLista=null;
        Cancion pistaCD=null;
        while(i.hasNext()){ 
         pistaLista=i.next();
         h = miLista.iterator(); 
         boolean encontradoTitulo =false; // booleano utilizado para detectar una cancion del cd con el mismo nombre que una de la lista
         pistaCD=null;//inicializamos a cero para recorrer desde el principio la lista del cd en busca de canciones con el mismo titulo 
          while(h.hasNext() && !encontradoTitulo){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=h.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              encontradoTitulo=pistaCD.igualTitulo(pistaLista.getTitulo());
          }
          if (!encontradoTitulo) { //si no se ha encontrado en el cd una cancion con el mismo nombre se añade a la lista del cd
              miLista.add(pistaLista);
          } 
        } //while
         }//if
       } //constructor
       
       // METODOS
       public String ToStringCd(){
          String disco;
          StringBuilder infoBuilder= new StringBuilder();
           infoBuilder.append("Titulo: ");
          infoBuilder.append(titulo);
          infoBuilder.append("\t");
          infoBuilder.append("Interprete: ");
          infoBuilder.append(interprete);
          infoBuilder.append("\t");
          infoBuilder.append("Identificador: ");
          infoBuilder.append(identificador);
          disco=infoBuilder.toString();
          return disco;
           
       }
       public String toString(){  
          String info;
          StringBuilder infoBuilder= new StringBuilder();
          infoBuilder.append(this.ToStringCd());
          Iterator <Cancion>i = miLista.iterator();
          Cancion pista;
          int numpista=1;
          infoBuilder.append("\n");
          infoBuilder.append("Listado de canciones: ");
          while(i.hasNext()){ 
            pista=i.next();
            infoBuilder.append("\n");
            infoBuilder.append(String.valueOf(numpista++));
            infoBuilder.append(". ");
            infoBuilder.append(pista.toString());
           }
          
          info=infoBuilder.toString();
          return info;
          }

    public String getTitulo() {
        return titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public int getIdentificador() {
        return identificador;
    }

    public ArrayList<Cancion> getMiLista() {
        return miLista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setMiLista(ArrayList<Cancion> lista) {
        if (lista!=null){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
        Iterator <Cancion>i = lista.iterator();
        Iterator <Cancion>h;
        Cancion pistaLista=null;
        Cancion pistaCD=null;
        while(i.hasNext()){ 
         pistaLista=i.next();
         h = miLista.iterator(); 
         boolean encontradoTitulo =false; // booleano utilizado para detectar una cancion del cd con el mismo nombre que una de la lista
         pistaCD=null;//inicializamos a cero para recorrer desde el principio la lista del cd en busca de canciones con el mismo titulo 
          while(h.hasNext() && !encontradoTitulo){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=h.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              encontradoTitulo=pistaCD.igualTitulo(pistaLista.getTitulo());
          }
          if (!encontradoTitulo) { //si no se ha encontrado en el cd una cancion con el mismo nombre se añade a la lista del cd
              miLista.add(pistaLista.clone(pistaLista));
          } 
        } //while
         }//if
    }
        
        public boolean añadirCancion (Cancion pista) {// compara el nombre de la cancion
        boolean añadido=false;
        if ((pista!=null)&&(!miLista.contains(pista))) { //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
            
              miLista.add(pista.clone(pista));
              añadido=true;
            } 
        
        return añadido;
    }
        
      
        public void añadirLista (ArrayList<Cancion> lista) {
        if (lista!=null){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
        Iterator <Cancion>i = lista.iterator();
        Iterator <Cancion>h;
        Cancion pistaLista=null;
        Cancion pistaCD=null;
        while(i.hasNext()){ 
         pistaLista=i.next();
         h = miLista.iterator(); 
         boolean encontradoTitulo =false; // booleano utilizado para detectar una cancion del cd con el mismo nombre que una de la lista
         pistaCD=null;//inicializamos a cero para recorrer desde el principio la lista del cd en busca de canciones con el mismo titulo 
          while(h.hasNext() && !encontradoTitulo){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=h.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              encontradoTitulo=pistaCD.igualTitulo(pistaLista.getTitulo());
          }
          if (!encontradoTitulo) { //si no se ha encontrado en el cd una cancion con el mismo nombre se añade a la lista del cd
              miLista.add(pistaLista.clone(pistaLista));
          } 
        } //while
         }//if
    }
        
        public boolean incluidaCancion (Cancion pista) {//compara el objeto cancion
        boolean incluida=false;
        if (pista!=null){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
            Iterator <Cancion>i = miLista.iterator();
            Cancion pistaCD;
            while(i.hasNext() && !incluida){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=i.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              incluida=pistaCD.equals(pista);
            }
        }
           return incluida;
    }
        public boolean incluidaCancion (String titulo) {//compara el titulo de la cancion
        boolean incluida=false;
        if (titulo.length()!=0){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
            Iterator <Cancion>i = miLista.iterator();
            Cancion pistaCD;
            while(i.hasNext() && !incluida){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=i.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              incluida=pistaCD.igualTitulo(titulo);
            }
        }
           return incluida;
    }
        public boolean borrarCancion (Cancion pista){
         
         boolean borrado=false;
        if (pista!=null){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
            Iterator <Cancion>i = miLista.iterator();
            Cancion pistaCD;
            while(i.hasNext() && !borrado){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=i.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              borrado=pistaCD.equals(pista);
            }
            if (borrado) {
                i.remove();
            }
        }
           return borrado;
    }
    // cuidado con este método que te devuelve un objeto, controlar el caso en que te devuelva un objeto vacío
    public Cancion borrarCancion (String titulo){
          Cancion pistaCD=null;
         boolean borrado=false;
        if (titulo.length()!=0){ //si la lista de canciones que se le pasa no es vacia la copiara a continuacion
            Iterator <Cancion>i = miLista.iterator();
           
            while(i.hasNext() && !borrado){ //mientras no se llegue al final de la lista del cd y no se haya encontrado 
              pistaCD=i.next();                    //ninguna cancion con el mismo nombre, avanza en la lista  
              borrado=pistaCD.igualTitulo(titulo);
            }
            if (borrado) {
                i.remove();
            }                         //la canción no se encuentra en la lista y 
            else {pistaCD=null;} //pongo a pistaCd a null, porque contendra la ultima cancion de la lista
        }
           return pistaCD;
    }
    /**
     *
     * @param calificacion
     * @return
     */
    public ArrayList<Cancion> obtenerLista(double calificacion) {
       ArrayList<Cancion>  lista = new ArrayList<Cancion>();
     //  if ((calificacion>= miLista.get(1).getCALIDADMIN())&&(calificacion>= miLista.get(1).getCALIDADMAX())){
           
           Iterator <Cancion> i = miLista.iterator();
           Cancion pista;
           while (i.hasNext()){
               pista=i.next();
               if (pista.getCalificacion()>calificacion){
                   lista.add(pista);
               }
           }
      // }
       return lista;
    }

     public double mediaCalificaion (CD disco){
         double media = 0;
         int contador= 0;
         Iterator <Cancion> i = miLista.iterator();
           Cancion pista;
           while (i.hasNext()){
               contador+=1;
               pista=i.next();
               media+=pista.getCalificacion();
           }
           if (contador !=0){
               media=media/contador;
           }
         return media;
     }
     
      public ArrayList<Cancion> obtenerListaMayorIgual(double calificacion) {
       ArrayList<Cancion>  lista = new ArrayList<Cancion>();
     //  if ((calificacion>= miLista.get(1).getCALIDADMIN())&&(calificacion>= miLista.get(1).getCALIDADMAX())){
           
           Iterator <Cancion> i = miLista.iterator();
           Cancion pista;
           while (i.hasNext()){
               pista=i.next();
               if (pista.getCalificacion()>=calificacion){
                   lista.add(pista);
               }
           }
      // }
        return lista;
      }
      
       public String mostrarListaMayorIgual(double calificacion) {//revisar para que te devuelva null
       String  lista;
     //  if ((calificacion>= miLista.get(1).getCALIDADMIN())&&(calificacion>= miLista.get(1).getCALIDADMAX())){
           StringBuilder listaBuilder = new StringBuilder();
           Iterator <Cancion> i = miLista.iterator();
           Cancion pista;
           while (i.hasNext()){
               pista=i.next();
               if (pista.getCalificacion()>=calificacion){
                   listaBuilder.append("\n");
                   listaBuilder.append(pista.toString());
                   
                  
               }
           }
      // }
           lista=listaBuilder.toString();
        return lista;
      }
       
       public boolean equals (Object o){
            CD c = (CD) o;
            return ((titulo.compareTo(c.titulo)==0)&&(interprete.compareTo(c.interprete)==0)&&(identificador==c.identificador));
            
            
        }
       
        public CD clone (Object o){
         CD d = (CD) o;
         return new CD(d.getTitulo(),d.getInterprete(),d.getIdentificador(),d.getMiLista());
     }
      
      
      
}
   

    
    




