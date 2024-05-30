package selenium.common_module.driver.easy_initialization;

import org.openqa.selenium.WebDriver;

//Простой вариант: 1 настройка selenium page
abstract public class BaseSeleniumPage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }
}
