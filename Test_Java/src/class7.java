//copy of array
public class class7 {
	
	public static void main(String[] args) {
		
		
		int arrA[] = {1,2,3,4,5,6};
		int arrB[] = new int[arrA.length];
		int i=0;
		for(i = 0 ;i<arrA.length-1;i++) {
			arrB[i]=arrA[i];
			
		}
		
		for(i=0;i<arrB.length-1;i++) {
		System.out.println(arrB[i]);
		}
	}

}
