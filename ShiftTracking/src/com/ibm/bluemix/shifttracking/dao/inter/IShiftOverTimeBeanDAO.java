package com.ibm.bluemix.shifttracking.dao.inter;

import com.ibm.bluemix.shifttracking.beans.*;
import java.util.*;

public interface IShiftOverTimeBeanDAO {
	public boolean add2ndShift(EmployeeBean emp, ProjectBean project, Date d);
	public boolean addOvertime(EmployeeBean emp, ProjectBean project, Date d);
	public boolean delete2ndShift(EmployeeBean emp, ProjectBean project, Date d);
	public boolean deleteOvertime(EmployeeBean emp, ProjectBean project, Date d);
	public boolean add3rdShift(EmployeeBean emp, ProjectBean project, Date d);
	public boolean delete3rdShift(EmployeeBean emp, ProjectBean project, Date d);
	public List<Date> getAll2ndShifts(EmployeeBean emp, ProjectBean project);
	public List<Date> getAll3rdShifts(EmployeeBean emp, ProjectBean project);
	public List<Date> getAllOvertimes(EmployeeBean emp, ProjectBean project);

}
