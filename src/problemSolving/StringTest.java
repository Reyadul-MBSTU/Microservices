package problemSolving;

import org.jetbrains.annotations.Nullable;

import java.util.StringJoiner;

import static problemSolving.ObjectUtil.*;

public class StringTest {

    public static String nullSafeToString(@Nullable String array) {
        if (array == null) {
            return null;
        }
        int length = array.length();
        if (length == 0) {
            return ObjectUtil.EMPTY_STRING;
        }
        StringJoiner stringJoiner = new StringJoiner(ARRAY_ELEMENT_SEPARATOR, ARRAY_START, ARRAY_END);
        for (char o : array.toCharArray()) {
            stringJoiner.add(START_CHAR + o + END_CHAR);
        }
        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        String input = "abccd";
        char[] ch = {'a', 'b', 'c', 'c', 'd'};
        for(int i=0; i< ch.length; i++)
        {
            System.out.println(ch[i]);
        }
        String ans = StringTest.nullSafeToString(input);
        System.out.println(ans);
    }
}
