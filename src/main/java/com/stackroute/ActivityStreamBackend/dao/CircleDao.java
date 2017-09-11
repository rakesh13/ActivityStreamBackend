package com.stackroute.ActivityStreamBackend.dao;

import java.util.List;

import com.stackroute.ActivityStreamBackend.model.Circle;



public interface CircleDao {

	boolean addCircle(Circle circle);
	boolean deleteCircle(String emailId,String circleName);
	List<Circle> getAllCircles();
	
	
	//What you are expecting from this method?  All the Circles of the User?
	// If yes, you won't get this information from CrcieDAO.
	//From CircleDAO, you will get all the circles created by a particular user.
	//Let us discuss..
	List<Circle> getCircleByUser(String emailId);
	Circle getCircleByName(String circleName);
}

