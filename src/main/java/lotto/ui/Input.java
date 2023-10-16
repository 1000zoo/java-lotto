package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Etc;
import lotto.constants.Message;

import java.util.Arrays;

public class Input {


    public static int readAmount() {
        Output.printInstruction(Message.AMOUNT_INPUT_INSTRUCTION);
        String amount = Console.readLine();
        ErrorDetector.isCorrectAmount(amount);
        return Integer.parseInt(amount);
    }

    public static int[] readNumbers() {
        Output.printInstruction(Message.ANSWER_NUMBERS_INPUT_INSTRUCTION);
        String numbers = Console.readLine();
        ErrorDetector.isCorrectNumbers(numbers);
        return stringToIntegerArray(numbers);
    }

    public static int readBonusNumber() {
        Output.printInstruction(Message.BONUS_NUMBER_INPUT_INSTRUCTION);
        String number = Console.readLine();
        ErrorDetector.isCorrectNumber(number);
        return Integer.parseInt(number);
    }

    private static int[] stringToIntegerArray(String str) {
        String[] arr = stringToArray(str);
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }

    private static String[] stringToArray(String str) {
        return str.split(Etc.SEPARATOR);
    }
}
