package com.ypm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ypm.interfaces.IUserDao;
import com.ypm.model.User;
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserInfoByUserName(String userName) {

		String sql = "select a.*,authority   from users a ,authorities b where a.id = b.users_id and username='"+userName+"'";
		List<User>userList =    jdbcTemplate.query(sql,new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setAuthorities(rs.getString("authority"));
				user.setEnabled(rs.getBoolean("enabled"));
				user.setUsername(userName);
				user.setPassword(rs.getString("password"));
				return user;
			}
			 
		 });
		return userList.get(0);
//		return jdbcTemplate.queryForObject("select a.*,authority   from user ,authorities b where a.id = b.users_id and username="+userName, User.class);

	}

}
