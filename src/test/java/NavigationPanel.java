import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPanel {
    private WebDriver driver;


@FindBy(xpath= "//*[@id=\"n-mainpage\"]/a")
    private WebElement accueilLink;


    public NavigationPanel(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void retourHomePage(){
        accueilLink.click();


    }

}

