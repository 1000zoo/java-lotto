package lotto.implement;

import lotto.constants.Etc;
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


    private int realRank(Lotto user) {
        int count = answer.countMatch(user);

        if (count == 6) {
            return 0;
        }
        if (count == 5 && hasBonusNumber(user)) {
            return 1;
        }
        if (count < 3) {
            return 5;
        }

        return Etc.LOTTO_LENGTH - count + 1;
    }

    private Rank getRank(Lotto userNumber) {
        Rank[] ranks = Rank.values();
        return ranks[realRank(userNumber)];
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
