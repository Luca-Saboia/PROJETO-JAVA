
import java.util.Arrays;

/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class Espetaculo {
    private String nome; // [cite: 25]
    private String data; // [cite: 25]
    private String hora; // [cite: 26]
    private double preco; // [cite: 28]
    private boolean[] assentos; // [cite: 32]

    public Espetaculo(String nome, String data, String hora, double preco) { // [cite: 33]
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.assentos = new boolean[50]; // [cite: 6] 50 lugares
        // Inicializa todos os assentos como livres (false)
        Arrays.fill(this.assentos, false);
    }

    public double getPreco() { // [cite: 36]
        return this.preco;
    }

    private void marcarAssento(int assento) { // [cite: 38]
        // Ajusta o número do assento (1-50) para o índice do array (0-49)
        int indice = assento - 1;
        if (indice >= 0 && indice < 50) {
            this.assentos[indice] = true; // Marca como ocupado
        }
    }

    public boolean verificarAssento(int assento) {
        int indice = assento - 1;
        if (indice >= 0 && indice < 50) {
            return this.assentos[indice]; // Retorna true se ocupado, false se livre
        }
        return true; // Considera inválido como "ocupado" para evitar venda
    }

    public void apresentaAssentos() { // [cite: 34]
        // [cite: 133] "Quando o assento não estiver disponível deve-se mostrar XX"
        // Segue a formatação exata do exemplo [cite: 145-149]
        for (int i = 4; i >= 0; i--) { // 5 fileiras [cite: 6]
            for (int j = 9; j >= 0; j--) { // 10 cadeiras [cite: 6]
                int assentoNum = (i * 10) + j + 1;
                int assentoIndex = assentoNum - 1;

                if (assentos[assentoIndex]) { // Se true = ocupado
                    System.out.print("XX ");
                } else {
                    System.out.printf("%02d ", assentoNum); // %02d para formatar 1 como 01
                }
            }
            System.out.println(); // Próxima fileira
        }
    }
    
    public Entrada novaEntrada(int tipo, int assento) { // [cite: 35]
        if (verificarAssento(assento)) {
            System.out.println("Erro: Assento " + assento + " já está ocupado.");
            return null;
        }

        Entrada novaEntrada = null;
        switch (tipo) {
            case 1: // Inteira [cite: 135]
                novaEntrada = new EntradaInteira(this, assento);
                break;
            case 2: // Meia [cite: 135]
                novaEntrada = new EntradaMeia(this, assento);
                break;
            case 3: // Professor [cite: 135]
                novaEntrada = new EntradaProfessor(this, assento);
                break;
            default:
                System.out.println("Erro: Tipo de entrada inválido.");
                return null;
        }

        marcarAssento(assento); // [cite: 95] Marca o assento como ocupado
        return novaEntrada;
    }

    @Override
    public String toString() { // [cite: 37]
        // Formato baseado no exemplo de execução [cite: 143]
        return String.format("%s %s %s R$ %.2f", this.nome, this.data, this.hora, this.preco);
    }
}