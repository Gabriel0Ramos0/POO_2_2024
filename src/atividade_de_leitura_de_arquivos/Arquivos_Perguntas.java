package atividade_de_leitura_de_arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Arquivos_Perguntas {
    private ArrayList<Perguntas> perguntas = new ArrayList<>();

    public Arquivos_Perguntas(String arquivoP) {
        try {
            FileReader fr = new FileReader(arquivoP);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String pergunta = dados[0];
                String respostaStr = dados[1].trim();
                boolean resposta;
                if (respostaStr.equalsIgnoreCase("verdadeiro")) {
                    resposta = true;
                } else if (respostaStr.equalsIgnoreCase("falso")) {
                    resposta = false;
                } else {
                    throw new IllegalArgumentException("Valor de resposta inválido: " + respostaStr);
                }
                perguntas.add(new Perguntas(pergunta, resposta));
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Perguntas sortearPergunta() {
        if (perguntas.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int indice = random.nextInt(perguntas.size());
        return perguntas.get(indice);
    }

    public boolean verificarResposta(Perguntas pergunta, boolean respostaUsuario) {
        return pergunta.getResposta() == respostaUsuario;
    }
    
    /* Testando método de arquivo_Perguntas.
     * Usar só pra verificar como está salvando as perguntas
     */
    public void listarPerguntas() {
        System.out.println("Lista de Perguntas e Respostas:");
        for (Perguntas pergunta : perguntas) {
            System.out.println("Pergunta: " + pergunta.getPergunta());
            System.out.println("Resposta: " + pergunta.getResposta());
            System.out.println("-------------------------");
        }
    }

    public ArrayList<Perguntas> getPerguntas() {
        return perguntas;
    }
}
