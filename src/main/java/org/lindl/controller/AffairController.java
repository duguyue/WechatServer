package org.lindl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.Affair;
import org.lindl.entity.Result;
import org.lindl.service.AffairService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AffairController {

	@Resource
	AffairService affairService;

	@ResponseBody
	@RequestMapping(value = "/queryAffairs")
	public Result queryAffair(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return affairService.queryAffairs(page, pageSize);
	}

	@RequestMapping("/addAffairUI.action")
	public String addAffairUI() throws Exception {
		return "addAffair";
	}

	@RequestMapping("/addAffair.action")
	public String addAffair(Affair affair) throws Exception {
		// TODO 添加用户数据，同时更新缓存
		affairService.addAffair(affair);

		return "redirect:queryAffair.action";
	}

	@RequestMapping("/deleteAffair.action")
	public String deleteAffair(int id) {
		// TODO 删除数据库中指定的记录，然后删除缓存中指定的数据
		affairService.deleteAffair(id);

		return "redirect:queryAffair.action";
	}
}
