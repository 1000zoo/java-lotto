package lotto.constants;

public enum Rank {
    FIRST(Prize.FIRST_PRIZE),
    SECOND(Prize.SECOND_PRIZE),
    THIRD(Prize.THIRD_PRIZE),
    FOURTH(Prize.FOURTH_PRIZE),
    FIFTH(Prize.FIFTH_PRIZE);

    private final int prize;

    Rank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
