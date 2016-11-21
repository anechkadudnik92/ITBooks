package block;


import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBar {
    private WebElement block;
    private WebDriverWait wait;

    public SearchBar(WebElement element) {
        block = element;
    }

    public WebElement searchInput() {
        try{
           return block.findElement(By.id("q"));
        } catch (Exception ex){
            throw new RuntimeException("Searchbar was not found", ex);
        }
    }

    public void enterSearchQuery(String input){
        try {
            searchInput().clear();
            searchInput().sendKeys(input);
        } catch (Exception ex){
            throw new RuntimeException("Search query was not entered", ex);
        }
    }

    public WebElement searchButton(){
        try {
            return block.findElement(By.cssSelector("input[type='submit']"));
        } catch (Exception ex){
            throw new RuntimeException("Button was not found", ex);
        }
    }

    public void selectSearchTypeTitle(){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='title']")));
            block.findElement(By.cssSelector("input[value='title']")).click();

        } catch (Exception ex){
            throw new RuntimeException("Type was not found", ex);
        }
    }

}
