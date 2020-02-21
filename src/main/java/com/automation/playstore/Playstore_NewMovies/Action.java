package com.automation.playstore.Playstore_NewMovies;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class Action extends Locator {
//declaring driver 
WebDriver driver;

//Initializing array to store names of the director
String DIRECTOR[]= new String [12];

//Variable to store array's index
int x=0;

//a public function to add Implicit wait before inspecting WebElements until element is visible 
public WebElement waitExplicitly(String s)
{
	WebDriverWait wait=new WebDriverWait(driver, 30);
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
	return element;
}

//START of flow..............................................................................................................................

//a public function to open Chrome browser and launch Google Play Store
public String invokeBrowser() {
	System.setProperty("webdriver.chrome.driver", "D:\\Workspace_bhumika\\Playstore_NewMovies\\DriverCollection\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://play.google.com/store?hl=en");
	driver.manage().window().maximize();
	String url=driver.getCurrentUrl();
	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	return(url);
	
}

//a public function to open Sign-in page of Google Play Store
public String signIntoPlaystore()
{	waitExplicitly(super.Sign_in).click();
	String url=driver.getTitle();
	return(url);
}

//a public function to successfully logging into Google Play Store with valid credentials
public String inputCredentials() 
{
	driver.findElement(By.xpath(super.Email)).sendKeys("arunnnsing@gmail.com");
	waitExplicitly(super.Next1).click();
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.findElement(By.xpath(super.Password)).sendKeys("Arun123@");
	waitExplicitly(super.Next2).click();
	String title=driver.getTitle();
	System.out.println(title);
	return(title);

}

//a public function to select Movies tab 
public String  selectMoviesTab() 
{waitExplicitly(super.Movies).click();	
String url=driver.getCurrentUrl();
System.out.println(url);
return(url);
}

//a public function to select New Releases tab 
public String selectNewReleases() throws InterruptedException
{	
	Thread.sleep(2000);
	WebElement releases=driver.findElement(By.xpath(super.NewReleases));
	releases.click();
	String url=driver.getCurrentUrl();
	System.out.println(url);
	return(url);
}

//a public function to select Genres tab and add the first most new released movie under every category of movie
public void selectGenres() throws InterruptedException 
{
	Thread.sleep(2000);
	
	List <WebElement> drpdwn=driver.findElements(By.xpath(super.drpdwn_class));
	int size=drpdwn.size();
	String arr[]=new String [size];
	System.out.println(size);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int i=1,m=1;
	for (int j=1;j<size;j++)
	{
		arr[j-1]=drpdwn.get(j).getAttribute("title");
		System.out.println(arr[j-1]);
	}
	
	int x=0;
	Actions actions= new Actions(driver);
	while(i<=size-1){
		String loc = "(//h2[text()='New" +" "+arr[x]+" "+ "Movies']/../../../../div[1]/following-sibling::div//a/div)[1]";
		String loc1="(//h2[text()='New Movie Releases']/../../../../div[1]/following-sibling::div//a/div)[1]";
		driver.findElement(By.xpath(super.Genres)).click();
		WebElement d=drpdwn.get(m);
	try {
		Thread.sleep(2000);
		actions.moveToElement(d);
		Thread.sleep(2000);
		actions.click();
		actions.build().perform();
		}
	catch(StaleElementReferenceException e)
		{
		Thread.sleep(2000);
		List <WebElement> drpdwn1=driver.findElements(By.xpath(super.drpdwn_class));
		WebElement d1=drpdwn1.get(m);
		actions.moveToElement(d1);
		Thread.sleep(2000);
		actions.click();
		actions.build().perform();
		}
		Thread.sleep(5000);
		System.out.println(loc);
		
		
		 js.executeScript("window.scrollBy(0,1000)");
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 Thread.sleep(1000);
		 
		 List <WebElement> reference= driver.findElements(By.xpath(loc));
			 if(reference.size() != 0)
			 		{
				 	System.out.println("Element present");
				 	reference.get(0).click();
			 		}
			 else
					{
					System.out.println("Element not present");
					List <WebElement> reference1= driver.findElements(By.xpath(loc1));
					if(reference1.size() != 0)
						{
						reference1.get(0).click();
						}
					}
		
		System.out.println("clicked on firstMovie");
		Thread.sleep(2000);
			i++;
			x++;
			m++;
		
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath(super.Add_to_wishlist));
		
		if(dynamicElement.size() != 0)
			{
			System.out.println("Element present");
			dynamicElement.get(0).click();
			}
		else
			{	
			System.out.println("Element not present");
			}
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement director= driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[4]/c-wiz[5]/div/div[2]/div/div[1]/div/c-wiz[2]/div[1]/div[2]/div[3]/div/span[1]/a/span"));
		DIRECTOR[x]=director.getText();
		
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(2000);
	
	}
	
}

//A public function to display the respective directors of the first most new released movie under every category of movie
public void printDirectorName() {
	for (int k=0;k<100;k++)
	{
		System.out.println(DIRECTOR[k]);
	}
	
//END of flow..............................................................................................................................
	
}}


