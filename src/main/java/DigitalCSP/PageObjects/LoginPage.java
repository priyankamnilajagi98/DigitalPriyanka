package DigitalCSP.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DigitalCSP.AbstractionComponents.abstractComponent;

public class LoginPage extends abstractComponent{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail")).sendKeys("priyankanilajagi98@gmail.com");
	//WebElement userPassword = driver.findElement(By.id("userPassword")).sendKeys("Pinkuu@123");
	//WebElement Login = driver.findElement(By.id("login")).click();
	
	@FindBy(id="userEmail")
	WebElement UserEmail;

	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement Login;
	
	public void LoginApplication(String email,String password) {
		UserEmail.sendKeys(email);
		userPassword.sendKeys(password);
		Login.click();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
