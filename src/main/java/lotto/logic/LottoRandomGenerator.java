package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.implement.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoRandomGenerator {

    public static Lotto getRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6 );
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
