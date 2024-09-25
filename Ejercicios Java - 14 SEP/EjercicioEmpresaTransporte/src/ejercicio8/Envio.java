package ejercicio8;

public class Envio {
    private static int contadorId = 1; // Contador para generar IDs únicos
    private int id;
    private String destino;
    private double peso; // En kilogramos
    private double distancia; // En kilómetros
    private String estado; // "Pendiente", "En tránsito", "Entregado"

    // Constructor
    public Envio(String destino, double peso, double distancia) {
        this.id = contadorId++;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.estado = "Pendiente"; // Estado inicial
    }

   
    public double calcularCosto() {
        double tarifaPorKilo = 2.5; // Tarifa por kilogramo
        double tarifaPorKilometro = 1.2; // Tarifa por kilómetro
        return (peso * tarifaPorKilo) + (distancia * tarifaPorKilometro);
    }

   
    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

   
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

   
    @Override
    public String toString() {
        return "Envío ID: " + id + " | Destino: " + destino + " | Peso: " + peso + "kg | Distancia: " + distancia + "km | Estado: " + estado;
    }
}
