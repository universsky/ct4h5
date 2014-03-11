/**
 * 
 */
package ct4h5.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * @author 东海陈光剑 2014年2月22日 上午12:30:29
 */
public class EventListener extends AbstractWebDriverEventListener {
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String dateString = formatter.format(new Date());
		// String imgDir = System.getProperty("user.dir");
		String imgDir = "D:/Android/ct4h5/img/";
		// System.out.println("imgDir::"+imgDir);
		try {
			// 截图并保存在D盘下
			File screenShotFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File(imgDir + dateString
					+ ".jpg"));
			// System.out.println("开始截图");
		} catch (IOException e) {
			System.out.println("Fail to capture screenshot:" + e.getMessage());
		}
	}

	private String generateRandomFilename(Throwable ex) {
		Calendar c = Calendar.getInstance();
		String filename = ex.getMessage();
		int i = filename.indexOf('\n');
		filename = filename.substring(0, i).replaceAll("\\s", "_")
				.replaceAll(":", "")
				+ ".png";
		filename = "" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH)
				+ "-" + c.get(Calendar.DAY_OF_MONTH) + "-"
				+ c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE)
				+ "-" + c.get(Calendar.SECOND) + "-" + filename;
		return filename;
	}

	private String extractScreenShot(Throwable ex) {
		Throwable cause = ex.getCause();
		if (cause instanceof ScreenshotException) {
			return ((ScreenshotException) cause).getBase64EncodedScreenshot();
		}
		return null;
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {

	}

}