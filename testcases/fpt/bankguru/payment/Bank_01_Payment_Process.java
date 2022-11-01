package fpt.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankGuru.BankGuruDeleteCustomerPO;
import pageObjects.bankGuru.BankGuruDepositPO;
import pageObjects.bankGuru.BankGuruEditAccountPO;
import pageObjects.bankGuru.BankGuruEditCustomerPO;
import pageObjects.bankGuru.BankGuruFundTransferPO;
import pageObjects.bankGuru.BankGuruHomePO;
import pageObjects.bankGuru.BankGuruLoginPO;
import pageObjects.bankGuru.BankGuruNewAccountPO;
import pageObjects.bankGuru.BankGuruNewCustomerPO;
import pageObjects.bankGuru.BankGuruPageGeneratorManager;
import pageObjects.bankGuru.BankGuruRegisterPO;
import pageObjects.bankGuru.BankGuruWithdrawalPO;

public class Bank_01_Payment_Process extends BaseTest {
	WebDriver driver;
	BankGuruLoginPO loginPage;
	BankGuruRegisterPO registerPage;
	BankGuruHomePO homePage;
	BankGuruNewCustomerPO newCustomerPage;
	BankGuruEditCustomerPO editCustomerPage;
	BankGuruNewAccountPO newAccountPage;
	BankGuruEditAccountPO editAccountPage;
	BankGuruDepositPO depositPage;
	BankGuruWithdrawalPO withdrawalPage;
	BankGuruFundTransferPO fundTransferPage;
	BankGuruDeleteCustomerPO deleteCustomerPage;

	String email, userID, password, loginPageUrl, customerID, accountTypeSaving, accountTypeCurrent, firstAccountID, secondAccountID;
	String name, gender, dateOfBirth, address, city, state, pin, phone;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriverBankGuru(browserName, appUrl);
		loginPage = BankGuruPageGeneratorManager.getBankGuruLoginPage(driver);
		email = "quanganh.plus" + generateFakeNumber() + "@gmail.com";

		// New Customer
		name = "quanganh trinh";
		gender = "male";
		dateOfBirth = "2022-10-10";
		address = "10 PVB";
		city = "Hanoi";
		state = "company";
		pin = "101010";
		phone = "0977825566";

		// Edit Customer
		editAddress = "10 Pham Van Bach";
		editCity = "Hanoi capital";
		editState = "công ty";
		editPin = "999999";
		editPhone = "0977825568";
		editEmail = "quanganh.trinh" + generateFakeNumber() + "@hotmail.com";

		// New Account
		accountTypeSaving = "Savings";
		accountTypeCurrent = "Current";
	}

	@Test
	public void Payment_01_Register_And_Login() {
		log.info("RegisterAndLogin - Step 01: Get Login Page Url");
		loginPageUrl = loginPage.getLoginPageUrl();

		log.info("RegisterAndLogin - Step 02: Click To 'here' Link");
		registerPage = loginPage.clickToHereLink();

		log.info("RegisterAndLogin - Step 03: Input To EmailID textbox");
		registerPage.inputToEmailIDTextbox(email);

		log.info("RegisterAndLogin - Step 04: Click Submit Button");
		registerPage.clickToSubmitButton();

		log.info("RegisterAndLogin - Step 05: Get UserID value");
		userID = registerPage.getUserIDValue();

		log.info("RegisterAndLogin - Step 06: Get Password value");
		password = registerPage.getPasswordValue();

		log.info("RegisterAndLogin - Step 07: Open Login Page");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		log.info("RegisterAndLogin - Step 08: Input to UserID textbox");
		loginPage.inputToUserIDTextbox(userID);

		log.info("RegisterAndLogin - Step 09: Input to Password textbox");
		loginPage.inputToPasswordTextbox(password);

		log.info("RegisterAndLogin - Step 10: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("RegisterAndLogin - Step 11: Verify Welcome Message Displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());

	}

	@Test
	public void Payment_02_NewCustomer() {
		newCustomerPage = (BankGuruNewCustomerPO) homePage.openPagesBankGuruByName(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicHeaderOrMessageDisplayed(driver, "Add New Customer"));

		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", name);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "dob", dateOfBirth);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", address);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", city);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", state);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", pin);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", phone);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", email);
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "password", password);

		newCustomerPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(newCustomerPage.isDynamicHeaderOrMessageDisplayed(driver, "Customer Registered Successfully!!!"));
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Customer Name"), name);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Address"), address);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "City"), city);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "State"), state);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Mobile No."), phone);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Email"), email);

		customerID = newCustomerPage.getDynamicTextIntoTable(driver, "Customer ID");

	}

	@Test
	public void Payment_03_EditCustomer() {
		editCustomerPage = (BankGuruEditCustomerPO) newCustomerPage.openPagesBankGuruByName(driver, "Edit Customer");
		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplayed(driver, "Edit Customer Form"));

		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);
		editCustomerPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplayed(driver, "Edit Customer"));

		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", editAddress);
		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", editCity);
		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", editState);
		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", editPin);
		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", editPhone);
		editCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", editEmail);

		editCustomerPage.clickToDynamicButton(driver, "Submit");

		// verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplayed(driver, "Customer details updated Successfully!!!"));
		Assert.assertEquals(editCustomerPage.isDynamicHeaderOrMessageDisplayed(driver, "Customer details updated Successfully!!!"), true);

