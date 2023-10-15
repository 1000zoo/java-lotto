package logic;

import lotto.implement.Lotto;
import lotto.logic.LottoRandomGenerator;
import org.junit.jupiter.api.Test;

public class LottoRandomGeneratorTest {
    
    @Test
    void 랜덤생성기테스트() {
        Lotto lotto = LottoRandomGenerator.getRandomLotto();
        System.out.println("lotto = " + lotto);
    }
}
