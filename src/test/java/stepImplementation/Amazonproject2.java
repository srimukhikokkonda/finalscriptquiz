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

public class Amazonproject2 {
	WebDriver driver;
	 @Given("^login to wayfair site$")
	 
	 public void login() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		 
		 driver=new ChromeDriver();
		  
		 // Open Wayfair
		 driver.get("http://www.wayfair.com"); 
		  
		 driver.manage().window().maximize();

		 
	 }
	    @When("^Select Furniture, living room furniture, sectionals and navigate to the 12th Item$")
	    
	    public void select() {
	    	
	    driver.findElement(By.xpath("(//a[text()='Furniture'])[1]")).click();
	    

	    	driver.findElement(By.xpath("//a[text()='Living Room Furniture']")).click();

	    	driver.findElement(By.xpath("//p[text()='Sectionals']")).click();


	    	driver.findElement(By.xpath("(//a[contains(@href,'gosnell')])[1]")).click();
			 
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
		   
		   String rating=driver.findElement(By.xpath("(//span[@class='ProductRatingNumberWithCount-rating'])[2]")).getText();

		   System.out.println(rating);

		   driver.findElement(By.xpath("(//button[@id='btn-add-to-cart'])[1]")).click();
		   driver.findElement(By.xpath("//a[@data-codeception-id='Related_Items_Continue_To_Cart']")).click();
		    
		   String price=driver.findElement(By.xpath("(//span[text()='Total:']//following-sibling::span)[1]")).getText();
		   
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

