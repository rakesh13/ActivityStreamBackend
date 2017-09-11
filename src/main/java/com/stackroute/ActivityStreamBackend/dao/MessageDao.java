package com.stackroute.ActivityStreamBackend.dao;

import java.util.List;

import com.stackroute.ActivityStreamBackend.model.Message;




public interface MessageDao {

	boolean sendMessage(Message message);
	
	//This method should not be in MessageDAO (if UserMessageDAO there) - think about it.
	List<Message> getMyMessages(String emailId);//create a private method in daoimpl class getmycircleids(email id)
	//boolean sendMessageToUser(String emailId);
}
