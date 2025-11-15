package sistema.models;

public class ContadorLuz extends Contador {

    public ContadorLuz(String id, String direccion) {
        super(id, direccion);
    }

    @Override
    public double calcularCosto(double consumo) {
        return consumo * 800;
    }

    @Override
    public String getTipo() {
        return "Luz";
    }
}
