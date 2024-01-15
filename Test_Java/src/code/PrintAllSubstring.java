package code;
//Print all substring of a word ABC->A,AB,ABC,B,BC,C
public class PrintAllSubstring {
	public static void main(String[] args) {
		String word = "abc";
		for(int i =0;i<=word.length();i++) {
			for(int j=i+1;j<=word.length();j++) {
				System.out.println(word.substring(i,j));
			}
		}
	}

}
