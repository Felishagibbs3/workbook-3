package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class FamousQuotes {
    public static <Int> void main(String[] args) {
        String[] quotes = {
                "The only thing we have to fear is fear itself. - Franklin Roosevelt",
                "Knowledge is power. - Francis Bacon.",
                "Life is 10% what happens to you and 90% how you react to it.",
                "Give light and people will find the way. - Ella Baker",
                "What mental health needs is more sunlight, more candor, and more unashamed conversation. - Glenn Close",
                "Life shrinks or expands in proportion to one's courage. - Anaïs Nin ",
                "The secret is not to find the meaning of life, but to use your life to make things that are meaningful. - James Clear ",
                "Love recognizes no barriers. - Maya Angelou ",
                "You're not alone.",
                "Believe in yourself and you're halfway there.",

    };

        Scanner myScanner = new Scanner(System.in);
    System.out.print("Pick a number between 1-10 to see quote: ");
        int quoteInput = myScanner.nextInt();

        if (quoteInput >= 1 && quoteInput <=10) {
            System.out.println("Selected quote:");
            System.out.println(quotes[quoteInput-1]);
        } else {
            System.out.println("Invalid number.");
        }

        }



    {

    }

}
