package OtherTests;





import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindSumofPrices {
	
// Definition
	WebDriver driver = new ChromeDriver();
	String TheURL = "https://www.saucedemo.com/";
	String Thecu = "standard_user";
	String thecp = "secret_sauce";
	
	@BeforeTest
	public void SetUpTest() {
	driver.manage().window().maximize();
	}
	
	
	
	@Test(priority = 1)
	public void LoginTest() {
		driver.get(TheURL);
		
		WebElement TheUserName = driver.findElement(By.name("user-name"));
		TheUserName.sendKeys(Thecu);
		
		WebElement ThePW = driver.findElement(By.name("password"));
		ThePW.sendKeys(thecp);
		
		driver.findElement(By.name("login-button")).click();	
		
	}
	
	// homework 
	
	// 1) login to saucedemowebsite and
	// 2) find the amount of the first item + the second one, the expected result is 39.98 
	
	@Test(priority = 2,enabled = false)
	public void  TotalPriceofFirstAndSecondItems() {

		double ExpectedTotal = 39.98;
	
	List<WebElement> TheItemsPrice = driver.findElements(By.className("inventory_item_price"));
	
	String Price1 = TheItemsPrice.get(0).getText().replace("$","");
	String Price2 = TheItemsPrice.get(1).getText().replace("$","");;
	
	double ActualPrice = Double.parseDouble(Price1) + Double.parseDouble(Price2);
	
	
	System.out.println("The first item price is: "+TheItemsPrice.get(0).getText());
	System.out.println("The first item price is: "+TheItemsPrice.get(1).getText());
	System.out.println("The Actual price of the items is: "+ActualPrice);
	System.out.println("The Expected price of the items is: "+ExpectedTotal);
	
	assertEquals(ActualPrice, ExpectedTotal);
	
	}
	
	
	@Test(priority = 3, enabled = true)
	public void  TotalPriceofFirstAndSecondItemsNEW() {

		double ExpectedTotal = 39.98;
	
	List<WebElement> TheItemsPrice = driver.findElements(By.className("inventory_item_price"));
	
	//double Price1 = Double.parseDouble(TheItemsPrice.get(0).getText().replace("$",""));
	//double Price2 = Double.parseDouble(TheItemsPrice.get(1).getText().replace("$",""));;
	double ActualPrice2 = 0;
	//String [] Price = {Price1, Price2}; 
	//double ActualPrice2 = Double.parseDouble(Price[0])+Double.parseDouble(Price[1]);
	
	for (int i = 0; i < TheItemsPrice.size(); i++) {
		if(i == 0 || i == 1)
			ActualPrice2 += Double.parseDouble(TheItemsPrice.get(i).getText().replace("$",""));
		
	}
	
	
	System.out.println("The first item price is: "+TheItemsPrice.get(0).getText());
	System.out.println("The first item price is: "+TheItemsPrice.get(1).getText());
	System.out.println("The Actual price of the items is: "+ActualPrice2);
	System.out.println("The Expected price of the items is: "+ExpectedTotal);

	assertEquals(ActualPrice2, ExpectedTotal);
	
	
	
	}
	
	
	

	@AfterTest
	public void PostTesting() {}
	
	
}
