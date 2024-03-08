package atividade_conta_bancaria.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Conta_Corrente;

class Conta_Corrente_Teste {
	
	Conta_Corrente conta1;
	Conta_Corrente conta2;

    @BeforeEach
    public void inicializar() {
        conta1 = new Conta_Corrente(123, 1000.0);
        conta2 = new Conta_Corrente();
    }
	
    @Test
    public void construtorTeste() {

        Conta_Corrente conta = new Conta_Corrente(12345, 1000);

        assertEquals(12345, conta.getNumeroConta());
        assertEquals(1000.0, conta.getSaldo(), 0.0);
    }
	
	@Test
    public void saqueTeste() {
        conta1.saque(500);
        assertEquals(500, conta1.getSaldo());
        assertFalse(conta1.saque(1500.0)); 
        assertFalse(conta2.saque(1500.0)); 
        conta2.deposito(1500);
        conta2.saque(700);
        assertEquals(800, conta2.getSaldo());
    }
	
	@Test
    public void transferenciaTeste() {
    	conta1.transferencia(conta2, 700);
    	assertEquals(300, conta1.getSaldo());
    	assertEquals(700, conta2.getSaldo());
    }
}