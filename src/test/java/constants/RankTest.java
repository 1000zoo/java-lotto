package constants;

import lotto.constants.Rank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void enumTest01() {
        Rank first = Rank.valueOf("FIRST");
        System.out.println(first);
    }
    
    @Test
    void enumTest02() {
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            System.out.println("rank.getPrize() = " + rank.getPrize());
        }

    }
}