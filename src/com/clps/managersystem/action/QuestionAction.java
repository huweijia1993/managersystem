package com.clps.managersystem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.clps.managersystem.model.Question;
import com.clps.managersystem.model.User;
import com.clps.managersystem.service.IQuestionService;
import com.clps.managersystem.utils.FileUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionAction extends ActionSupport implements ModelDriven<Question>,SessionAware{

	/**
	  * @Fields serialVersionUID : TODO
	  */
	
	private static final long serialVersionUID = 4192793984117399757L;

	private IQuestionService iqs=(IQuestionService)FileUtil.createNewInstance("IQuestionService");
	private List<Question> questionList;
	private Question question=new Question();
	private Map<String,Object> session;
	private String message;//附加信息
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Map<String, Object> getSession() {
		return session;
	}



	public List<Question> getQuestionList() {
		return questionList;
	}



	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	


	public void setQuestion(Question question) {
		this.question = question;
	}


	/**
	 * 
	  * goQuestionForm
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: goQuestionForm
	  * @Description: 跳转到questioninfo，为添加或修改问题准备数据
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String goQuestionForm(){
		questionList=iqs.getAllQuestion();
		return SUCCESS;
	}
	/**
	 * 
	  * addQuestion
	  * TODO Applicable conditions
	  * TODO	Execution process
	  * TODO	use-method
	  * TODO	attention
	  *
	  * @Title: addQuestion
	  * @Description: 完成添加问题
	  * @param @return    
	  * @return String   
	  * @throws
	 */
	public String addQuestion(){
		User user=(User)session.get("user");
		int id=user.getUserId();
		System.out.println(question.toString());
		boolean flag=iqs.addQuestionAnswer(question, id);
		if(flag){
			message="添加成功";
			user.setUserActive(true);
			return SUCCESS;
		}else{
			message="添加失败";
			return INPUT;
		}	
	}
	
	

	@Override
	public Question getModel() {
		return question;
	}



	@Override
	public void setSession(Map<String, Object> session) {
			this.session=session;
	}
	
	
}
