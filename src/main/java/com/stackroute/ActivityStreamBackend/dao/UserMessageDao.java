package com.stackroute.ActivityStreamBackend.dao;

import java.util.List;

import com.stackroute.ActivityStreamBackend.model.UserMessage;




public interface UserMessageDao {

	boolean sendMessage(UserMessage usrmessage);
	boolean deleteMessage(int messageId);
	List<UserMessage> getMyMessages(String emailId);
}
