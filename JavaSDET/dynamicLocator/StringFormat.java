package dynamicLocator;

public class StringFormat {
    public static void main(String[] args) {
        String DELETE_ICON_BY_FELMALE = "//td[@data-key='females' and text()='%s']/preceding-sibling::td/button[@class='@class='qgrd-edit-row-btn'']";
        String DELETE_ICON_BY_FEMALE_COUNTRY = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@data-key='females'" + "and text()='%s']/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";

        String DELETE_ICON_BY_FEMALE_COUNTRY_MALE = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@data-key='females'" + "and text()='%s']/preceding-sibling::td/button[@class='qgrd-edit-btn']";

        clickToDeleteIcon(DELETE_ICON_BY_FELMALE,"384187");
        clickToDeleteIcon(DELETE_ICON_BY_FELMALE,"276880");
        clickToDeleteIcon(DELETE_ICON_BY_FELMALE,"764956");

        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_COUNTRY,"Afghanistan","384187");
        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_COUNTRY,"Albania","24128");
        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_COUNTRY,"Argentina","338282");

        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_COUNTRY_MALE,"407124","Afghanistan","384187");
        clickToDeleteIcon(DELETE_ICON_BY_FEMALE_COUNTRY_MALE,"407124","Albania","24128");
    }
    public static void clickToDeleteIcon(String locator,String female){
        System.out.println("Delete to icon: " + String.format(locator,female));
    }

    public static void clickToDeleteIcon(String locator,String country,String female){
        System.out.println("Delete to icon: " + String.format(locator,country,female));
    }
    public static void clickToDeleteIcon(String locator,String male,String country,String female){
        System.out.println("Delete to icon: " + String.format(locator,male,country,female));
    }
    public static void clickToDeleteIcon(String locator,String total,String male,String country,String female){
        System.out.println("Delete to icon: " + String.format(locator,total,male,country,female));
    }
    public static void clickToDeleteIcon(String locator, String... restParameter){
        System.out.println("Delete to icon: " + String.format(locator,(Object) restParameter));
    }


}
