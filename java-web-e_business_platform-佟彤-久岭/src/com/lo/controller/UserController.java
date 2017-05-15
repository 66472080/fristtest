package com.lo.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lo.model.PageModel;
import com.lo.model.TicketModel;
import com.lo.model.UserPagesAticket;
import com.lo.check.Check;
import com.lo.entity.AdminTicket;
import com.lo.entity.Order;
import com.lo.entity.Pages;
import com.lo.entity.SC;
import com.lo.entity.User;
import com.lo.service.UserService;

@Controller
public class UserController {

	@Resource
	private Check check;

	Map<String, Object> session;
	@Resource
	private UserService userSerivce;

	public static int z = 10001;

	// 查询用户数据方法
	@RequestMapping("views/findUser")
	@ResponseBody
	public List<User> findUser() {

		List<User> lu = userSerivce.findUser();

		return lu;
	}

	// 查询用户数据方法(对比前台页面输入的值)
	@RequestMapping("views/findUser3")
	@ResponseBody
	public String findUser3(@RequestBody User user) {

		List<User> lu = userSerivce.findUser();
		for (User user2 : lu) {
			System.out.println("=====" + user.getTelon() + "*****");
			if (user.getUserName() != "" && 
					user.getUserName()!= null && 
					check.checkuserName(user.getUserName()) == false) {
				System.out.println(user.getUserName());
				return "geshi";

			} else if (user.getUserName() != "" && 
					user.getUserName()!= null &&
					user.getUserName().equals(user2.getUserName())) {
				return "userNameyou";
			}

			else if (user.getTelon() != "" && 
					user.getTelon() != null && 
					check.checktelon(user.getTelon()) == false) {

				return "userTelonyou";
			} else if (user.getTelon() != "" && 
					user.getTelon() != null && 
					check.checktelon(user.getTelon()) == true) {

				return "ok";
			} else if (user.getIdCard() != "" 
					&& user.getTelon() != null
					&& user.getIdCard().equals(user2.getIdCard())) {
				return "userIdCardyou";
			}
		}
		return "meiyou";
	}

	// 查询用户数据方法2
	@RequestMapping("views/findUser2")
	@ResponseBody
	public User findUser2(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		User lu = userSerivce.findUser2(id);
		return lu;
	}

	// 修改用户方法
	@RequestMapping("views/updateUser")
	public String updateUser(HttpServletRequest req, User user) {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		User u = new User();
		u.setUid(id);
		u.setAddress(user.getAddress());
		u.setAge(user.getAge());
		u.setBalance(user.getBalance());
		u.setGender(user.getGender());
		u.setIdCard(user.getIdCard());
		u.setName(user.getName());
		u.setTelon(user.getTelon());
		u.setUserPwd(user.getUserPwd());
		userSerivce.updateUser(u);
		return "index";
	}

	// 充值方法
	@RequestMapping("views/updateUser2")
	@ResponseBody
	public String updateUser2(@RequestBody double menoy, HttpServletRequest req) {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		User lu = userSerivce.findUser2(id);
		Double d1 = lu.getBalance();
		Double d2 = d1 + menoy;
		User u = new User();
		u.setUid(id);
		u.setBalance(d2);
		userSerivce.updateUser2(u);
		return "userMessage";
	}

