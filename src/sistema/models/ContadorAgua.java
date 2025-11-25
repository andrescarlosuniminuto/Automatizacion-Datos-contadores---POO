package sistema.models;

/**
 * Clase que representa un contador de agua.
 * Extiende la clase abstracta Contador e implementa su forma
 * específica de calcular el costo del consumo.
 */
public class ContadorAgua extends Contador {

/**
     * Constructor del contador de agua.
     *
     * @param id identificador único del contador
     * @param direccion ubicación física del contador
     */

    public ContadorAgua(String id, String direccion) {
        super(id, direccion);
    }

/**
     * Calcula el costo del consumo de agua.
     * La tarifa fija para consumo de agua es de 1200 pesos por unidad.
     *
     * @param consumo cantidad consumida
     * @return costo total del consumo
     */
    @Override
    public double calcularCosto(double consumo) {
        return consumo * 1200;
    }


    /**
     * Devuelve el tipo del contador.
     *
     * @return cadena con el nombre del tipo ("Agua")
     */
    @Override
    public String getTipo() {
        return "Agua";
    }
}
