package atividade_conta_bancaria;

public class Conta_Especial extends Conta_Bancaria{

	public double limite;
	
	public Conta_Especial() {
		super();
	}

	public Conta_Especial(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		setLimite(limite);
	}

	@Override
	public boolean saque(double valor) {
		if (valor <= saldo && valor <= getLimite()) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nLimite = "+getLimite();
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
}