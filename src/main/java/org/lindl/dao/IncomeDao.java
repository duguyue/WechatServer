package org.lindl.dao;

import java.util.ArrayList;
import java.util.List;

import org.lindl.entity.Income;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class IncomeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Result queryIncome(int page,int pageSize){
		List<Income> list=new ArrayList<Income>();
		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from income ");
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
			Income income=new Income();
			income.setId(rs.getInt("id"));
			income.setUserId(rs.getString("userId"));
			income.setIncomeTypeId(rs.getInt("incomeTypeId"));
			income.setIncomeType(rs.getString("incomeType"));
			income.setAmount(rs.getDouble("amount"));
			
			list.add(income);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countIncome());
		}
		return new Result(-1, "错误信息");
	}
	public int countIncome() {
		int num = 0;
		String sql = "select count(id) as num from income";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}

}
