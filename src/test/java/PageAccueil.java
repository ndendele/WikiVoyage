import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAccueil {



    public PageAccueil(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    public WebElement getAccueil() {
        return accueil;
    }

    @FindBy (xpath = "//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div[1]/a[1]")
    WebElement verifEspagnol;
    @FindBy(xpath = "//*[@id=\"Welcome_to_Wikivoyage\"]/a[1]")
    WebElement verifAnglais;

    @FindBy(tagName = "h1")
    private WebElement accueil;

    public String verification(){
        return accueil.getText();
    }

    public String verifEspagnol(){
        return verifEspagnol.getText();
    }

    public String verifAnglais(){
        return verifAnglais.getText();
    }

    public Header rechercheHeader(WebDriver driver){
        return new Header(driver);
    }

    public NavigationPanel navigationPanel (WebDriver driver){
        return new NavigationPanel(driver);
    }

}
