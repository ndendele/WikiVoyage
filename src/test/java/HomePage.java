import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private PageAccueil pageAccueil;

    @FindBy(id="searchInput")
    private WebElement searchInput;

    @FindBy(id="searchButton")
    private WebElement rechercheButton;

    @FindBy(xpath = "//*[@id=\"www-wikivoyage-org\"]/div[2]/div[5]")
    private WebElement francais;

    @FindBy(className="lang1")
    private WebElement anglais;

    @FindBy(className="lang3")
    private WebElement espagnol;


    public void setSearchInput(String s){
        searchInput.sendKeys(s);
    }
    public void getSearchButton(){
        rechercheButton.click();
    }

    public void selectFrancais(){
       francais.click();
       driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public void selectAnglais(){
      anglais.click();
      driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public void selectEspagnol(){
      espagnol.click();
      driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }


}
