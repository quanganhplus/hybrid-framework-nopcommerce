package pageUIs.wordpress.user;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POST_CURRENT_DAY_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']//parent::h2//following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']//ancestor::header//following-sibling::div//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']//parent::h2//following-sibling::div//a[text()='%s']";
	public static final String SEARCH_TEXTBOX = "css=section.widget_search form.search-form input.search-field";
	public static final String SEARCH_BUTTON = "css=section.widget_search form.search-form input.search-submit";
}
