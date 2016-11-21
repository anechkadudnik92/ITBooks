package pages;


import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import partials.BookSearchItem;

import java.util.List;
import java.util.Set;

public class MainPage{
    private WebDriver webDriver;

    public MainPage(WebDriver driver){
        webDriver = driver;
    }

    public WebElement bookListBlock(String listTitle){
        try{
            List<WebElement> elements = webDriver.findElements(By.className("top"));

            for (WebElement element: elements){
                if (element.findElement(By.tagName("h2")).getText().contains(listTitle)){
                    return element;
                }
            }
        } catch (Exception ex){
            throw new RuntimeException("Block not found", ex);
        }
        return null;
    }

    public List<BookSearchItem> lastUploadedBooks(){
        WebElement block = bookListBlock("Last Upload");

        block.findElements(By.tagName("tr"));
        return null;

    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }


}
