package com.clps.managersystem.daofactory;

import com.clps.managersystem.dao.IBaseDao;
import com.clps.managersystem.daoimpl.QuestionDaoImpl;
import com.clps.managersystem.model.Question;

public class QuestionDaoFactory implements IBaseDaoFactory<Question>{

	@Override
	public IBaseDao<Question> createDao() {
		// TODO Auto-generated method stub
		return new QuestionDaoImpl();
	}

}
