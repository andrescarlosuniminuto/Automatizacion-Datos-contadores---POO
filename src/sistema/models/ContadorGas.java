package sistema.models;

public class ContadorGas extends Contador {

    public ContadorGas(String id, String direccion) {
        super(id, direccion);
    }

    @Override
    public double calcularCosto(double consumo) {
        return consumo * 1000;
    }

    @Override
    public String getTipo() {
        return "Gas";
    }
}
