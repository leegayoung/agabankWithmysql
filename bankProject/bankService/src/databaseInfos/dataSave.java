package databaseInfos;

public class dataSave {
	
	static String myacc = null;
	static String receiverAcc = null;
	static String money = null;
	static String type = null;
	static String ssNumber = null;
	static String name = null;
	static String receiverName = null;
	public static String []info = new String[5];
	public static String []accAll = new String[3];
	static int widthDrawPos = 0;
	
	
	public static int getWidthDrawPos() {
		return widthDrawPos;
	}
	public static void setWidthDrawPos(int widthDrawPos) {
		dataSave.widthDrawPos = widthDrawPos;
	}
	static int password = 0;
	public static String getMyacc() {
		return myacc;
	}
	public static void setMyacc(String myacc) {
		dataSave.myacc = myacc;
	}
	public static String getReceiverAcc() {
		return receiverAcc;
	}
	public static void setReceiverAcc(String receiverAcc) {
		dataSave.receiverAcc = receiverAcc;
	}
	public static String getMoney() {
		return money;
	}
	public static void setMoney(String money) {
		dataSave.money = money;
	}
	public static String getType() {
		return type;
	}
	public static void setType(String type) {
		dataSave.type = type;
	}
	public static String getSsNumber() {
		return ssNumber;
	}
	public static void setSsNumber(String ssNumber) {
		dataSave.ssNumber = ssNumber;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		dataSave.name = name;
	}
	public static String getReceiverName() {
		return receiverName;
	}
	public static void setReceiverName(String receiverName) {
		dataSave.receiverName = receiverName;
	}
	public static int getPassword() {
		return password;
	}
	public static void setPassword(int password) {
		dataSave.password = password;
	}
	

}
