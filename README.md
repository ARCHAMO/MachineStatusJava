## Maquina de Estados

Prueba de conocimientos en java y creacion de Rest Api.

## **IDE usado**

NetBeans IDE 19

## **FrameWorks usados**

Sprint Boot

JPA

## Modelo de clases

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/3677412db586c5a19dd89171512cc3df920d23eec77b0f16.png)

## Modelo de entidad/relacion

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/11daef893a53f7969a773cd28fee4b8b8b63e2136c892ee5.png)

## Diccionario de datos

**Tabla: Objeto**

Descripcion: Se registran los diferentes objetos que tendran su configuration de estados y flujo.

<table><tbody><tr><td><strong>Campo</strong></td><td><strong>Tipo</strong></td><td><strong>Tamaño</strong></td><td><strong>Descripcion</strong></td></tr><tr><td>idObjeto</td><td>INT</td><td>&nbsp;</td><td>Identificador unico del registro incremental</td></tr><tr><td>nombre</td><td>VARCHAR</td><td>45</td><td>Nombre unico que identifica el objet en el sistema</td></tr><tr><td>descripcion</td><td>VARCHAR</td><td>250</td><td>Describe la funcionalidad del objeto y en que processo se usa</td></tr><tr><td>estadoRegistro</td><td>VARCHAR</td><td>1</td><td>Identifica si el registro esta activo, Para ser visualizado en &nbsp;el sistema</td></tr><tr><td>estadoInicialId</td><td>INT</td><td>&nbsp;</td><td>Permite configurar el estado inicial al momento de que se cera un registro de este tipo</td></tr><tr><td>estadoFinalId</td><td>INT</td><td>&nbsp;</td><td>Permite configurar el estado final que indica el final del flujo del proceso Para esse tipo de objeto &nbsp;</td></tr></tbody></table>

**Tabla: Estado**

Descripcion: Se registran los diferentes estados que puede tomar un tipo de objeto en particular.

<table><tbody><tr><td><strong>Campo</strong></td><td><strong>Tipo</strong></td><td><strong>Tamaño</strong></td><td><strong>Descripcion</strong></td></tr><tr><td>idEstado</td><td>INT</td><td>&nbsp;</td><td>Identificador unico del registro incremental</td></tr><tr><td>nombre</td><td>VARCHAR</td><td>45</td><td>Nombre unico que identifica un estado en el sistema</td></tr><tr><td>descripcion</td><td>VARCHAR</td><td>250</td><td>Determina el estado en que se encuentra un objeto proceso</td></tr><tr><td>estadoRegistro</td><td>VARCHAR</td><td>1</td><td>Identifica si el registro esta activo, Para ser visualizado en &nbsp;el sistema</td></tr></tbody></table>

**Tabla: ObjetoEstado**

Descripcion: Permite relacionar que estados triene access o puede ver un objeto en particular

<table><tbody><tr><td><strong>Campo</strong></td><td><strong>Tipo</strong></td><td><strong>Tamaño</strong></td><td><strong>Descripcion</strong></td></tr><tr><td>idObjetoEstado</td><td>INT</td><td>&nbsp;</td><td>Identificador unico del registro incremental</td></tr><tr><td>estadoId</td><td>INT</td><td>&nbsp;</td><td>Relaciona el estado de un objet especifico.</td></tr><tr><td>objetoId</td><td>INT</td><td>&nbsp;</td><td>Relaciona el objeto que puede tener uno o varios estados</td></tr><tr><td>estadoRegistro</td><td>VARCHAR</td><td>1</td><td>Identifica si el registro esta activo, Para ser visualizado en &nbsp;el sistema</td></tr></tbody></table>

**Tabla: Transiciones**

Descripcion: Permite configurar las transiciones que se pueden realizar entre un estado origen a un estado destino y ejecutar una lógica especifica Para cada transicion.

