package lotto.implement;

import lotto.constants.Rank;
import lotto.ui.Input;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {

    private final Lotto answer;
    private final int bonusNumber;

    public LottoManager() {
        this.answer = new Lotto(readNumbers());
        this.bonusNumber = readBonusNumbers();
    }

    public int getResults(List<Lotto> lottos) {
        int[] counts = new int[lottos.size()];

        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto);
            counts[rank.getRank()]++;
        }

        return getTotalProfit(counts);
    }

    private int getTotalProfit(int[] counts) {
        return Arrays.stream(counts).sum();
    }


    // TODO: 등수 확인 로직 수정
    private Rank getRank(Lotto userNumber) {
        int count = answer.countMatch(userNumber);

        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5 && hasBonusNumber(userNumber)) {
            return Rank.SECOND;
        }
        if (count == 5) {
            return Rank.THIRD;
        }
        if (count == 4) {
            return Rank.FOURTH;
        }
        if (count == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    private boolean hasBonusNumber(Lotto userNumber) {
        return userNumber.hasNumber(bonusNumber);
    }

    private int readBonusNumbers() {
        return Input.readBonusNumber();
    }

    private List<Integer> readNumbers() {
        int[] numbers = Input.readNumbers();
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
