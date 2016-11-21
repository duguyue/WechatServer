package org.lindl.dao;

import java.util.ArrayList;
import java.util.List;

import org.lindl.entity.Expense;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
@Repository
public class ExpenseDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Result queryExpense(int page,int pageSize){
		List<Expense> list=new ArrayList<Expense>();
		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from expense ");
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
			Expense expense=new Expense();
			expense.setId(rs.getInt("id"));
			expense.setUserId(rs.getString("userId"));
			expense.setExpenseTypeId(rs.getInt("expenseTypeId"));
			expense.setExpenseType(rs.getString("expenseType"));
			expense.setAmount(rs.getDouble("amount"));
			
			list.add(expense);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countExpense());
		}
		return new Result(-1, "错误信息");
	}
	public int countExpense() {
		int num = 0;
		String sql = "select count(id) as num from expense";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}
}
