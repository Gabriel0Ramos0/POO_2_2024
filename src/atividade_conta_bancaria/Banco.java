package atividade_conta_bancaria;

import java.util.ArrayList;

public class Banco {
	
	private ArrayList<Conta_Bancaria> contas;

	public Banco() {
		contas = new ArrayList<>();
	}

	public Banco(ArrayList<Conta_Bancaria> contas) {
		this.contas = contas;
	}
	
	public void adicionarConta(Conta_Bancaria conta) {
		contas.add(conta);
	}

	public ArrayList<Conta_Bancaria> getContas() {
		return contas;
	}	
}
