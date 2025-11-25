package sistema.services;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import sistema.models.*;

/**
 * La clase SistemaLecturas actúa como el núcleo del sistema:
 * administra los contadores registrados, almacena las lecturas realizadas
 * y permite calcular el costo total del consumo según el tipo de contador.
 *
 * Funciona como una “capa de servicio” que centraliza la lógica del negocio.
 */
public class SistemaLecturas {

 // Lista que guarda todos los contadores registrados (agua, luz, gas).
    private List<Contador> contadores = new ArrayList<>();

 // Lista donde se almacenan todas las lecturas realizadas.
    private List<Lectura> lecturas = new ArrayList<>();

/**
     * Registra un nuevo contador según el tipo especificado.
     * @param id        identificador único asignado al contador
     * @param direccion dirección donde está instalado
     * @param tipo      tipo de contador (1=Agua, 2=Luz, 3=Gas)
     * @return          el contador creado
     *
     * El método utiliza polimorfismo para crear el tipo correcto de contador.
     */
    public Contador registrarContador(String id, String direccion, int tipo) {
        Contador c;

    // Selección del tipo de contador usando una estructura switch moderna
        switch (tipo) {
            case 1 -> c = new ContadorAgua(id, direccion);
            case 2 -> c = new ContadorLuz(id, direccion);
            case 3 -> c = new ContadorGas(id, direccion);
            default -> throw new IllegalArgumentException("Tipo inválido");
        }

        // Guardamos el contador en la lista general
        contadores.add(c);
        return c;
    }

 /**
     * Registra una nueva lectura asociada a un contador.
     * @param idContador ID del contador al cual pertenece la lectura
     * @param valor      valor de consumo reportado
     * @return           la lectura registrada
     *
     * El sistema primero verifica que el contador exista antes de permitir guardar la lectura.
     */
    public Lectura registrarLectura(String idContador, double valor) {

        // Validación: el contador debe existir antes de registrar una lectura 
        if (buscarContador(idContador) == null)
            throw new IllegalArgumentException("Contador no existe");

 // Cada lectura se fecha automáticamente con el día actual
        Lectura l = new Lectura(idContador, valor, LocalDate.now());
    
         // Se almacena en la lista
        lecturas.add(l);
        return l;
    }

 /**
     * Devuelve todas las lecturas registradas.
     * @return lista de lecturas (se envía una copia para proteger la lista original)
     */
    public List<Lectura> listarLecturas() {
        return new ArrayList<>(lecturas);
    }

/**
     * Calcula el costo total del consumo acumulado de un contador.
     * @param id ID del contador
     * @return costo calculado según el tipo de contador
     *
     * Este método:
     * 1. Busca el contador
     * 2. Suma todas las lecturas asociadas a él
     * 3. Usa el método polimórfico calcularCosto() del contador
     */
    public double calcularCosto(String id) {

        // Verifica que el contador exista
        Contador contador = buscarContador(id);
        if (contador == null)
            throw new IllegalArgumentException("Contador no existe");

// Calculamos el consumo total sumando todas las lecturas del contador
        double consumo = lecturas.stream()
                .filter(l -> l.getIdContador().equals(id))
                .mapToDouble(Lectura::getValor)
                .sum();

 // Delegamos el cálculo a la clase específica (agua, luz o gas)
        return contador.calcularCosto(consumo);
    }

 /**
     * Busca un contador según su ID.
     * @param id ID del contador
     * @return el contador encontrado o null si no existe
     *
     * Esta función es privada porque solo debe usarse dentro del sistema.
     */
    private Contador buscarContador(String id) {
        return contadores.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
