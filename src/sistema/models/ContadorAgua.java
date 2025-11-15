package sistema.models;

public class ContadorAgua extends Contador {

    public ContadorAgua(String id, String direccion) {
        super(id, direccion);
    }

    @Override
    public double calcularCosto(double consumo) {
        return consumo * 1200;
    }

    @Override
    public String getTipo() {
        return "Agua";
    }
}
