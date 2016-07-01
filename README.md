TP Algoritmos 2 - Primer Cuatrimestre 2016
=========================================

# Introducción

La entrega de este proyecto está referida al trabajo práctico final de la clase Algoritmos 2 de la Universidad CAECE.

Se trata de un modelado de una clínica completa usando Java y patrones de diseño orientados a eventos.

Nuestra implementación también incluye un sistema de emergencias automatizado donde la aplicación
decide que hacer dependiendo de factores de probabilidad pseudo-aleatorios dados en tiempo de ejecución.

Los integrantes del equipo son:
 
 - Tomas Sevillano - [https://github.com/tsevillano](@tsevillano)
 - Alejandro Ciatti - [https://github.com/alejandrociatti](@alejandrociatti)
 - Rodrigo Troncoso - [https://github.com/rtroncoso](@rtroncoso)

# Instalación y ejecución

El proyecto requiere Maven para ser instalado y ejecutado, una vez instalado Maven los pasos para ejecutar
el proyecto son:

### Desde una terminal

Dirigirse a la carpeta `algoritmos/` desde cualquier terminal de preferencia y ejecutar los siguientes comandos:

    mvn install
    mvn exec:java

### Desde IntelliJ Idea

En las configuraciones de ejecución de IntelliJ Idea `(Run > Edit Configurations...)` agregar una nueva configuración
nombrada "Maven". Modificar los siguientes campos:
 
 - Dentro del campo `Working Directory` apuntar a la carpeta `algoritmos` del proyecto.
 - Dentro del campo `Command Line` escribir `exec:java` **(sin mvn)**

Una vez hecho esto se puede compilar y correr/debuggear el proyecto usando IntelliJ Idea
