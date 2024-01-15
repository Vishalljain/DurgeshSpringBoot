package code.udemy1;

public class SumNRecursion {
	
	public int recursion(int n) {
		//need to define the base case when to terminate the algorithm
		if(n==1)
			return 1;
		System.out.println(n);
		return n + recursion(n-1);
		
		
	}

}
