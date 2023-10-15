package lotto.implement;

import lotto.constants.Rank;
import lotto.ui.Input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    private final Lotto answer;

    public LottoManager() {
        this.answer = new Lotto(readNumbers());
    }

    public Rank getRank(Lotto userNumber) {
        return answer.calculateRank(userNumber);
    }

    private List<Integer> readNumbers() {
        int[] numbers = Input.readNumbers();
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
