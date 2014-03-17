package ct4etaoh5.testc;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.openqa.selenium.By;
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
public class TBSearchTest implements Runnable {
	String deviceId;
	AndroidDriver driver;
	int pcPort;

	public TBSearchTest(String deviceId, int pcPort) {
		this.deviceId = deviceId;
		this.pcPort = pcPort;
	}

	@Before
	public void init() {
		/**
		 * forward tcp
		 */
		Init.init(deviceId, pcPort);
	}

	public void testTBSearch() throws Exception {
		URL driverUrl = new URL("http://localhost:" + pcPort + "/wd/hub/");
		driver = new AndroidDriver(driverUrl);
		/**
		 * 首次打开“首页”
		 */
		// driver.get(Const.urlTaoBaoPre);// 预发
		driver.get("http://s.waptest.taobao.com/search.htm?from=1&q=%E8%BF%9E%E8%A1%A3%E8%A3%99");
		Util.record(driver, deviceId);

		driver.get("http://s.waptest.taobao.com/search.htm?_input_charset=utf-8&sst=1&rn=kTkFAi1-5WIRGi0xLI7r3qCSj6-vhSykYO-Y4&buying=buyitnow&top_search=1&suggest=&tab=all&abtest=7&catmap=&t=1395048291796&q=ipad");
		Util.record(driver, deviceId);

	}

	public void destroy() {
		Init.destroy(deviceId);
	}

	@Override
	public synchronized void run() {
		init();
		try {
			testTBSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		destroy();

	}

}
