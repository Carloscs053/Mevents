import java.util.Locale;
import java.util.Scanner;

/*Plantear dejar solo una variable de opciones. Habría que dejar solo un tipo de datos para las op pero nos ahorramos
 una variable*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        /*Hay que crear variables de asientos para cada evento*/
        /*Pensar en poner esperas entre pantallas (UX)*/
        final String userAdmin = "admin", passwdAdmin = "1234";
        String user, passwd, option1;
        int mainFloor = 200, armChair = 200, amphi = 200, option2 = 1, opEvent; //He puesto las variables que quedaban
        // en inglés
        float totalPrice;


        System.out.println("""
                               
                ███╗   ███╗███████╗██╗   ██╗███████╗███╗   ██╗████████╗███████╗
                ████╗ ████║██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝
                ██╔████╔██║█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║   ███████╗
                ██║╚██╔╝██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ╚════██║
                ██║ ╚═╝ ██║███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║   ███████║
                ╚═╝     ╚═╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝
                """);
        do { /*
        He empezado a meter el bucle pero hay que averiguar cual debe ser la condición de salida para
        cerrar los menús
        */
            System.out.println("""
                                   
                    ╔════════════════════════════════════════════╗
                    ║  ********     MENU PRINCIPAL     ********  ║
                    ╠════════════════════════════════════════════╣
                    ║  a. Vender entradas para un evento.        ║
                    ║  b. Consultar el estado de un evento.      ║
                    ║  c. Menú de Administrador                  ║
                    ╚════════════════════════════════════════════╝""");
            System.out.print("selecciona una opción: ");
            option1 = s.nextLine();
            option1 = option1.toLowerCase();
            /*NOS HEMOS QUEDADO AQUI 21/10/*/
            switch (option1) {
                case "a":
                    System.out.println("""
                                           
                            ╔═══════════════════════════════════════════╗
                            ║        ********   EVENTO   ********       ║
                            ╠═══════════════════════════════════════════╣
                            ║  1. Las Criadas.                          ║
                            ║  2. II Concierto de Otoño.                ║
                            ║  3. Concierto de Jazz.                    ║
                            ╚═══════════════════════════════════════════╝""");
                    System.out.print("Introduce un evento: ");
                    opEvent = Integer.parseInt(s.nextLine());
                    switch (opEvent) {
                        /*
                         * He incluido la info de cada concierto según la opción introducida. Habría que
                         * implementar la opción de compra y cuántas entradas quiere. Creo que podría ser otro switch
                         * que le preguntase si quiere comprar o no (yendo así al menú anterior), y si es que si preguntar
                         * cuantas quiere y hacer la lógica al respecto
                         * */
                        case 1:
                            System.out.println("""
                                    ╔═══════════════════════════════════════════╗
                                    ║     ********   Las Criadas   ********     ║
                                    ╠═══════════════════════════════════════════╣
                                    ║  - Fecha: 20/11/2024                      ║
                                    ║  - Precio Platea: 17€                     ║
                                    ║  - Precio Butaca: 20€                     ║
                                    ║  - Precio Anfiteatro: 13€                 ║
                                    ║  - Desc. Anticipado: 5%                   ║
                                    ╚═══════════════════════════════════════════╝""");
                            break;
                        case 2:
                            System.out.println("""
                                    ╔═════════════════════════════════════════════════════╗
                                    ║     ********   II Concierto de Otoño   ********     ║
                                    ╠═════════════════════════════════════════════════════╣
                                    ║  - Fecha: 28/11/2024                                ║
                                    ║  - Precio Platea: 12€                               ║
                                    ║  - Precio Butaca: 15€                               ║
                                    ║  - Precio Anfiteatro: 8€                            ║
                                    ║  - Desc. Anticipado: 7%                             ║
                                    ╚═════════════════════════════════════════════════════╝""");
                            break;
                        case 3:
                            System.out.println("""
                                    ╔═════════════════════════════════════════════════╗
                                    ║     ********   Concierto de Jazz   ********     ║
                                    ╠═════════════════════════════════════════════════╣
                                    ║  - Fecha: 06/12/2024                            ║
                                    ║  - Precio Platea: 20€                           ║
                                    ║  - Precio Butaca: 25€                           ║
                                    ║  - Precio Anfiteatro: 15€                       ║
                                    ║  - Desc. Anticipado: 3%                         ║
                                    ╚═════════════════════════════════════════════════╝""");
                            break;
                        default:
                            System.out.println("opción no valida");
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
        } while (option2 != 3);/*"E:"Se estaba repitiendo ya que estaba haciendo la lógica de se repita mientras opción
         sera igual a 3 ahora al ser distinto de 3 se sale :).
        "C:"Este while hace referencia al primer do, en el que está metido el primer menú
        no funciona, repite el bucle una y otra vez pero hay que investigar qué condición es la que rompe todo el
        bucle
        */
    }
}