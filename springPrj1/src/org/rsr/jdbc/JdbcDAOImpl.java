package org.rsr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDAOImpl {
	@Autowired
	private DataSource dataSource;
	
	//private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	//@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	// this class has supports both jdbcTemplate and NamedParameterJdbcTemplate
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public Object getEmployee() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			System.out.println("Connection Established to DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getExecutivesCount() {
		String str = "Select count(*) from Executives";
		//This is one way to get jdbc templat and initialize datasource
		//jdbcTemplate.setDataSource(dataSource);
		
		//Second way is to initialize at the time of datasource setter method called. we need to autowire setter method instead of field.
		//@Autowired
		//public void setDataSource(DataSource dataSource) {
		//	jdbcTemplate = new JdbcTemplate(dataSource);
		//}
		
		//Third way is to define at bean xml file
		
		return jdbcTemplate.queryForInt(str);
	}
	
	public String getExecutiveName(int id) {
		String sql = "select first_name from Executives where emp_id=?";
		
		String name = jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
		//String name = jdbcTemplate.queryForObject(sql, String.class);
		return name;
	}
	
	public Executives getExecutiveForID(int empId) {
		String sql = "select * from Executives where emp_id=?";
		Executives executives = jdbcTemplate.queryForObject(sql, new Object[] {empId}, new ExecutivesMapper());
		return executives;
	}
	
	private static final class ExecutivesMapper implements RowMapper<Executives> {
		@Override
		public Executives mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Executives executives = new Executives();
			executives.setEmpId(String.valueOf(resultSet.getInt("EMP_ID")));
			executives.setFirstName(resultSet.getString("FIRST_NAME"));
			executives.setLastName(resultSet.getString("LAST_NAME"));
			executives.setState(resultSet.getString("STATE"));
			
			return executives;
		}
	}

	
	public void insert(Executives executives){
//		String sql = "INSERT INTO Executives " +"(EMP_ID, FIRST_NAME, LAST_NAME, STATE) VALUES (?, ?, ?, ?)";
//		Connection conn = null;
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, Integer.valueOf(executives.getEmpId()));
//			ps.setString(2, executives.getFirstName());
//			ps.setString(3, executives.getLastName());
//			ps.setString(4, executives.getState());
//			ps.executeUpdate();
//			ps.close();
// 
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
// 
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {}
//			}
//		}
		//String sql = "INSERT INTO Executives " +"(EMP_ID, FIRST_NAME, LAST_NAME, STATE) VALUES (?, ?, ?, ?)";
		//jdbcTemplate.update(sql, new Object[] {executives.getEmpId(), executives.getFirstName(), executives.getLastName(), executives.getState()});
		
		String sql = "INSERT INTO Executives " +"(EMP_ID, FIRST_NAME, LAST_NAME, STATE) VALUES (:id, :firstName, :lastName, :state)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", executives.getEmpId())
														.addValue("firstName", executives.getFirstName())
														.addValue("lastName", executives.getLastName())
														.addValue("state", executives.getState());
		
		int i = namedParameterJdbcTemplate.update(sql, namedParameters);
		System.out.println("Return Result>>>"+i);
		
	}
 
	public Executives findByCustomerId(int custId){
 
		String sql = "SELECT * FROM executives WHERE EMP_ID = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Executives executives = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				executives = new Executives();
				executives.setEmpId(String.valueOf(rs.getInt("EMP_ID")));
				executives.setFirstName(rs.getString("FIRST_NAME"));
				executives.setLastName(rs.getString("LAST_NAME"));
				executives.setState(rs.getString("STATE"));
			}
			rs.close();
			ps.close();
			return executives;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	//@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
}
