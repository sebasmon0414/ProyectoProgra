/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance3punto0;

/**
 *
 * @author sebas
 */
public class libroF extends Libro{

    public libroF(String titulo, String autor, int id) {
        super(titulo, autor, id);
    }


    @Override
    public String consultarInfo() {
        return "Libro Físico: " + titulo + " por " + autor + ", ID: " + id;
    }
}
   
