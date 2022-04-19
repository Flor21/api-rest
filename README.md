# Desafio API REST

**Requerimientos**

- Docker (20.10.14)
- Docker-compose (2.4.1)

**Pasos**

1. Clono el repositorio `$ git clone https://github.com/Flor21/api-rest.git`

2. Luego me posiciono dentro del directorio: `$ cd api-rest`
    - `$ docker-compose up`

3. Una vez levantado el proyecto podemos realizar las siguientes peticiones POST, GET y DELETE, pero primero hay que registrarse y despues autenticarse.
    Los roles pueden ser  ROLE_ADMIN o ROLE_USER.

    - POST 
        * Url: http://localhost:8080/usuario/registrarse

        * RequestBody
        ~~~
        {
            "nombre": "cualquierNombre",
            "email": "email@gmail.com",
            "contrasenia": "cualquierContrasenia",
            "role": "ROLE_ADMIN"
        }
        ~~~

    - POST 
        * Url: http://localhost:8080/usuario/autenticarse

        * RequestBody
        ~~~
        {
            "email": "email@gmail.com",
            "contrasenia": "cualquierContrasenia",
        }
        ~~~

    Estas peticiones se hacen copiando el token que te devolvio cuando te auntenticaste.

    - POST
        Solo puede realizarlo el Admin
        
        * Url: http://localhost:8080/productos

        * RequestBody
        ~~~
        {
            "nombre": "Devanador Ovillador De Lana Manual",
            "descripcion": "**** OVILLADOR MANUAL **** Ovillador - Devanador Manual de excelente calidad. Incluye en el precio el Ovillador y el porta madeja. Con este Ovillador conseguirás que tus ovillos sean perfectos.\nIndustria Nacional\n",
            "precio": 9820.99
        }
        ~~~
        
    - GET 
        Pueden realizarlo el Admin y el User.

        * Para obtener todos los productos se utiliza la siguiente url: http://localhost:8080/productos
        
        * Para obtener un producto especifico se utiliza la siguiente url y reemplazo {idProducto} por el numero de id que quiero buscar http://localhost:8080/productos/{idProducto}

    - DELETE 
        Solo puede realizarlo el Admin.

        * Para eliminar un producto especifico se utiliza la siguiente url y reemplazo {idProducto} por el numero de id que quiero eliminar http://localhost:8080/productos/{idProducto}
