package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class formatDates {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println("The date is:" + " " + now);
        System.out.println("-----------");


        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String format1 = now.format(format);
        System.out.println(format1);
        System.out.println("-----------");

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MMMM, d, yyyy");
        String formatter2 = now.format(format2);
        System.out.println(formatter2);

        System.out.println("-----------");


        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, MMM, dd, yyyy, HH:mm");
        String formatDate = dateTime.format(dtf);
        System.out.println("Today is: " + formatDate);



    }
}
