package lotto.constants;

public class Message {

    public final static String AMOUNT_INPUT_INSTRUCTION = "구입금액을 입력해 주세요.";
    public final static String ANSWER_NUMBERS_INPUT_INSTRUCTION = "당첨 번호를 입력해 주세요.";
    public final static String BONUS_NUMBER_INPUT_INSTRUCTION = "보너스 번호를 입력해 주세요.";

    public final static String INVALID_AMOUNT_ERROR_MESSAGE = "로또 구입 금액은 1,000원 단위여야 합니다.";
    public final static String INVALID_NUMBER_ERROR_MESSAGE = "1 ~ 45 사이의 정수만 입력해주세요.";
    public final static String INVALID_NUMBERS_ERROR_MESSAGE_NO_INVALID_LENGTH = "당첨 번호는 6자리여야 합니다.";
    public final static String INVALID_NUMBERS_ERROR_MESSAGE_NO_UNIQUE_NUMBER = "당첨 번호는 중복되는 정수가 없어야 합니다.";
    public final static String INVALID_INPUT_ONLY_INTEGER = "정수만 입력해주세요.";

    public final static String[] RESULTS_INSTRUCTIONS = {
            "6개 일치",
            "5개 일치, 보너스 볼 일치",
            "5개 일치",
            "4개 일치",
            "3개 일치"
    };
}
