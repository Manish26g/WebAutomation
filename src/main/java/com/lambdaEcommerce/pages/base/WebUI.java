package com.lambdaEcommerce.pages.base;


import com.lambdaEcommerce.driver01.Manager.driverManager;
import com.lambdaEcommerce.enums.WaitStrategy;
import com.lambdaEcommerce.factories.ExplicitWaitFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.lambdaEcommerce.config.factory.FrameworkConfigFactory.getConfig01;


@Slf4j

public class WebUI {

    private static final int WAIT_EXPLICIT = 10;
    public static int getExplicitWait() {
        return WAIT_EXPLICIT;
    }


    //public static WebDriver Driver;

    private static SoftAssert softAssert = new SoftAssert();

    public static void stopSoftAssertAll() {
        softAssert.assertAll();
    }

    public static void BrowserBack(){
        //Driver.navigate().back();
        driverManager.getDriver().navigate().back();
        log.info("Navigated back to the previous page on the browser.");
    }
    public static void BrowserForward(){
        //Driver.navigate().forward();
        driverManager.getDriver().navigate().forward();
        log.info("Navigated to the Next page/forward on the browser");
    }
    public static void RefreshPage(){
        //Driver.navigate().refresh();
        driverManager.getDriver().navigate().refresh();
        log.info("Page Refreshed Successfully.");
    }
    public static void maximizeWindow() {
        driverManager.getDriver().manage().window().maximize();
    }
    public static void minimizeWindow() {
        driverManager.getDriver().manage().window().minimize();
    }

    
    public static void CheckPageTitle(String expected){
        //String actual= Driver.getTitle().toLowerCase().trim();
        String actual=driverManager.getDriver().getTitle().toLowerCase().trim();
        expected= expected.toLowerCase().trim();
        if(expected.equals(actual))
        {
           log.info("Page title matched. Expected Title is - " + expected+ " Actual Title is - " + actual);
        }
        else
        {
           log.info("Page title NOT matched.Expected Title is - " + expected+ "Actual Title is - " + actual);
        }
    }
    
    public static String GetCurrentURL(){
        String currentURL= "";
        //currentURL= Driver.getCurrentUrl();
        currentURL= driverManager.getDriver().getCurrentUrl();
        log.info("Current URL of the page is - " + currentURL);
        return currentURL;
    }
    public static String GetElementText(By by)    {
        String text = "";
        //text = Driver.findElement(by).getText().trim();
        text = driverManager.getDriver().findElement(by).getText().trim();
        log.info("Getitng the Text of the element. Text value is - " + text);
        return text;
    }
    public static String GetAttributeValue(By by,String attributeName)    {
        String value = "";
        //value = Driver.findElement(by).getAttribute(attributeName);
        value = driverManager.getDriver().findElement(by).getAttribute(attributeName);
        log.info("Getting the attribute value of the element. Attribute name - " + attributeName + " and Value is - " + value);
        return value;
    }

