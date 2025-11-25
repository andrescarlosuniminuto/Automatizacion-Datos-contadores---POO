package sistema.models;

/**
 * Clase abstracta que representa un Contador genérico.
 * Esta clase funciona como base para los distintos tipos de contadores
 * (por ejemplo: Agua, Luz, Gas), los cuales deberán implementar sus
 * propios métodos de cálculo de costo.
 */
public abstract class Contador {

 // Identificador único del contador
    protected String id;

// Dirección física donde está ubicado el contador
    protected String direccion;

/**
     * Constructor que inicializa los datos básicos del contador.
     *
     * @param id identificador único del contador
     * @param direccion ubicación del contador
     */
    public Contador(String id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

 /**
     * Devuelve el ID del contador.
     *
     * @return id del contador
     */
    public String getId() { return id; }

    /**
     * Devuelve la dirección asociada al contador.
     *
     * @return dirección donde está instalado el contador
     */
    public String getDireccion() { return direccion; }

 /**
     * Método abstracto y polimórfico que deben implementar las subclases.
     * Cada tipo de contador tendrá su propia forma de calcular el costo
     * según su consumo.
     *
     */
    public abstract double calcularCosto(double consumo);

 /**
     * Método abstracto para obtener el tipo de contador (Agua, Luz, Gas, etc.).
     *
     * @return tipo del contador como texto
     */
    public abstract String getTipo();

 /**
     * Representación textual del contador, mostrando su tipo, ID y ubicación.
     *
     * @return información resumida del contador
     */
    @Override
    public String toString() {
        return "[" + getTipo() + "] ID=" + id + " | Dirección=" + direccion;
    }
}
