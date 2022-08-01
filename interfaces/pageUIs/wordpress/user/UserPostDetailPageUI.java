package pageUIs.wordpress.user;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h1[text()='%s']";
	public static final String POST_CURRENT_DAY_TEXT_BY_POST_TITLE = "xpath=//article//h1[text()='%s']//following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//article//h1[text()='%s']//ancestor::header//following-sibling::div//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "xpath=//article//h1[text()='%s']//following-sibling::div//a[text()='%s']";
}
