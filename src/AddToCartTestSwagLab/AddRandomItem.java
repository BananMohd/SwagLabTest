package AddToCartTestSwagLab;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomItem {
	WebDriver driver = new ChromeDriver();

	String TheCorrectUserName = "standard_user";

	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";

	@BeforeTest

	public void preTest() {
		driver.manage().window().maximize();

		//driver.navigate().refresh();
		
		
		//int [] mynumbers = {1,2,19,1047,37,3,4,5,6,7,4,22,343};
	}
	
	@Test(priority = 1)
	public void LoginTest() throws InterruptedException{
		
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

		WebElement ThePasswordInput = driver.findElement(By.name("password"));

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);

		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void AddRandomItem2() {
		// first we generate something called object from class Random 	
		Random rand = new Random(); 
	     //int myRandomIndex = rand.nextInt(6); 
		 //number 6 is the number that will not be taken as random so the range is 0-5
		
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		int myRandomIndex = rand.nextInt(AddtoCartButtons.size()); 

		for(int i = 0 ; i < AddtoCartButtons.size();i++) {
			AddtoCartButtons.get(myRandomIndex).click();
		
			
			//example:
			 //int soso = rand.nextInt(18,66);
			 //	System.out.println(soso);
			 //	AddtoCartButtons.get(soso).click();
		}
		
	}
		
		
		
		//to repeat the all test many times
		//invocationCount=5
		@Test(priority = 3,invocationCount = 5, enabled = false)
		public void AddRandomItemRepeat() throws InterruptedException {
            //Login Part:
			driver.get(TheURL);
			WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

			WebElement ThePasswordInput = driver.findElement(By.name("password"));

			WebElement TheLoginButton = driver.findElement(By.name("login-button"));

			TheUserNameInput.sendKeys(TheCorrectUserName);

			ThePasswordInput.sendKeys(TheCorrectPassword);
			TheLoginButton.click();
			
			Thread.sleep(3000);// CAUSE SELENIUM IS VERY FAST

			
			//test part
			Random rand = new Random(); 
			
			List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn_primary"));
			int myRandomIndex = rand.nextInt(AddtoCartButtons.size()); 

			for(int i = 0 ; i < AddtoCartButtons.size();i++) {
				AddtoCartButtons.get(myRandomIndex).click();
			
				
			}
			
		
	}
}