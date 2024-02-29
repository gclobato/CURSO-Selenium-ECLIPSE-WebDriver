package br.mg.gclobato.pages;

import org.openqa.selenium.By;

import br.mg.gclobato.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}

	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}

	public void buscar() {
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}
}
