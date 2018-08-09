package com.enoca.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component("userDAO")
public class UserDAO {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	public List<User> getUsers() {
		return jdbc.query("select * from jiraUsers", new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("NAME"));
				u.setSurname(rs.getString("SURNAME"));
				u.setMail(rs.getString("MAIL"));
				u.setPassword("PASSWORD");
				return u;
			}
		});
	}

	public List<User> getUsersByName(String name) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		return jdbc.query("select * from jiraUsers where NAME=:name",params, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("idUser"));
				u.setName(rs.getString("NAME"));
				u.setSurname(rs.getString("SURNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setMail(rs.getString("MAIL"));
				return u;
			}
		});
	}

	public User getUserById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from jiraUsers where ID = :id", params, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("NAME"));
				u.setSurname(rs.getString("SURNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setMail(rs.getString("MAIL"));
				return u;
			}
		});
	}
	public User getUserByMail(String mail) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("mail", mail);
		return jdbc.queryForObject("select * from jiraUsers where MAIL = :mail", params, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("NAME"));
				u.setSurname(rs.getString("SURNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setMail(rs.getString("MAIL"));
				return u;
			}
		});
	}

	public boolean createUser(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

		return jdbc.update("insert into jiraUsers (NAME,SURNAME,MAIL,PASSWORD) values (:name,:surname,:mail,:password)",params) == 1;
	}

	public int deleteById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("delete from jiraUsers where ID=:id", params);
	}
	public int deleteByMail(String mail) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("mail", mail);
		return jdbc.update("delete from jiraUsers where MAIL=:mail", params);
	}
	public int update(User u) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", u.getId());
		params.addValue("name", u.getName());
		params.addValue("surname", u.getSurname());
		params.addValue("mail", u.getMail());
		params.addValue("password", u.getPassword());
		return jdbc.update("update jiraUsers set NAME=:name,SURNAME=:surname,MAIL=:mail,PASSWORD=:password where ID=:id", params);
	}
	
	public User loginUser(String email,String password) throws EmptyResultDataAccessException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("mail", email);
		params.addValue("password", password.hashCode());
		return jdbc.queryForObject("select * from jiraUsers where MAIL = :mail AND PASSWORD =:password", params, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("ID"));
				u.setName(rs.getString("NAME"));
				u.setSurname(rs.getString("SURNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setMail(rs.getString("MAIL"));
				return u;
			}
		});
	}
	
	
	
}
