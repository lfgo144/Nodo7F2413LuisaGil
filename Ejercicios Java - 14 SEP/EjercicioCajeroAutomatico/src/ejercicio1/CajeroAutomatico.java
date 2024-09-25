package ejercicio1;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 12345;
        int pin = 6789;
        int saldo = 1000;
        int opcion, cantidad;
        int cuentaIngresada, pinIngresado;

        System.out.println("Bienvenido al Cajero Automático");
        System.out.print("Ingrese su número de cuenta: ");
        cuentaIngresada = sc.nextInt();
        System.out.print("Ingrese su PIN: ");
        pinIngresado = sc.nextInt();

        if (cuentaIngresada == cuenta && pinIngresado == pin) {
            do {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Salir");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Su saldo actual es: " + saldo);
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad a retirar: ");
                        cantidad = sc.nextInt();
                        if (cantidad <= saldo) {
                            saldo -= cantidad;
                            System.out.println("Retiro exitoso. Su nuevo saldo es: " + saldo);
                        } else {
                            System.out.println("Fondos insuficientes.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad a depositar: ");
                        cantidad = sc.nextInt();
                        saldo += cantidad;
                        System.out.println("Depósito exitoso. Su nuevo saldo es: " + saldo);
                        break;
                    case 4:
                        System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 4);
        } else {
            System.out.println("Número de cuenta o PIN incorrectos.");
        }
        sc.close();
    }
}
