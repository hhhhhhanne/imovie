package cn.edu.ccnu.entity;

import java.util.Date;

import cn.edu.ccnu.util.Datetime;

public class Order {
	private int uid;
	private String content;
	private Date createDateTime;

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDatetime() {
		return Datetime.formatDate(this.createDateTime, "yyyy-MM-dd HH:mm:ss");
	}

	public void setCreateDatetime(Date cdt) {
		this.createDateTime = cdt;
	}

}
