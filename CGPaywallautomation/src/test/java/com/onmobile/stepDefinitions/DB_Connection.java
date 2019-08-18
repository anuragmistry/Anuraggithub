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

import com.onmobile.dataProvider.PropertyReader;

import cucumber.api.java.en.When;

public class DB_Connection {
	static Logger Log = LogManager.getLogger("test");
	static String DBType=DM_Flow.getCurrentDBType();
	
	@When("^Connect to DB$")
	public static String Connect_to_DB_And_fetch_Data(String query,String type) throws ClassNotFoundException, SQLException {
		String result = null;
		String DBurl =null;
		if(type.equalsIgnoreCase("Griff_DB")) {
			DBurl=PropertyReader.readItem("Griff_DB_url");
		}
		if(type.equalsIgnoreCase("Packs_DB")) {
			DBurl=PropertyReader.readItem("Packs_DB_url");
		}
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
		//String dbUrl = "jdbc:mysql://172.16.5.199:3306/mneeds_griff";					

		//Database Username		
		String username = "root";	

		//Database Password		
		String password = "root";				

		//Load mysql jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Create Connection to DB
		Connection conn=DriverManager.getConnection(DBurl,username,password);

		//Create Statement Object	
		Statement stmt=conn.createStatement();

		// Execute the SQL Query. Store results in ResultSet	
		ResultSet resultSet= stmt.executeQuery(query);
		// While Loop to iterate through all data and print results		
		while (resultSet.next()){	
			result=resultSet.getString(1);
			Log.info("Value Got from DB -->"+result);
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		// closing DB Connection		
		conn.close();
		return result;

	}
	@When("^Connect with SQL Server DB$")
	public static Map<String, Object> ConnectSQLServerDB(String query,String DM_DB) throws SQLException, ClassNotFoundException { 
		String dbURL=null;
		String user=null;
		String pass=null;
		Map<String,Object> map = new LinkedHashMap<>();
		//	String dbURL = "jdbc:sqlserver://172.19.110.140:1433;databaseName=DigitalMarketing_auto";
		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbURL = PropertyReader.readItem("DIAUS_DB_URL");
			user  = PropertyReader.readItem("DIAUS_DB_User");
			pass  = PropertyReader.readItem("DIAUS_DB_Pass");
			Log.info("DB Connection Login Credential->"+dbURL+" User->"+user+" Pass->"+pass);
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = PropertyReader.readItem("DIAUS_UK_DB_URL");
			user  = PropertyReader.readItem("DIAUS_UK_DB_User");
			pass  = PropertyReader.readItem("DIAUS_UK_DB_Pass");
			Log.info("DB Connection Login Credential->"+dbURL+" User->"+user+" Pass->"+pass);
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
			dbURL = PropertyReader.readItem("DIAUS_DB_URL");
			user  = PropertyReader.readItem("DIAUS_DB_User");
			pass  = PropertyReader.readItem("DIAUS_DB_Pass");
			Log.info("DB Connection Login Credential->"+dbURL+" User->"+user+" Pass->"+pass);
		}
		if(DIAUSDB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = PropertyReader.readItem("DIAUS_UK_DB_URL");
			user  = PropertyReader.readItem("DIAUS_UK_DB_User");
			pass  = PropertyReader.readItem("DIAUS_UK_DB_Pass");
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

	public static ResultSet Connect_MariaDB(String query,String type) throws ClassNotFoundException, SQLException {
		    Connection conn = null;
	        Statement stmt = null;
	        ResultSet resultSet=null;
	       String dbURL = PropertyReader.readItem("MARIA_DIAUS_DB_URL");
	       String user  = PropertyReader.readItem("MARIA_DIAUS_DB_User");
	       String pass  = PropertyReader.readItem("MARIA_DIAUS_DB_Pass");
	       
	        try {
	            //STEP 2: Register JDBC driver
	            Class.forName("org.mariadb.jdbc.Driver");
	            //STEP 3: Open a connection
	            System.err.println("Connecting to a selected database...");
	            Log.info("DB Connection Login Credential->"+dbURL+" User->"+user+" Pass->"+pass);
	            conn = DriverManager.getConnection(dbURL,user,pass);
	            System.err.println("Connected database successfully...");

	          //Create Statement Object	
	    	    stmt=conn.createStatement();
	            resultSet= stmt.executeQuery(query);
	        
	        } catch (SQLException se) {
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            //Handle errors for Class.forName
	            e.printStackTrace();
	        } finally {
	            //finally block used to close resources
	            try {
	                if (stmt != null) {
	                    conn.close();
	                }
	            } catch (SQLException se) {
	            }// do nothing
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }//end finally try
	        }//end try
	        System.out.println("Done!");
			
			return resultSet;
	   
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
		ResultSet rs=null;
		if(DBType.equalsIgnoreCase("MSSQLSERVER")) {
			rs=Connect_SQLServerDB(query,DIAUSDB);
		}
		if(DBType.equalsIgnoreCase("MARIADB")) {
			rs=Connect_MariaDB(query,DIAUSDB);
		}

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
	
	public static boolean DeleteRow(String type,String query)
	{
		boolean status=false;
		String DBurl =null;
		if(type.equalsIgnoreCase("Griff_DB")) {
			DBurl=PropertyReader.readItem("Griff_DB_url");
		}
		if(type.equalsIgnoreCase("Packs_DB")) {
			DBurl=PropertyReader.readItem("Packs_DB_url");
		}
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
		//String dbUrl = "jdbc:mysql://172.16.5.199:3306/mneeds_griff";					

		//Database Username		
		String username = "root";	

		//Database Password		
		String password = "root";						
		try 
		{  
			//Loading the required JDBC Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Creating a connection to the database
			Connection conn = DriverManager.getConnection(DBurl,username,password);
			PreparedStatement st = conn.prepareStatement(query);
			int deleteCount=st.executeUpdate(); 
			Log.info("Number of Row delete Count-->"+deleteCount);

			if (deleteCount > 0) {             
				System.err.println("Successfully Deleted");
				Log.info("Successfully Deleted.....");
				status=true;            
			} else {
				System.err.println("ERROR OCCURED OR Table has Empty Record");
				Log.info("Table has Empty Records.....");
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
		//ResultSet rs=Connect_SQLServerDB(query,DiausDB);
		
		ResultSet rs=null;
		if(DBType.equalsIgnoreCase("MSSQLSERVER")) {
			 rs=Connect_SQLServerDB(query,DiausDB);
		}
		if(DBType.equalsIgnoreCase("MARIADB")) {
			rs=Connect_MariaDB(query,DiausDB);
		}
		
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
	public static boolean DeleteRow(String Number,String DM_DB,String query)
	{
		boolean status=false;
		String dbURL=null;
		String user=null;
		String pass=null;
	//	Map<String,Object> map = new LinkedHashMap<>();
		//	String dbURL = "jdbc:sqlserver://172.19.110.140:1433;databaseName=DigitalMarketing_auto";
		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbURL = PropertyReader.readItem("DIAUS_DB_URL");
			user  = PropertyReader.readItem("DIAUS_DB_User");
			pass  = PropertyReader.readItem("DIAUS_DB_Pass");
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = PropertyReader.readItem("DIAUS_UK_DB_URL");
			user  = PropertyReader.readItem("DIAUS_UK_DB_User");
			pass  = PropertyReader.readItem("DIAUS_UK_DB_Pass");
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
			
	/*		if (deleteCount > 0) {             
                System.err.println("Successfully Deleted");
                status=true;            
			} else {
                System.err.println("ERROR OCCURED ");   
			}
			*/
			if (deleteCount > 0) {             
                System.err.println("Successfully Deleted");
                status=true;            
			}
			else {
                System.err.println("Nothing to delete ");
                status=false;
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	public static boolean MariaDB_DeleteRow(String Number,String DM_DB,String query)
	{
		boolean status=false;
		String dbURL=null;
		String user=null;
		String pass=null;
	
		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbURL = PropertyReader.readItem("MARIA_DIAUS_DB_URL");
			user  = PropertyReader.readItem("MARIA_DIAUS_DB_User");
			pass  = PropertyReader.readItem("MARIA_DIAUS_DB_Pass");
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbURL = PropertyReader.readItem("DIAUS_UK_DB_URL");
			user  = PropertyReader.readItem("DIAUS_UK_DB_User");
			pass  = PropertyReader.readItem("DIAUS_UK_DB_Pass");
		}
		
		try 
		{  
			Class.forName("org.mariadb.jdbc.Driver");
            System.err.println("Connecting to a selected database...");
            Connection conn = DriverManager.getConnection(dbURL,user,pass);
            System.err.println("Connected database successfully...");
			
			PreparedStatement st = conn.prepareStatement(query);
			int deleteCount=st.executeUpdate(); 
			Log.info("Number of Row delete Count-->"+deleteCount);

			if (deleteCount > 0) {             
                System.err.println("Successfully Deleted");
                status=true;            
			}
			else {
                System.err.println("Nothing to delete ");
                status=false;
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return status;
	}
	
	
	
	/*public static Map<String, Object> GetDMLogDetailsBasedOnActivityType(String query,String DiausDB) throws ClassNotFoundException, SQLException, InterruptedException {

		Map<String,Object> map = new LinkedHashMap<>();
		ResultSet resultset;

		for(int i=0;i<30;i++) {

			resultset=Connect_SQLServerDB(query,DiausDB);
			int count=DB_Connection.GetRowCountforDMLogEntry(resultset);

			if(count==1) {
				Log.info("Expected DM Log Entry is Created for Activity Type");
				int column = resultset.getMetaData().getColumnCount();
				for (int j = 1; j < column + 1; j++) {
					System.out.print(resultset.getMetaData().getColumnName(j));
					System.out.print(resultset.getString(j));
					
					System.out.print(" " + resultset.getMetaData().getColumnName(j) + "=" + resultset.getObject(j));
					map.put(resultset.getMetaData().getColumnName(j), resultset.getObject(j));
				}

				Log.info("All Column data-->"+map);
				break;
			}else {
				Thread.sleep(5000);
				System.err.println("Waiting ..................");
			}
		}

		return map;
	}*/
	
}
