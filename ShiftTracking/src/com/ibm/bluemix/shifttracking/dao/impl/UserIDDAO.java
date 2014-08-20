package com.ibm.bluemix.shifttracking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bluemix.shifttracking.beans.*;
import com.ibm.bluemix.shifttracking.dao.inter.*;
import com.ibm.bluemix.shifttracking.util.*;
import com.mongodb.*;

public class UserIDDAO implements IUserIDDAO {

	private DBCollection users;

	public UserIDDAO() {
		users = SimpleMongoDBHelper.getCollection("users");
	}

	@Override
	public boolean add(UserIDBean bean) {
		BasicDBObject user = new BasicDBObject();
		user.put("userid", bean.getUserID());
		user.put("password", bean.getPassword());
		user.put("answer", bean.getAnswer());
		users.insert(user);
		return true;
	}

	@Override
	public boolean remove(UserIDBean bean) {
		BasicDBObject user = new BasicDBObject();
		user.put("userid", bean.getUserID());
		users.remove(user);
		return true;
	}

	@Override
	public boolean update(UserIDBean bean) {

		BasicDBObject search = new BasicDBObject().append("userid",
				bean.getUserID());

		BasicDBObject newObj = new BasicDBObject();
		newObj.append("$set",
				new BasicDBObject().append("password", bean.getPassword())
						.append("answer", bean.getAnswer()));

		users.update(search, newObj);

		return true;
	}

	@Override
	public boolean delete(UserIDBean bean) {
		return remove(bean);
	}

	@Override
	public UserIDBean find(String userID) {
		UserIDBean bean = null;
		BasicDBObject query = new BasicDBObject();
		query.put("userid", userID.trim());
		DBCursor cursor = users.find(query);
		if (cursor.hasNext()) {
			DBObject b = cursor.next();
			bean = new UserIDBean();
			bean.setUserID(b.get("userid").toString());
			bean.setPassword(b.get("password").toString());
			bean.setAnswer(b.get("answer").toString());
		}
		return bean;
	}

	@Override
	public boolean clearPassword(String userID, String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll () {
		users.drop();
		return true;
	}
	@Override
	public List<UserIDBean> getAllUsers() {
		List<UserIDBean> allusers = new ArrayList<UserIDBean> ();
		DBCursor cursor = users.find();
		while (cursor.hasNext()) {
			DBObject b = cursor.next();
			//System.out.println(b);
			UserIDBean bean = new UserIDBean();
			bean.setUserID(b.get("userid").toString());
			bean.setPassword(b.get("password").toString());
			bean.setAnswer(b.get("answer").toString());
			allusers.add(bean);
		}
		return allusers;
	}

}
