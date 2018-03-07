package cn.edu.ccnu.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.dao.MovieDAO;
import cn.edu.ccnu.entity.Movie;

import com.opensymphony.xwork2.ActionSupport;

public class searchAction extends ActionSupport {

	private String message;// execute()执行完后返回的消息
	private String search;
	private List<Movie> movies;

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		this.movies = new ArrayList<Movie>();
		if (!this.search.isEmpty()) {
			this.movies = MovieDAO.getMovieMultiByName("%" + this.search + "%");
		}

		if (this.movies.isEmpty()) {
			this.message = "没有找到任何信息！";
		} else {
			this.message = "共搜索到" + this.movies.size() + "记录符合条件！";
		}
		return SUCCESS;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setS(String s) {
			this.search = s;
	}

	public String getS() {
		return this.search;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

}
