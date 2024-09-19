package pageUIs;

public class NewCustomerPageUI {
    public static final String DYNAMIC_FIELD_NAME_BY_NAME = "xpath=//input[@name='%s']";
    public static final String ADDRESS_TEXTAREA = "xpath=//textarea[@name='addr']";
    public static final String SUBMIT_BUTTON = "xpath=//input[@value='Submit']";
    public static final String DYNAMIC_ERROR_MESSAGE_BY_NAME = "xpath=//input[@name='%s']/following-sibling::label";
    public static final String ADDRESS_ERROR_MESSAGE = "xpath=//textarea[@name='addr']/following-sibling::label";
    public static final String MESSAGE_SUCCESS = "xpath=//table[@id='customer']//p[@class='heading3']";
    public static final String DYNAMIC_TEXT_BY_ROW_NAME = "xpath=//td[text()='%s']/following-sibling::td";
    public static final String DYNAMIC_GENDER_RADIO = "xpath=//input[@value='%s']";
}
