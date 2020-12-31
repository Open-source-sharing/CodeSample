import org.codesample.base.algorithm.sort.BubbleSortAlgorithm;
import org.junit.jupiter.api.Test;

public class BubbleSortAlgorithmTest {

    @Test
    public void testSort() {
        int[] arr = {10, 2, 5, 1, 6};
        int[] ints = new BubbleSortAlgorithm().sort(arr);

        for (int anInt : ints) {
            System.err.println(anInt);
        }
    }
}
