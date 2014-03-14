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

		String[] urlsPre = {
				"http://wapa.etao.com/?mode=pre#!/entry/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/zdm/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/free99/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/item/index.php?nid=35365773669&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/search/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/search/search.php?q=iphone5s&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/search/search.php?q=iphone5s&all_cities=0&fseller=%E4%BA%AC%E4%B8%9C%E5%95%86%E5%9F%8E&cat=52298021&start_price=0&end_price=8891&hidepop=true",
				// "http://wapa.etao.com/?mode=pre#!/search/search.php?q=iphone5s&all_cities=0&fseller=京东商城&cat=52298021&start_price=0&end_price=8891&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/squared9/index.php?datafrom=20&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/youhui/sign_only.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/youhui/index.php?feedid=26282&hidepop=true"
		// "http://wapa.etao.com/?mode=pre#!/myetao/index.php?hidepop=true",
		// "http://wapa.etao.com/?mode=pre#!/myetao/myjfb.php?hidepop=true",
		// "http://wapa.etao.com/?mode=pre#!/myetao/myquan.php?hidepop=true",
		};

		// /**
		// * 线上登陆
		// */
		//
		// driver.get("http://login.m.taobao.com/login.htm?ttid=12345@ETAOH5_ietao_1.0.0&tpl_redirect_url=http%3A%2F%2Fm.etao.com%2F%23!usercenter.php");
		// driver.findElementByXPath("//INPUT[@id=\"J_UserNameTxt\"]").sendKeys(
		// "universsky1");
		// driver.findElementByXPath("//INPUT[@id=\"J_PassWordTxt\"]").sendKeys(
		// "15850537705t");
		// Util.record(driver, deviceId);
		// driver.findElementByXPath("//DIV[4]/INPUT[1]").click();
		// Util.record(driver, deviceId);
		// Thread.sleep(5000);
		// driver.get("http://m.etao.com/#!usercenter.php?hidepop=true");
		// Util.record(driver, deviceId);
		//
		// driver.get("http://m.etao.com/#!myetao.php?hidepop=true");
		// Util.record(driver, deviceId);
		// driver.get("http://m.etao.com/#!myquan.php?hidepop=true");
		// Util.record(driver, deviceId);
		//
		// driver.get("http://m.etao.com/#!sign_only.php?hidepop=true");
		// Util.click(driver, "//DIV[@id=\"J_signTip\"]/IMG[1]");
		// Util.record(driver, deviceId);

		// for (String url : urls) {
		// driver.get(url);
		// Util.record(driver, deviceId);
		// }

		/**
		 * 预发测试
		 */
		// init();
		for (String url : urlsPre) {
			init();
			driver.get(url);
			Util.sleep();
			Util.record(driver, deviceId);
			// driver.close();
			destroy();
		}
		// driver.close();
	}

	public void destroy() {
		Init.destroy(deviceId);
		// driver.quit();
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
