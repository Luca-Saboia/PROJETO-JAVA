
/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class EntradaProfessor extends Entrada { // [cite: 61]

    public EntradaProfessor(Espetaculo espetaculo, int numeroDoAssento) {
        super(espetaculo, numeroDoAssento);
    }

    @Override
    public double calculaValor() { // [cite: 61]
        // "40% do valor da entrada inteira." [cite: 9]
        return this.espetaculo.getPreco() * 0.4;
    }
}