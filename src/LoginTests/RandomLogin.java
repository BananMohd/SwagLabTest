package LoginTests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;

public class RandomLogin {

	//assign and declaration
	WebDriver driver = new ChromeDriver(); //this mean open chrome driver ..it will open white page
	String[] UserNames = { "standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user",
			"visual_user" };// static arrays,
	Random rand = new Random();
	
	
	
	
	
	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();

	}
	
	
	
	@Test()
	public void LoginUsingDifferentUserNames() throws InterruptedException {

		System.out.println(rand.nextInt(UserNames.length));// size of array



		driver.get("https://www.saucedemo.com/");//enter the website
		//find element by xpath
		WebElement UserNameInputField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement PasswordInputField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

		//solution 1:
		//UserNameInputField.sendKeys(UserNames[rand.nextInt(UserNames.length)]);
		//Thread.sleep(3000);
		
		 
		//solution 2:
		String theUser = UserNames[rand.nextInt(UserNames.length)];
		String CommonPassword = "secret_sauce";
		
		UserNameInputField.sendKeys(theUser);
		PasswordInputField.sendKeys(CommonPassword);
		LoginButton.click();

		

		//add to cart
		List<WebElement> AddTocartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddTocartButtons.size(); i++) {
			AddTocartButtons.get(i).click();
		}

		
		
		//now the actual test
		int expecteditemAsNumber = AddTocartButtons.size();
        //String expectedItemAsText = Integer.toString(expecteditemAsNumber); 

		String actualitem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		int actualitemAsNumber = Integer.parseInt(actualitem);

		assertEquals(actualitemAsNumber, expecteditemAsNumber);

	}

	
	// homework 
	
	// login to saucedemowebsite and find the amount of the first item + the second one the expected result is 39.98 
}