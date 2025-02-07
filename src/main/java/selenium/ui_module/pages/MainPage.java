package selenium.ui_module.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    //указали путь до элементов
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[1]")
    private WebElement elementsButton;
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[2]")
    private WebElement formsButton;
    @FindBy(xpath =  "(//div[@class='card mt-4 top-card'])[3]")
    private WebElement alertFrameWindowsButton;
    @FindBy(xpath =  "(//div[@class='card mt-4 top-card'])[4]")
    private WebElement widgetsButton;
    @FindBy(xpath =  "(//div[@class='card mt-4 top-card'])[5]")
    private WebElement interactionsButton;
    @FindBy(xpath =  "(//div[@class='card mt-4 top-card'])[6]")
    private WebElement bookStoreApplicationButton;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
        logger.info("Navigating to: {}", url);
    }

    public WebElement getElementsButton(){
        return elementsButton;
    }

    public WebElement getFormsButton(){
        return formsButton;
    }

    public WebElement getAlertFrameWindowsButton(){
        return alertFrameWindowsButton;
    }

    public WebElement getWidgetsButton(){
        return widgetsButton;
    }

    public WebElement getInteractionsButton(){
        return interactionsButton;
    }

    public WebElement getBookStoreApplicationButton(){
        return bookStoreApplicationButton;
    }
}
