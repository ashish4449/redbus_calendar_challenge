import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Challenge {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.redbus.in/");
		
		getWeekEnds wk= new getWeekEnds(driver);
		wk.getWeekEndDates("Apr 2024");

	}


}