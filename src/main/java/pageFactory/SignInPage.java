package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SignInPage extends TestBase{
	/**
	 * Pagefactory SignInPage Constructor - 
	 */
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * WebElements Repository
	 */
	@FindBy(xpath="//div[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement signIn;
		
	@FindBy(id="username")
	@CacheLookup
	WebElement email;
		
	@FindBy(xpath="//input[@placeholder='************']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@id='id_SignInBtn']")
	@CacheLookup
	WebElement signBtn;
	
	@FindBy(xpath="//p[contains(text(),'Welcome User!')]")
	WebElement signinPageText;
	
	@FindBy(xpath="//div[@class='logo']//a//img")
	WebElement webSiteImage;
	

	/**
	 * Verification methods
	 * @return 
	*/
	public String validateSignInPageTitle() {
		String loginpageTitle = driver.getTitle();
		return loginpageTitle;
	}
	
	public boolean validateSignInPageText() {
		 return signinPageText.isDisplayed();
	}
	public boolean validateWebSiteLogo() {
		return webSiteImage.isDisplayed();
	}
	public WebElement username() {
		return email;
	}
	public WebElement password() {
		return password;
	}
	public WebElement signinbtn() {
		return signBtn;
	}
	/**
	 * Action links on SignIn Page
	 * 
	 */
	public void SignInPageText() {
		myAccount.click();
		signIn.click();
		boolean welcomTitle = signinPageText.isDisplayed();
		System.out.println(welcomTitle);
		
	}
	
	public void signIn(String unm, String psw) {
		myAccount.click();
		signIn.click();
		/**
		 * get data by the config file
		 * 
		 */
		//email.sendKeys(prop.getProperty("username")); 
		//password.sendKeys(prop.getProperty("password"));
		/**
		 * get data by the excel sheet file
		 * 
		 */
		email.sendKeys(unm);
		password.sendKeys(psw);
		signBtn.click();
		
	}

	
	
	
}
