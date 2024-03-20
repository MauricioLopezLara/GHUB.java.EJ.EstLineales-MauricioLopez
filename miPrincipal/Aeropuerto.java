package miPrincipal;

import java.util.Queue;
import java.util.Random;

public class Aeropuerto implements Runnable{
    private static final int MAX_ESPERA_ATERRIZAJE = 10;
    private String nombre;
    private Queue<Vuelo> colaVuelos;

    public Aeropuerto(String nombre, Queue<Vuelo> colaVuelos) {
        this.nombre = nombre;
        this.colaVuelos = colaVuelos;
    }

    @Override
    public void run() {
        while (true) {
            Vuelo vuelo = null;

            // Esperar a que un vuelo tenga como destino este aeropuerto
            synchronized (colaVuelos) {
                while (vuelo == null && !colaVuelos.isEmpty()) {
                    vuelo = colaVuelos.peek();

                    if (!vuelo.getDestino().equals(nombre)) {
                        vuelo = null;
                        try {
                            colaVuelos.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }

            if (vuelo != null) {
                colaVuelos.poll(); // Eliminar el vuelo de la cola

                System.out.println("**Aeropuerto " + nombre + ":** Preparando aterrizaje del vuelo " + vuelo.getId() + " procedente de " + vuelo.getOrigen());

                // Simular tiempo de espera aleatorio para el aterrizaje
                try {
                    Thread.sleep(new Random().nextInt(MAX_ESPERA_ATERRIZAJE));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                vuelo.setEstado("ATERRIZANDO");
                System.out.println("**Aeropuerto " + nombre + ":** Vuelo " + vuelo.getId() + " aterrizando en " + nombre);

                System.out.println("**Aeropuerto " + nombre + ":** Vuelo " + vuelo.getId() + " ha aterrizado.");
            }
        }
    }
    
}