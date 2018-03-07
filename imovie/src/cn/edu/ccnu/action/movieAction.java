package cn.edu.ccnu.action;

import java.util.List;

import cn.edu.ccnu.dao.MovieDAO;
import cn.edu.ccnu.dao.V_Movie_CinemaDAO;
import cn.edu.ccnu.entity.Movie;
import cn.edu.ccnu.entity.V_Movie_Cinema;

import com.opensymphony.xwork2.ActionSupport;

public class movieAction extends ActionSupport {

	private String mid;
	private Movie movie;
	private List<V_Movie_Cinema> cinema;
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		this.movie = null;
		if (!this.mid.isEmpty()) {
			this.movie = MovieDAO.getMovieById(this.mid);
			this.cinema = V_Movie_CinemaDAO.getCinemaInfoById(Integer
					.valueOf(this.mid));
			if (this.movie != null) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			return ERROR;
		}

	}

	public void setId(String id) {
		this.mid = id;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public List<V_Movie_Cinema> getCinemas() {
		return this.cinema;
	}

}
