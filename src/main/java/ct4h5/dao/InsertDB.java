package ct4h5.dao;

import java.sql.*;

import org.testng.internal.remote.SlavePool;

public class InsertDB {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			insert("2", "2", "2", "2", "2");
	}

	public static boolean insert(String timestamp, String url, String imgName,
			String deviceId, String imgTimeChamp) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://10.125.1.58:3306/test", "root", "isword");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();
			// String insertCmd = "insert into ct_pic  values(" + "\'" +
			// timestamp
			// + "\'" + "," + "\'" + deviceId + "\'" + "," + "\'"
			// + imgName + "\'" + "," + "\'" + url + "\'" + ")";
			String insertCmd = "INSERT INTO ct_pic(run_stamp,device_id,img_name,url,img_timestamp)"
					+ " VALUES ("
					+ "'"
					+ timestamp
					+ "',"
					+ "'"
					+ deviceId
					+ "',"
					+ "'"
					+ imgName
					+ "',"
					+ "'"
					+ url
					+ "','"
					+ imgTimeChamp + "')";
			System.out.println(insertCmd);
			boolean rs = stmt.execute(insertCmd);
			return rs;
			// while (rs.next()) {
			// System.out.println(rs.getString("img_name"));
			// }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

// GRANT ALL ON *.* TO root@"%" IDENTIFIED BY isword;