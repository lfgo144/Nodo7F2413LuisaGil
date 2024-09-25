package ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BolsaDeTrabajo {
    private List<OfertaEmpleo> ofertas;

    // Constructor
    public BolsaDeTrabajo() {
        this.ofertas = new ArrayList<>();
    }

    // Registrar una nueva oferta de empleo
    public void registrarOferta(String titulo, String industria, String ubicacion, String tipoContrato, String descripcion) {
        OfertaEmpleo nuevaOferta = new OfertaEmpleo(titulo, industria, ubicacion, tipoContrato, descripcion);
        ofertas.add(nuevaOferta);
        System.out.println("Oferta de empleo registrada: " + nuevaOferta);
    }

    // Buscar ofertas de empleo según criterios
    public List<OfertaEmpleo> buscarOfertas(String industria, String ubicacion, String tipoContrato) {
        return ofertas.stream()
                .filter(oferta -> (industria == null || oferta.getIndustria().equalsIgnoreCase(industria)) &&
                                  (ubicacion == null || oferta.getUbicacion().equalsIgnoreCase(ubicacion)) &&
                                  (tipoContrato == null || oferta.getTipoContrato().equalsIgnoreCase(tipoContrato)))
                .collect(Collectors.toList());
    }

    // Listar todas las ofertas
    public void listarOfertas() {
        if (ofertas.isEmpty()) {
            System.out.println("No hay ofertas de empleo disponibles.");
        } else {
            for (OfertaEmpleo oferta : ofertas) {
                System.out.println(oferta);
            }
        }
    }
}

