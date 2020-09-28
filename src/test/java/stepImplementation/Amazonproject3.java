package stepImplementation;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Amazonproject3 {
	WebDriver driver;
	 @Given("^login to amazon site$")
	 
	 public void login() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		 
		 WebDriver driver=new ChromeDriver();
		  
		 // Open Amazon
		 driver.get("http://www.Amazon.com"); 
		  
		 driver.manage().window().maximize();
		 
	 }
	    @When("^Select iPhone 11 Pro from shop IPhone$")
	    
	    public void select() {
	    	
	    	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone");

	    	driver.findElement(By.xpath("//a[text()='iPhone 11 Pro']")).click();


	    	boolean compare=driver.findElement(By.xpath("//h1[text()='Compare Apple iPhone products']")).isDisplayed();

	    	if(compare){

	    	System.out.println("compare chart is displayed");

	    	}

	    	else

	    	{

	    	System.out.println("compare chart is not displayed");

	    	}

		 }
	   @Then("^print the rating and price of item$")

	   public void rating() {
			
		   String MainWindow=driver.getWindowHandle();		
   		
	        // To handle all new opened window.				
	            Set<String> s1=driver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);	                                                                                                           
	                    			   
	                    String rating=driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star a-star')])[1]//span")).getText();

	                    System.out.println(rating);

	                    driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
	                     
	                    String price=driver.findElement(By.xpath("((//span[@class='a-size-base-plus'])[1])//span[contains(@class,'price')]")).getText();

	                    System.out.println(price);
		   
			// Closing the Child Window.
           driver.close();		
}		
}		
// Switching to Parent window i.e Main Window.
driver.switchTo().window(MainWindow);

driver.close();
}
	  
		 }

