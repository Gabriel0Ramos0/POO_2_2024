package atividade_conta_bancaria;

public class Conta_Bancaria {
	
	public int numeroConta;
	public double saldo;
	
	public Conta_Bancaria() {
		setNumeroConta(-1);
		setSaldo(0);
	}

	public Conta_Bancaria(int numeroConta, double saldo) {
		setNumeroConta(numeroConta);
		setSaldo(saldo);
	}

	@Override
	public String toString() {
		return "Numero da Conta = " + numeroConta + "\nSaldo = " + saldo;
	}
	
	public void deposito (double valor) {
		setSaldo(getSaldo() + valor);
	}
	
	public boolean saque(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo()-valor);
            return true;
        }
        return false;
    }
	
	public boolean transferencia(Conta_Bancaria destino, double valor) {
		if (valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			destino.deposito(valor);
			return true;
		}
		return false;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}