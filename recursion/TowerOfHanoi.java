package recursion;
import java.util.Scanner;
public class TowerOfHanoi {
	
	
	public static void towerOfHanoi(int n, char s, char h, char d) {
		if(n == 0) {
			return;
		}
		if(n == 1) {
			System.out.println("Move 1st disk From " + s + " to " + d);
			return;
					
		}
		towerOfHanoi(n - 1, s, d, h);
		System.out.println("Move " + n + " disk from " + s +" to "+d);
		towerOfHanoi(n - 1, h, s, d);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		towerOfHanoi(n, 's', 'h', 'd');
	}

}
