package stepdef;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

/**
 * Created by breddy on 05-05-2017.
 */
public class GmailElements {
	public static String OS;
    //static By ClickSignIn= By.xpath("html/body/nav/div/a[2]");
    static By UserName= By.xpath("//*[@id='identifierId']");
    static By NextButton = By.xpath("//*[@id='identifierNext']/content/span");
    static By PassWord = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
    public static String GetDateTimeInYYYYMMDDHHMMSS(){
		//return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	}




}
