package com.pluralsight;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {
        ArrayList<Product> inventory = null;
        try {
            inventory = getInventory();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f",
                    p.getId(), p.getName(), p.getPrice());


        }
    }

    public static ArrayList<Product> getInventory() throws FileNotFoundException {
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(4567, "10' 2x4 (grade b", 9.99F));
        inventory.add(new Product(1234, "Hammer", 19.49F));
        inventory.add(new Product(2345, "Box of Nails", 9.29F));
        inventory.add(new Product(1648, "10' Crescent Wrench", 24.97F));
        inventory.add(new Product(9876, "Mechanic Tool Set", 15.95F));

        FileReader fr = new FileReader("src/main/resources/inventory.csv");


        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line;
            while (line = bf.readLine() != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String category = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());

                    Product product = new Product(id, name, category, price);
                }
            }
        } catch (IIOException e) {
            System.out.println("error reading file:" + e.getMessage());

            fr.close();
            
        }


        return inventory;
    }












