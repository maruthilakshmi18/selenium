package seleniumartifact;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Amazon {
	
	WebDriver driver;
	
	
	@Given("^I open the Amazon site$")
	public void i_open_the_Amazon_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver","D:\\Selenicucumber\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get("https://www.amazon.com/");
	   /* WebElement e=driver.findElement(By.xpath("//*[@id='nav-main']//div[3]/span[1]"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", e);
	   // driver.findElement(By.xpath("//*[@id='nav-main']//div[3]/span[1]")).click();
*/	    Thread.sleep(7000);
	}
	
	@And("^I enter username and password to login$")
	public void i_enter_username_and_password_to_login() throws Throwable {
		
		/*WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));*/
		 Actions a=new Actions(driver);
	    WebElement e=driver.findElement(By.id("nav-link-accountList"));
	    a.moveToElement(e).perform();
	    WebElement e1=driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span[text()='Sign in']"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", e1);
	    
	   // driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span[text()='Sign in']")).click();
	    
	    driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("maruthilakshmi123@gmail.com");
	    driver.findElement(By.className("a-button-input")).click();
	    driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Password@1");
	    driver.findElement(By.className("a-button-input")).click();
	   // driver.findElement(By.xpath("//input[@id='continue']")).click();
	    	}	
	
	
	@And("^I hover the shop by category and click on Computers$")
	public void i_hover_the_shop_by_category_and_click_on_Computers() throws Throwable {
		Actions a=new Actions(driver);
	    WebElement e=driver.findElement(By.xpath("//a[@id='nav-link-shopall']//span[@class='nav-icon nav-arrow']"));
	    a.moveToElement(e).perform();	
	    
	    driver.findElement(By.xpath("//span[@class='nav-text' and text()='Computers']")).click();
	  
	}
	

	@And("^select the item in computers and add to cart$")
	public void select_the_item_in_computers_and_add_to_cart() throws Throwable {
	   /* List<WebElement> list=driver.findElements(By.xpath("//div[@class='a-row']"));
	    list.get(0).click();*/
		
		driver.findElement(By.xpath("//div[@class='a-row']//following-sibling::div")).click();
		driver.findElement(By.xpath("//img[contains(@alt, 'Samsung')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	}
	
	
	@And("^I click proceed to checkout$")
	public void I_click_proceed_to_checkout() throws Throwable {
		//driver.switchTo().frame("checkoutPrefetch");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='attach-sidesheet-checkout-button']/span/input")));
		WebElement e=driver.findElement(By.xpath("//*[@id='attach-sidesheet-checkout-button']/span/input"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", e);
		
		//driver.findElement(By.xpath("//input[@name='proceedToCheckout']")).click();
			}
	
	@And("^I enter shipping address$")
	public void I_enter_shipping_address() throws Throwable {
		driver.findElement(By.xpath("//input[@id='enterAddressAddressLine1']")).sendKeys("3747 N KIMBALL AVE");
		driver.findElement(By.xpath("//input[@id='enterAddressCity']")).sendKeys("CHICAGO");
		driver.findElement(By.xpath("//input[@id='enterAddressStateOrRegion']")).sendKeys("IL");
		driver.findElement(By.xpath("//input[@id='enterAddressPostalCode']")).sendKeys("60618");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}
	@And("^I click on proceed to checkout$")
	public void I_click_on_proceed_to_checkout() throws Throwable {
	
	driver.findElement(By.xpath("//*[@name='proceedToCheckout']")).click();
	driver.findElement(By.xpath("//input[@id='enterAddressAddressLine1']")).sendKeys("3747 N KIMBALL AVE");
	driver.findElement(By.xpath("//input[@id='enterAddressCity']")).sendKeys("CHICAGO");
	driver.findElement(By.xpath("//input[@id='enterAddressStateOrRegion']")).sendKeys("IL");
	driver.findElement(By.xpath("//input[@id='enterAddressPostalCode']")).sendKeys("60618");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	
	
	@Given("^I change the shipping address$")
	public void i_change_the_shipping_address() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.linkText("Change quantities or delete")).click();
		driver.findElement(By.xpath("//input[@name='editAddress']")).click();
		driver.findElement(By.xpath("//div[@class='a-span6 a-column']/div/span")).click();
		driver.findElement(By.xpath("//input[@id='enterAddressStateOrRegion']")).clear();
		driver.findElement(By.xpath("//input[@id='enterAddressStateOrRegion']")).sendKeys("CO");
		driver.findElement(By.xpath("//span[@class='a-button-text']")).click();
		
	}
		
	
	@And("^I delete the address and add new addres$")
	public void I_delete_the_address_and_add_new_addres() throws Throwable {
	//driver.findElement(By.linkText("Change quantities or delete")).click();
		driver.findElement(By.xpath("//a[@class='a-button-text']")).click();
		//driver.findElement(By.xpath("//input[@name='editAddress']")).click();
	//driver.findElement(By.xpath("//a[@class='a-button-text']")).click();
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='enterAddressAddressLine1']")));
	driver.findElement(By.xpath("//input[@name='enterAddressAddressLine1']")).sendKeys("3747 N KIMBALL AVE");
	driver.findElement(By.xpath("//input[@id='enterAddressCity']")).sendKeys("CHICAGO");
	driver.findElement(By.xpath("//input[@id='enterAddressStateOrRegion']")).sendKeys("IL");
	driver.findElement(By.xpath("//input[@id='enterAddressPostalCode']")).sendKeys("60618");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
}
	
	@And("^I click on continue button$")
	public void i_click_on_continue_button() throws Throwable {
		Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='shippingOptionFormId']//div[2]//span[1]/span/input")).click();
	}
	
	@When("^I enter credit card details$")
	public void i_enter_credit_card_details() throws Throwable {
		Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='a-section a-spacing-none pmts-inline-field-block']//input")).sendKeys("nagag");
	driver.findElement(By.xpath("//div[@class='a-section a-spacing-none apx-add-credit-card-number']//input")).sendKeys("371449635311004");
	Thread.sleep(5000);

	WebElement yeardropdwn=driver.findElement(By.xpath("//label[text()='Expiration date']/following-sibling::span[3]"));
	yeardropdwn.click();
	
	driver.findElement(By.xpath("//a[text()='2025']")).click();
	
/*	
	Select s=new Select(yeardropdwn);
	List <WebElement> list=s.getOptions();
	
	
//	/*yeardropdwn.click();
//	
//
//	
// List <WebElement> list=driver.findElements(By.xpath("//label[text()='Expiration date']/following-sibling::span[3]"));
//	System.out.println(list.size());
//	
//	for(int i=0;i<list.size();i++){
//				
//		if(list.get(i).equals("2025"))
//					{
//			System.out.println(list.get(i));
//					list.get(i).click();	
//					}
//			
//	} 
		for (WebElement year : list) {
		
		if(year.getText().equals("2025")){
			year.click();
			break;
			}
		
	}

	//driver.findElement(By.xpath("//div[4]/div/span[3]//span[@class='a-dropdown-prompt']")).sendKeys("2015");
*/	
	
	driver.findElement(By.xpath("//input[@name='ppw-widgetEvent:AddCreditCardEvent']")).click();
	
	
}
	
	@When("^I Select the product and add it to cart$")
		public void I_Select_the_product_and_add_it_to_cart() throws Throwable {
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung 128GB");
		driver.findElement(By.xpath("//img[contains(@alt,'Samsung 128GB')]")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//driver.findElement(By.xpath("//img[@class='hud-dashboard-card-v2-image']")).click();
		//driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(1000);
		/*WebElement e=driver.findElement(By.xpath("//*[@id='attachSiNoCoverage']/span"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", e);*/
	
		
	}
	
	@And("^I click continue button$")
	public void I_click_continue_button() throws Throwable {
	driver.findElement(By.xpath("//*[@class='a-box-inner']/span[1]//span[text()='Continue']")).click();
	}
	
	
	@And("^I click on use this address$")
	public void I_click_on_use_this_address() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id='newShippingAddressFormFromIdentity']//div[2]//span/input")).click();
		driver.findElement(By.xpath("//input[@id='enterAddressAddressLine1']")).sendKeys("3747 N KIMBALL AVE");
		driver.findElement(By.xpath("//input[@id='enterAddressCity']")).sendKeys("CHICAGO");
		driver.findElement(By.xpath("//input[@id='enterAddressStateOrRegion']")).sendKeys("IL");
		driver.findElement(By.xpath("//input[@id='enterAddressPostalCode']")).sendKeys("60618");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
}
	
	@Then("^I did Place an order$") 
	public void I_did_Place_an_order() throws Throwable {
		driver.findElement(By.xpath("//input[@name='placeYourOrder1']")).click();
}
}
