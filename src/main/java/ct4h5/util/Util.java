/**
 * 
 */
package ct4h5.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.ScreenshotException;

import sun.misc.BASE64Decoder;

import com.taobao.sword.android.elements.IAndroidActivity;

import ct4h5.config.Const;
import ct4h5.dao.InsertDB;
import ct4h5.report.GenerateReport;

/**
 * @author 东海陈光剑 2014年2月22日 上午12:16:10
 */
public class Util {

	public static List<String> getDeviceList() {
		// TODO Auto-generated method stub
		Process process = null;
		String strBuff = "";
		String t = "";
		String command = "adb devices";

		try {
			process = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream(), "utf-8"));
			while ((t = br.readLine()) != null) {
				strBuff += t + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * List of devices attached
		 * \nCoolpad5890-a1a1314a\tdevice\nHC34WW907981\tdevice\n\n
		 */
		print(strBuff);

		List<String> deviceList = new ArrayList<String>(5);
		String regex = "[\\n](.*)[\\t]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(strBuff);
		while (matcher.find()) {
			String deviceId = strBuff.substring(matcher.start(), matcher.end());
			deviceId = deviceId.replaceAll("\\s*", "");
			deviceList.add(deviceId);
		}
		return deviceList;
	}

	public static void print(String buff) {
		// TODO Auto-generated method stub
		System.out.println(buff);
	}

