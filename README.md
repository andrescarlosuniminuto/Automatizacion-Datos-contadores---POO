# Automatizaci-n-Datos-contadores---POO

#Proyecto 3

# Sistema de Automatización de Lecturas de Servicios Públicos


## Descripción del Proyecto
Este proyecto implementa un sistema básico para la **automatización de los datos de contadores** de agua, luz y gas.  
Permite registrar contadores, registrar lecturas, listar los registros y calcular costos según el tipo de servicio.

El sistema se diseñó siguiendo estrictamente los principios de **Programación Orientada a Objetos (POO)**, aplicando herencia, abstracción, encapsulación, polimorfismo y composición de forma clara y demostrable.

---

## Funcionalidades Principales

- Registro de contadores (agua, luz, gas).  
- Registro de lecturas de consumo.
- Listado de lecturas registradas.
- Cálculo automático del costo según el tipo de servicio.
- Menú interactivo en consola para navegación del usuario.

---

## Arquitectura y POO Implementados

### ✔ Encapsulación
Todos los atributos de las clases `Contador` y `Lectura` son privados y se accede a ellos mediante **getters** y **setters**, protegiendo la integridad de los datos.

### ✔ Abstracción
La clase abstracta `Servicio` representa un servicio público genérico.  
Define el método abstracto `calcularCosto()` que cada servicio concreto implementa.

### ✔ Herencia
Las clases:
- `ServicioAgua`
- `ServicioLuz`
- `ServicioGas`

Heredan de `Servicio` y cada una implementa su propia fórmula de cálculo.

### ✔ Polimorfismo
Los métodos se invocan sin importar la clase hija específica del servicio.  
Ejemplo:

```java
double costo = contador.getServicio().calcularCosto(consumo);

