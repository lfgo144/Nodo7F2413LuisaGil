package ejercicio8;

public class Camion {
    private static int contadorId = 1; // Contador para generar IDs únicos
    private int id;
    private String placa;
    private double capacidadMaxima; // En kilogramos

    // Constructor
    public Camion(String placa, double capacidadMaxima) {
        this.id = contadorId++;
        this.placa = placa;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Obtener el ID del camión
    public int getId() {
        return id;
    }

    // Obtener la capacidad máxima del camión
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    // Representación en texto del camión
    @Override
    public String toString() {
        return "Camión ID: " + id + " | Placa: " + placa + " | Capacidad máxima: " + capacidadMaxima + "kg";
    }
}

