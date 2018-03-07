package cn.edu.ccnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.entity.User;

public class UserDAO {

	public static User getUser(String username) {
		User user = new User();
		String sql = "select * from sys_user where username =?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);

		try {
			ResultSet res = Connect.executeQuery(sql, params);
			if (res.next()) {
				user.setUid(res.getInt("uid"));
				user.setUsername(res.getString("username"));
				user.setEmail(res.getString("email"));
				user.setMobile(res.getString("mobile"));
				user.setPasswd(res.getString("passwd"));
				user.setAddress(res.getString("address"));
				user.setExpiresIn(res.getDate("expires_in"));
				user.setSalt(res.getInt("salt"));
				user.setAccessToken(res.getString("access_token"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return user;
	}

	public static void addUser(User user) {
		String sql = "insert into sys_user(username,email,mobile,passwd,address,salt,expires_in,access_token)";
		sql += "values(?,?,?,?,?,?,getdate(),?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getEmail());
		params.add(user.getMobile());
		params.add(user.getPasswd());
		params.add(user.getAddress());
		params.add(user.getSalt());
		params.add(user.getAccessToken());
		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
	}

	public static void updateAccessToken(String expires, String token, int uid) {
		String sql = "update sys_user set expires_in =convert(datetime,?,21), access_token=? where  uid =?";
		List<Object> params = new ArrayList<Object>();
		params.add(expires);
		params.add(token);
		params.add(uid);
		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			Connect.close();
			e.printStackTrace();
		}
	}
}
