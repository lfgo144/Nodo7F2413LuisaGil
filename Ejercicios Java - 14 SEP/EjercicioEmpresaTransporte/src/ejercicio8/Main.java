package ejercicio8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpresaTransporte empresa = new EmpresaTransporte();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Logística ---");
            System.out.println("1. Registrar nuevo envío");
            System.out.println("2. Agregar camión");
            System.out.println("3. Asignar camión a un envío");
            System.out.println("4. Actualizar estado del envío");
            System.out.println("5. Listar envíos");
            System.out.println("6. Listar camiones");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea nueva

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el destino del envío: ");
                    String destino = scanner.nextLine();
                    System.out.print("Introduce el peso del paquete (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Introduce la distancia del envío (km): ");
                    double distancia = scanner.nextDouble();
                    empresa.registrarEnvio(destino, peso, distancia);
                    break;

                case 2:
                    System.out.print("Introduce la placa del camión: ");
                    String placa = scanner.nextLine();
                    System.out.print("Introduce la capacidad máxima del camión (kg): ");
                    double capacidadMaxima = scanner.nextDouble();
                    empresa.agregarCamion(placa, capacidadMaxima);
                    break;

                case 3:
                    System.out.print("Introduce el ID del envío: ");
                    int envioId = scanner.nextInt();
                    System.out.print("Introduce el ID del camión: ");
                    int camionId = scanner.nextInt();
                    empresa.asignarCamionAEnvio(envioId, camionId);
                    break;

                case 4:
                    System.out.print("Introduce el ID del envío: ");
                    int envioActualizarId = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea
                    System.out.print("Introduce el nuevo estado (Pendiente/En tránsito/Entregado): ");
                    String nuevoEstado = scanner.nextLine();
                    empresa.actualizarEstadoEnvio(envioActualizarId, nuevoEstado);
                    break;

                case 5:
                    empresa.listarEnvios();
                    break;

                case 6:
                    empresa.listarCamiones();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
