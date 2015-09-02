/**
 * @Title: MailUtil.java
 * @Package com.aust.shuyu.util
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:clps
 * 
 * @author Comsys-huweijia
 * @date 2015年8月5日 上午9:22:32
 * @version V1.0
 */


package com.clps.managersystem.utils;


import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

/**
 * @ClassName: MailUtil
 * @Description: TODO
 * @author Comsys-huweijia
 * @date 2015年8月5日 上午9:22:32
 *
 */

public class MailUtil{

	private static Logger logger=Logger.getLogger((MailUtil.class));//日志
	
	/**
	 * 
	  * @Title: addImage
	  * @Description: 创建带有内嵌图片
	  * @param @param messageText
	  * @param @param imagePath
	  * @param @return
	  * @param @throws MessagingException    
	  * @return MimeMultipart    
	  * @throws
	 */
	private static MimeMultipart addImage(String imagePath[]) throws MessagingException{
		MimeMultipart mm=new MimeMultipart();
		for(String image:imagePath){
			MimeBodyPart mp=new MimeBodyPart();
			DataHandler dh=new DataHandler(new FileDataSource(image));
			mp.setDataHandler(dh);
			mp.setContentID(FormatUtil.getFileName(image));
			
			mm.addBodyPart(mp);
		}
	
		return mm;
	}
	/**
	 * 
	  * @Title: addAttachment
	  * @Description: 处理带有附件的邮件
	  * @param @param attachments
	  * @param @return
	  * @param @throws MessagingException    
	  * @return MimeMultipart    
	  * @throws
	 */
	private static MimeMultipart addAttachment(String attachments[]) throws MessagingException{
		MimeMultipart mm=new MimeMultipart();
		for(String attachment:attachments){
			MimeBodyPart mp=new MimeBodyPart();
			DataHandler dh=new DataHandler(new FileDataSource(attachment));
			mp.setDataHandler(dh);
			mp.setFileName(attachment);
			
			mm.addBodyPart(mp);
		}
		
		return mm;
	}
	
	
	
	/**
	 * 
	  * @Title: setMailProperties
	  * @Description: 设置邮件服务基本属性
	  * @param @param smtpHost
	  * @param @param from
	  * @param @param fromUserPassword
	  * @param @return    
	  * @return Session    
	  * @throws
	 */
	private static Session setMailProperties(String smtpHost,String from,String fromUserPassword){
		Properties props=new Properties();
		props.put("mail.smtp.host", smtpHost);
		//例用tls验证需要加入属性mail.smtp.ssl.checkserveridentity 为false 不需要加入信任的服务器
		props.put("mail.smtp.starttls.enable", "true");//使用starttls安全连接
		props.put("mail.smtp.ssl.checkserveridentity",false);
		props.put("mail.smtp.auth", "true");//使用验证
		
		props.put("mail.smtp.ssl.trust", "smtp.qq.com");
		props.put("mail.smtp.port", 25);
		return Session.getInstance(props,new MyAuthenticator(from,fromUserPassword));
	}
	/**
	 * 
	  * @Title: setMailMessage
	  * @Description: 设置邮件信息
	  * @param @param from
	  * @param @param to
	  * @param @param mailSession
	  * @param @param subject
	  * @param @param messageText
	  * @param @param messageType
	  * @param @return
	  * @param @throws MessagingException    
	  * @return MimeMessage    
	  * @throws
	 */
	private static MimeMessage setMailMessage(String from,String to,Session mailSession,String subject,
			String messageText,String messageType,String imagePath[],String attachments[]) throws MessagingException{
		InternetAddress fromAddress=new InternetAddress(from);
		InternetAddress toAddress=new InternetAddress(to);
		
		MimeMessage message=new MimeMessage(mailSession);
	
		//设置来源
		message.setFrom(fromAddress);
		//设置目的地
		message.addRecipient(RecipientType.TO, toAddress);
		//加入日期
		message.setSentDate(Calendar.getInstance().getTime());
		//设置主题
		message.setSubject(subject);
		
		if(null==imagePath&&null==attachments){
			//纯文本数据 没有内嵌图片和附件
			message.setContent(messageText,messageType);
		}else if(imagePath!=null&&null==attachments){
//			//只有内嵌图片　没有附件
			//准备邮件正文数据
			MimeBodyPart text=new MimeBodyPart();
			text.setContent(messageText, messageType);

			//描述数据关系
			MimeMultipart mm=addImage(imagePath);
			mm.addBodyPart(text);
			mm.setSubType("related");
			message.saveChanges();
			//放进去
			message.setContent(mm);
		}else if(null==imagePath&&attachments!=null){
			//只有附件
			//准备邮件正文数据
			MimeBodyPart text=new MimeBodyPart();
			text.setContent(messageText, messageType);
		
			//处理附件
			MimeMultipart mm2=addAttachment(attachments);
		
			mm2.addBodyPart(text);
			mm2.setSubType("mixed");
			
			message.setContent(mm2);
			message.saveChanges();
		}else if(imagePath!=null&&attachments!=null){
			//图片和附件都有
			//准备邮件正文数据
			MimeBodyPart text=new MimeBodyPart();
			text.setContent(messageText, messageType);

			//描述数据关系
			MimeMultipart mm=addImage(imagePath);
			mm.addBodyPart(text);
			mm.setSubType("related");
			message.saveChanges();
		
			//处理附件
			MimeMultipart mm2=addAttachment(attachments);
			
			//代表正文的bodypart
			MimeBodyPart content=new MimeBodyPart();
			content.setContent(mm);
			mm2.addBodyPart(content);
			mm2.setSubType("mixed");
			
			message.setContent(mm2);
			message.saveChanges();
			
		}
	
		return message;
	}

	
	/**
	 * 
	  * @Title: sendMail
	  * @Description: 邮件发送 只有正文
	  * @param @param smtpHost
	  * @param @param from
	  * @param @param fromUserPassword
	  * @param @param to
	  * @param @param subject
	  * @param @param messageText
	  * @param @param messageType
	  * @param @throws MessagingException    
	  * @return void    
	  * @throws
	 */
	public static void sendMail(String to,String subject,
			String messageText) throws MessagingException{

		sendMail(to,subject,messageText,null);
	}
	/**
	 * 
	  * @Title: sendMail
	  * @Description: 带图片的邮件
	  * @param @param smtpHost
	  * @param @param from
	  * @param @param fromUserPassword
	  * @param @param to
	  * @param @param subject
	  * @param @param messageText
	  * @param @param messageType
	  * @param @param imagePath
	  * @param @throws MessagingException    
	  * @return void    
	  * @throws
	 */
	public static void sendMail(String to,String subject,
			String messageText,String imagePath[]) throws MessagingException {
		sendMail(to,subject,messageText,imagePath,null);
	}
	
