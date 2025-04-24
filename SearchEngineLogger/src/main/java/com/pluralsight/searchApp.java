package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class searchApp {
    static DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        logData( "launch");
        logData("exit");

        boolean running = true;

        while(running){
            System.out.println("Enter a search term. (X to exit");
            String search = myScanner.nextLine();

            if(search.equalsIgnoreCase("x")){
                System.out.println("Have a good day!");
                logData("exit");
                running = false;
            }else {
                logData("Search : " + search);
                
            }


        }

    }
    public static void logData(String action){

        try{

            FileWriter outPut = new FileWriter("src/main/resources/logs.txt", true);
            BufferedWriter bufwriter = new BufferedWriter(outPut);

            LocalDateTime timeStamp = LocalDateTime.now();
            bufwriter.write(timeStamp.format(timeStampFormatter) + " " + action);
            bufwriter.newLine();

            bufwriter.close();

        } catch (Exception e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }


    }
}
