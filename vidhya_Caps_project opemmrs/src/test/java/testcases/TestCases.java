
package testcases;

import java.io.IOException;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Browser.Bases;
import HomePage.Capture_Vitals;
import LoginPage.Login1;
import Schedule_Operation.Schedule_Appointment;

public class TestCases extends Bases{
		public Login1 lp;

		public TestCases () throws IOException {
		super();
		
		lp=new Login1();
		}
		
		@BeforeSuite
		public void Launching_Browser()
		{
		initialisation();
		}
		@BeforeMethod
		public void BeforeTest() throws IOException {
		lp=new Login1();
		PageFactory.initElements(driver,Schedule_Appointment.class);
		PageFactory.initElements(driver,Capture_Vitals.class);
		}
		@Test
		public void Sign_in() throws Exception {
		lp.signin("Admin","Admin123");


		}

		@Test(dependsOnMethods = "Sign_in")
		public void HomePage() {
		String lable=Schedule_Appointment.lable.getText();
		String Expect="Logged in as Super User (admin) at Inpatient Ward.";

		Assert.assertEquals(lable, Expect);
		System.out.println("The Lable is :"+lable);

		}

		@Test(dependsOnMethods = "HomePage")
		public void AppointmentScheduling() throws InterruptedException
		{
		Schedule_Appointment.Appointment.click();

		Schedule_Appointment.Manageservicetype.click(); Schedule_Appointment.Delete.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Schedule_Appointment.NO);
		}

		@Test
		(dependsOnMethods = "AppointmentScheduling")
		public void CaptureVitals()
		{ 
			driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
			Capture_Vitals.CaptureTab.click();
			Capture_Vitals.SearchTab.sendKeys("1002KL"+Keys.ENTER);
			String Name=Capture_Vitals.patienttab.getText();
			System.out.println(Name);
			String Expected="Patient ID 1002KL";
			Assert.assertEquals(Name, Expected);
		}
		}



