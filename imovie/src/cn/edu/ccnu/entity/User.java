package cn.edu.ccnu.entity;

import java.util.Date;

public class User {
	private int uid;
	private String username;
	private String email;
	private String mobile;
	private String passwd;
	private String address;
	private Date expires_in;
	private int salt;
	private String access_token;
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setExpiresIn(Date expires_in) {
		this.expires_in = expires_in;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	public void setAccessToken(String access_token) {
		this.access_token = access_token;
	}

	public int getUid() {
		return this.uid;
	}

	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return this.email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public String getAddress() {
		return this.address;
	}
	
	public Date getExpiresIn() {
		return this.expires_in;
	}

	public int getSalt() {
		return this.salt;
	}

	public String getAccessToken() {
		return this.access_token;
	}
}
