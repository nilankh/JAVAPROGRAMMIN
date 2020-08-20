//Minimum bracket Reversal
//Send Feedback
//Given a string expression which consists only ‘}’ and ‘{‘. The expression may not be balanced.
//You need to find the minimum number of bracket reversals which are required to make the expression balanced.
//}
//Return -1 if the given expression can't be balanced.
//Input Format :
//String S
//Output Format :
//Required count
//Sample Input 1 :
//{{{
//Sample Output 1 :
//-1
//Sample Input 2 :
//{{{{}}
//Sample Output 2 :
//1








package stack;
import java.util.Scanner;
import java.util.Stack;
public class MinimumBracketReversal {

	
	public static int minimum(String input) {
		if(input.length() == 0) {
			return 0;
		}
		if(input.length() % 2 != 0) {
			return -1;
		}
		
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if(current == '{') {
				s.push(current);
			}else {
				if(!s.isEmpty() && s.peek() == '{') {
					s.pop();
				}else {
					s.push(current);
				}
			}
		}
		
		int count = 0;
		while(!s.isEmpty()) {
			char count1 = s.pop();
			char count2 = s.pop();
			if(count1 != count2) {
				count += 2;
			}else {
				count += 1;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner m = new Scanner(System.in);
		String str = m.nextLine();
		System.out.println(minimum(str));
	}

}
