package ejercicio10;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BolsaDeTrabajo bolsa = new BolsaDeTrabajo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Simulador de Bolsa de Trabajo ---");
            System.out.println("1. Registrar nueva oferta de empleo");
            System.out.println("2. Buscar ofertas de empleo");
            System.out.println("3. Aplicar a una oferta");
            System.out.println("4. Listar todas las ofertas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea nueva

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el título de la oferta: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Introduce la industria: ");
                    String industria = scanner.nextLine();
                    System.out.print("Introduce la ubicación: ");
                    String ubicacion = scanner.nextLine();
                    System.out.print("Introduce el tipo de contrato (Tiempo completo/Medio tiempo/Freelance): ");
                    String tipoContrato = scanner.nextLine();
                    System.out.print("Introduce la descripción del puesto: ");
                    String descripcion = scanner.nextLine();
                    bolsa.registrarOferta(titulo, industria, ubicacion, tipoContrato, descripcion);
                    break;

                case 2:
                    System.out.print("Introduce la industria (o presiona enter para omitir): ");
                    String buscarIndustria = scanner.nextLine();
                    System.out.print("Introduce la ubicación (o presiona enter para omitir): ");
                    String buscarUbicacion = scanner.nextLine();
                    System.out.print("Introduce el tipo de contrato (o presiona enter para omitir): ");
                    String buscarTipoContrato = scanner.nextLine();

                    List<OfertaEmpleo> ofertasEncontradas = bolsa.buscarOfertas(
                            buscarIndustria.isEmpty() ? null : buscarIndustria,
                            buscarUbicacion.isEmpty() ? null : buscarUbicacion,
                            buscarTipoContrato.isEmpty() ? null : buscarTipoContrato);

                    if (ofertasEncontradas.isEmpty()) {
                        System.out.println("No se encontraron ofertas con los criterios especificados.");
                    } else {
                        for (OfertaEmpleo oferta : ofertasEncontradas) {
                            System.out.println(oferta);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Introduce tu nombre: ");
                    String nombreCandidato = scanner.nextLine();
                    System.out.print("Introduce un resumen de tus calificaciones: ");
                    String calificaciones = scanner.nextLine();
                    System.out.print("Introduce un resumen de tu experiencia: ");
                    String experiencia = scanner.nextLine();
                    Candidato candidato = new Candidato(nombreCandidato, calificaciones, experiencia);

                    System.out.print("Introduce el ID de la oferta a la que quieres aplicar: ");
                    int idOferta = scanner.nextInt();

                    OfertaEmpleo ofertaSeleccionada = bolsa.buscarOfertas(null, null, null).stream()
                            .filter(oferta -> oferta.getId() == idOferta)
                            .findFirst()
                            .orElse(null);

                    if (ofertaSeleccionada != null) {
                        candidato.aplicarAOferta(ofertaSeleccionada);
                    } else {
                        System.out.println("Oferta no encontrada.");
                    }
                    break;

                case 4:
                    bolsa.listarOfertas();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
