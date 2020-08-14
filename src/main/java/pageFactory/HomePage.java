package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase{
	/**
	 * Pagefactory SignInPage Constructor - 
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * WebElements Repository
	 */
	@FindBy(xpath="//div[@class='cartIcon']//img")
	WebElement myCart;
	
	@FindBy(xpath="//div[contains(@class,'numArea')]//span[contains(@class,'')][contains(text(),'0')]")
	WebElement mycartitemquantity;
	
	@FindBy(xpath="//div[contains(text(),'Hi Manish')]")
	WebElement userNameLabel;
		
	@FindBy(xpath="//input[@id='search_input']")
	WebElement searchInput;
	
	@FindBy(xpath="//button[@class='topsearchsubmit SearchBtn']//img")
	WebElement searchBtn;
	

	/**
	 * Verification methods
	 * @return 
	 */
	public String validateHomePageTitle() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	
	public String correctUserName() {
		//boolean username = userNameLabel.isDisplayed();
		String username = userNameLabel.getText();
		return username;
	}
	
	public String validatecartQuantity() {
		String quantityItem = mycartitemquantity.getText();
		//System.out.println(quantityItem);
		return quantityItem;
	}
	/**
	 * Action links on homePage
	 * @return 
	 */
	public String searchInputItem(String itemName) {
		searchInput.sendKeys(itemName);
		return itemName;
	}
	
	public WebElement searchButton() {
		return searchBtn;
	}
	
	public WebElement myCart() {
		return myCart;
	}



}
