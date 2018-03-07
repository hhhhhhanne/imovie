package cn.edu.ccnu.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.ccnu.dao.DemoDAO;
import cn.edu.ccnu.dao.UserDAO;
import cn.edu.ccnu.entity.Demo;
import cn.edu.ccnu.entity.User;
import cn.edu.ccnu.util.AccessToken;
import cn.edu.ccnu.util.Decripts;

public class logonAction extends ActionSupport {

	private String username;// �û���
	private String passwd;// ����
	private String again; // ȷ������
	private String mobile;
	private String email;
	private String address;
	private boolean rememberme; //

	private int life_cycle = 7 * 24 * 60 * 60;
	private String message;// execute()ִ����󷵻ص���Ϣ

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {

		User user = UserDAO.getUser(this.username);
		if (this.checkpass(user)) {
			// �û�����������ȷ
			if (this.getRememberme() == true) {
				// ��ס��
				String access_token = AccessToken.createToken(user,
						this.life_cycle);
				// ��¼cookies
				this.addCookie("username", user.getUsername(), this.life_cycle);
				this.addCookie("uid", String.valueOf(user.getUid()), this.life_cycle);
				this.addCookie("access_token", access_token, this.life_cycle);

			} else {
				// ����cookies
				this.addCookie("username", "", 0);
				this.addCookie("uid", "", 0);
				this.addCookie("access_token", "", 0);
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("username", this.username);
			session.setAttribute("uid", String.valueOf(user.getUid()));
			session.setAttribute("status", "true");
			return SUCCESS;
		} else {
			message = "�û������������";
			return ERROR;
		}
	}

	public String logoutAct() throws Exception {
		// �h��session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("username");
		session.removeAttribute("uid");
		session.removeAttribute("status");

		this.addCookie("username", "", 0);
		this.addCookie("uid", "", 0);
		this.addCookie("access_token", "", 0);
		return SUCCESS;
	}

	public String registerAct() throws Exception {
		// ��̨У��ע�������Ƿ�ƥ��
		if (this.passwd.equals(this.again)) {
			// У������
			User user = UserDAO.getUser(this.username);
			if (user.getUid() == 0) {
				user = new User();
				// �������һ��������Ϊ��ֵ
				Random r = new Random();
				// ������Χȡ����ֵ
				user.setSalt(Math.abs(r.nextInt()));
				user.setUsername(this.username);
				user.setEmail(this.email);
				user.setMobile(this.mobile);
				user.setAddress(this.address);
				user.setAccessToken("");
				user.setPasswd(Decripts.SHA1(user.getSalt() + this.username
						+ this.passwd));
				// д�����ݿ�
				UserDAO.addUser(user);
				return SUCCESS;
				
			} else {
				this.message = "�Ѵ�����ͬ���û���";
				return ERROR;
			}

		} else {
			return ERROR;
		}

	}

	private void addCookie(String key, String value, int time)
			throws UnsupportedEncodingException {
		String val = URLEncoder.encode(value, "UTF-8");
		Cookie cookie = new Cookie(key, val);
		cookie.setPath("/");
		cookie.setMaxAge(time);
		ServletActionContext.getResponse().addCookie(cookie);
	}

	/* У���û����������Ƿ���ȷ */
	private boolean checkpass(User user) {
		if (user != null) {
			// sha1����
			String hash = Decripts.SHA1(user.getSalt() + this.username
					+ this.passwd);
			// ��ϣ�Ƚ�
			if (hash.equals(user.getPasswd())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.passwd;
	}

	public void setPassword(String password) {
		this.passwd = password;
	}

	public String getAgain() {
		return this.again;
	}

	public void setAgain(String again) {
		this.again = again;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getRememberme() {
		return this.rememberme;
	}

	public void setRememberme(boolean rememberme) {
		this.rememberme = rememberme;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/* Demo Start */
	private Demo demo;
	private List<Demo> demolist;

	public String demoAct() throws Exception {
		this.demo = DemoDAO.getDemoById("1");
		this.demolist = DemoDAO.getDemoMultiByName("%%");
		return SUCCESS;
	}

	public String demoiAct() throws Exception {
		Demo d = new Demo();
		d.setId("100");
		d.setName("PalaPala");
		d.setPrice((float) 101.1);
		DemoDAO.addDemo(d);

		this.demo = DemoDAO.getDemoById("1");
		this.demolist = DemoDAO.getDemoMultiByName("%%");
		return SUCCESS;
	}

	public String demouAct() throws Exception {
		this.demo = DemoDAO.getDemoById("1");
		Random rest = new Random();
		this.demo.setPrice(rest.nextFloat());
		DemoDAO.updateDemoById(this.demo, demo.getId());

		this.demolist = DemoDAO.getDemoMultiByName("%%");
		return SUCCESS;
	}

	public String demodAct() throws Exception {
		DemoDAO.delDemoById("100");
		this.demo = DemoDAO.getDemoById("1");
		this.demolist = DemoDAO.getDemoMultiByName("%%");
		return SUCCESS;
	}

	public Demo getDemo() {
		return this.demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	public List<Demo> getDemolist() {
		return this.demolist;
	}

	public void setDemolist(List<Demo> demolist) {
		this.demolist = demolist;
	}

	/* Demo End */

}
