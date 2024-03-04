package revisao_desafio_jogador;

import java.util.ArrayList;

public class Time {

	private String nome;
	private ArrayList<Jogador> jogadores;
	
	public Time() {
		setNome("");
		setJogadores(jogadores = new ArrayList<>());
	}
	
	public Time(String nome, ArrayList<Jogador> jogadores) {
		this.nome = nome;
		this.jogadores = jogadores;
	}
	
	public String listaJogadores() {
		String retorno = "";
		for (Jogador jogador : jogadores) {
			retorno += jogador + "\n";
		}
		return retorno;
	}
	
	public Jogador artilheirodoTime() {
		Jogador artilheiro = new Jogador();
		for (Jogador jogador : jogadores) {
			if (jogador.getGols() > artilheiro.getGols()) {
				artilheiro = jogador;
			}
		}
		return artilheiro;
	}
	
	public int golsdoTime() {
		int qtGols = 0;
		Jogador artilheiro = new Jogador();
		for (Jogador jogador : jogadores) {
			qtGols += jogador.getGols();
		}
		return qtGols;
	}

	@Override
	public String toString() {
		return getNome() + " (" + getJogadores().size()+ ")";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}	
}
