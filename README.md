# DASI

## Practica 1

El código puede compilarse y ejecutarse a través de `make` mediante el Makefile
proporcionado


### Compilación

> Importante: para compilar un fichero específico hace falta indicar explícitamente
> dentro de la variable `TARGET`

Para compilar todos los ficheros Java basta con el mandato:

```
make compile_all
```

Si queremos compilar tan solo un fichero Java, tomando como ejemplo el
fichero `AgenteOneShot.java`, haría falta introducir el siguiente mandato:

```
make compile TARGET=AgenteOneShot
```

Si tan solo se ejecutase `make compile` se compilará la clase `Agente.java`

### Ejecución

> Importante: para ejecutar un fichero específico hace falta indicar explícitamente
> dentro de la variable `TARGET`

Los ficheros se pueden ejecutar o bien arrancando la interfaz gráfica o bien
mediante la línea de comandos:

#### Modo GUI

```
make run TARGET=AgenteOneShot
```

#### Modo no GUI

```
make run-no-gui TARGET=AgenteOneShot
```