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
        conta1 = new Conta_Poupança(123, 1000.0, 0, LocalDate.now().getMonthValue());
        conta2 = new Conta_Poupança();
    }

    @Test
    public void SaqueDentroDoLimiteMensalTeste() {
        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());

        assertTrue(conta1.saque(200.0));
        assertEquals(2, conta1.getSaquesMensais());

        assertTrue(conta1.saque(300.0));
        assertEquals(3, conta1.getSaquesMensais());
    }

    @Test
    public void SaqueForaDoLimiteMensalTeste() {
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
        
        assertFalse(conta1.saque(100.0));
        assertEquals(5, conta1.getSaquesMensais());
    }

    @Test
    public void ReiniciarContadorMensalTeste() {
        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());

        LocalDate newMonth = LocalDate.now().plusMonths(1);
        conta1.setMes(newMonth.getMonthValue());

        assertTrue(conta1.saque(100.0));
        assertEquals(1, conta1.getSaquesMensais());
    }

}