package SeleniumPractice;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddUserPage {
	WebDriver driver;

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a/span")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
	}
	@Test
	public void userpage() {
		ArrayList<String> Totallables = new ArrayList<String>();
		List<WebElement> lables = driver.findElements(By.xpath("//div//label[@class=\"col-sm-3 control-label\"]"));
		for (WebElement wb : lables) {
			String text = wb.getText();
			Totallables.add(text);
		}
		ArrayList<String> actlables = new ArrayList<String>();
		actlables.add("Username");
		actlables.add("Mobile");
		actlables.add("Email");
		actlables.add("Courses");
		actlables.add("Gender");
		actlables.add("State");
		actlables.add("Password");
		actlables.add("Friend Mobile");
		Assert.assertEquals(Totallables, actlables);
	}
	@Test
	public void VerifySideBar() {
		List<WebElement> SideBar = driver.findElements(By.xpath("//h3[@class=\"control-sidebar-heading\"]"));
	    int count = SideBar.size();
	    Assert.assertEquals(count,4);
        }
	@Test
	public void CheckURL() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertEquals(URL,"file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
	}
	@Test
	public void VerifyHeading() {
		String actHeading = driver.findElement(By.xpath("//b[text()='Java By Kiran']")).getText();
		String ExpHeading = "Java By Kiran";
		Assert.assertEquals(actHeading, ExpHeading);
	}
	@Test
	public void VerifySubmitButton() {
		String button = driver.findElement(By.xpath("//button")).getText();
		String Expbutton="Submit";
		Assert.assertEquals(button, Expbutton);
	}
	
	}
