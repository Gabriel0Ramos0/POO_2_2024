package atividade_conta_bancaria.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Conta_Bancaria;
import atividade_conta_bancaria.Conta_Corrente;
import atividade_conta_bancaria.Conta_Especial;

public class Conta_Especial_Teste {
	
	Conta_Bancaria conta1;
	Conta_Bancaria conta2;

    @BeforeEach
    public void inicializar() {
        conta1 = new Conta_Especial(123, 1000.0, 500);
        conta2 = new Conta_Especial();
    }
	
	@Test
    public void ConstrutorTeste() {
        int numeroConta = 12345;
        double saldo = 1000.0;

        Conta_Corrente conta = new Conta_Corrente(numeroConta, saldo);

        assertEquals(numeroConta, conta.getNumeroConta());
        assertEquals(saldo, conta.getSaldo(), 0.0);
    }
	
	@Test
    public void SaqueTeste() {
        conta1.saque(500);
        assertEquals(500, conta1.getSaldo());
        assertFalse(conta1.saque(1500.0)); 
        assertFalse(conta2.saque(1500.0)); 
    }
}
