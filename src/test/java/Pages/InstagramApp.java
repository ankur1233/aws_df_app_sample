package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InstagramApp extends BasePage{

public InstagramApp(AppiumDriver driver) {
		super(driver);
	}


By userIdLocator = By.id("com.instagram.android:id/login_username");

By pwdLocator = By.id("com.instagram.android:id/login_password");

By loginBtnLocator = By.id("com.instagram.android:id/next_button");


	
public void login(String userName,String password) throws Exception{
	try{
		driver.findElement(By.id("com.instagram.android:id/log_in")).click();
		System.out.println("Clicked On Log in Link.");
	}catch(Exception e){
		
	}
	driver.findElement(userIdLocator).clear();
	driver.findElement(userIdLocator).sendKeys(userName);
	System.out.println("Set UserName : "+userName);
	driver.findElement(pwdLocator).clear();
	driver.findElement(pwdLocator).sendKeys(password);
	System.out.println("Set Password : "+password);
	driver.findElement(loginBtnLocator).click();
	System.out.println("Clicked On Login Button.");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}	


}



