/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoralimentos;

import java.util.Scanner;

public class CalculadorAlimentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Establecemos valores de referencia
        double maxCalorias = 450.0;
        double minProteinas = 32.0;
        double maxGrasas = 18.0;
        double maxCarbohidratos = 40.0;

        // Establecer variables para el cálculo total
        double totalCalorias = 0.0;
        double totalProteinas = 0.0;
        double totalGrasas = 0.0;
        double totalCarbohidratos = 0.0;
        // Bienvenida
        System.out.println("UNIVERSIDAD TECNOLOGICA EMPRESARIAL DE GUAYAQUIL");
        System.out.println("CALCULADORA DE VALORES NUTRICIONALES");
 

        while (true) {
            System.out.print("Nombre del producto (o 'finalizar' para terminar): ");
            String nombreIngrediente = scanner.next();

            if (nombreIngrediente.equalsIgnoreCase("finalizar")) {
                break;
            }

            System.out.print("Cantidad en gramos: ");
            double cantidadGramos = scanner.nextDouble();

            System.out.print("Grupo del producto (caloria, proteina, grasa, carbohidrato): ");
            String grupo = scanner.next();

            // Realizar el cálculo parcial según el grupo del producto, establecemos todo a minusculas
            switch (grupo.toLowerCase()) {
                case "caloria":
                    totalCalorias += cantidadGramos;
                    break;
                case "proteina":
                    totalProteinas += cantidadGramos;
                    break;
                case "grasa":
                    totalGrasas += cantidadGramos;
                    break;
                case "carbohidrato":
                    totalCarbohidratos += cantidadGramos;
                    break;
                default:
                    System.out.println("El grupo no se encuentra, intente nuevamente.");
                    continue;
            }
        }

        // Verificar si el valor nutricional esta dentro de los rangos saludables
        if (totalCalorias <= maxCalorias &&
                totalProteinas >= minProteinas &&
                totalGrasas <= maxGrasas &&
                totalCarbohidratos <= maxCarbohidratos) {
            System.out.println("El valor nutricional es saludable");
        } else {
            System.out.println("El valor nutricional no es saludable");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
