package scr;

public class Notas {
	    private String nome;
	    private int RA;
	    private double[] notas;
	    private boolean isEAD; // me informa se a disciplina é EAD ou Presencial (verdadeiro ou falso)

	    // Construtor com as informações de cada variável
	    public Notas(String nome, int RA, double[] notas, boolean isEAD) {
	        this.nome = nome;
	        this.RA = RA;
	        this.notas = notas;
	        this.isEAD = isEAD;  
	    }

	    // Método para calcular a nota final
	    public double calcularNotaFinal() {
	        int numNotas = notas.length;
	        double notaFinal = 0;

	        if (numNotas <= 2) {
	            // Média aritmética
	            for (double nota : notas) {
	                notaFinal += nota;
	            }
	            return notaFinal / numNotas;
	        } else if (numNotas == 3) {
	            // Média ponderada
	            notaFinal = notas[0] + 2 * notas[1] + 4 * notas[2];
	            return notaFinal / 7;
	        } else if (numNotas == 4) {
	            // Cálculo específico para todas as 4 notas dos alunos
	            return notas[0] * 0.15 + notas[1] * 0.30 + notas[2] * 0.10 + notas[3] * 0.45;
	        } else {
	            throw new IllegalArgumentException("Número inválido de notas");
	        }
	        }
	    

	    // Método para verificar aprovação
	    public boolean estaAprovado(double frequencia) {
	        double notaFinal = calcularNotaFinal();
	        return (notaFinal >= 5 && (isEAD || frequencia >= 0.75));
	    }

	    // Método para imprimir informações do aluno
	    public void imprimirInformacoes() {
	        System.out.println("Nome: " + nome);
	        System.out.println("RA: " + RA);
	        System.out.println("Nota Final: " + calcularNotaFinal());
	        System.out.println("Situação: " + (estaAprovado(0.75) ? "Aprovado" : "Reprovado")); // Considerando 75% como padrão
	    }
	
public class Main {
    public static void main(String[] args) {
        double[] notasAluno1 = {8.5, 9.0};
        double[] notasAluno2 = {7.0, 8.5, 9.5};
        double[] notasAluno3 = {6.0, 7.5, 8.0, 9.0};

        Notas aluno1 = new Notas("João", 12345, notasAluno1, false);
        Notas aluno2 = new Notas("Maria", 67890, notasAluno2, true);
        Notas aluno3 = new Notas("Pedro", 34567, notasAluno3, false);

        aluno1.imprimirInformacoes();
        aluno2.imprimirInformacoes();
        aluno3.imprimirInformacoes();
    }
}
}

