package com.hms.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.User;
import com.model.Intr.UserIntr;

public class UserDao implements UserIntr {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void insertUser(User user) {
		jt.update("insert into patient_info(name , bloodgroup,disease)values('"+user.getName()+"','"+user.getBloodgroup()+"','"+user.getDisease()+"'"+")");
		
	}

	@Override
	public Map selectUser(int id) {
		Map m= jt.queryForMap("select * from patient_info where id='"+id+"'");
		return m;
	}

	@Override
	public List getAllUsers() {
		List l = jt.queryForList("select * from patient_info");
		return l;
	}

	@Override
	public void updateUser(User user) {
	jt.update("update patient_info set name='"+user.getName()+"', bloodgroup='"+user.getBloodgroup()+"',disease='"+user.getDisease()+"' where id ='"+user.getId()+"'");
		
	}

	@Override
	public void deleteUser(int id) {
		jt.update("delete from patient_info where id = '"+id+"'");
		
	}
  
	
	 
}
