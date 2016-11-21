package org.lindl.service;

import java.util.ArrayList;
import java.util.List;

import org.lindl.dao.NoteBookDao;
import org.lindl.entity.NoteBook;
import org.lindl.entity.Result;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class NoteBookService {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addNoteBook(NoteBook note) {
		String sql = "insert into notebook(content,flag) values (?,?)";
		Object[] object = { note.getContent(), note.getFlag() };
		jdbcTemplate.update(sql, object);
	}

	public void updateNoteBook(NoteBook note) {
		String sql = "update notebook set content=?,flag=? where id=?";
		Object[] object = { note.getContent(), note.getFlag(), note.getId() };
		jdbcTemplate.update(sql, object);
	}

	public void deleteNoteBook(int id) {
		String sql = "delete from notebook where id=?";
		Object[] object = { id };
		jdbcTemplate.update(sql, object);
	}

	public Result queryNoteBooks(int page, int pageSize) {
		List<NoteBook> list = new ArrayList<NoteBook>();
		List<Object> dataList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from notebook ");
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
			NoteBook noteBook = new NoteBook();
			noteBook.setId(rs.getInt("id"));
			noteBook.setContent(rs.getString("content"));
			noteBook.setFlag(rs.getInt("flag"));
			noteBook.setUserId(rs.getString("userId"));

			list.add(noteBook);
		}
		if (list.size() > 0) {
			return new Result(0, list, "", countNoteBooks());
		}
		return new Result(-1, "错误信息");
	}

	public int countNoteBooks() {
		int num = 0;
		String sql = "select count(id) as num from notebook";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			num = rs.getInt("num");
		}
		return num;
	}
	
	public NoteBook queryNoteBookById(int id) {
		String sql = "select * from notebook where id=?";
		Object[] object = { id };
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, object);
		NoteBook noteBook = null;
		while (rs.next()) {
			noteBook.setId(rs.getInt("id"));
			noteBook.setContent(rs.getString("content"));
			noteBook.setFlag(rs.getInt("flag"));
		}
		return noteBook;
	}

}
