package databaseInfos;

import java.util.Scanner;

public class cutomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBaseWork j = new DataBaseWork();
	//	j.insetUser("����ѹ�", "970112-2542341", "010-1234-5678");
	//	j.createAcc("����ѹ�", "970112-2542341", "010-1234-5678", "500000", 5678, 1234, "200000", "200000");
	//	boolean s = j.printInfo_Acc("1111111-11101010");
	//	System.out.println(s);
	//	System.out.println(j.allInfo_Acc_Info("1111111-10101010", 4));
	//	int i = j.printInfo_Password("1111111-10101010", 1234);
	//	j.rename("970112-2542341", "����");
	//	j.repassword("1491699-10638042", "1014");
	//	j.withdraw("1111111-10101010", "50000");	
	//	j.deposit("1111111-10101010", "50000");
	//	j.noPassbook("000711-4444444", "1111111-10101010", "2000");
	//	j.remittance("1383661-22577205", "1510795-20903564", "7000",6);
	//	System.out.println("���� : "+j.printInfo_balance("1111111-10101010"));
	//	j.balancecheck("1383661-22577205");
		j.typecheck("1383661-22577205", "�Ǽ��縮");
		//	j.remittance
	}

	public int Depositamount(){
		
		Scanner scan = new Scanner(System.in);
		int amount =0;
		System.out.println("�Ա� ���Ͻô� �ݾ��� �Է��ϼ��� : ");
		amount = scan.nextInt();
		return amount;
	}
}
