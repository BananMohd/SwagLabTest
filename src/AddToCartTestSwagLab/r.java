package AddToCartTestSwagLab;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class r {

	

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
		
		@Test(priority = 1, groups = "soso")
		public void LoginTest(){
			
			driver.get(TheURL);
			WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

			WebElement ThePasswordInput = driver.findElement(By.name("password"));

			WebElement TheLoginButton = driver.findElement(By.name("login-button"));

			TheUserNameInput.sendKeys(TheCorrectUserName);

			ThePasswordInput.sendKeys(TheCorrectPassword);
			TheLoginButton.click();
			
		}
		
		@Test(priority = 2,groups = "high severity")
		public void AddRandomItem() {
			// first we generate something called object from class Random 
			
			Random rand = new Random(); 
		
			
			//int soso = rand.nextInt(18,66);
		
			
			List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
			// number 6 is the number that will not be taken as random so the range is 0-5
			int myRandomIndex = rand.nextInt(AddtoCartButtons.size()); 

			for(int i = 0 ; i < AddtoCartButtons.size();i++) {
				AddtoCartButtons.get(myRandomIndex).click();
				//System.out.println(soso);
				//AddtoCartButtons.get(soso).click();
			}
			
			
		}
	}

