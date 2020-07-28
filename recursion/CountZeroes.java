package recursion;
import java.util.Scanner;
public class CountZeroes {
	
	public static int countZeros(int n) {
		if(n < 10) {
			if(n == 0) {
				return 1;
			}else {
				return 0;
			}
		}
		if(n % 10 == 0) {
			return countZeros(n/10) + 1;
		}
		else {
			return countZeros(n/ 10);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(countZeros(n));
	}

}
