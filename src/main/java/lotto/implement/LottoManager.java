package lotto.implement;

import lotto.constants.Etc;
import lotto.constants.Message;
import lotto.constants.Rank;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    private Lotto answer;
    private int bonusNumber;

    public void setAnswer() {
        this.answer = new Lotto(readNumbers());
        setBonusNumber();
    }

    public void setBonusNumber() {
        this.bonusNumber = readBonusNumbers();
    }

    public int getResults(List<Lotto> lottos) {
        int[] counts = new int[Etc.LOTTO_LENGTH];

        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto);
            int temp = rank.getRank();
            if (temp >= 5) continue;
            counts[temp]++;
        }

        printResults(counts);

        return getTotalProfit(counts);
    }

    public static void printResults(int[] counts) {
        Rank[] ranks = Rank.values();
        for (int i = 4; i >= 0; i--) {
            Output.printMatchInstruction(
                    Message.RESULTS_INSTRUCTIONS[i],
                    ranks[i].getPrize(),
                    counts[i]
            );
        }
    }

    private int getTotalProfit(int[] counts) {
        int[] profits = new int[counts.length];
        for (int i = 0; i < counts.length; i++) {
            profits[i] = counts[i] * Rank.values()[i].getPrize();
        }
        return Arrays.stream(profits).sum();
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
