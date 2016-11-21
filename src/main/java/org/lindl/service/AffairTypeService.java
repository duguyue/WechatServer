package org.lindl.service;

import java.util.ArrayList;
import java.util.List;

import org.lindl.dao.AffairTypeDao;
import org.lindl.entity.AffairType;
import org.lindl.entity.Result;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class AffairTypeService{

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addAffairType(AffairType affairType) {
		// TODO Auto-generated method stub
		String sql="insert into affair_type(affair_type) values(?)";
		Object[] object={affairType.getAffairType()};
		jdbcTemplate.update(sql, object);
	}

	public void updateAffairType(AffairType affairType) {
		String sql = "update affair_type set affair_type=? where id=?";
		Object[] object={ affairType.getAffairType(), affairType.getId() };
		jdbcTemplate.update(sql, object);
	}

	public void deleteAffairType(int id) {
		// TODO Auto-generated method stub
		String sql="delete from affair_type where id=?";
		Object[] object={id};
		jdbcTemplate.update(sql, object);
	}

	public Result queryAffairTypes(int page, int pageSize) {
		List<AffairType> list=new ArrayList<AffairType>();
		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from affair_type ");
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
			AffairType affairType=new AffairType();
			affairType.setId(rs.getInt("id"));
			affairType.setAffairType(rs.getString("affair_type"));
			affairType.setUserId(rs.getString("userId"));
			
			list.add(affairType);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countAffairTypes());
		}
		return new Result(-1, "错误信息");
	}
	public int countAffairTypes() {
		int num = 0;
		String sql = "select count(id) as num from affair_type";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}
	public AffairType queryAffairTypeById(int id) {
		String sql="select * from affair_type where id=?";
		Object[] object={id};
		SqlRowSet rs=jdbcTemplate.queryForRowSet(sql, object);
		AffairType affairType=null;
		while(rs.next()){
			affairType=new AffairType();
			affairType.setId(rs.getInt("id"));
			affairType.setAffairType(rs.getString("affair_type"));
		}
		return affairType;
	}

}
