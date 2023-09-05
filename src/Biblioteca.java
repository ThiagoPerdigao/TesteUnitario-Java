package src;
import java.util.ArrayList;
import java.util.List;

    public class Biblioteca {
    private List<Livro> livrosDisponiveis;
    private List<Membro> membros;

    public Biblioteca() {
        this.livrosDisponiveis = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    public void registrarLivro(Livro livro) {
        livrosDisponiveis.add(livro);
    }

    public void registrarMembro(Membro membro) {
        membros.add(membro);
    }

    public void emprestarLivro(int livroId, int membroId) {
        Livro livro = encontrarLivroPorId(livroId);
        Membro membro = encontrarMembroPorId(membroId);

        if (livro == null || membro == null) {
            throw new IllegalArgumentException("Livro ou membro não encontrado.");
        }

        if (livro.estaEmprestado()) {
            throw new IllegalStateException("O livro já está emprestado.");
        }

       
        membro.membroEmprestarLivro(livro);
    }

    public void retornarLivro(int livroId, int membroId) {
        Livro livro = encontrarLivroPorId(livroId);
        Membro membro = encontrarMembroPorId(membroId);

        if (livro == null || membro == null) {
            throw new IllegalArgumentException("Livro ou membro não encontrado.");
        }

        if (!membro.getLivrosEmprestados().contains(livro)) {
            throw new IllegalStateException("Este membro não possui este livro emprestado.");
        }

        membro.membroRetornarLivro(livro);
    }

    private Livro encontrarLivroPorId(int livroId) {
        for (Livro livro : livrosDisponiveis) {
            if (livro.getId() == livroId) {
                return livro;
            }
        }
        return null;
    }

    private Membro encontrarMembroPorId(int membroId) {
        for (Membro membro : membros) {
            if (membro.getId() == membroId) {
                return membro;
            }
        }
        return null;
    }

    // Getters e setters
    public List<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public void setLivrosDisponiveis(List<Livro> livrosDisponiveis) {
        this.livrosDisponiveis = livrosDisponiveis;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }
}

