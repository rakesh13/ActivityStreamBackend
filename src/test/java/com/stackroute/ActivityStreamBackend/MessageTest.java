package com.stackroute.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.ActivityStreamBackend.dao.MessageDao;
import com.stackroute.ActivityStreamBackend.model.Message;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@EnableAspectJAutoProxy
public class MessageTest {

	@Autowired
	 private Message message;
	@Autowired
	private MessageDao messageDao;
	
	@Ignore
	@Test
	public void sendMessageTest()
	{
		
		message.setMaximumSize(1000000);
		message.setMessageText("Hi....");
		message.setMessageSize(message.getMessageText().length());
		message.setMessageType("Text");
		message.setSenderEmailId("rakesh@gmail.com");
		message.setReceiverEmailId("ramesh@gmail.com");
		assertEquals(true, messageDao.sendMessage(message));
	}
	
	@Ignore
	@Test
	public void getMessagesByIdTest()
	{
		message.setReceiverEmailId("ramesh@gmail.com");
		List<Message> messages=messageDao.getMyMessages(message.getReceiverEmailId());
		assertEquals(1, messages.size());
	}
}
