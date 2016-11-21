package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookPage {
    private WebDriver book;

    public BookPage(WebDriver driver){
        book = driver;
    }
    public List<WebElement> relatedBooks(){
        WebElement blockRelated = book.findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(9);
        List<WebElement> relatedBooks = blockRelated.findElements(By.tagName("td"));
        return relatedBooks;
    }

}
