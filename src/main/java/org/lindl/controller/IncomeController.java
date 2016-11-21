package org.lindl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.Result;
import org.lindl.service.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IncomeController {


	@Resource
	IncomeService incomeService;

	@ResponseBody
	@RequestMapping(value = "/queryIncome")
	public Result queryIncome(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return incomeService.queryIncome(page, pageSize);
	}
}
