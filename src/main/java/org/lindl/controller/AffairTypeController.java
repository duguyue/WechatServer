package org.lindl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.Affair;
import org.lindl.entity.AffairType;
import org.lindl.entity.Result;
import org.lindl.service.AffairTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AffairTypeController {

	@Resource
	AffairTypeService affairTypeService;

	@ResponseBody
	@RequestMapping(value = "/queryAffairTypes")
	public Result queryAffairType(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return affairTypeService.queryAffairTypes(page, pageSize);
	}

	@RequestMapping("/addAffairTypeUI.action")
	public String addAffairTypeUI() throws Exception {
		return "addAffairType";
	}

	@RequestMapping("/addAffairType.action")
	public String addaffairType(AffairType affairType) throws Exception {
		// TODO 添加用户数据，同时更新缓存
		affairTypeService.addAffairType(affairType);

		return "redirect:queryAffairType.action";
	}

	@RequestMapping("/deleteAffairType.action")
	public String deleteAffairType(int id) {
		// TODO 删除数据库中指定的记录，然后删除缓存中指定的数据
		affairTypeService.deleteAffairType(id);

		return "redirect:queryAffairType.action";
	}
}
