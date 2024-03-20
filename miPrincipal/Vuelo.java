package miPrincipal;

public class Vuelo {

    private int id;
    private String origen;
    private String destino;
    private String estado;

    public Vuelo(int id, String origen, String destino, String estado) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
    
}
