package atividade_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Conta_Corrente;

class Conta_Corrente_Teste {

	@Test
    public void testConstrutor() {
        int numeroConta = 12345;
        double saldo = 1000.0;

        Conta_Corrente conta = new Conta_Corrente(numeroConta, saldo);

        assertEquals(numeroConta, conta.getNumeroConta());
        assertEquals(saldo, conta.getSaldo(), 0.0);
    }
}
