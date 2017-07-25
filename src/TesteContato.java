import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.SelectElement;

public class TesteContato {

	private ChromeDriver driver;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
	}

	@Test
	public void testFormContato() {
		
		driver.get("https://1-dot-hotsiteconti2017-dot-pdbenv-dev.appspot.com/#"); // Abre pagina		
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/a[2]/i")).click(); // Clica no menu
		driver.findElement(By.xpath("//*[@id=\"nav-mobile\"]/ul[2]/li[8]/a")).click(); // Clica no contato

		try {
			WebElement nome = driver.findElement(By.xpath("//*[@id=\"fullnamecontact\"]"));
			WebElement cpf = driver.findElement(By.xpath("//*[@id=\"cpfcontact\"]"));
			WebElement telefone = driver.findElement(By.xpath("//*[@id=\"phonenumbercontact\"]"));
			WebElement email = driver.findElement(By.xpath("//*[@id=\"emailcontact\"]"));
			WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"message\"]"));
			
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"select-options-4ef59496-765f-a49b-3d1f-1f0493ee9d66\"]/li[2]/span")));			
			
			
//			driver.findElement(By.xpath("//*[@id=\"frmcontato\"]/div[5]/div")).click();

			// Botão enviar
			driver.findElement(By.xpath("//*[@id=\"frmcontato\"]/div[7]/button")).click();

			nome.sendKeys("Elton dos Santos");
			cpf.sendKeys("213.409.018-97");
			telefone.sendKeys("11982324748");
			email.sendKeys("cooperton4@gmail.com");
			mensagem.sendKeys("Teste com Selenium");
		} catch (ElementNotInteractableException ex) {			
			System.out.println("Erro de Validação: " + ex);
		}
	}
	
	public void testeCadastro() {
		
	}

}
