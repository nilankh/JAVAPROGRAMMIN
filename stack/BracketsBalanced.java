package stack;
import java.util.Scanner;
import java.util.Stack;
public class BracketsBalanced {
	public static boolean checkBalanced(String exp) {
		Stack<Character> s = new Stack<Character> ();
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) == '(' || exp.charAt(i) =='{' || exp.charAt(i) == '[') {
					s.push(exp.charAt(i));
			}
			else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']') {
				if(s.isEmpty()) {
					return false;
				}
				char ch = s.pop();
				if(exp.charAt(i) == ')' && ch == '(') {
					continue;
				}
				else if(exp.charAt(i) == '}' && ch == '{' ) {
					continue;
				}
				else if(exp.charAt(i) == ']' && ch == '[') {
					continue;
				}
				else {
					return false;
				}
			}
		}
		if(s.isEmpty()){
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(BracketsBalanced.checkBalanced(input));
		
	}

}
