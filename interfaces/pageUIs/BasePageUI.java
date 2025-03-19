package pageUIs;

public class BasePageUI {
    public static final String ADDRESS_LINK = "XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='addresses']";
    public static final String REWARD_POINT_LINK = "XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='Reward points']";
    public static final String CUSTOMER_INFO_LINK = "XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";
    public static final String ORDER_LINK = "XPATH=//div[contains(@class,'block-account-navigation')]//a[text()='Orders']";
    public static final String UPLOAD_FILE_TYPE ="CSS=input[type='file']";
    public static final String UPLOAD_BUTTON ="CSS=td>button.start";
    public static final String FILE_UPLOAD_SUCCESS_BY_FILE_NAME ="XPATH=//p[@class='name' and text()='%s']";

}
