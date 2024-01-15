
public class DuplicateValueInArray {
	public static void main(String[] args) {
		
		int arr[] = {1,1,2,7,3,4,2,5,7};
		
		for(int i =0;i<arr.length;i++) {
			for(int j =i+1;j<=arr.length-1;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("Duplicate Value is :"+arr[i]);
				}
			}
		}
		
		
	}

}
