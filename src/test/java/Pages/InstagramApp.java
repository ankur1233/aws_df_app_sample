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

String profileSelector = "new UiSelector().descriptionContains(\"Profile\")";

String optionSelector= "new UiSelector().descriptionContains(\"Options\")";

String searchAndExploreLocator = "new UiSelector().descriptionContains(\"Search and Explore\")";

By searchBoxLocator = By.id("com.instagram.android:id/action_bar_search_edit_text");

String placeLoctor = "new UiSelector().text(\"Places\")";

String addAccountText = "Add Account";
String addAccountSelector = "new UiSelector().text(\""+addAccountText+"\")";


String logOutText = "Log Out";
String logOutSelector = "new UiSelector().text(\""+logOutText+"\")";



By avatarLocator = By.id("com.instagram.android:id/tab_avatar");

String logOutAllText = "Log Out of All Accounts";
String logOutAllSelector = "new UiSelector().text(\""+logOutAllText+"\")";


By photosOfYouLocator = By.id("com.instagram.android:id/button_profile_tags_imageview");

By imagesLocator = By.id("com.instagram.android:id/image_button");

	
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

/*	public boolean isSomeoneLoggedIn(){
		try{
			driver.findElementByAndroidUIAutomator(profileSelector);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public boolean isMultipePersonLoggedIn(){
		try{
			driver.findElement(avatarLocator);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public void clickOptions(){
		driver.findElementByAndroidUIAutomator(optionSelector).click();
		System.out.println("Clicked On Option.");

	}
	public void logOutAll(){
		clickAvtar();
		clickOptions();
		scrollTo(logOutAllText);
		driver.findElementByAndroidUIAutomator(logOutAllSelector).click();
		System.out.println("Clicked On LogOut All.");
		driver.findElementByAndroidUIAutomator(logOutSelector).click();
		System.out.println("Clicked On Log Out Confirmation Box.");
		getWait().until(ExpectedConditions.presenceOfElementLocated(userIdLocator));	
	}
	public void logOut(){
		clickProfile();
		clickOptions();
		scrollTo(logOutText);
		System.out.println("Clicked On LogOut.");
		driver.findElementByAndroidUIAutomator(logOutSelector).click();
		System.out.println("Clicked On Log Out Confirmation Box.");
		driver.findElementByAndroidUIAutomator(logOutSelector).click();
		getWait().until(ExpectedConditions.presenceOfElementLocated(userIdLocator));
	}
	
	

	public void clickAvtar(){		
		driver.findElement(avatarLocator).click();
		System.out.println("Clicked On Avatar Icon.");
	}

	public void clickProfile(){
		driver.findElementByAndroidUIAutomator(profileSelector).click();
		System.out.println("Clicked On Profile.");
	}

	public void addAccount(String instagramId, String instagramPwd) throws Exception {
		clickOptions();
		scrollTo(addAccountText);
		driver.findElementByAndroidUIAutomator(addAccountSelector).click();
		System.out.println("Clicked On Add Account.");
		login(instagramId, instagramPwd);
		
	}
	
	public void clickOnPhotosOfYou(){
		driver.findElement(photosOfYouLocator).click();
	}


	public void likePhoto() {
		WebElement heartElement = driver.findElement(By.id("com.instagram.android:id/row_feed_button_like"));
		System.out.println(heartElement.getAttribute("name"));
		if(heartElement.getAttribute("name").equalsIgnoreCase("like")){
			heartElement.click();
		}
	}

	public int getNumberOfLikes() {
		int numOfLikes=0;
		try{
		WebElement numberOfLikes = driver.findElement(By.id("com.instagram.android:id/row_feed_textview_likes"));
		String numberOflikesValue = numberOfLikes.getText().trim().split(" ")[0];
		System.out.println("Number Of Likes : "+ numberOflikesValue);
		if(numberOfLikes.getText().endsWith("likes")){
			numOfLikes = Integer.valueOf(numberOflikesValue);
		}
		}catch(Exception e){
			System.err.println("No Like On the Post.");
		}
		return numOfLikes;
	}
	
	public void clickOnNumberOfLikes(){
		driver.findElement(By.id("com.instagram.android:id/row_feed_textview_likes")).click();
	}


	public void clickBack() {
		driver.findElement(By.id("com.instagram.android:id/action_bar_button_back")).click();
		
	}
	
	public String getPostUserName(){
		return driver.findElement(By.id("com.instagram.android:id/row_feed_photo_profile_name")).getText();
	}
	
	public String getPostDate(){
		return	driver.findElement(By.id("com.instagram.android:id/row_feed_media_feedback")).findElements(By.className("android.widget.TextView")).get(1).getText();
	}
	
	
	public String getPostLocation(){
		try{
		return driver.findElement(By.id("com.instagram.android:id/row_feed_photo_location")).getText();
		}catch(Exception e){
			return "";
		}
	}
	
	public String getPostDuration(){
		try{
		return driver.findElement(By.id("com.instagram.android:id/row_feed_photo_profile_metalabel")).getText();
		}catch(Exception e){
	return "";
		}	
	}
	
	public String getPostComment(){
		try{
		return driver.findElement(By.id("com.instagram.android:id/row_feed_textview_comments")).getText();
		}catch(Exception e){
			return "";
		}
	}
	
	public void scrollTo(String text){
		System.out.println("Scrolling to Find Text : "+text);
		boolean isFound=false;
		List<WebElement> allrow = driver.findElements(By.id("com.instagram.android:id/row_simple_text_textview"));
		do{
		scroll(0.9, 0.2);//scroll(0.5, 0.2);
		allrow = driver.findElements(By.id("com.instagram.android:id/row_simple_text_textview"));
		for(WebElement one : allrow){
			if(one.getText().equals(text)){
				isFound = true;
				System.out.println(text + " Found!");
				break;
			}
		}
			
		}while(!isFound);
	}


	public void FollowAllLikers() {
		int numOfLikes = getNumberOfLikes();
//		numOfLikes =0;
		//TODO
		if(numOfLikes!=0){
			
			clickOnNumberOfLikes();
			
			int loop = (int) Math.floor(numOfLikes/ (driver.findElements(By.id("com.instagram.android:id/row_user_container")).size()-1))+2;
		
			for(int j=1;j<=loop;j++){
				
				List<WebElement> allUsers = driver.findElements(By.id("com.instagram.android:id/row_user_container"));
				
				for(int k=0;k<allUsers.size();k++){
					
					try{
							WebElement followbtn = allUsers.get(k).findElement(By.id("com.instagram.android:id/button"));
							Thread.sleep(300);
							
							if(followbtn.getText().equalsIgnoreCase("follow")){
								followbtn.click();
								}
					
					}catch(Exception e){
						System.err.println("Follow Button Not Found");
					}
				}
				scroll(0.9, 0.2);
				//allUsers = driver.findElements(By.id("com.instagram.android:id/row_user_container"));
				}
			clickBack();
		}
	}
	
	public List<WebElement> getAllTaggedPhotos(){
		return driver.findElements(imagesLocator);
	}

	public void clickSearchAndExplore(){
		driver.findElementByAndroidUIAutomator(searchAndExploreLocator).click();
	}
	
	public void searchLocation(String value){
		driver.findElement(searchBoxLocator).clear();
		driver.findElement(searchBoxLocator).sendKeys(value);
		driver.findElementByAndroidUIAutomator(placeLoctor).click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+value+"\")").click();
	}


	public boolean isTopPostsAvailable() {
		try{
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Top Posts\")");
		return true;
		}catch(Exception e){
			System.out.println("Top Posts Not Available.");
			return false;
		}
		
		
	}
	
	public boolean scrollTillRecenPostInvisible() {
		while(true){
			try{
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Most Recent\")");
				BaseFunctions.scroll(0.5,0.3);//Scroll Down
			}catch(Exception e){
				System.out.println("Recent post Text Not Visible.Break the loop.");
				return true;
			}
		}
	}

		
		public boolean scrollTillRecenPostVisible() {
			while(true){
				try{
					driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Most Recent\")");
				return true;
				}catch(Exception e){
					BaseFunctions.scroll(0.5,0.3);//Scroll Down
					System.out.println("Recent post Text Not Visible.Continue loop.");
				}
			}

		
	}*/
}



