package POMpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePOM {
	
	public WebDriver driver;
	
	By inputUsername = By.xpath("//input[@name='email']");
	By inputPass = By.xpath("//input[@name='pass']");
	By clicklbutton = By.xpath("//button[@name='login']");
	
	public LoginPagePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUser() {
		return driver.findElement(inputUsername);
	}
	
	public WebElement getPass() {
		return driver.findElement(inputPass);
	}
	
	public WebElement getClickbutton() {
		return driver.findElement(clicklbutton);
	}

}
