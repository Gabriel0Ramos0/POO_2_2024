package revisao_desafio_jogador;

import java.util.ArrayList;

public class Campeonato {
	
	public static Time timeComMaisGols(ArrayList<Time> times) {
		Time timeMaisGols = times.get(0);
		for (Time time : times) {
			if (time.golsdoTime() > timeMaisGols.golsdoTime()) {
				timeMaisGols = time;
			}
		}
		return timeMaisGols;
	}
	
	public static Jogador artilheiroCampeonato(ArrayList<Time> times) {
		Jogador artilheiroCampeonato = times.get(0).artilheirodoTime();
		for (Time time : times) {
			if (time.artilheirodoTime().getGols() > artilheiroCampeonato.getGols()) {
				artilheiroCampeonato = time.artilheirodoTime();
			}
		}
		return artilheiroCampeonato;
	}
}
