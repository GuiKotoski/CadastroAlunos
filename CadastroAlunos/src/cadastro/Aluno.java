package cadastro;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private ArrayList<Double> notas;

    // Construtor
    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    // Método para adicionar uma nota
    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    // Método para calcular a média
    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    // Método para exibir detalhes do aluno
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Notas: " + notas);
        System.out.println("Média: " + calcularMedia());
    }

    // Getter para o nome
    public String getNome() {
        return nome;
    }
}
