
import java.util.ArrayList;

/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class Pedido { // [cite: 53]
    
    private ArrayList<Entrada> entradas;

    public Pedido() { // [cite: 54]
        this.entradas = new ArrayList<>();
    }

    public void adicionaEntrada(Entrada entrada) { // [cite: 55]
        this.entradas.add(entrada);
    }

    public double calculaValorTotal() { // [cite: 56]
        double total = 0.0;
        // Itera sobre todas as entradas (polimorficamente) e soma seus valores
        for (Entrada e : this.entradas) {
            total += e.calculaValor(); // [cite: 97]
        }
        return total;
    }
}