package ct4etaoh5.testc;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.WebDriverEventListener;

import ct4h5.Init;
import ct4h5.config.Const;
import ct4h5.util.EventListener;
import ct4h5.util.Util;

/**
 * 
 * @author 东海陈光剑 2014年2月21日 下午11:13:59
 */
@SuppressWarnings("deprecation")
public class LottoryTest implements Runnable {
	String deviceId;
	AndroidDriver driver;
	int pcPort;

	public LottoryTest(String deviceId, int pcPort) {
		this.deviceId = deviceId;
		this.pcPort = pcPort;
	}

	public void init() {
		/**
		 * forward tcp
		 */
		Init.init(deviceId, pcPort);
	}

	public void testLottory() throws Exception {
		URL driverUrl = new URL("http://localhost:" + pcPort + "/wd/hub/");
		driver = new AndroidDriver(driverUrl);
		driver.get(Const.urlLottoryPre); // 预发
		Util.record(driver, deviceId);

	}

	public void destroy() {
		Init.destroy(deviceId);
	}

	@Override
	public synchronized void run() {
		init();
		try {
			testLottory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		destroy();
	}

}
