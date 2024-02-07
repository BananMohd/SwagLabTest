package AddToCartTestSwagLab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSpecifcITem {
	WebDriver driver = new ChromeDriver();

	String TheCorrectUserName = "standard_user";
	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";

	@BeforeTest

	public void preTest() {
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void LoginTest() {

		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);
		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();

	}

	//A. by index= by class
	//1.based on index
	@Test(priority = 2, enabled = false)
	public void AddspecifcItemBasedOnTheIndex() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));

			// first item
			AddtoCartButtons.get(0).click();

			// second item
			AddtoCartButtons.get(1).click();
	}

	//2.Add Odd Index Items = 1,3,5,...
		@Test(priority = 3, enabled = false)
		public void AddOddIndexItems() {
			List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));

			for(int i=0; i<AddtoCartButtons.size(); i=i+2 ) 
			{
				AddtoCartButtons.get(i).click();
			}
				
		}
	
	
	//3.Add Even Index Items = 0,2,4,...
		@Test(priority = 4, enabled = false)
		public void AddEvenNumberItems() {
		
			List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
			
			for(int i = 1 ; i < AddtoCartButtons.size();i+=2) {
				
			AddtoCartButtons.get(i).click();;
			}
		}
		
	//4.
		@Test(priority = 5, enabled = false)
		public void AddAllItemsExceptFifthItem() {
				
					List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
					
					for(int i = 0 ; i < AddtoCartButtons.size();i++) {
						if(i==4) {
							continue;
						}
						
					AddtoCartButtons.get(i).click();;
					}
		}
	
		
	//5.
		@Test(priority = 6, enabled = false)
		public void AddAllItemsExceptItemsAfterFifthItem() {
						
					List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));							
					
					for(int i = 0 ; i < AddtoCartButtons.size();i++) {
								if(i==4) {
									break;
								}
								
							AddtoCartButtons.get(i).click();;
							}
				}
			
		
		
		
		
	/////////////////////////////
	//B.By the name of items...// class name not compound 
	//1. 
	@Test(priority = 7, enabled = false)
	public void AddSpecifcItemBasedOnTheNameOfTheItem() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));// all items must have same class for the name 

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {
				AddtoCartButtons.get(i).click();
			}
		}

	}

	//2.
	@Test(priority = 8,enabled = false)
	public void AddTwoItemsBasedOnTheNames() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")
					|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
				AddtoCartButtons.get(i).click();
			}
		}

	}

	//3.
	@Test(priority = 9,enabled = false)
	public void addAllItemsExceptForOneitemOrTwo() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")
					|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
				continue ; 
			}
			
			AddtoCartButtons.get(i).click();
		}

	}
	
	//4.
	@Test(priority = 10, enabled = false)
	public void addAllItemsExceptOne() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {
				continue ; 
			}
			
			AddtoCartButtons.get(i).click();
		}
	}

	

	//5.
	@Test(priority = 10, enabled =false)
	public void addAllItemsAndStopAtOneItem() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {
				break ; 
			}
			
			AddtoCartButtons.get(i).click();
		}

	
}
	}