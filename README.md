# MediTrack — Backend base (Caso 2, Grupo 2)

Base de software mínima para el Caso 2 del Anexo TA1: el módulo de recetas del sistema de historias clínicas, simplificado a Java plano + JUnit 5 (sin depender de un framework como Spring Boot, para que el proyecto compile y pruebe sin dependencias pesadas). El grupo no necesita programar el módulo: su entregable es el pipeline CI/CD.

## Qué incluye

- `src/main/java/com/meditrack/Prescription.java` y `PrescriptionService.java`: lógica de validación de recetas, incluyendo el control de dosis máxima que en el caso real no se validó correctamente antes de un despliegue.
- `src/test/java/com/meditrack/PrescriptionServiceTest.java`: pruebas unitarias con JUnit 5, incluyendo el caso de dosis que excede el máximo permitido.

## Cómo correrlo localmente

```bash
mvn test      # compila y ejecuta las pruebas automatizadas
mvn package   # genera el .jar (equivalente a la etapa de "compilacion" del pipeline)
```

## Qué debe hacer el grupo

Diseñar un pipeline que ejecute `mvn test` en cada cambio, valide en un entorno de staging con datos anonimizados, y controle el paso a producción con posibilidad de rollback inmediato, según la guía del Caso 2 del Anexo TA1. No se requiere convertir este proyecto a Spring Boot; el grupo puede documentar en su informe que en un entorno real usarían ese framework, sin necesidad de implementarlo para esta tarea.
