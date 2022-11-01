package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

public class BankGuruPageGeneratorManager {

	public static BankGuruHomePO getBankGuruHomePage(WebDriver driver) {
		return new BankGuruHomePO(driver);
	}

	public static BankGuruLoginPO getBankGuruLoginPage(WebDriver driver) {
		return new BankGuruLoginPO(driver);
	}

	public static BankGuruRegisterPO getBankGuruRegisterPage(WebDriver driver) {
		return new BankGuruRegisterPO(driver);
	}

	public static BankGuruNewCustomerPO getBankGuruNewCustomerPage(WebDriver driver) {
		return new BankGuruNewCustomerPO(driver);
	}

	public static BankGuruEditCustomerPO getBankGuruEditCustomerPage(WebDriver driver) {
		return new BankGuruEditCustomerPO(driver);
	}

	public static BankGuruDeleteCustomerPO getBankGuruDeleteCustomerPage(WebDriver driver) {
		return new BankGuruDeleteCustomerPO(driver);
	}

	public static BankGuruNewAccountPO getBankGuruNewAccountPage(WebDriver driver) {
		return new BankGuruNewAccountPO(driver);
	}

	public static BankGuruEditAccountPO getBankGuruEditAccountPage(WebDriver driver) {
		return new BankGuruEditAccountPO(driver);
	}

	public static BankGuruDeleteAccountPO getBankGuruDeleteAccountPage(WebDriver driver) {
		return new BankGuruDeleteAccountPO(driver);
	}

	public static BankGuruDepositPO getBankGuruDepositPage(WebDriver driver) {
		return new BankGuruDepositPO(driver);
	}

	public static BankGuruWithdrawalPO getBankGuruWithdrawalPage(WebDriver driver) {
		return new BankGuruWithdrawalPO(driver);
	}

	public static BankGuruFundTransferPO getBankGuruFundTransferPage(WebDriver driver) {
		return new BankGuruFundTransferPO(driver);
	}

	public static BankGuruBalanceEnquiryPO getBankGuruBalanceEnquiryPage(WebDriver driver) {
		return new BankGuruBalanceEnquiryPO(driver);
	}

}
