package org.lindl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lindl.entity.NoteBook;
import org.lindl.entity.Result;
import org.lindl.service.NoteBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoteBookController {

	@Resource
	NoteBookService noteBookService;

	@ResponseBody
	@RequestMapping(value = "/queryNoteBooks")
	public Result queryNoteBook(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		return noteBookService.queryNoteBooks(page, pageSize);
	}

	@RequestMapping("/addNoteBookUI.action")
	public String addNoteBookUI() throws Exception {
		return "addNoteBook";
	}

	@RequestMapping("/addNoteBook.action")
	public String addNoteBook(NoteBook noteBook) throws Exception {
		// TODO 添加用户数据，同时更新缓存
		noteBookService.addNoteBook(noteBook);

		return "redirect:queryNoteBook.action";
	}

	@RequestMapping("/deleteNoteBook.action")
	public String deleteNoteBook(int id) {
		// TODO 删除数据库中指定的记录，然后删除缓存中指定的数据
		noteBookService.deleteNoteBook(id);

		return "redirect:queryNoteBook.action";
	}
}
