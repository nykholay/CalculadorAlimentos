/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project1;
 import java.time.LocalDateTime; // libreria encargada de devolver valores de hora y fecha
import java.util.Scanner; //Librería encargada de leer datos ingresados por HID

public class Project1 {

    static final int MAX_ASIENTOS = 100; // Asientos máximos disponibles en el avión
    static final int MAX_EQUIPAJE = 2; // Cantidad máxima de maletas
    static final int PESO_MAX_MALETA = 23; // Peso máximo por maleta en kg, peso estandar en vuelos
    static final int TIEMPO_RESERVA_HORAS = 48; // Tiempo límite para reservas/cancelaciones en horas
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    static int asientosDisponibles = MAX_ASIENTOS;

    public static void main(String[] args) { //esta es la ejecución principal
        Scanner scanner = new Scanner(System.in);  //declaramos la opcion de lectura de datos

        while (true) {
            System.out.println(ANSI_RED + "_________________________________________________________________________________________");
            System.out.println("\nBienvenido \n   Sistema de Reserva de Aerolinea Z");
            System.out.println("   Asientos disponibles:  " + asientosDisponibles);
             
                  
                System.out.println("\nPor favor, escoja una opcion. Ingrese el numero de la accion que desea realizar");
            System.out.println("1. Reservar vuelo");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt(); //Lee el número ingresado

            switch (opcion) {
                case 1:
                    reservarVuelo(scanner); //escoge la opcion 1, que es reservar
                    break;
                case 2:
                    cancelarReserva(scanner); //escoge la opcion de cancelar un vuelo
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema.");  // opcion salir
                    return;
                    
                default:
                    System.out.println("Ha ingresado una opcion invalida. Intente nuevamente."); //en caso de que no sea el ingreso, 1,2 o 3, dirá inválido y reiniciará el bucle
            }
        }
    }

    public static void reservarVuelo(Scanner scanner) {
        if (asientosDisponibles == 0) {
            System.out.println("No hay asientos disponibles.");
            return;
        }

        System.out.print("Ingrese su nombre: ");
        scanner.nextLine(); 
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su documento de identidad: ");
        String documento = scanner.nextLine();

        System.out.print("Ingrese el tipo de boleto (económico/premium): ");
        String tipoBoleto = scanner.nextLine();

        System.out.print("¿Cuantas maletas necesita agregar? (máximo " + MAX_EQUIPAJE + "): ");
        int cantidadMaletas = scanner.nextInt();

        if (cantidadMaletas > MAX_EQUIPAJE) {
            System.out.println("Excede la cantidad máxima permitida de equipaje.");
            return;
        }

        for (int i = 1; i <= cantidadMaletas; i++) {
            System.out.print("Ingrese el peso de la maleta " + i + " en kg: ");
            double pesoMaleta = scanner.nextDouble();
            if (pesoMaleta > PESO_MAX_MALETA) {
                System.out.println("La maleta " + i + " excede el peso permitido de " + PESO_MAX_MALETA + " kg.");
                return;
            }
        }

        System.out.println("Reserva realizada exitosamente. ¡Buen viaje!");
        asientosDisponibles--;
    }

    public static void cancelarReserva(Scanner scanner) {
        System.out.print("Ingrese la fecha de su reserva (YYYY-MM-DD): ");
        scanner.nextLine(); // Consumir el salto de línea
        String fechaReservaStr = scanner.nextLine();
        System.out.print("Ingrese la hora de su reserva (HH:MM en formato 24 horas): ");
        String horaReservaStr = scanner.nextLine();

        // Separar los componentes de la fecha y hora
        String[] fechaPartes = fechaReservaStr.split("-");
        String[] horaPartes = horaReservaStr.split(":");

        int ano = Integer.parseInt(fechaPartes[0]);
        int mes = Integer.parseInt(fechaPartes[1]);
        int dia = Integer.parseInt(fechaPartes[2]);
        int hora = Integer.parseInt(horaPartes[0]);
        int minuto = Integer.parseInt(horaPartes[1]);

   
        LocalDateTime fechaReserva = LocalDateTime.of(ano, mes, dia, hora, minuto);
        LocalDateTime ahora = LocalDateTime.now();

        // Calcular diferencia entre las fechas, para calcular las horas restantes
        long diferenciaHoras = (ahora.getDayOfYear() - fechaReserva.getDayOfYear()) * 24
                             + (ahora.getHour() - fechaReserva.getHour())
                             + (ahora.getMinute() - fechaReserva.getMinute()) / 60;

        if (diferenciaHoras > TIEMPO_RESERVA_HORAS) {
            System.out.println("La cancelación está fuera del tiempo permitido. Se aplicará una multa del 20%.");
            
        } else {
            System.out.println("Cancelación realizada sin multas.");
        }

        asientosDisponibles++; // guarda un asiento más
    }
}
