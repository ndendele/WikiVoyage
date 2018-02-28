import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Destination {
    @FindBy(className = "wpb-name")
    private WebElement destination;


    public String verification() {
        return destination.getText();
    }


    public Destination(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait10= new WebDriverWait (driver,10);
        wait10.until(ExpectedConditions.visibilityOf(destination));

    }
}
