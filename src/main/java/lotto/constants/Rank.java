package lotto.constants;

public enum Rank {
    FIRST(0, Prize.FIRST_PRIZE),
    SECOND(1, Prize.SECOND_PRIZE),
    THIRD(2, Prize.THIRD_PRIZE),
    FOURTH(3, Prize.FOURTH_PRIZE),
    FIFTH(4, Prize.FIFTH_PRIZE),
    NONE(5, Prize.NONE_PRIZE);

    private final int rank;
    private final int prize;

    Rank(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
