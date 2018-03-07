package cn.edu.ccnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.entity.V_Movie_Cinema;

public class V_Movie_CinemaDAO {
	public static List<V_Movie_Cinema> getVMCMultiByMovie(String movie) {
		List<V_Movie_Cinema> list = new ArrayList<V_Movie_Cinema>();
		String sql = "select * from v_movie_cinema where movie =?";
		List<Object> params = new ArrayList<Object>();
		params.add(movie);
		try {
			ResultSet res = Connect.executeQuery(sql, params);
			while (res.next()) {
				V_Movie_Cinema m = new V_Movie_Cinema();
				m.setMid(res.getInt("mid"));
				m.setMovie(res.getString("movie"));
				m.setCid(res.getInt("cid"));
				m.setCinema(res.getString("cinema"));
				m.setPrice(res.getBigDecimal("price"));
				m.setMptype(CodeDAO.getValue("mptype", res.getString("mptype")));
				m.setCrid(res.getInt("crid"));
				m.setSeatX(res.getInt("seat_x"));
				m.setSeatY(res.getInt("seat_y"));
				m.setRoomname(res.getString("roomname"));
				m.setStatu(CodeDAO.getValue("statu", res.getString("statu")));
				m.setStarttime(res.getString("starttime"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
		return list;
	}

	public static List<V_Movie_Cinema> getVMCMultiByCinema(String cinema) {
		List<V_Movie_Cinema> list = new ArrayList<V_Movie_Cinema>();
		String sql = "select * from v_movie_cinema where cinema =?";
		List<Object> params = new ArrayList<Object>();
		params.add(cinema);
		try {
			ResultSet res = Connect.executeQuery(sql, params);
			while (res.next()) {
				V_Movie_Cinema m = new V_Movie_Cinema();
				m.setMid(res.getInt("mid"));
				m.setMovie(res.getString("movie"));
				m.setCid(res.getInt("cid"));
				m.setCinema(res.getString("cinema"));
				m.setPrice(res.getBigDecimal("price"));
				m.setMptype(CodeDAO.getValue("mptype", res.getString("mptype")));
				m.setCrid(res.getInt("crid"));
				m.setSeatX(res.getInt("seat_x"));
				m.setSeatY(res.getInt("seat_y"));
				m.setRoomname(res.getString("roomname"));
				m.setStatu(CodeDAO.getValue("statu", res.getString("statu")));
				m.setStarttime(res.getString("starttime"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
		return list;
	}

	public static V_Movie_Cinema getMovieById(int movie_id, int cinema_id,
			int room_id) {
		V_Movie_Cinema m = new V_Movie_Cinema();
		String sql = "select * from v_movie_cinema where mid =? and cid = ? and crid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(movie_id);
		params.add(cinema_id);
		params.add(room_id);
		try {
			ResultSet res = Connect.executeQuery(sql, params);
			if (res.next()) {
				m.setMid(res.getInt("mid"));
				m.setMovie(res.getString("movie"));
				m.setCid(res.getInt("cid"));
				m.setCinema(res.getString("cinema"));
				m.setPrice(res.getBigDecimal("price"));
				m.setMptype(CodeDAO.getValue("mptype", res.getString("mptype")));
				m.setCrid(res.getInt("crid"));
				m.setSeatX(res.getInt("seat_x"));
				m.setSeatY(res.getInt("seat_y"));
				m.setRoomname(res.getString("roomname"));
				m.setStatu(CodeDAO.getValue("statu", res.getString("statu")));
				m.setStarttime(res.getString("starttime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
		return m;
	}

	public static List<V_Movie_Cinema> getCinemaInfoById(int movie_id) {
		List<V_Movie_Cinema> list = new ArrayList<V_Movie_Cinema>();
		StringBuffer sb = new StringBuffer();
		sb.append("select cid,cinema,mid,movie,price,mptype,starttime,roomname ");
		sb.append("from v_movie_cinema where mid = ? ");
		sb.append("group by cid,cinema,mid,movie,price,mptype,starttime,roomname");
		List<Object> params = new ArrayList<Object>();
		params.add(movie_id);
		try {
			ResultSet res = Connect.executeQuery(sb.toString(), params);
			while (res.next()) {
				V_Movie_Cinema m = new V_Movie_Cinema();
				m.setMid(res.getInt("mid"));
				m.setMovie(res.getString("movie"));
				m.setCid(res.getInt("cid"));
				m.setCinema(res.getString("cinema"));
				m.setPrice(res.getBigDecimal("price"));
				m.setMptype(CodeDAO.getValue("mptype", res.getString("mptype")));
				m.setRoomname(res.getString("roomname"));
				m.setStarttime(res.getString("starttime"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
		return list;
	}

	public static List<V_Movie_Cinema> getSeatInfoById(int movie_id,
			int cinema_id) {
		List<V_Movie_Cinema> list = new ArrayList<V_Movie_Cinema>();
		StringBuffer sb = new StringBuffer();
		sb.append("select crid,seat_x,seat_y,statu ");
		sb.append("from v_movie_cinema ");
		sb.append("where mid = ? and cid = ?  order by seat_x");
		List<Object> params = new ArrayList<Object>();
		params.add(movie_id);
		params.add(cinema_id);
		try {
			ResultSet res = Connect.executeQuery(sb.toString(), params);
			while (res.next()) {
				V_Movie_Cinema m = new V_Movie_Cinema();
				m.setCrid(res.getInt("crid"));
				m.setSeatX(res.getInt("seat_x"));
				m.setSeatY(res.getInt("seat_y"));
				m.setStatu(res.getString("statu"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
		return list;
	}

	public static boolean isFreeSeatById(int movie_id, int cinema_id,
			int room_id) {
		String sql = "select * from v_movie_cinema where mid =? and cid = ? and crid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(movie_id);
		params.add(cinema_id);
		params.add(room_id);
		boolean isfree = false;
		try {
			ResultSet res = Connect.executeQuery(sql, params);
			if (res.next()) {
				if (res.getString("statu").equals("0"))
					isfree = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
		return isfree;
	}

	public static void reserveTicketById(int cinema_id, int room_id) {
		String sql = "update cinema_room set statu=? where cid = ? and crid = ? and statu = '0'";
		List<Object> params = new ArrayList<Object>();
		params.add("1");
		params.add(cinema_id);
		params.add(room_id);

		try {
			Connect.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.close();
		}
	}

}
