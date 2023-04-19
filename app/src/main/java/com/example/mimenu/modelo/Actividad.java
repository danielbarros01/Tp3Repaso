package com.example.mimenu.modelo;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Actividad {
    private String nombre, descripcion;
    private Date fecha;
    private Date hora;

    public Actividad() {
    }

    public Actividad(String nombre, String descripcion, Date fecha, Date hora) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }
}
