package ct4taobaoh5.test;

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
@RunWith(Parameterized.class)
public class SearchTest extends TestCase {
	String deviceId;
	AndroidDriver driver;

	public SearchTest(String deviceId) {
		this.deviceId = deviceId;
	}

	@Before
	public void init() {
		/**
		 * forward tcp
		 */
		// Init.forward(deviceId);
		Init.init(deviceId);

	}

	/**
	 * <p>
	 * The custom runner <code>Parameterized</code> implements parameterized
	 * tests. When running a parameterized test class, instances are created for
	 * the cross-product of the test methods and the test data elements.
	 * </p>
	 * 
	 * For example, to test a Fibonacci function, write:
	 * 
	 * <pre>
	 * &#064;RunWith(Parameterized.class)
	 * public class FibonacciTest {
	 * 	&#064;Parameters
	 * 	public static Collection&lt;Object[]&gt; data() {
	 * 		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
	 * 				{ 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	 * 	}
	 * 
	 * 	private int fInput;
	 * 	private int fExpected;
	 * 
	 * 	public FibonacciTest(int input, int expected) {
	 * 		fInput = input;
	 * 		fExpected = expected;
	 * 	}
	 * 
	 * 	&#064;Test
	 * 	public void test() {
	 * 		assertEquals(fExpected, Fibonacci.compute(fInput));
	 * 	}
	 * }
	 * </pre>
	 * 
	 * <p>
	 * Each instance of <code>FibonacciTest</code> will be constructed using the
	 * two-argument constructor and the data values in the
	 * <code>&#064;Parameters</code> method.
	 * </p>
	 */

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

	@Test
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
		driver = new AndroidDriver();
		/**
		 * 首次打开“首页”
		 */
		driver.get(Const.urlTaobaoOnline);// 线上
		// driver.get(Const.urlPre);//预发
		Thread.sleep(2000);
		Util.record(driver, deviceId);

		/**
		 * 点击 搜索框
		 */
		Util.click(driver, "//INPUT[@id=\"J_searchtext\"]");
		Util.record(driver, deviceId);

		/**
		 * 在搜索框"//FORM/INPUT[1]"输入query keys
		 */
		WebElement e = driver
				.findElementByXPath("//INPUT[@id=\"J_searchtext\"]");
		e.sendKeys("iphone5s");
		Util.record(driver, deviceId);// 搜索下拉推荐
		// e.submit();// 提交搜索
		e.sendKeys(Keys.ENTER);
		/**
		 * 2s等待SRP加载渲染出来
		 */
		Thread.sleep(2000);
		Util.record(driver, deviceId);

		/**
		 * 点击“分类”
		 */
		Util.click(driver, "//SPAN[@id=\"J_selt\"]");
		Thread.sleep(1000);
		Util.record(driver, deviceId);

		/**
		 * 子类目可点击
		 */
		Thread.sleep(1000);
		Util.click(driver, "//LI[1]/H2[1]");
		Util.record(driver, deviceId);

		// //////////////////////////////////////////////////////////////////////////////////

		/**
		 * 打开“首页”
		 */
		driver.get(Const.urlTaobaoOnline);// 线上
		// driver.get(Const.urlPre);//预发
		Thread.sleep(2000);
		Util.record(driver, deviceId);

		/**
		 * 点击 搜索框
		 */
		Util.click(driver, "//INPUT[@id=\"J_searchtext\"]");
		Util.record(driver, deviceId);

		/**
		 * 在搜索框"//FORM/INPUT[1]"输入query keys
		 */
		driver.findElementByXPath("//INPUT[@id=\"J_searchtext\"]").sendKeys(
				"iphone5s");
		Util.record(driver, deviceId);// 搜索下拉推荐
		// e.submit();// 提交搜索
		e.sendKeys(Keys.ENTER);
		/**
		 * 2s等待SRP加载渲染出来
		 */
		Thread.sleep(2000);
		Util.record(driver, deviceId);

		/**
		 * 点击 筛选 //SPAN[@id="J_sift"]
		 */
		Util.click(driver, "//SPAN[@id=\"J_sift\"]");
		Util.record(driver, deviceId);
		/**
		 * 点击 筛选项目
		 */
		Util.click(driver, "//LI[1]/LABEL[1]/INPUT[1]");
		Util.record(driver, deviceId);
		/**
		 * 设定 “最高价”“最低价”
		 */
		driver.findElementByXPath("//DIV[3]/DIV[1]/INPUT[1]").sendKeys("2000");
		driver.findElementByXPath("//DIV[2]/INPUT[1]").sendKeys("4000");

		/**
		 * 点击“确定”
		 */
		Util.click(driver, "//BUTTON[@id=\"J_siftSearchBtn\"]");
		Util.record(driver, deviceId);

		/**
		 * 点击 销量 //DIV[4]/DIV[1]/UL[1]/LI[2]
		 * 
		 */
		Util.click(driver, "//DIV[4]/DIV[1]/UL[1]/LI[2]");
		Util.record(driver, deviceId);

		/**
		 * 点击 价格排序： //DIV[4]/DIV[1]/UL[1]/LI[3]
		 */
		Util.click(driver, "//DIV[4]/DIV[1]/UL[1]/LI[3]");
		Util.record(driver, deviceId);
		/**
		 * 切大图：//DIV[@id="tbh5v0"]/DIV[1]/DIV[4]/DIV[1]/DIV[1]/DIV[1]
		 */
		Util.click(driver,
				"//DIV[@id=\"tbh5v0\"]/DIV[1]/DIV[4]/DIV[1]/DIV[1]/DIV[1]");
		Util.record(driver, deviceId);

		Util.click(driver,
				"//DIV[@id=\"tbh5v0\"]/DIV[1]/DIV[4]/DIV[1]/DIV[1]/DIV[1]");
		Util.record(driver, deviceId);

		Util.click(driver,
				"//DIV[@id=\"tbh5v0\"]/DIV[1]/DIV[4]/DIV[1]/DIV[1]/DIV[1]");
		Util.record(driver, deviceId);
	}

	@After
	public void destroy() {
		Init.destroy(deviceId);
		// driver.quit();
	}

}
