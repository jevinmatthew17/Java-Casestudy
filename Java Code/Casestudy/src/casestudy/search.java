package casestudy;

import java.util.Scanner;

public class search {
	public static void servicesearch()
	{
	System.out.println("1.Firstname and Lastname");
	System.out.println("2.SSN");
	System.out.println("3.Email");
	System.out.println("4.Phone_No");
	System.out.println("5.Return To Function");
	Scanner sc= new Scanner(System.in);
	int option=sc.nextInt();
	
	
	switch(option)
	{
	case 1: 
			name obj = new name();
			name.sname();
			break;
	case 2:
			ssn obj1 = new ssn();
			ssn.sssn();
			break;
	case 3:
			email obj2 = new email();
			email.semail();
			break;
	case 4:
			phone_no obj3 = new phone_no();
			phone_no.sphone();
			break;
	case 5:
			
			controller.main(null);
			break;
	default:
			System.out.println("Not Found");
		
	}
	
	}
}
