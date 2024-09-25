package ejercicio10;

public class OfertaEmpleo {
    private static int contadorId = 1; // Contador para generar IDs únicos
    private int id;
    private String titulo;
    private String industria;
    private String ubicacion;
    private String tipoContrato; // "Tiempo completo", "Medio tiempo", "Freelance"
    private String descripcion;

    // Constructor
    public OfertaEmpleo(String titulo, String industria, String ubicacion, String tipoContrato, String descripcion) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.industria = industria;
        this.ubicacion = ubicacion;
        this.tipoContrato = tipoContrato;
        this.descripcion = descripcion;
    }

    // Obtener el ID de la oferta
    public int getId() {
        return id;
    }

    // Obtener la industria
    public String getIndustria() {
        return industria;
    }

    // Obtener la ubicación
    public String getUbicacion() {
        return ubicacion;
    }

    // Obtener el tipo de contrato
    public String getTipoContrato() {
        return tipoContrato;
    }

    // Representación en texto de la oferta de empleo
    @Override
    public String toString() {
        return "Oferta ID: " + id + " | Título: " + titulo + " | Industria: " + industria + " | Ubicación: " + ubicacion + " | Contrato: " + tipoContrato + "\nDescripción: " + descripcion;
    }
}
