package atividade_conta_bancaria.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import atividade_conta_bancaria.Conta_Especial;

public class Conta_Especial_Teste {
	
	Conta_Especial conta1;
	Conta_Especial conta2;

    @BeforeEach
    public void inicializar() {
        conta1 = new Conta_Especial(123, 1000.0, 500);
        conta2 = new Conta_Especial();
    }
	
	@Test
    public void ConstrutorTeste() {

        assertEquals(123, conta1.getNumeroConta());
        assertEquals(1000.0, conta1.getSaldo(), 0.0);
        assertEquals(500, conta1.getLimite());
        assertEquals(-1, conta2.getNumeroConta());
        assertEquals(0.0, conta2.getSaldo(), 0.0);
        assertEquals(0, conta2.getLimite());
    }
	
	@Test
    public void SaqueTeste() {
        conta1.saque(500);
        assertEquals(500, conta1.getSaldo());
        assertFalse(conta1.saque(1500.0)); 
        assertFalse(conta2.saque(1500.0)); 
        conta2.deposito(1500);
        conta2.setLimite(600);
        conta2.saque(700);
        assertFalse(conta2.saque(700));
        assertEquals(1500, conta2.getSaldo());
    }
}