	/**
	 * 
	  * @Title: sendMail
	  * @Description: 发送带有附件的邮件
	  * @param @param smtpHost
	  * @param @param from
	  * @param @param fromUserPassword
	  * @param @param to
	  * @param @param subject
	  * @param @param messageText
	  * @param @param messageType
	  * @param @param imagePath
	  * @param @param attachment
	  * @param @throws MessagingException    
	  * @return void    
	  * @throws
	 */
	public static void sendMail(String to,String subject,
			String messageText,String imagePath[],String attachment[]) throws MessagingException {
	
		Properties properties=FileUtil.getProperties(FileUtil.getClassesFile("mail.properties"));
		
		String userName=properties.getProperty("fromUserName");
		String password=properties.getProperty("fromPassword");
		String hostName=properties.getProperty("hostName");
		//String to=properties.getProperty("toUserName");
		//String subject=properties.getProperty("subject");
		//String messageText=properties.getProperty("messageText");
		String messageType=properties.getProperty("messageType");
		
		
		logger.info("为"+hostName+"配置mail　session对象");
		//获取session
		Session mailSession=setMailProperties(hostName,userName,password);
		logger.info("编写信息from--to:"+userName+"--"+to);
		
		MimeMessage message=setMailMessage(userName,to,mailSession,subject,messageText,messageType,imagePath,attachment);
	
		logger.info("发送信息");
		Transport transport=mailSession.getTransport("smtp");
		transport.connect(hostName,userName,password);
		logger.info("连接成功");
		Transport.send(message,message.getRecipients(RecipientType.TO));
		logger.info("发送成功");
	
	
	}
	
}

/**
 * 
  * @ClassName: MyAuthenticator
  * @Description: 处理发送方用户名验证
  * @author Comsys-huweijia
  * @date 2015年8月5日 上午9:34:28
  *
 */
class MyAuthenticator extends Authenticator{
	private String userName="";
	private String password="";
	
	public MyAuthenticator(){
		
	}
	
	public MyAuthenticator(String userName,String password){
		this.userName=userName;
		this.password=password;
	}
	
	/**
	 * 用户名密码验证
	 */
	
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName,password);
	}
	
}





