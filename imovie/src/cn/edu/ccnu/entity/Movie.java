package cn.edu.ccnu.entity;

public class Movie {
	private int mid;
	private String name;
	private String nickname;
	private String director;
	private String country;
	private String mtype;
	private String myear;
	private String msummary;
	private int sub;
	private int sup;
	private String imgurl;

	public void setMid(int mid) {
		this.mid = mid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setDirector(String direcotr) {
		this.director = direcotr;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setType(String mtype) {
		this.mtype = mtype;
	}

	public void setYear(String myear) {
		this.myear = myear;
	}

	public void setSummary(String msummary) {
		this.msummary = msummary;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public void setSup(int sup) {
		this.sup = sup;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public int getMid() {
		return this.mid;
	}

	public String getName() {
		return this.name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public String getDirector() {
		return this.director;
	}

	public String getCountry() {
		return this.country;
	}

	public String getType() {
		return this.mtype;
	}

	public String getYear() {
		return this.myear;
	}

	public String getSummary() {
		return this.msummary;
	}

	public int getSub() {
		return this.sub;
	}

	public int getSup() {
		return this.sup;
	}
	
	public String getImgurl() {
		return this.imgurl;
	}
}
