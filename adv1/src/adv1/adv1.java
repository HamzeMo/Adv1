package adv1;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class adv1  {
	   WebDriver driver = new ChromeDriver();
	   
	   static String Url = "https://www.saucedemo.com/";
	   static String Username = "standard_user";
	   static String Password = "secret_sauce";

	@BeforeTest
	public void mybeforetest() {
		driver.get(Url);
		driver.manage().window().maximize();}
	
	@Test(priority = 1)
	public void logintest () {
		WebElement UserLogin =driver.findElement(By.id("user-name"));
		UserLogin.sendKeys(Username);
		
		WebElement PasswordLogin = driver.findElement(By.id("password"));
		PasswordLogin.sendKeys(Password);
		
		WebElement Login = driver.findElement(By.id("login-button"));
		Login.click();}
	@Test(priority = 2)
	public void AddToCart () {
		List<WebElement> Button = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> ItemsPrices = driver.findElements(By.className("inventory_item_price"));

		for (int i =0 ; i<Button.size();i++) {
		if (ItemsNames.get(i).getText().contains("Backpack") || ItemsNames.get(i).getText().contains("Fleece") || ItemsNames.get(i).getText().contains("Onesie")) {
			
			String PriceAfterTax = ItemsPrices.get(i).getText().replace("$", "");
			double PriceAsDouble = Double.parseDouble(PriceAfterTax);
			double Tax= 0.10;
			double FinalPrice= PriceAsDouble * Tax + PriceAsDouble;
			
			System.out.println(ItemsNames.get(i).getText()+" Wasn't Added " +" The Price For This Item Is" +ItemsPrices.get(i).getText() + " And The Last Price With Tax For This Item Is " + FinalPrice  );
	        int intFinalPrice = (int) FinalPrice;
            if (  intFinalPrice %2==0) {System.out.println(" This Is Number A Even Number");}
			else {System.out.println("This Is Number A Odd Number");}
		    continue;
			}else  { 
			String PriceAfterTax = ItemsPrices.get(i).getText().replace("$", "");
			double PriceAsDouble = Double.parseDouble(PriceAfterTax);
			double Tax= 0.10;
			double FinalPrice= PriceAsDouble * Tax + PriceAsDouble;
			Button.get(i).click(); 
			
			System.out.println(ItemsNames.get(i).getText()+" Was Added "+"And The Original Price For Item Is" +ItemsPrices.get(i).getText() + " And The Last Price With Tax For This Item Is " + FinalPrice   );
			int intFinalPrice = (int) FinalPrice;
			if ( intFinalPrice  %2==0) {
				System.out.println("This Is Number A Even Number");
				
			}
			else {
				System.out.println("This Is Number A Odd Number");
			}}
			}
}	
	@AfterTest
	public void aftertest () {	
	}
}