package com.pack.home.TestExecution;

import java.io.IOException;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pack.home.Libraries.DriverLaunch;
import com.pack.home.Libraries.LibraryForGenericFunction;

public class TestRun {
	DriverLaunch Dlib = new DriverLaunch();
	public static WebDriver driver;	
	LibraryForGenericFunction lib = null;

	@BeforeTest
	public void executing() throws InterruptedException, IOException {
		driver = Dlib.openBrowser("chrome");
		lib = new LibraryForGenericFunction(driver);
		// Application link will be opened
		driver.get("http://marcus.oneeight.co.in/zeno/login");
	}

	@Test(priority = 1, description="Performs an unsuccessful login and checks the resulting error message (passes)")
	public void unsuccessfullogin() throws InterruptedException, IOException {
		lib.jsSendKeysForID("username", "ROL000033", "login", "ID");
		lib.jsSendKeysForID("password", "123456", "login", "ID");
		Assert.assertTrue(lib.waitAndClickForID("login", "login", "ID"));
		Thread.sleep(2000);
		Assert.assertTrue(lib.getText("error", "login", "ID").contains("login fail"));					
	}
	
	@Test(priority = 2, description="Performs an successful login and checks the dashboard url (passes)")
	public void login() throws InterruptedException, IOException {
		lib.jsSendKeysForID("username", "OE-000003", "login", "ID");
		lib.jsSendKeysForID("password", "123456", "login", "ID");
		Assert.assertTrue(lib.waitAndClickForID("login", "login", "ID"));
		Thread.sleep(2000);
		Assert.assertEquals(lib.getCurrentUrl(), "http://marcus.oneeight.co.in/zeno/dashboard");					
	}
	
	@Test(priority = 3, description="Tries to navigate to privacy (passes)")
	public void clickPrivacy() throws InterruptedException, IOException {
		lib.waitAndClickForID("privacylink", "login", "linktext");
	}
	
	@Test(priority = 4, description="Tries to navigate to Terms of services (passes)")
	public void clickTerms() throws InterruptedException, IOException {
		lib.waitAndClickForID("termslink", "login", "linktext");
	}
	
	@Test(priority = 5, description="Tries to navigate to Refund page (passes)")
	public void clickRefund() throws InterruptedException, IOException {
		lib.waitAndClickForID("refundlink", "login", "linktext");
	}
	
	@Test(priority = 6, description="Tries to navigate to Feedback (passes)")
	public void clickfeedback() throws InterruptedException, IOException {
		lib.waitAndClickForID("feedbacklink", "login", "linktext");
	}
	
	@Test(priority = 7, description="Tries to navigate to Contact us (passes)")
	public void clickcontact() throws InterruptedException, IOException {
		lib.waitAndClickForID("contactlink", "login", "linktext");
	}
	
	@Test(priority = 8, description="Tries to navigate to FAQ (passes)")
	public void clickfaq() throws InterruptedException, IOException {
		lib.waitAndClickForID("faqlink", "login", "linktext");
	}
	@Test(priority = 9, description="Tries to navigate to Know your CPE (passes)")
	public void clickknowcpe() throws InterruptedException, IOException {
		lib.waitAndClickForID("knowlink", "login", "linktext");
	}
	
	@Test(priority = 10, description="Tries to navigate to Know your BILL (passes)")
	public void clickknowbill() throws InterruptedException, IOException {
		lib.waitAndClickForID("knowbilllink", "login", "linktext");
	}
	
	@Test(priority = 11,description="Checks for the welcome message (passes)")
	public void verifyWelcomeMesg() throws InterruptedException, IOException {
		Assert.assertEquals(lib.getText("welcomemesg", "dashboard", "class"), "Welcome Saravanan, to your One8 page");			
	}	
	
	@Test(priority = 12, description="Tries to navigate to Make Payment (passes)")
	public void clickPayment() throws InterruptedException, IOException {
		lib.waitAndClickForID("paymentlink", "dashboard", "linktext");
	}
	
	/*@Test(priority = 5, description="Tries to navigate to View Bill (passes)")
	public void clickViewBill() throws InterruptedException, IOException {
		Thread thread=new Thread();
		lib.waitAndClickForID("viewbilllink", "dashboard", "linktext");
		
		thread.stop();
	}*/
	
	@Test(priority = 13, description="Tries to navigate to pay Bill (passes)")
	public void clickPayBill() throws InterruptedException, IOException {
		lib.waitAndClickForID("paybilllink", "dashboard", "linktext");
	}
	
	@Test(priority = 14, description="Tries to navigate to Top up (passes)")
	public void clickTopUp() throws InterruptedException, IOException {
		lib.waitAndClickForID("topuplink", "dashboard", "linktext");
	}
	
	@Test(priority = 15, description="Tries to navigate to Your Plan(passes)")
	public void clickPlan() throws InterruptedException, IOException {
		lib.waitAndClickForID("planlink", "dashboard", "linktext");
	}

	@Test(priority = 16, description="Navigates to Profile page (passes)")
	public void clickProfile() throws InterruptedException, IOException {
		lib.waitAndClickForID("profilelink", "dashboard", "linktext");
	}
	
	@Test(priority = 17, description="Navigates to Service request page (passes)")
	public void clickService() throws InterruptedException, IOException {
		lib.waitAndClickForID("servicelink", "dashboard", "linktext");
	}

	@Test(priority = 18, description="Logs out (passes)")
	public void logout() throws InterruptedException, IOException {
		lib.waitAndClickForID("logoutlink", "dashboard", "linktext");
	}
	
	@AfterTest()
	public void afterMethod() throws IOException {
		driver.quit();		
	}	
}
