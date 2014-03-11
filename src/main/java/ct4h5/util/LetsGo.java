package ct4h5.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.locks.Lock;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import ct4h5.config.Const;

/**
 * @author 东海陈光剑 2014年2月19日 下午10:29:27
 */
public class LetsGo implements Runnable {
	public static void main(String[] args) {
		List<String> deviceList = Util.getDeviceList();
		for (String e : deviceList) {
			(new Thread(new LetsGo(e))).start();
		}
	}

	public LetsGo(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @param deviceId
	 * @param lock
	 */
	public LetsGo(String deviceId, Lock lock) {
		super();
		this.deviceId = deviceId;
		this.lock = lock;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		long startTime = System.currentTimeMillis();
		// lock.lock();
		try {
			// uninstall(this.deviceId, Const.packageSigned);
			// uninstall(this.deviceId, Const.packageTest);
			install(this.deviceId, Const.apkPath);
			// install(this.deviceId, Const.apkTestPath);
			//
			// for (String s : Util.getClassInPackage("compatibility.test")) {
			// if (s.endsWith("Test")) {
			// runClass(this.deviceId, "compatibility.test." + s);
			// Thread.sleep(1000);
			// }
			// }
		} catch (Exception e) {
		}
		// lock.unlock();
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;

		System.out.println(Thread.currentThread() + " | 卸载安装 | "
				+ this.deviceId + " | Running time : " + runTime / 1000
				+ " seconds (" + runTime / 1000 / 60 + " minutes.)");
	}

	/**
	 * 安装android-server.apk
	 * 
	 * @param devName
	 * @param apkAddress
	 */
	private static void install(String devName, String apkAddress) {
		Util.print(devName + " Installing " + apkAddress + "...");
		String cmd = "adb -s " + devName + " install -r " + apkAddress;
		Util.excuCmd(cmd);
	}

	/**
	 * @param packageName
	 */
	private static void uninstall(String deviceName, String packageName) {
		// TODO Auto-generated method stub
		Util.print(deviceName + " Uninstalling " + packageName + "...");
		Process process = null;
		String buff = "";
		try {
			/**
			 * adb -s HC34WW907981 uninstall com.taobao.taobao.sword.test
			 */
			process = Runtime.getRuntime().exec(
					"adb -s " + deviceName + " uninstall " + packageName);
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

	String deviceId;
	Lock lock;

}
