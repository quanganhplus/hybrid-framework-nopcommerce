package pageUIs.bankGuru;

public class BasePageBankGuruUI {

	public static final String DYNAMIC_LINK = "xpath=//ul[@class='menusubnav']//a[text()='%s']";
	public static final String DYNAMIC_HEADER_OR_MESSAGE_DISPLAYED = "xpath=//p[@class='heading3' and text()='%s']";
	public static final String DYNAMIC_TEXTBOX_TEXTAREA = "xpath=(//input | //textarea)[@name='%s']";
	public static final String DYNAMIC_BUTTON = "xpath=//input[@value='%s']";
	public static final String DYNAMIC_TEXT_INTO_TABLE = "xpath=//td[text()='%s']//following-sibling::td";
	public static final String DYNAMIC_DROPDOWN = "xpath=//select[@name='%s']";

}
