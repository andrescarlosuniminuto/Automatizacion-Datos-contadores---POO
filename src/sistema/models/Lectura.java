package sistema.models;

import java.time.LocalDate;

/**
 * Clase que representa una lectura registrada para un contador.
 * Contiene la información del identificador del contador, el valor leído
 * y la fecha en la que se realizó la lectura.
 */
public class Lectura {

    // ID del contador al que pertenece esta lectura
    private String idContador;

    // Valor registrado en la lectura (consumo)
    private double valor;

    // Fecha en la que se tomó la lectura
    private LocalDate fecha;


 /**
     * Constructor de la clase Lectura.
     *
     * @param idContador identificador del contador asociado
     * @param valor cantidad registrada como consumo
     * @param fecha fecha en que se realizó la lectura
     */
    public Lectura(String idContador, double valor, LocalDate fecha) {
        this.idContador = idContador;
        this.valor = valor;
        this.fecha = fecha;
    }

/**
     * Devuelve el ID del contador asociado a la lectura.
     *
     * @return id del contador
     */
    public String getIdContador() { return idContador; }

 /**
     * Devuelve el valor registrado de la lectura.
     *
     * @return consumo leído
     */   
    public double getValor() { return valor; }

  /**
     * Devuelve la fecha de la lectura.
     *
     * @return fecha de registro
     */   
    public LocalDate getFecha() { return fecha; }


 /**
     * Representación textual de la lectura,
     * útil para depuración o visualización rápida.
     *
     * @return cadena con datos de contador, valor y fecha
     */
    @Override
    public String toString() {
        return "Lectura [Contador=" + idContador + ", Valor=" + valor + ", Fecha=" + fecha + "]";
    }
}
