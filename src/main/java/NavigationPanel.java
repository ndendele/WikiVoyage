import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPanel {
    private WebDriver driver;


    @FindBy(xpath = "//*[@id=\"n-mainpage\"]/a")
    private WebElement lienAccueil;
    @FindBy(partialLinkText = "Aide")
    private WebElement lienAide;


    public NavigationPanel(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void retourHomePage() {
        lienAccueil.click();
    }

    public void accesAide() {
        lienAide.click();
    }

}

