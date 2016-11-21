package org.lindl.service;

import javax.annotation.Resource;

import org.lindl.dao.ExpenseTypeDao;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ExpenseTypeService {

	@Resource
	ExpenseTypeDao expenseTypeDao;

	public Result queryExpenseType(int page, int pageSize) {
		return expenseTypeDao.queryExpenseType(page, pageSize);
	}
}
