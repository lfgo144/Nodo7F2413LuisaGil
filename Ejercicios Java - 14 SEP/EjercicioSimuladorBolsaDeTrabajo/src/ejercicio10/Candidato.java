package ejercicio10;

public class Candidato {
    private String nombre;
    private String calificaciones;
    private String experiencia;

    // Constructor
    public Candidato(String nombre, String calificaciones, String experiencia) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.experiencia = experiencia;
    }

    // Método para aplicar a una oferta de empleo
    public void aplicarAOferta(OfertaEmpleo oferta) {
        System.out.println("Candidato: " + nombre + " ha aplicado a la oferta: " + oferta.getId());
        System.out.println("Resumen de calificaciones: " + calificaciones);
        System.out.println("Resumen de experiencia: " + experiencia);
    }
}