	// 登录 对比账号密码方法
	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest req, User user) {
		String a = "^[A-Za-z][A-Za-z0-9_-]+$";
		String b = "^[0-9]\\d{6,10}$";
		if (user.getUserName().matches(a) && user.getUserPwd().matches(b)) {
			List<User> lu = userSerivce.findUser();
			for (User user2 : lu) {
				if (user.getUserName().equals(user2.getUserName()) && user.getUserPwd().equals(user2.getUserPwd())) {
					int id = user2.getUid();
					HttpSession session = req.getSession();
					session.setAttribute("id", id);
					return "index";
				}
			}
			return "userLogin";
		} else {
			return "no";
		}
	}

	// 用户退出方法
	@RequestMapping(value = "UserOut")
	public String outUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.getAttribute("id");
		if (session.getAttribute("id") != null) {

			session.invalidate();
		}
		return "begin";
	}

	@RequestMapping("views/gosaveUser")
	public String gosaveUser() {
		return "loginin";
	}

	@RequestMapping(value = "views/saveUser2")
	public String saveUser2() {

		return "userLogin";

	}

	// 注册方法
	User u = null;

	@RequestMapping(value = "views/saveUser", method = RequestMethod.POST)
	public String saveUser(User user) {
		if (!check.checkname(user.getName())) {
			return "name error";
		}

		String a = "^[A-Za-z][A-Za-z0-9_-]+$";
		String b = "^[0-9]\\d{6,10}$";
		String name = "^[\u0391-\uFFE5]+$ ";
		String age = "^[0-9]\\d{3}$ ";
		String idCard = "^(\\d{6})(18|19|20|21)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$";
		String telon = "^1[3|4|5|8][0-9]\\d{8}$ ";
		String gender = "^[男|女]$";
		if (user.getUserName().matches(a) && user.getUserPwd().matches(b)) {
			u = new User();
			Timestamp ts = new Timestamp(System.currentTimeMillis());// 设置日期格式
			u.setRegTime(ts);
			if (user.getUserName().matches(a) && user.getUserPwd().matches(b) && user.getName().matches(name)
					&& user.getAge().matches(age) && user.getIdCard().matches(idCard) && user.getTelon().matches(telon)
					&& user.getGender().matches(gender)) {
				userSerivce.saveUser(user);
				return "userLogin";
			}
			return "loginin";
		}
		return "no";
	}

	// 注册方法
	@RequestMapping(value = "views/saveUser99", method = RequestMethod.POST)
	public void saveUser99(User user) {

		userSerivce.saveUser(user);

	}

	// 查询票务信息方法
	@RequestMapping(value = "views/findTicket")
	@ResponseBody
	public UserPagesAticket findTicket(@RequestBody int currentPage) {
		int a = userSerivce.findTicket4();
		Pages pages = new Pages();

		pages.setCurrentPage(currentPage);
		pages.setTotalNumber(a);

		List<AdminTicket> lu = userSerivce.findTicket8(pages);
		UserPagesAticket userPageAticket = new UserPagesAticket();
		userPageAticket.setLa(lu);
		userPageAticket.setPages(pages);
		return userPageAticket;
	}

	// // 查询票务信息方法
	// @RequestMapping(value = "findTicket2")
	// public String findTicket2() {
	//
	// return "rb";
	// }

	// 加入购物车方法
	@RequestMapping(value = "saveShopCar")
	@ResponseBody
	public String saveShopCar(@RequestBody TicketModel ticketModel, HttpServletRequest req) {

		AdminTicket at = new AdminTicket();
		at.setTid(ticketModel.getTid());
		SC ss = new SC();
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("id");
		List<AdminTicket> lu = userSerivce.findTicket3(at);
		for (AdminTicket adminTicket : lu) {
			ss.setBuyticket(ticketModel.getBuyCount());
			ss.setDese(adminTicket.getDese());
			ss.setMenoy(adminTicket.getPrice() * ticketModel.getBuyCount());
			ss.setPrice(adminTicket.getPrice());
			ss.setUid(uid);
			ss.setPrice(adminTicket.getPrice());
		}
		userSerivce.saveSC(ss);
		return "ok";
	}

	// 跳转查看购物车方法
	@RequestMapping(value = "lookSC")
	public String lookSC() {
		return "shopcar";
	}

	// 查询购物车方法
	@RequestMapping(value = "findSC")
	@ResponseBody
	public List<SC> findSC(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("id");
		List<SC> lu = userSerivce.findSC(uid);
		return lu;

	}

	// 结账方法
	@RequestMapping(value = "findSC2")
	@ResponseBody
	public List<SC> findSC2(HttpServletRequest req) {
		HttpSession session = req.getSession();
		// 把登录用户的id拿到
		int uid = (int) session.getAttribute("id");
		// 存入我的订单
		Order o = new Order();
		// 根据用户id 查询他的购物车里的信息
		List<SC> lu = userSerivce.findSC(uid);
		double a = 0;
		double b = 0;
		double c = 0;
		int d = 0;
		int r = 0;

		int id = uid;
		// 根据用户查询出他的信息
		User user = userSerivce.findUser2(id);
		// 拿到登录用户的余额
		b = user.getBalance();
		// 拿到购物车里的总金额
		for (SC sc : lu) {
			a += sc.getMenoy();

		}
		// 余额减去购买票的总金额
		c = b - a;
		o.setAmount(a);

		if (c > 0) {

			User u = new User();
			u.setBalance(c);
			u.setUid(id);
			// 查询票务信息
			AdminTicket at = new AdminTicket();
			for (SC sc : lu) {
				List<AdminTicket> la = userSerivce.findTicket();
				for (AdminTicket adminTicket : la) {

					if (adminTicket.getDese().equals(sc.getDese())) {
						o.setDese(sc.getDese());
						o.setPrice(sc.getPrice());
						o.setLid(sc.getSid());
						d = adminTicket.getBalance() - sc.getBuyticket();
						r = adminTicket.getTid();
						at.setBalance(d);
						at.setTid(r);
						if (d > 0) {
							// 修改票务信息
							userSerivce.updateat(at);
						} else {

							return null;
						}
					}
				}
				// 获取当前时间
				Timestamp ts = new Timestamp(System.currentTimeMillis());

				o.setCommitTime(ts);

				o.setXuhao(z);
				o.setUid(uid);

				z++;

				userSerivce.saveOrder(o);
			}

			// 存入个人信息内
			userSerivce.updateUser3(u);
			userSerivce.deleteSC2(uid);

			return lu;
		} else {
			return null;
		}

	}

	// // 退出方法
	// @RequestMapping(value = "UserOut")
	// public String UserOut(HttpServletRequest req) {
	// session.clear();
	// return "index";
	// }

	// 按日期查票方法
	@RequestMapping(value = "views/findTicketDate")
	@ResponseBody
	public List<AdminTicket> findTicketDate(@RequestBody AdminTicket adminTicket, HttpServletRequest request) {
		AdminTicket at = new AdminTicket();
		System.out.println(request.getSession().getAttribute("id"));
		at.setStartTime(adminTicket.getStartTime());
		List<AdminTicket> la = userSerivce.findTicket2(at);
		return la;
	}

	// 删除购物车内信息方法
	@RequestMapping(value = "deleteSC")
	@ResponseBody
	public String deleteSC(@RequestBody SC sc) {
		int lid = sc.getSid();
		userSerivce.deleteSC(lid);
		return "ok";
	}

	// 去结账页面方法
	@RequestMapping(value = "gojiezhang")
	public String gojiezhang() {

		return "jiezhang";
	}
	// 查询订单方法

	@RequestMapping(value = "views/findbill")
	@ResponseBody
	public List<Order> findbill() {

		List<Order> lo = userSerivce.findbill();
		return lo;
	}

	// 按uid查订单里的票方法
	@RequestMapping(value = "views/findOrder")
	@ResponseBody
	public Order findOrder(@RequestBody Order order) {
		Order o = new Order();
		o.setOid(order.getOid());
		Order o1 = userSerivce.findOrders(o);
		return o1;
	}

	// ----------------------------------------------
	// 分页查询我的订单方法
	@RequestMapping(value = "findbills", method = RequestMethod.POST)
	@ResponseBody // @RequestBody(gson\jackson) 将前台发过来的json字符串直接映射到userModer
	public PageModel findbills(@RequestBody int currentPage, HttpServletRequest req) {
		HttpSession session = req.getSession();
		int a = (int) session.getAttribute("id");
		if (a != 0) {
			// 分页器
			Pages page = new Pages();
			// 接收传过来的页数---前端
			page.setCurrentPage(currentPage);
			// 查询总条数
			int count = userSerivce.findbillsCount(a);
			page.setTotalNumber(count);

			User user = new User();
			user.setUid(a);

			// 使用map集合进行多对象的查询
			Map<String, Object> pageMap = new HashMap<>();
			pageMap.put("page", page);
			pageMap.put("user", user);
			// 分页查询
			List<Order> o1 = userSerivce.findOrdersbills(pageMap);

			// 将数据发送到页面上
			PageModel pum = new PageModel();
			pum.setO1(o1);// ---显示所有的用户
			pum.setPages(page);// ----分页数据
			return pum;
		} else {
			return null;
		}

	}

}
