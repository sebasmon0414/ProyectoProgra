/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author sebas
 */
public class Biblioteca {

    private static final String URL = "jdbc:sqlite:biblioteca.db";

    public Biblioteca() {
        crearBaseDeDatos();
    }

    private void crearBaseDeDatos() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS libros ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "titulo TEXT NOT NULL,"
                        + "autor TEXT NOT NULL,"
                        + "disponible BOOLEAN NOT NULL CHECK (disponible IN (0, 1))"
                        + ");";
                stmt.execute(sql);
                System.out.println("Tabla 'libros' creada o ya existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libros(titulo, autor, disponible) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setBoolean(3, libro.isDisponible());
            pstmt.executeUpdate();
            System.out.println("Libro insertado: " + libro.getTitulo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> buscarLibros(String criterio) {
        List<Libro> resultados = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE titulo LIKE ? OR autor LIKE ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + criterio + "%");
            pstmt.setString(2, "%" + criterio + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponible = rs.getBoolean("disponible");
                resultados.add(new Libro(id, titulo, autor, disponible));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public boolean reservarLibro(int id) {
        String sql = "UPDATE libros SET disponible = ? WHERE id = ? AND disponible = 1";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, id);
            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0; // Retorna true si se actualizó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void devolverLibro(int id) {
        String sql = "UPDATE libros SET disponible = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Libro devuelto correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
