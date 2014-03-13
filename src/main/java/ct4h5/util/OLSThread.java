/**
 * OLSThread.java ct4h5.util ct4h5 上午12:08:01 2014年3月14日 2014
 */
package ct4h5.util;

import ct4etaoh5.testc.TraverseUrlsTest;

/**
 * @author 东海陈光剑 2014年3月14日 上午12:08:01
 */
public class OLSThread extends Thread {

	public OLSThread() {
	}

	/**
	 * 
	 * @param c
	 * @param traverseUrlsTest
	 */
	public OLSThread(MyCountDown c, Runnable runnable) {
		this.countDown = c;
		this.runnable = runnable;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始...");// 打印开始标记
		// Do something
		countDown.countDown();// 计时器减1
		(new Thread(runnable)).start();
		System.out.println(Thread.currentThread().getName() + "结束. 还有"
				+ countDown.getCount() + " 个线程");// 打印结束标记
	}

	private MyCountDown countDown;
	private Runnable runnable;

}
