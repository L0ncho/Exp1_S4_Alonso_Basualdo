
package exp1_s4_alonsobasualdo;

import java.util.Scanner;


public class Exp1_S4_AlonsoBasualdo {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        int opcion = 0;
        int edad = 0;
        int valorInicial = 0;
        double valorFinal = 0.0;
        int totalDeEntradas = 0;
        double totalRecaudado = 0.0;
        System.out.println("Bienvenido a la compra de entradas de Teatro Moro");
        System.out.println(" ");

        for (opcion = 0; opcion != 2;) {
            System.out.println("///Menu Principal//");
            System.out.println("--------------------");
            System.out.println("1.- Comprar entrada");
            System.out.println("2.- Salir");
            System.out.println("Seleccione una opcion: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida, favor seleccione un numero5");
                scanner.next();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {

                case 1:
                    boolean continuarCompra = true;
                    // Mostrar el plano del teatro
                    System.out.println("\n---Seleccione el sector de su preferencia");
                    System.out.println("Zona A (VIP)- $35000");
                    System.out.println("Zona B (PLATEA)- $25000");
                    System.out.println("Zona C (GALERIA)- $15000");
                    System.out.println("Ingrese la zona que prefiera");
                    String zona = scanner.next().toUpperCase(); //esto convierte la respuesta a minusculas
                    valorInicial = 0;
                    String nombreZona = " ";

                    if (zona.equals("A")) {
                        valorInicial = 35000;
                        nombreZona = "Zona A";
                    } else if (zona.equals("B")) {
                        valorInicial = 25000;
                        nombreZona = "Zona B";
                    } else if (zona.equals("C")) {
                        valorInicial = 15000;
                        nombreZona = "Zona C";
                    } else {
                        System.out.println("Zona inexistente");
                        continue;
                    }
                    System.out.print("Ingrese su edad: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Edad invalida, debe ser un numero");
                        scanner.next();
                        continue;
                    }
                    edad = scanner.nextInt();
                    if (edad <= 0 || edad > 99) {
                        System.out.println("Ingrese un rango de edad real");
                        continue;
                    }
                    double descuento = 0.0;
                    String tipoDescuento = "Sin descuento";
                    if (edad >= 18 && edad <= 25) {
                        descuento = 0.10;
                        tipoDescuento = "10% Estudiante";
                    } else if (edad > 60) {
                        descuento = 0.15;
                        tipoDescuento = "15% Adulto Mayor";
                    }

                    int i = 0;

                    do {
                        valorFinal = valorInicial - (valorInicial * descuento);
                        i++;

                    } while (i < 1);
                    totalDeEntradas++;
                    totalRecaudado += valorFinal;
                    System.out.println("\n--- Resumen de Compra ---");
                    System.out.println("Ubicación: " + nombreZona);
                    System.out.println("Precio base: $" + valorInicial);
                    System.out.println("Descuento aplicado: " + tipoDescuento);
                    System.out.println("Total a pagar: $" + (int) valorFinal);
                    System.out.println();
                    do {
                        System.out.println("¿Desea realizar otra compra? (s/n)");
                        respuesta = scanner.next().toLowerCase();
                        if (!respuesta.equals("s") && !respuesta.equals("n")) {
                            System.out.println("Opcion no valida, favor intente nuevamente");
                        }

                    } while (!respuesta.equals("s") && !respuesta.equals("n"));
                    if (respuesta.equals("n")) {
                        System.out.println("Muchas Gracias por su preferencia. Hasta pronto!");
                        continuarCompra = false;
                        return;
                        
                    }
                case 2:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opcion no valida, Intente nuevamente \n");
                    break;
            }
        }
        scanner.close();
            }
    
}
