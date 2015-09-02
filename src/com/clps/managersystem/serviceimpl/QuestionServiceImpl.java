package com.clps.managersystem.serviceimpl;

import java.util.List;

import com.clps.managersystem.dao.IBaseDao;
import com.clps.managersystem.daofactory.IBaseDaoFactory;
import com.clps.managersystem.daofactory.QuestionDaoFactory;
import com.clps.managersystem.model.Question;
import com.clps.managersystem.service.IQuestionService;
import com.clps.managersystem.transaction.TransactionCallback;
import com.clps.managersystem.transaction.TransactionTemplate;

public class QuestionServiceImpl implements IQuestionService{

	private IBaseDaoFactory<Question> ibf=new QuestionDaoFactory();
	
	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions=TransactionTemplate.execute(new TransactionCallback<List<Question>>(){

			@Override
			public List<Question> doInTransaction() {
				String sql="select * from question";
				return ibf.createDao().list(sql, null);
			}
			
		});
		
		
		return questions;
	}
	
	public boolean addQuestionAnswer(final Question question,final int userId){
		boolean flag=TransactionTemplate.execute(new TransactionCallback<Boolean>(){

			@Override
			public Boolean doInTransaction() {	
				String sql1="insert into user_qa (user_id,question_id,answer) values(?,?,?)";
				String sql2="update user set user_active=1 where user_id="+userId;
				String paras[]=new String[]{userId+"",question.getQuestionId()+"",question.getAnswer()};
				IBaseDao<Question> ibd=ibf.createDao();
				if(ibd.add(sql1,paras)!=0){
					return ibd.update(sql2);
				}
				
				return false;
			}
			
		});
		return flag;
	}
	

}
