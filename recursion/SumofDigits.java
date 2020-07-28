package recursion;
import java.util.Scanner;

public class SumofDigits {
	
	public static int sumOfDigits(int n) {
		if(n == 0) {
			return 0;
		}else {
			int r = n % 10;
			return r + sumOfDigits(n/10);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(sumOfDigits(n));
	}

}
