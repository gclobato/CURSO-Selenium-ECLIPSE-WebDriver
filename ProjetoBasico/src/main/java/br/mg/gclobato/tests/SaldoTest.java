package br.mg.gclobato.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gclobato.BaseTest;
import br.mg.gclobato.pages.HomePage;
import br.mg.gclobato.pages.MenuPage;


public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void testSaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}





