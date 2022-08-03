package pageUIs.wordpress.admin;

public class AdminPostAddNewPageUI {
	public static final String POST_TITLE = "css=h1.wp-block-post-title";
	public static final String POST_BODY_BUTTON = "css=p.block-editor-default-block-appender__content";
	public static final String POST_BODY_TEXTBOX = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "css=div[aria-label='Editor top bar'] button[class*='editor-post-publish-button']";
	public static final String PRE_PUBLISH_BUTTON = "css=div[aria-label='Editor publish'] button[class*='editor-post-publish-button']";
	public static final String PUBLISH_OR_UPDATE_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
