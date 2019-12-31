package seleniumartifact;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Renorex {

	 WebDriver driver;
	@Given("^I click on signin icon$")
	public void click_on_signin_icon() throws Throwable{
		System.setProperty("webdriver.chrome.driver","D:\\Selenicucumber\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.ranorex.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav rx-header-sticky-main-nav']/li[7]")).click();
	}
	
	@And("^click on register button for registration$")
	public void click_on_register_button_for_registration() throws Throwable{
	
		driver.findElement(By.xpath("//*[@class='rx-header-sticky-category-title']/following::a[2]")).click();
		Thread.sleep(5000);
}
	
	
	@Given("^I entered data into registration form$")
	public void When_I_entered_data_into_registration_form(DataTable dt) throws Throwable{
		
	List<Map<String, String>> list=dt.asMaps(String.class, String.class);
	
			
	for(int i=0; i<list.size(); i++) {
	
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(list.get(i).get("first name"));
	
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(list.get(i).get("last name"));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(list.get(i).get("user name"));
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(list.get(i).get("email"));
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(list.get(i).get("password"));
		
	}
		
		/*driver.findElement(By.xpath("//div[@class='has-feedback form-group terms-checkbox']//input[2]")).click();
		
		driver.findElement(By.xpath("//div[@class='has-feedback form-group marketing-checkbox']//input[2]")).click();*/
			
			
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;	
		js.executeScript("window.scrollBy(0,250)");
		
		driver.findElement(By.xpath("//span[@class='rx-bottom-overlay-close']")).click();
		
		//WebElement e=driver.findElement(By.xpath("//input[@type='checkbox']")); 
		
		JavascriptExecutor js1=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();",e);
		js1.executeScript("window.scrollBy(0, 250)");
		
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=0; i<checkbox.size(); i++) {
		
			checkbox.get(i).click();
			
		}
		
		driver.findElement(By.xpath("//button[@id='the-submit-button']")).click();
	
				
}
	
	
	@Then("^We get thankyou page$")
	public void We_get_thankyou_page() throws Throwable{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you!']")));
		
	String Text="Thank you!";
	String bodytext=driver.findElement(By.xpath("//h1[text()='Thank you!']")).getText();
	
	assertTrue("Text is not found", bodytext.contains(Text));
	
	}
	
	@Then("^click on signin button to login the application$")
	public void click_on_signin_button_to_login_the_application() throws Throwable{
		
		driver.findElement(By.xpath("//*[@class='rx-header-sticky-category-title']/following::a[1]")).click();
	
  }
	
	@When("^I enter username and password in login page$")
	public void I_enter_username_and_password_in_login_page(DataTable dt) throws Throwable{
		
		List<String> list=dt.asList(String.class);
				
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(list.get(0));
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(list.get(1));
	}
	
	@When("^I click the submit button$")
	public void I_click_the_submit_button() throws Throwable{
		
		driver.findElement(By.xpath("//button[@id='the-submit-button']")).click();
		Thread.sleep(2000);
	
   }
	@When ("^click on blog in header$")
	public void click_on_blog_in_header() throws Throwable{
	
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav rx-header-sticky-main-nav']/li[6]")).click();
		Thread.sleep(2000);
	}
	
	@And("^hover the sliding in header and click on arrows$")
	public void hover_the_sliding_in_header_and_click_on_arrows() throws Throwable{
		
		WebElement e=driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a"));
		Actions a= new Actions(driver);
		a.moveToElement(e).perform();
		
	/* List<WebElement> slides=driver.findElements(By.xpath("//div[@class='et-pb-controllers']"));
	 
	 for(int i=0; i<slides.size(); i++)
	 {
		 slides.get(i).click();
	 }*/
		JavascriptExecutor js=(JavascriptExecutor) driver;	
		js.executeScript("window.scrollBy(0,250)");
		
	
		driver.findElement(By.xpath("//span[@class='rx-bottom-overlay-close']")).click();
		
		WebElement e1=driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a"));
		Actions a1= new Actions(driver);
		a1.moveToElement(e1).perform();
		a1.click();
		
		 List<WebElement> slides=driver.findElements(By.xpath("//div[@class='et-pb-slider-arrows']/a"));
		 
		 for(int i=0; i<slides.size(); i++)
		 {
			 slides.get(i).click();
		 }
	 
}
	
}