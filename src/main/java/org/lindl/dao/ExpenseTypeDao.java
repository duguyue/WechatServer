package org.lindl.dao;

import java.util.ArrayList;
import java.util.List;

import org.lindl.entity.ExpenseType;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
@Repository
public class ExpenseTypeDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Result queryExpenseType(int page,int pageSize){
		List<ExpenseType> list=new ArrayList<ExpenseType>();
		
		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from expense_type ");
		sql.append(" order by id desc");
		
		if (page != 0 && pageSize != 0) {
			sql.append(" limit ?,?");
			int start = (page - 1) * pageSize;
			dataList.add(start);
			dataList.add(pageSize);
		}

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql.toString(),
				dataList.toArray());
		while(rs.next()){
			ExpenseType expenseType=new ExpenseType();
			expenseType.setId(rs.getInt("id"));
			expenseType.setUserId(rs.getString("userId"));
			expenseType.setExpenseType(rs.getString("expenseType"));
			
			list.add(expenseType);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countExpenseType());
		}
		return new Result(-1, "错误信息");
	}
	public int countExpenseType() {
		int num = 0;
		String sql = "select count(id) as num from expense_type";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}
}
