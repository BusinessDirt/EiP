import org.apache.commons.math3.primes.Primes;

import java.util.List;

public class PrimeTesterApplication {
    public static List<Integer> getCommonPrimeFactors(int a, int b) {
        List<Integer> primeFactors1 = Primes.primeFactors(a);
        List<Integer> primeFactors2 = Primes.primeFactors(b);
        return primeFactors1.stream().filter(primeFactors2::contains).distinct().toList();
    }
}
