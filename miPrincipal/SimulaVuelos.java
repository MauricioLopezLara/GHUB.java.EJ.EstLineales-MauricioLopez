package miPrincipal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SimulaVuelos {
    private static final int MAX_ESPERA_DESPEGUE = 5000; // En milisegundos
    private static final int MAX_ESPERA_ATERRIZAJE = 3000; // En milisegundos

    public static void main(String[] args) {
        // Crear cola de vuelos
        Queue<Vuelo> colaVuelos = new LinkedList<>();

        // Generar vuelos
        generarVuelos(colaVuelos);

        // Iniciar hilo torre de control
        Thread hiloTorreControl = new Thread(new TorreControl(colaVuelos));
        hiloTorreControl.start();

        // Iniciar hilos aeropuertos
        for (Aeropuerto aeropuerto : generarAeropuertos(colaVuelos)) {
            Thread hiloAeropuerto = new Thread(aeropuerto);
            hiloAeropuerto.start();
        }
    }

    private static void generarVuelos(Queue<Vuelo> colaVuelos) {
        Random random = new Random();
        String[] origenes = {"Culiacán", "Mazatlán", "Tijuana", "Monterrey", "Ciudad de México"};
        String[] destinos = {"Ciudad de México", "Guadalajara", "Tijuana", "Cancún", "Los Cabos"};

        for (int i = 0; i < 10; i++) {
            String origen = origenes[random.nextInt(origenes.length)];
            String destino = destinos[random.nextInt(destinos.length)];
            colaVuelos.offer(new Vuelo(i, origen, destino, "EN ESPERA"));
        }
    }

    private static Aeropuerto[] generarAeropuertos(Queue<Vuelo> colaVuelos) {
        Aeropuerto[] aeropuertos = new Aeropuerto[5];

        for (int i = 0; i < aeropuertos.length; i++) {
            aeropuertos[i] = new Aeropuerto(null, colaVuelos);
        }

        return aeropuertos;
    }
    
}