package lotto.implement;

import lotto.constants.Etc;
import lotto.constants.Message;
import lotto.logic.LottoRandomGenerator;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int amount;
    private final LottoManager lm;
    private final List<Lotto> lottos;

    public Player() {
        this.amount = Input.readAmount();
        this.lottos = new ArrayList<>();
        setLottos();
        this.lm = new LottoManager();
    }

    public void getResults() {
        int profit = lm.getResults(lottos);
        getRoe(profit);
    }

    public void getRoe(int profit) {
        double roe = 100.0 * profit / amount;
    }

    private void setLottos() {
        int n = amount / Etc.THOUSAND;
        for (int i = 0; i < n; i++) {
            lottos.add(LottoRandomGenerator.getRandomLotto());
        }
        Output.printInstruction(lottosToString());
    }

    private String lottosToString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto).append(" ");
        }

        return sb.toString();
    }
}
