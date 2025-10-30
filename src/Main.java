import java.util.Scanner;
public class Main {
    static String nomeCliente;
    static String cpf;
    static String hora;
    static String data;
    static String nomeEspetaculo;
    static double precoEntrada;
    static Scanner entrada = new Scanner(System.in);

    public static void cadastrarCliente(){
        System.out.println("***CADASTRO CLIENTE***");
        System.out.println("Nome do cliente: ");
        nomeCliente = entrada.nextLine();
        System.out.println("CPF do cliente");
        cpf = entrada.nextLine();
        Cliente c1 = new Cliente(nomeCliente, cpf);
    }

        public static void espetaculo(){
            
        System.out.println("***CADASTRO ESPETÁCULO***");
        System.out.println("Nome do espetacúlo:");
        nomeEspetaculo = entrada.nextLine();
        System.out.println("Data do Espetáculo:");
        data = entrada.nextLine();
        System.out.println("Hora do Espetáculo:");
        hora = entrada.nextLine();
        System.out.println("Preço do Espetáculo:");
        precoEntrada = entrada.nextDouble();
        Espetaculo espetaculo1 = new Espetaculo(nomeEspetaculo, hora, data, precoEntrada);
        }
    public static void main(String[] args) {
        int opcao;
        do { 
            System.out.println("*** MACK THEATHER***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2)Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.println("Selecione uma opção");
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1: 
                   espetaculo();
                   break;

                case 2:
                    cadastrarCliente();
                    break;

                case 3:
                    compraDeEntradas();
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;  
            }
        } while (opcao != 4);


    }
}
