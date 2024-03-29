package revisao_desafio_jogador.testes;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import revisao_desafio_jogador.Campeonato;
import revisao_desafio_jogador.Jogador;
import revisao_desafio_jogador.Time;

class CampeonatoTeste {

	ArrayList<Time> times = new ArrayList<Time>();
	Campeonato campeonato = new Campeonato();
	
	@BeforeEach
	void inicializa() {
		ArrayList<Jogador> jogadores1 = new ArrayList<Jogador>();
		jogadores1.add(new Jogador ("N1", 1, 1));
		jogadores1.add(new Jogador ("N2", 2, 2));
		jogadores1.add(new Jogador ("N3", 3, 3));
		jogadores1.add(new Jogador ("N4", 4, 4));
		jogadores1.add(new Jogador ("N5", 5, 5));
		Time t1 = new Time("Time 1", jogadores1);
		ArrayList<Jogador> jogadores2 = new ArrayList<Jogador>();
		jogadores2.add(new Jogador ("N6", 6, 6));
		jogadores2.add(new Jogador ("N7", 7, 7));
		jogadores2.add(new Jogador ("N8", 8, 8));
		jogadores2.add(new Jogador ("N9", 9, 9));
		jogadores2.add(new Jogador ("N10", 10, 10));
		Time t2 = new Time("Time 2", jogadores2); 
		ArrayList<Jogador> jogadores3 = new ArrayList<Jogador>();
		jogadores3.add(new Jogador ("xxx", 99, 0));
		jogadores3.add(new Jogador ("zzz", 99, 0));
		Time t3 = new Time("Time 3", jogadores3);
		times = new ArrayList<Time>();
		times.add(t1);
		times.add(t2);
		times.add(t3);
	}
	
	@Test
	void timeMaisGolsTest() {
		Time timeMaisGols = Campeonato.timeComMaisGols(times);
		assertEquals("Time 2 (5)", timeMaisGols.toString());
	}
	
	@Test
	void artilheiroCampeonatoGolsTest() {
		Jogador artilheiro = Campeonato.artilheiroCampeonato(times);
		assertEquals("Jogador " + "\nNome=" + "N10" + "\nCamisa=" + "10" 
				+ "\nGols=" + "10", artilheiro.toString());
	}

}
