package testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helperUtility.TestUtil;
import pageFactory.SignInPage;
import testBase.TestBase;

public class SignInPageTest extends TestBase{
	
	public static SignInPage signinpage;
	
	@BeforeMethod
	public void launchURL() throws IOException {
		InitializationDriver();
	}
	
	@Test(priority =1)
	public void signInPageTitleTest() {
		signinpage= new SignInPage();
		String signinpagetitle = signinpage.validateSignInPageTitle();
		System.out.println("Title of the Sign In page --> "+signinpagetitle);
		//Buy Industrial and Business Supplies - MRO Products, Tools, Equipment and more
		Assert.assertEquals(signinpagetitle, "Buy Industrial and Business Supplies - MRO Products, Tools, Equipment and more", "page title is not matched");
	}
	
	@Test(priority =2)
	public void webSiteImageLogoTest() {
		signinpage = new SignInPage();
		boolean flag = signinpage.validateWebSiteLogo();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test(groups={"smoke"})
	public void verifyWelcomeToSignInPageTextTest() {
		signinpage= new SignInPage();
		signinpage.SignInPageText();
		
	}
	
	@DataProvider
	public Object[][] getDataProvider() throws IOException {
		return TestUtil.excelHelper(0);
	}
	@Test(dataProvider="getDataProvider")
	public void signInTest(String unm, String psw) {
		signinpage= new SignInPage();
		//signinpage.signIn(unm, psw);
		signinpage.signIn(unm, psw);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
