//merge 2 arrays
public class class12 {

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 6, 7, 8, 9, 10 };
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		int arr3[] = new int[arr1Length + arr2Length];

		for (int i = 0; i < arr1Length; i++) {
			arr3[i] = arr1[i];
		}

		for (int j = 0; j < arr2Length; j++) {
			arr3[arr1Length + j] = arr2[j];
		}

		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}

	}

}
