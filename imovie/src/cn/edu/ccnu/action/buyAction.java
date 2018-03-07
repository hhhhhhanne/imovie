package cn.edu.ccnu.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.edu.ccnu.dao.OrderDAO;
import cn.edu.ccnu.dao.V_Movie_CinemaDAO;
import cn.edu.ccnu.entity.Order;
import cn.edu.ccnu.entity.V_Movie_Cinema;
import cn.edu.ccnu.util.Dataformat;

import com.opensymphony.xwork2.ActionSupport;

public class buyAction extends ActionSupport {

	private String mid;
	private String cid;
	private String crid;
	private String message;
	private String seats;

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String uidstr = (String) session.getAttribute("uid");
		if (uidstr != null) {
			int uid = Integer.valueOf(uidstr);
			int n_min = Integer.valueOf(this.mid);
			int n_cid = Integer.valueOf(this.cid);
			String[] tickets = this.crid.split(",");
			String jsonstr = "";
			for (int i = 0; i < tickets.length; i++) {

				int n_crid = Integer.valueOf(tickets[i]);
				// 所订座位是否为空
				if (V_Movie_CinemaDAO.isFreeSeatById(n_min, n_cid, n_crid)) {

					V_Movie_Cinema vmc = V_Movie_CinemaDAO.getMovieById(n_min,
							n_cid, n_crid);
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("mid", String.valueOf(vmc.getMid()));
					map.put("name", vmc.getMovie());
					map.put("cid", String.valueOf(vmc.getCid()));
					map.put("cinema", vmc.getCinema());
					map.put("price", String.valueOf(vmc.getPrice()));
					map.put("starttime", vmc.getStarttime());
					map.put("crid", String.valueOf(vmc.getCrid()));
					map.put("seat_x", String.valueOf(vmc.getSeatX()));
					map.put("seat_y", String.valueOf(vmc.getSeatY()));
					map.put("roomname", vmc.getRoomname());
					if (jsonstr == "") {
						jsonstr = Dataformat.setJson("ticket", map);
					} else {
						jsonstr = Dataformat.appendJson("ticket", jsonstr, map);
					}
				}
			}
			// 添加订单
			Order o = new Order();
			o.setUid(uid);
			o.setContent(jsonstr);
			OrderDAO.addOrder(o);
			for (int i = 0; i < tickets.length; i++) {
				int n_crid = Integer.valueOf(tickets[i]);
				// 更新座位状态
				V_Movie_CinemaDAO.reserveTicketById(n_cid, n_crid);
			}

			return SUCCESS;
		} else {
			this.message = "订票前，请先登录!";
			return ERROR;
		}

	}

	public void showOrdersAct() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session = ServletActionContext.getRequest().getSession();
		String uidstr = (String) session.getAttribute("uid");

		if (uidstr != null) {
			List<Order> myorders = OrderDAO.getOrdersByName(Integer
					.valueOf(uidstr));
			HashMap<String, String> res = new HashMap<String, String>();
			for (int i = 0; i < myorders.size(); i++) {
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("createdatetime", myorders.get(i).getCreateDatetime());
				String jsonStr = Dataformat.appendJson("datetime", myorders
						.get(i).getContent(), hm);
				res.put("info" + i, jsonStr);
			}
			if(res.size() == 0){
				out.println(res.size());
			}else{
				out.println(Dataformat.setJson("orders", res).toString());
			}
			

		} else {

		}
		out.flush();
		out.close();
	}

	public String selectSeatAct() throws Exception {
		List<V_Movie_Cinema> list = V_Movie_CinemaDAO.getSeatInfoById(
				Integer.valueOf(this.mid), Integer.valueOf(this.cid));

		int row_num = 0;
		int column_num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSeatX() > row_num) {
				row_num++;
			}
			if (list.get(i).getSeatY() > column_num) {
				column_num++;
			}
		}
		this.seats = null;
		for (int row = 1; row <= row_num; row++) {
			String columnstr = null;
			for (int column = 1; column <= column_num; column++) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSeatX() == row
							&& list.get(i).getSeatY() == column) {
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("crid", String.valueOf(list.get(i).getCrid()));
						map.put("title", list.get(i).getSeatX() + "排"
								+ list.get(i).getSeatY() + "列");
						map.put("statu", list.get(i).getStatu());
						map.put("type", "0");

						if (columnstr == null) {
							columnstr = Dataformat.setJson("data", map);
						} else {
							columnstr = Dataformat.appendJson("data",
									columnstr, map);
						}

						list.remove(i);
						break;
					}
				}
			}
			HashMap<String, String> r = new HashMap<String, String>();
			r.put("row", columnstr);
			if (seats == null) {
				seats = Dataformat.setJson("info", r);
			} else {
				seats = Dataformat.appendJson("info", seats, r);
			}

		}

		return SUCCESS;
	}

	public String getMessage() {
		return this.message;
	}

	public String getSeats() {
		return this.seats;
	}

	public void setId(String id) {
		this.mid = id;
	}

	public String getId() {
		return this.mid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCrid(String crid) {
		this.crid = crid;
	}

	public String getCrid() {
		return this.crid;
	}

}
