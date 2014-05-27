package ct4h5.config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 东海陈光剑 2014年2月17日 下午7:01:26
 */
public class Const {
	/**
	 * 预发首页地址
	 */
	final public static String urlEtaoPre = "http://wapa.etao.com/?mode=pre#!/entry/index.php?hidepop=true";
	/**
	 * 线上首页地址
	 */
	final public static String urlEtaoOnline = "http://m.etao.com/entry.php?hidepop=true";

	/**
	 * 预发首页地址
	 */
	final public static String urlTaobaoPre = "http://wapa.taobao.com/";
	/**
	 * 线上首页地址
	 */
	final public static String urlTaobaoOnline = "http://m.taobao.com/";

	/**
	 * WebDriver server包的路径
	 */
	final public static String apkPath = "android-server.apk";
	/**
	 * Test类所在的package路径
	 */
	final public static String packageEtaoH5Path = "ct4etaoh5.test";
	final public static String packageEtaoH5PathC = "ct4etaoh5.testc";
	final public static String packageTaobaoH5Path = "ct4taobaoh5.test";
	public static final String reportPath = "http://10.125.1.58:88/h5report.html?run_stamp=";
	public static final String urlLottoryPre = "http://activity.wapa.etao.com/lottery-tenmin.php";
	public static final String upLoadUrl = "http://10.125.1.58:8888/UploadServlet/upload";
	public static final String[] urlsPreEtao = {
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
			"http://wapa.etao.com/?mode=pre#!/youhui/index.php?feedid=26282&hidepop=true" };
	public static final String[] urlsPreTaoBao = {
			"http://daily.m.admin.search.taobao.com/h5?q=%E6%9C%BA%E7%A5%A8",
			"http://daily.m.admin.search.taobao.com/h5?q=%E6%9D%8E%E5%AE%81",
			"http://daily.m.admin.search.taobao.com/h5?q=%E5%BD%A9%E7%A5%A8",
			"http://daily.m.admin.search.taobao.com/h5?q=kindle",
			"http://daily.m.admin.search.taobao.com/h5?q=%E8%A1%A3%E6%9C%8D%20%E5%A5%B3%E8%A3%85&sst=1&m=api4h5&n=20&buying=buyitnow&style=mid&DN=1&atype=1&searchfrom=1",
			"http://daily.m.admin.search.taobao.com/h5?abtestTarget=3&q=%E8%BF%9E%E8%A1%A3%E8%A3%99" };
	public static String timestamp = (new SimpleDateFormat("yyyyMMddhhmmss"))
			.format(new Date());
	/**
	 * 截图保存的路径
	 */
	// public static String photoSavePath = new File("src/test/resources/"
	// + timestamp + "/").getAbsolutePath();

	public static String photoSavePath = "D:/Apache2.2/htdocs/resources/"
			+ timestamp + "/";
	public static String photoSrcPath = "http://127.0.0.1:88/resources/"
			+ timestamp + "/";

	public static StringBuffer report = new StringBuffer("<table border=\"0\">"
			+ "<tr><th width=\"80\" scope=\"col\">deviceId</th>");
	public static String searchOnlineUrl = "http://m.etao.com/#!search_index.php?hidepop=true";
	public static String searchPreUrl = "http://wapa.etao.com/?mode=pre#!/search/index.php?hidepop=true";

	public static String free99OnlineUrl = "http://m.etao.com/index.php#!free99.php?hidepop=true";
	public static String free99PreUrl = "http://wapa.etao.com/?mode=pre#!/free99/index.php?hidepop=true";
	public static String urlTaoBaoPre = "http://s.waptest.taobao.com/search.htm?from=1&q=%E8%BF%9E%E8%A1%A3%E8%A3%99";
}
