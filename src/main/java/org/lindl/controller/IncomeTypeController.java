package org.lindl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.Result;
import org.lindl.service.IncomeTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IncomeTypeController {

	@Resource
	IncomeTypeService incomeTypeService;

	@ResponseBody
	@RequestMapping(value = "/queryIncomeType")
	public Result queryIncomeType(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return incomeTypeService.queryIncomeType(page, pageSize);
	}
}
