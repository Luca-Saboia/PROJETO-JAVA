public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double preco;
    private boolean[] assentos = new boolean[50];

    public Espetaculo(String nome, String data, String hora, double preco) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        for (int i = 0; i < assentos.length; i++) assentos[i] = true;
    }

    public void apresentaAssentos() {
        for (int linha = 0; linha < 5; linha++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < 10; col++) {
                int idx = linha * 10 + (9 - col);
                int numero = idx + 1;
                if (assentos[idx]) {
                    if (numero < 10) sb.append("0").append(numero).append(" ");
                    else sb.append(numero).append(" ");
                } else {
                    sb.append("XX ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

    public Entrada novaEntrada(int tipo, int assento) {
        if (assento < 1 || assento > 50) return null;
        if (!assentos[assento - 1]) return null;
        assentos[assento - 1] = false;
        switch (tipo) {
            case 1: return new EntradaInteira(assento, this);
            case 2: return new EntradaMeia(assento, this);
            case 3: return new EntradaProfessor(assento, this);
            default: return null;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void marcarAssento(int assento) {
        if (assento >= 1 && assento <= 50) assentos[assento - 1] = false;
    }
    
    public boolean assentoDisponivel(int assento) {
        if (assento < 1 || assento > assentos.length) return false;
        return assentos[assento - 1];
    }

    public String getNome() { 
        return nome; 
    }

    @Override
    public String toString() {
        return nome + " " + data + " " + hora + " R$ " + String.format("%.2f", preco);
    }
}
