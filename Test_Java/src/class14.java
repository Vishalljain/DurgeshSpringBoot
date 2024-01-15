//longest string in array
public class class14 {
	public static void main(String[] args) {
		
		String a[] = {"Hey","Hello","Hi"};
		int max = 0;
		String longName="";
		for(String longArray : a) {
			if(longArray.length()>max) {
				max = longArray.length();
				longName=longArray;
				
			}
		}
		System.out.println(longName);
		
	}

}
