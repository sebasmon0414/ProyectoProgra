/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avance1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Avance1 {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes"));
        biblioteca.agregarLibro(new Libro("Coraline", "Neil Gaiman"));
        biblioteca.agregarLibro(new Libro("Harry Potter y el Caliz del Fuego", "J.K. Rowling"));
        biblioteca.agregarLibro(new Libro("El Señor de los Anillos", "J.R.R. Tolkien"));
        biblioteca.agregarLibro(new Libro("Madame Bovary", "Gustave Flaubert"));
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel Garcia Márquez"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Buscar un libro");
            System.out.println("2. Reservar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título o autor del libro a buscar: ");
                    String criterio = scanner.nextLine();
                    List<Libro> resultados = biblioteca.buscarLibros(criterio);
                    for (Libro libro : resultados) {
                        System.out.println(libro.getTitulo() + " - " + libro.getAutor());
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro a reservar: ");
                    String tituloReserva = scanner.nextLine();
                    if (biblioteca.reservarLibro(tituloReserva)) {
                        System.out.println("Libro reservado.");
                    } else {
                        System.out.println("No se pudo reservar el libro solicitado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolucion);
                    System.out.println("Libro devuelto.");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
   
