/**
 * LThread.java ct4h5.util ct4h5 上午12:46:48 2014年3月14日 2014
 */
package ct4h5.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 东海陈光剑 2014年3月14日 上午12:46:48
 */
public class LThread extends Thread {

	private static List<Thread> runningThreads = new ArrayList<Thread>();
	Runnable t;

	public LThread() {
	}

	public LThread(Runnable t) {
		this.t = t;
	}

	@Override
	public void run() {
		regist(this);// 线程开始时注册
		System.out.println(Thread.currentThread().getName() + "开始...");// 打印开始标记
		// run target
		if (t != null) {
			t.run();
		}
		unRegist(this);// 线程结束时取消注册
		System.out.println(Thread.currentThread().getName() + "结束.");// 打印结束标记
	}

	public void regist(Thread t) {
		synchronized (runningThreads) {
			runningThreads.add(t);
		}
	}

	public void unRegist(Thread t) {
		synchronized (runningThreads) {
			runningThreads.remove(t);
		}
	}

	public static boolean hasThreadRunning() {
		return (runningThreads.size() > 0);// 通过判断runningThreads是否为空就能知道是否还有线程未执行完
	}
}
