package POMpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPagePOM {
	
	public WebDriver driver;
	
	By clickProfile = By.xpath("//span[text()='Vivek']");
	//By clickAbout = By.xpath("//span[text()='About']");
	By name = By.xpath("//h1[@class='gmql0nx0 l94mrbxd p1ri9a11 lzcic4wl']");
	
	public LandingPagePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getClickP() {
		return driver.findElement(clickProfile);
	}
	
//	public WebElement getClickAb() {
//		return driver.findElement(clickAbout);
//	}
	
	public WebElement getClikN() {
		return driver.findElement(name);
	}

}
