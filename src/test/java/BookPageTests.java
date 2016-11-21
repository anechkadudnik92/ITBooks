import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookPageTests {
    WebDriver webdriver;
    WebApp app;
    WebDriverWait wait;

    @Before
    public void setUp(){
        webdriver = new ChromeDriver();
        //webdriver = new FirefoxDriver();
        webdriver.get("http://it-ebooks.info/");
        wait = new WebDriverWait(webdriver,30);

        app = new WebApp(webdriver);
        app.mainPage().lastUploadedBooks().get(1);
    }


    @Test
    public void getRelatedBooks(){
        Assert.assertTrue(app.bookPage().relatedBooks().size() == 3);
    }


    @After
    public void quit(){
        if (webdriver!=null){
            webdriver.quit();
        }
    }

}
