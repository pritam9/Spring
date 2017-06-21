package com.uncc.mhealth.job;

//STEP 1. Import required packages
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.uncc.mhealth.model.User;

public class LoginCreation {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/usersdb";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "mhealth";

	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';
	
	static final String csvFile = "/Users/jduvvu/Documents/UNCC/RA/VLogins.csv";

	public static void main(String[] args) throws Exception {
		
		//insertLoginsFromExcel();
		generateIdCardsHTML();
		
	}// end main
	
	public static void generateIdCardsHTML(){
		Scanner scanner=null;
		try {
			scanner = new Scanner(new File(csvFile));
			String body = "";
			String header = "<!DOCTYPE html>"+
						   "<html>"+
					       "<head>"+
						   "<title>Login Cards</title>"+
						   "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
						   "<link rel=\"stylesheet\" href=\"http://www.w3schools.com/lib/w3.css\">"+
						   "<style>"+
						   "hr { "+
						   "  border-top: 1px dashed #8c8b8b; "+
						   "} "+
						   "hr:after { "+
						   "  content: '\002702'; "+
						   "  display: inline-block; "+
						   "  position: relative; "+
						   "  top: -12px; "+
						   "  left: 40px; "+
						   "  padding: 0 3px; "+
						   "  background: #f0f0f0; "+
						   "  color: #8c8b8b; "+
						   "  font-size: 18px; "+
						   "}"+
						   "</style>"+
						   "</head>"+
						   "<body>"+
						   ""+
						   "<div class=\"w3-container\">"+
						   "  <h2>Login Cards</h2>";
			int count=0;
			while (scanner.hasNext()) {
				count=count+1;
				List<String> line = parseLine(scanner.nextLine());
			body = body+  "<div class=\"w3-card-4\" style=\"width:336px;margin:0 auto;\">"+
							"<header class=\"w3-container w3-blue\">"+
							"      <h1>"+line.get(1)+"</h1>"+
							" </header>"+
							""+
							" <div class=\"w3-container\" style=\"padding:10px;margin-left:25px;\">"+
							"  <table>"+
							"    <tr><td><p>User Name</p></td><td><p>:</p></td><td><p>"+line.get(2)+"</p></td></tr>"+
							"    <tr><td><p>Password</p></td><td><p>:</p></td><td><p>"+line.get(3)+"</p></td></tr>"+
							"  </table>"+
							" </div>"+
							"<footer class=\"w3-container w3-blue\">"+
							"   <h5>https://52.205.102.85/mHealth/</h5>"+
							"    </footer>"+
							"  </div><hr>";
			if(count==3){
				body = body+ "<div style=\"page-break-after: always;\"></div>";
				count=0;
			}
			}
			String footer = "</div>"+
							""+
							"</body>"+
							"</html>";
			System.out.println(header+body+footer);

								

			/*while (scanner.hasNext()) {
				List<String> line = parseLine(scanner.nextLine());
				System.out.println("Login [id= " + line.get(1) + ", userName= " + line.get(2) + " , Password="+ line.get(3) + "]");
			}*/
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(scanner!=null)
				scanner.close();
		}
	}
	
	public static void insertLoginsFromExcel(){

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean commitFlag=true;
		//String csvFile = "/Users/jduvvu/Documents/UNCC/RA/VLogins.csv";
		int count = -1;
		String sql = "INSERT INTO USERS (username,password,email,first_name,last_name,dob,token,nickname,randomized_id,detailsUpdated,istoApp,sixWeekFlag) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		Scanner scanner=null;
		try {
			scanner = new Scanner(new File(csvFile));

			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			while (scanner.hasNext()) {
				List<String> line = parseLine(scanner.nextLine());
				System.out.println("Login [id= " + line.get(1) + ", userName= " + line.get(2) + " , Password="+ line.get(3) + "]");
				User user = new User();
				user.setUsername(line.get(2));
				user.setPassword(line.get(3));
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				user.setEmail("dummy@uncc.edu");
				user.setFirstName("XXX");
				user.setLastName("XXX");
				user.setDob("999999");
				user.setDetailsUpdated("N");
				user.setIstoApp("Y");
				user.setSixWeekFlag("N");
				String auth_token = UUID.randomUUID().toString().toUpperCase() + "|" + user.getUsername() + "|"
						+ System.currentTimeMillis();
				user.setToken(auth_token);
				user.setNickname("XXX");
				// user.setRegistrationDate(new Date(System.currentTimeMillis()).toString());

				// STEP 4: Execute a query
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getFirstName());
				pstmt.setString(5, user.getLastName());
				pstmt.setString(6, user.getDob());
				pstmt.setString(7, user.getToken());
				pstmt.setString(8, user.getNickname());
				pstmt.setString(9, line.get(1));
				pstmt.setString(10, user.getDetailsUpdated());
				pstmt.setString(11, user.getIstoApp());
				pstmt.setString(12, user.getSixWeekFlag());

				count = pstmt.executeUpdate();
				if(count != 1 && commitFlag){	
					commitFlag=false;
				}
			}
		
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// STEP 6: Clean-up environment
			// finally block used to close resources
			try {
				if (commitFlag) {
					System.out.println("Success!!");
					conn.commit();
				} else {
					conn.rollback();
				}
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		if(scanner!=null)
			scanner.close();
		System.out.println("Goodbye!");
	
	}

	public static List<String> parseLine(String cvsLine) {
		return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separators) {
		return parseLine(cvsLine, separators, DEFAULT_QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

		List<String> result = new ArrayList();

		// if empty, return!
		if (cvsLine == null && cvsLine.isEmpty()) {
			return result;
		}

		if (customQuote == ' ') {
			customQuote = DEFAULT_QUOTE;
		}

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuffer curVal = new StringBuffer();
		boolean inQuotes = false;
		boolean startCollectChar = false;
		boolean doubleQuotesInColumn = false;

		char[] chars = cvsLine.toCharArray();

		for (char ch : chars) {

			if (inQuotes) {
				startCollectChar = true;
				if (ch == customQuote) {
					inQuotes = false;
					doubleQuotesInColumn = false;
				} else {

					// Fixed : allow "" in custom quote enclosed
					if (ch == '\"') {
						if (!doubleQuotesInColumn) {
							curVal.append(ch);
							doubleQuotesInColumn = true;
						}
					} else {
						curVal.append(ch);
					}

				}
			} else {
				if (ch == customQuote) {

					inQuotes = true;

					// Fixed : allow "" in empty quote enclosed
					if (chars[0] != '"' && customQuote == '\"') {
						curVal.append('"');
					}

					// double quotes in column will hit this!
					if (startCollectChar) {
						curVal.append('"');
					}

				} else if (ch == separators) {

					result.add(curVal.toString());

					curVal = new StringBuffer();
					startCollectChar = false;

				} else if (ch == '\r') {
					// ignore LF characters
					continue;
				} else if (ch == '\n') {
					// the end, break!
					break;
				} else {
					curVal.append(ch);
				}
			}

		}

		result.add(curVal.toString());

		return result;
	}

}// end