	/***********
	 * 根据包名来获取此包下所有的类名及其实例
	 * 
	 * @param packagePath
	 * @return
	 */
	public static List<String> getClassInPackage(String packagePath) {
		List<String> classList = new ArrayList(5);
		String packageName = packagePath;
		String packageDirName = packageName.replace(".", "/");
		Enumeration<URL> dirs = null;
		try {
			dirs = Thread.currentThread().getContextClassLoader()
					.getResources(packageDirName);
			// 迭代此 Enumeration
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				File file = new File(url.getFile());
				// 把此目录下的所有文件列出
				String[] classes = file.list();
				// 循环此数组，并把.class去掉 ".class".length() = 6
				for (String className : classes) {
					className = className.substring(0, className.length() - 6);
					classList.add(className);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classList;
	}

	public static void record(AndroidDriver driver, String deviceId)
			throws InterruptedException {
		/**
		 * 考虑到页面加载的时间，线程延时2s
		 */
		printTitle(driver, deviceId);
		sleep();
		screenShot(driver, deviceId);
	}

	public static void sleep() {
		for (int i = 0; i < 1e9; i++) {
		}
	}

	/**
	 * @param driver
	 * @param deviceId
	 */
	public static void printTitle(AndroidDriver driver, String deviceId) {
		System.out.println(deviceId + " | " + driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	public static void printTitle(AndroidDriver driver) {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	/**
	 * @param driver
	 * @param xPath
	 * @throws InterruptedException
	 */
	public static void click(AndroidDriver driver, String xPath)
			throws InterruptedException {
		driver.findElement(By.xpath(xPath)).click();
		// driver.wait();// 报错：java.lang.IllegalMonitorStateException
		sleep();
	}

	/**
	 * 截图
	 * 
	 * @param driver
	 * @param imgFullPathName
	 */
	public static void takeScreenShot(WebDriver driver, String imgFullPathName) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(imgFullPathName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发生异常截图
	 * 
	 * @param e
	 * @return
	 */
	public String extractScreenShot(WebDriverException e) {
		Throwable cause = e.getCause();
		if (cause instanceof ScreenshotException) {
			return ((ScreenshotException) cause).getBase64EncodedScreenshot();
		}
		return null;
	}

	/**
	 * 将Base64转换成图片
	 * 
	 * @param activity
	 * @param url
	 * @return
	 */

	/**
	 * >adb -s <deviceID> shell /system/bin/screencap -p /sdcard/screenshot.png
	 * >adb -s <deviceID> pull /sdcard/screenshot.png d:/screenshot.png 2990
	 * KB/s (382785 bytes in 0.125s)
	 * 
	 * @param driver
	 * @param deviceId
	 * @return
	 */
	public static boolean GenerateImage(AndroidDriver driver, String deviceId) {// 对字节数组字符串进行Base64解码并生成图片
		String url = driver.getCurrentUrl();
		System.out.println("AndroidDriver 截图 | " + url);
		String imgStr = driver.getScreenshotAs(OutputType.BASE64);
		/**
		 * 这里记得加上"/"目录标示符
		 */
		File fp = new File(Const.photoSavePath);
		if (!fp.isDirectory())
			fp.mkdirs();

		String imgPath = Const.photoSavePath + "/" + deviceId;
		File f = new File(imgPath);
		if (!f.isDirectory())
			f.mkdirs();
		if (!imgPath.endsWith("/"))
			imgPath += "/";

		String timeChamp = (new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss"))
				.format(new Date());
		/**
		 * url(去除非法字符)+时间戳 命名图片
		 */
		String imgName = url.replaceAll("[\\/:*?\"<>|!#]", "") + "_"
				+ timeChamp + "_driver.jpeg";
		if (imgStr == null)
			// 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			f = new File(imgPath);
			if (!f.isDirectory())
				f.mkdirs();
			if (!imgPath.endsWith("/"))
				imgPath += "/";
			String imgFullPathName = imgPath + imgName;

			OutputStream out = new FileOutputStream(imgFullPathName);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean GenerateImage(AndroidDriver driver) {
		// 对字节数组字符串进行Base64解码并生成图片
		String url = driver.getCurrentUrl();
		System.out.println("截图 | " + url);
		String imgStr = driver.getScreenshotAs(OutputType.BASE64);
		String imgPath = Const.photoSavePath + "/";
		String timeChamp = (new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss"))
				.format(new Date());
		/**
		 * url(去除非法字符)+时间戳 命名图片
		 */
		String imgName = url.replaceAll("[\\/:*?\"<>|]", "") + "-" + timeChamp
				+ ".jpeg";
		if (imgStr == null)
			// 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			File f = new File(imgPath);
			if (!f.isDirectory())
				f.mkdir();
			if (!imgPath.endsWith("/"))
				imgPath += "/";
			String imgFullPathName = imgPath + imgName;
			OutputStream out = new FileOutputStream(imgFullPathName);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "restriction", "unused" })
	public static boolean screenShot(AndroidDriver driver, String deviceId) {// 对字节数组字符串进行Base64解码并生成图片

		/**
		 * 这里记得加上"/"目录标示符
		 */
		File fp = new File(Const.photoSavePath);
		if (!fp.isDirectory())
			fp.mkdirs();

		String url = driver.getCurrentUrl();
		System.out.println("adb screenShot 截图 | " + url);
		// String imgStr = driver.getScreenshotAs(OutputType.BASE64);
		String imgPath = Const.photoSavePath + "/" + deviceId;
		File f = new File(imgPath);
		if (!f.isDirectory())
			f.mkdirs();
		if (!imgPath.endsWith("/"))
			imgPath += "/";

		String timeChamp = (new SimpleDateFormat("yyyyMMddhhmmss"))
				.format(new Date());
		/**
		 * url(去除非法字符)+时间戳 命名图片
		 */

		String imgName = Const.timestamp + "$" + deviceId + "$" + timeChamp
				+ "$" + url.replaceAll("[\\/%:*?\"<>|!#]", "") + "_"
				+ timeChamp + ".jpeg";

		String imgFullPathName = imgPath + imgName;
		String imgSrcPath = Const.photoSrcPath + deviceId + "/" + imgName;

		InsertDB.insert(Const.timestamp, url, imgName, deviceId, timeChamp);

		/**
		 * screencap >adb -s <deviceID> shell /system/bin/screencap -p
		 * /sdcard/screenshot.png >adb -s <deviceID> pull /sdcard/screenshot.png
		 * d:/screenshot.png
		 */
		String screencapCmd = "adb -s " + deviceId
				+ " shell /system/bin/screencap -p  /sdcard/screenshot.png";
		String pullScreenShotCmd = "adb -s " + deviceId
				+ " pull /sdcard/screenshot.png " + imgFullPathName;
		String rmScreenShotCmd = "rm -f /sdcard/screenshot.png";
		// adb -s <deviceID> shell /system/bin/screencap -p
		// sdcard/screenshot.png
		excuCmd(screencapCmd);// use adb shell /system/bin/screencap
		excuCmd(pullScreenShotCmd);

		// driver.getScreenshotAs(OutputType.FILE);
		String href_imgFullPathName = imgPath + "_href_" + imgName;
		takeScreenShot(driver, href_imgFullPathName);

		/**
		 * upload img to server <img src=
		 * "http://10.125.1.58:88/img/20140527015503$096b3760$20140527015734$httpwapa.etao.commode=preentryindex.phphidepop=true_20140527015734.jpeg"
		 */
		// upload server
		FileUpload fu = new FileUpload();

		try {
			fu.send(Const.upLoadUrl, imgFullPathName);
			fu.send(Const.upLoadUrl, href_imgFullPathName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// excuCmd(rmScreenShotCmd);

		return true;

	}

	public static void excuCmd(String cmd) {
		System.out.println("$" + cmd);
		Process process = null;
		String buff = "";
		try {

			/**
			 * adb -s HC34WW907981 install
			 * D:/Android/test/taobao_android.sword.signed.apk
			 */
			process = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream(), "utf-8"));
			while ((buff = br.readLine()) != null) {
				Util.print(buff);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param e
	 */
	public static void install(String deviceId) {
		String cmdInstall = "adb -s " + deviceId + " install -r "
				+ Const.apkPath;
		Util.excuCmd(cmdInstall);

	}
}
