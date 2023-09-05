package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import src.Livro;
import src.Membro;
import src.Biblioteca;

public class testBiblioteca {
    private Biblioteca biblioteca;



    @Test
    public void testRegistrarLivro() {
        biblioteca = new Biblioteca();
        Livro novoLivro = new Livro(102, "1984", "George Orwell");
        biblioteca.registrarLivro(novoLivro);
        assertTrue(biblioteca.getLivrosDisponiveis().contains(novoLivro));
    }

    @Test
    public void testEmprestarLivroParaMembro() {
        Biblioteca biblioteca = new Biblioteca(); 
        Livro novoLivro = new Livro(200, "1984", "George Orwell");
        Membro novoMembro = new Membro(1, "João");
    
        biblioteca.registrarLivro(novoLivro);
        biblioteca.registrarMembro(novoMembro);
        biblioteca.emprestarLivro(200, 1);
        
        
        assertTrue(novoMembro.getLivrosEmprestados().contains(novoLivro));
    }
    

    @Test
    public void testRetornarLivroParaMembro() {
        Biblioteca biblioteca = new Biblioteca(); 
        Livro novoLivro = new Livro(200, "1984", "George Orwell");
        Membro novoMembro = new Membro(1, "João");
    
        biblioteca.registrarLivro(novoLivro);
        biblioteca.registrarMembro(novoMembro);       
        biblioteca.emprestarLivro(200, 1);       
        biblioteca.retornarLivro(200, 1);
        
        assertFalse(novoMembro.getLivrosEmprestados().contains(novoLivro));
    }
    


    @Test
    public void testEmprestarLivroNaoDisponivel() {
        biblioteca = new Biblioteca();
        Livro novoLivro = new Livro(200, "1984", "George Orwell");
        Membro novoMembro = new Membro(1, "João");
        biblioteca.registrarLivro(novoLivro);
        biblioteca.registrarMembro(novoMembro);
        biblioteca.emprestarLivro(200, 1);
        assertThrows(IllegalStateException.class, () -> biblioteca.emprestarLivro(200, 1));
         }
}
    

