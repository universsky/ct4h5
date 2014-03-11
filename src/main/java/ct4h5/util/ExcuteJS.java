/**
 * ExcuteJS.java ct4h5.util ct4h5 下午7:01:37 2014年3月2日 2014
 */
package ct4h5.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author 东海陈光剑 2014年3月2日 下午7:01:37
 */
public class ExcuteJS {
	public static String test() throws Exception {
		// 读取JS文件
		BufferedReader buf = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("report.js"))));
		// 调用js。。这里是关键 啊
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		ScriptEngine js = scriptManager.getEngineByExtension("js");
		// 执行JS
		js.eval(buf);
		Invocable inv = (Invocable) js;
		// p1的获取 执行js中的方法
		String p = (String) inv.invokeFunction("report");
		return p;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(test());
	}

}
