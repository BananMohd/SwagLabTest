package LoginTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver = new ChromeDriver();

	
	String TheCorrectUserName = "standard_user";
	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";
	String TheIncorrectUserName = "lulu";
	String TheIncorrectPassword = "iLoveJava";
	char myFirstLetter = 'M';
	int TheUserNameTwo = 123;
	double myHighest = 173.9;
	boolean iLoveJava = false;
	List<String> myList = new ArrayList<String>();
	
	
	
	@BeforeTest

	public void preTest() {
		driver.manage().window().maximize();

	}

	@Test(enabled = false, priority = 1)
	public void myFirstTest() {
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();

	} 
	
	@Test(enabled = true, priority = 2)
	public void TestLogin_HappyScenario() {
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);
		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();

	}

	
	
	@Test(enabled = false, priority =3)
	public void TestLogin_SadSceanrio() {
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheIncorrectUserName);
		ThePasswordInput.sendKeys(TheIncorrectPassword);
		TheLoginButton.click();

	}

	
	
	
	@AfterTest
	public void postTesting() {
	}

}


