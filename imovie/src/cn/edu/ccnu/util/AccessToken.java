package cn.edu.ccnu.util;

import java.util.Date;

import cn.edu.ccnu.dao.UserDAO;
import cn.edu.ccnu.entity.User;

public class AccessToken {
	private static int begin = 0;
	private static int end = 20;

	/* 生成 access token */
	public static String createToken(User user, int sec) {
		if (user != null && sec != 0) {
			// 更新有效期
			Date nowDate = Datetime.addDateSec(new Date(), sec);
			String nowStr = Datetime.formatDate(nowDate, null);
			String token = Decripts.SHA1(
					user.getUsername() + user.getPasswd() + user.getSalt()
							+ Datetime.formatDate(user.getExpiresIn(), null))
					.substring(begin, end);
			UserDAO.updateAccessToken(nowStr, token, user.getUid());
			return token;

		} else {
			return null;
		}
	}

	/* 验证 access token */
	public static boolean checkToken(User user, String token) {
		if (user != null && token != null) {
			Date now = new Date();
			if (now.before(user.getExpiresIn())
					&& user.getAccessToken() != null) {
				String ntoken = Decripts
						.SHA1(user.getUsername()
								+ user.getPasswd()
								+ user.getSalt()
								+ Datetime.formatDate(user.getExpiresIn(), null))
						.substring(begin, end);
				if (ntoken.equals(token)) {
					return true;
				} else {
					return false;
				}
			} else {
				// access token timeout
				return false;
			}

		} else {
			return false;
		}

	}
}
