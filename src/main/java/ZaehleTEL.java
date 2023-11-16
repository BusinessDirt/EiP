import java.util.Scanner;

public class ZaehleTEL {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine Zeichenfolge ein: ");
		countTEL(scanner.nextLine());
		scanner.close();
	}

	private static void countTEL(String str) {
		System.out.println("Der Buchstabe \"t\" kommt " + countChar(str, 't') + " mal vor.");
		System.out.println("Der Buchstabe \"l\" kommt " + countChar(str, 'l') + " mal vor.");
		System.out.println("Der Buchstabe \"e\" kommt " + countChar(str, 'e') + " mal vor.");
	}

	private static long countChar(String str, char c) {
		return str.toLowerCase().codePoints().filter(ch -> ch == c).count();
	}
}
