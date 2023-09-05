package src;
import java.util.ArrayList;
import java.util.List;

public class Membro {
    private int id;
    private String nome;
    private List<Livro> livrosEmprestados;

    public Membro(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }    

    public void criarMembro(int novoId, String novoNome) {
        this.id = novoId;
        this.nome = novoNome;
    }

    public void membroEmprestarLivro(Livro livro) {
        livro.emprestarLivroStatus();
        livrosEmprestados.add(livro);
    }

    public void membroRetornarLivro(Livro livro) {
        if (!livrosEmprestados.contains(livro)) {
            throw new IllegalStateException("Este membro não possui este livro emprestado.");
        }
        livro.retornarLivroStatus();
        livrosEmprestados.remove(livro);
    }
}