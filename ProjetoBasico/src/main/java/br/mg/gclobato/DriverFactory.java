package br.mg.gclobato;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.mg.gclobato.Propriedades.TipoExecucao;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
	
	//private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		WebDriver driver = null;
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.BROWSER) {
			    case FIREFOX: driver = new FirefoxDriver(); break;
			    case CHROME: driver = new ChromeDriver(); break;
			}
	    }
	    if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
	    	DesiredCapabilities cap = null;
	    	switch (Propriedades.BROWSER) {
	    	    case FIREFOX: cap = DesiredCapabilities.firefox(); break;
    	        case CHROME: cap = DesiredCapabilities.chrome(); break;
	    	}
	    	try {
				driver = new RemoteWebDriver(new URL("http://192.168.0.116:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
	    }
	    if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
	    	DesiredCapabilities cap = null;
	    	switch (Propriedades.BROWSER) {
	    	    case FIREFOX: cap = DesiredCapabilities.firefox(); break;
	    	    case CHROME: cap = DesiredCapabilities.chrome(); break;
	    	}
	    	try {
				driver = new RemoteWebDriver(new URL("https://oauth-roncarcla18-f7116:956fd19b-658e-48ef-b785-763062a623ab@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o Nuvem");
				e.printStackTrace();
			}
	    }
		driver.manage().window().maximize();			
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}


