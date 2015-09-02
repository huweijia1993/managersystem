package com.clps.managersystem.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.clps.managersystem.dao.BaseDao;
import com.clps.managersystem.dao.IQuestionDao;
import com.clps.managersystem.model.PageUtil;
import com.clps.managersystem.model.Question;

public class QuestionDaoImpl extends BaseDao<Question> implements IQuestionDao{

	/**
	 * 
	  * encapsulateQuestion
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: encapsulateQuestion
	  * @Description: 二次封装问题表
	  * @param @param list
	  * @param @return    
	  * @return List<Question>   
	  * @throws
	 */
	private List<Question> encapsulateQuestion(List<ArrayList<Object>> list){
		
		List<Question> questions=new ArrayList<Question>();
		for(ArrayList<Object> res:list){
			Question question=new Question();
			question.setQuestionId(Integer.parseInt(res.get(0).toString()));
			question.setQuestionContent(res.get(1).toString());
			questions.add(question);
			
		}
		return questions;
		
	}
	
	
	@Override
	public List<Question> list(String sql, Object[] paras) {
		return this.encapsulateQuestion(queryCommonList(sql, paras));
	}

	@Override
	public List<Question> list(String sql, Object para) {
		return this.list(sql, new Object[]{para});
	}

	@Override
	public List<Question> list(String sql) {
		return this.list(sql, null);
	}

	@Override
	public PageUtil<Question> listByPage(String sql, Object[] paras) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<Question> listByPage(String sql, Object para) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<Question> listByPage(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question queryObject(String sql, Object[] paras) {
		return null;
	}

	@Override
	public Question queryObject(String sql, Object para) {
		return null;
	}

	@Override
	public Question queryObject(String sql) {
		return null;
	}

}
