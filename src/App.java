import java.util.Scanner;

import com.project.usecase.AdminLogin;
import com.project.usecase.CustomerRegistration;
import com.project.usecase.UserLogin;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("========================================");
		System.out.println("");
		System.out.println("Welcome to Bus Ticket reservation system");
		System.out.println("");
		System.out.println("========================================");
		System.out.println("");
		
		System.out.println("1. New customers - Register yourself");
		System.out.println("2. Existing customer - Login here");
		System.out.println("3. Admin login");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		   case 1:
			   CustomerRegistration cr = new CustomerRegistration();
			   cr.main(null);
			   break;
		   case 2:
			   UserLogin u1 = new UserLogin();
			   u1.main(null);
			   break;
		   case 3:	   
			   AdminLogin a1 = new AdminLogin();
			   a1.main(null);
			   break;
			   default:
			
		}
		
		
		
		
		
		
		

		
		

	}

}
