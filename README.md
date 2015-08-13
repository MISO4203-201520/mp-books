#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-bookmp)
  - [Entidad Book](#entidad-book)
  - [Entidad CartItem](#entidad-cartitem)
  - [Entidad Client](#entidad-client)
  - [Entidad Editorial](#entidad-editorial)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /BookMP.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación BookMP
###Entidad Book
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Book, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Book
```javascript
{
    editorial: '' /*Tipo Editorial*/,
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    isbn: '' /*Tipo Long que representa id de String*/,
    image: '' /*Tipo Long que representa id de String*/,
    price: '' /*Tipo Long que representa id de Integer*/,
    description: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/books|Obtener todos los objetos JSON de Book (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Book y el total de registros en la base de datos en el header X-Total-Count
**GET**|/books/:id|Obtener los atributos de una instancia de Book en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Book
**POST**|/books|Crear una nueva instancia de la entidad Book (CREATE)||Objeto JSON de Book a crear|Objeto JSON de Book creado
**PUT**|/books/:id|Actualiza una instancia de la entidad Book (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Book|Objeto JSON de Book actualizado
**DELETE**|/books/:id|Borra instancia de Book en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad CartItem
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad CartItem, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto CartItem
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    book: '' /*Tipo Book*/,
    quantity: '' /*Tipo Long que representa id de Integer*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/cartItems|Obtener todos los objetos JSON de CartItem (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON CartItem y el total de registros en la base de datos en el header X-Total-Count
**GET**|/cartItems/:id|Obtener los atributos de una instancia de CartItem en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de CartItem
**POST**|/cartItems|Crear una nueva instancia de la entidad CartItem (CREATE)||Objeto JSON de CartItem a crear|Objeto JSON de CartItem creado
**PUT**|/cartItems/:id|Actualiza una instancia de la entidad CartItem (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de CartItem|Objeto JSON de CartItem actualizado
**DELETE**|/cartItems/:id|Borra instancia de CartItem en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Client
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Client, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Client
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    phone: '' /*Tipo Long que representa id de String*/,
    idCard: '' /*Tipo Long que representa id de String*/,
    email: '' /*Tipo Long que representa id de String*/,
    userId: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/clients|Obtener todos los objetos JSON de Client (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Client y el total de registros en la base de datos en el header X-Total-Count
**GET**|/clients/:id|Obtener los atributos de una instancia de Client en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Client
**POST**|/clients|Crear una nueva instancia de la entidad Client (CREATE)||Objeto JSON de Client a crear|Objeto JSON de Client creado
**PUT**|/clients/:id|Actualiza una instancia de la entidad Client (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Client|Objeto JSON de Client actualizado
**DELETE**|/clients/:id|Borra instancia de Client en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Client
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Client son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|clients/:id/shoppingcart|Obtener Objetos JSON de shoppingcart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client||Colección de objetos JSON de shoppingcart(CartItem)
**POST**|clients/:id/shoppingcart|Creación de instancias de shoppingcart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de shoppingcart(CartItem) a crear|Colección de objetos JSON de shoppingcart(CartItem) creados con sus respectivos ID
**PUT**|clients/:id/shoppingcart|Actualización de instancias de shoppingcart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de shoppingcart(CartItem) a actualizar|Colección de objetos JSON de shoppingcart(CartItem) actualizados
**DELETE**|clients/:id/shoppingcart|Eliminación de instancias de shoppingcart(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de atributo `id` de shoppingcart(CartItem) a eliminar|

[Volver arriba](#tabla-de-contenidos)

###Entidad Editorial
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Editorial, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Editorial
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    email: '' /*Tipo Long que representa id de String*/,
    phone: '' /*Tipo Long que representa id de String*/,
    userId: '' /*Tipo Long que representa id de String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/editorials|Obtener todos los objetos JSON de Editorial (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Editorial y el total de registros en la base de datos en el header X-Total-Count
**GET**|/editorials/:id|Obtener los atributos de una instancia de Editorial en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Editorial
**POST**|/editorials|Crear una nueva instancia de la entidad Editorial (CREATE)||Objeto JSON de Editorial a crear|Objeto JSON de Editorial creado
**PUT**|/editorials/:id|Actualiza una instancia de la entidad Editorial (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Editorial|Objeto JSON de Editorial actualizado
**DELETE**|/editorials/:id|Borra instancia de Editorial en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

