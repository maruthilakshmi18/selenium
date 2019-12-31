package seleniumartifact;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
/*import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DeleteCard {

WebDriver driver;
	
	
	@Given("^I open Amazon site$")
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
	
	@And("^I enter username password to login$")
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
	
	@And("I hover the shop by category and click on your account in header$")
	public void I_hover_the_shop_by_category_and_click_on_your_account_in_header() throws Throwable {
		Actions a=new Actions(driver);
	    WebElement e=driver.findElement(By.xpath("//span[text()='Account & Lists']/span"));
	    a.moveToElement(e).perform();  
	    e.click();
	    Thread.sleep(2000);
	  
	    
	}
	   
	
	@When("^I click on your account in header$")			
		public void I_click_on_your_account_in_header() throws Throwable {
		/*WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Account']")));
		e.click();*/
		//driver.findElement(By.xpath("//span[text()='Your Account']")).click();
	/*WebElement e=driver.findElement(By.xpath("//span[text()='Your Account']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", e);*/
		  Thread.sleep(5000);
}
	  
	   
	/*   @And("^I verified the authentication$")
		public void I_verified_the_authentication() throws Throwable {   
	  
		   driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Password@1");
		    driver.findElement(By.className("a-button-input")).click();
		  
}*/
	   
	   @And("^click on remove icon to delete the card$")
		public void click_on_remove_icon_to_delete_the_card() throws Throwable { 
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//span[text()='ending in 3021']")).click();
		  /*WebElement e=driver.findElement(By.xpath("//*[@id='cpefront-mpo-widget']/div/form//div[2]/div/a/i"));
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("argument[0].click();", e);*/
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//*[@aria-expanded='true']/div[3]//span[@id='a-autoid-1']")).click();
		
		   Thread.sleep(2000);
		  /* WebElement e=driver.findElement(By.xpath("//div[contains(@id,'a-popover-content')]/div//following-sibling::form[2]/div[3]//span[2]"));
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("argument[0].click();", e);*/
		   WebElement remove=driver.findElement(By.xpath("//div[contains(@id,'a-popover-content')]/div//following-sibling::form[2]/div[3]//span[2]"));
		   
		   Actions action=new Actions(driver);
		   action.moveToElement(remove).build().perform();
		   action.moveToElement(remove).click(remove);
		   
		
				
}
	   
}
	   



