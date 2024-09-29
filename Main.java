import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        while (true) {
            limparTela();
            mostrarMenu();
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        adicionarLivro(biblioteca);
                        break;
                    case 2:
                        removerLivro(biblioteca);
                        break;
                    case 3:
                        pesquisarLivro(biblioteca);
                        break;
                    case 4:
                        biblioteca.listarLivros();
                        break;
                    case 5:
                        biblioteca.clear();
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
            }
            esperarTecla();
        }
    }

    private static void mostrarMenu() {
        System.out.println("==== Biblioteca ====");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Remover Livro por Título");
        System.out.println("3. Pesquisar Livro por Título");
        System.out.println("4. Listar Todos os Livros");
        System.out.println("5. Limpar Todos os Livros");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarLivro(Biblioteca biblioteca) {
        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Autor: ");
            String autor = scanner.nextLine();
            System.out.print("Ano de publicação: ");
            int anoPublicacao = Integer.parseInt(scanner.nextLine());
            System.out.print("Número de páginas: ");
            int numeroPaginas = Integer.parseInt(scanner.nextLine());

            Livro livro = new Livro(titulo, autor, anoPublicacao, numeroPaginas);
            biblioteca.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir números corretamente.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerLivro(Biblioteca biblioteca) {
        System.out.print("Digite o título do livro que deseja remover: ");
        String titulo = scanner.nextLine();
        biblioteca.removerLivroPorTitulo(titulo);
    }

    private static void pesquisarLivro(Biblioteca biblioteca) {
        System.out.print("Digite o título do livro que deseja pesquisar: ");
        String titulo = scanner.nextLine();
        biblioteca.pesquisarLivroPorTitulo(titulo);
    }

    private static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar a tela.");
        }
    }

    private static void esperarTecla() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
}
