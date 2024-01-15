package code;

class Array2 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2,4, 5, 6, 7,8 };
		{
			int n = arr.length;
			for (int i = 0; i < n; i++) {

				for (int j = i + 1; j < n; j++) {
					if (arr[i] >= 0 && arr[j] >= 0 && arr[i] % 2 == 0 && arr[j] % 2 != 0) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;

					}
				}
			}

			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}

	}
}
