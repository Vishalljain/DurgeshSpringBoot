import java.util.Arrays;

public class MoveAllZeroes {
	public static void main(String[] args) {
		
		int arr[] = {1,0,2,0,3,0};
		int count = 0;
		for(int i =0;i<arr.length;i++) {
			if(arr[i]!=0) {
			int temp = arr[count];
			arr[count]=arr[i];
			System.out.println(arr[i]);
			arr[i]=temp;
			count++;
			
			
		}
			System.out.println(Arrays.toString(arr));
		}
	}

}
