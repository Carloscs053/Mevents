import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        final String userAdmin = "admin", passwdAdmin = "1234";
        String user, passwd, option1;
        int platea = 200, butaca = 200, anfiteatro = 200, option2, opEvent;
        float totalPrice;


        System.out.println("""
               
                ███╗   ███╗███████╗██╗   ██╗███████╗███╗   ██╗████████╗███████╗
                ████╗ ████║██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝
                ██╔████╔██║█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║   ███████╗
                ██║╚██╔╝██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ╚════██║
                ██║ ╚═╝ ██║███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║   ███████║
                ╚═╝     ╚═╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝
                """);
        System.out.println("""
               
                ╔════════════════════════════════════════════╗
                ║  ********     MENU PRINCIPAL     ********  ║
                ╠════════════════════════════════════════════╣
                ║  a. Vender entradas para un evento.        ║
                ║  b. Consultar el estado de un evento.      ║
                ║  c. Menú de Administrador                  ║
                ╚════════════════════════════════════════════╝""");
        System.out.print("selecciona una opción: ");
        option1 =  s.nextLine();
        option1 = option1.toLowerCase();
/*NOS HEMOS QUEDADO AQUI 21/10/2024*/
        switch (option1){
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
                switch(opEvent){
                    case 1:
                        System.out.println("hola1");
                        break;
                    case 2:
                        System.out.println("hola2");
                        break;
                    case 3:
                        System.out.println("hola3");
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
                if (user.equals(userAdmin) && passwd.equals(passwdAdmin)){
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
                } else { System.out.println("""
                            
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