import java.util.Scanner; /* notwendig, damit der Scanner funktioniert */

public class TriangleOutput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); /* oeffnet die Konsole */
		System.out.println("Bitte geben Sie die Hoehe des Dreiecks ein: ");
		int triangleSize = scanner.nextInt(); /* liest einen Integer von der Konsole */
		drawTriangle(triangleSize);
		scanner.close(); /* schliesst die Konsole */
	}

	static void drawTriangle(int sizeOfTriangle) {
		for (int i = 1; i <= sizeOfTriangle; i++) System.out.println("*".repeat(i));
	}
}