package sistema;

import java.util.Scanner;
import sistema.services.SistemaLecturas;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaLecturas sistema = new SistemaLecturas();
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE AUTOMATIZACIÓN DE LECTURAS ===");
            System.out.println("1. Registrar contador");
            System.out.println("2. Registrar lectura");
            System.out.println("3. Listar lecturas");
            System.out.println("4. Calcular costo de consumo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> sistema.registrarContador();
                case 2 -> sistema.registrarLectura();
                case 3 -> sistema.listarLecturas();
                case 4 -> sistema.calcularCosto();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
