package org.siva.ravipati;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.OracleCallableStatement;


public class JDBCCallableStatementOUTParameterExample {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		callOracleStoredProcOUTParameter(connection);
		callOracleStoredProcOUT_ResultSet(connection);
	}

	static void callOracleStoredProcOUTParameter(Connection connection) throws SQLException {
		String storedProcedureQuery = "call getEMPLOYEESById(?,?,?)";
		CallableStatement callableStatement = connection.prepareCall(storedProcedureQuery);
		
		callableStatement.setInt(1, 100);
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
		callableStatement.executeUpdate();
		
		String lastName = callableStatement.getString(2);
		Date hiredDate = callableStatement.getDate(3);
		System.out.println(":LastName : " + lastName+"	"+":HiredDate : " + hiredDate);
	}
	
	static void callOracleStoredProcOUT_ResultSet(Connection connection) throws SQLException {
		String storedProcedureQuery = "call get_emp_rs(?)";
		CallableStatement callableStatement = connection.prepareCall(storedProcedureQuery);
		
		callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
		callableStatement.execute();
		
		ResultSet rs = ((OracleCallableStatement)callableStatement).getCursor(1);
		while(rs.next()) {
			System.out.println(":LastName : " + rs.getString("LAST_NAME")+"	"+":HiredDate : " + rs.getDate("HIRE_DATE"));
		}
	}
	
}