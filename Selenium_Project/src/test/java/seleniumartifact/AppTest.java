package seleniumartifact;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
    
public class AppTest
{
	
	WebDriver driver;
	
	
	@Given("^I open the macys site$")
	public void i_open_the_macys_site() throws Throwable {
		System.out.println("welcom");
		
		System.out.println("driver initiated");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenicucumber\\chromedriver_win32\\chromedriver.exe");
	     driver=new ChromeDriver();
 		driver.get("https://www.mcom-121.tbe.zeus.fds.com/");
 		driver.manage().window().maximize();
	}
	
	
	@Given("^I close the popup$")
	public void i_close_the_popup() throws Throwable {
		
		          Thread.sleep(7000);		         
		         driver.findElement(By.xpath("//*[@id='closeButton']")).click(); 
		        	  
	}
	
	@Given("^verify the title of the web page$")
	public void verify_the_title_of_the_web_page() throws Throwable {
	    String Expected_Title="Macy's - Shop Fashion Clothing & Accessories - Official Site - Macys.com";
	    
	    String Actual_Title=driver.getTitle();
	    
	    System.out.println(Actual_Title);
	    
	    assertEquals("not verified", Expected_Title, Actual_Title);   	
		
	}
	
	
	@When("^I click on go to us site$")
	public void i_click_on_go_to_us_site() throws Throwable {
		WebElement e=driver.findElement(By.xpath("//*[@href='javascript:void(0)']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();", e);
	  
	
	}
	

	@When("^I enter the product in search bar$")
	public void i_enter_the_product_in_search_bar(List<String> product) throws Throwable {
	  
	 	     
	  for(int i=0; i<product.size(); i++)
		{
		  WebElement search=driver.findElement(By.xpath("//*[@id='globalSearchInputField']"));
			 search.isDisplayed();		  
		     
			search.sendKeys(product.get(i));
			search.sendKeys(Keys.ENTER);
		
			
		}
	  	  		  
	}
	
	@When("^select the product to bag$")
	public void select_the_product_to_bag() throws Throwable {
		
		List<WebElement> products=driver.findElements(By.xpath("//*[starts-with(@id,'img_')]"));
		System.out.println(products.size());
		products.get(0).click();
		 
   /*WebElement button=driver.findElement(By.xpath("//*[@id='atbIntContinueShopping']"));
   JavascriptExecutor jjs= (JavascriptExecutor)driver;	
   jjs.executeScript("arguments[0].click();", button);*/
}
	
	
	@When("^select the size and number of products$")
	public void select_the_size_and_number_of_products() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='medium-float-children swatches-scroller c-reset']/li[1]")).click();
		driver.findElement(By.xpath("//button[@class='icon-ui-plus-bk-medium']")).click();
			     		
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement b=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[1]/button[contains(@id,'bag-add')]"))));
		b.click();
	}
	
	
	@Then("^do checkout the items$")
	public void do_checkout_the_items() throws Throwable {
	
		Thread.sleep(5000);
		
	WebElement element=driver.findElement(By.xpath("//*[@id='atbIntViewBagAndCheckout']"));
	element.click();
	driver.findElement(By.xpath("//div[@class='buttons-wrapper']/a")).click();
}
	
	
	
	
}

