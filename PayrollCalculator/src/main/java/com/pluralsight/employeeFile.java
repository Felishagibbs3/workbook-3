package com.pluralsight;

import java.io.*;

import java.util.Scanner;


public class employeeFile {
    public static void main(String[] args) throws IOException {


        try {

            FileReader fileReader = new FileReader("src/main/resources/employees.csv");

            BufferedReader bufReader = new BufferedReader(fileReader);

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

        } catch (Exception e) {
            throw new RuntimeException(e);


        }
        Scanner theScanner = new Scanner(System.in);
        System.out.println("Enter name of employee file to process");
        String inputFile = theScanner.nextLine();

        System.out.println("Enter name of payroll file you'd like to create");
        String output = theScanner.nextLine();

        try (
                BufferedReader bufread = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
                BufferedWriter write = new BufferedWriter(new FileWriter("payroll-sept-2023.csv"))
        ) {

            write.write("id|name|gross pay");
            write.newLine();

            String line = bufread.readLine();

            while ((line = bufread.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                int iD = Integer.parseInt(parts[0]);
                String names = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double hourlyRate = Double.parseDouble(parts[3]);

                double grossPay = hoursWorked * hourlyRate;

                String Payroll = iD + "|" + names + "|" + grossPay + "\n");
                write.write(Payroll);
                write.newLine();

                BufferedReader.close();
                BufferedWriter.close();


            }
            catch(IOException e){
                System.out.println("Error Processing Files");
            }

            System.out.println("File Successfully Created!" + output);


        }


    }


}