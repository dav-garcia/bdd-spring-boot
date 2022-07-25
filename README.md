# bdd-spring-boot

Ejemplo de microservicio desarrollado en Spring Boot con la técnica de desarrollo Behavior Driven Development (BDD).

Tutorial con todas las explicaciones: https://www.adictosaltrabajo.com/2019/01/08/haciendo-bdd-en-microservicios-hexagonales-spring-boot/

## Versiones

### 0.0.1
La versión original de este proyecto es la [0.0.1](https://github.com/dav-garcia/bdd-spring-boot/tree/v0.0.1) y es la que se desarrolla en el tutorial.

### 0.0.2

La versión 0.0.2 (master) corrige algunos defectos y actualiza la versión de Spring Boot y sus dependencias:

1. La organización de paquetes no es verdaderamente hexagonal.
   - Hay confusión entre puertos (interfaces) y adaptadores (implementaciones).
   - De manera indirecta, la lógica de negocio depende de las interfaces de Spring Data JPA. \
     Esto se ha resuelto con una verdadera interfaz de puerto de persistencia de la que luego extiende la interfaz del adaptador de Spring Data JPA.
2. No se sigue la recomendación de Robert C. Martin de exponer el modelo en primer plano y ocultar la implementación de los adaptadores.
3. Los tests de casos de uso no necesitan levantar el contexto de Spring; pueden ser implementados como tests unitarios para que se ejecuten más rápido.
