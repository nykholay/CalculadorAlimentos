/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.moviessort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Pelicula {
    String titulo;
    int añoLanzamiento;

    public Pelicula(String titulo, int añoLanzamiento) {
        this.titulo = titulo;
        this.añoLanzamiento = añoLanzamiento;
    }
}

public class MoviesSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pelicula> listaPeliculas = new ArrayList<>();

        // Ingreso información de las películas
        System.out.println("Ingrese información sobre las películas, si desea finalizar  escriba 'fin':");

        while (true) {
            System.out.print("Título de la película: ");
            String titulo = scanner.nextLine();

            if (titulo.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Año de lanzamiento de la película ingresada previamente: ");
            int añoLanzamiento = scanner.nextInt();
            scanner.nextLine(); 

            // Ingresa la película al array
            Pelicula nuevaPelicula = new Pelicula(titulo, añoLanzamiento);
            listaPeliculas.add(nuevaPelicula);
        }

        // Ordenar la lista de películas por su año ingresado
        Collections.sort(listaPeliculas, Comparator.comparingInt(pelicula -> pelicula.añoLanzamiento));

        // Mostrar o imprimir la lista ya ordenada
        System.out.println("\nPelículas ordenadas por el año de lanzamiento:");
        for (Pelicula pelicula : listaPeliculas) {
            System.out.println(pelicula.titulo + " - Año: " + pelicula.añoLanzamiento);
        }

        // Cerrar el scanner
        scanner.close();
    }
}
