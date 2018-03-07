package cn.edu.ccnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeDAO {
	public static String getValue(String name, String code) {
		String sql = "select * from sys_code where name =? and code=?";
		String val = null;
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(code);
		try {
			ResultSet res = Connect.executeQuery(sql, params);
			if (res.next()) {
				val = res.getString("value");
			} else {
				val = code;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return val;
	}

	public static HashMap<String, String> getKeyValue(String name) {
		HashMap<String, String> map = new HashMap<String, String>();
		String sql = "select * from sys_code where name =?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		try {
			ResultSet res = Connect.executeQuery(sql, params);
			while (res.next()) {
				map.put(res.getString("code"), res.getString("value"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return map;
	}
}
