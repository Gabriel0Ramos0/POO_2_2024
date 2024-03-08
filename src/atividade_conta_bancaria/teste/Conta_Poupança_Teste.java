package atividade_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Conta_Poupança;

class Conta_Poupança_Teste {
	
	Conta_Poupança conta1;
	Conta_Poupança conta2;

    @BeforeEach
    public void inicializar() {
        conta1 = new Conta_Poupança(123, 500.0, 0, LocalDate.now().getMonthValue());
        conta2 = new Conta_Poupança();
    }

    @Test
    public void SaqueDentroDoLimiteMensalTeste() {
    	conta1.deposito(500);
    	assertEquals(1000, conta1.getSaldo());
    	
        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());

        assertTrue(conta1.saque(200.0));
        assertEquals(2, conta1.getSaquesMensais());

        assertTrue(conta1.saque(300.0));
        assertEquals(3, conta1.getSaquesMensais());
        assertEquals(400, conta1.getSaldo());
    }

    @Test
    public void saqueForaDoLimiteMensalTeste() {
    	conta1.deposito(500);
    	assertEquals(1000, conta1.getSaldo());
    	
        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());

        assertTrue(conta1.saque(200.0));
        assertEquals(2, conta1.getSaquesMensais());

        assertTrue(conta1.saque(300.0));
        assertEquals(3, conta1.getSaquesMensais());

        assertTrue(conta1.saque(100.0));
        assertEquals(4, conta1.getSaquesMensais());
        
        assertTrue(conta1.saque(100.0));
        assertEquals(5, conta1.getSaquesMensais());
        assertEquals(200, conta1.getSaldo());
        
        //Saque não é efetuado e tanto a contagem de saques mensais qualto o saldo não são alterados
        assertFalse(conta1.saque(100.0));
        assertEquals(5, conta1.getSaquesMensais());
        assertEquals(200, conta1.getSaldo());
    }

    @Test
    public void reiniciarContadorMensalTeste() {
        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());
        assertTrue(conta1.saque(300.0));
        assertEquals(2, conta1.getSaquesMensais());
        
        //Passa para o mês seguinte e reinicia a contagem de sagues mensais
        LocalDate newMonth = LocalDate.now().plusMonths(1);
        conta1.setMes(newMonth.getMonthValue());

        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());
    }
    
    @Test
    public void transferenciaTeste() {
    	conta1.transferencia(conta2, 500);
    	assertEquals(0, conta1.getSaldo());
    	assertEquals(500, conta2.getSaldo());
    }

}