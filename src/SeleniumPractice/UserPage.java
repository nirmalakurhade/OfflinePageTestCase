package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserPage {
    WebDriver driver;
    @BeforeTest
    public void Setup() {
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//*[text()='Users']")).click();
    }
    @Test(priority = 1)
    public void CheckColumnTitle() {
    	ArrayList<String>ColumnTitle = new ArrayList<String>();
    	List<WebElement> CTitle = driver.findElements(By.xpath("//th"));
    	for (WebElement wb : CTitle) {
    		String Text = wb.getText();
    		ColumnTitle.add(Text);
    	}
    	ArrayList<String>ExpTitle = new ArrayList<String>();
    	ExpTitle.add("#");
    	ExpTitle.add("Username");
    	ExpTitle.add("Email");
    	ExpTitle.add("Mobile");
    	ExpTitle.add("Course");
    	ExpTitle.add("Gender");
    	ExpTitle.add("State");
    	ExpTitle.add("Action");
    	Assert.assertEquals(ColumnTitle,ExpTitle);
    }
	@Test(priority = 2)
	public void StateSelected() {
		List<WebElement>actState = driver.findElements(By.xpath("//*[text()='Maharashtra']"));
		String Exp = "Maharashtra";
		System.out.println(Exp);
		int count = actState.size();
		Assert.assertEquals(count,2);
	}
	@Test(priority = 4)
	public void VerifyHeading() {
		String act = driver.findElement(By.xpath("//b[text()='Java By Kiran']")).getText();
		String Exp = "Java By Kiran";
		Assert.assertEquals(act,Exp);
	}
	@Test(priority = 5)
	public void AlertHandle() throws Exception {
		driver.findElement(By.linkText("Delete")).click();
		driver.switchTo().alert().getText();
		Thread.sleep(3000);
		String Text = driver.switchTo().alert().getText();
		String ExpText = "You can not delete Default User";
		Assert.assertEquals(Text,ExpText);
		driver.switchTo().alert().accept();
	}
	
	@Test (priority = 6)
	public void ListTitle() {
		String actTitle = driver.findElement(By.xpath("//h3")).getText();
		String ExpTitle = "User List";
		Assert.assertEquals(actTitle, ExpTitle);
	}
	@Test(priority = 7)
	public void GetHomepageUrl() throws Exception {
	 driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();
	 String WindowText = driver.findElement(By.xpath("//*[text()=\"Certified Software Developer\"]")).getText();
	 Thread.sleep(3000);
	 String ExpText = "Certified Software Developer";
	 Assert.assertEquals(WindowText,ExpText);
	}
}
