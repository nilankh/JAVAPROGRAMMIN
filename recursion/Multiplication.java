package recursion;
import java.util.Scanner;
public class Multiplication {
	
	public static int multiply(int m, int n) {
		if(m == 0|| n == 0) {
			return 0;
		}
		return m + multiply(m, n - 1);
	}
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = s.nextInt();
		int n = s.nextInt();
		System.out.println(multiply(m, n));
	}

}
