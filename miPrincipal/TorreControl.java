package miPrincipal;

import java.util.Queue;
import java.util.Random;

public class TorreControl implements Runnable{
    private static final int MAX_ESPERA_DESPEGUE = 10;
    private static final int MAX_DURACION_VUELO = 60000;
    private Queue<Vuelo> colaVuelos;

    public TorreControl(Queue<Vuelo> colaVuelos) {
        this.colaVuelos = colaVuelos;
    }

    @Override
    public void run() {
        while (!colaVuelos.isEmpty()) {
            Vuelo vuelo = colaVuelos.poll();
            System.out.println("**Torre de Control:** Preparando despegue del vuelo " + vuelo.getId() + " desde " + vuelo.getOrigen() + " hacia " + vuelo.getDestino());

            // Simular tiempo de espera aleatorio para el despegue
            try {
                Thread.sleep(new Random().nextInt(MAX_ESPERA_DESPEGUE));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            vuelo.setEstado("DESPEGANDO");
            System.out.println("**Torre de Control:** Vuelo " + vuelo.getId() + " despegando de " + vuelo.getOrigen());

            // Simular tiempo de vuelo
            try {
                Thread.sleep(new Random().nextInt(MAX_DURACION_VUELO));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            vuelo.setEstado("EN VUELO");
            System.out.println("**Torre de Control:** Vuelo " + vuelo.getId() + " en vuelo hacia " + vuelo.getDestino());
        }

        System.out.println("**Torre de Control:** Todos los vuelos han despegado.");
    }
    
}