<table><tbody><tr><td><strong>Campo</strong></td><td><strong>Tipo</strong></td><td><strong>Tamaño</strong></td><td><strong>Descripcion</strong></td></tr><tr><td>idTransicion</td><td>INT</td><td>&nbsp;</td><td>Identificador unico del registro incremental</td></tr><tr><td>estadoOrigenId</td><td>INT</td><td>&nbsp;</td><td>Id del estado origen para Para configurar la transicion.</td></tr><tr><td>estadoDestinoId</td><td>INT</td><td>&nbsp;</td><td>Id del estado destino para Para configurar la transicion.</td></tr><tr><td>metodoEjecucion</td><td>VARCHAR</td><td>100</td><td>Especifica, un SP de BD, una URL o un metodo especifico a ejecutar cuando se cumple la transicion.</td></tr><tr><td>parametros</td><td>VARCHAR</td><td>1000</td><td>Objeto JSON que representa lso parâmetros necesarios para la ejecución definida en metodoEjecucion.</td></tr><tr><td>estadoRegistro</td><td>VARCHAR</td><td>1</td><td>Identifica si el registro esta activo, Para ser visualizado en &nbsp;el sistema</td></tr></tbody></table>

## Documentación Servicios Rest 

[https://documenter.getpostman.com/view/70301/2s9YJdV2ce#0543a246-1320-4381-ab68-24057b34a8da](https://documenter.getpostman.com/view/70301/2s9YJdV2ce#0543a246-1320-4381-ab68-24057b34a8da)

## Features pendientes

1.  Servicio para evaluar las transiciones basado en el estado inicial configurado de un Objeto. 
    1.  No logro entender cuales o que tipo de reglas se determinan Para validar si cambia de estado o no.
    2.  En el apartado de implementación “_Para validar su diseño, desarrollar dos web service rest, uno que le retorne cual es el estado y el otro modifica el estado. Su desarrollo debe programarse en lenguaje java.”._ **No entiendo a que se refiere a cual es el estado y el otro modificado el estado.**

## Impedimentos presentados

> Me tomo tiempo configurar el entorno de Java al tener conflictos entre versiones de SDK, por tener instalado herramientas para desarrollo Movil.

> Curva Para recordar conceptos y maneras de declaración en Java, asi como tambien el manejo de JPA, ya que tenia alrededor de 4 años de no usarlo. Acltualmente mis Skill fuertes son, NodeJs, NestJs, c#, SQL Server, Oracle, MongoDB, pero logre adaptarme con mi lógica de programacion.

## Arquitectura de Microservicios

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/24d2820101aa96393b46a24655b4de2eec356729029ab619.png)

**Servicios de operaciones básicas**

Identificamos los servicios, operaciones que tengan bajo acoplamiento y comenzamos a desagregarlos, basados en el impacto de la operación.

**Service 1, 2, 3, x**

Serán servicios desagregados con funciones específicas y puntuales que requieran de respuestas transaccionales con alta recurrencia pero poco tiempo de ejecución.

**Service Bus Message**

Este componente será encargado de registrar los mensajes de eventos enviados tanto por los servicios básicos como toda operación que se genere y que requiera ser comunicada hacia los demás actores de la solución.

**Integration event trigger**

Componente encargado de detectar operaciones de sincronización, ejecución de procesos de alta demanda, así como la comunicación con apis externas, este componente tendrá sus propios recursos escalables a demanda.

**Synchronization Event Trigger**

Componente encargado de detectar las operaciones básicas que se realizan entre Servicios y mantener la información sincronizada entre ellos.

**Logic App BD Events**

Componente encargado de detectar cambios en base de datos, que requieran de la ejecución y procesamiento de información de alta demanda.

**RECOMENDACIONES ADICIONALES**

1.  Implementar principios SOLID, con el objetivo de mantener más mantenible y soportada la solución.
2.  Implementar patrón CQRS, Para dividir las operaciones de escritura y lectura.
3.  Implementar arquitecturas en capas Para segregar responsabilidades.
4.  Implementar patrón repositorio, en canso de requerir modificar la persistencia de los datos.
