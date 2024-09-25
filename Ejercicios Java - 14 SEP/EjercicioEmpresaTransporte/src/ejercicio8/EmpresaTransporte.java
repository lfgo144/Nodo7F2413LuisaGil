package ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
    private List<Envio> envios;
    private List<Camion> camiones;

    // Constructor
    public EmpresaTransporte() {
        this.envios = new ArrayList<>();
        this.camiones = new ArrayList<>();
    }

   
    public void registrarEnvio(String destino, double peso, double distancia) {
        Envio nuevoEnvio = new Envio(destino, peso, distancia);
        envios.add(nuevoEnvio);
        System.out.println("Envío registrado: " + nuevoEnvio);
    }

    
    public void agregarCamion(String placa, double capacidadMaxima) {
        Camion nuevoCamion = new Camion(placa, capacidadMaxima);
        camiones.add(nuevoCamion);
        System.out.println("Camión registrado: " + nuevoCamion);
    }

    
    public void asignarCamionAEnvio(int envioId, int camionId) {
        Envio envio = buscarEnvioPorId(envioId);
        Camion camion = buscarCamionPorId(camionId);

        if (envio != null && camion != null) {
            if (envio.getEstado().equals("Pendiente")) {
                if (envio.calcularCosto() <= camion.getCapacidadMaxima()) {
                    envio.setEstado("En tránsito");
                    System.out.println("Camión asignado exitosamente al envío ID " + envioId);
                } else {
                    System.out.println("El envío excede la capacidad del camión.");
                }
            } else {
                System.out.println("El envío ya está en tránsito o entregado.");
            }
        } else {
            System.out.println("Envío o camión no encontrado.");
        }
    }

    
    public void actualizarEstadoEnvio(int envioId, String nuevoEstado) {
        Envio envio = buscarEnvioPorId(envioId);
        if (envio != null) {
            envio.setEstado(nuevoEstado);
            System.out.println("Estado del envío actualizado: " + envio);
        } else {
            System.out.println("Envío no encontrado.");
        }
    }

   
    private Envio buscarEnvioPorId(int id) {
        for (Envio envio : envios) {
            if (envio.getId() == id) {
                return envio;
            }
        }
        return null;
    }

  
    private Camion buscarCamionPorId(int id) {
        for (Camion camion : camiones) {
            if (camion.getId() == id) {
                return camion;
            }
        }
        return null;
    }

   
    public void listarEnvios() {
        if (envios.isEmpty()) {
            System.out.println("No hay envíos registrados.");
        } else {
            for (Envio envio : envios) {
                System.out.println(envio);
            }
        }
    }

  
    public void listarCamiones() {
        if (camiones.isEmpty()) {
            System.out.println("No hay camiones registrados.");
        } else {
            for (Camion camion : camiones) {
                System.out.println(camion);
            }
        }
    }
}

