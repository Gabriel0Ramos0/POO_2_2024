package atividade_de_leitura_de_arquivos;

public class Perguntas {
	
	private String questao;
	private String Respostas;
	
	public Perguntas() {
		
	}

	public Perguntas(String questao, String respostas) {
		super();
		this.questao = questao;
		Respostas = respostas;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public String getRespostas() {
		return Respostas;
	}

	public void setRespostas(String respostas) {
		Respostas = respostas;
	}
	
}
