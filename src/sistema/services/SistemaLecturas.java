package sistema.services;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import sistema.models.*;

public class SistemaLecturas {

    private List<Contador> contadores = new ArrayList<>();
    private List<Lectura> lecturas = new ArrayList<>();

    public Contador registrarContador(String id, String direccion, int tipo) {
        Contador c;
        switch (tipo) {
            case 1 -> c = new ContadorAgua(id, direccion);
            case 2 -> c = new ContadorLuz(id, direccion);
            case 3 -> c = new ContadorGas(id, direccion);
            default -> throw new IllegalArgumentException("Tipo inválido");
        }
        contadores.add(c);
        return c;
    }

    public Lectura registrarLectura(String idContador, double valor) {
        if (buscarContador(idContador) == null)
            throw new IllegalArgumentException("Contador no existe");

        Lectura l = new Lectura(idContador, valor, LocalDate.now());
        lecturas.add(l);
        return l;
    }

    public List<Lectura> listarLecturas() {
        return new ArrayList<>(lecturas);
    }

    public double calcularCosto(String id) {
        Contador contador = buscarContador(id);
        if (contador == null)
            throw new IllegalArgumentException("Contador no existe");

        double consumo = lecturas.stream()
                .filter(l -> l.getIdContador().equals(id))
                .mapToDouble(Lectura::getValor)
                .sum();

        return contador.calcularCosto(consumo);
    }

    private Contador buscarContador(String id) {
        return contadores.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
