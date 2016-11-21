package org.lindl.service;

import javax.annotation.Resource;

import org.lindl.dao.IncomeDao;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class IncomeService {

	@Resource
	IncomeDao incomeDao;

	public Result queryIncome(int page, int pageSize) {
		return incomeDao.queryIncome(page, pageSize);
	}
}
