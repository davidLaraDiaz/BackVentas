Back Ventas en Java

Descripcion:

        Conexion DB Postgresql
        Servicios API REST
        Servicios con rxJava
        Authenticacion con JWT
        Todo esta desplegado en un contenedor Docker
        Tambien se hace uso de log4j2
        pruebas de integracion con JUnit5 y Mockito
        
        Consiste en un servicio BackEnd en java con spring boot para un carrito de compras 

Prerequisitos
        JDK-11 (en caso de tener otra version se debe configurar el proyecto)
        Docker
        postgresql
        IDE con maven

Para dar mas seguridad al proyecto no solo se piden las credencias de la API,
tambien se debe enviar un usuario y contraseña, esto con el fin de dar mas seguridad ala API
(ver evidencias o archivo .json de postman)

Config Properties

        
        crear una base de datos y usuario postgrest (de preferencia debe estar vacia)
        se debe configurar el acceso a la base de datos
        en el archivo .properties en la ruta rc/resourses/

Hay dos formas de desplegar el proyecto


1- Despliegue con Docker

        para este despliegue es necesario que el usuario de postgrest tenga privilegios de conexion remota
        se ocupara el puerto 8085, cambiarlo en caso de ya estar en uso
        
        entrar al directorio del proyecto y ejecutar los siguientes comandos
        - mvn clean install
        - copiar el archivo .properties y pegarlo en target junto al jar creado anteriormente
        - docker build -t demo .
        - docker run -d -p 8085:8085 --name demoj11 demo
        
        para ver el log del compilado ejecutar
        - docker logs demoj11

       -------->al terminar de compilar ya debe estar el servicio por el puerto 8085
       
2- Despliegue con IDE

        Solo debe compilar el proyecto con el IDE de su preferencia
        (para esta opcion no es necesario tener privilegios de conexion remota a la base de datos)
        
        
        
        
Gracias por llegar hasta aqui :D

davinchis007@hotmail.com
        

        
        




