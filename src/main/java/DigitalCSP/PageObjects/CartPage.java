package DigitalCSP.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DigitalCSP.AbstractionComponents.abstractComponent;

public class CartPage extends abstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector());
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement checkoutButton;
	
	By productsDisplay = By.xpath("//div[@class='cartSection']/h3");
	
	@FindBy(xpath="///div[@class='cartSection']/h3']")
	List<WebElement> cartProducts;
	
	public boolean verifyProductDispley(String productName) {
		waitForElementToAppear(productsDisplay);
		Boolean match = cartProducts.stream().anyMatch(cartList->cartList.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void goToCheckOut() {
		checkoutButton.click();
	}
}
