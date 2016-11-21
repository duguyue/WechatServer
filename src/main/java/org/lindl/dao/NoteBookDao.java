package org.lindl.dao;

import java.util.List;

import org.lindl.entity.NoteBook;

public interface NoteBookDao {
	void addNoteBook(NoteBook noteBook);

	void updateNoteBook(NoteBook noteBook);

	void deleteNoteBook(int id);

	List<NoteBook> queryNoteBook();

	NoteBook queryNoteBookById(int id);
}
