/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

/**
 *
 * @author Juanan
 */
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Cancion implements Serializable{
    
    private final double DURACIONMAX = 10;
    private final double CALIDADMIN = 0.0;
    private final double CALIDADMAX = 10.0;
    private String titulo;
    private double duracion;
    private double calificacion;
    private GregorianCalendar fecha;
            
            //CONSTRUCTORAS
            
   public Cancion (String titulo, double duracion, double calificacion){         
    
       this.titulo=titulo;
       if (duracion <= DURACIONMAX) {
        this.duracion=duracion;
       }
       else {
           this.duracion=0;
       }
       
       this.calificacion=calificacion;
       fecha=new GregorianCalendar();
       
       if ((calificacion>=CALIDADMIN)&&(calificacion<=CALIDADMAX)) {
           this.calificacion=calificacion;
       }
       else {
           calificacion=0.0;
       }
      }
   
   
   public Cancion (String titulo, double calificacion){         
       
       
       this(titulo,Math.random()*10+1,calificacion);
       }
   
   
   public Cancion (Cancion cancion){
       this.titulo=cancion.titulo;
       this.duracion=cancion.duracion;
       this.fecha=cancion.fecha;
       this.calificacion=cancion.calificacion;
   }   
   
   
   // METODOS

    public String getTitulo() {
        return titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public double getDURACIONMAX() {
        return DURACIONMAX;
    }

    public double getCALIDADMIN() {
        return CALIDADMIN;
    }

    public double getCALIDADMAX() {
        return CALIDADMAX;
    }

    
    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    
    public void setDuracion(double duracion) {
         if (duracion <= DURACIONMAX) {
        this.duracion=duracion;
       }
       else {
           this.duracion=0;
       }
    }

    public void setCalificacion(double calificacion) {
        if ((calificacion>=CALIDADMIN)&&(calificacion<=CALIDADMAX)) {
           this.calificacion=calificacion;
       }
       else {
           calificacion=0;
       }
    }

    public void setFecha(int año, int mes, int dia) { //revisar 
        this.fecha.set(año, mes, dia);
    }
   
   public String toString(){
      String auxduracion;
       String auxcalificacion;
       //auxduracion = String.format("%02d", this.duracion);
       auxduracion = String.format("%.2f", duracion);
       //auxcalificacion = String.format("%01d", calificacion);
       auxcalificacion =  String.format("%.1f", calificacion);
       Date auxfecha = fecha.getTime();
       SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       String fs= df.format(auxfecha);
       return ("Titulo: "+titulo+"  Duracion: "+auxduracion+"  Calificacion: "+auxcalificacion+"  Fecha de publicacion: "+fs);
       //return("Titulo: "+titulo+"Fecha de publicacion: "+fs);
   }
   
   
   public boolean igualTitulo (String titulo){
       
       return (this.titulo.compareTo(titulo)==0);
   }
   
   public boolean calificacionMayor (double calificacion) {
       
       return (this.calificacion > calificacion);
   }
   
     public boolean equals (Object o){
            Cancion c = (Cancion) o;
            return ((titulo.compareTo(c.titulo)==0)); // no comparo la duracion porque te la crea aleatoriamente
            
            
        }
     
     public Cancion clone (Object o){
         Cancion c = (Cancion) o;
        return new Cancion(c);
     }
     
    
}



