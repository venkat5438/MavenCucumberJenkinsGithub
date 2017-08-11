package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.Timeout;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.AutoConstants;
import util.AutoUtils;
import util.PropHandlerz;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class GapStepDefiniton2 extends GapElements {
   public static WebDriver driver;

    @Given("^user navigate to main page$")
    public void user_navigate_to_main_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\breddy\\workspace\\MavenCucumberJenkinsGithub\\drivers\\chromedriver.exe");
        /*ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        o.addArguments("--start-maximized");*/
        driver=new ChromeDriver();
        //driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // WebDriverWait wait=new WebDriverWait(driver,5);
        driver.get(PropHandlerz.fetchProp(AutoConstants.URL.GAURL));
        //driver.manage().deleteAllCookies();  delete all cookies
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandles());
        WebElement popup;
         WebDriverWait popupwait=new WebDriverWait(driver,60);
         popup=popupwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='optly-modal-content']/span/span")));
         if(popup.isDisplayed()){
             popup.click();
         }
         /*if(popup.isDisplayed())
         {
          popup.click();
         }*/
           WebElement button;
             WebDriverWait buttonwait=new WebDriverWait(driver,20);
             button=buttonwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal--close-button")));
         button.click();

        String Title= driver.getTitle();
        System.out.println(Title);
    }
    @When("^user click Men tab and Verify Categories text present$")
    public void user_click_Men_tab_and_Verify_Categories_text_present() throws Throwable {
        WebElement men;
        WebDriverWait menwait=new WebDriverWait(driver,20);
        men=menwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/browse/subDivision.do?cid=5065&mlink=5058,12456145,visnav_M&clink=12456145']")));
        men.click();
        String Mentitle=driver.getTitle();
        System.out.println(Mentitle);
       String Text=  driver.findElement(Categories).getText();
       String PageSource= driver.getPageSource();
       if(PageSource.contains(Text)){
           System.out.println("categories present on the page");
       }
    }

    @When("^capture all the categories names$")public void capture_all_the_categories_names() throws Throwable {
        WebElement jeans;
        WebDriverWait wait1=new WebDriverWait(driver,20);
        jeans=wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mainContent']//a[@href='/browse/category.do?cid=6998&departmentRedirect=true#pageId=0&department=75']")));
        jeans.click();
        //AutoUtils.captureScreenShot(driver,"clicked jeans tab");
        // below we commented code for random jeans;
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='product-card-grid--group']/div[@class='grid-root grid ism-root']/div[@class='g-1-2 g-lg-1-3 g-xl-1-3 g-1280-1-4']"));
        System.out.println(listOfElements.size());
        Random element = new Random();
        int randomProduct = element.nextInt(listOfElements.size());
        System.out.println(randomProduct);
        listOfElements.get(randomProduct).click();


        List<WebElement> pillboxtext = driver.findElements(By.xpath("//div[@class='pillbox pillbox_2-across']/label"));
        if (pillboxtext.size() != 0) {
            int count = pillboxtext.size();
            System.out.println(count);
            Random r2 = new Random();
            int randomValue1 = r2.nextInt(pillboxtext.size()); //Getting a random value that is between 0 and (list's size)-1
            pillboxtext.get(randomValue1).click(); //Clicking on the random item in the list.
            System.out.println(pillboxtext.get(randomValue1).getText());  // here we are printing the type
        }


        //div[@id='size']/div[@class='swatches swatches_size']/div/div/div/div/div[@class='swatches--list']/label
        List<WebElement> sizu = driver.findElements(By.xpath("//div[@id='size']/div[@class='swatches swatches_size']/div/div/div/div/div[@class='swatches--list']/label"));
        if (sizu.size() != 0) {
            Random rsize = new Random();
            int randomsize = rsize.nextInt(sizu.size());
            sizu.get(randomsize).click();
            System.out.println(sizu.get(randomsize).getText());
        }

        List<WebElement> waist = driver.findElements(By.xpath("//div[@id='waist']/div[3]/div/div/div/div/div/label"));
        if (waist.size() != 0) {
            int count1 = waist.size();
            System.out.println(count1);
            Random r3 = new Random();
            int randomValue2 = r3.nextInt(waist.size()); //Getting a random value that is between 0 and (list's size)-1
            waist.get(randomValue2).click();//Clicking on the random item in the list.
            System.out.println(waist.get(randomValue2).getText());  // here we are printing the type
        }


        List<WebElement> length = driver.findElements(By.xpath("//div[@id='length']/div[3]/div/div/div/div/div/label"));
        if (length.size() != 0) {
            int count2 = length.size();
            System.out.println(count2);
            Random r4 = new Random();
            int randomValue3 = r4.nextInt(length.size()); //Getting a random value that is between 0 and (list's size)-1
            length.get(randomValue3).click();//Clicking on the random item in the list.
            System.out.println(length.get(randomValue3).getText());  // here we are printing the type
        }

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement quantity1;
        WebDriverWait wait= new WebDriverWait(driver,20);
        quantity1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='quantity quantity_size']")));
        quantity1.click();
        //driver.findElement(By.xpath("//div[@class='quantity quantity_size']")).click();
        List<WebElement> quantity=driver.findElements(By.xpath("//*[@id='product']/div[2]/div[1]/div[2]/div[5]/div/div[2]/label"));
        int count3 = quantity.size();
        System.out.println("quantity count "+count3);
        Random r5 = new Random();
        int randomValue4 = r5.nextInt(quantity.size()); //Getting a random value that is between 0 and (list's size)-1
        System.out.println(randomValue4);
       if(quantity.get(randomValue4).isEnabled())
       {
           quantity.get(randomValue4).click();
           System.out.println("clicked");
       }

    }
    @Then("^close the driver$")
        public void close_the_driver () throws Throwable {
        String title = driver.getTitle();
        System.out.println(title);
      
        driver.quit();
        }





}
