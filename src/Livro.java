package src;


public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false; 
    }




    public void criarLivro(int novoId, String novoTitulo, String novoAutor) {
        this.id = novoId;
        this.titulo = novoTitulo;
        this.autor = novoAutor;
        this.emprestado = false; 
    }


    public void emprestarLivroStatus() {
        if (emprestado) {
            throw new IllegalStateException("O livro já está emprestado.");
        }
        this.emprestado = true;
    }

    public void retornarLivroStatus() {
        if (!emprestado) {
            throw new IllegalStateException("O livro já foi retornado.");
        }
        this.emprestado = false;
    }



    // Método para verificar se o livro está emprestado
    public boolean estaEmprestado() {
        return emprestado;
    }



    // Getters e setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}



