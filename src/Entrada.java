
/**
 * Matrícula e Nome dos Alunos:
 * - 123456 - Aluno 1
 * - 789012 - Aluno 2
 */
public abstract class Entrada { // [cite: 51]
    
    // Protegido para que as classes filhas possam acessar
    protected Espetaculo espetaculo; 
    protected int numeroDoAssento; // [cite: 52]

    public Entrada(Espetaculo espetaculo, int numeroDoAssento) {
        this.espetaculo = espetaculo;
        this.numeroDoAssento = numeroDoAssento;
    }
    
    /**
     * Método abstrato para calcular o valor da entrada.
     * As classes filhas devem implementar esta lógica.
     * [cite: 52]
     */
    public abstract double calculaValor();
}