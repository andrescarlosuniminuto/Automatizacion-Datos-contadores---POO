package sistema.models;

/**
 * Clase que representa un contador de gas.
 * Extiende la clase abstracta Contador y define su propia tarifa
 * para el cálculo del costo del consumo.
 */
public class ContadorGas extends Contador {

    /**
     * Constructor del contador de gas.
     *
     * @param id identificador único del contador
     * @param direccion ubicación física donde está instalado el contador
     */

    public ContadorGas(String id, String direccion) {
        super(id, direccion);
    }

 /**
     * Calcula el costo del consumo de gas.
     * La tarifa definida para el gas es de 1000 pesos por unidad consumida.
     *
     * @param consumo cantidad consumida
     * @return costo total calculado según la tarifa del gas
     */
    @Override
    public double calcularCosto(double consumo) {
        return consumo * 1000;
    }

/**
     * Devuelve el tipo de contador.
     *
     * @return cadena con el nombre del tipo ("Gas")
     */
    @Override
    public String getTipo() {
        return "Gas";
    }
}
