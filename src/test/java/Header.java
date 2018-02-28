import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    WebDriver driver;

    @FindBy(id="searchInput")
    private WebElement recherche;

    @FindBy(id="searchButton")
    private WebElement rechercheButton;

    public Header(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public  NavigationPanel search(String s) {
        recherche.sendKeys(s);
        rechercheButton.click();
        return new NavigationPanel(driver);

    }


}


