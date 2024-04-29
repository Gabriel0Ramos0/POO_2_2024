package jogo_perguntas_respostas.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import jogo_perguntas_respostas.Arquivo;
import jogo_perguntas_respostas.Pergunta;
import jogo_perguntas_respostas.Resposta;

class JogoTest {
	
	private Arquivo jogo = new Arquivo();

	@Test
	void carregaArquivoTeste() {
		jogo.lerArquivo();
		assertEquals(50, jogo.getPerguntas().size());
		Pergunta quarta = jogo.getPerguntas().get(3);
		assertEquals("O gelo é feito de água congelada", quarta.getTitulo());
		assertEquals(true, quarta.isRespostaCorreta());
	}
	
	@Test
	void fazCorrecaoAcertoTest() {
		Pergunta pergunta = new Pergunta("ABCD é EFGH, Falso");
		Resposta r = new Resposta (pergunta, false);
		assertEquals("acerto", r.correcao());
	}
	
	@Test
	void fazCorrecaoErroTest() {
		Pergunta pergunta = new Pergunta("ABCD é EFGH, Falso");
		Resposta r = new Resposta (pergunta, true);
		assertEquals("erro", r.correcao());
	}
	
	@Test
	void calculaPontuacaoTest() {
		assertEquals(2,  jogo.calculaPontuacao(respostasControladas()));
	}
	
	@Test
	void gravaRespostasTest() {
		ArrayList<Resposta> respostas = respostasControladas();
		jogo.gravaResultado(respostas);
		String conteudoArq = jogo.lerRespostas();
		assertEquals("1,A,acerto\n2,B,acerto\n2,C,erro\n4,D,erro\n", conteudoArq);
	}
	
	@Test
	void sorteiaRodada() {
		jogo.lerArquivo();
		Pergunta primeira = jogo.getPerguntas().get(0);
		Pergunta segunda = jogo.getPerguntas().get(1);
		assertEquals("A Terra é redonda", primeira.getTitulo());
		assertEquals("O Sol é uma estrela", segunda.getTitulo());
		ArrayList<Pergunta> sorteadas = jogo.sorteiaRodada(10);		
		primeira = sorteadas.get(0);
		segunda = sorteadas.get(1);
		assertEquals("A Terra é redonda", primeira.getTitulo());
		assertEquals("O Sol é uma estrela", segunda.getTitulo());
		assertEquals(10, sorteadas.size());
		
	}
	
	private ArrayList<Resposta> respostasControladas(){
		ArrayList<Resposta> respostas = new ArrayList<Resposta>();
		Pergunta p1 = new Pergunta("A", false);
		Pergunta p2 = new Pergunta("B", false);
		Pergunta p3 = new Pergunta("C", true);
		Pergunta p4 = new Pergunta("D", true);
		respostas.add(new Resposta(p1, false));
		respostas.add(new Resposta(p2, false));
		respostas.add(new Resposta(p3, false));
		respostas.add(new Resposta(p4, false));
		return respostas;
	}
 
}
