package sistema.models;

/**
 * Clase que representa un contador de luz (energía eléctrica).
 * Hereda de la clase abstracta Contador e implementa la forma
 * específica de calcular el costo según el consumo de electricidad.
 */
public class ContadorLuz extends Contador {


/**
     * Constructor del contador de luz.
     *
     * @param id identificador único del contador
     * @param direccion ubicación física donde está instalado el contador
     */
    public ContadorLuz(String id, String direccion) {
        super(id, direccion);
    }

/**
     * Calcula el costo del consumo eléctrico.
     * La tarifa definida para electricidad es de 800 pesos por unidad consumida.
     *
     * @param consumo cantidad de energía consumida
     * @return costo total de acuerdo con la tarifa de electricidad
     */
    @Override
    public double calcularCosto(double consumo) {
        return consumo * 800;
    }

/**
     * Devuelve el tipo del contador.
     *
     * @return cadena con el tipo ("Luz")
     */
    @Override
    public String getTipo() {
        return "Luz";
    }
}
