package sistema.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

import sistema.models.*;

public class SistemaLecturas {

    private List<Contador> contadores = new ArrayList<>();
    private List<Lectura> lecturas = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    // REGISTRAR CONTADOR (herencia)

    public void registrarContador() {
        System.out.println("\n--- Registrar Contador ---");
        System.out.print("ID: ");
        String id = sc.next();

        sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.println("Tipo de contador:");
        System.out.println("1. Agua");
        System.out.println("2. Luz");
        System.out.println("3. Gas");
        System.out.print("Opción: ");
        int tipo = sc.nextInt();

        Contador c;

        switch (tipo) {
            case 1 -> c = new ContadorAgua(id, direccion);
            case 2 -> c = new ContadorLuz(id, direccion);
            case 3 -> c = new ContadorGas(id, direccion);
            default -> {
                System.out.println("Tipo inválido.");
                return;
            }
        }

        contadores.add(c);
        System.out.println("✔ Registrado: " + c);
    }


    // REGISTRAR LECTURA

    public void registrarLectura() {
        System.out.println("\n--- Registrar Lectura ---");
        System.out.print("ID del contador: ");
        String id = sc.next();

        if (buscarContador(id) == null) {
            System.out.println("Contador no existe.");
            return;
        }

        System.out.print("Valor leído: ");
        double valor = sc.nextDouble();

        Lectura lec = new Lectura(id, valor, LocalDate.now());
        lecturas.add(lec);

        System.out.println("✔ Lectura registrada.");
    }


    // LISTAR LECTURAS

    public void listarLecturas() {
        System.out.println("\n--- Lecturas Registradas ---");
        if (lecturas.isEmpty()) {
            System.out.println("No hay lecturas.");
            return;
        }
        lecturas.forEach(System.out::println);
    }


    // CALCULAR COSTO (polimorfismo)

    public void calcularCosto() {
        System.out.println("\n--- Cálculo de Costo ---");
        System.out.print("ID del contador: ");
        String id = sc.next();

        Contador contador = buscarContador(id);
        if (contador == null) {
            System.out.println("No existe el contador.");
            return;
        }

        double consumoTotal = lecturas.stream()
                .filter(l -> l.getIdContador().equals(id))
                .mapToDouble(Lectura::getValor)
                .sum();

        double costo = contador.calcularCosto(consumoTotal); // ⬅ polimorfismo real

        System.out.println("Contador: " + contador.getTipo());
        System.out.println("Consumo total: " + consumoTotal);
        System.out.println("Costo total: $" + costo);
    }

    // --------------------------------------------------------

    private Contador buscarContador(String id) {
        return contadores.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
