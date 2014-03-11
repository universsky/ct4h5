package ct4etaoh5.test;

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
@RunWith(Parameterized.class)
public class NineTest extends TestCase {
	String deviceId;
	AndroidDriver driver;

	public NineTest(String deviceId) {
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
	public void testNine() throws Exception {
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

		// String[] c = { "_m_h5_tk",
		// "1bd4e8d6d8d5495cc98898818056be0e_1393315222267",
		// "m_h5_tk_enc", "f3154d21b657a0761365e37d99fc40e2",
		// "_tb_token_", "zgJ8isqEVLXF", "added", "true", "cna",
		// "G6dTC3v8hWICASp4SvKiiLvX", "cookie2",
		// "4d48508c8c23d78cafa7249818e4495c", "swiped", "swiped", "t",
		// "5937a2a26537de54a572d04c3cbd5cb9" };
		//
		// driver.manage().addCookie(
		// new Cookie("_m_h5_tk",
		// "1bd4e8d6d8d5495cc98898818056be0e_1393315222267"));
		// driver.manage().addCookie(
		// new Cookie("m_h5_tk_enc", "f3154d21b657a0761365e37d99fc40e2"));
		// driver.manage().addCookie(new Cookie("_tb_token_", "zgJ8isqEVLXF"));
		// driver.manage().addCookie(new Cookie("added", "true"));
		// driver.manage()
		// .addCookie(new Cookie("cna", "G6dTC3v8hWICASp4SvKiiLvX"));
		// driver.manage().addCookie(
		// new Cookie("cookie2", "4d48508c8c23d78cafa7249818e4495c"));
		// driver.manage().addCookie(new Cookie("swiped", "swiped"));
		// driver.manage().addCookie(
		// new Cookie("t", "5937a2a26537de54a572d04c3cbd5cb9"));
		// for (int i = 0; i < c.length - 1; i += 2) {
		// driver.manage().addCookie(new Cookie(c[i], c[i + 1]));
		// }
		// Set<Cookie> cookies = driver.manage().getCookies();
		// System.out.println(cookies);
		// driver.manage().addCookie(new Cookie("swiped", "swiped"));
		// driver.manage().addCookie(new Cookie("path", "/"));
		// driver.manage().addCookie(new Cookie("domain", "http"));
		/**
		 * 打开首页
		 */
		driver.get(Const.urlEtaoOnline);// 线上
		// driver.get(Const.urlPre); // 预发

		Util.record(driver, deviceId);

		// /**
		// * 关闭首页pop浮层:有时候会直接出发点击到了搜索icon,跳到搜索页了
		// */
		Util.click(driver, "//A[3]");
		Util.record(driver, deviceId);
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size() + " | " + cookies);
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		// driver.get(Const.urlOnline);
		// driver.get(Const.urlPre);// 这样会直接导致webdriver退出 ？
		/* 以上是公共启动区域 */
		// //////////////////////////////////////////////////////////
		/**
		 * 点击9.9包邮,进入Goods Grid List页
		 */
		Util.click(driver, "//DIV[1]/UL[1]/LI[3]/A[1]/IMG[1]");
		// driver.get("http://wapa.etao.com/index.php#!free99.php");
		// driver.get("http://m.etao.com/index.php#!free99.php");
		/**
		 * 考虑加载数据，渲染页面时间
		 */
		Thread.sleep(5000);
		Util.record(driver, deviceId);

		/**
		 * 点击页面上的“返回”回到首页
		 */
		Util.click(driver, "//A[@id=\"J_Back\"]/B[1]");
		Util.record(driver, deviceId);

		/**
		 * 点击9.9包邮,进入Goods Grid List页
		 */
		Util.click(driver, "//DIV[1]/UL[1]/LI[3]/A[1]/IMG[1]");
		// driver.get("http://wapa.etao.com/index.php#!free99.php");
		// driver.get("http://m.etao.com/index.php#!free99.php");
		/**
		 * 考虑加载数据，渲染页面时间
		 */
		Thread.sleep(5000);
		Util.record(driver, deviceId);

		/**
		 * 点击“下一页” //DIV[@id="free99_list"]/DIV[1]/A[2]
		 */
		Util.click(driver, "//DIV[@id=\"free99_list\"]/DIV[1]/A[2]");
		Thread.sleep(3000);
		Util.record(driver, deviceId);
		assert (driver.findElementByXPath(
				"//DIV[@id=\"free99_list\"]/DIV[1]/A[2]").getText()
				.contains("下一页"));

	}

	@After
	public void destroy() {
		Init.destroy(deviceId);
		// driver.quit();
	}

}
