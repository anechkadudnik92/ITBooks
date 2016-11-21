package partials;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SelenimUtils {
   // static String currentWindowHandle = "";

    public static void switchToWindow(String windowTitle, WebDriver driver){
        try{
            String currentWindowHandle = driver.getWindowHandle();
            Set<String> openedWindowHandles = driver.getWindowHandles();
            if (openedWindowHandles.size()<2){
                throw new Exception("New window wasn't opened");
            }

            String[] window = openedWindowHandles.toArray(new String[openedWindowHandles.size()]);

            for (int i=0; i<openedWindowHandles.size(); i++) {
                driver.switchTo().window(window[i]);
                if (driver.getTitle().equals(windowTitle))
                    return;
                if (i==openedWindowHandles.size()-1 && !(driver.getTitle().equals(windowTitle)))
                {
                    System.out.println("Window with title " + windowTitle + " doesn't opened");
                    break;
                }
            }

        } catch (Exception ex){
            throw new RuntimeException("error", ex);
        }




    }
}
