package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;

    private Label damageTextLabel;
    private Label damageValueLabel;
    private Label inventoryTextLabel;
    private Label inventoryValueLabel;

    public StatusPane() {
        ui = new GridPane();

        ui.setStyle("-fx-background-color: rgb(71, 45, 60);-fx-border-color: rgb(207, 198, 184); -fx-border-width: 5px;");

        healthTextLabel = new Label("Health: ");
        healthTextLabel.setFont(new Font("Verdana", 15));
        healthTextLabel.setStyle("-fx-text-fill: rgb(207, 198, 184);");

        healthValueLabel = new Label();
        healthValueLabel.setFont(new Font("Verdana", 15));
        healthValueLabel.setStyle("-fx-text-fill: rgb(207, 198, 184);");

        damageTextLabel = new Label("Damage: ");
        damageTextLabel.setFont(new Font("Verdana", 15));
        damageTextLabel.setStyle("-fx-text-fill: rgb(207, 198, 184);");

        damageValueLabel = new Label();
        damageValueLabel.setFont(new Font("Verdana", 15));
        damageValueLabel.setStyle("-fx-text-fill: rgb(207, 198, 184);");

        inventoryTextLabel = new Label("Inventory: ");
        inventoryTextLabel.setFont(new Font("Verdana", 15));
        inventoryTextLabel.setStyle("-fx-text-fill: rgb(207, 198, 184);");

        inventoryValueLabel = new Label();
        inventoryValueLabel.setFont(new Font("Verdana", 15));
        inventoryValueLabel.setStyle("-fx-text-fill: rgb(207, 198, 184);");
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);

        ui.add(damageTextLabel, 0, 1);
        ui.add(damageValueLabel, 1, 1);

        ui.add(inventoryTextLabel, 0, 2);
        ui.add(inventoryValueLabel, 1, 2);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setDamageValue(String text) {
        damageValueLabel.setText(text);
    }
    public void setInventoryValueLabel(String text) {
        inventoryValueLabel.setText(text);
    }
}
