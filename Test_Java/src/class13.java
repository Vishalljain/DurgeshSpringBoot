//sort an array
public class class13 {
	public static void main(String[] args) {
		// creating an instance of an array
		int[] arr = new int[] { 78, 34, 1,100 };
		System.out.println("Array elements after sorting:");
		// sorting logic
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tmp = 0;
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
				
			}
			System.out.println(arr[i]);
			
		}
		// prints the sorted element of the array
					
					System.out.println("Second Smallest element is " + arr[1]); // Display second largest element.
					System.out.println("Second Largest element is " + arr[arr.length - 2]); // Display second smallest element.
	}
}
