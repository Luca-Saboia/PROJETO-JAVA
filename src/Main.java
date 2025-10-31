import java.util.Scanner;
public class Main {
    
    static Scanner entrada = new Scanner(System.in);

    public static void cadastrarCliente(Teatro teatro){
        
        System.out.println("***CADASTRO CLIENTE***");
        System.out.println("Nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.println("CPF do cliente");
        String cpf = entrada.nextLine();
        Cliente cliente = new Cliente(nomeCliente, cpf);
        teatro.cadastrarCliente(cliente);
        
    }


    public static void espetaculo(Teatro teatro){
            
        System.out.println("***CADASTRO ESPETÁCULO***");
        System.out.println("Nome do espetacúlo:");
        String nomeEspetaculo = entrada.nextLine();
        System.out.println("Data do Espetáculo:");
        String data = entrada.nextLine();
        System.out.println("Hora do Espetáculo:");
        String hora = entrada.nextLine();
        System.out.println("Preço do Espetáculo:");
        double precoEntrada = entrada.nextDouble();
        Espetaculo espetaculo = new Espetaculo(nomeEspetaculo, hora, data, precoEntrada);
        teatro.cadastrarEspetaculo(espetaculo);
    }


    public static void main(String[] args) {
        int opcao;
        Teatro teatro = new Teatro();
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
                   espetaculo(teatro);
                   break;

                case 2:
                    cadastrarCliente(teatro);
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


