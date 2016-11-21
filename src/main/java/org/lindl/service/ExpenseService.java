package org.lindl.service;

import javax.annotation.Resource;

import org.lindl.dao.ExpenseDao;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ExpenseService {

	@Resource
	private ExpenseDao expenseDao;

	public Result queryExpense(int page, int pageSize) {
		return expenseDao.queryExpense(page, pageSize);
	}
}
