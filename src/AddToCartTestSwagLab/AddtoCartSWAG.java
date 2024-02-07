package AddToCartTestSwagLab;

//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddtoCartSWAG {


	WebDriver driver = new ChromeDriver();

	
	String TheCorrectUserName = "standard_user";
	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";
	String TheIncorrectUserName = "lulu";
	String TheIncorrectPassword = "iLoveJava";
	
	
	
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

	


	@Test(priority = 2, enabled = false)  // solution of homework 1
	public void AddtoCarttheIncorrectWay() {

		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

	}

	@Test(priority = 3, enabled = true)
	public void AddtoCartTest1() throws InterruptedException {

		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		
		System.out.println(AddtoCartButtons.size() + " found in your website");

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			AddtoCartButtons.get(i).click();
			Thread.sleep(2000);//cause selenium is very fast 
		}

	}

}