//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Customer Name"), name);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Gender"), gender);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Birthdate"), dateOfBirth);
//
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Address"), editAddress);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "City"), editCity);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "State"), editState);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Pin"), editPin);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Mobile No."), editPhone);
//		verifyEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Email"), editEmail);

		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Customer Name"), name);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Gender"), gender);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Birthdate"), dateOfBirth);

		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Address"), editAddress);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "City"), editCity);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "State"), editState);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Pin"), editPin);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Mobile No."), editPhone);
		Assert.assertEquals(newCustomerPage.getDynamicTextIntoTable(driver, "Email"), editEmail);
	}

	@Test
	public void Payment_04_NewAccount() {
		// Create firstAccountID - Payers
		newAccountPage = (BankGuruNewAccountPO) editCustomerPage.openPagesBankGuruByName(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Add new account form"));

		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);
		newAccountPage.selectDynamicDropdown(driver, "selaccount", accountTypeSaving);
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", "5000");

		newAccountPage.clickToDynamicButton(driver, "submit");

		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Account Generated Successfully!!!"));

		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Customer Name"), name);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Date of Opening"), getCurrentDay());
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Current Amount"), "5000");

		firstAccountID = newAccountPage.getDynamicTextIntoTable(driver, "Account ID");

		// Create secondAccountID - Payees
		newAccountPage = (BankGuruNewAccountPO) newAccountPage.openPagesBankGuruByName(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Add new account form"));

		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);
		newAccountPage.selectDynamicDropdown(driver, "selaccount", accountTypeSaving);
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", "1000");

		newAccountPage.clickToDynamicButton(driver, "submit");

		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Account Generated Successfully!!!"));

		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Customer Name"), name);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Date of Opening"), getCurrentDay());
		verifyEquals(newAccountPage.getDynamicTextIntoTable(driver, "Current Amount"), "1000");

		secondAccountID = newAccountPage.getDynamicTextIntoTable(driver, "Account ID");
	}

	@Test
	public void Payment_05_EditAccount() {

		editAccountPage = (BankGuruEditAccountPO) newAccountPage.openPagesBankGuruByName(driver, "Edit Account");
		verifyTrue(editAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Edit Account Form"));

		editAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", firstAccountID);
		editAccountPage.clickToDynamicButton(driver, "Submit");

		// verifyTrue(editAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Edit Account Entry Form"));
		Assert.assertEquals(editAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Edit Account Entry Form"), true);

		editAccountPage.selectDynamicDropdown(driver, "a_type", accountTypeCurrent);
		editAccountPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(editAccountPage.isDynamicHeaderOrMessageDisplayed(driver, "Account Generated Successfully!!!"));

		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Account ID"), firstAccountID);
		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Customer Name"), name);
		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Email"), editEmail);
		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Account Type"), accountTypeCurrent);
		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Date of Opening"), getCurrentDay());
		verifyEquals(editAccountPage.getDynamicTextIntoTable(driver, "Current Amount"), "5000");

	}

	@Test
	public void Payment_06_DepositToAccount() {

		depositPage = (BankGuruDepositPO) editAccountPage.openPagesBankGuruByName(driver, "Deposit");
		verifyTrue(depositPage.isDynamicHeaderOrMessageDisplayed(driver, "Amount Deposit Form"));

		depositPage.inputToDynamicTextboxOrTextArea(driver, "accountno", firstAccountID);
		depositPage.inputToDynamicTextboxOrTextArea(driver, "ammount", "3000");
		depositPage.inputToDynamicTextboxOrTextArea(driver, "desc", "noptien tk");
		depositPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(depositPage.isDynamicHeaderOrMessageDisplayed(driver, "Transaction details of Deposit for Account " + firstAccountID));

		verifyEquals(depositPage.getDynamicTextIntoTable(driver, "Account No"), firstAccountID);
		verifyEquals(depositPage.getDynamicTextIntoTable(driver, "Amount Credited"), "3000");
		verifyEquals(depositPage.getDynamicTextIntoTable(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getDynamicTextIntoTable(driver, "Description"), "noptien tk");
		verifyEquals(depositPage.getDynamicTextIntoTable(driver, "Current Balance"), "8000");

	}

	@Test
	public void Payment_07_WithdrawalFromAccount() {

		withdrawalPage = (BankGuruWithdrawalPO) depositPage.openPagesBankGuruByName(driver, "Withdrawal");
		verifyTrue(withdrawalPage.isDynamicHeaderOrMessageDisplayed(driver, "Amount Withdrawal Form"));

		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "accountno", firstAccountID);
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "ammount", "2000");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "desc", "ruttien tk");
		withdrawalPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(withdrawalPage.isDynamicHeaderOrMessageDisplayed(driver, "ransaction details of Withdrawal for Account " + firstAccountID));

		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Account No"), firstAccountID);
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Amount Debited"), "2000");
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Description"), "ruttien tk");
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Current Balance"), "6000");

	}

	@Test
	public void Payment_08_TransferToOtherAccount() {

		fundTransferPage = (BankGuruFundTransferPO) withdrawalPage.openPagesBankGuruByName(driver, "Fund Transfer");
		verifyTrue(fundTransferPage.isDynamicHeaderOrMessageDisplayed(driver, "Fund transfer"));

		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", firstAccountID);
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", secondAccountID);
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", "1000");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "desc", "chuyen khoan");
		fundTransferPage.clickToDynamicButton(driver, "Submit");

		verifyTrue(fundTransferPage.isDynamicHeaderOrMessageDisplayed(driver, "Fund Transfer Details"));

		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "From Account Number"), firstAccountID);
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "To Account Number"), secondAccountID);
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Amount"), "1000");
		verifyEquals(withdrawalPage.getDynamicTextIntoTable(driver, "Description"), "chuyen khoan");
	}

	@Test
	public void Payment_09_CheckCurrentAmount() {

	}

	@Test
	public void Payment_10_DeleteAllAccount() {

	}

	@Test
	public void Payment_11_DeleteCustomer() {

	}

	@Test
	public void Payment_12_LogoutToSystem() {
		loginPage = deleteCustomerPage.clickToLogoutLink();
		// verify login page displayed
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
