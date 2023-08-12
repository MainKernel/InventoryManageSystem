package org.managesystem.model;

import org.managesystem.view.InventoryView;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryModel {
    private static final ArrayList<Item> inventory = new ArrayList<>();
    private InventoryView view;

    public InventoryModel() {
        view = new InventoryView();
    }

    public void addItem() {
        // add item to inventory
        inventory.add(view.readNewItem());
    }

    public void removeItem() {
        // remove item from inventory
        int byId = findById(view.readItemId());
        if(byId != -1){
            inventory.remove(byId-1);
        }
    }

    public void updateItemQuantity() {
        // update item quantity in inventory
        int byId = findById(view.readItemId());
        if(byId != -1) {
            inventory.get(byId).setQuantityInStock(view.readNewQuantity());
        }
    }

    public ArrayList<Item> getInventory() {
        // retrieve inventory
        return inventory;
    }

    public int findById(int itemId) {
        if(!inventory.isEmpty()) {
            for (int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).getId() == itemId){
                    return itemId;
                }
            }
        }
        return -1;
    }


    public int verifyId(Scanner scanner){
        while (true){
            System.out.print("Enter Item ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            if(id == findById(id)){
                System.out.println("Product with this id already exist\n");
            }else{
                return id;
            }
        }
    }

}
