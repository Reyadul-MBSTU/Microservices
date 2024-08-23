package test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FirstCapitalLetter {

    private String sentenceCaseWithoutRegex(String text) {
        // Check if the input text is null or empty
        if (text == null || text.isEmpty()) {
            return text;
        }

        // Convert the first character to uppercase
        char[] charArray = text.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);

        // Iterate through the characters to add spaces before capital letters
        for (int i = 1; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
                // Add a space before the capital letter
                charArray = insertChar(charArray, i, ' ');
            }
        }

        // Convert the char array back to a string
        return new String(charArray);
    }

    // Helper method to insert a character at a specific position in a char array
    private char[] insertChar(char[] array, int index, char value) {
        char[] result = new char[array.length + 1];
        System.arraycopy(array, 0, result, 0, index);
        result[index] = value;
        System.arraycopy(array, index, result, index + 1, array.length - index);
        return result;
    }

    public static String capitalize(final String str) {
        final int strLen = length(str);
        if (strLen == 0) {
            return str;
        }

        final int firstCodepoint = str.codePointAt(0);
        final int newCodePoint = Character.toTitleCase(firstCodepoint);
        if (firstCodepoint == newCodePoint) {
            // already capitalized
            return str;
        }

        final int[] newCodePoints = new int[strLen]; // cannot be longer than the char array
        int outOffset = 0;
        newCodePoints[outOffset++] = newCodePoint; // copy the first codepoint
        for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen; ) {
            final int codepoint = str.codePointAt(inOffset);
            newCodePoints[outOffset++] = codepoint; // copy the remaining ones
            inOffset += Character.charCount(codepoint);
        }
        return new String(newCodePoints, 0, outOffset);
    }

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    private String sentenceCase(String text) {
         final Pattern CAPITAL_LETTER_PATTERN = Pattern.compile("([A-Z])");
        if (text == null || text.isEmpty()) {
            return text;
        }
        Matcher matcher = CAPITAL_LETTER_PATTERN.matcher(text);
        String result = matcher.replaceAll(" $1");
        return capitalize(result);
    }

    private String spaceAndCapitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();
        result.append(text.charAt(0));

        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                result.append(' ').append(currentChar);
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "AbcTyzXyaUioopsdiFyr";
        FirstCapitalLetter firstCapitalLetter = new FirstCapitalLetter();
        String res = firstCapitalLetter.sentenceCaseWithoutRegex(text);
        System.out.println(res);
        String str = firstCapitalLetter.sentenceCase(text);
        System.out.println(str);
        String coreCode = firstCapitalLetter.spaceAndCapitalizeFirstLetter(text);
        System.out.println(coreCode);
    }

}
