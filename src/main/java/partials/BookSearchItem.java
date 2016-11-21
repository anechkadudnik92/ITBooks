package partials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.print.Book;
import java.util.List;

public class BookSearchItem{
    private WebElement item;

    public BookSearchItem(WebElement webElement) {
        item = webElement;
    }

    public WebElement bookImage(){
        try {
            return item.findElement(By.tagName("img"));
        } catch (Exception ex){
            throw new RuntimeException("Image was not found", ex);
        }
    }

    public WebElement bookTitleLink(){
        try {
            return item.findElements(By.tagName("a")).get(1);
        } catch (Exception ex){
            throw new RuntimeException("Element was not found", ex);
        }
    }


}
