package teatro;

import java.util.Scanner;

public class Main {
    private static Teatro teatro = new Teatro();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String opc;
        do {
            System.out.println("*** MACK THEATHER ***");
            System.out.println("1) Cadastrar Espetáculo");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Compra de Entradas");
            System.out.println("4) Sair");
            System.out.print("Selecione uma opção: ");
            pc = sc.nextLine().trim();

            switch (opc) {
                case "1":
                    cadastrarEspetaculo();
                    break;

                case "2":
                    cadastrarCliente();
                    break;

                case "3":
                    compraDeEntradas();
                    break;

                case "4":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 4.\n");
                    break;
            }

        } while (!opc.equals("4"));
    }

    private static void cadastrarEspetaculo() {
        System.out.println("*** CADASTRO DE ESPETÁCULO ***");
        String nome;
        do {
            System.out.print("Nome do Espetáculo: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) System.out.println("O nome não pode estar vazio.");
        } while (nome.isEmpty());

        String data;
        while (true) {
            System.out.print("Data (ex: 15/11/2025): ");
            data = sc.nextLine().trim();
            if (data.length() != 10 || data.charAt(2) != '/' || data.charAt(5) != '/') {
                System.out.println("Formato inválido. Use dd/MM/yyyy (ex: 15/11/2025).");
                continue;
            }
            boolean digitos = true;
            for (int i = 0; i < data.length(); i++) {
                if (i == 2 || i == 5) continue;
                if (!Character.isDigit(data.charAt(i))) { digitos = false; break; }
            }
            if (!digitos) {
                System.out.println("Data inválida: use apenas números no dia, mês e ano.");
                continue;
            }
            int dia = Integer.parseInt(data.substring(0,2));
            int mes = Integer.parseInt(data.substring(3,5));
            int ano = Integer.parseInt(data.substring(6,10));
            if (mes < 1 || mes > 12) {
                System.out.println("Mês inválido. Informe um mês entre 01 e 12.");
                continue;
            }
            int maxDia = 31;
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) maxDia = 30;
            else if (mes == 2) {
                boolean bissexto = (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
                maxDia = bissexto ? 29 : 28;
            }
            if (dia < 1 || dia > maxDia) {
                System.out.println("Dia inválido para o mês informado. Dia deve ser entre 1 e " + maxDia + ".");
                continue;
            }
            if (ano < 1900) {
                System.out.println("Ano inválido. Informe um ano válido (ex: 2025).");
                continue;
            }
            break;
        }

        String hora;
        while (true) {
            System.out.print("Hora (ex: 19:30): ");
            hora = sc.nextLine().trim();
            if (hora.length() != 5 || hora.charAt(2) != ':') {
                System.out.println("Formato inválido. Use HH:mm (ex: 19:30).");
                continue;
            }
            boolean digitosHora = true;
            for (int i = 0; i < hora.length(); i++) {
                if (i == 2) continue;
                if (!Character.isDigit(hora.charAt(i))) { digitosHora = false; break; }
            }
            if (!digitosHora) {
                System.out.println("Hora inválida: use apenas números em HH e mm.");
                continue;
            }
            int hh = Integer.parseInt(hora.substring(0,2));
            int mm = Integer.parseInt(hora.substring(3,5));
            if (hh < 0 || hh > 23) {
                System.out.println("Hora inválida. Horas válidas: 00 a 23.");
                continue;
            }
            if (mm < 0 || mm > 59) {
                System.out.println("Minutos inválidos. Valores válidos: 00 a 59.");
                continue;
            }
            break;
        }

        double preco = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print("Preço da Entrada Inteira: ");
            String entrada = sc.nextLine().replace(",", ".").trim();
            boolean somenteNumero = true;
            boolean ponto = false;
            for (int i = 0; i < entrada.length(); i++) {
                char c = entrada.charAt(i);
                if (c == '.') {
                    if (ponto) somenteNumero = false;
                    ponto = true;
                } else if (!Character.isDigit(c)) {
                    somenteNumero = false;
                    break;
                }
            }
            if (!somenteNumero || entrada.isEmpty()) {
                System.out.println("Valor inválido. Digite apenas números (ex: 30 ou 30.50).");
            } else {
                preco = Double.parseDouble(entrada);
                if (preco <= 0) System.out.println("O preço deve ser maior que zero.");
                else valido = true;
            }
        }

        Espetaculo e = new Espetaculo(nome, data, hora, preco);
        teatro.adicionaEspetaculo(e);
        System.out.println("\nEspetáculo cadastrado com sucesso!\n");
    }

    private static void cadastrarCliente() {
        System.out.println("*** CADASTRO DE CLIENTE ***");
        String nome;
        do {
            System.out.print("Nome do Cliente: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) System.out.println("O nome não pode estar vazio.");
        } while (nome.isEmpty());

        String cpf;
        do {
            System.out.print("CPF (somente números): ");
            cpf = sc.nextLine().trim();
            boolean valido = cpf.matches("\\d{11}");
            if (!valido) System.out.println("CPF inválido. Digite exatamente 11 números.");
        } while (!cpf.matches("\\d{11}"));

        Cliente c = new Cliente(nome, cpf);
        teatro.adicionaCliente(c);
        System.out.println("\nCliente cadastrado com sucesso!\n");
    }

    private static void compraDeEntradas() {
        if (teatro.getClientes().isEmpty()) { 
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente antes de comprar ingressos.\n"); 
            return; 
        }

        if (teatro.getEspetaculos().isEmpty()) {
            System.out.println("Nenhum espetáculo cadastrado.\n");
            return;
        }

        System.out.println("*** VENDA DE ENTRADAS – ESPETÁCULOS ***");
        teatro.apresentaEspectaculos();

        int sel = 0;
        while (true) {
            System.out.print("Selecione um espetáculo: ");
            String entrada = sc.nextLine().trim();
            boolean apenasNumeros = !entrada.isEmpty();
            for (int i = 0; i < entrada.length(); i++) {
                if (!Character.isDigit(entrada.charAt(i))) {
                    apenasNumeros = false;
                    break;
                }
            }
            if (!apenasNumeros) {
                System.out.println("Entrada inválida. Digite apenas o número do espetáculo (ex: 1, 2, 3...).");
                continue;
            }
            sel = Integer.parseInt(entrada);
            if (sel < 1 || sel > teatro.getEspetaculos().size()) {
                System.out.println("Número inválido. Escolha um espetáculo entre 1 e " + teatro.getEspetaculos().size() + ".");
                continue;
            }
            break;
        }

        teatro.novaCompra();
        teatro.selecionaEspetaculo(sel);
        Espetaculo e = teatro.getEspetaculos().get(sel - 1);

        while (true) {
            System.out.println(" ||| Assentos Disponíveis |||");
            e.apresentaAssentos();

            int assento = 0;
            while (true) {
                System.out.print("Selecione um assento: ");
                String entrada = sc.nextLine().trim();
                boolean apenasNumeros = !entrada.isEmpty();
                for (int i = 0; i < entrada.length(); i++) {
                    if (!Character.isDigit(entrada.charAt(i))) {
                        apenasNumeros = false;
                        break;
                    }
                }
                if (!apenasNumeros) {
                    System.out.println("Digite um número de assento válido (1 a 50).");
                    continue;
                }
                assento = Integer.parseInt(entrada);
                if (!e.assentoDisponivel(assento)) {
                    System.out.println("Assento ocupado ou inexistente. Escolha outro.");
                    continue;
                }
                break;
            }

            int tipo = 0;
            while (true) {
                System.out.println(" ||| Tipos de Entrada |||");
                System.out.println("1) Inteira");
                System.out.println("2) Meia  50% do valor da entrada");
                System.out.println("3) Professor 40% do valor da entrada");
                System.out.print("Selecione um tipo de entrada: ");
                String entrada = sc.nextLine().trim();
                boolean apenasNumeros = !entrada.isEmpty();
                for (int i = 0; i < entrada.length(); i++) {
                    if (!Character.isDigit(entrada.charAt(i))) {
                        apenasNumeros = false;
                        break;
                    }
                }
                if (!apenasNumeros) {
                    System.out.println("Digite apenas números (1, 2 ou 3).");
                    continue;
                }
                tipo = Integer.parseInt(entrada);
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Tipo inválido. Escolha 1, 2 ou 3.");
                    continue;
                }
                break;
            }

            teatro.novaEntrada(tipo, assento);

            String r;
            while (true) {
                System.out.print("Deseja comprar outra entrada (S/N)? ");
                r = sc.nextLine().trim().toUpperCase();
                if (r.equals("S") || r.equals("N")) break;
                System.out.println("Resposta inválida. Digite 'S' para sim ou 'N' para não.");
            }
            if (!r.equals("S")) break;
        }

        Cliente cliente = null;
        String cpf;
        while (cliente == null) {
            System.out.print("\nInforme o CPF do Cliente Cadastrado: ");
            cpf = sc.nextLine().trim();
            cliente = teatro.buscarClientePorCPF(cpf);
            if (cliente == null) {
                System.out.println("CPF não encontrado. Tente novamente.");
            } else {
                double total = teatro.finalizaCompra(cpf);
                System.out.println("Valor Total: R$ " + String.format("%.2f", total) + "\n");
                System.out.println(">>> Retornar ao menu principal <<<\n");
            }
        }
    }
}
