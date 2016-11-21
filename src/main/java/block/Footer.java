package block;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Footer {
    private WebElement footer;

    public Footer(WebElement element) {
        footer = element;
    }

    public WebElement clickLink(String linkTitle){
        try{
            return footer.findElement(By.cssSelector("a[title='"+linkTitle+"']"));

        }catch (Exception ex){
            throw new RuntimeException("Link was not clicked");
        }

    }
}
