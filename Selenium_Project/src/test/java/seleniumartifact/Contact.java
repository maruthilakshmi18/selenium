package seleniumartifact;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Contact {
	
	WebDriver driver;
	
	@Given("^I visit the macys site$")
	public void I_visit_the_macys_site() throws Throwable{
		System.setProperty("webdriver.chrome.driver","D:\\Selenicucumber\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.customerservice-macys.com/app/contact");
		driver.manage().window().maximize();
	}


	@Given("^I verify the addresses in contact page$")
	public void I_verify_the_addresses_in_contact_page() throws Throwable{
		//Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");

		List<WebElement> actual=driver.findElements(By.xpath("//div[@id='rn_Dept']"));		
		for(int i=0; i<actual.size(); i++) {
			System.out.println(actual.get(i).getText());
			assertTrue(actual.get(i).getText(), true);

		}

		/*ArrayList<String> alist=new ArrayList <String>();
		alist.add(list.get(i).getText());
		System.out.println(alist);*/

		List<WebElement>actual1=driver.findElements(By.xpath("//span[@style='font-size:1rem; line-height: 1.25']"));	
		
		System.out.println(actual1);
		for(int i=0; i<actual1.size(); i++) {
			System.out.println(actual1.get(i).getText());
			

			
			/*List<String> expected=Arrays.asList("Macys.com Customer Service","Macys.com International Customer Service","Credit Customer Service","Furniture & Mattress Customer Service","Furniture & Mattress Sales","Wedding & Gift Registry","Store Hours");

			LinkedList<String> expected3= new LinkedList<String>();
			expected3.addAll(expected);
			boolean isEqual= actual1.get(i).getText().equals(expected3);
			System.out.println(isEqual);*/


		}
	}
		
		@And("^I verify the chat functionality$")
		public void I_verify_the_chat_functionality() throws Throwable{
			
			driver.findElement(By.xpath("//div[@id='rn_ChatButton']")).click();
			Thread.sleep(5000);
			String ParentWindowhandle =driver.getWindowHandle();
			
			/*Set<String>windowss=driver.getWindowHandles();
			System.out.println(windowss);*/
			for(String handle: driver.getWindowHandles())
			{
				driver.switchTo().window(handle);
				String Title= driver.getTitle();
				System.out.println(Title);
			
				
			}
			
			try {
				driver.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Not closed");
			}
		
			  //---it will close the child window and focused automatically the parent window
			driver.switchTo().window(ParentWindowhandle);
			String title1=driver.getTitle();
			System.out.println(title1);		
				
		}
		
		@And("^I verify the email functionality$")
		public void I_verify_the_email_functionality() throws Throwable{
			
			
			driver.findElement(By.xpath("//a[@class='rn_EmailAside']")).click();
			assertTrue("title is miss matching",driver.getTitle().equals("Macy's Customer Service Site"));
		
}
		

		@And("^I click on browser back button$")
		public void I_click_on_browser_back_button() throws Throwable{
			driver.navigate().back();
			
}
		@And("^I verify the messanger$")
		public void I_verify_the_messanger() throws Throwable{
			driver.findElement(By.xpath("//a[text()='Messenger']")).click();
			String parenthandle=driver.getWindowHandle();
			for(String childhandle : driver.getWindowHandles()){
			
				driver.switchTo().window(childhandle);
				String url=driver.getCurrentUrl();
				System.out.println(url);
			}
			driver.close();
			driver.switchTo().window(parenthandle);
			
			
}
		
		@And("^I verify the twitter$")
		public void I_verify_the_twitter() throws Throwable{
			
				
			driver.findElement(By.xpath("Twitter")).click();
			
			String Parentwindow=driver.getWindowHandle();
			
			for(String childwindow : driver.getWindowHandles()) {
				
				driver.switchTo().window(childwindow);
				String url=driver.getCurrentUrl();
				System.out.println(url);
			}
			driver.close();
			driver.switchTo().window(Parentwindow);
		
}
}



