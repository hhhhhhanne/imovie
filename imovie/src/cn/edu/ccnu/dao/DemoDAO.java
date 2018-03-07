package cn.edu.ccnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.entity.Demo;

public class DemoDAO {

	public static Demo getDemoById(String id) {
		Demo demo = new Demo();
		String sql = "select * from demo where id =?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);

		try {
			ResultSet res = Connect.executeQuery(sql, params);
			if (res.next()) {
				demo.setId(res.getString("id"));
				demo.setName(res.getString("name"));
				demo.setPrice(res.getFloat("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return demo;
	}

	public static List<Demo> getDemoMultiByName(String name) {
		List<Demo> demoList = new ArrayList<Demo>();
		String sql = "select * from demo where name like ?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);

		try {
			ResultSet res = Connect.executeQuery(sql, params);
			while (res.next()) {
				Demo demo = new Demo();
				demo.setId(res.getString("id"));
				demo.setName(res.getString("name"));
				demo.setPrice(res.getFloat("price"));
				demoList.add(demo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return demoList;
	}

	public static void updateDemoById(Demo newDemo, String id) {
		String sql = "update demo set id=?,name=?,price=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(newDemo.getId());
		params.add(newDemo.getName());
		params.add(newDemo.getPrice());
		params.add(id);
		
		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
	}

	public static void delDemoById(String id) {
		String sql = "delete demo where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);

		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
	}

	public static void addDemo(Demo demo) {
		String sql = "insert into demo values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(demo.getId());
		params.add(demo.getName());
		params.add(demo.getPrice());

		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
	}
}
