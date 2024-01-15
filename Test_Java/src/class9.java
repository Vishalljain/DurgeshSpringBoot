//largest
public class class9 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int arr[] = new int[] {1,2,4,6,100,5,10};
		for(int i = 0 ; i<arr.length ; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println(max);
		
	}

}
