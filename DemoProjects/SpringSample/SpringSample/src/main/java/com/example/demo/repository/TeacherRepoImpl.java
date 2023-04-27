package com.example.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Teachers;

@Repository
public class TeacherRepoImpl implements TeacherRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insertTeacherRecord(Teachers teacher) {

		String sql = "insert into teachers" + "(id,name,language) values (?,?,?)";
		// KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, teacher.getId());
				ps.setString(2, teacher.getName());
				ps.setString(3, teacher.getLanguage());
				return ps;
			}
		});

	}

	public List<Teachers> findAllTeachers() {

		String SELECT_ALL_QUERY = "SELECT * from Teachers";

		List<Teachers> list = jdbcTemplate.query(SELECT_ALL_QUERY, new EmployeeMapper());

		return list;

	}
	
	@Override
	public Teachers findTeacher(int id) {
		String SELECT_BY_ID_QUERY = "SELECT id, name, language from Teachers where id = ?";
		Teachers teacher = jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new EmployeeMapper(),id);
		return teacher;
	}  

	private static final class EmployeeMapper implements RowMapper<Teachers> {
		public Teachers mapRow(ResultSet rs, int rowNum) throws SQLException {
			Teachers emp = new Teachers();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setLanguage(rs.getString("language"));
			return emp;
		}
	}

}
