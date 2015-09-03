package com.clps.managersystem.service;

import java.util.List;

import com.clps.managersystem.model.Question;

public interface IQuestionService {

	/**
	 * 
	  * getAllQuestion
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getAllQuestion
	  * @Description: 获取所有question
	  * @param @return    
	  * @return List<Question>   
	  * @throws
	 */
	public List<Question> getAllQuestion();
	
	/**
	 * 
	  * addQuestionAnswer
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: addQuestionAnswer
	  * @Description: 为用户添加安全问题
	  * @param @param question
	  * @param @param userId
	  * @param @return    
	  * @return boolean   
	  * @throws
	 */
	public boolean addQuestionAnswer(Question question,int userId);
	
	/**
	 * 
	  * getQuestionByUserId
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: getQuestionByUserId
	  * @Description: 根据用户id获取问题
	  * @param @param id
	  * @param @return    
	  * @return Question   
	  * @throws
	 */
	public Question getQuestionByUserId(int id);
	
	
	public boolean updateUserQuestion(Question question,int userId);
	
	
	
}
