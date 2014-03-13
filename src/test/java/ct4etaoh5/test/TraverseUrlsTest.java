/**
 * TraverseUrlsTest.java ct4etaoh5.test ct4h5 下午2:07:00 2014年3月13日 2014
 */
package ct4etaoh5.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.android.AndroidDriver;

import ct4h5.Init;
import ct4h5.config.Const;
import ct4h5.util.Util;
import junit.framework.TestCase;

/**
 * @author 东海陈光剑 2014年3月13日 下午2:07:00
 */
@RunWith(Parameterized.class)
public class TraverseUrlsTest extends TestCase {

	String deviceId;
	AndroidDriver driver;

	public TraverseUrlsTest(String deviceId) {
		this.deviceId = deviceId;
	}

	@Before
	public void init() {
		/**
		 * forward tcp
		 */
		Init.init(deviceId);

	}

	@Parameterized.Parameters
	public static Collection deviceIds() {
		List<String> deviceList = Util.getDeviceList();
		List<String[]> col = new ArrayList<String[]>(); // List
		// [4d004077b4369049,
		// Coolpad5890-a1a1314a]
		// 把List<String> 转换成 List<String[]>
		for (String e : deviceList) {
			String[] el = new String[] { e };
			col.add(el);
		}
		return col; // 字符串数组 [[Ljava.lang.String;@b4e29b,
		// [Ljava.lang.String;@18941f7, null, null, null]
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testUrls() throws Exception {
		driver = new AndroidDriver();

		String[] urls = {
				"http://m.etao.com/#!entry.php?hidepop=true",
				"http://m.etao.com/#!feed.php?hidepop=true",
				"http://m.etao.com/#!item.php?nid=341198388615335342&wpartnerid=undefined&hidepop=true",
				"http://m.etao.com/#!usercenter.php?hidepop=true",
				"http://m.etao.com/#!myetao.php?hidepop=true",
				"http://m.etao.com/#!myquan.php?hidepop=true",
				"http://m.etao.com/#!sign_only.php?hidepop=true",
				"http://m.etao.com/#!free99.php?hidepop=true",
				"http://m.etao.com/#!youhui.php?feedid=26184?hidepop=true",
				"http://m.etao.com/#!search_index.php?hidepop=true",
				"http://m.etao.com/#!search.php?q=iphone5s&hidepop=true",
				"http://m.etao.com/#!search.php?q=iphone5s&all_cities=0&fseller=京东商城&cat=52298021&start_price=0&end_price=&hidepop=true",
				"http://m.etao.com/#!squared9.php?datafrom=20&hidepop=true" };

		String[] urlsPre = {
				"http://wapa.etao.com/?mode=pre#!/entry/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/zdm/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/item/index.php?nid=35365773669&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/myetao/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/myetao/myjfb.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/myetao/myquan.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/youhui/sign_only.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/free99/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/youhui/index.php?feedid=26282&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/search/index.php?hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/search/search.php?q=iphone5s&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/search/search.php?q=iphone5s&all_cities=0&fseller=京东商城&cat=52298021&start_price=0&end_price=8891&hidepop=true",
				"http://wapa.etao.com/?mode=pre#!/squared9/index.php?datafrom=20&hidepop=true" };

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
		for (String url : urlsPre) {
			driver.get(url);
			Util.sleep();
			Util.record(driver, deviceId);
		}

	}

	@After
	public void destroy() {
		Init.destroy(deviceId);
		// driver.quit();
	}
}
