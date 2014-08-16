package com.ibm.bluemix.shifttracking.dao.inter;

import com.ibm.bluemix.shifttracking.beans.*;

public interface IUserIDDAO {
	public boolean add(UserIDBean bean);
	public boolean remove(UserIDBean bean);
	public boolean update(UserIDBean bean);
	public boolean delete(UserIDBean bean);
	public UserIDBean find(String userID);
	public boolean clearPassword(String userID, String answer);

}
