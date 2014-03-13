/**
 * MyCountDown.java ct4h5.util ct4h5 上午12:06:19 2014年3月14日 2014
 */
package ct4h5.util;

/**
 * @author 东海陈光剑 2014年3月14日 上午12:06:19
 */
public class MyCountDown {

	/**
	 * 
	 */
	public MyCountDown() {
	}

	private int count;

	public MyCountDown(int count) {
		this.count = count;
	}

	public synchronized void countDown() {
		count--;
	}

	public synchronized boolean hasNext() {
		return (count > 0);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
