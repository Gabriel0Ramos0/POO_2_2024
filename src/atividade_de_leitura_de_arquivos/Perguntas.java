package atividade_de_leitura_de_arquivos;

public class Perguntas {
    private String pergunta;
    private boolean resposta;

    public Perguntas(String pergunta, boolean resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
    
    @Override
    public String toString() {
        return pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public boolean getResposta() {
        return resposta;
    }

}