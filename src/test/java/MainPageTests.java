import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import partials.BookSearchItem;

import java.util.List;

public class MainPageTests {
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
    }


    @Test
    public void testFooter(){
       app.footer().clickLink("IT-eBooks.Info").click();
        Assert.assertEquals("http://it-ebooks.info/", webdriver.getCurrentUrl());
    }

    @Test
    public void testSearch(){
        app.searchBar().enterSearchQuery("java");
        app.searchBar().selectSearchTypeTitle();
        app.searchBar().searchButton().click();
        wait = new WebDriverWait(webdriver,30);
        Assert.assertTrue(webdriver.getCurrentUrl().contains("http://it-ebooks.info/search/?q=java&type=title"));
        Integer countOfBooks = webdriver.findElement(By.tagName("table")).findElements(By.tagName("tr")).size();
        Assert.assertTrue(countOfBooks == 10);
    }

    @Test
    public void getLastUploadedBooks(){
        Assert.assertTrue(app.mainPage().lastUploadedBooks().size() == 10);
    }


    @After
    public void quit(){
        if (webdriver!=null){
            webdriver.quit();
        }
    }
}
