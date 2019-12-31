package seleniumartifact;

import static org.junit.Assert.assertEquals;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Pottery {
	WebDriver driver;

	@Given("^I open the pottery website$")
	public void I_open_the_pottery_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenicucumber\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.potterybarnkids.com/");
		Thread.sleep(7000);
		WebElement element = driver.findElement(By.xpath("//a[@class='stickyOverlayMinimizeButton' and @title='Minimize']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	@And("^I hover the registry button and click on get started for registration$")
	public void i_hover_the_registry_button_and_click_on_get_started_for_registration() throws Throwable {

		// driver.findElement(By.xpath("//*[@id='nav-user-links']/div[2]/a[1]")).click();
		WebElement element = driver.findElement(By.xpath("//*[@id='nav-user-links']/div[2]/a[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='nav-user-links']/div[2]//div[3]/ul/li[2]/a")).click();

	}

	@And("^I enter the below details for creating a account$")
	public void i_enter_the_below_details_for_creating_a_account(DataTable dt) throws Throwable {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {

			driver.findElement(By.xpath("//input[@id='profile.fullName']")).sendKeys(list.get(i).get("full name"));
			driver.findElement(By.xpath("//input[@id='profile.email']")).sendKeys(list.get(i).get("email"));
			driver.findElement(By.xpath("//input[@id='profile.confirmEmail']"))
					.sendKeys(list.get(i).get("confirm email"));
			driver.findElement(By.xpath("//input[@id='profile.password']")).sendKeys(list.get(i).get("password"));
			driver.findElement(By.xpath("//input[@id='profile.confirmPassword']"))
					.sendKeys(list.get(i).get("confirm password"));

		}
	}

	@Then("^click on submit and account is created$")
	public void click_on_submit_and_account_is_created() throws Throwable {

		driver.findElement(By.xpath("//*[@id='create-password']/button")).click();

	}

	@And("^I click on logout$")
	public void I_click_on_logout() throws Throwable {

		WebElement element = driver.findElement(By.xpath("//*[@id='signOut']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	@And("^I login the website with below credintials$")
	public void I_login_the_website_with_below_credintials(DataTable dt) throws Throwable {

		WebElement element = driver.findElement(By.xpath("//*[@class='user-account-link']"));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@title='Sign In']")).click();
		Thread.sleep(2000);
		List<String> list = dt.asList(String.class);
		driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys(list.get(0));
		driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys(list.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='button-group']//*[@id='btn-sign-in']")).click();

	}

	
	@And("^I validate the loggedIn page$")
	public void I_validate_the_loggedIn_page() throws Throwable {

		String expectedtext = driver.findElement(By.xpath("//*[@class='user-account-link']")).getText();
		System.out.println(expectedtext);
		assertTrue("invalid message", expectedtext.equalsIgnoreCase("LAKSHMI'S ACCOUNT"));
		driver.findElement(By.xpath("//*[@class='user-account-link']")).click();

	}

	@And("^I click on Account setting$")
	public void I_click_on_Account_setting() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='side-nav-menu']/li[3]/a")).click();

		/*
		 * boolean b=driver.findElement(By.
		 * xpath("//p[@class='pull-left account-update account-name']/span[2]")).
		 * isDisplayed(); System.out.println(b);
		 */
		assertTrue("not displayed", driver
				.findElement(By.xpath("//p[@class='pull-left account-update account-name']/span[2]")).isDisplayed());
		assertTrue("not displayed", driver
				.findElement(By.xpath("//p[@class='pull-left account-update account-email']/span[2]")).isDisplayed());
		assertTrue("not displayed",
				driver.findElement(By.xpath("//p[@class='pull-left account-update account-password']/span[2]"))
						.isDisplayed());

	}

	@And("^I edit the display name and verify it$")
	public void i_edit_the_display_name_and_verify_it(DataTable dt) throws Throwable {

		driver.findElement(By.xpath("//*[@class='simple-container float-container']//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fullName']")).clear();

		List<String> list = dt.asList(String.class);
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys(list.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='button-group']/button")).click();
		Thread.sleep(2000);
		// String
		// Expected=driver.findElement(By.xpath("//input[@id='fullName']")).getText();
		String Expected = "mars";
		System.out.println(Expected);

		String Actual = driver.findElement(By.xpath("//p[@class='pull-left account-update account-name']/span[2]"))
				.getText();
		System.out.println(Actual);
		assertTrue("mismatching", Expected.equals(Actual));

	}

	@And("^I edit the email address and verify it$")
	public void i_edit_the_email_address_and_verify_it(DataTable dt) throws Throwable {

		driver.findElement(By.xpath("//*[@class='pull-left account-update account-email']/following::a[1]")).click();
		Thread.sleep(2000);

		List<String> list = dt.asList(String.class);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(list.get(0));
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(list.get(1));
		driver.findElement(By.xpath("//*[@id='confirmEmail']")).sendKeys(list.get(2));

		driver.findElement(By.xpath("//*[@class='button-group']/button")).click();
		driver.findElement(By.xpath("//*[@class='button-group']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='side-nav-menu']/li[3]/a")).click();
		Thread.sleep(2000);
		// String
		// Expected=driver.findElement(By.xpath("//*[@id='confirmEmail']")).getText();
		String Expected = "lakshmi.kg@gmail.com";
		System.out.println(Expected);

		String Actual = driver.findElement(By.xpath("//p[@class='pull-left account-update account-email']/span[2]"))
				.getText();
		System.out.println(Actual);
		assertTrue("mismatching", Expected.equals(Actual));
	}

	@And("^I click on Address Book$")
	public void i_click_on_Address_Book() throws Throwable {
		driver.findElement(By.xpath("//*[@class='side-nav-menu']/li[4]/a")).click();

	}

	@And("^I click on add Address Book$")
	public void i_click_on_add_Address_Book() throws Throwable {
		driver.findElement(By.xpath("//*[@class='btn btn-primary add-new-address']")).click();
	}

	@And("^I enter the below details in address book$")
	public void I_enter_the_below_details_in_address_book(DataTable dt) throws Throwable {

		Thread.sleep(2000);
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {

			driver.findElement(By.xpath("//*[@id='address.fullName']")).sendKeys(list.get(i).get("full name"));
			driver.findElement(By.xpath("//*[@id='address.addrLine1']")).sendKeys(list.get(i).get("address"));
			driver.findElement(By.xpath("//*[@id='address.city']")).sendKeys(list.get(i).get("city"));
			driver.findElement(By.xpath("//*[@id='address.zip']")).sendKeys(list.get(i).get("zip code"));
			driver.findElement(By.xpath("//*[@id='address.dayPhone']")).sendKeys(list.get(i).get("phone number"));

		}

		Select s = new Select(driver.findElement(By.xpath("//*[@id='address.state']")));
		List<WebElement> list2 = s.getOptions();
		for (int i = 0; i < list2.size(); i++) {
			String value = list2.get(i).getText();
			System.out.println(value);
			if (value.equalsIgnoreCase("illinois")) {

				s.selectByIndex(i);
				break;
			}
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='btn-mod-address']")).click();
	}

	@And("^set address as default for shipping and billing in address page$")
	public void set_address_as_default_for_shipping_and_billing_in_address_page() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Set as Default']")).click();
		Thread.sleep(2000);

		String parent = driver.getWindowHandle();
		for (String child : driver.getWindowHandles()) {
			driver.switchTo().window(child);

			driver.findElement(By.xpath("//*[@class='big-checkbox-label']/*[@id='isDefaultShipping']")).click();
			driver.findElement(By.xpath("//*[@class='big-checkbox-label']/*[@id='isDefaultBilling']")).click();

			driver.findElement(By.xpath("//*[@class='button-group']/button[1]")).click();
		}

		driver.switchTo().window(parent);

	}

	@And("^I update the address in address page$")
	public void I_update_the_address_in_address_page() throws Throwable {

		driver.findElement(By.xpath("//*[text()='Edit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='address.fullName']")).clear();
		driver.findElement(By.xpath("//*[@id='address.fullName']")).sendKeys("Johnn");
		driver.findElement(By.xpath("//*[@id='btn-mod-address']")).click();
	}

	@And("^I add multiple addresses in address page$")
	public void I_add_multiple_addresses_in_address_page(DataTable dt) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary add-new-address']")).click();
		Thread.sleep(2000);
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {

			driver.findElement(By.xpath("//*[@id='address.fullName']")).sendKeys(list.get(i).get("full name"));
			driver.findElement(By.xpath("//*[@id='address.addrLine1']")).sendKeys(list.get(i).get("address"));
			driver.findElement(By.xpath("//*[@id='address.city']")).sendKeys(list.get(i).get("city"));
			driver.findElement(By.xpath("//*[@id='address.zip']")).sendKeys(list.get(i).get("zip code"));
			driver.findElement(By.xpath("//*[@id='address.dayPhone']")).sendKeys(list.get(i).get("phone number"));

		}

	}

	@Given("^select the \"([^\"]*)\" and submit in address page$")
	public void select_the_and_submit_in_address_page(String option) throws Throwable {

		Select s = new Select(driver.findElement(By.xpath("//*[@id='address.state']")));
		List<WebElement> list = s.getOptions();
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i).getText();
			System.out.println(value);

			if (value.equalsIgnoreCase(option)) {

				s.selectByIndex(i);
				break;
			}

			/*
			 * switch (value) { case "Illinois": s.selectByIndex(i); break;
			 * 
			 * default: break; }
			 */

		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='btn-mod-address']")).click();
		Thread.sleep(5000);
		// driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@class='checkbox-set avs-override-checkbox']")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btn-mod-address']")));
		driver.findElement(By.xpath("//*[@id='btn-mod-address']")).click();
		Thread.sleep(2000);

	}

	@And("^I remove any address from address page$")
	public void I_remove_any_address_from_address_page() throws Throwable {
		driver.findElement(By.xpath("//*[@class='button-group addressbook-button-group']/a[2]")).click();

		String parent = driver.getWindowHandle();
		for (String child : driver.getWindowHandles()) {
			driver.switchTo().window(child);
			Thread.sleep(5000);

			driver.findElement(By.xpath("//*[@class='button-group']/button[1]")).click();
		}

		driver.switchTo().window(parent);
		/*
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@class='button-group']/button[1]")).click();
		 */
	}
}
