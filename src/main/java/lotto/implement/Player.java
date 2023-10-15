package lotto.implement;

import lotto.ui.Input;

public class Player {

    private final int amount;

    public Player() {
        this.amount = Input.readAmount();
    }

}
