package juspayjava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open Flipkart
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();

        // Close Flipkart login popup if it appears
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'✕')]")));
            closePopup.click();
            System.out.println("Closed Flipkart login popup.");
        } catch (Exception e) {
            System.out.println("No login popup found.");
        }

        // Search for a product
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("realme 14 pro");
        searchBox.submit();

        // Wait for search results and click on the first product
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/p/')])[1]")));
        firstProduct.click();

        // Wait for new tab to open
        Thread.sleep(3000); // Ensure the new tab is fully opened before switching
        
        // Get all tabs
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1)); // Switch to the newly opened tab
            System.out.println("Switched to product tab.");
        } else {
            System.out.println("New tab was not opened.");
        }

        // Wait for the Buy Now button to be clickable
        WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'QqFHMw') and contains(@class, '_7Pd1Fp')]")));
        buyNowButton.click();
        
        System.out.println("Successfully navigated to the payment page.");
        
        // Wait before closing to observe the behavior
        Thread.sleep(5000);

        // Close browser only if necessary
        if (driver.getWindowHandles().size() > 1) {
            driver.quit();
        }
    }
}
