package lotto.ui;

import lotto.constants.Etc;

public class Output {

    public static void printInstruction(String instruction) {
        System.out.println(instruction);
    }

    public static void printBuyInstruction(int num) {
        System.out.println(buyInstruction(num));
    }

    public static void printMatchInstruction(String rankInstruction, int prize, int count) {
        System.out.println(matchInstruction(rankInstruction, prize, count));
    }

    public static void printRoeInstruction(double roe) {
        System.out.println(roeInstruction(roe));
    }

    private static String buyInstruction(int num) {
        return String.format("%d개를 구매했습니다.", num);
    }

    private static String matchInstruction(String rankInstruction, int prize, int count) {
        return String.format("%s (%s원) - %d개", rankInstruction, stringFormat(prize), count);
    }

    private static String roeInstruction(double roe) {
        return String.format("총 수익률은 %.1f%s입니다.", roe, "%");
    }

    public static String stringFormat(int prize) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (prize > 0) {
            if (count == 3) {
                count = 0;
                sb.append(Etc.SEPARATOR);
                continue;
            }
            sb.append(prize % 10);
            prize /= 10;
            count++;
        }

        return sb.reverse().toString();
    }
}
