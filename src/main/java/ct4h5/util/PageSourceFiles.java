/**
 * 
 */
package ct4h5.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * @author 东海陈光剑 2014年2月22日 上午12:32:02 封装driver
 */
public class PageSourceFiles {
	private static WebDriver driver;

	protected static WebDriver getDriver() {
		if (driver == null) {
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new InternetExplorerDriver(ieCapabilities);
			WebDriverEventListener eventListener = new EventListener();
			driver = new EventFiringWebDriver(driver);
			((EventFiringWebDriver) driver).register(eventListener);
		}
		return driver;
	}
}
