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

public class Pgm1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("priyankanilajagi98@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pinkuu@123");
		driver.findElement(By.id("login")).click();
		String prodname = "ZARA COAT 3";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(prodname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']/h3")));
		List<WebElement> cartLists = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match = cartLists.stream().anyMatch(cartList->cartList.getText().equalsIgnoreCase(prodname));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.cssSelector(".action__submit")).click();
		Thread.sleep(1000);
		String confimationPage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confimationPage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
