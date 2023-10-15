package lotto.implement;

import lotto.constants.Rank;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Rank calculateRank(Lotto userNumber) {
        return null;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}