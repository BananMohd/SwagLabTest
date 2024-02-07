package OtherTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PrintItemsName {


	WebDriver driver = new ChromeDriver();

	
	String TheCorrectUserName = "standard_user";
	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";
	
	
	@BeforeTest
	public void preTest() {
		driver.manage().window().maximize();

	}

	
	@Test(enabled = true, priority = 1)
	public void TestLogin_HappyScenario() {
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);
		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();
	}

	




	@Test(priority = 3, enabled = true)
	public void PrintItemsNamesAll()  {

			
			List<WebElement> Items_Names = driver.findElements(By.className("inventory_item_name"));
			
			for(int i = 0 ; i < Items_Names.size();i++) {
				
				System.out.println(	Items_Names.get(i).getText());
			}
	}

}
