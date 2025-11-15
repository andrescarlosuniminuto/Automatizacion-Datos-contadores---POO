package sistema.models;

import java.time.LocalDate;

public class Lectura {
    private String idContador;
    private double valor;
    private LocalDate fecha;

    public Lectura(String idContador, double valor, LocalDate fecha) {
        this.idContador = idContador;
        this.valor = valor;
        this.fecha = fecha;
    }

    public String getIdContador() { return idContador; }
    public double getValor() { return valor; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return "Lectura [Contador=" + idContador + ", Valor=" + valor + ", Fecha=" + fecha + "]";
    }
}
