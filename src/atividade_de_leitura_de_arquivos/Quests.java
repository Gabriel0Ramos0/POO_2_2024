package atividade_de_leitura_de_arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Quests {
	
	public static void main(String[] args) {
		String menu = "1 - Rodada de Perguntas\n"
				+ "2 - Score Total\n"
				+ "3 - Sair";
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			if (op == 1) {
				ler();
			}
			if (op == 2) {
				
			}			
		}while (op!=3);
	}
	
	private static void ler() {
		//Estava testando
		try {
			FileReader fr = new FileReader("Perguntas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while ((linha = br.readLine()) !=null){
				System.out.println(linha);
				System.out.println(linha.length());
			}
			br.close();			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
