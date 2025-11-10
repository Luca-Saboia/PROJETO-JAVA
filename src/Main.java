import java.util.Scanner;
public class Main {
    
    static Scanner entrada = new Scanner(System.in);

    public static void cadastrarEspetaculo(Teatro teatro){
            
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
    
    
    
    public static void cadastrarCliente(Teatro teatro){
        
        System.out.println("***CADASTRO CLIENTE***");
        System.out.println("Nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.println("CPF do cliente");
        String cpf = entrada.nextLine();
        Cliente cliente = new Cliente(nomeCliente, cpf);
        teatro.cadastrarCliente(cliente);
        
    }



    public static void compraDeEntradas(Teatro teatro){
        do{
            Espetaculo espetaculo;
            System.out.println("*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
            teatro.novaCompra();
            teatro.apresentaEspetaculos();


            System.out.println();
            System.out.print("Selecione um espetáculo: ");
            int numero = entrada.nextInt();
            teatro.selecionaEspetaculo(numero);
            System.out.println();


            System.out.println("    ||| Assentos Disponíveis |||");
            Espetaculo.apresentaAssentos;
            System.out.print("Selecione um assento: ");
            int assento = entrada.nextInt();
            Espetaculo.selecionaEspetaculo(assento);
            System.out.println();
            System.out.println("    ||| Tipos de Entrada |||");
            System.out.println("    1) Inteira");
            System.out.println("    2) Meia 50% do valor da entrada");
            System.out.println("    3) Professor 40% do valor da entrada");
            System.out.print("Selecione um tipo de entrada: ");
            int tipo = entrada.nextInt();
            Espetaculo.novaEntrada(tipo, assento);
            System.out.println();
            System.out.print("Deseja comprar outra entrada (S/N)? ");
            String outraEntrada = nextLine();
            if (outraEntrada != "N" || outraEntrada != "S" || outraEntrada != "n" || outraEntrada != "s"){
                System.out.println("Opção invalida digite novamente");
                System.out.print("Deseja comprar outra entrada (S/N)? ");
                outraEntrada = nextLine();
            }
        }
        while (outraEntrada != "N" || outraEntrada != "n");

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
                   cadastrarEspetaculo(teatro);
                   break;

                case 2:
                    cadastrarCliente(teatro);
                    break;

                case 3:
                    compraDeEntradas(teatro);
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;  
            }
        } while (opcao != 4);


    }
}


