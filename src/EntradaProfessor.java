package teatro;

public class EntradaProfessor extends Entrada {
    public EntradaProfessor(int numeroDoAssento, Espetaculo espetaculo) {
        super(numeroDoAssento, espetaculo);
    }

    public double calculaValor() {
        return espetaculo.getPreco() * 0.4;
    }
}
