
/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public class EntradaInteira extends Entrada { // [cite: 58]

    public EntradaInteira(Espetaculo espetaculo, int numeroDoAssento) {
        super(espetaculo, numeroDoAssento);
    }

    @Override
    public double calculaValor() { // [cite: 59]
        // "Valor conforme informado no cadastro do espetáculo." [cite: 9]
        return this.espetaculo.getPreco();
    }
}