public class ReverseArray {
    public static int[] reverse(int[] a) {
        if (a == null) return null;
        if (a.length == 0) return a;
        int[] reversed = new int[a.length];
        for (int i = 0; i < a.length; i++) reversed[a.length - 1 - i] = a[i];
        return reversed;
    }
}
