package atividade_de_leitura_de_arquivos;

import javax.swing.JOptionPane;

public class Quests {
    private static Arquivos_Perguntas arquivo = new Arquivos_Perguntas("Perguntas.txt");
    private static Perguntas perguntaAtual;
    private static int score =0;

    public static void main(String[] args) {
        String menu = "Digite o número da opção desejada!"
        			+ "\n1 - Rodada de Perguntas" 
        			+ "\n2 - Score Total" 
        			+ "\n3 - Sair";
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (op == 1) {
            	for (int i = 0; i < 10; i++) {
                    perguntaAtual = arquivo.sortearPergunta();
                    if (perguntaAtual != null) {
                        String[] opcoes = {"Verdadeiro", "Falso"};
                        int respostaIndex = JOptionPane.showOptionDialog(
                                null,
                                "Pergunta " + (i + 1) + ": " + perguntaAtual,
                                "Responda:",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcoes,
                                opcoes[0]);

                        boolean respostaUsuario = (respostaIndex == 0);
                        boolean resultado = arquivo.verificarResposta(perguntaAtual, respostaUsuario);
                        if (resultado) {
                            JOptionPane.showMessageDialog(null, "Resposta correta!");
                            score++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Resposta incorreta.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há perguntas disponíveis.");
                        break;
                    }
                }
            }
            if (op == 2) {
            	if (score > 0) {
            		JOptionPane.showMessageDialog(null, "Pontuação Final: " + score + " / 10");
            	} else {
            		JOptionPane.showMessageDialog(null, "Score = 0, jogue uma rodada para aumentá-lo!");
            	}
            }            
            if (op == 3) {
            	//arquivo.listarPerguntas();
            	JOptionPane.showMessageDialog(null, "Saindo...");
            }            
        } while (op != 3);
    }
}
