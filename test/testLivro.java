package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import src.Livro;

public class testLivro {


    @Test
    public void testCriarLivro() {
        Livro livro = new Livro(1, "nada", "nada");

        livro.criarLivro(1, "Moby Dick", "Herman Melville");
        
        assertEquals(1, livro.getId());
        assertEquals("Moby Dick", livro.getTitulo());
        assertEquals("Herman Melville", livro.getAutor());
    }


    @Test
    public void testEmprestarLivroStatus() {

        Livro livro = new Livro(1, "Livro do Thiago", "Thiago");
       
        livro.emprestarLivroStatus();
        assertTrue(livro.estaEmprestado());
    }

     @Test
    public void testRetornarLivro() {

        Livro livro = new Livro(1, "Livro do Thiago", "Thiago");
        livro.emprestarLivroStatus();
        livro.retornarLivroStatus();
        assertFalse(livro.estaEmprestado());

    }

    




}