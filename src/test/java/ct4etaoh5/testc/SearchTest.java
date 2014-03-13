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
public class SearchTest implements Runnable {
	String deviceId;
	AndroidDriver driver;
	int pcPort;

	public SearchTest(String deviceId, int pcPort) {
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

	public void testSearch() throws Exception {
		// String remote_driver_url = "http://localhost:5555/h5";
		// WebDriverEventListener eventListener = new EventListener();

		// WebDriver driver = new EventFiringWebDriver(new RemoteWebDriver(
		// new URL(remote_driver_url), DesiredCapabilities.android()))
		// .register(eventListener);
		/**
		 * getDefaultUrl: return new URL("http://localhost:8080/wd/hub");
		 */
		// driver = new AndroidDriver(new URL("http://localhost:" + port
		// + "/wd/hub"), DesiredCapabilities.android());
		// driver = new AndroidDriver();
		URL driverUrl = new URL("http://localhost:" + pcPort + "/wd/hub/");
		driver = new AndroidDriver(driverUrl);
		/**
		 * 首次打开“首页”
		 */
		// driver.get(Const.urlEtaoOnline);// 线上
		driver.get(Const.urlEtaoPre);// 预发
		Util.record(driver, deviceId);

		// /**
		// * 关闭首页pop浮层,有时候会直接出发点击到了搜索icon,跳到搜索页了?如何解决？
		// */
		// Thread.sleep(3000);
		// Util.click(driver, "//A[3]");
		// Util.record(driver, deviceId);
		// Thread.sleep(3000);
		// if (!driver.getCurrentUrl().equals(Const.urlPre)
		// || !driver.getCurrentUrl().equals(Const.urlPre + "#!entry.php")) {
		// driver.get(Const.urlPre);
		// }
		// Thread.sleep(1000);
		/**
		 * 点击搜索icon "//SECTION[1]/DIV[2]/A[1]",进入搜索页
		 */
		// Util.click(driver, "//SECTION[1]/DIV[2]/A[1]");
		driver.findElementByCssSelector(
				"SECTION:nth-of-type(1)>DIV:nth-of-type(2)>A:nth-of-type(1)")
				.click();

		driver.get(Const.searchPreUrl);
		Util.sleep();
		// if (!driver.getCurrentUrl().equals(
		// "http://wapa.etao.com/#!search_index.php")) {
		// driver.get("http://wapa.etao.com/#!search_index.php");
		// }
		Util.record(driver, deviceId);

		/**
		 * 点击搜索框
		 */
		Util.click(driver, "//FORM/INPUT[1]");
		Util.record(driver, deviceId);
		/**
		 * 在搜索框"//FORM/INPUT[1]"输入query keys
		 */
		WebElement e = driver.findElementByXPath("//FORM/INPUT[1]");
		e.sendKeys("iphone5s");
		Util.record(driver, deviceId);// 搜索下拉推荐
		// e.submit();// 提交搜索
		e.sendKeys(Keys.ENTER);
		/**
		 * 2s等待SRP加载渲染出来
		 */
		Util.sleep();
		Util.record(driver, deviceId);
		// /**
		// * SRP页，点击"筛选"
		// * //DIV[@id="angela-view-2"]/DIV[1]/SECTION[1]/DIV[1]/DIV[1]
		// * /DIV[1]/DIV[2]/A[2]
		// */
		// Util.click(driver,
		// "//DIV[1]/SECTION[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/A[2]");
		// Util.record(driver, deviceId);
		// /**
		// * 点击商家“京东”"//DIV[2]/DIV[1]/DIV[1]/UL[1]/LI[2]"
		// */
		// Util.click(driver, "//DIV[2]/DIV[1]/DIV[1]/UL[1]/LI[2]");
		// Util.record(driver, deviceId);
		// /**
		// * 点击"确定" //DIV[1]/DIV[1]/A[2]
		// */
		// Util.click(driver, "//DIV[1]/DIV[1]/A[2]");
		// Util.record(driver, deviceId);
		// /**
		// * 验证筛选结果
		// */
		// e = driver.findElementByXPath("//LI[1]/UL[1]/LI[4]/SPAN[1]");
		//
		// assert (e.getText().contains("京东商城"));
		// /**
		// * 点击"价格"排序
		// */
		// driver.findElementByCssSelector("DIV:nth-of-type(3)>A:nth-of-type(1)")
		// .click();
		// Util.record(driver, deviceId);
		//
		// /**
		// * 销量
		// */
		//
		// Util.click(driver,
		// "//DIV[@id=\"angela-view-4\"]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/A[1]");
		// Util.record(driver, deviceId);
		// /**
		// * 点击"大小图切换"
		// */
		// Util.click(driver, "//DIV[4]/SPAN[1]/I[1]");
		// Util.record(driver, deviceId);
		// /**
		// * 点击"大小图切换"
		// */
		// Util.click(driver, "//DIV[4]/SPAN[1]/I[1]");
		// Util.record(driver, deviceId);

	}

	public void destroy() {
		Init.destroy(deviceId);
	}

	@Override
	public synchronized void run() {
		init();
		try {
			testSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		destroy();

	}

}
