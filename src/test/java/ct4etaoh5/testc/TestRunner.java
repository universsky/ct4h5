package ct4etaoh5.testc;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import ct4h5.Install;
import ct4h5.Uninstall;
import ct4h5.config.Const;
import ct4h5.report.GenerateReport;
import ct4h5.util.LThread;
import ct4h5.util.Util;

/**
 * Multi-Thread
 * 
 * @author 东海陈光剑 2014年2月17日 下午8:58:02
 */
public class TestRunner {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		for (;;)
			Go();

	}

	private static void Go() {
		long start = System.currentTimeMillis();
		multiThreadRunTraverseUrlsTest();
		multiThreadRunNineTest();
		multiThreadRunSearchTest();
		long end = System.currentTimeMillis();
		report(start, end);

	}

	private static void multiThreadRunTraverseUrlsTest() {
		// long start = System.currentTimeMillis();
		int threadNum = Util.getDeviceList().size();
		System.out.println(Thread.currentThread().getName() + "开始");// 打印开始标记

		for (int index = 0, pcPort = 8080; index < threadNum; index++, pcPort++) {
			String device = Util.getDeviceList().get(index);
			Runnable target = new TraverseUrlsTest(device, pcPort);
			Thread thread = new LThread(target);
			thread.start();
		}

		while (true) {// 等待所有子线程执行完
			if (!LThread.hasThreadRunning()) {
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束.");// 打印结束标记
		// long end = System.currentTimeMillis();
		// report(start, end);
	}

	private static void multiThreadRunNineTest() {
		// long start = System.currentTimeMillis();
		int threadNum = Util.getDeviceList().size();
		System.out.println(Thread.currentThread().getName() + "开始");// 打印开始标记

		for (int index = 0, pcPort = 8080; index < threadNum; index++, pcPort++) {
			String device = Util.getDeviceList().get(index);
			Runnable target = new NineTest(device, pcPort);
			Thread thread = new LThread(target);
			thread.start();
		}

		while (true) {// 等待所有子线程执行完
			if (!LThread.hasThreadRunning()) {
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束.");// 打印结束标记
		// long end = System.currentTimeMillis();
		// report(start, end);

	}

	private static void multiThreadRunSearchTest() {
		// long start = System.currentTimeMillis();
		int threadNum = Util.getDeviceList().size();
		System.out.println(Thread.currentThread().getName() + "开始");// 打印开始标记

		for (int index = 0, pcPort = 8080; index < threadNum; index++, pcPort++) {
			String device = Util.getDeviceList().get(index);
			Runnable target = new SearchTest(device, pcPort);
			Thread thread = new LThread(target);
			thread.start();
		}

		while (true) {// 等待所有子线程执行完
			if (!LThread.hasThreadRunning()) {
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束.");// 打印结束标记
		// long end = System.currentTimeMillis();
		// report(start, end);

	}

	/**
	 * @throws Exception
	 * 
	 */
	private static void run() throws Exception {
		long start = System.currentTimeMillis();
		runTestCases();
		long end = System.currentTimeMillis();
		report(start, end);

	}

	private static void report(long start, long end) {
		System.out.println("Running Time: " + (end - start) / 1000 + " s"
				+ "( " + (end - start) / 1000 / 60 + " min )");
		System.out.println("Run timestamp:" + Const.timestamp);

		String runningSec = (end - start) / 1000 + "";
		String runningMin = (end - start) / 1000 / 60 + "";
		// String startReportCmd = "start http://10.73.72.122:88/report.html";
		// Util.excuCmd(startReportCmd);
		GenerateReport.genReport(Const.timestamp, runningSec, runningMin);

	}

	/**
	 * @throws Exception
	 * 
	 */
	private static void runTestCases() throws Exception {
		List<String> classList = Util
				.getClassInPackage(Const.packageEtaoH5Path);
		for (String c : classList) {
			if (c.endsWith("Test")) {
				runClass(c);
			}
		}

	}

	public static void runClass(String className) throws Exception {

		String fullClassName = Const.packageEtaoH5PathC + "." + className;
		Class<?> c = Class.forName(fullClassName);

		long start = System.currentTimeMillis();

		for (Failure failure : JUnitCore.runClasses(c).getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(JUnitCore.runClasses(c).wasSuccessful());

		long end = System.currentTimeMillis();
		System.out.println(fullClassName + " | Running Time: " + (end - start)
				/ 1000 + " s" + "( " + (end - start) / 1000 / 60 + " min )");
	}

	/**
	 * 多线程执行安装android-server.apk
	 */
	private static void install() {
		for (String e : Util.getDeviceList()) {
			(new Thread(new Install(e))).start();
		}

	}

	/**
	 * 多线程执行安装android-server.apk
	 */
	private static void uninstall() {
		for (String e : Util.getDeviceList()) {
			(new Thread(new Uninstall(e))).start();
		}

	}

}
