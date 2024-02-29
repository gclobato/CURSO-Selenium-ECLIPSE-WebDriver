package br.mg.gclobato.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.gclobato.DriverFactory;
import br.mg.gclobato.pages.LoginPage;
import br.mg.gclobato.tests.ContaTest;
import br.mg.gclobato.tests.MovimentacaoTest;
import br.mg.gclobato.tests.RemoverMovimentacaoContaTest;
import br.mg.gclobato.tests.ResumoTest;
import br.mg.gclobato.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset(){
		page.acessarTelaInicial();
		
		page.setEmail("roncarcla18@gmail.com");
		page.setSenha("310506");
        page.entrar();
		
		page.resetar();
		
		DriverFactory.killDriver();
	}
}







