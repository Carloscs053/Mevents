# 🎭 Mevents 🎭
Práctica del tema 2 realizada por Carlos Cañada Sánchez y Eduardo Cruz Muñoz (1º DAM).


# Indice

- INTRODUCCIÓN
- REQUISITOS MÍNIMOS
- DESCARGA
- MANUAL DE USUARIO
    - MENÚ PRINCIPAL
      - VENDER ENTRADAS PARA UN EVENTO
        - SELECCIÓN DEL EVENTO
        - FACTURA
        - TICKETS
    - CONSULTAR EL ESTADO DE UN EVENTO
    - MENÚ DE ADMINISTRADOR
- COLABORADORES


# INTRODUCCIÓN
En este proyecto presentamos la empresa Mevents S.A., ubicada en Martos (Jaén), que se dedica a la distribución de entradas de eventos. En este caso, hemos recibido el encargo de nuestro servicio de por parte del Auditorio Municipal de Martos para los eventos concertados en la temporada de otoño.

Los eventos en cuestión son los siguientes:

- Las Criadas (20/11/2024)
- II Concierto de Otoño (28/11/2024)
- Concierto de Jazz (06/12/2024)

Para ello, hemos puesto a disposición del Auditorio y sus espectadores nuestra aplicación. A continuación, indicaremos los pasos a seguir para su uso.


# REQUISITOS MÍNIMOS
Para poder descargar y utilizar el programa, es necesario tener instalado el siguiente programa:
- Java Runtime Envrioment 23

Para comprobar la versión de Java que tiene instalado debe realizar los siguientes pasos:
- Abrir la consola del Símbolo del sistema (buscar en la barra de búsqueda de Windows)

