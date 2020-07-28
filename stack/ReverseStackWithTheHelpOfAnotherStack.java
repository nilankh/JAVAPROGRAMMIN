package stack;
import java.util.Scanner;
import java.util.Stack;
public class ReverseStackWithTheHelpOfAnotherStack {

	public static void reverseStack(Stack<Integer> s1,Stack<Integer> s2) {
		if(s1.size() <= 1) {
			return;
		}
		int lastElement = s1.pop();
		reverseStack(s1, s2);
		while(!s1.isEmpty()) {
			int a = s1.pop();
			s2.push(a);
		}
		s1.push(lastElement);
		while(!s2.isEmpty()) {
			int b = s2.pop();
			s1.push(b);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		Stack<Integer> input = new Stack<Integer>();
		for(int i = 0; i < size; i++) {
			input.push(s.nextInt());
		}
		Stack<Integer> extra = new Stack<Integer>();
		ReverseStackWithTheHelpOfAnotherStack.reverseStack(input, extra);
		while(!input.isEmpty()) {
			System.out.print(input.pop() + " ");
		}
	}

}
