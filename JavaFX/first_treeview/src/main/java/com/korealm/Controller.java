package com.korealm;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML private TreeView<String> treeView;
    
    @FXML public void initialize() {
        TreeItem<String> rootItem = new TreeItem<>("Files");
        
        Image folderIcon = new Image(getClass().getResourceAsStream("files.png"));
        TreeItem<String> branchItem1 = new TreeItem<>("Documents", new ImageView(folderIcon));
        TreeItem<String> branchItem2 = new TreeItem<>("Downloads", new ImageView(folderIcon));
        TreeItem<String> branchItem3 = new TreeItem<>("Music", new ImageView(folderIcon));

        TreeItem<String> leafItem1 = new TreeItem<>("Document 1.docx");
        TreeItem<String> leafItem2 = new TreeItem<>("Document 2.pptx");
        TreeItem<String> leafItem3 = new TreeItem<>("Document 1.txt");
        TreeItem<String> leafItem4 = new TreeItem<>("Program 1.java");
        TreeItem<String> leafItem5 = new TreeItem<>("サッドナムバー.mp3");

        branchItem1.getChildren().addAll(leafItem1, leafItem2, leafItem3);
        branchItem2.getChildren().addAll(leafItem4);
        branchItem3.getChildren().addAll(leafItem5);

        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);
        treeView.setShowRoot(false);
        treeView.setRoot(rootItem);
    }

    public void selectItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

        if (item != null) {
            System.out.println(item.getValue());
        }
    }
}
