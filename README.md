### Laboratorio WebSokets
### David Santiago Castro Sierra
![alt text](img/img1.png)

![alt text](img/img2.png)

En donde creamos el proyecto, con la siguiente estructura:

![alt text](img/img3.png)

![alt text](img/img4.png)

Actualizamos el pom añadiendo la nueva depedencia:

![alt text](img/img5.png)

![alt text](img/img6.png)

En donde cree la siguiente clase:

![alt text](img/img7.png)

![alt text](img/img8.png)
![alt text](img/img9.png)

Creando el siguiente controlador:

![alt text](img/img10.png)

![alt text](img/img11.png)

De modo que se creo:

![alt text](img/img12.png)

![alt text](img/img13.png)

En donde vemos que esta corriendo bien:

![alt text](img/img14.png)

![alt text](img/img15.png)

Y efectivamente veremos el correcto funcionamiento de su ejecución:

![alt text](img/img16.png)

![alt text](img/img17.png)

En donde anexamos al html un try catch que intente obtener el estado y lo muestre, si no lo hace, que nos muestre el error de lo que paso:

![alt text](img/img18.png)

Con esto, veremos que el servidos nos entregara los elemntos estaticos web

![alt text](img/img19.png)

![alt text](img/img20.png)

Sobre la nota 1, ya index.html se encuentra en la ruta src/main/resources/static

Para la nota 2, agrgamos la siguiente dependencia en el pom:

![alt text](img/img21.png)

Y en aplicacion properties ponemos que no se guarde el cache, de forma que al volver a ejecutar nuestro proyecto, ya nos permite actualizar el index.html solo guardandolo y recargando el navegador sin necesidad de re ejecutar todo el proyecto

![alt text](img/img22.png)
![alt text](img/img23.png)
![alt text](img/img24.png)

En donde se realizo el siguiente Endpoint:

![alt text](img/img25.png)

![alt text](img/img26.png)
