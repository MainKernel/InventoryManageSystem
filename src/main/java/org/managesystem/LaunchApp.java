package org.managesystem;

import org.managesystem.controller.InventoryController;
import org.managesystem.model.InventoryModel;
import org.managesystem.view.InventoryView;

public class LaunchApp {
    public static void main(String[] args) {
        InventoryModel model = new InventoryModel();
        InventoryView view = new InventoryView();
        InventoryController controller = new InventoryController(model, view);

        controller.run();
    }
}