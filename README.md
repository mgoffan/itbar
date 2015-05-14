# ITBar

Proyecto de POO

####Integrantes

* Capparelli, Martin
* Cortés Rodríguez, Kevin 
* Goffan, Martín
* Nielavitzky, Jonatan

##Idea

Inicialmente la aplicación consiste de una pantalla inicial donde cada alumno hará log-in bajo un usuario (legajo) y contraseña. Si el usuario no está registrado, podrá crearse una cuenta ingresando: su número de legajo, mail, nombre y teléfono.

Una vez loggeado, el usuario tendrá la posibilidad de comprar en el bar de la facultad por secciones:

1. Cafetería
2. Almuerzo
3. Quisco

Si elige “Almuerzo” el usuario podrá elegir que opciones tiene para comprar. Si el usuario quiere, además de comprar el almuerzo, comprar algo de la Cafetería también 
podrá hacerlo. Cada producto será añadido a un “carrito”. Una vez que haya terminado de comprar todo, el usuario deberá confirmar la compra, elegir la forma de pago (efectivo o si se debita a la factura mensual) y seleccionar la hora en la que pasará a buscar su compra. Automáticamente, su compra se sube a una base de datos (por el momento utilizaremos 
“Parse” pero puede cambiar). Finalmente, la app devolverá un código de compra (alfanumérico o QR, todavía no está definido) que será de utilidad para el cajero.

A su vez, opcionalmente, implementaremos el sistema para PC del bar. El sistema tendrá una base de datos con los códigos propios de cada producto. Además tendrá una sección donde el gerente del bar podrá ingresar el código devuelto por la app al usuario y podrá imprimir la factura para el alumno que lo solicite. También podrá dar de baja y alta usuarios. Si hay algún usuario que no tenga la aplicación y quiera reservar la comida para una cierta hora, también podrá hacerlo por medio de la cajera (en este caso, cumpliría la misma función que la aplicación).

##Recursos

* [Play](https://www.playframework.com/)
* [Tutorial Parte 1](https://www.playframework.com/documentation/2.1.1/JavaGuide2)
* [Tutorial Parte 2](https://www.playframework.com/documentation/2.1.1/JavaGuide4)
* [Tutorial Parte 3](https://www.playframework.com/documentation/2.1.1/JavaGuide5)
* [Tutorial Parte 4](https://www.playframework.com/documentation/2.1.1/JavaGuide7)