![image](https://github.com/user-attachments/assets/57cd02ad-aed9-4856-8f23-f7114042fba9)

- Y a continuación, escribir el comando "java -version"

![image](https://github.com/user-attachments/assets/af192d47-3e63-4103-bcef-431011e0ed9e)

A continuación vemos la versión instalada en nuestro equipo, en caso de ser uno diferente al JRE23, puede descargarlo e instalarlo en el siguiente enlace:

- https://www.oracle.com/es/java/technologies/downloads/



# DESCARGA 💾
Abrimos la pestaña de "Code", y dentro de las opciones descargamos la carpeta comprimida en un archivo .ZIP en el botón "Download ZIP".

![image](https://github.com/user-attachments/assets/f74224e8-05d1-48ef-af41-9f101ee0e99f)

Nos dirigimos a la ubicación dónde tengamos la carpeta comprimida y la descomprimimos seleccionando la carpeta, dando click derecho y seleccionando la opción de "Extraer todo..." o en la barra de opciones como se muestra en la imagen.

![image](https://github.com/user-attachments/assets/7b9ee611-c9d3-4847-b02b-3239eae34ebe)

Seguimos la ruta de directorios "Mevents_1-main > Mevents_1 > out > artifacts > Mevents_1_jar > Mevents.bat

![image](https://github.com/user-attachments/assets/c07b7225-c8fd-4284-a127-6cdc760e7630)

![image](https://github.com/user-attachments/assets/376846c5-dd9d-4e6f-aec5-56f3bc96e241)

![image](https://github.com/user-attachments/assets/e4149b61-b874-4ac9-93a5-19b49db097f4)

![image](https://github.com/user-attachments/assets/6ab88fe5-1bf3-4b3c-90f7-a972c6220f52)

![image](https://github.com/user-attachments/assets/42377819-1118-4c2d-9cbf-8c1b086721c5)

![image](https://github.com/user-attachments/assets/758f1867-af91-45b5-91b1-39d117d22542)

En las imágenes podemos ver la ruta del archivo de forma gráfica. Mevents.bat es el archivo ejecutable para iniciar el programa.


# MANUAL DE USUARIO 📖
 - MENÚ PRINCIPAL
   En el menú principal tenemos 3 opciones:
     a. Vender entradas para un evento.
     b. Consultar el estado de un evento.
     c. Menú de Administrador

   ![image](https://github.com/user-attachments/assets/c8fcfb76-ef82-4116-b7de-473ac4d7ee96)

   - COMPRAR ENTRADAS PARA UN EVENTO:
     Dentro del primer apartado, accedemos al selector del evento que desee acudir, en el que tenemos los tres eventos mencionados anteriormente, o una cuarta opción para volver al menú principal, función que se repite a lo largo del programa. Dentro de cada apartado podremos ver información del evento (fecha del evento, precio de cada asiento (platea, butaca y anfiteatro) y el descuento por la compra anticipada) y podremos elegir entre dos opciones: comprar y volver al menú principal.
     
     ![image](https://github.com/user-attachments/assets/86206ea4-ec8c-4dde-826a-920ecf4c84f8)
  
     ![image](https://github.com/user-attachments/assets/48a693fe-e64a-487e-a19f-69f44a6329a9)
  
     ![image](https://github.com/user-attachments/assets/dcdb5043-5d5e-4c24-a6a3-31060e8cc487)
  
     ![image](https://github.com/user-attachments/assets/3126b5fa-b59a-47f8-84e0-3184f87bb858)
  
     A continuación, voy a usar el evento de "Las Criadas" como ejemplo para el proceso de compra.
  
       - SELECCIÓN DEL EVENTO:
        Primero, nos pregunta la fecha (indicando el formato en el que debe ser introducido), y en caso de no querer introducir la fecha, con poner "no" automáticamente tomará la fecha actual del equipo. La finalidad de esta función es para saber si se dispone del descuento por compra anticipada (disponible si se compra con 7 días o más).
     
       ![image](https://github.com/user-attachments/assets/ce3e535b-72e1-4884-b833-b1dcba04439d)
  
       Los siguiente que nos preguntará es por el tipo de asiento que desea, en mi caso, voy a usar de ejemplo los asientos en platea.
  
       ![image](https://github.com/user-attachments/assets/2c95b6c6-495a-4889-b766-45fe0ff468d0)
  
       Introducimos la cantidad de asientos que deseamos
  
       ![image](https://github.com/user-attachments/assets/6c8e449b-af60-407b-baa6-7cc723700d4a)
  
        - FACTURA: 
       Una vez seleccionados los asientos, el programa nos generará una factura con información de nuestra compra (Número de entradas seleccionadas, precio unitario por entrada, IVA de las entradas, descuento (como vemos en las imágenes, nos indica el porcentaje a aplicar si está disponible, de lo contrario, nos sale no disponible), y el precio total a pagar) y nos pregunta con qué cantidad de dinero vamos a pagar, ya que solo se permite pagar al contado.
  
       ![image](https://github.com/user-attachments/assets/908d56fd-9497-4b19-85b1-5f7994326661)
  
       Aquí podemos ver un ejemplo en caso de que el descuento por compra anticipada no esté disponible y no lo aplica al precio final
  
       ![image](https://github.com/user-attachments/assets/e4f86fa5-65f6-418f-ae34-6dd60f7903cf)
  
  
       Según la cantidad introducida nos indicará una cosa u otra. En la siguiente imagen podemos ver lo que ocurre si se introduce una cantidad insuficiente y nos vuelve a preguntar con cuánto vamos a pagar, ya que ha rechazado el pago.
  
       ![image](https://github.com/user-attachments/assets/c449dca2-9302-4a3e-8b78-f5ebb50323ef)
  
       De lo contrario, calcula el cambio que se le debe dar. Si el cambio es 0, pasaría al siguiente paso.
  
       ![image](https://github.com/user-attachments/assets/53bd494c-7916-43d1-a9fd-025ab59a3943)
  
       En caso de haber cambio pendiente, calcula la menor cantidad de divisas que se le debe dar y se lo indica.
  
       ![image](https://github.com/user-attachments/assets/bee9285b-df46-43c3-bb4e-e6534178acb7)

       - TICKETS
         Una vez pagado, se generarán los tickets que se han adquirido con los siguientes datos:
           - El número de ticket y el total
           - Nombre del evento
           - Fecha
           - Lugar
           - Tipo de asiento
           - Precio desglosado
           - Código único de la entrada
           - Nombre de la empresa
        
         Una vez mostrados todos los tickets, te devolverá al menú principal.

       ![image](https://github.com/user-attachments/assets/01fa6829-16b1-415b-a536-8751aebc717c)


    - CONSULTAR EL ESTADO DE UN EVENTO
      Cuando nos metemos en este apartado, primero nos pregunta la fecha en la que lo estamos consultando para saber cuántos días quedan para el evento y así saber si disponemos de descuento para este o no. Usaré una fecha fija, que es 14/11/2024, para simular el estado de dos eventos y ver cómo actúa según dos eventos distintos. Primero, nos pregunta qué evento estamos interesados en conocer su estado, usaremos tanto "Las Criadas" como "II Concierto de Otoño".

      ![image](https://github.com/user-attachments/assets/7a7a8038-fc77-44de-b732-8956213af6dd)

      Una vez seleccionado vemos tres apartados:
        - Entradas vendidas
        - Entradas libres
        - Días restantes hasta el evento y si tiene descuento disponible

      ![image](https://github.com/user-attachments/assets/7267cde9-e6ef-4173-bfaf-379c1aec9e2a)

      ![image](https://github.com/user-attachments/assets/b23b859e-dec8-4521-8272-ac09380e5d30)

      ![image](https://github.com/user-attachments/assets/c14d6c9a-459d-43b2-8abb-4a4dfd5b6a89)

      En caso de estar disponible, se nos indicará de la siguiente forma. Una vez mostrado el estado del evento, nos devolverá de nuevo al menú principal

      ![image](https://github.com/user-attachments/assets/d31f02cd-2bcd-40d8-8180-725d61db65a0)


   - MENÚ DE ADMINISTRADOR
     Para acceder al menú de administrador, necesitaremos introducir las credenciales. En caso de no meter correctamente las credenciales, nos devolverá directamente al menú principal enviándonos un mensaje de error antes.

     ![image](https://github.com/user-attachments/assets/a8f830b1-8174-4e5d-8648-49c2bfe3fa19)

     Para poder hacer una demostración al usuario, se indicará las credenciales en caso de querer comprobarlo en su propio terminal.
     USER: Carlos
     PASSWORD: Venao

     Una vez dentro del menú de administrador, tendremos 4 opciones. Después de las dos primeras opciones, nos devuelve al menú de administrador, la opción 3 nos devuelve al menú principal y la opción 4 apagaría el programa:
     - Consultar los ingresos totales por evento

       ![image](https://github.com/user-attachments/assets/7d5ede70-04f3-4ec5-a339-9010e6eac3c2)

     - Consultar las monedas restantes para el cambio
    
       ![image](https://github.com/user-attachments/assets/cfcac77a-3a90-48f9-98d3-12c6bba9ac0d)
    
     - Volver al menú principal

       ![image](https://github.com/user-attachments/assets/232949a2-64bd-4d2b-8edd-5c9da865b9ae)

     - Apagar el software
    
       ![image](https://github.com/user-attachments/assets/3e713302-485b-4040-9eb7-ba81beea5715)



  Este sería todo el manual del usuario. Esperamos que les haya sido de ayuda y agradecemos la confianza en la empresa.


- COLABORADORES
    - Carlos Cañada Sánchez / Enlace GitHub: https://github.com/Carloscs053
    - Eduardo Cruz Muñoz / Enlace GitHub: https://github.com/EduardoCruzmunioz
