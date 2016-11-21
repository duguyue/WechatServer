package org.lindl.dao;

import java.util.List;

import org.lindl.entity.AffairType;

public interface AffairTypeDao {
	void addAffairType(AffairType affairType);

	void updateAffairType(AffairType affairType);

	void deleteAffairType(int id);

	List<AffairType> queryAffairType();

	AffairType queryAffairTypeById(int id);
}
