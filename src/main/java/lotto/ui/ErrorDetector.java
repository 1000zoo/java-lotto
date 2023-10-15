package lotto.ui;

import lotto.constants.Etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ErrorDetector {

    public static void isCorrectAmount(String amount) {
        isOnlyInteger(amount);
        isUnder1000(amount);
        isDividedBy1000(amount);
    }

    public static void isCorrectNumbers(String numbers) {
        String[] numberArray = numbers.split(Etc.SEPARATOR);
        checkLength(numberArray);

        for (String number : numberArray) {
            isCorrectNumber(number);
        }

        isUniqueNumbers(numberArray);
    }

    public static void isCorrectNumber(String number) {
        isOnlyInteger(number);
        int temp = Integer.parseInt(number);
        if (temp <= 0 || temp > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static void isUniqueNumbers(String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));

        if (set.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLength(String[] arr) {
        if (arr.length != Etc.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void isUnder1000(String amount) {
        if (amount.length() < 4) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDividedBy1000(String amount) {
        int length = amount.length();
        if (!amount.substring(length - 3).equals(Etc.THREE_ZERO)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOnlyInteger(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
