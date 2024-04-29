package banco_de_dados.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import banco_de_dados.CidadeService;
import banco_de_dados.Conexao;
import banco_de_dados.model.Cidade;

class bancoDadosTeste {

	@Test
	void coneccaoTeste() {
		assertNotNull(Conexao.conectaMySql());
	}
	
	@Test
	void insereCidadeTest() {
		//Cidade c= new Cidade(0, "Araranguá", "SC");
		//assertEquals(1,  CidadeService.insereCidade(c));
	}
	
	@Test
	void alteraCidadeExistenteTest() {
		//Cidade c = new Cidade(6, "Brasília", "DF");
		//assertEquals(1, CidadeService.alteraCidade(c));
	}
	
	@Test
	void alteraCidadeInexistenteTest() {
		Cidade c = new Cidade(25, "Brasília", "DF");
		assertEquals(0, CidadeService.alteraCidade(c));
	}
	
	@Test
	void excluirCidadeTest() {
		//Cidade c = new Cidade(1, "", "");
		//assertEquals(1, CidadeService.deleteCidade(c));
	}
	
	@Test
	void excluirCidadeInexistenteTest() {
		//Cidade c = new Cidade(0, "", "");
		//assertEquals(0, CidadeService.deleteCidade(c));
	}
	
	@Test
	void listaCidadeTest() {
		ArrayList<Cidade> lista = CidadeService.listAll();
		for (Cidade c : lista) {
			System.out.println(c);
		}
	}

}
