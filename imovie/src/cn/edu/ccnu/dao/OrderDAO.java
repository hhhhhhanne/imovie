package cn.edu.ccnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.entity.Order;

public class OrderDAO {
	public static List<Order> getOrdersByName(int uid){
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from [order] where uid = ? order by createDateTime desc";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);

		try {
			ResultSet res = Connect.executeQuery(sql, params);
			while (res.next()) {
				Order c = new Order();
				c.setUid(res.getInt("uid"));
				c.setContent(res.getString("content"));
				c.setCreateDatetime(res.getTimestamp("createDateTime"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return list;
		
	}
	
	
	public static void addOrder(Order order) {
		String sql = "insert into [order] values(?,?,getdate())";
		List<Object> params = new ArrayList<Object>();
		params.add(order.getUid());
		params.add(order.getContent());
		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
	}
	
}
