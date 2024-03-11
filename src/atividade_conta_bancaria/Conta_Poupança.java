package atividade_conta_bancaria;

import java.time.LocalDate;

public class Conta_Poupança extends Conta_Bancaria{
	
	private final int limiteMensal = 5;
	private int SaquesMensais;
	private int mes;
	
	public Conta_Poupança() {
		super();
	}

	public Conta_Poupança(int numeroConta, double saldo, int saquesMensais, int mes) {
		super(numeroConta, saldo);
		setSaquesMensais(0);
		setMes(LocalDate.now().getMonthValue());
	}

	@Override
	public boolean saque(double valor) {
		//Verifica o mês e atualiza se for diferente
		LocalDate hoje = LocalDate.now();
		if (hoje.getMonthValue() != getMes()) {
			SaquesMensais = 0; 
			mes = hoje.getMonthValue(); 
		}		
		//Pode realizar o saque até o limite mensal
		if (SaquesMensais < limiteMensal && valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			SaquesMensais++;
			return true;
		}
		return false;
	}

	public int getSaquesMensais() {
		return SaquesMensais;
	}

	public void setSaquesMensais(int SaquesMensais) {
		this.SaquesMensais = SaquesMensais;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
}