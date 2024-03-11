package atividade_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Banco;
import atividade_conta_bancaria.Conta_Bancaria;
import atividade_conta_bancaria.Conta_Corrente;

class Banco_Teste {
	
	Banco banco;
    Conta_Bancaria conta1;
    Conta_Bancaria conta2;
    Conta_Bancaria conta3;
    Conta_Corrente contaCorrente;
	
	@BeforeEach
	public void inicializar() {
		banco = new Banco();
        conta1 = new Conta_Bancaria(1, 1000.0);
        conta2 = new Conta_Bancaria(2, 2000.0);
        conta3 = new Conta_Bancaria();
	}

	 @Test
	 public void adicionarContaTeste() {
		 banco.adicionarConta(conta1);
		 assertEquals(1, banco.getContas().size());
		 assertTrue(banco.getContas().contains(conta1));
		 banco.adicionarConta(conta2);
		 assertEquals(2, banco.getContas().size());
		 assertTrue(banco.getContas().contains(conta2)); 
		 assertFalse(banco.getContas().contains(conta3));
	 }
	 
	 @Test
	 public void construtorComArrayListTeste() {
		 conta1 = new Conta_Bancaria(123, 1000.0);
		 conta2 = new Conta_Bancaria(321, 2000.0);
		        
		 ArrayList<Conta_Bancaria> contas = new ArrayList<>();
		 Banco banco = new Banco(contas);
		 banco.adicionarConta(conta1);
		 banco.adicionarConta(conta2);
		 assertEquals(2, banco.getContas().size());
		 assertTrue(banco.getContas().contains(conta1));
		 assertTrue(banco.getContas().contains(conta2));
	 }
}