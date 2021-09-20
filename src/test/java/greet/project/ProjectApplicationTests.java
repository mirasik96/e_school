package greet.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

class ProjectApplicationTests {

	WebDriver driver;

	@Test
	public void TestMethod() {
//		//Launch firefox browser
//		System.setProperty("webdriver.gecko.driver", "/Users/sunilkumarpatro/sel/geckodriver");
		driver = new SafariDriver();

		//maximize the browser
//		driver.manage().window().maximize();

		//Implicit wait, wait for at least some time (10 sec) to identify an element, //if can't find the element with in 10

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//open the url or AUT
//		driver.get("http://localhost:8080/login");
		driver.navigate().to("http://localhost:8080/login");

		//Click on the register link:
//		WebElement lnk_register = driver.findElement(By.linkText("sign in"));
//		lnk_register.click();

		//Enter details on the provided text boxes by using sendkeys method.
		WebElement txtBox_firstname = driver.findElement(By.name("user"));
		txtBox_firstname.sendKeys("admin");

		//or directly we can identify element and act on that in one line
		driver.findElement(By.name("password")).sendKeys("admin");
	}

//	public static void main(String[] args) {
//
//// Instantiate a SafariDriver class.
//		WebDriver driver = new SafariDriver();
//// Launch Website
//		driver.navigate().to("http://localhost:8080/login");
//
//// Click on the search text box and send value
//		WebElement txtBox_firstname = driver.findElement(By.name("user"));
//		txtBox_firstname.sendKeys("admin");
//		driver.findElement(By.name("password")).sendKeys("admin");
//
//
//	}

}
