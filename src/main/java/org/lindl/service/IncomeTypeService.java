package org.lindl.service;

import javax.annotation.Resource;

import org.lindl.dao.IncomeTypeDao;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class IncomeTypeService {

	@Resource
	IncomeTypeDao incomeTypeDao;

	public Result queryIncomeType(int page, int pageSize) {
		return incomeTypeDao.queryIncomeType(page, pageSize);
	}
}
