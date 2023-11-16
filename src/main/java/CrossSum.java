public class CrossSum {

    public static int calculateCrossSum(int n) {
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        // Testen Sie Ihr Programm hier
        System.out.println(calculateCrossSum(125));
    }
}
