import block.Footer;
import block.SearchBar;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BookPage;
import pages.MainPage;
import pages.ResultsPage;

public class WebApp {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public WebApp(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage mainPage(){
        return new MainPage(webDriver);
    }
    public ResultsPage resultsPage(){
        return new ResultsPage(webDriver);
    }

    public SearchBar searchBar(){
        return new SearchBar(webDriver.findElement(By.id("searchform")));
    }

    public Footer footer(){
        return new Footer(webDriver.findElement(By.className("footer")));
    }

    public BookPage bookPage(){
        return new BookPage(webDriver);
    }

}
