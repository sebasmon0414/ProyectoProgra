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
        
        
        biblioteca.agregarLibro(new Libro(1, "Cien años de soledad", "Gabriel Garcia Marquez", true));
        biblioteca.agregarLibro(new Libro(2, "1984", "George Orwell", true));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Buscar libro");
            System.out.println("2. Reservar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Salir");

            int opcion = 0;
            boolean opcionValida = false;

            
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
                    List<Libro> resultados = biblioteca.buscarLibros(criterio);
                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron libros con esos datos ");
                    } else {
                        System.out.println("Libros encontrados con dichas caracteristicas");
                        for (Libro libro : resultados) {
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (ID: " + libro.getId() + ", Disponible: " + libro.isDisponible() + ")");
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

                    if (biblioteca.reservarLibro(idReserva)) {
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

                    biblioteca.devolverLibro(idDevolucion);
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