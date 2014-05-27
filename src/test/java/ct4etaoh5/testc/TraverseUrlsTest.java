/**
 * TraverseUrlsTest.java ct4etaoh5.test ct4h5 下午2:07:00 2014年3月13日 2014
 */
package ct4etaoh5.testc;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;

import ct4h5.Init;
import ct4h5.config.Const;
import ct4h5.util.Util;

/**
 * @author 东海陈光剑 2014年3月13日 下午2:07:00
 */
@SuppressWarnings("deprecation")
public class TraverseUrlsTest implements Runnable {

	String deviceId;
	AndroidDriver driver;
	int pcPort;

	public TraverseUrlsTest(String deviceId, int pcPort) {
		this.deviceId = deviceId;
		this.pcPort = pcPort;
	}

	public void init() {
		/**
		 * forward tcp
		 */
		Init.init(deviceId, pcPort);
		URL driverUrl;
		try {
			driverUrl = new URL("http://localhost:" + pcPort + "/wd/hub/");
			driver = new AndroidDriver(driverUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void testUrls() throws Exception {

		/**
		 * 预发测试
		 */
		for (String url : Const.urlsPreTaoBao) {
			init();
			driver.get(url);
			Util.sleep();
			Util.record(driver, deviceId);
			destroy();
		}
	}

	public void destroy() {
		Init.destroy(deviceId);
	}

	@Override
	public synchronized void run() {
		try {

			testUrls();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
