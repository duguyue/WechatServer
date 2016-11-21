package org.lindl.dao;

import java.util.List;

import org.lindl.entity.Affair;

public interface AffairDao {
	void addAffair(Affair affair);

	void updateAffair(Affair affair);

	void deleteAffair(int id);

	List<Affair> queryAffairs();

	Affair queryAffairById(int id);
}
