public class EntradaProfessor extends Entrada{
    private double entradaProfessor;
    
    public double calcularValor () {
        entradaProfessor = Espetaculo.getPreco * 0.40;
        return entradaProfessor;
    }
}