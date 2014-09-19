package com.ibm.hrnotes.shifttracking.dao.inter;

import com.ibm.hrnotes.shifttracking.entites.*;

public interface IManagerDao {
	public boolean add(Manager manager);
	public boolean update(Manager manager);
	public Manager getByEmail(String email);
	public Manager get(Integer id);
}
