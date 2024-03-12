package leitura_arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import atividade_conta_bancaria.Conta_Bancaria;
import atividade_conta_bancaria.Conta_Corrente;
import atividade_conta_bancaria.Conta_Especial;
import atividade_conta_bancaria.Conta_Poupança;

public class ArquivoContas {
	
	public static void main(String[] args) {
		ArrayList<Conta_Bancaria> contas = new ArrayList<Conta_Bancaria>();
		try {
			FileReader fr = new FileReader("Contas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String v[] = linha.split(",");
				int nr = Integer.parseInt(v[1]);
				double saldo = Double.parseDouble(v[2]);
				if(v[0].equals("0")) {
					contas.add(new Conta_Corrente(nr, saldo));
				}
				if(v[0].equals("1")) {
					contas.add(new Conta_Poupança(nr, saldo, nr, nr));
				}
				if(v[0].equals("2")) {
					double limite = Double.parseDouble(v[3]);
					contas.add(new Conta_Especial(nr, saldo, limite));
				}
			}
			br.close();
			fr.close();
			
			for (Conta_Bancaria c : contas) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}