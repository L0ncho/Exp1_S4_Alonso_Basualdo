
package exp1_s5_alonso_basualdo;

import java.util.ArrayList;
import java.util.Scanner;


public class Exp1_S5_Alonso_Basualdo {

      // precios constantes por ubicacion
    static double precioVip = 35000;
    static double precioPlatea = 25000;
    static double precioGeneral = 15000;   
    static ArrayList<String> entradasVendidas = new ArrayList<>();   // lista para almacenar las entradas vendidas

    // funcion para mostrar el menu principal
    public static void Menu() {

        System.out.println("--- Menu Principal ---");
        System.out.println("1. Venta de entradas");
        System.out.println("2. Promociones ");
        System.out.println("3. Busqueda de entradas ");
        System.out.println("4. Eliminar una entrada ");
        System.out.println("5. Salir ");
        System.out.println("Seleccione una opcion: ");
    }

       // Funcion para validar entrada de ubicacion//
    public static boolean ubicacionValida(String ubicacion) {
        return ubicacion.equalsIgnoreCase("VIP")
                || ubicacion.equalsIgnoreCase("PLATEA")
                || ubicacion.equalsIgnoreCase("GENERAL");
    }
    
       // funcion para la venta de entradas//
    public static void ventaEntrada(Scanner scanner) {
        System.out.println("------ Venta de entradas -------------");

        System.out.println("Ingrese la ubicacion (VIP/PLATEA/GENERAL): ");
        String ubicacion = scanner.nextLine().trim().toUpperCase();
        if (!ubicacionValida(ubicacion)) {
            System.out.println("ubicacion  no valida, favor intente nuevamente");
            return;
        }

        int cantidad = 0;
        while (true) {
            System.out.println("Cuantas entradas desea comprar?");
            String entradaCantidad;
            entradaCantidad = scanner.nextLine().trim();
            try {
                cantidad = Integer.parseInt(entradaCantidad);
                if (cantidad <= 0) {
                    System.out.println("Debe ingresar una cantidad mayor a 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida, ingrese un numero valido");
            }

        }

        System.out.println("Es estudiante?(s/n):");
        boolean esEstudiante = scanner.nextLine().trim().equalsIgnoreCase("s");

        System.out.println("Es de la tercera edad?(s/n):");
        boolean esAdultoMayor = scanner.nextLine().trim().equalsIgnoreCase("s");

        double precioInicial;

        switch (ubicacion) {
            case "VIP" ->
                precioInicial = precioVip;
            case "PLATEA" ->
                precioInicial = precioPlatea;
            case "GENERAL" ->
                precioInicial = precioGeneral;
            default -> {
                System.out.println("Opcion no valida. intente nuevamente");
                return;
            }
        }
        double descuento = 0.0;
        if (ubicacion.equals("VIP") && cantidad == 4) {
            descuento = 0.20;
            System.out.println("Descuento especial por 4 entradas VIP");
        } else if (esEstudiante) {
            descuento = 0.10;
        } else if (esAdultoMayor) {
            descuento = 0.15;
        }

        double total = precioInicial * cantidad * (1 - descuento);

        System.out.println("Precio final es : " + total);
        for (int j = 0; j < cantidad; j++) {
            String registro = "ubicacion: " + ubicacion + "| precio: $ " + String.format("%.2f", total);
            entradasVendidas.add(registro);

        }
        System.out.println("Entradas guardada con exito"); // se coloca fuera del bucle for, para que no se repita el mensaje tantas entradas se hayan comprado 

    }
    //Promociones//
    public static void promociones() {

        System.out.println(" Lista de promociones!!!");
        System.out.println("---------------------------- ");
        System.out.println("Por ser estudiante, tienes un 10% de descuento");
        System.out.println("Por ser Adulto Mayor, tienes un 15% de descuento");
        System.out.println("Por la compra de 4 entradas VIP tienes el 20% de descuento (no aplicable sobre otras promociones)");
    }

        //Busqueda de entradas//
    public static void busquedaEntrada(Scanner scanner) {
        System.out.println("Busqueda de entradas");
        if (entradasVendidas.isEmpty()) { // verifica que el arraylist entradas vendidas no este vacio
            System.out.println("No hay entradas registradas.");
            return;
        }
        System.out.println("Ingrese una palabra clave como VIP o el precio de la entrada");
        String palabraClave = scanner.nextLine().trim().toUpperCase();

        boolean encontrado = false;
        for (String entrada : entradasVendidas) {
            if (entrada.toUpperCase().contains(palabraClave)) {
                System.out.println(" " + entrada);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias");
        }
    }

        //Eliminar entradas//
    public static void eliminarEntrada(Scanner scanner) {
        System.out.println("Eliminar entrada");
        if (entradasVendidas.isEmpty()) { // verifica que entradasVendida no este vacio 
            System.out.println("No hay entradas para eliminar");
            return;
        }
        System.out.println("Entradas registradas");
        for (int i = 0; i < entradasVendidas.size(); i++) { //.size( devuelve el numero de elementos del arraylist 
            System.out.println((i + 1) + ". " + entradasVendidas.get(i)); // imprime la lista de entradas numeradas, usando el indice de for
        }
        System.out.println("Ingrese el numero de la entrada que desea eliminar");
        if (scanner.hasNext()) {
            int indice = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (indice >= 1 && indice <= entradasVendidas.size()) {
                String eliminada = entradasVendidas.remove(indice - 1);
                System.out.println("Entrada eliminada: " + eliminada);
            } else {
                System.out.println("Numero fuera de rango ");
            }
        } else {
            System.out.println("Entrada invalida");
            scanner.nextLine(); // limpirar entrada 
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                Menu();
                System.out.flush();
                while (!scanner.hasNextInt()) {
                    System.out.println("Ingrese una opcion valida (numero)");
                    scanner.next(); // descartar emtrada invalida
                }
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                switch (opcion) {
                    case 1 ->
                        ventaEntrada(scanner);
                    case 2 ->
                        promociones();
                    case 3 ->
                        busquedaEntrada(scanner);
                    case 4 ->
                        eliminarEntrada(scanner);
                    case 5 ->
                        System.out.println("¡Gracias por visitarnos");
                    default ->
                        System.out.println("Opcion no valida, intente nuevamente");

                }

            } while (opcion != 5);
        }

    }

}
