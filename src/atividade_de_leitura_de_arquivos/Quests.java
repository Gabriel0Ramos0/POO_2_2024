package atividade_de_leitura_de_arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Quests {
    private static Arquivos_Perguntas arquivo = new Arquivos_Perguntas("Perguntas.txt");
    private static Perguntas perguntaAtual;
    private static boolean resultado;
    private static int count = 0;
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
            	score = 0;
            	limparArquivo();
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
                        resultado = arquivo.verificarResposta(perguntaAtual, respostaUsuario);
                        count++;
                        gravaResultado();
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
            		JOptionPane.showMessageDialog(null, "Pontuação Final: " + score + " / 10"
            				+ "\nRespostas\n"
            				+ arquivo.lerRespostas());
            	} else {
            		JOptionPane.showMessageDialog(null, "Score = 0, jogue uma rodada para aumentá-lo!");
            	}
            }            
            if (op == 3) {
            	JOptionPane.showMessageDialog(null, "Saindo...");
            }            
        } while (op != 3);
    }
    
    public static void limparArquivo() {
        try {
            FileWriter fw = new FileWriter("respostas.txt", false);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void gravaResultado() {
		try {
			FileWriter fw = new FileWriter("respostas.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
				bw.append(
				    (count) +", "+
					perguntaAtual + ", ");
				if (resultado == true) {
					bw.append("acerto\n");
				} else {
					bw.append("erro\n");
				}
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
