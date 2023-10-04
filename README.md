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
