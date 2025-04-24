package com.pluralsight;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class employeeFile {
    public static void main(String[] args) throws IOException {


        try {
            Scanner theScanner = new Scanner(System.in);
            System.out.println("Enter name of employee file to process");
            String inputFile = theScanner.nextLine();

            System.out.println("Enter name of payroll file you'd like to create");
            String output = theScanner.nextLine();


            FileReader fileReader = new FileReader("src/main/resources/" + inputFile);
            FileWriter fileWriter = new FileWriter("src/main/resources/" + output);

            BufferedReader bufReader = new BufferedReader(fileReader);
            BufferedWriter write = new BufferedWriter(fileWriter);
            write.write("id|name|gross pay\n");
            {

                String input;
                while ((input = bufReader.readLine()) != null) {

                    String[] inputParts = input.split("\\|");

                    if (inputParts[0].equals("id")) {
                        continue;
                    }

                    Employee theEmployee = new Employee(Integer.parseInt(inputParts[0]), inputParts[1], Double.parseDouble(inputParts[2]), Double.parseDouble(inputParts[3]));

                    System.out.printf("%d - %s - $%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());

                }

                bufReader.close();
                write.close();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
