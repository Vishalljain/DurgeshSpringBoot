import java.util.Scanner;

//Write a program to enter the numbers till the user wants and at the end the program should display the largest and smallest numbers entered.
public class class6 {
	
	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		char choice;
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("Enter the number");
			int number = sc.nextInt();
			if(number<min) {//100<10000
				min = number;
			}
			if(number>max) {
				max = number;
			}
			System.out.println("Do you want to continue Yes or No");
			choice = sc.next().charAt(0);
			
		}while(choice == 'y' || choice == 'Y');
		
		System.out.println("Max Number"+max);
		System.out.println("Min Number"+min);
		
		
	}

}
