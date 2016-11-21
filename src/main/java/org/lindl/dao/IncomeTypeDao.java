package org.lindl.dao;

import java.util.ArrayList;
import java.util.List;

import org.lindl.entity.IncomeType;
import org.lindl.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class IncomeTypeDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Result queryIncomeType(int page, int pageSize) {
		List<IncomeType> list = new ArrayList<IncomeType>();

		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from income_type ");
		sql.append(" order by id desc");

		if (page != 0 && pageSize != 0) {
			sql.append(" limit ?,?");
			int start = (page - 1) * pageSize;
			dataList.add(start);
			dataList.add(pageSize);
		}

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql.toString(),
				dataList.toArray());
		while (rs.next()) {
			IncomeType incomeType = new IncomeType();
			incomeType.setId(rs.getInt("id"));
			incomeType.setUserId(rs.getString("userId"));
			incomeType.setIncomeType(rs.getString("incomeType"));

			list.add(incomeType);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countIncomeType());
		}
		return new Result(-1, "错误信息");
	}

	public int countIncomeType() {
		int num = 0;
		String sql = "select count(id) as num from income_type";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}
}
