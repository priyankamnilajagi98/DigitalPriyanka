package common.utils;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DigitalCSP.PageObjects.CartPage;
import DigitalCSP.PageObjects.LoginPage;
import DigitalCSP.PageObjects.ProductCatalogue;

public class Pgm1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String prodname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		LoginPage loginpage =  new LoginPage(driver);
		loginpage.goTo();
		loginpage.LoginApplication("priyankanilajagi98@gmail.com","Pinkuu@123");
		ProductCatalogue productcatalogue =  new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getproductsList();
									productcatalogue.addProductToCart(prodname);
									productcatalogue.goToCartPage();
		
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductDispley(prodname);
		Assert.assertTrue(match);
		cartPage.goToCheckOut();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.cssSelector(".action__submit")).click();
		Thread.sleep(1000);
		String confimationPage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confimationPage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
