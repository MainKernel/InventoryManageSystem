package org.managesystem.view;

import org.managesystem.model.InventoryModel;
import org.managesystem.model.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InventoryModel model = new InventoryModel();

    public InventoryView() {
    }

    public void displayInventory() {
        // display inventory to user
        ArrayList<Item> inventory = model.getInventory();
        if(!inventory.isEmpty()){
            for (Item i: inventory) {
                System.out.println(i.toString());
            }
        }else{
            System.out.println("Inventory is empty, add something to it\n");
        }
    }


    public void displayMenu() {
        // Display menu options
        System.out.println("===== Inventory Management System =====");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Update Item Quantity");
        System.out.println("4. Display Inventory");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public Item readNewItem() {
        // Read input to create a new item
        int id = model.verifyId(scanner);

        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Price per Unit: ");
        double price = Double.parseDouble(scanner.nextLine());

        return new Item(id, name, quantity, price);

    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public int readItemId() {
        // Read input for item ID
        System.out.print("Enter Item ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int readNewQuantity() {
        // Read input for new quantity
        System.out.print("Enter New Quantity: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }
}