    public static void clickElement(By by) {
        waitForElementVisible(by).click();


    }
    public static void ClearInputField(By by)    {
        //Driver.findElement(by).clear();
        driverManager.getDriver().findElement(by).clear();
        System.out.println("Input field data cleared.");
        log.info("Input field data cleared.");
    }
    public static void TypeIn(By by, String keysToEnter)    {
        driverManager.getDriver().findElement(by).click();
        driverManager.getDriver().findElement(by).clear();
        driverManager.getDriver().findElement(by).sendKeys(keysToEnter);
        log.info("Input value - " + keysToEnter + " was provided to the element.");
    }
    public static void setText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);


    }
    public static boolean IsDisplayed(By by)    {
        boolean bool = false;
        //bool = Driver.findElement(by).isDisplayed();
        bool =driverManager.getDriver().findElement(by).isDisplayed();
        log.info("Element is Displayed on the Webpage");
        return bool;
    }
    public static boolean IsElementPresentOnPage(By by)    {
        try
        {
            driverManager.getDriver().findElement(by);
            log.info("Element is present on the Webpage.");
            return true;
        }
        catch(Exception e)
        {
           log.error("Unable to find Element on the Webpage. Exception message - " + e.getMessage());
            return false;
        }
    }
    public static void ClickOnUsingJavaScript(By by)    {
        JavascriptExecutor executor = (JavascriptExecutor)driverManager.getDriver();
        executor.executeScript("arguments[0].click();", driverManager.getDriver().findElement(by));
        log.info("Click action performed on element using Javascript click method");
    }
    public static void AppendTextAtInputField(By by, String appendingText)    {
        driverManager.getDriver().findElement(by).sendKeys(appendingText);
        log.info("Text value - " + appendingText + " was appended to the Input field.");
    }
    public static int GetElementCount(By by)    {
        int count = 0;
        try
        {
            List<WebElement> element = driverManager.getDriver().findElements(by);
            count = element.size();
            log.info("Number of Elements present on the Webpage is - " + count);
            return count;
        }
        catch(Exception e)
        {
            log.error("Cannot find the Elements present on the Webpage to get an Element Count.");
            return -1;
        }
    }
    public static void ScrollWebpageToTop()    {
        JavascriptExecutor executor = (JavascriptExecutor)driverManager.getDriver();
        executor.executeScript("window.scrollTo(document.body.scrollHeight, 0)"); //x-axis & y-axis
        log.info("Webpage scrolled to the Top of the page.");
    }
    public static void scrollToElementToTop(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        log.info("Scroll to element " + by);

    }
    public static void ScrollWebpageToBottom()    {
        JavascriptExecutor executor = (JavascriptExecutor)driverManager.getDriver();
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //x-axis & y-axis
        log.info("Webpage scrolled to the Bottom of the page.");

    }
    public static void ScrollToElementView(By by)    {
        JavascriptExecutor executor = (JavascriptExecutor)driverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true)", driverManager.getDriver().findElement(by));
        log.info("Webpage scrolled to the particular Element View.");
    }
    public static boolean IsCheckboxChecked(By by)    {
        boolean status = false;
        try
        {
            status = driverManager.getDriver().findElement(by).isSelected();
            if(status == true)
            {
                log.info("Checkbox is selected.");
            }
            else
            {
                log.info("Checkbox is NOT selected.");
            }
        }
        catch(Exception e)
        {
            log.error("Unable to check the status of the checkbox element.\nException message - " + e.getMessage());
        }
        return status;
    }
    public static boolean IsRadiobuttonSelected(By by)    {
        boolean status = false;
        try
        {
            status = driverManager.getDriver().findElement(by).isSelected();
            if(status == true)
            {
                log.info("Radiobutton is selected.");
            }
            else
            {
                log.info("Radiobutton is NOT selected.");
            }
        }
        catch(Exception e)
        {
            log.error("Unable to check the status of the Radiobutton element.\nException message - " + e.getMessage());
        }
        return status;
    }
    public static void SelectDropdownByVisibleText(By by, String visibleText)    {
        WebElement element =driverManager.getDriver().findElement(by);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
        log.info("Value - " + visibleText + " is selected in the Dropdown using selectByVisibleText.");
    }
    public static void SelectDropdownByValue(By by, String value)    {

        WebElement element = driverManager.getDriver().findElement(by);
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Value - " + value + " is selected in the Dropdown using selectByValue.");
    }
    public static void SelectDropdownByIndex(By by, int index)    {
        WebElement element = driverManager.getDriver().findElement(by);
        Select select = new Select(element);
        select.selectByIndex(index);
        log.info("Index - " + index + " is selected in the Dropdown using selectByIndex.");
    }
    public static void SwitchToFrame(By by)    {
        WebElement element = driverManager.getDriver().findElement(by);
        driverManager.getDriver().switchTo().frame(element);
        log.info("Driver has switched to a Frame.");
    }
    public static void SwitchToFrame(int index)    {
        driverManager.getDriver().switchTo().frame(index);
        log.info("Driver has switched to a Frame by using Index postion.");
    }
    public static void SwitchToFrame(String NameOrId)    {
        driverManager.getDriver().switchTo().frame(NameOrId);
        log.info("Driver has switched to a Frame by using Name or ID of the element.");
    }
    public static void SwitchToDefaultContent()    {
        driverManager.getDriver().switchTo().defaultContent();
        log.info("Driver has switched to a Default content on the Webpage.");
    }
    public static void AcceptPopUpAlert()    {
        driverManager.getDriver().switchTo().alert().accept();
        log.info("Popup alert accepted.");
    }
    public static void DismissPopUpAlert()    {
        driverManager.getDriver().switchTo().alert().dismiss();
        log.info("Popup alert dismissed.");
    }
    public  static void MouseHoverAndClick(By hoverElement, By clickElement)    {
        WebElement element = driverManager.getDriver().findElement(hoverElement);
        Actions action = new Actions(driverManager.getDriver());
        action.moveToElement(element).build().perform();
        log.info("User has hovered the mouse on the preferred element.");
        driverManager.getDriver().findElement(clickElement).click();
        log.info("User has clicked on the element visible after mouse is hovered on it.");
    }
    public  static void MouseHoverAndClick01(By by)    {
        driverManager.getDriver().findElement(by).click();
        log.info("User has clicked on the element visible after mouse is hovered on it.");
    }

    public static String TakeScreenshot()    {
        String path = System.getProperty("user.dir");
        String directory = path + "\\screenshots\\";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String name = dtf.format(now);
        String fileName = name + ".png";
        File sourceFile = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(directory + fileName);
        try
        {
            FileUtils.copyFile(sourceFile, destinationFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        log.info("Screenshot taken with name as :- " + fileName);
        return path;
    }
    public static String TakeScreenshotReturnLocation()    {
        String destination = "";
        String path = System.getProperty("user.dir");
        String directory = path + "\\screenshots\\";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String name = dtf.format(now);
        String fileName = name + ".png";
        File sourceFile = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(directory + fileName);
        destination = directory + fileName;
        try
        {
            FileUtils.copyFile(sourceFile, destinationFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        log.info("Screenshot taken with name as :- " + fileName);
        return destination;
    }
    public static String TakeScreenshotAsBase64()    {
        String destination = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        return destination;
    }

    public static void DragAndDropAction(By startingPosition, By endingPosition)    {
        WebElement start = driverManager.getDriver().findElement(startingPosition);
        WebElement end = driverManager.getDriver().findElement(endingPosition);
        Actions action = new Actions(driverManager.getDriver());
        action.dragAndDrop(start, end);
        log.info("Element is dragged from Starting position to Ending position.\nDrag and Drop action performed.");
    }
    public static WebElement getWebElement(By by) {
        return driverManager.getDriver().findElement(by);
    }
    public static List<WebElement> getWebElements(By by) {
        return driverManager.getDriver().findElements(by);
    }
    public static boolean verifyElementVisible(By by, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            Assert.fail("The element is NOT visible. " + by);
            return false;
        }
    }
    public static boolean isElementVisible(By by, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            log.info("Verify element visible " + by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static WebElement waitForElementVisible(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));

            boolean check = verifyElementVisible(by, timeOut);
            if (check == true) {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            } else {
                scrollToElementToTop(by);
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return null;
    }
    public static WebElement waitForElementVisible(By by) {
        //waitForElementPresent(by);
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(getExplicitWait()), Duration.ofMillis(500));
            boolean check = isElementVisible(by, 1);
            if (check == true) {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            } else {
                scrollToElementToTop(by);
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            log.info("Timeout waiting for the element Visible. " + by.toString());

        }
        return null;
    }
    public static WebElement waitForElementClickable(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            return wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            log.info("Timeout waiting for the element ready to click. " + by.toString());
        }
        return null;
    }
    public static WebElement waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(500));
            return wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            log.info("Timeout waiting for the element ready to click. " + by.toString());
        }
        return null;
    }
    public static WebElement waitForElementPresent(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            log.info("Timeout waiting for the element to exist. " + by.toString());
            Assert.fail("Timeout waiting for the element to exist. " + by.toString());
        }

        return null;
    }
    public static WebElement waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(WAIT_EXPLICIT), Duration.ofMillis(500));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            log.info("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
        return null;
    }
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(getConfig01().WAIT_PAGE_LOADED()),
                Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            log.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + getConfig01().WAIT_PAGE_LOADED() + "s)");
            }
        }
    }
    public static  void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        log.info(value +" is entered successfully in "+elementname);
    }
    public static  void click(By by, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();

    }
    public static void enterTextUsingJS(By by, String value){
        WebElement name=driverManager.getDriver().findElement(by);
        ((JavascriptExecutor)driverManager.getDriver()).executeAsyncScript("arguments[0].value='" + value + "';",name);

    }


    /*Verification section used in the framework*/


    public static String getTextElement(By by) {
         return waitForElementVisible(by).getText().trim();
    }
    public static boolean verifyElementText(By by, String text) {
        waitForElementVisible(by);
        //return getTextElement(by).trim().equals(text.trim());
        return getTextElement(by).equals(text);
    }


















}
