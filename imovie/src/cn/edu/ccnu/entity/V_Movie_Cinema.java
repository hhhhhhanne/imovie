package cn.edu.ccnu.entity;

import java.math.BigDecimal;

public class V_Movie_Cinema {
	private int mid;
	private String movie;
	private int cid;
	private String cinema;
	private BigDecimal price;
	private String mptype;
	private int crid;
	private int seat_x;
	private int seat_y;
	private String roomname;
	private String statu;
	private String starttime;
	
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public int getMid() {
		return this.mid;
	}
	
	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public String getMovie() {
		return this.movie;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public int getCid() {
		return this.cid;
	}
	
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	
	public String getCinema() {
		return this.cinema;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
	
	public void setMptype(String mptype) {
		this.mptype = mptype;
	}
	
	public String getMptype() {
		return this.mptype;
	}
	
	public void setCrid(int crid) {
		this.crid = crid;
	}
	
	public int getCrid() {
		return this.crid;
	}
	
	public void setSeatX(int seat_x) {
		this.seat_x = seat_x;
	}
	
	public int getSeatX() {
		return this.seat_x;
	}
	
	public void setSeatY(int seat_y) {
		this.seat_y = seat_y;
	}
	
	public int getSeatY() {
		return this.seat_y;
	}
	
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	
	public String getRoomname() {
		return this.roomname;
	}
	
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	public String getStatu() {
		return this.statu;
	}
	
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getStarttime() {
		return this.starttime;
	}
}
