import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    WebDriver driver = new ChromeDriver();

    @Before
    public void init(){
        driver.get("https://www.wikivoyage.org/");
        driver.manage().window().maximize();

    }

    @Test
    @Ignore
    //Test entrer d'une ville
    public void test(){
     HomePage homePage= new HomePage(driver);
     homePage.setSearchInput("Paris");
     homePage.getSearchButton();
     Destination destination= new Destination(driver);
     Assert.assertEquals("Paris", destination.verification());

    }

    @Test
    @Ignore
    //Test selection d'une langue
    public void test2(){
        HomePage homePage= new HomePage(driver);
        homePage.selectFrancais();
        Assert.assertEquals("Accueil",  new PageAccueil(driver).verification());
        driver.navigate().back();

        homePage.selectEspagnol();
        Assert.assertEquals("Bienvenido",  new PageAccueil(driver).verifEspagnol());
        driver.navigate().back();

        homePage.selectAnglais();
        Assert.assertEquals("Welcome",  new PageAccueil(driver).verifAnglais());
        driver.navigate().back();

    }


    @Test
    @Ignore
    //Test recherche header puis retourne à HomePage
    public void test3(){
        HomePage homePage= new HomePage(driver);
        homePage.selectFrancais();
        PageAccueil pageAccueil = new PageAccueil(driver);
        pageAccueil.rechercheHeader(driver).search("Lyon").retourHomePage();
        Assert.assertEquals("Accueil", new PageAccueil(driver).verification());





    }

    @After
    public void quit(){
        driver.quit();
    }

}