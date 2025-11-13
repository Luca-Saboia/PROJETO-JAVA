package teatro;

public abstract class Entrada {
    protected int numeroDoAssento;
    protected Espetaculo espetaculo;

    public Entrada(int numeroDoAssento, Espetaculo espetaculo) {
        this.numeroDoAssento = numeroDoAssento;
        this.espetaculo = espetaculo;
    }

    public abstract double calculaValor();

    public int getNumeroDoAssento() { 
        return numeroDoAssento; 
    }
}
