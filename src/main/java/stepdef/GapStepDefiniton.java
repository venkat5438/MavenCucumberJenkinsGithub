package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.AutoConstants;
import util.PropHandlerz;

import java.util.concurrent.TimeUnit;


/**
 * Created by breddy on 09-05-2017.
 */
public class GapStepDefiniton extends GapElements {

    @Given("^Invoke the driver Browser and  Navigate to Gap Website$")
    public void invoke_the_driver_Browser_and_Navigate_to_Gap_Website() throws Throwable {
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\chromedriver.exe");
        //driver= new ChromeDriver();
        GmailStepDefinition.driver=new FirefoxDriver();
        GmailStepDefinition.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        GmailStepDefinition.driver.get(PropHandlerz.fetchProp(AutoConstants.URL.GAURL));
        GmailStepDefinition.driver.manage().window().maximize();
        GmailStepDefinition.driver.findElement(Button).click();
       String Title= GmailStepDefinition.driver.getTitle();
        System.out.println(Title);

        //driver.switchTo().alert().dismiss();
    }

    @When("^User Click Men Option and Click the New Arrivals$")
    public void user_Click_Men_Option_and_Click_the_New_Arrivals() throws Throwable {
   GmailStepDefinition.driver.findElement(Men).click();
        String Mentitle= GmailStepDefinition.driver.getTitle();
        System.out.println(Mentitle);
    }

    @When("^User Click GAP|Star Wars Hyper Speed tee$")
    public void user_Click_GAP_Star_Wars_Hyper_Speed_tee() throws Throwable {

    GmailStepDefinition.driver.findElement(Image).click();
    GmailStepDefinition.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(GmailStepDefinition.driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(GmailStepDefinition.driver.findElement(Image2)));
        element.click();
    //driver.findElement(Image2).click();
    String ModelText= GmailStepDefinition.driver.findElement(ModelProductName).getText();
        System.out.println(ModelText);


    }

    @When("^User Select the size \"([^\"]*)\"$")
    public void user_Select_the_size(String arg1) throws Throwable {
        GmailStepDefinition.driver.findElement(ModelProductsize).click();
        String size = GmailStepDefinition.driver.findElement(ModelProductsize).getText();
        System.out.println(size);

/*      List<WebElement> ele = driver.findElements(By.xpath("//div[@id='quickLookSize1Swatches']/label"));

        int count=ele.size();
        System.out.println(count);
        for (int i = 0; i <=count ; i++) {

            Actions action=new Actions(driver);
            WebElement element=driver.findElement(By.xpath("//div[@id='quickLookSize1Swatches']/label["+i+"])"));
            action.moveToElement(element).click().build().perform();


        }*/



    }

    @Then("^User Add to the Bag$")
    public void user_Add_to_the_Bag() throws Throwable {
    GmailStepDefinition.driver.findElement(AddToBag).click();
    GmailStepDefinition.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    GmailStepDefinition.driver.findElement(CheckOutButton).click();
    }

    @Then("^User Click Checkout and Verify the Same added$")
    public void user_Click_Checkout_and_Verify_the_Same_added() throws Throwable {

     GmailStepDefinition.driver.quit();
    }
}
