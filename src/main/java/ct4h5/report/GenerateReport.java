/**
 * GenerateReport.java ct4h5.util ct4h5 下午8:07:45 2014年3月2日 2014
 */
package ct4h5.report;

import java.io.IOException;
import java.net.MalformedURLException;

import ct4h5.config.Const;

/**
 * @author 东海陈光剑 2014年3月2日 下午8:07:45
 */
public class GenerateReport {

	/**
	 * @param args
	 *            void main
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String run_stamp = "20140302023811";
		genReport(run_stamp);
		// String startReportCmd = "start http://10.73.72.122:88/report.html";
		// Util.excuCmd(startReportCmd);// Cannot run program "start":
		// // CreateProcess error=2

	}

	public static void genReport(String run_stamp) throws IOException {

		// String reportPath = "D:\\Apache2.2\\htdocs\\report.html";
		// /**
		// * 访问http://10.73.72.122:88/report.html
		// */
		// java.net.URL url = new java.net.URL(
		// "http://10.73.72.122:88/report.html");
		// java.io.BufferedReader in = null;
		// try {
		// try {
		// in = new java.io.BufferedReader(new java.io.InputStreamReader(
		// url.openStream()));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// for (String line; (line = in.readLine()) != null;) {
		// System.out.println(line);
		// }
		// } finally {
		// if (in != null) {
		// in.close();
		// }
		// }

		/**
		 * 调用系统默认浏览器打开链接
		 * http://10.73.72.122:88/report.html?run_stamp=20140302023811
		 */
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				String reportUriStr = Const.reportPath + run_stamp;
				// 创建一个URI实例
				java.net.URI reportUri = java.net.URI.create(reportUriStr);

				// String uri1Str =
				// "http://10.73.72.122:8080/Report/go?run_stamp="
				// + run_stamp;
				//
				// java.net.URI uri1 = java.net.URI.create(uri1Str);

				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					// 获取系统默认浏览器打开链接
					dp.browse(reportUri);
					// dp.browse(uri1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// /////////////////////////////////
	}

	public static void genReport(String run_stamp, String runningSec,
			String runningMin) {
		/**
		 * 调用系统默认浏览器打开链接
		 * http://10.73.72.122:88/report.html?run_stamp=20140302023811
		 * &sec=250&min=4
		 */
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				String reportUriStr = Const.reportPath + run_stamp + "&sec="
						+ runningSec + "&min=" + runningMin;
				// 创建一个URI实例
				java.net.URI reportUri = java.net.URI.create(reportUriStr);

				// String uri1Str =
				// "http://10.73.72.122:8080/Report/go?run_stamp="
				// + run_stamp;
				//
				// java.net.URI uri1 = java.net.URI.create(uri1Str);

				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					// 获取系统默认浏览器打开链接
					dp.browse(reportUri);
					// dp.browse(uri1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
