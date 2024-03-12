import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getWeekEnds {
	public WebDriver d;

	public getWeekEnds(WebDriver driver) {
		this.d = driver;
	}

	public void getWeekEndDates(String EnterYearAndMonth) throws InterruptedException {
		d.findElement(By.cssSelector("#onwardCal")).click();
		Thread.sleep(2000);
		List<WebElement> cl = d.findElements(By.cssSelector(".bwoYtA"));
		String ss = d.findElement(By.cssSelector("[style*='flex-grow: 2;'][style*='font-size: 0.875rem;']")).getText();
		String[] SplitHeading = ss.split("\\n");
		String MonthYear = SplitHeading[0];

		// System.out.println(MonthYear);
		String month = EnterYearAndMonth;
		String nextMonth = "";
		if (MonthYear.contains(month)) {
			System.out.println(ss);
			cl.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));
		} else {
//			System.out.println("ky kr rha hai ye");
			while (!MonthYear.equals(month)) {
				d.findElement(By.cssSelector(".DayNavigator__IconBlock-qj8jdz-2:nth-child(3)")).click();
				Thread.sleep(1000);
				String GetMonth = d
						.findElement(By.cssSelector("[style*='flex-grow: 2;'][style*='font-size: 0.875rem;']"))
						.getText();
				// System.out.println(GetMonth);
				String[] part2 = GetMonth.split("\\n");
				String str1 = part2[0];

				nextMonth = str1;

				if (nextMonth.equals(month)) {
					Thread.sleep(2000);

					System.out.println(GetMonth);
					List<WebElement> dl = d.findElements(By.cssSelector(".bwoYtA"));
					dl.stream().map(s -> s.getText()).forEach(s -> System.out.print(s + ", "));
					break;
				}

			}
		}
	}
}
