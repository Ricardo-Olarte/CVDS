# CVDS_5 ARCHILA - OLARTE

## PARTE I

### ¿Qué codigo de error sale?

Nos muestra el error 400, el cual se refiere a "bad request" ya que no puede responder la peticion dada, esto se puede deber a que la pagina de la escuela es https

### ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?

* information responses (100 - 199) como su nombre lo indica brindan informacion a diferentes tipos de peticiones.
* successfull responses (200-299)  se usan para informar que una peticion salio exitosa.
* redirection messages (300-399) se usan para redireccionar paginas web o URL .
* client error responses (400-499) se usan cuando el usuario comete un error al momento de hacer una peticion.
* Server error responses (500-599) nos indican un error o una caida en el servidor que esta atendiendo la pagina o el cliente.

### ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?

El GET envia los datos de manera visible, asi cualquier persona que acceda al URL puede ver toda la informacion de este, mientras que el POST los manda ocultos asi no son visibles por el usuario, son muy usados para formularios

Tambien existen las siguientes peticiones:
* GET
* HEAD
* PUT/POST
* TRACE

### ¿Cuáles son las diferencias con los diferentes parámetros?

curl -v nos muestra el encabezado de la URL y las respuestas esperadas, en pocas palabras nos muestra toda la informacion del GET, la coneccion al puerto 80, la IP a la que se desea acceder y demas informacion, se usa cuando se tienen problemas o se desea validar informacion. El comando curl -i no nos muestra tanta informacion como el -v, alli se ve la hora, el tipo de archivo html, la version del HTTP y la longitud de coneccion

## PARTE III

### Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?

Con el GET nos muestra el id usado (nos muestra todo el path) mientras que con el POST no nos muestra ninguna informacion del id.

### ¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.

Service me genera la "estructura" de una tabla, generando asi el ID dado, el titulo asociado, y el completed.

## PARTE IV

### Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.

* javax.javaee-api:  

* com.sun.faces.jsf-api:

* com.sun.faces.jsf-impl:

* javax.servlet.jstl:
