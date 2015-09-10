#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-marketplace)
  - [Entidad Book](#entidad-book)
  - [Entidad CartItem](#entidad-cartitem)
  - [Entidad Client](#entidad-client)
  - [Entidad Product](#entidad-product)
  - [Entidad Provider](#entidad-provider)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /MarketPlace.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

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

##API de la aplicación MarketPlace
###Entidad Book
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Book, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Book
```javascript
{
    id: '' /*Tipo Long que representa id de Long*/,
    name: '' /*Tipo Long que representa id de String*/,
    description: '' /*Tipo Long que representa id de String*/,
    image: '' /*Tipo Long que representa id de String*/,
    isbn: '' /*Tipo Long que representa id de String*/
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
    quantity: '' /*Tipo Long que representa id de Integer*/,
    name: '' /*Tipo Long que representa id de String*/,
    product: '' /*Tipo Product*/
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

###Entidad Product
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Product, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Product
```javascript
{
    book: '' /*Tipo Book*/,
    name: '' /*Tipo Long que representa id de String*/,
    price: '' /*Tipo Long que representa id de Integer*/,
    id: '' /*Tipo Long que representa id de Long*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/products|Obtener todos los objetos JSON de Product (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Product y el total de registros en la base de datos en el header X-Total-Count
**GET**|/products/:id|Obtener los atributos de una instancia de Product en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Product
**POST**|/products|Crear una nueva instancia de la entidad Product (CREATE)||Objeto JSON de Product a crear|Objeto JSON de Product creado
**PUT**|/products/:id|Actualiza una instancia de la entidad Product (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Product|Objeto JSON de Product actualizado
**DELETE**|/products/:id|Borra instancia de Product en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Provider
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Provider, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Provider
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
**GET**|/providers|Obtener todos los objetos JSON de Provider (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Provider y el total de registros en la base de datos en el header X-Total-Count
**GET**|/providers/:id|Obtener los atributos de una instancia de Provider en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Provider
**POST**|/providers|Crear una nueva instancia de la entidad Provider (CREATE)||Objeto JSON de Provider a crear|Objeto JSON de Provider creado
**PUT**|/providers/:id|Actualiza una instancia de la entidad Provider (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Provider|Objeto JSON de Provider actualizado
**DELETE**|/providers/:id|Borra instancia de Provider en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Provider
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Provider son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|providers/:id/products|Obtener Objetos JSON de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider||Colección de objetos JSON de products(Product)
**POST**|providers/:id/products|Creación de instancias de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de objetos JSON de products(Product) a crear|Colección de objetos JSON de products(Product) creados con sus respectivos ID
**PUT**|providers/:id/products|Actualización de instancias de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de objetos JSON de products(Product) a actualizar|Colección de objetos JSON de products(Product) actualizados
**DELETE**|providers/:id/products|Eliminación de instancias de products(Product) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de atributo `id` de products(Product) a eliminar|

[Volver arriba](#tabla-de-contenidos)

