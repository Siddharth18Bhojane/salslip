package javagui;
import java.sql.*;
import javax.swing.*;
public class Emp {

	
	public static Connection ConnectDB()
	{
		try
		{
			Class.forName("org.sqltite.JDBC");
			Connection conn = DriverManager.getConnection
					("jdbc:sqlite:C:\\Users\\SIDDHARTH\\eclipse-workspace\\salslip\\employee.db");
					JOptionPane.showMessageDialog(null, "Connection Made");
					return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Connection Made");
			return null;
		}
	}
}
