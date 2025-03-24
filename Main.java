

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

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
        WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button")));
        buyNowButton.click();
        
        System.out.println("Successfully navigated to the payment page.");
        
        // Wait before closing to observe the behavior
        Thread.sleep(5000);

        // Close browser only if necessary
        //if (driver.getWindowHandles().size() > 1) {
            //driver.quit();
        	
        	// Enter mobile number
            
        //}
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input")));
        phoneInput.sendKeys("6290410903");
        System.out.println("Entered phone number.");	
        
        WebElement firstcontinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button/span")));
        firstcontinueButton.click();
        System.out.println("Clicked on the first Continue button.");
        
        WebElement secondcontinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[3]/div/div/div/div/div[5]/span[2]/button")));
        secondcontinueButton.click();
        System.out.println("Clicked on the second Continue button .");
        
        WebElement acceptAndContinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div/div/button")));
        acceptAndContinueButton.click();
        System.out.println("Clicked on Accept & Continue.");

        Thread.sleep(3000);
        
        
     // Select Credit Card Payment Option
        WebElement creditCardOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[1]")));
        creditCardOption.click();
        System.out.println("Selected Credit Card payment option.");

        // Wait for card details fields to appear
        Thread.sleep(2000);

        // Enter Card Number
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[1]/div/div/input")));
        cardNumberField.sendKeys("4111 1111 1111 1111");  // Dummy card number
        System.out.println("Entered card number.");

        // Enter Expiry Date (MM/YY format)
        WebElement monthexpiryFieldoption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[2]/span[2]/div[1]/select")));
        monthexpiryFieldoption.sendKeys("12");  // Example: December 2028
        System.out.println("Entered expiry month.");
        
        WebElement yearexpiryFieldoption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[2]/span[2]/div[2]/select")));
        yearexpiryFieldoption.sendKeys("28");  // Example: December 2028
        System.out.println("Entered expiry year.");
        
        
     // Enter CVV
        WebElement cvvField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[3]/div/div/input")));
        cvvField.sendKeys("123");  // Example CVV
        System.out.println("Entered CVV.");
        
        WebElement zipcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[4]/div[1]/div/input")));
        zipcode.sendKeys("712112");  // Example: December 2028
        System.out.println("Entered zipcode.");
        
        WebElement countryCodeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[4]/div[2]/div/select")));
        countryCodeOption.sendKeys("India");
        System.out.println("Selected country code +91.");
        
        
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[4]/div[3]/div/input")));
        city.sendKeys("BHADRESHWAR");  // Example: December 2028
        System.out.println("Entered city.");
        
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[4]/div[4]/div/input")));
        state.sendKeys("WEST BENGAL");  // Example: December 2028
        System.out.println("Entered state");
        
        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[4]/div[5]/textarea")));
        address.sendKeys("KRISHNA KUTHIR");  // Example: December 2028
        System.out.println("Entered address");
        
        
        

        

        // Click on Pay Now or Continue Button
        WebElement payNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div/div[3]/form/div[5]/button")));
        payNowButton.click();
        System.out.println("Clicked on Pay Now.");

    }
}