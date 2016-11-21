package org.lindl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.Result;
import org.lindl.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExpenseController {

	@Resource
	ExpenseService expenseService;

	@ResponseBody
	@RequestMapping(value = "/queryExpense")
	public Result queryExpense(HttpServletRequest request) {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return expenseService.queryExpense(page, pageSize);
	}
}
