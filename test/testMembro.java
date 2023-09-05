package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import src.Livro;
import src.Membro;

public class testMembro {

    @Test
    public void testCriarMembro() {
        Membro membro = new Membro(1, "nada");

        membro.criarMembro(1, "João");
        
        assertEquals(1, membro.getId());
        assertEquals("João", membro.getNome());
        
    }

    @Test
    public void testMembroEmprestarLivro() {
        Membro membro = new Membro(1, "João");
        Livro livro = new Livro(1, "Livro A", "Autor A");
        
        membro.membroEmprestarLivro(livro);
        
        assertTrue(livro.estaEmprestado());
        assertTrue(membro.getLivrosEmprestados().contains(livro));        
        
    }

    @Test
    public void testMembroRetornarLivro() {
        Membro membro = new Membro(1, "João");
        Livro novolivro = new Livro(70, "Livro novo", "Maria");        
        
        membro.membroEmprestarLivro(novolivro);        
        membro.membroRetornarLivro(novolivro);
        
        assertFalse(novolivro.estaEmprestado());
        assertFalse(membro.getLivrosEmprestados().contains(novolivro));
        
    }
}

