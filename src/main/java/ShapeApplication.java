import java.util.Scanner;

public class ShapeApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shape[] shapes = new Shape[10];

		System.out.println("Bitte geben Sie eine geometrische Form ein. Zur Auswahl stehen:\nDreieck\nQuadrat\nLinie\n\nZum Beenden des Programmes geben Sie \"Ende\" ein.");
		for (int i=0;i<shapes.length;i++) {
			String input = scanner.nextLine();
			if (input.equals("Ende")) break;
			shapes[i] = eval(input);
		}

        for (Shape shape : shapes) {
            if (shape != null) {
                shape.printShape();
                System.out.println();
            }
        }
	}

	private static Shape eval(String input) {
        return switch (input) {
            case "Dreieck" -> new Triangle();
            case "Quadrat" -> new Square();
            case "Linie" -> new Line();
            default -> null;
        };
	}
}
