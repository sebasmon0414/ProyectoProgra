/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avance3punto0;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Avance3punto0 {

    public static void main(String[] args) {
        Biblioteca BiblioInst = new Biblioteca("titulo", "autor", 0);
        BiblioInst.agregarLibro(new libroF ("Coraline", "Neil Gaiman", 1));
        BiblioInst.agregarLibro(new libroD ("Pantalones Cortos", "Lara Ríos", 2));
        BiblioInst.agregarLibro(new libroD ("Harry Potter", "J.K.Rowling", 3));
        BiblioInst.agregarLibro(new libroF ("El Señor de los Anillos", "J.R.R. Tolkien", 4));
        BiblioInst.agregarLibro(new libroF ("El Principito", "Antoine de Saint-Exupéry", 5));
        

        System.out.println("Libros disponibles en la biblioteca:");
        for (String info : BiblioInst.listarLibrosDisponibles()) {
            System.out.println(info);
        }
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Buscar libro");
            System.out.println("2. Reservar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Salir");
            
            int opcion = 0;
            boolean opcionValida = false;
            Scanner scanner = new Scanner(System.in);


            
            while (!opcionValida) {
                try {
                    opcion = Integer.parseInt(scanner.nextLine()); 
                    opcionValida = true; 
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un numero valido ");
                }
            }

            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese el título del libro o autor del mismo ");
                    String criterio = scanner.nextLine();
                    List<Libro> resultados;
                    resultados = (List<Libro>) BiblioInst.buscarLibro(criterio);
                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron libros con esos datos ");
                    } else {
                        System.out.println("Libros encontrados con dichas caracteristicas");
                        for (Libro libro : resultados) {
                            System.out.println(BiblioInst.getTitulo() + " - " +BiblioInst.getAutor()+ " - " + BiblioInst.getId() + ", Disponible: "  );
                        }
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID del libro que desea reservar ");
                    int idReserva = 0;
                    boolean idReservaValido = false;

                    
                    while (!idReservaValido) {
                        try {
                            idReserva = Integer.parseInt(scanner.nextLine());
                            idReservaValido = true; 
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, ingrese un ID valido");
                        }
                    }

                    if (BiblioInst.reservarLibro(Integer.toString(idReserva))) {
                        System.out.println("Libro reservado correctamente");
                    } else {
                        System.out.println("No se pudo reservar el libro o el libro no está disponible.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del libro que desea devolver: ");
                    int idDevolucion = 0;
                    boolean idDevolucionValido = false;

                    
                    while (!idDevolucionValido) {
                        try {
                            idDevolucion = Integer.parseInt(scanner.nextLine());
                            idDevolucionValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, ingrese un ID valido.");
                        }
                    }

                    BiblioInst.devolverLibro(Integer.toString(idDevolucion));
                    System.out.println("Libro devuelto correctamente");
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida. Ingrese una opción valida ");
    }
    }
}
}