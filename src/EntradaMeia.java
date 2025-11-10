
/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class EntradaMeia extends Entrada { // [cite: 60]

    public EntradaMeia(Espetaculo espetaculo, int numeroDoAssento) {
        super(espetaculo, numeroDoAssento);
    }

    @Override
    public double calculaValor() { // [cite: 60]
        // "50% do valor da entrada inteira." [cite: 9]
        return this.espetaculo.getPreco() * 0.5;
    }
}