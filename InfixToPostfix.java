
public class InfixToPostfix {
	private MyStack<Character> myStack;
	private String in;
	private String out = "";
	int stackSize;
	public InfixToPostfix(String in) {
		this.in = in;
		stackSize = in.length();
		myStack = new MyStack <Character>();
 
   }
   
	public String convert() {
		for (int i = 0; i < stackSize; i++) {
			//System.out.println(in);
			char ch = in.charAt(i);
			switch (ch) {
				case '+': 
				case '-':
				Operands(ch, 1); 
				break; 
				case '*': 
				case '/':
				Operands(ch, 2); 
				break; 
				case '(': 
				myStack.push(ch);
				break;
				case ')': 
				Parenthesis(ch); 
				break;
				default: 
				out = out + ch; 
				break;
			}
		}
		while (!myStack.isEmpty()) {
			out = out + myStack.pop();
		}
		//System.out.println(out);
		return out; 
	}
	public void Operands(char ch1, int i) {
		while (!myStack.isEmpty()) {
			char ch2 = myStack.pop();
			if (ch2 == '(') {
				myStack.push(ch2);
				break;
			}
			else {
				int i2;
				if (ch2 == '+' || ch2 == '-')
				i2 = 1;
				else
				i2 = 2;
				if (i2 < i) { 
					myStack.push(ch2);
					break;
				}
				else
				out = out + ch2;
			}
		}
		myStack.push(ch1);
	}
	public void Parenthesis(char ch){ 
		while (!myStack.isEmpty()) {
			char chx = myStack.pop();
			if (chx == '(') 
			break; 
			else
			out = out + chx; 
		}
	}
	
}