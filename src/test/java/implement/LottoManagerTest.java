package implement;

import lotto.implement.LottoManager;
import org.junit.jupiter.api.Test;

import static lotto.implement.LottoManager.printResults;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @Test
    void printResultsTest() {
        int[] counts = {1, 1, 1, 1, 1, 1};
        printResults(counts);
    }
}