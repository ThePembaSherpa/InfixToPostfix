import java.io.IOException;
import java.util.Scanner;


public class StartUp{
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the inflix term >> ");
		String in = scanner.next();
		String out;
		InfixToPostfix Translate = new InfixToPostfix(in);
		out = Translate.convert(); 
		System.out.println("\nInfix is " + in + '\n');
		System.out.println("Postfix is " + out);
	}

}