package pageUIs;

public class HomePageNewAccountPageUI {
    public static final String DYNAMIC_FIELD_NAME_BY_NAME = "xpath=//input[@name='%s']";
    public static final String ACCOUNT_TYPE_DROPDOWN = "xpath=//select[@name='selaccount']";
    public static final String SUBMIT_BUTTON = "xpath=//input[@value='submit']";
    public static final String DYNAMIC_ERROR_MESSAGE_BY_NAME = "xpath=//input[@name='%s']/following-sibling::label";
    public static final String MESSAGE_SUCCESS = "xpath=//table[@id='account']//p[@class='heading3']";
    public static final String DYNAMIC_TEXT_BY_ROW_NAME = "xpath=//td[text()='%s']/following-sibling::td";
}
