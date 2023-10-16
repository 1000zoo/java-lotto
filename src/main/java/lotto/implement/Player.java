package lotto.implement;

import lotto.constants.Etc;
import lotto.constants.Message;
import lotto.logic.LottoRandomGenerator;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int amount;
    private LottoManager lottoManager;
    private List<Lotto> lottos;

    public void start() {
        try {
            this.amount = Input.readAmount();
            this.lottos = new ArrayList<>();
            setLottos();
            setLottoManager();
            getResults();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(Message.INVALID_AMOUNT_ERROR_MESSAGE);
        }
    }

    private void setLottoManager() {
        lottoManager = new LottoManager();
        lottoManager.setAnswer();
    }

    private void getResults() {
        int profit = lottoManager.getResults(lottos);
        getRoe(profit);
    }

    private void getRoe(int profit) {
        double roe = (100.0 * profit) / amount;
        Output.printRoeInstruction(roe);
    }

    private void setLottos() {
        int n = amount / Etc.THOUSAND;
        Output.printBuyInstruction(n);
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
