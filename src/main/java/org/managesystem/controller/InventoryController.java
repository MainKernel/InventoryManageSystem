package org.managesystem.controller;

import org.managesystem.model.InventoryModel;
import org.managesystem.view.InventoryView;

public class InventoryController {
    private InventoryModel model;
    private InventoryView view;

    public InventoryController(InventoryModel model, InventoryView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        // main application loop
        boolean exit = false;

        while (!exit) {
            view.displayMenu();
            int choice = Integer.parseInt(view.getUserInput());

            switch (choice) {
                case 1:
                    model.addItem();
                    break;
                case 2:
                    model.removeItem();
                    break;
                case 3:
                    model.updateItemQuantity();
                    break;
                case 4:
                    view.displayInventory();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
        view.closeScanner();
    }

}
