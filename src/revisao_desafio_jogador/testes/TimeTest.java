package revisao_desafio_jogador.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao_desafio_jogador.Jogador;
import revisao_desafio_jogador.Time;

class TimeTest {
	
	Time t1;
	Time t2;
	
	@BeforeEach
	public void inicializa() {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador ("N1", 1, 1));
		jogadores.add(new Jogador ("N2", 2, 2));
		jogadores.add(new Jogador ("N3", 3, 3));
		jogadores.add(new Jogador ("N4", 4, 4));
		jogadores.add(new Jogador ("N5", 5, 5));
		t1 = new Time("Time 1", jogadores);
		t2 = new Time();
	}	

	@Test
	void listaJogadoresTest() {
		String retorno = t1.listaJogadores();
		assertEquals("Jogador " + "\nNome=" + "N1" + "\nCamisa=" + "1" 
			+ "\nGols=" + "1" + "\n" 
			+ "Jogador " + "\nNome=" + "N2" + "\nCamisa=" + "2"  
				+ "\nGols=" + "2" + "\n" 
			+ "Jogador " + "\nNome=" + "N3" + "\nCamisa=" + "3"  
				+ "\nGols=" + "3" + "\n"
			+ "Jogador " + "\nNome=" + "N4" + "\nCamisa=" + "4"  
				+ "\nGols=" + "4" + "\n" 
			+ "Jogador " + "\nNome=" + "N5" + "\nCamisa=" + "5"  
				+ "\nGols=" + "5" + "\n", retorno);
		assertEquals("", t2.listaJogadores());
	}
	
	@Test
	void toStringTest() {
		assertEquals("Time 1 (5)", t1.toString());
		assertEquals(" (0)", t2.toString());
	}
	
	@Test
	void artilheiroTest() {
		assertEquals("Jogador " + "\nNome=" + "N5" + "\nCamisa=" + "5"  
				+ "\nGols=" + "5", t1.artilheirodoTime().toString());
		assertEquals("Jogador " + "\nNome=" + "" + "\nCamisa=" + "999"  
				+ "\nGols=" + "-1", t2.artilheirodoTime().toString());
	}
	
	@Test
	void qtGolsTest() {
		assertEquals(15, t1.golsdoTime());
		assertEquals(0, t2.golsdoTime());
	}

}
