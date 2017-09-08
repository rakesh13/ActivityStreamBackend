package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.UserMessageDao;
import com.stackroute.ActivityStreamBackend.model.UserMessage;




@Repository(value="userMessageDao")
@Component
@Transactional
public class UserMessageDaoImpl implements UserMessageDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean sendMessage(UserMessage usrmessage) {
		try
		{
			sessionFactory.getCurrentSession().save(usrmessage);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}

	public boolean deleteMessage(int messageId) {
		UserMessage userMessage=(UserMessage) sessionFactory.getCurrentSession().createCriteria(UserMessage.class).add(Restrictions.eq("messageId", messageId)).uniqueResult();
		if(userMessage!=null)
		{
			sessionFactory.getCurrentSession().delete(userMessage);
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<UserMessage> getMyMessages(String emailId) {
		return sessionFactory.getCurrentSession().createCriteria(UserMessage.class).add(Restrictions.eq("senderEmailId", emailId)).list();
		
	}

}
