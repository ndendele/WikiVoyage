import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    WebDriver driver = new ChromeDriver();
    String recherche;

    @Before
    public void init(){
        driver.get("https://www.wikivoyage.org/");
        driver.manage().window().maximize();

    }

    @Test
    //Test pour entrer la ville à rechercher
    public void test() {
        recherche= System.getProperty("recherche");
        HomePage homePage= new HomePage(driver);
        homePage.setSearchInput(recherche);
        homePage.getSearchButton();
  
    }



    @Test
    //Test entrer d'une ville
    public void test1(){
     HomePage homePage= new HomePage(driver);
     homePage.setSearchInput("Paris");
     homePage.getSearchButton();
     Assert.assertEquals("Paris", new Destination(driver).verification());
    }

    @Test
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
    //Test recherche header puis retourne à HomePage
    public void test3(){
        HomePage homePage= new HomePage(driver);
        homePage.selectFrancais();
        PageAccueil pageAccueil = new PageAccueil(driver);
        pageAccueil.rechercheHeader(driver).search("Lyon").retourHomePage();
        Assert.assertEquals("Accueil", new PageAccueil(driver).verification());
    }


    @Test
    //Test du lien vers l'aide
    public void test4() {
        HomePage homePage = new HomePage(driver);
        homePage.selectFrancais();
        PageAccueil pageAccueil = new PageAccueil(driver);
        pageAccueil.navigationPanel(driver).accesAide();
        Assert.assertEquals("https://fr.wikivoyage.org/wiki/Aide:Accueil", driver.getCurrentUrl());
    }





    @After
    public void quit(){
        driver.quit();
    }

}
