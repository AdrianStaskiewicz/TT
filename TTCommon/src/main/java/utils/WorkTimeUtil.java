package utils;

import enums.TaskCategory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkTimeUtil {

    public static Boolean checkStringFormatCorectness(String string) {
        Boolean isCorrect = Boolean.TRUE;
        String format = "(([0-9]+w){0,1}([0-9]+d){0,1}([0-9]+h){0,1}([0-9]+m){0,1})";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(string);

        isCorrect = matcher.matches();

        return isCorrect;
    }

    public static Long convertToNumber(String string) {
        string = removeAllSpaces(string);

        int currentLetterPosition = string.length() - 1;
        int nextLetterPosition = currentLetterPosition;

        Boolean isNextTimeMark = Boolean.TRUE;

        Long currentTimeValue;
        Long currentTimeValueInSeconds;
        Long resultValueInSeconds = 0L;

        char timeMark;

        while (isNextTimeMark) {
            currentLetterPosition = nextLetterPosition;
            timeMark = string.charAt(currentLetterPosition);
            if (findPositionOfLastAlphabeticCharacter(string.substring(0, currentLetterPosition)) == -1) {
                nextLetterPosition = -1;
                isNextTimeMark = Boolean.FALSE;
            } else {
                nextLetterPosition = findPositionOfLastAlphabeticCharacter(string.substring(0, currentLetterPosition));
            }
            currentTimeValue = Long.valueOf(string.substring(nextLetterPosition + 1, currentLetterPosition));
            currentTimeValueInSeconds = currentTimeValue * getMultiplierBasedOnTimeMark(timeMark);
            resultValueInSeconds = resultValueInSeconds + currentTimeValueInSeconds;

        }
        return resultValueInSeconds;
    }

    public static String convertToString(Long number) {
        return "";
    }

    private static String removeAllSpaces(String string) {
        return string.replaceAll("\\s", "");
    }

    private static Integer findPositionOfLastAlphabeticCharacter(String string) {
        int i = string.length() - 1;
        while (i >= 0 && Character.isDigit(string.charAt(i))) {
            i--;
        }

        if (i >= 0) {
            return i;
        } else {
            return -1;
        }
    }

    private static Integer getMultiplierBasedOnTimeMark(char timeMark) {
        switch (timeMark) {
            case 's':
                return 1;
            case 'm':
                return 1 * 60;
            case 'h':
                return 1 * 60 * 60;
            case 'd':
                return 1 * 60 * 60 * 24;
            case 'w':
                return 1 * 60 * 60 * 24 * 7;
            default:
                return 0;
        }
    }

}
