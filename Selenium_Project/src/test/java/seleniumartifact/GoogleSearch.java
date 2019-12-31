package seleniumartifact;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class GoogleSearch {
	
	  public static Logger log=LogManager.getLogger(GoogleSearch.class.getName());
	WebDriver driver;

	@Given("^I click on the Google link$")
	public void I_click_on_the_Google_search_link() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenicucumber\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		// driver.findElement(By.xpath("//input[@class='gLFyf
		// gsfi']")).sendKeys("nisum");
		log.debug("debugging");
		log.debug("started");
		log.debug("end");
		log.info("logging");
		log.error("unable to loggin");
		log.fatal("not valid");
	}

	@And("^I enter keyword as \"([^\"]*)\" in search bar\\.$")
	public void i_enter_keyword_as_in_search_bar(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(arg1);

	}
	
	@And("^I validate whether selected company is first option from drop down$")
	public void i_validate_whether_selected_company_is_first_option_from_drop_down() throws Throwable {
	   
		WebElement element = driver.findElement(By.className("erkvQe"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));

		List<WebElement> list = element.findElements(By.tagName("li"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			
			String company=list.get(0).getText();
			assertTrue("not first option from drop down",company.equalsIgnoreCase("nisum technologies"));
			break;
		}

		
	}

	@And("^I select the options from the drop down$")
	public void i_select_the_options_from_the_drop_down() throws Throwable {
		/*
		 * List<WebElement> list
		 * =driver.findElements(By.xpath("//ul[@class='erkvQe']"));
		 * System.out.println(list.size()); Thread.sleep(2000); list.get(0).click();
		 * 
		 * 
		 * for(int i=0; i<list.size();i++) {
		 * if(list.get(i).getText().equalsIgnoreCase("Nisum Technologies")) {
		 * list.get(0).click(); }
		 * 
		 * 
		 * }
		 */
		/*
		 * driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.
		 * ARROW_DOWN);
		 * driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.
		 * RETURN);
		 */

		WebElement element = driver.findElement(By.className("erkvQe"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));

		List<WebElement> list = element.findElements(By.tagName("li"));
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().equalsIgnoreCase("nisum technologies")) {
				list.get(i).click();

				break;
			}

		}

	}

	@And("^I click on (\\d+)st link in search options$")
	public void i_click_on_st_link_in_search_options(int arg1) throws Throwable {
		driver.findElement(By.xpath("//h3[contains(text(), 'Nisum: inicio')]")).click();

		String title = driver.getTitle();
		System.out.println(title);
		assertTrue("not valid", title.equalsIgnoreCase("inicio | Nisum"));
	}
	
	

}
