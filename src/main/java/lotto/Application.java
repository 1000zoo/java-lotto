package lotto;

import lotto.implement.Player;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        try {
            player.start();
        } catch (IllegalArgumentException e) {

        }
    }
}
