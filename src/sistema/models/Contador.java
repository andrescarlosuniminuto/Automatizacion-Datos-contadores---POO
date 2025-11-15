package sistema.models;

public abstract class Contador {

    protected String id;
    protected String direccion;

    public Contador(String id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public String getId() { return id; }
    public String getDireccion() { return direccion; }

    // Método polimórfico
    public abstract double calcularCosto(double consumo);

    public abstract String getTipo();

    @Override
    public String toString() {
        return "[" + getTipo() + "] ID=" + id + " | Dirección=" + direccion;
    }
}
