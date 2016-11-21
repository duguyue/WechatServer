package org.lindl.service;

import java.util.ArrayList;
import java.util.List;

import org.lindl.dao.UserDao;
import org.lindl.entity.Result;
import org.lindl.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserService {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Result addUser(User user) {
		String sql = "insert into user(userId,username,password,last_login) values(?,?,?,?)";
		Object[] object = { user.getUserId(), user.getUsername(),
				user.getPassword(), user.getLast_get() };
		int row = jdbcTemplate.update(sql, object);
		if (row == 1) {
			return new Result(0, "添加用户成功");
		}
		return new Result(-1, "添加用户失败");
	}

	public Result updateUser(User user) {
		String sql = "update user set username=?,password=?,last_login=?,coin=? where id=?";
		Object[] object = { user.getUsername(), user.getPassword(),
				user.getLast_get(), user.getCoin(), user.getId() };
		int row = jdbcTemplate.update(sql, object);
		if (row == 1) {
			return new Result(0, "更新成功");
		}
		return new Result(-1, "更新失败");
	}

	public Result deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id=?";
		Object[] objects = { id };
		int row = jdbcTemplate.update(sql, objects);
		if (row == 1) {
			return new Result(0, "删除成功");
		}
		return new Result(-1, "删除失败");
	}

	public int countUsers() {
		int num = 0;
		String sql = "select count(id) as num from user";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}

	public Result queryUsers(int page, int pageSize) {
		List<User> list = new ArrayList<User>();
		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from user ");
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
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserId(rs.getString("userId"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setLast_get(rs.getString("last_login"));
			user.setCoin(rs.getInt("coin"));

			list.add(user);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countUsers());
		}
		return new Result(-1, "错误信息");
	}

	public User queryUserById(int id) {
		String sql = "select * from user where id=?";
		Object[] objects = { id };
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, objects);
		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUserId(rs.getString("userId"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setCoin(rs.getInt("coin"));
			user.setLast_get(rs.getString("last_login"));
		}
		return user;
	}

	public Result isHasUser(String username, String password) {
		String sql = "select * from user where username=? && password=?";
		Object[] object = { username, password };
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, object);
		if (rs.next()) {
			return new Result(0, username);
		}
		return new Result(-1, "登录失败");
	}

}
