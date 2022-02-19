package LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Browser.Bases;

public class Login1 extends Bases{ 

	
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//input[@id='loginButton']")
		WebElement submitbtn;
		
		@FindBy(xpath="//li[@id='Inpatient Ward']")
		WebElement Session_Location; 
		
		public Login1() throws IOException {
		super(); 
		PageFactory.initElements(driver,this); 
		}
		
		public void signin(String st, String str) throws Exception {
		
		driver.switchTo().activeElement().sendKeys(st);
		password.sendKeys(str);
		Session_Location.click();
		submitbtn.click();


	}

}
