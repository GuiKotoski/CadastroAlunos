package cadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAlunos {
    private static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Cadastro de Alunos ===");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Adicionar nota ao aluno");
            System.out.println("3. Exibir alunos cadastrados");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            switch (opcao) {
                case 1:
                    adicionarAluno(scanner);
                    break;
                case 2:
                    adicionarNota(scanner);
                    break;
                case 3:
                    exibirAlunos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    // Método para adicionar um aluno
    public static void adicionarAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
        System.out.println("Aluno " + nome + " cadastrado com sucesso!");
    }

    // Método para adicionar nota a um aluno
    public static void adicionarNota(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            System.out.print("Digite a nota: ");
            double nota = scanner.nextDouble();
            aluno.adicionarNota(nota);
            System.out.println("Nota adicionada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método para exibir alunos cadastrados
    public static void exibirAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                aluno.exibirDetalhes();
            }
        }
    }

    // Método para buscar aluno pelo nome
    public static Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
}
