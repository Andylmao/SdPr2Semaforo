# SdPr2Semaforo
# Simulación de Semáforo y Generación de Autos

Este programa en Java simula el funcionamiento de un semáforo de tráfico y la generación de autos en distintos estados del semáforo. El programa utiliza hilos para manejar el semáforo y la generación de autos de manera concurrente.

## Funcionamiento

El programa utiliza tres estados para el semáforo: Verde, Naranja y Rojo. Cada estado tiene su propio comportamiento:

- **Verde:** En este estado, se despachan los autos generados en el estado Rojo.

- **Naranja:** En este estado, los autos pasan a través del semáforo, y se muestra cuántos autos han pasado.

- **Rojo:** En este estado, se generan aleatoriamente entre 1 y 12 autos cada cierto tiempo.

El programa utiliza un hilo para el semáforo y otro hilo para la generación de autos en el estado Rojo. Estos hilos comparten información sobre el estado actual y la cantidad de autos generados.

## Uso

Para ejecutar el programa, sigue estos pasos:

1. Clona o descarga el repositorio en tu máquina local.

2. Abre el proyecto en tu entorno de desarrollo Java favorito.

3. Ejecuta la clase `Main` para iniciar la simulación.

## Configuración

Puedes ajustar la configuración del programa en el código fuente según tus necesidades. Por ejemplo, puedes cambiar el tiempo de espera para el despacho de autos en el estado Verde o el tiempo entre la generación de autos en el estado Rojo.

## Contribuciones

Si deseas contribuir al proyecto o realizar mejoras, ¡estamos abiertos a tus aportaciones! Siéntete libre de crear un fork del repositorio y enviar pull requests.

## Licencia

Este proyecto está bajo la Licencia MIT. Puedes consultar el archivo [LICENSE](LICENSE) para obtener más detalles.

## Autor

Este programa fue desarrollado por A.García

