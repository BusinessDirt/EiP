public class Quadratwurzel {

    public static double quadratwurzel(double x, int n) {
        if (n == 0) return (x + 1) / 2;
        double xn1 = quadratwurzel(x, n-1);
        return 0.5f * (xn1 + (x / xn1));
    }
}
