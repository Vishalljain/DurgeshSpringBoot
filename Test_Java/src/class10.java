import java.util.Scanner;

//2 largest
public class class10 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the size of the array");
			int arraySize = sc.nextInt();
			int arr[] = new int[arraySize];
			System.out.println("Enter the elements of the array");
			for(int i = 0 ;i <arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0;i<arr.length;i++) {//1,2,3,4
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]<arr[j]) {
						int temp=arr[i];
			            arr[i]=arr[j];
			            arr[j]=temp;
			       }
					
				}
			//	System.out.println(arr[i]);
			}
			
			System.out.println("Second Largest element is "+arr[1]);   //Display second largest element.
			System.out.println("Second Smallest element is "+arr[arraySize-2]);  //Display second smallest element.
		}
		
	}

}
