package br.mg.gclobato.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gclobato.BaseTest;
import br.mg.gclobato.pages.ContasPage;
import br.mg.gclobato.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}




