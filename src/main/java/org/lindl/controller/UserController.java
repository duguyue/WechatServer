package org.lindl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lindl.entity.Result;
import org.lindl.entity.User;
import org.lindl.service.UserService;
import org.lindl.utils.GetUniqueKey;
import org.lindl.utils.Md5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Resource
	UserService userService;

	@ResponseBody
	@RequestMapping(value = "/queryUser")
	public Result queryUser(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return userService.queryUsers(page, pageSize);
	}
	@ResponseBody
	@RequestMapping(value="/addUser")
	public Result addUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=new User();
		user.setUsername(new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8"));
		user.setPassword(Md5.getVal_UTF8(request.getParameter("password")));
		user.setUserId(GetUniqueKey.getKey());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		user.setLast_get(df.format(new Date()));
		
		System.out.println(user);
		return userService.addUser(user);
	}
	
	// @ResponseBody
	// @RequestMapping(value = "/queryUser")
	// public Result queryUser(int page, int pageSize) throws Exception {
	// return userService.queryUsers(page, pageSize);
	// }

	// @RequestMapping(value = "/queryUser.action")
	// public ModelAndView queryUser() throws Exception {
	// List<User> userList = new ArrayList<User>();
	// userList = userService.queryUsers();
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.addObject("userList", userList);
	// modelAndView.setViewName("user");
	// return modelAndView;
	// }

	@RequestMapping("/addUserUI.action")
	public String addUserUI() throws Exception {
		return "addUser";
	}

	@ResponseBody
	@RequestMapping(value="/updateUser")
	public Result updateUser(HttpServletRequest request){
		User user=new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUsername(request.getParameter("username"));
		user.setPassword(Md5.getVal_UTF8(request.getParameter("password")));
		user.setUserId(request.getParameter("userId"));
		user.setCoin(Integer.parseInt(request.getParameter("coin")));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		user.setLast_get(df.format(new Date()));
		
		return userService.updateUser(user);
	}

	@ResponseBody
	@RequestMapping("/deleteUser")
	public Result deleteUser(HttpServletRequest request) {
		int id=Integer.parseInt(request.getParameter("id"));
		return userService.deleteUser(id);
	}

	@RequestMapping("/loginUI.action")
	public String loginUI() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/login")
	public Result login(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		return userService.isHasUser(username, password);
	}
	
}
