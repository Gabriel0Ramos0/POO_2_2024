package atividade_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividade_conta_bancaria.Banco;
import atividade_conta_bancaria.Conta_Bancaria;
import atividade_conta_bancaria.Conta_Corrente;
import atividade_conta_bancaria.Conta_Especial;
import atividade_conta_bancaria.Conta_Poupança;

class Banco_Teste {
	
	Banco banco;
    Conta_Bancaria conta1;
    Conta_Corrente conta2;
    Conta_Especial conta3;
    Conta_Poupança conta4;
	
	@BeforeEach
	public void inicializar() {
		banco = new Banco();
        conta1 = new Conta_Bancaria();
        conta2 = new Conta_Corrente(2, 2000.0);
        conta3 = new Conta_Especial(3, 1000.0, 500);
        conta4 = new Conta_Poupança(4, 1500.0, 0, 0);
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
		 conta2 = new Conta_Corrente(2, 2000.0);
	     conta3 = new Conta_Especial(3, 1000.0, 500);
		        
		 ArrayList<Conta_Bancaria> contas = new ArrayList<>();
		 Banco banco = new Banco(contas);
		 banco.adicionarConta(conta2);
		 banco.adicionarConta(conta3);
		 assertEquals(2, banco.getContas().size());
		 assertTrue(banco.getContas().contains(conta2));
		 assertTrue(banco.getContas().contains(conta3));
	 }
}