# Desafio API REST

**Requerimientos**

- Docker (20.10.14)
- Docker-compose (2.4.1)
- Maven (3.8.4)
- Java (11.0.15)

**Pasos**

1. Clono el repositorio `$ git clone https://github.com/Flor21/api-rest.git`

2. Luego me posiciono dentro del directorio: `$ cd api-rest`
    - Ejecuto `$ docker-compose up`
    - Una vez que esta levantado el container en otra terminal ejecuto `$ mvn spring-boot:run`

3. Ahora podemos realizar las siguiente peticiones
    - POST 
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
        * Para obtener todos los productos se utiliza la siguiente url: http://localhost:8080/productos
        
        * Para obtener un producto especifico se utiliza la siguiente url y reemplazo {idProducto} por el numero de id que quiero buscar http://localhost:8080/productos/{idProducto}

    - DELETE
        * Para eliminar un producto especifico se utiliza la siguiente url y reemplazo {idProducto} por el numero de id que quiero eliminar http://localhost:8080/productos/{idProducto}
