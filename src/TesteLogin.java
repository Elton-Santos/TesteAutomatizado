import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteLogin {

	private ChromeDriver driver;
	private String cpf = "213.409.018-97";
	private String senha = "abcd1234";

	public void abreUrls() {
		driver.get("https://1-dot-hotsiteconti2017-dot-pdbenv-dev.appspot.com/#"); // Abre pagina
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/a[2]/i")).click(); // Clica no menu
		driver.findElement(By.xpath("//*[@id=\"nav-mobile\"]/ul[3]/li/a")).click(); // Clica menu entrar
	}

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
	}

	@Ignore
	public void loginComCpf() {
		abreUrls();

		try {

			// Seleciona div acessar conta
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btn-login\"]")));
			driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();

			WebElement cpf = driver.findElement(By.xpath("//*[@id=\"cpflogin\"]"));
			WebElement senha = driver.findElement(By.xpath("//*[@id=\"passwordlogin\"]"));

			cpf.sendKeys(this.cpf);
			senha.sendKeys(this.senha);

			// Botão enviar
			driver.findElement(By.xpath("//*[@id=\"frmlogin\"]/div[3]/button")).click();

		} catch (ElementNotInteractableException ex) {
			System.out.println("Erro de Validação: " + ex);
		}
	}

	@Test
	public void loginComFacebook() {
		abreUrls();

		// Seleciona div acessar conta
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btn-login\"]")));
		driver.findElement(By.xpath("#frmlogin > div:nth-child(7) > a")).click();

		// Botão enviar
		driver.findElement(By.xpath("//*[@id=\"frmlogin\"]/div[7]/a")).click();
	}

}
