package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(id = "register-button")
	private WebElement registerButton;

	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;

	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;

	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;

	@FindBy(id = "Password-error")
	private WebElement paswordErrorMessage;

	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPaswordErrorMessage;

	@FindBy(id = "FirstName")
	private WebElement firstNameTextBox;

	@FindBy(id = "LastName")
	private WebElement lastNameTextBox;

	@FindBy(id = "Email")
	private WebElement emailTextBox;

	@FindBy(id = "Password")
	private WebElement passwordTextBox;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;

	// Page Object/ Action
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFistnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, paswordErrorMessage);
		return getElementText(driver, paswordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPaswordErrorMessage);
		return getElementText(driver, confirmPaswordErrorMessage);
	}

	public void inputToFistnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastName);
	}

	public void inputToEmailTextbox(String emailAdress) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, emailAdress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confirmPassword);
	}

	public String getRegisterSucessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}
}
