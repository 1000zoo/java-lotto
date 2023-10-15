package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Etc;

import java.util.Arrays;

public class Input {

    public static int readAmount() {
        String amount = Console.readLine();
        // Todo: 에러처리
        return Integer.parseInt(amount);
    }

    public static int[] readNumbers() {
        String numbers = Console.readLine();
        // Todo: 에러처리
        return stringToIntegerArray(numbers);
    }

    public static int readBonusNumber() {
        String number = Console.readLine();
        // Todo: 에러처리
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
