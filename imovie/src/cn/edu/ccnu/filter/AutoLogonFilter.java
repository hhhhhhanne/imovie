package cn.edu.ccnu.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.dao.UserDAO;
import cn.edu.ccnu.entity.User;
import cn.edu.ccnu.util.AccessToken;

public class AutoLogonFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (req.getSession(false) == null) {
			// 不存在session，存在cookies
			String token = this.getCookie(req, "access_token");
			String username = this.getCookie(req, "username");
			String uid = this.getCookie(req, "uid");
			if (token != null) {
				User user = UserDAO.getUser(username);
				if (AccessToken.checkToken(user, token)) {
					req.getSession().setAttribute("status", "true");
					req.getSession().setAttribute("username", username);
					req.getSession().setAttribute("uid", uid);
				} else {
					// token过期
				}
			}
		}
		chain.doFilter(req, res);
	}

	private String getCookie(HttpServletRequest request, String name)
			throws UnsupportedEncodingException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					String val = URLDecoder.decode(cookie.getValue(), "UTF-8");
					return val;
				}
			}
		}
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
