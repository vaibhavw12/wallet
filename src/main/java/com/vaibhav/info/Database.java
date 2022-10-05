package com.vaibhav.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Database {
	public static Connection create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/wallet";
			String uname = "root";
			String pass = "@mysql";
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			return con;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String name;
	public boolean save(User user) {
		Connection con = Database.create();
		int status = 0; 
		try {
			
			//value insert in database
			PreparedStatement ps=con.prepareStatement("insert into user (name,phone,email,pass,balance) values(?,?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getBalance());
			//executing query
		    status= ps.executeUpdate();
		}catch (SQLIntegrityConstraintViolationException e) {
			return false;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==1) {
			return true;
		}else {
			return false;
		}
	
	}


	public boolean success(String email, String pass) {
		// TODO Auto-generated method stub
		Connection con = Database.create();
		
		try {
			PreparedStatement ps=con.prepareStatement("select name from user where email=? and pass=?");
			ps.setString(1,email);
			ps.setString(2,pass);
		//	System.out.println(ps.executeUpdate());
			ResultSet rs = ps.executeQuery();
			boolean b = rs.next();
			name=rs.getString(1);
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return false;
	}
	
	public static String giveBalance(String email) {
		Connection con = Database.create();
		try {
			PreparedStatement ps=con.prepareStatement("select balance from user where email=?");
			ps.setString(1,email);
		//	System.out.println(ps.executeUpdate());
			ResultSet rs = ps.executeQuery();
			rs.next();
			String get_balance = rs.getString(1);
			return get_balance;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
		
	}
	
	public static boolean updateBalance(String email, String amount) {
		Connection con = Database.create();
		//System.out.println(email +"," + amount);
		try {
			String get_balance = Database.giveBalance(email);
			Long bal_inital = Long.parseLong(get_balance);
			Long amount_credit = Long.parseLong(amount);
			Long bal_updated = bal_inital + amount_credit;
			//System.out.println(bal_updated);
			PreparedStatement ps = con.prepareStatement("update user set balance = ? where email = ?");
			ps.setString(1,bal_updated+"");
			ps.setString(2,email);
			ps.executeUpdate();
			LocalDateTime myDateObj = LocalDateTime.now();
		  //  System.out.println("Before formatting: " + myDateObj);
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
		 //   System.out.println("After formatting: " + formattedDate);
			String value = "amount credited " +amount +"rs at "+formattedDate;
			if(transctions(email,value)) {
				//System.out.println("transctions successfull");
			}else {
				//System.out.println("transctions unsuccessfull");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}


	private static boolean transctions(String email, String value) {
		// TODO Auto-generated method stub
		Connection con = Database.create();
		int status = 0; 
		try {
			
			//value insert in database
			PreparedStatement ps=con.prepareStatement("insert into transctions (email,detail) values(?,?)");
			ps.setString(1, email);
			ps.setString(2, value);
			//executing query
		    status= ps.executeUpdate();
		}catch (SQLIntegrityConstraintViolationException e) {
			return false;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static ArrayList<String> printTranctions(String email){
		ArrayList<String> trans = new ArrayList<>();
		Connection con = Database.create();

		try {
			PreparedStatement ps=con.prepareStatement("select detail from transctions where Email=?");
			ps.setString(1,email);
		//	System.out.println(ps.executeUpdate());
			ResultSet rs = ps.executeQuery();
	//		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			
	//		boolean b = rs.next();
			int i = 1;
//			trans.add(i + ". " + rs.getString(1)+" ");
//			i++;
			while(rs.next()) {
			        
			           trans.add(i + ". " + rs.getString(1)+" ");
			           i++;
			           
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}


	public static boolean debitBalance(String email, String amount) {
		// TODO Auto-generated method stub
		
		Connection con = Database.create();
		//System.out.println(email +"," + amount);
		try {
			String get_balance = Database.giveBalance(email);
			Long bal_inital = Long.parseLong(get_balance);
			Long amount_debit = Long.parseLong(amount);
			if(amount_debit > bal_inital) {
				return false;
			}
			Long bal_updated = bal_inital - amount_debit;
			//System.out.println(bal_updated);
			PreparedStatement ps = con.prepareStatement("update user set balance = ? where email = ?");
			ps.setString(1,bal_updated+"");
			ps.setString(2,email);
			ps.executeUpdate();
			LocalDateTime myDateObj = LocalDateTime.now();
		  //  System.out.println("Before formatting: " + myDateObj);
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
		 //   System.out.println("After formatting: " + formattedDate);
			String value = "amount debited " +amount +"rs at "+formattedDate;
			if(transctions(email,value)) {
				//System.out.println("transctions successfull");
			}else {
				//System.out.println("transctions unsuccessfull");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
}
