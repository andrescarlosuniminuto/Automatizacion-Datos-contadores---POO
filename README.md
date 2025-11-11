# Automatizaci-n-Datos-contadores---POO

#Proyecto 3

# Sistema de Automatización de Lecturas de Servicios Públicos

## 💡 Descripción general
Solución tecnológica para la **automatización de los datos de los contadores** que realizan la lectura y medición de los servicios de agua, luz y gas.  
El sistema permite registrar contadores, registrar lecturas, listar las lecturas realizadas y calcular el costo del consumo según el tipo de servicio.

---

## 🎯 Objetivo
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

