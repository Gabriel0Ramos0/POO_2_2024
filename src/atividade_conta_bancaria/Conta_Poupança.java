package atividade_conta_bancaria;

import java.time.LocalDate;

public class Conta_Poupança extends Conta_Bancaria{
	
	private final int limiteMensal = 5;
	private int quantidadeDeSaquesMensais;
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
		LocalDate hoje = LocalDate.now();
		if (hoje.getMonthValue() != getMes()) {
			quantidadeDeSaquesMensais = 0; 
			mes = hoje.getMonthValue(); 
		}
		if (quantidadeDeSaquesMensais < limiteMensal && valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			quantidadeDeSaquesMensais++;
			return true;
		}
		return false;
	}

	public int getSaquesMensais() {
		return quantidadeDeSaquesMensais;
	}

	public void setSaquesMensais(int quantidadeDeSaquesMensais) {
		this.quantidadeDeSaquesMensais = quantidadeDeSaquesMensais;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
}
