package runner;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CreateTask {
    public WebDriver driver = null;
    private boolean isSetHeadless = false;
    private FirefoxOptions options;

	public void clickSelectProject() {
        options = new FirefoxOptions();
        options.setHeadless(false);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// setCapability(SUPPORTS_JAVASCRIPT, javascriptEnabled);
		capabilities.setJavascriptEnabled(true);
        
        options.addPreference("javascript.enabled", true);
        driver = new FirefoxDriver(options);
		
		try {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

			driver.get("https://siiliwall.netlify.app");
			// CLICKING THE TEST PROJECT
			driver.findElement(By.className("MuiButton-label")).click();
			


			FirefoxBinary binary = new FirefoxBinary(new File("C:/Program Files/Mozilla Firefox/firefox.exe"));
			FirefoxProfile profile = new FirefoxProfile();

			//profile.setPreference("preferenceName", "Value");
			profile.setPreference("javascript.enabled", false);

			RemoteWebDriver driver = new FirefoxDriver(binary, profile, capabilities);
			
			
			driver.findElement(By.linkText("+ add new")).click();
			
			//+ add new
			System.out.println(driver.getPageSource());
		} catch (Exception ex) {
			System.out.println("Could not select project.");
		}
	}
	public static void main(String[] args) {
		CreateTask runner = new CreateTask();
		runner.clickSelectProject();
	}
}
