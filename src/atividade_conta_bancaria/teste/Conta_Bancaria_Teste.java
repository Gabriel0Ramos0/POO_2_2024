package atividade_conta_bancaria.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Conta_Bancaria;

class Conta_Bancaria_Teste {

	Conta_Bancaria conta1;
	Conta_Bancaria conta2;
	Conta_Bancaria conta3;

    @BeforeEach
    public void inicializar() {
        conta1 = new Conta_Bancaria(1, 1000.0);
        conta2 = new Conta_Bancaria();
        conta3 = new Conta_Bancaria(2, 1500.0);
    }
    
    @Test
    public void toStringTeste() {
    	String retorno1 = conta1.toString();
    	String retorno2 = conta2.toString();
    	String retorno3 = conta3.toString();
		assertEquals("Numero da Conta = " + "1" + "\nSaldo = " + "1000.0", retorno1);
		assertEquals("Numero da Conta = " + "-1" + "\nSaldo = " + "0.0", retorno2);
		assertEquals("Numero da Conta = " + "2" + "\nSaldo = " + "1500.0", retorno3);
    }

    @Test
    public void DepositoTeste() {
    	conta1.deposito(500);
    	conta2.deposito(500);
    	assertEquals(1500, conta1.getSaldo());
    	assertEquals(500, conta2.getSaldo());
    }

    @Test
    public void SaqueTeste() {
        conta1.saque(500);
        assertEquals(500, conta1.getSaldo());
        assertFalse(conta1.saque(1500.0)); 
        assertFalse(conta2.saque(1500.0)); 
    }
    
    @Test
    public void TransferenciaTeste() {
        conta1.transferencia(conta2, 500);
        assertEquals(500, conta1.getSaldo());
        conta2.transferencia(conta1, 100);
        assertEquals(400, conta2.getSaldo());
        assertFalse(conta2.transferencia(conta1, 500));
        //transferir pra uma conta inexistente
    }
}