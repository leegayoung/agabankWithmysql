package databaseInfos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataBaseWork extends DBBaseInfo {
	//내가 있는 계좌 보여주기
	public void showAcc(String ssNumber) {
		String em[] = new String[10];
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");

			String query = "SELECT * from acc_info where ssNumber = '" + ssNumber + "'";
			st = (Statement) con.createStatement();
			dataSave d = new dataSave();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			int i =0;
			while (rs.next() && i<3 ) {
				System.out.println(d.getMyacc());
				em[0] = rs.getString("myName");
				em[1] = rs.getString("ssNumber");
				em[2] = rs.getString("phone");
				em[3] = rs.getString("balance");
				em[4] = rs.getString("passWord");
				em[5] = rs.getString("pattern");
				em[6] = rs.getString("mlimit");
				em[7] = rs.getString("slimit");
				em[8] = rs.getString("account");
				em[9] = rs.getString("monthAmount");
				System.out.println("em8 = "+em[8]);
				d.accAll[i] = em[0]+"&"+em[8]+"&"+em[3];
				System.out.println("fddasaaf : "+d.accAll[i]);
				i++;
			}
			if(i <3)
			{
				dataSave s = new dataSave();
				for(;i<3;i++)
					s.info[i] = "-";
			}
			// iterate through the java resultset
			con.close();
			st.close();
		} catch (Exception e) {
			// System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	

	// 계좌계설
	public void createAcc(String myName, String ssNumber, String phone, String balance, int password, int pattern,
			String mlimit, String slimit) {
		try {
			Random random = new Random();
			Class.forName(driver);
			String acc = "1";
			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			for(int i=0 ;i<14; i++){
				int randomInt = random.nextInt(10);
				if(i ==6)acc+="-";
				acc+= Integer.toString(randomInt);
			}
			System.out.println(acc);
			dataSave ds = new dataSave();
			ds.setMyacc(acc);

			String query = "insert into Acc_info values('" + myName + "','" + ssNumber + "','" + phone + "','" + balance
					+ "','" + password + "','" + pattern + "','" + mlimit + "','" + slimit + "','" + acc+ "','" + "0" + "')";
			st = (Statement) con.createStatement();
			int rs = st.executeUpdate(query);
			con.close();
			st.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	// 회원가입
	public void insetUser(String myName, String ssNumber, String phone) {
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");

			String query = "insert into User_info values('" + myName + "','" + ssNumber + "','" + phone + "')";
			st = (Statement) con.createStatement();
			int rs = st.executeUpdate(query);
			con.close();
			st.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	//user_info db에 있는 값을 주민번호를 이용해서 리턴
	public String allInfo_User_Info(String ssNumber, int index) {
		String em[] = new String[3];
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");

			String query = "SELECT * FROM user_info where ssNumber ='" + ssNumber + "'";

			st = (Statement) con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				em[0] = rs.getString("myName");
				em[1] = rs.getString("ssNumber");
				em[2] = rs.getString("phone");
				System.out.println(em[2]);
			}
			// iterate through the java resultset
			con.close();
			st.close();
		} catch (Exception e) {
			// System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		try {
			return em[index];
		} catch (NullPointerException e) {// 값이 없으면 거짓반환
			// TODO: handle exception
			return "0";
		}
	}

	
	//acc_info db에 있는 값을 계좌번호를 이용해서 리턴
	public String allInfo_Acc_Info(String acc, int index) {
		String em[] = new String[10];
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			
			String query = "SELECT * FROM acc_info where account ='" + acc + "'";
			System.out.println("Fdfdf");
			
			st = (Statement) con.createStatement();
			
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				em[0] = rs.getString("myName");
				em[1] = rs.getString("ssNumber");
				em[2] = rs.getString("phone");
				em[3] = rs.getString("balance");
				em[4] = rs.getString("passWord");
				em[5] = rs.getString("pattern");
				em[6] = rs.getString("mlimit");
				em[7] = rs.getString("slimit");
				em[8] = rs.getString("account");
				em[9] = rs.getString("monthAmount");
				System.out.println(em[6]);
			}
			// iterate through the java resultset
			if(con.isClosed()){
			con.close();
			st.close();
			}
		} catch (Exception e) {
			// System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		try {
			return em[index];
		} catch (NullPointerException e) {// 값이 없으면 거짓반환
			// TODO: handle exception
			return "0";
		}
	}

	// 계좌가 존재하는지 확인! 값이 똑같으면 있다는 것
	public boolean Check_Acc(String acc) {
		String value = allInfo_Acc_Info(acc,8);
		System.out.println(acc);
		System.out.println("dfd "+value);
		if(value == null)
		return false;
		if(value.equals(acc))
			return true;
		else
		return false;
		
	}
	

	// 주민번호가 맞는지보다는 있는지??
	public boolean Check_ssNumber(String ssNumber) {
		String value = allInfo_User_Info(ssNumber, 1);
		if(value == null)
			return false;
		if(value.equals(ssNumber))
			return true;
		else
		return false;
	}

	// 한달 동안 쓴 금액 리턴
	public String return_MonthAmount(String acc) {
		String value = allInfo_Acc_Info(acc, 9);
		if(value.equals(acc))
			return value;
		else
		return "0";
	}

	// 이름을 리턴해준다 -> 거래내역에 넣으려구
	public String return_Name_Acc_Info(String acc) {
		String value = allInfo_Acc_Info(acc, 0);
		if(value == null) return "0";
		if(value.equals(null))
			return "0";
		return value;	
	}
	// 이름을 리턴해준다 근데 주민번호를 이용해서~~
	public String return_Name_User_Info(String ssNumber) {
		String value = allInfo_User_Info(ssNumber, 0);
		if(value == null) return "0";
		if(value.equals(null))
			return "0";
		return value;	
	}
	
	//핸폰을 리턴해준다 -> 거래내역에 삽입
	public String return_Phone(String acc) {
		String value = allInfo_Acc_Info(acc, 2);
		if(value.equals(null))
			return "0";
		return value;
	}
	//핸폰을 리턴해준다  하지만 주민번호를 통해
	public String return_Phone_User_Info(String ssNumber) {
		String value = allInfo_User_Info(ssNumber, 2);
		if(value.equals(null))
			return "0";
		return value;
	}

	// 패스워드가 맞는지
	public boolean match_Password(String acc, int pw) {
		String value = allInfo_Acc_Info(acc, 4);
		System.out.println(value);
		if(value == null)
		{
			return false;
		}
		
		if(value.equals(String.valueOf(pw)))
			return true;
		else
			return false;

	}
	//출금
	public Boolean withdraw(String acc, String money, String type) {

			try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			st = (Statement) con.createStatement();
			
			int DepositAmount = Integer.parseInt(money); // 뺄값, 출금액
			String balance = allInfo_Acc_Info(acc,3); // 내가 가지고 이쓴ㄴ 값
			//System.out.println(balance);
			DepositAmount = Integer.parseInt(balance) - DepositAmount;
			System.out.println(DepositAmount);
			boolean check =  withdraw_possible(acc, DepositAmount, money);
			if(check == false)return false;
			add_MonthAmount(acc,money);
			
			
			String query = "update acc_info set balance='" + DepositAmount + "'" + "where account='" + acc + "'";
			
			st.executeUpdate(query);
			//System.out.println("마지막 : " + allInfo_Acc_Info("1111111-10101010",3));
			con.close();
			st.close();
			SavingTransaction(return_Name_Acc_Info(acc)," ",return_Phone(acc),type,"-"+money,Integer.toString(DepositAmount),"출금",acc);
		} catch (Exception e) {
			System.out.println("여기 오류1");
			System.err.println(e.getMessage());
		}
			return true;

	}

	//입금
	public void deposit(String acc, String money) {
		// String em = null;
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			st = (Statement) con.createStatement();
			
			int DepositAmount = Integer.parseInt(money); // 입금액
			String balance = allInfo_Acc_Info(acc,3); // 내가 가지고 이쓴ㄴ 값
			//System.out.println(balance);
			DepositAmount = Integer.parseInt(balance) + DepositAmount;
			String query = "update acc_info set balance='" + DepositAmount + "'" + "where account='" + acc + "'";
			
			st.executeUpdate(query);
			System.out.println("마지막 : " + allInfo_Acc_Info("1111111-10101010",3));
			con.close();
			st.close();
			SavingTransaction(return_Name_Acc_Info(acc)," ",return_Phone(acc)," ",money,Integer.toString(DepositAmount),"입금",acc);

		} catch (Exception e) {
			System.out.println("여기 오류");
			System.err.println(e.getMessage());
		}

	}
	
	//무통장실행
	public void noPassbook(String ssNumber, String receiverAcc , String money, String type){
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			st = (Statement) con.createStatement();
			
			int DepositAmount = Integer.parseInt(money); // 입금액
			String balance = allInfo_Acc_Info(receiverAcc,3); // 내가 가지고 이쓴ㄴ 값
			//System.out.println(balance);
			DepositAmount = Integer.parseInt(balance) + DepositAmount;
			String query = "update acc_info set balance='" + DepositAmount + "'" + "where account='" + receiverAcc + "'";
			st.executeUpdate(query);
			//System.out.println("마지막 : " + allInfo_Acc_Info(receiverAcc,3));
			con.close();
			st.close();
			SavingTransaction(return_Name_Acc_Info(receiverAcc),return_Name_User_Info(ssNumber),return_Phone(receiverAcc),type,money,Integer.toString(DepositAmount),"입금",receiverAcc);
			
		} catch (Exception e) {
			System.out.println("여기 오류 noPassbook");
			System.err.println(e.getMessage());
		}

	}
	
	//송금
	public boolean remittance(String myAcc, String receiverAcc, String money,String type){
			try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			st = (Statement) con.createStatement();
			
			//내 계좌에서 출금
			int DepositAmount = Integer.parseInt(money); // 출금액
			String balance = allInfo_Acc_Info(myAcc,3); // 내가 가지고 이쓴ㄴ 값
			DepositAmount = Integer.parseInt(balance) - DepositAmount; //db에 들어갈, 모든 계산이 끝난 값
			boolean check =  withdraw_possible(myAcc, DepositAmount, money);
			System.out.println("ch : "+ check);
			if(check == false)return false;
			add_MonthAmount(myAcc,money);
			
			String query = "update acc_info set balance='" + DepositAmount + "'" + "where account='" + myAcc + "'";
			st.executeUpdate(query);
			SavingTransaction(return_Name_Acc_Info(myAcc),return_Name_Acc_Info(receiverAcc),return_Phone(myAcc),type,"-"+money,Integer.toString(DepositAmount),"송금",myAcc);
			
			//상대방 계좌에 입금
			DepositAmount = Integer.parseInt(money);;
			balance = allInfo_Acc_Info(receiverAcc,3); // 상대방이 가지고 있는 값
			DepositAmount = Integer.parseInt(balance) + DepositAmount;
			query = "update acc_info set balance='" + DepositAmount + "'" + "where account='" + receiverAcc + "'";
			st.executeUpdate(query);
			SavingTransaction(return_Name_Acc_Info(receiverAcc),return_Name_Acc_Info(myAcc),return_Phone(receiverAcc)," ",money,Integer.toString(DepositAmount),"입금",receiverAcc);
			con.close();
			st.close();
			
			
		} catch (Exception e) {
			System.out.println("여기 오류 remittance");
			System.err.println(e.getMessage());
		}
			return true;
	}
	
	//거래내역 추가
	public void SavingTransaction(String myName, String receiver, String phone, String type,String amount,
			String balance, String note, String ssNumber) {
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");

			String query = "insert into Transaction values(" + "now()" + ",'" + myName + "','" + receiver+"','" + phone+"','" 
			+ type+"','" + amount+"','" + balance+"','" + note+"','" + ssNumber + "')";
			st = (Statement) con.createStatement();
			st.executeUpdate(query);
			con.close();
			st.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public boolean withdraw_possible(String myAcc, int DepositAmount, String money){
		dataSave ds = new dataSave();
		if (DepositAmount < 0) {
			System.out.println("잔액이 부족합니다");
			ds.setWidthDrawPos(1);
			return false;
		}
		if(Integer.parseInt(allInfo_Acc_Info(myAcc,7)) < Integer.parseInt(money)){
			ds.setWidthDrawPos(2);
			System.out.println("지출한도가 넘은 금액입니다");
			return false;
		}
		if(Integer.parseInt(allInfo_Acc_Info(myAcc,9))+Integer.parseInt(money) > Integer.parseInt(allInfo_Acc_Info(myAcc,6))){
			ds.setWidthDrawPos(3);
			System.out.println("한달지출한도를 넘었습니다");
			return false;
		}
		ds.setWidthDrawPos(0);
		return true;
	}
	
	//내가 출금 했을때 한달 지출금액을 늘려준다
	public void add_MonthAmount(String myAcc,String money){
		int monthAmount = Integer.parseInt(allInfo_Acc_Info(myAcc,9));
		monthAmount = monthAmount + Integer.parseInt(money);
		try {
			String query = "update acc_info set monthAmount='" + monthAmount + "'" + "where account='" + myAcc + "'";
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("그래서 한달동안 쓴 금액은 : "+Integer.parseInt(allInfo_Acc_Info(myAcc,9)));
	}
	
	public void balancecheck(String acc){
		String em[] = new String[10];
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");

			String query = "SELECT * FROM Transaction where account ='" + acc + "' order by date desc";

			st = (Statement) con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			int i =0;
			while (rs.next() && i<5 ) {
				em[0] = rs.getString("date");
				em[1] = rs.getString("myName");
				em[2] = rs.getString("receiver");
				em[3] = rs.getString("phone");
				em[4] = rs.getString("type");
				em[5] = rs.getString("amount");
				em[6] = rs.getString("balance");
				em[7] = rs.getString("note");
				em[8] = rs.getString("account");
				dataSave s = new dataSave();
				s.info[i] = em[0]+"&"+em[1]+"&"+em[2]+"&"+em[3]+"&"+em[4]+"&"+em[5]+"&"+em[6]+"&"+em[7];
				//s.info[i] = em[1]+"&"+em[2]+"&"+em[3]+"&"+em[4]+"&"+em[5]+"&"+em[6]+"&"+em[7];
				
				i++;
			}
			// iterate through the java resultset
			con.close();
			st.close();
		} catch (Exception e) {
			// System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	// 타입으로 거래내역 출력
	public void typecheck(String acc, String type){
		String em[] = new String[10];
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");

			String query = "SELECT * FROM Transaction where account ='" + acc + "' and type ='"+type+"' order by date desc";

			st = (Statement) con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			int i =0;
			while (rs.next() && i<5 ) {
				em[0] = rs.getString("date");
				em[1] = rs.getString("myName");
				em[2] = rs.getString("receiver");
				em[3] = rs.getString("phone");
				em[4] = rs.getString("type");
				em[5] = rs.getString("amount");
				em[6] = rs.getString("balance");
				em[7] = rs.getString("note");
				em[8] = rs.getString("account");
				dataSave s = new dataSave();
				s.info[i] = em[0]+"&"+em[1]+"&"+em[2]+"&"+em[3]+"&"+em[4]+"&"+em[5]+"&"+em[6]+"&"+em[7];
				i++;
			}
			if(i <5)
			{
				dataSave s = new dataSave();
				for(;i<5;i++)
					s.info[i] = "-";
			}
			// iterate through the java resultset
			con.close();
			st.close();
		} catch (Exception e) {
			// System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	
	
	public void rename(String ssNumber, String name){
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			st = (Statement) con.createStatement();
			
			
			String query = "update user_info set myName='" + name + "'" + "where ssNumber='" + ssNumber + "'";
			st.executeUpdate(query);
			String query2 = "update acc_info set myName='" + name + "'" + "where ssNumber='" + ssNumber + "'";
			st.executeUpdate(query2);
			
			con.close();
			st.close();
			
			
		} catch (Exception e) {
			System.out.println("여기 오류 rename");
			System.err.println(e.getMessage());
		}
	}
	
	public void repassword(String acc, String password){
		try {
			Class.forName(driver);

			con = (Connection) DriverManager.getConnection(jdbcUrl, "bank1", "1111");
			st = (Statement) con.createStatement();
			
			
			String query = "update acc_info set password='" + password + "'" + "where account='" + acc + "'";
			st.executeUpdate(query);
			
			con.close();
			st.close();
			
			
		} catch (Exception e) {
			System.out.println("여기 오류 repassword");
			System.err.println(e.getMessage());
		}
	}
}
