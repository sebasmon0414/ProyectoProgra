/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance3punto0;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class Biblioteca extends Libro {
       private List<Libro> libros;

    public Biblioteca (String titulo, String autor, int id){
        super (titulo, autor, id);
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public List<String> listarLibrosDisponibles() {
        List<String> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles.add(libro.consultarInfo());
            }
        }
        return disponibles;
    }

    @Override
    public String consultarInfo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     public boolean reservarLibro( String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible()) {
                libro.reservar();
                return true;
            }
        }
        return false;
    }
     
       public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.devolver();
                return;
            }
        }


}
}
