package testpages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.HomePage;
import pageFactory.SignInPage;
import testBase.TestBase;

public class HomePageTest extends TestBase{
	public static HomePage homepage;
	public static SignInPage signinpage;
	
	@BeforeMethod
	public void setUpHomePage() throws IOException {
		InitializationDriver();
		signinpage = new SignInPage();
		signinpage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		homepage = new HomePage();
		String homepagetitle = homepage.validateHomePageTitle();
		System.out.println("HomePage Title --> "+homepagetitle);
		Assert.assertEquals(homepagetitle, "Buy Industrial and Business Supplies - MRO Products, Tools, Equipment and more", "Home Page Title is not matched");
	}
	
	@Test(priority = 2)
	public void validateCorrectUserNameTest() {
		homepage = new HomePage();
		String usernametest = homepage.correctUserName();
		System.out.println(usernametest);
		Assert.assertEquals(usernametest, "Hi Manish", "Username Text is not matched");
	}
	
	@Test(priority=3)
	public void validateCartItemQuantityTest() {
		homepage = new HomePage();
		String cartItemQuantity = homepage.validatecartQuantity();
		System.out.println("Initially Number of Items in cart --> "+cartItemQuantity);
		Assert.assertEquals(cartItemQuantity, "0", "Number of items in cart is not matched");
	}
	
	@Test(groups={"smoke"})
	public void searchItemTest() {
		homepage = new HomePage();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('search_input').value='office chairs'");
		//homepage.searchInputItem("Office chairs");
		homepage.searchButton().click();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}