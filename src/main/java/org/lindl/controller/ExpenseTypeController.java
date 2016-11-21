package org.lindl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.Result;
import org.lindl.service.ExpenseTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExpenseTypeController {

	@Resource
	ExpenseTypeService expenseTypeService;

	@ResponseBody
	@RequestMapping(value = "/queryExpenseType")
	public Result queryExpenseType(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return expenseTypeService.queryExpenseType(page, pageSize);
	}
}
