# BackendServidor

Este es el backend de la aplicación Servidor. Proporciona funcionalidades de seguridad, persistencia de datos y controladores RESTful para gestionar usuarios y personas.

## Configuración

El proyecto está estructurado en varios paquetes:

- `app.backendServidor.security`: Contiene la configuración de seguridad, incluyendo filtros de autenticación y autorización.
- `app.backendServidor.persistence.model`: Contiene las entidades de base de datos, como `User` y `Person`.
- `app.backendServidor.controllers`: Contiene los controladores RESTful para gestionar usuarios y personas.
- `app.backendServidor.tests`: Contiene los casos de prueba unitarios para el CRUD.

## Funcionalidades

### Seguridad
- Implementa autenticación JWT para proteger las rutas y recursos.
- Gestiona usuarios y contraseñas encriptadas utilizando BCrypt.

### Persistencia de datos
- Utiliza JPA para la gestión de entidades y la interacción con la base de datos.

### Controladores RESTful
- Proporciona endpoints para obtener, agregar, actualizar y eliminar usuarios y personas.

### Pruebas unitarias
- Incluye casos de prueba unitarios para garantizar el correcto funcionamiento del CRUD.
- Se ha utilizado mockito para las pruebas unitarias y Junit

### Documentación de la API
- Se ha utilizado Postman para consumir la API.
- La documentación de la API está disponible en [Postman Documenter](https://documenter.getpostman.com/view/31759288/2sA2xfYYiw).
- Además, se proporciona un archivo JSON con ejemplos de las solicitudes y respuestas en el repositorio de GitHub.

## Ejecución

Para ejecutar el proyecto, asegúrate de tener instalado Java y Maven. Luego, puedes compilar y ejecutar el proyecto usando Maven:

El servidor estará disponible en `http://localhost:8080`

## Autores

Este proyecto fue desarrollado por Pablo Merinas Soto.