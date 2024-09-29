import java.util.ArrayList;
import java.util.Iterator;


class Biblioteca {
    private ArrayList<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        Iterator<Livro> iterator = livros.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getTitulo().equalsIgnoreCase(titulo.trim())) {
                iterator.remove();
                System.out.println("Livro removido com sucesso.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro com título \"" + titulo + "\" não encontrado.");
        }
    }

    public void pesquisarLivroPorTitulo(String titulo) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo.trim())) {
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro com o título \"" + titulo + "\" foi encontrado.");
        }
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void clear() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros para remover.");
        } else {
            livros.clear();
            System.out.println("Todos os livros foram removidos.");
        }
    }
}
