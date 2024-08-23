package test;

import java.util.ArrayList;
import java.util.List;

public class ValidNumber {

    public void validNumbers(int rowlength, String data)
    {
        String ans = "";
        List<String> list = new ArrayList<>();
        for(int i=0; i<data.length(); i++)
        {
            Character ch = data.charAt(i);
            if(Character.isDigit(ch))
            {
                ans+=String.valueOf(ch);
            }
            else {
                ans = "";
            }
            if(ans.length()==11)
            {
                list.add(ans);
            }
        }
        boolean b = true, c = true;
        System.out.println("<table>");
        for(int i=0; i<list.size(); i++) {

            if (b) {
                System.out.println("<tr>");
                for (int j = 0; j < rowlength; j++) {

                    if (j < list.size()) {
                        System.out.println(String.format("<td>" + list.get(j) + "</td>"));
                    }
                }
                System.out.println("</tr>");
                b = false;
            }
            if (rowlength < list.size()) {
                if (c) {
                    System.out.println("<tr>");
                    if (rowlength < list.size()) {
                        for (int j = rowlength; j < list.size(); j++) {

                            if (j < list.size()) {
                                System.out.println(String.format("<td>" + list.get(rowlength) + "</td>"));
                            }

                        }
                    }
                    System.out.println("</tr>");
                    c = false;
                }
            }
        }
        System.out.println("</table>");
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        validNumber.validNumbers(3, "“Ghg 01305678999 ghg 01305678999 jhy h55h 01305678999  01305678999 ");
    }
}
