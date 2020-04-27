package com.test.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDao {

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password")) {
			// Oracle - jdbc:oracle:thin:@myhost:1521:mydb

			Statement st = conn.createStatement();

			// executeUpdate - for DML(Insert,update,delete)
			// executeQuery - select

			/*
			 * int result = statement.executeUpdate(
			 * "INSERT INTO account(accno,lastname,firstname,bal) values(2,\"Bhagwat\",\"Shashank\",200)"
			 * ); System.out.println(result);
			 */

			/*
			 * int result = statement.
			 * executeUpdate("Update  account set firstname='Manasa' where accno=2");
			 * System.out.println(result);
			 */

			/*
			 * int result = statement.executeUpdate( "DELETE FROM account where accno=1");
			 * System.out.println(result);
			 */

			ResultSet rs = st.executeQuery("Select * from account");
			while (rs.next()) {
				System.out.println(rs.getInt("bal"));
				System.out.println(rs.getString("lastname"));
				System.out.println(rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
