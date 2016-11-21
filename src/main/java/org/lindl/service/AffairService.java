package org.lindl.service;

import java.util.ArrayList;
import java.util.List;

import org.lindl.dao.AffairDao;
import org.lindl.entity.Affair;
import org.lindl.entity.Result;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class AffairService {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Result queryAffairs(int page, int pageSize) {
		List<Affair> affairs = new ArrayList<Affair>();

		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from affair ");
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

			// SimpleDateFormat format;
			// Date datePlanStartTime = null;
			// Date datePlanEndTime = null;

			Affair affair = new Affair();
			affair.setId(rs.getInt("id"));
			affair.setContent(rs.getString("content"));
			affair.setAddress(rs.getString("address"));
			affair.setPlanStartTime(rs.getDate("planStartTime"));
			affair.setPlanEndTime(rs.getDate("planEndTime"));
			affair.setRank(rs.getInt("rank"));
			affair.setAddContent(rs.getString("addContent"));
			affair.setBelongToType(rs.getInt("belongToType"));
			affair.setBelongToTypeName(rs.getString("belongToTypeName"));
			affair.setUserId(rs.getString("userId"));

			affairs.add(affair);
		}
		if (affairs.size() > 0) {
			return new Result(0, affairs, "", countAffairs());
		}
		return new Result(-1, "错误信息");
	}
	public int countAffairs() {
		int num = 0;
		String sql = "select count(id) as num from affair";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}
	public Affair queryAffairById(int id) {
		String sql = "select * from affair where id=?";
		Object[] object = { id };
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, object);
		Affair affair = null;
		while (rs.next()) {
			affair = new Affair();

			affair.setId(rs.getInt("id"));
			affair.setContent(rs.getString("content"));
			affair.setAddress(rs.getString("address"));
			affair.setPlanStartTime(rs.getDate("planStartTime"));
			affair.setPlanEndTime(rs.getDate("planEndTime"));
			affair.setRank(rs.getInt("rank"));
			affair.setAddContent(rs.getString("addContent"));
			affair.setBelongToType(rs.getInt("belongToType"));
			affair.setBelongToTypeName(rs.getString("belongToTypeName"));
		}
		return affair;
	}

	public void addAffair(Affair affair) {
		String sql = "insert into affair(content,address,planStartTime,planEndTime,rank,addContent,belongToType,belongToTypeName) values (?,?,?,?,?,?,?,?)";
		Object[] object={ affair.getContent(), affair.getAddress(),
				affair.getPlanStartTime(), affair.getPlanEndTime(),
				affair.getRank(), affair.getAddContent(),
				affair.getBelongToType(),affair.getBelongToTypeName() };
		jdbcTemplate.update(sql, object);
	}

	public void updateAffair(Affair affair) {
		String sql = "update affair set content=?,address=?,planStartTime=?,"
				+ "planEndTime=?,rank=?,addContent=?,belongToType=?,"
				+ "belongToTypeName=? where id=?";
		Object[] object={ affair.getContent(), affair.getAddress(),
				affair.getPlanStartTime(), affair.getPlanEndTime(),
				affair.getRank(), affair.getAddContent(),
				affair.getBelongToType(), affair.getBelongToTypeName(),
				affair.getId() };
		jdbcTemplate.update(sql, object);
	}

	public void deleteAffair(int id) {
		String sql="delete from affair where id=?";
		Object[] object={id};
		jdbcTemplate.update(sql, object);
	}

}
