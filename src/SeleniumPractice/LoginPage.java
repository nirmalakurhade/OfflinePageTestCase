package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	}

	@Test(priority = 1)
	public void cheakUrl() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertEquals(URL, "file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	}

	@Test(priority = 2)
	public void FailLoginPassword() {
		driver.findElement(By.id("password")).sendKeys("03594849");
		driver.findElement(By.xpath("//button")).click();
		String Fail = driver.findElement(By.id("password_error")).getText();
		Assert.assertEquals(Fail, "Please enter password 123456");
		System.out.println(Fail);
	}

	@Test(priority = 3)
	public void FailLoginmail() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("nirmala@gmail.com");
		driver.findElement(By.xpath("//button")).click();
		String Fail = driver.findElement(By.id("email_error")).getText();
		Assert.assertEquals(Fail, "Please enter email as kiran@gmail.com");
		System.out.println(Fail);
	}

	@Test(priority = 4)
	public void Headline() {
		String actText = driver.findElement(By.xpath("//*[text()='Sign in to start your session']")).getText();
		String ExpText = "Sign in to start your session";
		Assert.assertEquals(actText, "Sign in to start your session");
		System.out.println(ExpText);
	}

	@Test(priority = 5)
	public void subtitle() {
		String actTitle = driver.findElement(By.xpath("/html/body/div/div[1]/a/h4")).getText();
		System.out.println("actTilte=" + actTitle);
		Assert.assertEquals(actTitle, "JAVA | SELENIUM | PYTHON");
	}

	@Test(priority = 6)
	public void checkmail() {
		WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		String actplaceholder = emailBox.getAttribute("placeholder");
		String exp = "Email";
		Assert.assertEquals(actplaceholder, exp);

	}

	@Test(priority = 7)
	public void BlankData() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys(" ");
		driver.findElement(By.id("password")).sendKeys(" ");
		String Entermail = driver.findElement(By.id("email_error")).getText();
		Assert.assertEquals(Entermail, "Please enter email as kiran@gmail.com");
	}

	@Test(priority = 8)
	public void VerifyLogo() {
		String actimage = driver.findElement(By.xpath("//img")).getText();
		String exp = "";
		Assert.assertEquals(actimage, exp);
		System.out.println(actimage);
	}

	@Test(priority = 9)
	public void verifyText() {
		String actText = driver.findElement(By.xpath("//*[text()='Java By Kiran']")).getText();
		String ExpText = "Java By Kiran";
		Assert.assertEquals(actText, "Java By Kiran");
		System.out.println(ExpText);
	}

	@Test(priority = 10)
	public void verifyHeadline() {
		String actText = driver.findElement(By.xpath("//*[text() ='JAVA | SELENIUM | PYTHON']")).getText();
		String ExpText = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actText, ExpText);
		System.out.println(ExpText);
	}

	@Test(priority = 11)
	public void Validlogin() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String Login = driver.getCurrentUrl();
		Assert.assertEquals(Login,"file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
	}
}
