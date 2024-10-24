import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.*;
import java.util.Scanner;

/*Plantear dejar solo una variable de opciones. Habría que dejar solo un tipo de datos para las op pero nos ahorramos
 una variable*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        /*TODO Pensar en poner esperas entre pantallas (UX)*/
        final String userAdmin = "admin", passwdAdmin = "1234";
        String user, passwd, option1, opEvent = "";
        /*El número al final de cada variable hace referencia a cada evento por orden de aparición*/
        int mainFloor1 = 200, armChair1 = 200, amphi1 = 200, totalChair1 = 600,
                mainFloor2 = 200, armChair2 = 200, amphi2 = 200, totalChair2 = 600,
                mainFloor3 = 200, armChair3 = 200, amphi3 = 200, totalChair3 = 600, option2 = 1;
        float totalPrice;
        LocalDate dateEntry;
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("""
                               
                ███╗   ███╗███████╗██╗   ██╗███████╗███╗   ██╗████████╗███████╗
                ████╗ ████║██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝
                ██╔████╔██║█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║   ███████╗
                ██║╚██╔╝██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ╚════██║
                ██║ ╚═╝ ██║███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║   ███████║
                ╚═╝     ╚═╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝
                """);
        while (option2 != 3) { /*Con el bucle while, mientras la opcion2 no sea 3 (opción de salida en el menú de admin
        permite apagar el programa*/
            System.out.println(""" 
                                   
                    \t╔════════════════════════════════════════════╗
                    \t║  ********     MENU PRINCIPAL     ********  ║
                    \t╠════════════════════════════════════════════╣
                    \t║  a. Vender entradas para un evento.        ║
                    \t║  b. Consultar el estado de un evento.      ║
                    \t║  c. Menú de Administrador                  ║
                    \t╚════════════════════════════════════════════╝""");//Le metemos un tabulador al principio para
            //centrar el display de los menús y opciones
            System.out.print("\tSelecciona una opción: ");
            option1 = s.nextLine();
            option1 = option1.toLowerCase();
            switch (option1) {
                case "a":
                    while (!option1.equalsIgnoreCase("4")) {
                        System.out.println("""
                                               
                                \t╔═══════════════════════════════════════════╗
                                \t║        ********   EVENTO   ********       ║
                                \t╠═══════════════════════════════════════════╣
                                \t║  1. Las Criadas.                          ║
                                \t║  2. II Concierto de Otoño.                ║
                                \t║  3. Concierto de Jazz.                    ║
                                \t   4. Menú principal
                                \t╚═══════════════════════════════════════════╝""");
                        System.out.print("\tIntroduce un evento: ");
                        option1 = s.nextLine();
                        switch (option1) {
                            /*
                             * He incluido la info de cada concierto según la opción introducida. Habría que
                             * implementar la opción de compra y cuántas entradas quiere. Creo que podría ser otro switch
                             * que le preguntase si quiere comprar o no (yendo así al menú anterior), y si es que si preguntar
                             * cuantas quiere y hacer la lógica al respecto
                             * */
                            case "1":
                                while (!opEvent.equalsIgnoreCase("2")) {
                                    System.out.println("""
                                            \t╔═══════════════════════════════════════════╗
                                            \t║     ********   Las Criadas   ********     ║
                                            \t╠═══════════════════════════════════════════╣
                                            \t║  - Fecha: 20/11/2024                      ║
                                            \t║  - Precio Platea: 17€                     ║
                                            \t║  - Precio Butaca: 20€                     ║
                                            \t║  - Precio Anfiteatro: 13€                 ║
                                            \t║  - Desc. Anticipado: 5%                   ║
                                            \t║                                           ║
                                            \t║    1. Compra                 2. Menú      ║
                                            \t╚═══════════════════════════════════════════╝""");


                                    System.out.print("\tSeleccione una opción: ");
                                    opEvent = s.nextLine();
                                    switch (opEvent) {
                                        case "1":
                                            /*TODO NOS HEMOS QUEDADO POR AQUÍ 24/10/2024, INVESTIGAR FECHA*/
                                            System.out.print("Introduzca la fecha ('no' para coger fecha actual): ");
                                            dateEntry = LocalDate.parse(s.nextLine());
                                            System.out.println(dateForm.format(dateEntry));
                                            break;
                                        case "2":
                                            System.out.println("Volver");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                while (!opEvent.equalsIgnoreCase("2")) {
                                    System.out.println("""
                                            \t╔═════════════════════════════════════════════════════╗
                                            \t║     ********   II Concierto de Otoño   ********     ║
                                            \t╠═════════════════════════════════════════════════════╣
                                            \t║  - Fecha: 28/11/2024                                ║
                                            \t║  - Precio Platea: 12€                               ║
                                            \t║  - Precio Butaca: 15€                               ║
                                            \t║  - Precio Anfiteatro: 8€                            ║
                                            \t║  - Desc. Anticipado: 7%                             ║
                                            \t║                                                     ║
                                            \t║    1. Compra                 2. Menú                ║
                                            \t╚═════════════════════════════════════════════════════╝""");


                                    System.out.print("\tSeleccione una opción: ");
                                    opEvent = s.nextLine();
                                    switch (opEvent) {
                                        case "1":
                                            System.out.println("Compra");
                                            break;
                                        case "2":
                                            System.out.println("Volver");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                while (!opEvent.equalsIgnoreCase("2")) {
                                    System.out.println("""
                                            ╔═════════════════════════════════════════════════╗
                                            ║     ********   Concierto de Jazz   ********     ║
                                            ╠═════════════════════════════════════════════════╣
                                            ║  - Fecha: 06/12/2024                            ║
                                            ║  - Precio Platea: 20€                           ║
                                            ║  - Precio Butaca: 25€                           ║
                                            ║  - Precio Anfiteatro: 15€                       ║
                                            ║  - Desc. Anticipado: 3%                         ║
                                            \t║                                               ║
                                            \t║    1. Compra                 2. Menú          ║
                                            ╚═════════════════════════════════════════════════╝""");

                                    System.out.print("\tSeleccione una opción: ");
                                    opEvent = s.nextLine();
                                    switch (opEvent) {
                                        case "1":
                                            System.out.println("Compra");
                                            break;
                                        case "2":
                                            System.out.println("Volver");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                }
                                break;
                            case "4":
                                break;
                            default:
                                System.out.println("opción no valida");
                        }
                    }
                    break;
                case "b":
                    System.out.println("hola b");
                    break;
                case "c":
                    System.out.println("""
                                                
                            ██ ███    ██ ██  ██████ ██  ██████      ███████ ███████ ███████ ██  ██████  ███    ██
                            ██ ████   ██ ██ ██      ██ ██    ██     ██      ██      ██      ██ ██    ██ ████   ██
                            ██ ██ ██  ██ ██ ██      ██ ██    ██     ███████ █████   ███████ ██ ██    ██ ██ ██  ██
                            ██ ██  ██ ██ ██ ██      ██ ██    ██          ██ ██           ██ ██ ██    ██ ██  ██ ██
                            ██ ██   ████ ██  ██████ ██  ██████      ███████ ███████ ███████ ██  ██████  ██   ████
                            """);
                    System.out.print("Introduce Usuario: ");
                    user = s.nextLine();
                    System.out.print("Introduce Contraseña: ");
                    passwd = s.nextLine();
//se comprueba que el usuario sea el correcto
                    if (user.equals(userAdmin) && passwd.equals(passwdAdmin)) {
                        System.out.println("""
                                                
                                ╔═══════════════════════════════════════════════════════════╗
                                ║          ********   MENU ADMINISTRADOR   ********         ║
                                ╠═══════════════════════════════════════════════════════════╣
                                ║  1. Consultar los ingresos totales por evento.            ║
                                ║  2. Consultar las monedas restantes para el cambio.       ║
                                ║  3. Apagar el software                                    ║
                                ╚═══════════════════════════════════════════════════════════╝""");
                        System.out.print("selecciona una opción: ");
                        option2 = Integer.parseInt(s.nextLine());

                        switch (option2) {
                            case 1:
                                System.out.println("hola 1");
                                break;
                            case 2:
                                System.out.println("hola 2");
                                break;
                            case 3:
                                System.out.println("apagar");
                                break;
                            default:
                                System.out.println("El valor introducido no es correcto es incorrecto.");
                        }
                    } else {
                        System.out.println("""
                                                            
                                ███████╗██████╗ ██████╗  ██████╗ ██████╗
                                ██╔════╝██╔══██╗██╔══██╗██╔═══██╗██╔══██╗
                                █████╗  ██████╔╝██████╔╝██║   ██║██████╔╝
                                ██╔══╝  ██╔══██╗██╔══██╗██║   ██║██╔══██╗
                                ███████╗██║  ██║██║  ██║╚██████╔╝██║  ██║
                                ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝
                                                            
                                Usuario o Contraseña incorrecto.""");
                    }
                    break;
                default:
                    System.out.println("El valor introducido no es correcto es incorrecto.");
            }
        }
    }
}