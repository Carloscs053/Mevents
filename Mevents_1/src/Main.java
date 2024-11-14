import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

    /*Plantear dejar solo una variable de opciones. Habría que dejar solo un tipo de datos para las op, pero nos ahorramos
     una variable*/
//Te has flipado makinón


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        /*TODO Pensar en poner esperas entre pantallas (UX)*/
        //Variables para la definición de los formatos de fechas
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        final String USERADMIN = "Carlos", PASSWADMIN = "venao";
        /*El número al final de cada variable hace referencia a cada evento por orden de aparición*/
        final float PRICEMAINFLOOR1 = 17, PRICEARMCHAIR1 = 20, PRICEAMPHI1 = 13, DISCOUNT1 = 5,
                PRICEMAINFLOOR2 = 12, PRICEARMCHAIR2 = 15, PRICEAMPHI2 = 8, DISCOUNT2 = 7,
                PRICEMAINFLOOR3 = 20, PRICEARMCHAIR3 = 25, PRICEAMPHI3 = 15, DISCOUNT3 = 3, IVA = 10;
        final LocalDate DATE_EVENT1 = LocalDate.parse("20-11-2024", outputFormatter),
                DATE_EVENT2 = LocalDate.parse("28-11-2024", outputFormatter),
                DATE_EVENT3 = LocalDate.parse("06-12-2024", outputFormatter);
        final int MAINFLOOR1 = 140, ARMCHAIR1 = 200, AMPHI1 = 200,
                MAINFLOOR2 = 140, ARMCHAIR2 = 200, AMPHI2 = 200,
                MAINFLOOR3 = 140, ARMCHAIR3 = 200, AMPHI3 = 200;
        String user, passwd, date;
        //Variables para navegación entre menús
        String opMenu = "", opEvent, opPostMenu, opAdmin, opSeat, opStatus;
        //Variables para la gestión de entradas
        int mainFloor1 = 140, armChair1 = 200, amphi1 = 200, totalChair1 = (mainFloor1 + armChair1 + amphi1),
                mainFloor2 = 140, armChair2 = 200, amphi2 = 200, totalChair2 = (mainFloor2 + armChair2 + amphi2),
                mainFloor3 = 140, armChair3 = 200, amphi3 = 200, totalChair3 = (mainFloor3 + armChair3 + amphi3),
                ticket = 0;
        //Variables para la gestión de monedas que se le da al cliente y factura
        int bill500, bill200, bill100, bill50, bill20, bill10, bill5, coin2, coin1, coin050, coin020, coin010, coin005,
                coin002, coin001;
        double change, pay, receipt1 = 0, receipt2 = 0, receipt3 = 0;
        final String EVENT1 = "LAS CRIADAS", EVENT2 = "IICONCIERTO DE OTOÑO", EVENT3 = "CONCIERTO DE JAZZ",
                TYPECHAIR1 = "PLATEA", TYPECHAIR2 = "BUTACA", TYPECHAIR3 = "ANFITEATRO",
                CHARACTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String code, eventoParte, tipoAsientoParte;
        //Variable de monedas que le queda a la máquina
        int totalBill500 = 20, totalBill200 = 20, totalBill100 = 30, totalBill50 = 1000, totalBill20 = 1000,
                totalBill10 = 1000, totalBill5 = 1000, totalCoin2 = 1000, totalCoin1 = 1000, totalCoin050 = 1000,
                totalCoin020 = 1000, totalCoin010 = 1000, totalCoin005 = 1000, totalCoin002 = 1000, totalCoin001 = 1000;

        //Ganancias por evento
        float earn1 = 0, earn2 = 0, earn3 = 0;

        boolean nullDate = false, payValide, chairValide = false, ticketValide = true;
        LocalDate dateEntry = null;
        long daysBetween;

        //TODO Gobo es un Easter Egg al personaje de Scratch
        while (!opMenu.equals("Gobo")) { /*Con el bucle while, mientras la opMenu no sea 3 (opción de salida en el menú de admin
            permite apagar el programa*/
            System.out.println(""" 
                    ███╗   ███╗███████╗██╗   ██╗███████╗███╗   ██╗████████╗███████╗
                    ████╗ ████║██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝
                    ██╔████╔██║█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║   ███████╗
                    ██║╚██╔╝██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ╚════██║
                    ██║ ╚═╝ ██║███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║   ███████║
                    ╚═╝     ╚═╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝
                                        
                    \t╔════════════════════════════════════════════╗
                    \t║  ********     MENÚ PRINCIPAL     ********  ║
                    \t╠════════════════════════════════════════════╣
                    \t║  a. Comprar entradas para un evento.       ║
                    \t║  b. Consultar el estado de un evento.      ║
                    \t║  c. Menú de Administrador                  ║
                    \t╚════════════════════════════════════════════╝""");//Le metemos un tabulador al principio para
            //centrar el display de los menús y opciones
            System.out.print("\tSeleccione una opción: ");
            opMenu = s.nextLine();
            opMenu = opMenu.toLowerCase();
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
            switch (opMenu) {
                case "a"://pintamos el menu de los eventos
                    do {
                        System.out.println("""
                                \t╔═══════════════════════════════════════════╗
                                \t║        ********   EVENTO   ********       ║
                                \t╠═══════════════════════════════════════════╣
                                \t║  1. Las Criadas.                          ║
                                \t║  2. II Concierto de Otoño.                ║
                                \t║  3. Concierto de Jazz.                    ║
                                \t║  4. Menú Principal                        ║
                                \t╚═══════════════════════════════════════════╝""");
                        System.out.print("\tIntroduzca un evento: ");
                        opPostMenu = s.nextLine();
                        //Limpiar pantalla
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
                        switch (opPostMenu) {
                            case "1"://pintamos el menu de la compra de las criadas
                                do {
                                    System.out.println("""
                                            \t╔═══════════════════════════════════════════╗
                                            \t║     ********   Las Criadas   ********     ║
                                            \t╠═══════════════════════════════════════════╣
                                            \t║  - Fecha: 20/11/2024                      ║
                                            \t║  - Precio Platea: 17E                     ║
                                            \t║  - Precio Butaca: 20E                     ║
                                            \t║  - Precio Anfiteatro: 13E                 ║
                                            \t║  - Desc. Anticipado: 5%                   ║
                                            \t║                                           ║
                                            \t║    1. Comprar                  2. Menú    ║
                                            \t╚═══════════════════════════════════════════╝""");


                                    System.out.print("\tSeleccione una opción: ");
                                    opEvent = s.nextLine();
                                    switch (opEvent) {
                                        case "1"://Pedimos los datos para la compra
                                            do {
                                                while (!nullDate) {
                                                    System.out.print("\tIntroduzca una fecha (dd/MM/yyyy) o escribe 'no' para usar la fecha actual: ");
                                                    date = s.nextLine();
                                                    //se modifica el formato de la fecha
                                                    if (date.equalsIgnoreCase("no")) {
                                                        dateEntry = LocalDate.now(); // Asigna la fecha actual
                                                        //System.out.println("Fecha actual seleccionada: " + dateEntry.format(outputFormatter));
                                                        nullDate = true; // Termina el bucle
                                                    } else {
                                                        try {
                                                            // Intentar convertir el input en una fecha con el formato de entrada
                                                            dateEntry = LocalDate.parse(date, inputFormatter);
                                                            //System.out.println("Fecha ingresada correctamente: " + dateEntry.format(outputFormatter));
                                                            nullDate = true; // Termina el bucle si la fecha es válida
                                                        } catch (DateTimeParseException e) {
                                                            System.out.println("Fecha no válida, intente de nuevo.");
                                                        }
                                                    }

                                                }
                                                daysBetween = ChronoUnit.DAYS.between(dateEntry, DATE_EVENT1);
                                                if (daysBetween < 0) {
                                                    System.out.print("\tEvento Finalizado\n");
                                                    //date = "";
                                                    dateEntry = null;
                                                    nullDate = false;
                                                }
                                            } while (daysBetween < 0);
                                            do {//selección de asientos
                                                System.out.print("""
                                                        \t╔═══════════════════════════════╗
                                                        \t╠═══════════════════════════════╣
                                                        \t║  1. Platea                    ║
                                                        \t║  2. Butaca                    ║
                                                        \t║  3. Anfiteatro                ║
                                                        \t║  4. Volver atrás              ║
                                                        \t╚═══════════════════════════════╝
                                                        """);
                                                System.out.print("\tIndique tipo de asiento que desea: : ");
                                                opSeat = s.nextLine();
                                                switch (opSeat) {
                                                    case "1"://platea
                                                        do {
                                                            System.out.print("\t¿Cuántas asientos en platea desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0) {
                                                                System.out.println("\tEl número de tickets tiene que ser 1 o más.");
                                                            }
                                                            //TODO VALIDACIÓN MAL, HAY QUE CALENTARSE LA CABEZA
                                                            if (ticket > mainFloor1) {
                                                                System.out.print("Cantidad de entradas restantes insuficientes\n");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);

                                                        if (ticketValide) {
                                                            mainFloor1 -= ticket;
                                                            totalChair1 -= ticket;
                                                            chairValide = true;

                                                            receipt1 = PRICEMAINFLOOR1 * ticket;
                                                            receipt1 += ((receipt1 * IVA) / 100);
                                                            if (daysBetween >= 7) {
                                                                receipt1 = receipt1 - ((receipt1 * DISCOUNT1) / 100);
                                                            }
                                                            earn1 += (float) receipt1;
                                                        }
                                                        break;
                                                    case "2"://butaca
                                                        do {
                                                            System.out.print("\t¿Cuántas asientos en butaca desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0) {
                                                                System.out.println("\tEl número de tickets tiene que ser 1 o más.");
                                                            }
                                                            if (ticket > armChair1) {
                                                                System.out.print("\tCantidad de entradas restantes insuficientes\n");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);
                                                        if (ticketValide) {
                                                            armChair1 -= ticket;
                                                            totalChair1 -= ticket;
                                                            chairValide = true;

                                                            receipt1 = PRICEARMCHAIR1 * ticket;
                                                            receipt1 += ((receipt1 * IVA) / 100);
                                                            if (daysBetween >= 7) {
                                                                receipt1 = receipt1 - ((receipt1 * DISCOUNT1) / 100);
                                                            }
                                                            earn1 += (float) receipt1;
                                                        }
                                                        break;
                                                    case "3"://anfiteatro
                                                        do {
                                                            System.out.print("\t¿Cuántas asientos en anfiteatro desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0) {
                                                                System.out.println("\tEl número de tickets tiene que ser 1 o más.");
                                                            }
                                                            if (ticket > amphi1) {
                                                                System.out.print("\tCantidad de entradas restantes insuficientes\n");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);
                                                        if (ticketValide) {//se actualiza los datos y generando el precio de las entradas
                                                            amphi1 -= ticket;
                                                            totalChair1 -= ticket;
                                                            chairValide = true;

                                                            receipt1 = PRICEAMPHI1 * ticket;
                                                            receipt1 += ((receipt1 * IVA) / 100);
                                                            if (daysBetween >= 7) {
                                                                receipt1 = receipt1 - ((receipt1 * DISCOUNT1) / 100);
                                                            }
                                                            earn1 += (float) receipt1;
                                                        }
                                                        break;
                                                    case "4":
                                                        chairValide = false;
                                                        break;
                                                    default:
                                                        System.out.println("\tOpción no válida, tonto.");
                                                        break;
                                                }
                                                if (!ticketValide || !chairValide) {
                                                    System.out.print("\tPulse Enter...");
                                                    s.nextLine();
                                                } else {
                                                    //TODO GENERANDO TICKET
                                                    System.out.print("\tGenerando factura");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    //pintamos Factura
                                                    System.out.printf("""
                                                                    \t╔------------* FACTURA *----------╗
                                                                    \t\tEntradas: %d
                                                                    \t\tPecio Entrada: %5.2fE
                                                                    \t\tIVA: %s
                                                                    \t\tDescuento: %s
                                                                    \t\tPrecio Total: %5.2fE
                                                                    \t╚---------------------------------╝
                                                                    """, ticket, (opSeat.equals("1")) ? PRICEMAINFLOOR1 : (opSeat.equals("2") ? PRICEARMCHAIR1 : PRICEAMPHI1),
                                                            IVA + "%", (daysBetween > 7) ? DISCOUNT1 + "%" : "No disponible", receipt1);
                                                    //recomendación calculando cambio
                                                    do {//validamos que el pago sea el correcto
                                                        payValide = true;
                                                        System.out.print("\t¿Con cuánto desea pagar? Formato de pago (0.00): ");
                                                        pay = Float.parseFloat(s.nextLine());
                                                        if (pay < 0) {
                                                            System.out.println("\tValor introducido no permitido.");
                                                            payValide = false;
                                                        }
                                                        if (pay > 0 && pay < receipt1) {
                                                            System.out.println("Debe pagar con la misma cantidad o superior");
                                                            payValide = false;
                                                        }
                                                    } while (!payValide);
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    change = ((Math.round((receipt1 - pay) * 100)) / 100f); //Aquí saco el cambio con tan solo 2 decimales
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    change = (Math.abs((change * 100))) / 100f; //Como aquí change llega en negativo, lo paso a positivo con solo 2 decimales
                                                    //Mejorar la interfaz de usuario
                                                    System.out.print("\tCalculando cambio");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    //Pintar el cambio de la factura
                                                    System.out.printf("Su cambio es de %.2f euros.\n", Math.abs(change)); //Y le digo el change a percibir

                                                    while (change > 0) { //Empiezo un bucle mientras el change sea mayor que 0 para que calcule las monedas a devolver
                                                        change = Math.round(change * 100.0) / 100.0;//nos da en cambio con dos decimales exactos
                                                        //change = Math.abs(change);
                                                        if (change >= 500) { //Comprueba si el change es mayor a 500
                                                            bill500 = Math.abs((int) change / 500); //Si lo es, calcula cuantos billetes tiene que darle
                                                            System.out.printf("\tBilletes de 500 euros: %d\n", bill500);//Informa la cantidad de la divisa
                                                            change %= 500; //Saca el módulo de 500 para pasar al siguiente nivel
                                                            totalBill500 -= bill500;
                                                            //ESTE PROCESO SE REPITE EN CADA CONDICIÓN, NO VOY A COMENTAR TODOS EDU, LO SIENTO
                                                        } else if (change >= 200) {
                                                            bill200 = Math.abs((int) change / 200);
                                                            System.out.printf("\tBilletes de 200 euros: %d\n", bill200);
                                                            change %= 200;
                                                            totalBill200 -= bill200;
                                                        } else if (change >= 100) {
                                                            bill100 = Math.abs((int) change / 100);
                                                            System.out.printf("\tBilletes de 100 euros: %d\n", bill100);
                                                            change %= 100;
                                                            totalBill100 -= bill100;
                                                        } else if (change >= 50) {
                                                            bill50 = Math.abs((int) change / 50);
                                                            System.out.printf("\tBilletes de 50 euros: %d\n", bill50);
                                                            change %= 50;
                                                            totalBill50 -= bill50;
                                                        } else if (change >= 20) {
                                                            bill20 = Math.abs((int) change / 20);
                                                            System.out.printf("\tBilletes de 20 euros: %d\n", bill20);
                                                            change %= 20;
                                                            totalBill20 -= bill20;
                                                        } else if (change >= 10) {
                                                            bill10 = Math.abs((int) change / 10);
                                                            System.out.printf("\tBilletes de 10 euros: %d\n", bill10);
                                                            change %= 10;
                                                            totalBill10 -= bill10;
                                                        } else if (change >= 5) {
                                                            bill5 = Math.abs((int) change / 5);
                                                            System.out.printf("\tBilletes de 5 euros: %d\n", bill5);
                                                            change %= 5;
                                                            totalBill5 -= bill5;
                                                        } else if (change >= 2) {
                                                            coin2 = Math.abs((int) change / 2);
                                                            System.out.printf("\tMonedas de 2 euros: %d\n", coin2);
                                                            change %= 2;
                                                            totalCoin2 -= coin2;
                                                        } else if (change >= 1) {
                                                            coin1 = Math.abs((int) change);
                                                            System.out.printf("\tMonedas de 1 euro: %d\n", coin1);
                                                            change %= 1;
                                                            totalCoin1 -= coin1;
                                                        } else if (change >= 0.50) {
                                                            coin050 = (int) Math.abs(change / 0.50);
                                                            System.out.printf("\tMonedas de 50 céntimos: %d\n", coin050);
                                                            change %= 0.50;
                                                            totalCoin050 -= coin050;
                                                        } else if (change >= 0.20) {
                                                            coin020 = (int) Math.abs(change / 0.20);
                                                            System.out.printf("\tMonedas de 20 céntimos: %d\n", coin020);
                                                            change %= 0.20;
                                                            totalCoin020 -= coin020;
                                                        } else if (change >= 0.10) {
                                                            coin010 = (int) Math.abs(change / 0.10);
                                                            System.out.printf("\tMonedas de 10 céntimos: %d\n", coin010);
                                                            change %= 0.10;
                                                            totalCoin010 -= coin010;
                                                        } else if (change >= 0.05) {
                                                            coin005 = (int) Math.abs(change / 0.05);
                                                            System.out.printf("\tMonedas de 5 céntimos: %d\n", coin005);
                                                            change %= 0.05;
                                                            totalCoin005 -= coin005;
                                                        } else if (change >= 0.02) {
                                                            coin002 = (int) Math.abs(change / 0.02);
                                                            System.out.printf("\tMonedas de 2 céntimos: %d\n", coin002);
                                                            change %= 0.02;
                                                            totalCoin002 -= coin002;
                                                        } else if (change >= 0.01) {
                                                            coin001 = (int) Math.abs(change / 0.01);
                                                            System.out.printf("\tMonedas de 1 céntimo: %d\n", coin001);
                                                            change %= 0.01;
                                                            totalCoin001 -= coin001;
                                                        } else if (change < 0.01) { //Último else para salir del bucle
                                                            change = 0;
                                                        }
                                                    }
                                                    System.out.print("\tPulse para crear ticket");
                                                    s.nextLine();
                                                    // Muestra un mensaje de "Creando ticket" y luego simula un proceso de carga con puntos.
                                                    System.out.print("\tCreando ticket");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    // Limpia la consola simulando que se borran las líneas impresas anteriormente.
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    // Genera el código para los tickets.
                                                    for (int i = 1; i <= ticket; i++) {
                                                        code = "";// Inicializa el código como una cadena vacía.
                                                        System.out.printf("Entrada %d de %d\n", i, ticket);
                                                        // Obtiene las primeras 3 letras del nombre del evento y las convierte a mayúsculas.
                                                        eventoParte = EVENT1.substring(0, 3).toUpperCase();
                                                        // Determina el tipo de asiento seleccionado y toma sus primeras 3 letras en mayúsculas.
                                                        if (opSeat.equals("1"))
                                                            tipoAsientoParte = TYPECHAIR1.substring(0, 3).toUpperCase();
                                                        else if ((opSeat.equals("2")))
                                                            tipoAsientoParte = TYPECHAIR2.substring(0, 3).toUpperCase();
                                                        else
                                                            tipoAsientoParte = TYPECHAIR3.substring(0, 3).toUpperCase();

                                                        // Concatena el código del evento y el tipo de asiento con un guion.
                                                        code += eventoParte + tipoAsientoParte + "-";

                                                        // Genera 4 caracteres aleatorios a partir de la cadena 'CHARACTER'.
                                                        for (int j = 0; j < 4; j++) {
                                                            int index = random.nextInt(CHARACTER.length());
                                                            code += CHARACTER.charAt(index);
                                                        }

                                                        // Aquí se muestra el ticket generado con todos los detalles.
                                                        System.out.printf("""
                                                                        ╔---------* TICKET *--------------------------------------------------------------------╗
                                                                                   ccee88oo            NOMBRE: %s\t\t%s
                                                                               C8O8O8Q8PoOb o8oo       LUGAR: Auditorio Municipal de Martos.
                                                                             dOB69QO8PdUOpugoO9bD      ASIENTO: %s
                                                                            CgggbU8OU qOp qOdoUOdcb
                                                                              6OuU  /p u gcoUodpP      PRECIO ENTRADA %.2f€ + IVA %s : %.2fE = %.2fE
                                                                                 \\\\\\//  /douUP      %s
                                                                                  \\\\\\////
                                                                                    |||/\\
                                                                                    |||\\/
                                                                                   |||||
                                                                              .....||||||....
                                                                                                                                                
                                                                              code: %s                                                     MEVENTS S.A.
                                                                        ╚---------------------------------------------------------------------------------------╝
                                                                        """, EVENT1, DATE_EVENT1.format(outputFormatter),// Nombre del evento y fecha formateada.
                                                                (opSeat.equals("1")) ? TYPECHAIR1 : (opSeat.equals("2") ? TYPECHAIR2 : TYPECHAIR3),// Tipo de asiento.
                                                                (opSeat.equals("1")) ? PRICEMAINFLOOR1 : (opSeat.equals("2") ? PRICEARMCHAIR1 : PRICEAMPHI1),// Precio del asiento sin IVA.
                                                                IVA + "%", (opSeat.equals("1")) ? ((PRICEMAINFLOOR1 * IVA) / 100) : (opSeat.equals("2") ? ((PRICEARMCHAIR1 * IVA) / 100) : ((PRICEAMPHI1 * IVA) / 100)),// IVA aplicado.
                                                                (opSeat.equals("1")) ? (PRICEMAINFLOOR1 + (PRICEMAINFLOOR1 * IVA) / 100) : (opSeat.equals("2") ? (PRICEARMCHAIR1 + (PRICEARMCHAIR1 * IVA) / 100) : (PRICEAMPHI1 + (PRICEAMPHI1 * IVA) / 100)),// Precio con IVA.
                                                                // Calcula el descuento si la compra fue anticipada.
                                                                (daysBetween > 7 && opSeat.equals("1")) ? "Descuento " + DISCOUNT1 + "% = " + ((PRICEMAINFLOOR1 * DISCOUNT1) / 100)
                                                                        : (daysBetween > 7 && opSeat.equals("2")) ? "Descuento " + DISCOUNT1 + "% = " + ((PRICEARMCHAIR1 * DISCOUNT1) / 100)
                                                                        : (daysBetween > 7 && opSeat.equals("3")) ? "Descuento " + DISCOUNT1 + "% = " + ((PRICEAMPHI1 * DISCOUNT1) / 100) : "", code);// Código generado para el ticket.
                                                        // Si hay más tickets por imprimir, espera a que el usuario presione Enter para continuar.
                                                        if (i < ticket) {
                                                            System.out.print("Pulse para continuar...");
                                                            s.nextLine();
                                                        }
                                                    }
                                                }
                                                // Sección que maneja la lógica de validación de opciones seleccionadas.
                                                if (!ticketValide) {
                                                    opEvent = "2";
                                                    opPostMenu = "4";

                                                } else if (!opSeat.equals("4")) {
                                                    opSeat = "4";
                                                    opEvent = "2";
                                                    opPostMenu = "4";
                                                    System.out.print("\tPulse para volver al menú...");
                                                    s.nextLine();
                                                }
                                                nullDate = false;
                                                ticketValide = true;
                                                // Bucle que se repite hasta que la opción de asiento sea "4", es decir, cancelar la compra.
                                            } while (!opSeat.equals("4"));
                                            break;
                                        case "2":
                                            System.out.println("\tVolviendo");
                                            break;
                                        default:
                                            System.out.println("\tOpción no válida");
                                            break;
                                    }
                                    for (int i = 0; i < 100; i++) {
                                        System.out.println();
                                    }
                                } while (!opEvent.equalsIgnoreCase("2"));
                                break;
                            case "2":
                                do {
                                    System.out.println("""
                                            \t╔═════════════════════════════════════════════════════╗
                                            \t║     ********   II Concierto de Otoño   ********     ║
                                            \t╠═════════════════════════════════════════════════════╣
                                            \t║  - Fecha: 28/11/2024                                ║
                                            \t║  - Precio Platea: 12E                               ║
                                            \t║  - Precio Butaca: 15E                               ║
                                            \t║  - Precio Anfiteatro: 8E                            ║
                                            \t║  - Desc. Anticipado: 7%                             ║
                                            \t║                                                     ║
                                            \t║    1. Comprar                            2. Menú    ║
                                            \t╚═════════════════════════════════════════════════════╝""");


                                    System.out.print("\tSeleccione una opción: ");
                                    opEvent = s.nextLine();
                                    switch (opEvent) {
                                        case "1":
                                            do {
                                                while (!nullDate) {
                                                    System.out.print("\tIntroduzca una fecha (dd/MM/yyyy) o escribe 'no' para usar la fecha actual: ");
                                                    date = s.nextLine();

                                                    if (date.equalsIgnoreCase("no")) {
                                                        dateEntry = LocalDate.now(); // Asigna la fecha actual
                                                        //System.out.println("Fecha actual seleccionada: " + dateEntry.format(outputFormatter));
                                                        nullDate = true; // Termina el bucle
                                                    } else {
                                                        try {
                                                            // Intentar convertir el input en una fecha con el formato de entrada
                                                            dateEntry = LocalDate.parse(date, inputFormatter);
                                                            //System.out.println("Fecha ingresada correctamente: " + dateEntry.format(outputFormatter));
                                                            nullDate = true; // Termina el bucle si la fecha es válida
                                                        } catch (DateTimeParseException e) {
                                                            System.out.println("Fecha no válida, intente de nuevo.");
                                                        }
                                                    }

                                                }
                                                daysBetween = ChronoUnit.DAYS.between(dateEntry, DATE_EVENT2);
                                                if (daysBetween < 0) {
                                                    System.out.print("\tEvento Finalizado\n");
                                                    //date = "";
                                                    dateEntry = null;
                                                    nullDate = false;
                                                }
                                            } while (daysBetween < 0);
                                            do {
                                                System.out.print("""
                                                        \t╔═══════════════════════════════╗
                                                        \t╠═══════════════════════════════╣
                                                        \t║  1. Platea                    ║
                                                        \t║  2. Butaca                    ║
                                                        \t║  3. Anfiteatro                ║
                                                        \t║  4. Menú                      ║
                                                        \t╚═══════════════════════════════╝
                                                        """);
                                                System.out.print("\tIndique tipo de asiento que desea: ");
                                                opSeat = s.nextLine();
                                                switch (opSeat) {
                                                    case "1":
                                                        do {
                                                            System.out.print("\t¿Cuántos asientos en platea desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0)
                                                                System.out.println("El número de tickets tiene que ser 1 o más.");
                                                            if (ticket > mainFloor2) {
                                                                System.out.println("Cantidad de entradas restantes insuficientes");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);
                                                        //TODO TERMINAR LAS VALIDACIONES
                                                        mainFloor2 -= ticket;
                                                        totalChair2 -= ticket;
                                                        chairValide = true;

                                                        receipt2 = PRICEMAINFLOOR2 * ticket;
                                                        if (daysBetween >= 7) {
                                                            receipt2 = receipt2 - ((receipt2 * DISCOUNT2) / 100);
                                                        }
                                                        receipt2 += ((receipt2 * IVA) / 100);
                                                        earn2 += (float) receipt2;
                                                        break;
                                                    case "2":
                                                        do {
                                                            System.out.print("\t¿Cuántos asientos en butaca desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0)
                                                                System.out.println("El número de tickets tiene que ser 1 o más.");
                                                            if (ticket > armChair2) {
                                                                System.out.println("Cantidad de entradas restantes insuficientes");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);
                                                        armChair2 -= ticket;
                                                        totalChair2 -= ticket;
                                                        chairValide = true;

                                                        receipt2 = PRICEARMCHAIR2 * ticket;
                                                        receipt2 += ((receipt2 * IVA) / 100);
                                                        if (daysBetween >= 7) {
                                                            receipt2 = receipt2 - ((receipt2 * DISCOUNT2) / 100);
                                                        }
                                                        earn2 += (float) receipt2;
                                                        break;
                                                    case "3":
                                                        do {
                                                            System.out.print("\t¿Cuántos asientos en anfiteatro desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0)
                                                                System.out.println("El número de tickets tiene que ser 1 o más.");
                                                            if (ticket > amphi2) {
                                                                System.out.println("Cantidad de entradas restantes insuficientes");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);
                                                        amphi2 -= ticket;
                                                        totalChair2 -= ticket;
                                                        chairValide = true;

                                                        receipt2 = PRICEAMPHI2 * ticket;
                                                        receipt2 += ((receipt2 * IVA) / 100);
                                                        if (daysBetween >= 7) {
                                                            receipt2 = receipt2 - ((receipt2 * DISCOUNT2) / 100);
                                                        }
                                                        earn2 += (float) receipt2;
                                                        break;
                                                    case "4":
                                                        chairValide = false;
                                                        break;
                                                    default:
                                                        System.out.println("Opción no válida.");
                                                        break;
                                                }
                                                if (!chairValide || !ticketValide)
                                                    System.out.println("Pulse Enter...");
                                                else {
                                                    // Mejorar la interfaz de usuario con una simulación de cálculo de cambio.
                                                    System.out.print("\tGenerando factura");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }// Limpia la consola simulando que se borran las líneas impresas anteriormente.
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    //pintamos Factura
                                                    System.out.printf("""
                                                                    \t╔------------* FACTURA *----------╗
                                                                    \t\tEntradas: %d
                                                                    \t\tPecio Entrada: %5.2fE
                                                                    \t\tIVA: %s
                                                                    \t\tDescuento: %s
                                                                    \t\tPrecio Total: %5.2fE
                                                                    \t╚---------------------------------╝
                                                                    """, ticket, (opSeat.equals("1")) ? PRICEMAINFLOOR2 : (opSeat.equals("2") ? PRICEARMCHAIR2 : PRICEAMPHI2),
                                                            IVA + "%", (daysBetween > 7) ? DISCOUNT2 + "%" : "No disponible", receipt2);
                                                    do {//validamos que el pago sea el correcto
                                                        payValide = true;
                                                        System.out.print("\t¿Con cuanto desea pagar? Formato de pago (0.00): ");
                                                        pay = Float.parseFloat(s.nextLine());
                                                        if (pay < 0) {
                                                            System.out.println("\tValor introducido no permitido.");
                                                            payValide = false;
                                                        }
                                                        if (pay > 0 && pay < receipt2) {
                                                            System.out.println("\tDebe pagar con la misma cantidad o superior");
                                                            payValide = false;
                                                        }
                                                    } while (!payValide);
                                                    change = ((Math.round((receipt2 - pay) * 100)) / 100f); //Aquí saco el cambio con tan solo 2 decimales
                                                    //Mejorar la interfaz de usuario
                                                    System.out.print("\tCalculando cambio");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    //Pintar el cambio de la factura
                                                    change = (Math.abs((change * 100))) / 100f; //Como aquí change llega en negativo, lo paso a positivo con solo 2 decimales
                                                    System.out.printf("Su cambio es de %.2f euros.\n", Math.abs(change)); //Y le digo el change a percibir

                                                    while (change > 0) { //Empiezo un bucle mientras el change sea mayor que 0 para que calcule las monedas a devolver
                                                        change = Math.round(change * 100.0) / 100.0;//nos da en cambio con dos decimales exactos
                                                        //change = Math.abs(change);
                                                        if (change >= 500) { //Comprueba si el change es mayor a 500
                                                            bill500 = Math.abs((int) change / 500); //Si lo es, calcula cuantos billetes tiene que darle
                                                            System.out.printf("\tBilletes de 500 euros: %d\n", bill500);//Informa la cantidad de la divisa
                                                            change %= 500; //Saca el módulo de 500 para pasar al siguiente nivel
                                                            totalBill500 -= bill500;
                                                            //ESTE PROCESO SE REPITE EN CADA CONDICIÓN, NO VOY A COMENTAR TODOS EDU, LO SIENTO
                                                        } else if (change >= 200) {
                                                            bill200 = Math.abs((int) change / 200);
                                                            System.out.printf("\tBilletes de 200 euros: %d\n", bill200);
                                                            change %= 200;
                                                            totalBill200 -= bill200;
                                                        } else if (change >= 100) {
                                                            bill100 = Math.abs((int) change / 100);
                                                            System.out.printf("\tBilletes de 100 euros: %d\n", bill100);
                                                            change %= 100;
                                                            totalBill100 -= bill100;
                                                        } else if (change >= 50) {
                                                            bill50 = Math.abs((int) change / 50);
                                                            System.out.printf("\tBilletes de 50 euros: %d\n", bill50);
                                                            change %= 50;
                                                            totalBill50 -= bill50;
                                                        } else if (change >= 20) {
                                                            bill20 = Math.abs((int) change / 20);
                                                            System.out.printf("\tBilletes de 20 euros: %d\n", bill20);
                                                            change %= 20;
                                                            totalBill20 -= bill20;
                                                        } else if (change >= 10) {
                                                            bill10 = Math.abs((int) change / 10);
                                                            System.out.printf("\tBilletes de 10 euros: %d\n", bill10);
                                                            change %= 10;
                                                            totalBill10 -= bill10;
                                                        } else if (change >= 5) {
                                                            bill5 = Math.abs((int) change / 5);
                                                            System.out.printf("\tBilletes de 5 euros: %d\n", bill5);
                                                            change %= 5;
                                                            totalBill5 -= bill5;
                                                        } else if (change >= 2) {
                                                            coin2 = Math.abs((int) change / 2);
                                                            System.out.printf("\tMonedas de 2 euros: %d\n", coin2);
                                                            change %= 2;
                                                            totalCoin2 -= coin2;
                                                        } else if (change >= 1) {
                                                            coin1 = Math.abs((int) change);
                                                            System.out.printf("\tMonedas de 1 euro: %d\n", coin1);
                                                            change %= 1;
                                                            totalCoin1 -= coin1;
                                                        } else if (change >= 0.50) {
                                                            coin050 = (int) Math.abs(change / 0.50);
                                                            System.out.printf("\tMonedas de 50 céntimos: %d\n", coin050);
                                                            change %= 0.50;
                                                            totalCoin050 -= coin050;
                                                        } else if (change >= 0.20) {
                                                            coin020 = (int) Math.abs(change / 0.20);
                                                            System.out.printf("\tMonedas de 20 céntimos: %d\n", coin020);
                                                            change %= 0.20;
                                                            totalCoin020 -= coin020;
                                                        } else if (change >= 0.10) {
                                                            coin010 = (int) Math.abs(change / 0.10);
                                                            System.out.printf("\tMonedas de 10 céntimos: %d\n", coin010);
                                                            change %= 0.10;
                                                            totalCoin010 -= coin010;
                                                        } else if (change >= 0.05) {
                                                            coin005 = (int) Math.abs(change / 0.05);
                                                            System.out.printf("\tMonedas de 5 céntimos: %d\n", coin005);
                                                            change %= 0.05;
                                                            totalCoin005 -= coin005;
                                                        } else if (change >= 0.02) {
                                                            coin002 = (int) Math.abs(change / 0.02);
                                                            System.out.printf("\tMonedas de 2 céntimos: %d\n", coin002);
                                                            change %= 0.02;
                                                            totalCoin002 -= coin002;
                                                        } else if (change >= 0.01) {
                                                            coin001 = (int) Math.abs(change / 0.01);
                                                            System.out.printf("\tMonedas de 1 céntimo: %d\n", coin001);
                                                            change %= 0.01;
                                                            totalCoin001 -= coin001;
                                                        } else if (change < 0.01) { //Último else para salir del bucle
                                                            change = 0;
                                                        }
                                                    }
                                                    System.out.print("\tPulse para crear ticket");
                                                    s.nextLine();
                                                    // Muestra un mensaje de "Creando ticket" y luego simula un proceso de carga con puntos.
                                                    System.out.print("\tCreando ticket");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }// Limpia la consola simulando que se borran las líneas impresas anteriormente.
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    // Genera el código para los tickets.
                                                    for (int i = 1; i <= ticket; i++) {
                                                        code = "";// Inicializa el código como una cadena vacía.
                                                        System.out.printf("Entrada %d de %d\n", i, ticket);
                                                        // Obtiene las primeras 3 letras del nombre del evento y las convierte a mayúsculas.
                                                        eventoParte = EVENT2.substring(0, 3).toUpperCase();
                                                        // Determina el tipo de asiento seleccionado y toma sus primeras 3 letras en mayúsculas.
                                                        if (opSeat.equals("1"))
                                                            tipoAsientoParte = TYPECHAIR1.substring(0, 3).toUpperCase();
                                                        else if ((opSeat.equals("2")))
                                                            tipoAsientoParte = TYPECHAIR2.substring(0, 3).toUpperCase();
                                                        else
                                                            tipoAsientoParte = TYPECHAIR3.substring(0, 3).toUpperCase();
                                                        // Concatena el código del evento y el tipo de asiento con un guion.
                                                        code += eventoParte + tipoAsientoParte + "-";

                                                        // Genera 4 caracteres aleatorios a partir de la cadena 'CHARACTER'.
                                                        for (int j = 0; j < 4; j++) {
                                                            int index = random.nextInt(CHARACTER.length());
                                                            code += CHARACTER.charAt(index);
                                                        }
                                                        //Aquí se pinta el ticket
                                                        System.out.printf("""
                                                                        ╔---------* TICKET *--------------------------------------------------------------------╗
                                                                                   ccee88oo            NOMBRE: %s\t\t%s
                                                                               C8O8O8Q8PoOb o8oo       LUGAR: Auditorio Municipal de Martos.
                                                                             dOB69QO8PdUOpugoO9bD      ASIENTO: %s
                                                                            CgggbU8OU qOp qOdoUOdcb
                                                                              6OuU  /p u gcoUodpP      PRECIO ENTRADA %.2fE + IVA %s : %.2fE = %.2fE
                                                                                 \\\\\\//  /douUP      %s
                                                                                  \\\\\\////
                                                                                    |||/\\
                                                                                    |||\\/
                                                                                    |||||
                                                                              .....||||||....
                                                                                                                                                
                                                                              code: %s                                                     MEVENTS S.A.
                                                                        ╚---------------------------------------------------------------------------------------╝
                                                                        """, EVENT2, DATE_EVENT2.format(outputFormatter),// Nombre del evento y fecha formateada.
                                                                (opSeat.equals("1")) ? TYPECHAIR1 : (opSeat.equals("2") ? TYPECHAIR2 : TYPECHAIR3),// Tipo de asiento.
                                                                (opSeat.equals("1")) ? PRICEMAINFLOOR2 : (opSeat.equals("2") ? PRICEARMCHAIR2 : PRICEAMPHI2),// Precio del asiento sin IVA.
                                                                IVA + "%", (opSeat.equals("1")) ? ((PRICEMAINFLOOR2 * IVA) / 100) : (opSeat.equals("2") ? ((PRICEARMCHAIR2 * IVA) / 100) : ((PRICEAMPHI2 * IVA) / 100)),// IVA aplicado.
                                                                (opSeat.equals("1")) ? (PRICEMAINFLOOR2 + (PRICEMAINFLOOR2 * IVA) / 100) : (opSeat.equals("2") ? (PRICEARMCHAIR2 + (PRICEARMCHAIR2 * IVA) / 100) : (PRICEAMPHI2 + (PRICEAMPHI2 * IVA) / 100)),// Calcula el descuento si la compra fue anticipada.
                                                                (daysBetween > 7 && opSeat.equals("1")) ? "Descuento " + DISCOUNT2 + "% = " + ((PRICEMAINFLOOR2 * DISCOUNT2) / 100)
                                                                        : (daysBetween > 7 && opSeat.equals("2")) ? "Descuento " + DISCOUNT2 + "% = " + ((PRICEARMCHAIR2 * DISCOUNT2) / 100)
                                                                        : (daysBetween > 7 && opSeat.equals("3")) ? "Descuento " + DISCOUNT2 + "% = " + ((PRICEAMPHI2 * DISCOUNT2) / 100) : "", code);// Código generado para el ticket.
                                                        // Si hay más tickets por imprimir, espera a que el usuario presione Enter para continuar.
                                                        if (i < ticket) {
                                                            System.out.println("\tPulse para continuar...");
                                                            s.nextLine();
                                                        }
                                                    }
                                                }
                                                // Sección que maneja la lógica de validación de opciones seleccionadas.
                                                nullDate = false;
                                                if (!ticketValide) {
                                                    opEvent = "2";
                                                    opPostMenu = "4";
                                                } else if (!opSeat.equals("4")) {
                                                    opSeat = "4";
                                                    opEvent = "2";
                                                    opPostMenu = "4";
                                                    System.out.print("\tPulse para volver al menú...");
                                                    s.nextLine();
                                                }
                                            } while (!opSeat.equals("4"));// Bucle que se repite hasta que la opción de asiento sea "4", es decir, cancelar la compra.
                                            break;
                                        case "2":
                                            System.out.println("Volviendo");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                    for (int i = 0; i < 100; i++) {
                                        System.out.println();
                                    }
                                } while (!opEvent.equalsIgnoreCase("2"));
                                break;
                            case "3":
                                do {
                                    System.out.print("""
                                            \t╔═════════════════════════════════════════════════╗
                                            \t║     ********   Concierto de Jazz   ********     ║
                                            \t╠═════════════════════════════════════════════════╣
                                            \t║  - Fecha: 06/12/2024                            ║
                                            \t║  - Precio Platea: 20E                           ║
                                            \t║  - Precio Butaca: 25E                           ║
                                            \t║  - Precio Anfiteatro: 15E                       ║
                                            \t║  - Desc. Anticipado: 3%                         ║
                                            \t║                                                 ║
                                            \t║    1. Compra                        2. Menú     ║
                                            \t╚═════════════════════════════════════════════════╝
                                            """);

                                    System.out.print("\tSeleccione una opción: ");
                                    opEvent = s.nextLine();
                                    switch (opEvent) {
                                        case "1":
                                            do {
                                                while (!nullDate) {
                                                    System.out.print("\tIntroduzca una fecha (dd/MM/yyyy) o escriba 'no' para usar la fecha actual: ");
                                                    date = s.nextLine();

                                                    if (date.equalsIgnoreCase("no")) {
                                                        dateEntry = LocalDate.now(); // Asigna la fecha actual
                                                        //System.out.println("Fecha actual seleccionada: " + dateEntry.format(outputFormatter));
                                                        nullDate = true; // Termina el bucle
                                                    } else {
                                                        try {
                                                            // Intentar convertir el input en una fecha con el formato de entrada
                                                            dateEntry = LocalDate.parse(date, inputFormatter);
                                                            //System.out.println("Fecha ingresada correctamente: " + dateEntry.format(outputFormatter));
                                                            nullDate = true; // Termina el bucle si la fecha es válida
                                                        } catch (DateTimeParseException e) {
                                                            System.out.println("Fecha no válida, intente de nuevo.");
                                                        }
                                                    }

                                                }
                                                daysBetween = ChronoUnit.DAYS.between(dateEntry, DATE_EVENT3);
                                                if (daysBetween < 0) {
                                                    System.out.print("\tEvento Finalizado\n");
                                                    //date = "";
                                                    dateEntry = null;
                                                    nullDate = false;
                                                }
                                            } while (daysBetween < 0);
                                            do {
                                                System.out.print("""
                                                        \t╔═══════════════════════════════╗
                                                        \t╠═══════════════════════════════╣
                                                        \t║  1. Platea                    ║
                                                        \t║  2. Butaca                    ║
                                                        \t║  3. Anfiteatro                ║
                                                        \t║  4. Menú                      ║
                                                        \t╚═══════════════════════════════╝
                                                        """);
                                                System.out.print("\tIndique tipo de asiento que desea: ");
                                                opSeat = s.nextLine();
                                                switch (opSeat) {
                                                    case "1"://compra de asientos en platea
                                                        do {
                                                            // Se solicita al usuario la cantidad de asientos en platea que desea comprar.
                                                            System.out.print("\t¿Cuántos asientos en platea desea? :");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0)// Verifica que el número de tickets solicitado sea mayor a 0.
                                                                System.out.println("El número de tickets tiene que ser 1 o más.");
                                                            if (ticket > mainFloor3) {// Verifica que la cantidad solicitada no exceda la cantidad disponible en platea.
                                                                System.out.print("Cantidad de entradas restantes insuficientes\n");
                                                                ticketValide = false;// Marca la validez del ticket como falsa si no hay suficientes entradas.
                                                            }
                                                        } while (ticket <= 0);// Repite el ciclo hasta que el usuario introduzca un número válido.
                                                        // Descuenta la cantidad de asientos comprados del total disponible en platea.
                                                        mainFloor3 -= ticket;
                                                        totalChair3 -= ticket;
                                                        chairValide = true;
                                                        // Calcula el costo del recibo considerando el precio de platea.
                                                        receipt3 = PRICEMAINFLOOR3 * ticket;
                                                        receipt3 += ((receipt3 * IVA) / 100);
                                                        // Si la compra se realiza con 7 días o más de anticipación, aplica un descuento.
                                                        if (daysBetween >= 7) {
                                                            receipt3 = receipt3 - ((receipt3 * DISCOUNT3) / 100);
                                                        }
                                                        // Suma del recibo a las ganancias totales.
                                                        earn3 += (float) receipt3;
                                                        break;
                                                    case "2"://compra de asientos en butaca
                                                        do {
                                                            // Se solicita al usuario la cantidad de asientos en butaca que desea comprar.
                                                            System.out.print("\t¿Cuántos asientos en butaca desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0)// Verifica que el número de tickets solicitado sea mayor a 0.
                                                                System.out.println("El número de tickets tiene que ser 1 o más.");
                                                            if (ticket > armChair3) {// Verifica que la cantidad solicitada no exceda la cantidad disponible en butaca.
                                                                System.out.print("Cantidad de entradas restantes insuficientes\n");
                                                                ticketValide = false;// Marca la validez del ticket como falsa si no hay suficientes entradas.
                                                            }
                                                        } while (ticket <= 0);// Repite el ciclo hasta que el usuario introduzca un número válido.
                                                        // Descuenta la cantidad de asientos comprados del total disponible en butaca.
                                                        armChair3 -= ticket;
                                                        totalChair3 -= ticket;
                                                        chairValide = true;
                                                        // Calcula el costo del recibo considerando el precio de butaca.
                                                        receipt3 = PRICEARMCHAIR3 * ticket;
                                                        receipt3 += ((receipt3 * IVA) / 100);
                                                        // Si la compra se realiza con 7 días o más de anticipación, aplica un descuento.
                                                        if (daysBetween >= 7) {
                                                            receipt3 = receipt3 - ((receipt3 * DISCOUNT3) / 100);
                                                        }
                                                        // Suma del recibo a las ganancias totales.
                                                        earn3 += (float) receipt3;
                                                        break;
                                                    case "3":
                                                        do
                                                        {// Se solicita al usuario la cantidad de asientos en anfiteatro que desea comprar.
                                                            System.out.print("\t¿Cuántos asientos en anfiteatro desea?: ");
                                                            ticket = Integer.parseInt(s.nextLine());
                                                            if (ticket <= 0)// Verifica que el número de tickets solicitado sea mayor a 0.
                                                                System.out.println("El número de tickets tiene que ser 1 o más.");
                                                            if (ticket > amphi3) {// Verifica que la cantidad solicitada no exceda la cantidad disponible en anfiteatro.
                                                                System.out.print("Cantidad de entradas restantes insuficientes\n");
                                                                ticketValide = false;
                                                            }
                                                        } while (ticket <= 0);// Repite el ciclo hasta que el usuario introduzca un número válido.
                                                        // Descuenta la cantidad de asientos comprados del total disponible en anfiteatro.
                                                        amphi3 -= ticket;
                                                        totalChair3 -= ticket;
                                                        chairValide = true;
                                                        // Calcula el costo del recibo considerando el precio de anfiteatro.
                                                        receipt3 = PRICEAMPHI3 * ticket;
                                                        receipt3 += ((receipt3 * IVA) / 100);
                                                        // Si la compra se realiza con 7 días o más de anticipación, aplica un descuento.
                                                        if (daysBetween >= 7) {
                                                            receipt3 = receipt3 - ((receipt3 * DISCOUNT3) / 100);
                                                        }
                                                        earn3 += (float) receipt3;// Suma del recibo a las ganancias totales.
                                                        break;
                                                    case "4":// cancelar la compra de asientos.
                                                        chairValide = false;
                                                        break;
                                                    default:// Caso por defecto si el usuario introduce una opción no reconocida.
                                                        System.out.println("\tOpción no válida.");
                                                        break;
                                                }
                                                //pintamos Factura
                                                if (!chairValide || !ticketValide) {
                                                    System.out.println("\tPulse Enter...");
                                                } else {
                                                    //TODO GENERANDO
                                                    System.out.print("\tGenerando factura");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    System.out.printf("""
                                                                    \t╔------------* FACTURA *----------╗
                                                                    \t\tEntradas: %d
                                                                    \t\tPecio Entrada: %5.2fE
                                                                    \t\tIVA: %s
                                                                    \t\tDescuento: %s
                                                                    \t\tPrecio Total: %5.2fE
                                                                    \t╚---------------------------------╝
                                                                    """, ticket, (opSeat.equals("1")) ? PRICEMAINFLOOR3 : (opSeat.equals("2") ? PRICEARMCHAIR3 : PRICEAMPHI3),
                                                            IVA + "%", (daysBetween > 7) ? DISCOUNT3 + "%" : "No disponible", receipt3);
                                                    do {//validamos que el pago sea el correcto
                                                        payValide = true;
                                                        System.out.print("\t¿Con cuanto desea pagar? Formato de pago (0.00): ");
                                                        pay = Float.parseFloat(s.nextLine());
                                                        if (pay < 0) {
                                                            System.out.println("\tValor introducido no permitido.");
                                                            payValide = false;
                                                        }
                                                        if (pay > 0 && pay < receipt3) {
                                                            System.out.println("\tDebe pagar con la misma cantidad o superior");
                                                            payValide = false;
                                                        }
                                                    } while (!payValide);
                                                    change = ((Math.round((receipt3 - pay) * 100)) / 100f); //Aquí saco el cambio con tan solo 2 decimales
                                                    //Mejorar la interfaz de usuario
                                                    System.out.print("\tCalculando cambio");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    //Pintar el cambio de la factura
                                                    change = (Math.abs((change * 100))) / 100f; //Como aquí change llega en negativo, lo paso a positivo con solo 2 decimales
                                                    System.out.printf("Su cambio es de %.2f euros.\n", Math.abs(change)); //Y le digo el change a percibir

                                                    while (change > 0) { //Empiezo un bucle mientras el change sea mayor que 0 para que calcule las monedas a devolver
                                                        change = Math.round(change * 100.0) / 100.0;//nos da en cambio con dos decimales exactos
                                                        //change = Math.abs(change);
                                                        if (change >= 500) { //Comprueba si el change es mayor a 500
                                                            bill500 = Math.abs((int) change / 500); //Si lo es, calcula cuantos billetes tiene que darle
                                                            System.out.printf("\tBilletes de 500 euros: %d\n", bill500);//Informa la cantidad de la divisa
                                                            change %= 500; //Saca el módulo de 500 para pasar al siguiente nivel
                                                            totalBill500 -= bill500;
                                                            //ESTE PROCESO SE REPITE EN CADA CONDICIÓN, NO VOY A COMENTAR TODOS EDU, LO SIENTO
                                                        } else if (change >= 200) {
                                                            bill200 = Math.abs((int) change / 200);
                                                            System.out.printf("\tBilletes de 200 euros: %d\n", bill200);
                                                            change %= 200;
                                                            totalBill200 -= bill200;
                                                        } else if (change >= 100) {
                                                            bill100 = Math.abs((int) change / 100);
                                                            System.out.printf("\tBilletes de 100 euros: %d\n", bill100);
                                                            change %= 100;
                                                            totalBill100 -= bill100;
                                                        } else if (change >= 50) {
                                                            bill50 = Math.abs((int) change / 50);
                                                            System.out.printf("\tBilletes de 50 euros: %d\n", bill50);
                                                            change %= 50;
                                                            totalBill50 -= bill50;
                                                        } else if (change >= 20) {
                                                            bill20 = Math.abs((int) change / 20);
                                                            System.out.printf("\tBilletes de 20 euros: %d\n", bill20);
                                                            change %= 20;
                                                            totalBill20 -= bill20;
                                                        } else if (change >= 10) {
                                                            bill10 = Math.abs((int) change / 10);
                                                            System.out.printf("\tBilletes de 10 euros: %d\n", bill10);
                                                            change %= 10;
                                                            totalBill10 -= bill10;
                                                        } else if (change >= 5) {
                                                            bill5 = Math.abs((int) change / 5);
                                                            System.out.printf("\tBilletes de 5 euros: %d\n", bill5);
                                                            change %= 5;
                                                            totalBill5 -= bill5;
                                                        } else if (change >= 2) {
                                                            coin2 = Math.abs((int) change / 2);
                                                            System.out.printf("\tMonedas de 2 euros: %d\n", coin2);
                                                            change %= 2;
                                                            totalCoin2 -= coin2;
                                                        } else if (change >= 1) {
                                                            coin1 = Math.abs((int) change);
                                                            System.out.printf("\tMonedas de 1 euro: %d\n", coin1);
                                                            change %= 1;
                                                            totalCoin1 -= coin1;
                                                        } else if (change >= 0.50) {
                                                            coin050 = (int) Math.abs(change / 0.50);
                                                            System.out.printf("\tMonedas de 50 céntimos: %d\n", coin050);
                                                            change %= 0.50;
                                                            totalCoin050 -= coin050;
                                                        } else if (change >= 0.20) {
                                                            coin020 = (int) Math.abs(change / 0.20);
                                                            System.out.printf("\tMonedas de 20 céntimos: %d\n", coin020);
                                                            change %= 0.20;
                                                            totalCoin020 -= coin020;
                                                        } else if (change >= 0.10) {
                                                            coin010 = (int) Math.abs(change / 0.10);
                                                            System.out.printf("\tMonedas de 10 céntimos: %d\n", coin010);
                                                            change %= 0.10;
                                                            totalCoin010 -= coin010;
                                                        } else if (change >= 0.05) {
                                                            coin005 = (int) Math.abs(change / 0.05);
                                                            System.out.printf("\tMonedas de 5 céntimos: %d\n", coin005);
                                                            change %= 0.05;
                                                            totalCoin005 -= coin005;
                                                        } else if (change >= 0.02) {
                                                            coin002 = (int) Math.abs(change / 0.02);
                                                            System.out.printf("\tMonedas de 2 céntimos: %d\n", coin002);
                                                            change %= 0.02;
                                                            totalCoin002 -= coin002;
                                                        } else if (change >= 0.01) {
                                                            coin001 = (int) Math.abs(change / 0.01);
                                                            System.out.printf("\tMonedas de 1 céntimo: %d\n", coin001);
                                                            change %= 0.01;
                                                            totalCoin001 -= coin001;
                                                        } else if (change < 0.01) { //Último else para salir del bucle
                                                            change = 0;
                                                        }
                                                    }
                                                    System.out.print("\tPulse para crear ticket");
                                                    s.nextLine();

                                                    //Muestra un mensaje de "Creando ticket" y luego simula un proceso de carga con puntos.
                                                    System.out.print("\tCreando ticket");
                                                    for (int i = 0; i <= 3; i++) {
                                                        System.out.print((i != 3) ? "." : "\n");
                                                        try {
                                                            Thread.sleep(500);
                                                        } catch (InterruptedException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    }
                                                    // Limpia la consola simulando que se borran las líneas impresas anteriormente.
                                                    for (int i = 0; i < 100; i++) {
                                                        System.out.println();
                                                    }
                                                    //Se genera el código para los tickets
                                                    for (int i = 1; i <= ticket; i++) {
                                                        code = "";
                                                        System.out.printf("\tEntrada %d de %d\n", i, ticket);

                                                        eventoParte = EVENT3.substring(0, 3).toUpperCase(); // Primeras 3 letras del evento
                                                        // Primeras 3 letras del tipo de asiento
                                                        if (opSeat.equals("1"))
                                                            tipoAsientoParte = TYPECHAIR1.substring(0, 3).toUpperCase();
                                                        else if ((opSeat.equals("2")))
                                                            tipoAsientoParte = TYPECHAIR2.substring(0, 3).toUpperCase();
                                                        else
                                                            tipoAsientoParte = TYPECHAIR3.substring(0, 3).toUpperCase();

                                                        //Concatena el código del evento y el tipo de asiento con un guion.
                                                        code += eventoParte + tipoAsientoParte + "-";

                                                        //Genera 4 caracteres aleatorios a partir de la cadena 'CHARACTER'.
                                                        for (int j = 0; j < 4; j++) {
                                                            int index = random.nextInt(CHARACTER.length());
                                                            code += CHARACTER.charAt(index);
                                                        }


                                                        //Aquí se pinta el ticket
                                                        System.out.printf("""
                                                                        ╔---------* TICKET *--------------------------------------------------------------------╗
                                                                                   ccee88oo            NOMBRE: %s\t\t%s
                                                                               C8O8O8Q8PoOb o8oo       LUGAR: Auditorio Municipal de Martos.
                                                                             dOB69QO8PdUOpugoO9bD      ASIENTO: %s
                                                                            CgggbU8OU qOp qOdoUOdcb
                                                                              6OuU  /p u gcoUodpP      PRECIO ENTRADA %.2fE + IVA %s : %.2fE = %.2fE
                                                                                 \\\\\\//  /douUP      %s
                                                                                  \\\\\\////
                                                                                    |||/\\
                                                                                    |||\\/
                                                                                    |||||
                                                                              .....||||||....
                                                                                                                                                
                                                                              code: %s                                                     MEVENTS S.A.
                                                                        ╚---------------------------------------------------------------------------------------╝
                                                                        """, EVENT3, DATE_EVENT3.format(outputFormatter),// Nombre del evento y fecha formateada.
                                                                (opSeat.equals("1")) ? TYPECHAIR1 : (opSeat.equals("2") ? TYPECHAIR2 : TYPECHAIR3),
                                                                (opSeat.equals("1")) ? PRICEMAINFLOOR3 : (opSeat.equals("2") ? PRICEARMCHAIR3 : PRICEAMPHI3),// Tipo de asiento
                                                                IVA + "%", (opSeat.equals("1")) ? ((PRICEMAINFLOOR3 * IVA) / 100) : (opSeat.equals("2") ? ((PRICEARMCHAIR3 * IVA) / 100) : ((PRICEAMPHI3 * IVA) / 100)),
                                                                (opSeat.equals("1")) ? (PRICEMAINFLOOR3 + (PRICEMAINFLOOR3 * IVA) / 100) : (opSeat.equals("2") ? (PRICEARMCHAIR3 + (PRICEARMCHAIR3 * IVA) / 100) : (PRICEAMPHI3 + (PRICEAMPHI3 * IVA) / 100)),// Precio del asiento sin IVA.
                                                                (daysBetween > 7 && opSeat.equals("1")) ? "Descuento " + DISCOUNT2 + "% = " + ((PRICEMAINFLOOR3 * DISCOUNT3) / 100)
                                                                        : (daysBetween > 7 && opSeat.equals("2")) ? "Descuento " + DISCOUNT3 + "% = " + ((PRICEARMCHAIR3 * DISCOUNT3) / 100)
                                                                        : (daysBetween > 7 && opSeat.equals("3")) ? "Descuento " + DISCOUNT3 + "% = " + ((PRICEAMPHI3 * DISCOUNT3) / 100) : "", code);// Código generado para el ticket.
                                                        // Si hay más tickets por imprimir, espera a que el usuario presione Enter para continuar.
                                                        if (i < ticket) {
                                                            System.out.print("\tPulse para continuar...");
                                                            s.nextLine();
                                                        }
                                                    }
                                                }
                                                // Sección que maneja la lógica de validación de opciones seleccionadas.
                                                nullDate = false;
                                                if (!ticketValide) {
                                                    opEvent = "2";
                                                    opPostMenu = "4";
                                                } else if (!opSeat.equals("4")) {
                                                    opSeat = "4";
                                                    opEvent = "2";
                                                    opPostMenu = "4";
                                                    System.out.print("\tPulse para volver al menú...");
                                                    s.nextLine();
                                                }
                                            } while (!opSeat.equals("4"));// Bucle que se repite hasta que la opción de asiento sea "4", es decir, cancelar la compra.
                                            break;
                                        case "2":
                                            System.out.println("Volviendo");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                    for (int i = 0; i < 100; i++) {
                                        System.out.println();
                                    }
                                } while (!opEvent.equalsIgnoreCase("2"));
                                break;
                            case "4":
                                break;
                            default:
                                System.out.println("opción no valida");

                        }
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
                    } while (!opPostMenu.equalsIgnoreCase("4"));
                    break;
                case "b": //TODO MENÚ DE CONSULTA, YA ESTA READY
                    while (!nullDate) {

                        System.out.print("\tIntroduzca una fecha (dd/MM/yyyy) o escribe 'no' para usar la fecha actual: ");
                        date = s.nextLine();

                        if (date.equalsIgnoreCase("no")) {
                            dateEntry = LocalDate.now(); // Asigna la fecha actual
                            //System.out.println("Fecha actual seleccionada: " + dateEntry.format(outputFormatter));
                            nullDate = true; // Termina el bucle
                        } else {
                            try {
                                // Intentar convertir el input en una fecha con el formato de entrada
                                dateEntry = LocalDate.parse(date, inputFormatter);
                                //System.out.println("Fecha ingresada correctamente: " + dateEntry.format(outputFormatter));
                                nullDate = true; // Termina el bucle si la fecha es válida
                            } catch (DateTimeParseException e) {
                                System.out.println("Fecha no válida, intente de nuevo.");
                            }
                        }
                    }
                    nullDate = false;
                    do {

                        System.out.print("""
                                \t╔════════════════════════════════════╗
                                \t║         CONSULTA EVENTOS           ║
                                \t╠════════════════════════════════════╣
                                \t║  1. Las criadas                    ║
                                \t║  2. II Concierto de Otoño          ║
                                \t║  3. Concierto de Jazz              ║
                                \t║  4. Menu Principal                 ║
                                \t╚════════════════════════════════════╝
                                \tSeleccione una opción:\s""");
                        opStatus = s.nextLine();
                        switch (opStatus) {
                            case "1"://Consultas del Evento 1

                                System.out.printf("""
                                        \tENTRADAS VENDIDAS:
                                        \t\tPlatea: %d
                                        \t\tButaca: %d
                                        \t\tAnfiteatro: %d
                                        """, MAINFLOOR1 - mainFloor1, ARMCHAIR1 - armChair1, AMPHI1 - amphi1);

                                System.out.printf("""
                                        \tENTRADAS LIBRES:
                                        \t\tPlatea: %d
                                        \t\tButaca: %d
                                        \t\tAnfiteatro: %d
                                        """, mainFloor1, armChair1, amphi1);
                                daysBetween = ChronoUnit.DAYS.between(dateEntry, DATE_EVENT1);
                                if (daysBetween < 7)
                                    System.out.printf("%d días hasta el evento, Descuento no disponible\n", daysBetween);
                                else System.out.printf("%d días hasta el evento, Descuento disponible\n", daysBetween);
                                System.out.print("\tPulse para volver hacía atrás...");
                                s.nextLine();
                                break;

                            case "2"://Consultas del Evento 2
                                System.out.printf("""
                                        \tENTRADAS VENDIDAS:
                                        \t\tPlatea: %d
                                        \t\tButaca: %d
                                        \t\tAnfiteatro: %d
                                        """, MAINFLOOR2 - mainFloor2, ARMCHAIR2 - armChair2, AMPHI2 - amphi2);
                                System.out.printf("""
                                        \tENTRADAS LIBRES:
                                        \t\tPlatea: %d
                                        \t\tButaca: %d
                                        \t\tAnfiteatro: %d
                                        """, mainFloor2, armChair2, amphi2);
                                daysBetween = ChronoUnit.DAYS.between(dateEntry, DATE_EVENT2);
                                if (daysBetween < 7)
                                    System.out.printf("%d días hasta el evento, Descuento no disponible\n", daysBetween);
                                else System.out.printf("%d días hasta el evento, Descuento disponible\n", daysBetween);
                                System.out.print("\tPulse para volver hacía atrás...");
                                s.nextLine();
                                break;
                            case "3"://Consultas del Evento 2
                                System.out.printf("""
                                        \tENTRADAS VENDIDAS:
                                        \t\tPlatea: %d
                                        \t\tButaca: %d
                                        \t\tAnfiteatro: %d
                                        """, MAINFLOOR3 - mainFloor3, ARMCHAIR3 - armChair3, AMPHI3 - amphi3);
                                System.out.printf("""
                                        \tENTRADAS LIBRES:
                                        \t\tPlatea: %d
                                        \t\tButaca: %d
                                        \t\tAnfiteatro: %d
                                        """, mainFloor3, armChair3, amphi3);
                                daysBetween = ChronoUnit.DAYS.between(dateEntry, DATE_EVENT3);
                                if (daysBetween < 7)
                                    System.out.printf("%d días hasta el evento, Descuento no disponible\n", daysBetween);
                                else System.out.printf("%d días hasta el evento, Descuento disponible\n", daysBetween);
                                System.out.print("\tPulse para volver hacía atrás...");
                                s.nextLine();
                                break;
                            case "4":
                                System.out.print("\tPulse para volver al menú...");
                                s.nextLine();
                                break;

                            default:
                                System.out.println("PERO Amos a ve cabezo chorlito");
                        }
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
                    } while (!opStatus.equals("4"));

                    break;

                case "c":
                    do {
                        System.out.print("""  
                                ██ ███    ██ ██  ██████ ██  ██████      ███████ ███████ ███████ ██  ██████  ███    ██
                                ██ ████   ██ ██ ██      ██ ██    ██     ██      ██      ██      ██ ██    ██ ████   ██
                                ██ ██ ██  ██ ██ ██      ██ ██    ██     ███████ █████   ███████ ██ ██    ██ ██ ██  ██
                                ██ ██  ██ ██ ██ ██      ██ ██    ██          ██ ██           ██ ██ ██    ██ ██  ██ ██
                                ██ ██   ████ ██  ██████ ██  ██████      ███████ ███████ ███████ ██  ██████  ██   ████
                                \n""");
                        System.out.print("Introduce Usuario: ");
                        user = s.nextLine();
                        System.out.print("Introduce Contraseña: ");
                        passwd = s.nextLine();
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
                        //se comprueba que el usuario sea el correcto
                        if (!(user.equals(USERADMIN) && passwd.equals(PASSWADMIN))) {
                            System.out.print("""  
                                    ███████╗██████╗ ██████╗  ██████╗ ██████╗
                                    ██╔════╝██╔══██╗██╔══██╗██╔═══██╗██╔══██╗
                                    █████╗  ██████╔╝██████╔╝██║   ██║██████╔╝
                                    ██╔══╝  ██╔══██╗██╔══██╗██║   ██║██╔══██╗
                                    ███████╗██║  ██║██║  ██║╚██████╔╝██║  ██║
                                    ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝
                                                                        
                                    Usuario o Contraseña incorrecto.
                                    """);
                            user = USERADMIN;
                            passwd = PASSWADMIN;

                        } else {
                            do {
                                System.out.print("""  
                                        \t╔═══════════════════════════════════════════════════════════╗
                                        \t║          ********   MENU ADMINISTRADOR   ********         ║
                                        \t╠═══════════════════════════════════════════════════════════╣
                                        \t║  1. Consultar los ingresos totales por evento.            ║
                                        \t║  2. Consultar las monedas restantes para el cambio.       ║
                                        \t║  3. Volver al menú principal                              ║
                                        \t║  4. Apagar el software                                    ║
                                        \t╚═══════════════════════════════════════════════════════════╝
                                        """);
                                System.out.print("\tSeleccione una opción: ");
                                opAdmin = s.nextLine();

                                switch (opAdmin) {
                                    case "1":
                                        System.out.printf("\tIngreso total de Las criadas: %.2f\n", earn1);
                                        System.out.printf("\tIngreso total de II Concierto de Otoño: %.2f\n", earn2);
                                        System.out.printf("\tIngreso total de Concierto de Jazz: %.2f\n", earn3);
                                        System.out.print("\tPulse para volver hacía atrás...");
                                        s.nextLine();
                                        break;
                                    case "2":
                                        System.out.printf("\tBilletes restantes de 500€:\t %4d %s\n", totalBill500, (totalBill500 <= 3) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tBilletes restantes de 200€:\t %4d %s\n", totalBill200, (totalBill200 <= 5) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tBilletes restantes de 100€:\t %4d %s\n", totalBill100, (totalBill100 <= 10) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tBilletes restantes de 50€:\t %4d %s\n", totalBill50, (totalBill50 <= 10) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tBilletes restantes de 20€:\t %4d %s\n", totalBill20, (totalBill20 <= 50) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tBilletes restantes de 10€:\t %4d %s\n", totalBill10, (totalBill10 <= 50) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tBilletes restantes de 5€:\t %4d %s\n", totalBill5, (totalBill5 <= 50) ? "CANTIDAD DE BILLETES BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 2€:\t %4d %s\n", totalCoin2, (totalCoin2 <= 50) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 1€:\t %4d %s\n", totalCoin1, (totalCoin1 <= 50) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 0'50€:\t %4d %s\n", totalCoin050, (totalCoin050 <= 100) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 0'20€:\t %4d %s\n", totalCoin020, (totalCoin020 <= 25) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 0.10€:\t %4d %s\n", totalCoin010, (totalCoin010 <= 50) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 0'05€:\t %4d %s\n", totalCoin005, (totalCoin005 <= 100) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 0'02€:\t %4d %s\n", totalCoin002, (totalCoin002 <= 250) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.printf("\tMonedas restantes de 0'01€:\t %4d %s\n", totalCoin001, (totalCoin001 <= 200) ? "CANTIDAD DE MONEDA BAJA" : "");
                                        System.out.print("\tPulse para volver hacía atrás...");
                                        s.nextLine();
                                        break;
                                    case "3":
                                        break;
                                    case "4":
                                        System.out.println("APAGANDO");
                                        opMenu = "Gobo";
                                        break;
                                    default:
                                        System.out.println("El valor introducido es incorrecto.");
                                        break;
                                }
                                for (int i = 0; i < 100; i++) {
                                    System.out.println();
                                }
                            } while (!((opAdmin.equals("3")) || opAdmin.equals("4")));
                        }
                    } while (!(user.equals(USERADMIN) && passwd.equals(PASSWADMIN)));

                    break;
                default:
                    System.out.println("El valor introducido es incorrecto.");
                    System.out.print("Pulse para continuar... ");
                    s.nextLine();
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
            }
        }
    }
}