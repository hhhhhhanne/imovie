package cn.edu.ccnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.entity.Movie;

public class MovieDAO {
	public static List<Movie> getMovieMultiByName(String name){
		List<Movie> list = new ArrayList<Movie>();
		String sql = "select * from movie_info where name like ?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);

		try {
			ResultSet res = Connect.executeQuery(sql, params);
			while (res.next()) {
				Movie m = new Movie();
				m.setMid(res.getInt("mid"));
				m.setName(res.getString("name"));
				m.setNickname(res.getString("nickname"));
				m.setDirector(res.getString("director"));
				m.setCountry(res.getString("country"));
				m.setType(CodeDAO.getValue("mtype", res.getString("mtype")));
				m.setYear(res.getString("myear"));
				m.setSummary(res.getString("msummary"));
				m.setSub(res.getInt("sub"));
				m.setSup(res.getInt("sup"));
				m.setImgurl(res.getString("imgurl"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return list;
		
	}
	
	public static Movie getMovieById(String mid) {
		Movie m = new Movie();
		String sql = "select * from movie_info where mid =?";
		List<Object> params = new ArrayList<Object>();
		params.add(mid);

		try {
			ResultSet res = Connect.executeQuery(sql, params);
			if (res.next()) {
				m.setMid(res.getInt("mid"));
				m.setName(res.getString("name"));
				m.setNickname(res.getString("nickname"));
				m.setDirector(res.getString("director"));
				m.setCountry(res.getString("country"));
				m.setType(CodeDAO.getValue("mtype", res.getString("mtype")));
				m.setYear(res.getString("myear"));
				m.setSummary(res.getString("msummary"));
				m.setSub(res.getInt("sub"));
				m.setSup(res.getInt("sup"));
				m.setImgurl(res.getString("imgurl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}

		return m;
	}
}
