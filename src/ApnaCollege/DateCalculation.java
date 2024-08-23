package ApnaCollege;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateCalculation {

    static void find(String join_date, String leave_date) {
        // Create an instance of the SimpleDateFormat class
        SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

        // In the try block, we will try to find the difference
        try {

            // Use parse method to get date object of both dates
            Date date1 = obj.parse(join_date);
            Date date2 = obj.parse(leave_date);

            // Calucalte time difference in milliseconds
            long time_difference = date2.getTime() - date1.getTime();

            // Calucalte time difference in days using TimeUnit class
            long days_difference = TimeUnit.MILLISECONDS.toDays(time_difference) % 30;

            long months_difference = TimeUnit.MILLISECONDS.toDays(time_difference) / 30;

            // Calculate time difference in years using TimeUnit class
            long years_difference = TimeUnit.MILLISECONDS.toDays(time_difference) / 365l;

            System.out.print(
                    "Difference "
                            + "between two dates is: ");
            System.out.println(
                    +years_difference
                            + " years, "
                            + months_difference
                            + "months "
                            + days_difference
                            + " days "
            );
        }
        // Catch parse exception
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static void find(LocalDate  first_date, LocalDate second_date)
    {
        // Get period between the first and the second date
        Period difference = Period.between(first_date, second_date);

        System.out.println(difference);
        // Show date difference in years, months, and days
        System.out.print("Difference between two dates is:\n");
        System.out.printf( "%d days, %d months and %d years",
                difference.getDays(),
                difference.getMonths(),
                difference.getYears());
    }

    public static void main(String[] args) {
        // Set values for both dates
        String join = "12-12-2018 02:11:20";
        String leave  = "1-26-2020 07:15:50";

        // Calling find() function for getting difference bwtween dates
        //find(join, leave);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        find(LocalDate.of(1997, 06, 12), localDate);
    }

}
