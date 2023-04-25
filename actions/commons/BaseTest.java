package commons;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BaseTest {
	private WebDriver driverBaseTest;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			driverBaseTest = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driverBaseTest = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			System.setProperty("webdriver.opera.driver", projectPath + "\\browserDriver\\operadriver.exe");
			driverBaseTest = new OperaDriver();
		}else if (browserName.equals("brave")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("coccoc")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver_110.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driverBaseTest = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser is invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverBaseTest.get("https://demo.nopcommerce.com/");
		return driverBaseTest;
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt();
	}

}
