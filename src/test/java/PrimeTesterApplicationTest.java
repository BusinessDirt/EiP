import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class PrimeTesterApplicationTest {

    @TestFactory
    @DisplayName("Common Prime Factors between two Integers")
    Stream<DynamicTest> getCommonPrimeFactors() {
        int[][] data = { { 15, 25, 5 }, { 454542, 1482932, 2, 11 }, { 2, 3 }, { 25, 15, 5 }, { 17 * 11 * 11 * 5 * 3 * 2 * 2, 19 * 17 * 5 * 3 * 2 * 2, 2, 3, 5, 17 } };
        return Arrays.stream(data).map(entry -> {
            int p1 = entry[0];
            int p2 = entry[1];
            int[] factors = new int[entry.length - 2];
            System.arraycopy(entry, 2, factors, 0, factors.length);
            return dynamicTest(String.format("primeFactors(%s, %s) = %s", p1, p2, Arrays.toString(factors)), () -> {
                assertArrayEquals(factors, PrimeTesterApplication.getCommonPrimeFactors(p1, p2)
                        .stream().mapToInt(a -> a).toArray()
                );
            });
        });
    }
}