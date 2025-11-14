# Automatizaci-n-Datos-contadores---POO

#Proyecto 3

# Sistema de Automatización de Lecturas de Servicios Públicos

## Descripción general
Solución tecnológica para la **automatización de los datos de los contadores** que realizan la lectura y medición de los servicios de agua, luz y gas.  
El sistema permite registrar contadores, registrar lecturas, listar las lecturas realizadas y calcular el costo del consumo según el tipo de servicio.

---

## Objetivo
Desarrollar un sistema básico en **Java** que demuestre los principios de la **Programación Orientada a Objetos (POO)**:

- **Abstracción:** Clase abstracta `Servicio`.
- **Encapsulamiento:** Atributos privados y métodos getters/setters.
- **Herencia:** `ServicioAgua`, `ServicioLuz`, `ServicioGas` heredan de `Servicio`.
- **Polimorfismo:** Cada tipo de servicio implementa su propio cálculo de consumo.
- **Asociación y composición:** `Contador` tiene muchas `Lectura`; `SistemaLecturas` administra colecciones.

proyectoPOO/
 └── src/
      └── sistema/
           ├── Main.java
           └── services/
                └── SistemaLecturas.java


---

# ENTREGABLE 1 — Estructura Base del Sistema

## Descripción
Se crea el esqueleto del sistema de automatización de lecturas de contadores.  
Esta primera versión no almacena datos reales, pero define la estructura modular del proyecto.

## Objetivos
- Aplicar conceptos de encapsulación básica.
- Separar responsabilidades entre la clase `Main` y el servicio `SistemaLecturas`.
- Construir un menú navegable que represente las futuras funcionalidades.

## Estado del Sistema
- El menú muestra opciones para registrar contadores, registrar lecturas, listar lecturas y calcular costos.
- Las funciones solo imprimen mensajes de depuración.

--- 

# ENTREGABLE 2 — Implementación de Clases y Lógica Básica

## Descripción
En esta segunda entrega se implementan las **clases de dominio** del sistema:
- `Contador` (representa el medidor de un servicio).
- `Lectura` (representa una medición realizada por un contador).
- Se agregan estructuras para **almacenar y gestionar** los datos en memoria desde `SistemaLecturas`.

El sistema ahora puede registrar contadores y lecturas de forma básica usando colecciones.

---

## Objetivos
- Aplicar **encapsulación, constructores, getters/setters y listas**.
- Implementar la relación entre `Contador` y `Lectura`.
- Simular el registro de datos sin base de datos (colecciones en memoria).

---

## Estructura del proyecto

proyectoPOO/
└── src/
└── sistema/
├── Main.java
├── models/
│ ├── Contador.java
│ └── Lectura.java
└── services/
└── SistemaLecturas.java

---

---

## **ENTREGA 3 — Herencia, Polimorfismo y Cálculo de Costos**

# ENTREGABLE 3 — Herencia, Polimorfismo y Cálculo de Consumo

## Descripción
En esta fase final, el sistema diferencia los tipos de contadores mediante herencia:
- Clase base `Contador`.
- Clases hijas: `ContadorAgua`, `ContadorLuz` y `ContadorGas`.
Cada una implementa su propio método para calcular el costo del consumo.

---

## Objetivos
- Aplicar **herencia y polimorfismo**.
- Simular la lectura y cálculo del costo según tipo de servicio.
- Consolidar la arquitectura modular y extensible del sistema.

---

## Estructura del proyecto

proyectoPOO/
└── src/
└── sistema/
├── Main.java
├── models/
│ ├── Contador.java
│ ├── ContadorAgua.java
│ ├── ContadorLuz.java
│ ├── ContadorGas.java
│ └── Lectura.java
└── services/
└── SistemaLecturas.java


---

## Conceptos aplicados

-Herencia: clases específicas derivadas de una clase base abstracta.

-Polimorfismo: uso dinámico del método calcularCosto() según tipo de contador.

-Colecciones y búsqueda (stream, filter).

-Diseño modular y extensible.
