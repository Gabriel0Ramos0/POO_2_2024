package atividade_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Conta_Corrente;

class Conta_Corrente_Teste {

	@Test
    public void testConstrutor() {

        Conta_Corrente conta = new Conta_Corrente(12345, 1000);

        assertEquals(12345, conta.getNumeroConta());
        assertEquals(1000.0, conta.getSaldo(), 0.0);
    }
}