package com.onmobile.stepDefinitions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.onmobile.utils.Util;

import cucumber.api.java.en.When;

public class DB_Connection {
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
    WebDriver webdriver = Launcher.getdriver();
   
	@When("^Connect with SQL Server DB$")
	public static Map<String, Object> ConnectSQLServerDB(String query,String DM_DB) throws SQLException, ClassNotFoundException { 
		String dbURL=null;
		String user=null;
		String pass=null;
		Map<String,Object> map = new LinkedHashMap<>();
		//	String dbURL = "jdbc:sqlserver://172.19.110.140:1433;databaseName=DigitalMarketing_auto";
		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbURL = Launcher.CFR.getProperty("DIAUS_DB_URL");
			user  = Launcher.CFR.getProperty("DIAUS_DB_User");
			pass  = Launcher.CFR.getProperty("DIAUS_DB_Pass");
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = Launcher.CFR.getProperty("DIAUS_UK_DB_URL");
			user  = Launcher.CFR.getProperty("DIAUS_UK_DB_User");
			pass  = Launcher.CFR.getProperty("DIAUS_UK_DB_Pass");
		}
		//Loading the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	

		//Creating a connection to the database
		Connection conn = DriverManager.getConnection(dbURL,user,pass);

		//Executing SQL query and fetching the result
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {

			int row = rs.getRow();
			Log.info("Number of Row->"+row);

			if(row>=1) {
				int column = rs.getMetaData().getColumnCount();
				for (int i = 1; i < column + 1; i++) {
					//	System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
					map.put(rs.getMetaData().getColumnName(i), rs.getObject(i));

				}

			}

		}
		Log.info("All Column data-->"+map);
		conn.close();
		return map;
	}
	public static ResultSet Connect_SQLServerDB(String query,String DIAUSDB) throws SQLException, ClassNotFoundException { 

		String dbURL=null;
		String user=null;
		String pass=null;
		//	String dbURL = "jdbc:sqlserver://172.19.110.140:1433;databaseName=DigitalMarketing_auto";
		if(DIAUSDB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbURL = Launcher.CFR.getProperty("DIAUS_DB_URL");
			user  = Launcher.CFR.getProperty("DIAUS_DB_User");
			pass  = Launcher.CFR.getProperty("DIAUS_DB_Pass");
			Log.info("DB Connection Login Credential->"+dbURL+" User->"+user+" Pass->"+pass);
		}
		if(DIAUSDB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = Launcher.CFR.getProperty("DIAUS_UK_DB_URL");
			user  = Launcher.CFR.getProperty("DIAUS_UK_DB_User");
			pass  = Launcher.CFR.getProperty("DIAUS_UK_DB_Pass");
			Log.info("DB Connection Login Credential->"+dbURL+" User->"+user+" Pass->"+pass);
		}
		//	String dbURL = "jdbc:sqlserver://172.19.110.140:1433;databaseName=DigitalMarketing_auto";
		//	String dbURL = PropertyReader.readItem("DIAUS_DB_URL");
		//Loading the required JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	

		//Creating a connection to the database
		Connection conn = DriverManager.getConnection(dbURL,user,pass);

		//Executing SQL query and fetching the result
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(query);

		//	conn.close();
		return rs;
	}


	public static Map<Integer, Map<String, Object>> GetDMLogDataRowBased(String query,String DiausDB) throws ClassNotFoundException, SQLException {
		//Connect to the Server and pass the query and DB Detials Like: DIAUS_UK or DIAUS_INDIA
		//And Get the RS Data and Get the data row based and store in map.
		//Inside Map we are store <Key is RowNum,Value is All Column val>
		ResultSet rs=Connect_SQLServerDB(query,DiausDB);
		Map<Integer,Map<String,Object>> LogInfo = new LinkedHashMap<>();
		while (rs.next()) {
			int row = rs.getRow();
			Log.info("Number of Row->"+row);
			Map<String,Object> map = new LinkedHashMap<>();
			if(row>=1) {
				int column = rs.getMetaData().getColumnCount();
				for (int i = 1; i < column + 1; i++) {
					System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
					map.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
				}
			}
			LogInfo.put(row, map);
		}
		Log.info("All Column data-->"+LogInfo);
		return LogInfo;
	}
	public static int CountRowEntry(String query,String DIAUSDB) throws SQLException, ClassNotFoundException {
		int count=0;
		ResultSet rs=Connect_SQLServerDB(query,DIAUSDB);

		while (rs.next()) {
			int row = rs.getRow();
			
			Log.info("Number of Row Count-->"+row);
			count  = rs.getInt("colCount");
			Log.info("Number of Entry Count-->"+count);
			String result=rs.getString(1);
			System.err.println("Get the Num of count from DB -->"+result);
			
			
		}
		return count;
	}
	
	public static boolean DeleteRow(String Number,String DM_DB,String query)
	{
		boolean status=false;
		String dbURL=null;
		String user=null;
		String pass=null;
		Map<String,Object> map = new LinkedHashMap<>();
		//	String dbURL = "jdbc:sqlserver://172.19.110.140:1433;databaseName=DigitalMarketing_auto";
		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbURL = Launcher.CFR.getProperty("DIAUS_DB_URL");
			user  = Launcher.CFR.getProperty("DIAUS_DB_User");
			pass  = Launcher.CFR.getProperty("DIAUS_DB_Pass");
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = Launcher.CFR.getProperty("DIAUS_UK_DB_URL");
			user  = Launcher.CFR.getProperty("DIAUS_UK_DB_User");
			pass  = Launcher.CFR.getProperty("DIAUS_UK_DB_Pass");
		}
		
		try 
		{  
			//Loading the required JDBC Driver class
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			//Creating a connection to the database
			Connection conn = DriverManager.getConnection(dbURL,user,pass);
			PreparedStatement st = conn.prepareStatement(query);
			int deleteCount=st.executeUpdate(); 
			Log.info("Number of Row delete Count-->"+deleteCount);
			
			if (deleteCount > 0) {             
                System.err.println("Successfully Deleted");
                status=true;            
			}
			else {
                System.err.println("Nothing to delete ");
                status=true;
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static Map<String, Object> GetDMLogDetailsBasedOnActivityType(String query,String DiausDB) throws ClassNotFoundException, SQLException {
		//Connect to the Server and pass the query and DB Detials Like: DIAUS_UK or DIAUS_INDIA
		//And Get the RS Data and Get the data row based and store in map.
		//Inside Map we are store <Key is RowNum,Value is All Column val>
		ResultSet rs=Connect_SQLServerDB(query,DiausDB);
		Map<String,Object> DMLogInfo = new LinkedHashMap<>();
		while (rs.next()) {
			int row = rs.getRow();
			Log.info("Number of Row->"+row);
			
			if(row>=1) {
				int column = rs.getMetaData().getColumnCount();
				for (int i = 1; i < column + 1; i++) {
					System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
					DMLogInfo.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
				}
			}
			
		}
		Log.info("All Column data-->"+DMLogInfo);
		return DMLogInfo;
	}
}
