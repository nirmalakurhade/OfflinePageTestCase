package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dashboard {
     WebDriver driver;
     
     @BeforeTest
     public void Setup() {
    	 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    	 driver = new ChromeDriver();
    	 driver.get("file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
    	 driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
    	 driver.findElement(By.id("password")).sendKeys("123456");
    	 driver.findElement(By.xpath("//button")).click();
    	 }
     @Test(priority = 1)
     public void TotalinnerBox() {
     	 List<WebElement> Boxlist = driver.findElements(By.xpath("//div[@class=\"inner\"]"));
     	 int Boxcount = Boxlist.size();
     	 Assert.assertEquals(Boxcount, 4);
       }
     @Test(priority = 2)
     public void DashboardPage() {
    	 String login = driver.findElement(By.xpath("//*[text()='Java By Kiran']")).getText();
    	 String Exp ="Java By Kiran";
    	 Assert.assertEquals(login,Exp);
     }
     @Test(priority = 3)
     public void TotalCourses() {
    	 ArrayList<String>actCourses = new ArrayList<String>();
    	 actCourses.add("Selenium");
    	 actCourses.add("Java / J2EE");
    	 actCourses.add("Python");
    	 actCourses.add("Php");
    	 
    	 ArrayList<String>ExpCourses = new ArrayList<String>();
    	 List<WebElement> list = driver.findElements(By.xpath("//h3"));
    	 for(WebElement wb : list) {
    		String text = wb.getText();
    		ExpCourses.add(text);
    	 }
    	 Assert.assertEquals(actCourses,ExpCourses);
     }
     @Test(priority = 4)
    public void TotalMoreInfoLink() {
    	 List<WebElement> list = driver.findElements(By.xpath("//*[@class='small-box-footer']"));
    	 int count = list.size();
    	 Assert.assertEquals(count, 4);
     }
     @Test(priority = 6)
 	public void WindowHandeling() throws Exception {
 		String mainwin = driver.getWindowHandle();
 		List<WebElement> links = driver.findElements(By.partialLinkText("info"));

 		for (WebElement link : links)
 			link.click();
 		Thread.sleep(5000);
 		Set<String> allwins = driver.getWindowHandles();
 		for (String window : allwins) {
 			System.out.println("id or handle of window: " + window);

 			driver.switchTo().window(window);
 			System.out.println(" title of child window : " + driver.getTitle());
 			System.out.println(driver.getCurrentUrl());
 			
 			if (!window.equals(mainwin));
 			driver.switchTo().window(mainwin);
 			String act = driver.findElement(By.xpath("//b[text()='Java By Kiran']")).getText();
 			String Exp = "Java By Kiran";
 			Assert.assertEquals(act,Exp);
  		}
     }
     @Test (priority = 5)
     public void NoOfIcons() {
    	 List<WebElement> TotalIcons= driver.findElements(By.xpath("//div[@class=\"icon\"]"));
    	 int IconCount = TotalIcons.size();
    	 Assert.assertEquals(IconCount,4);
     }
    
}