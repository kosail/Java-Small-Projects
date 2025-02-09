package com.korealm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Controller {
    @FXML Stage stage;
    @FXML private WebView webView;
    @FXML private Button homeButton, reloadButton, goToPageButton, zoomInButton, zoomOutButton, historyButton, goForwardButton, goBackButton;
    @FXML private TextField urlTextField;
    
    private WebEngine webEngine;
    private WebHistory webHistory;
    private float zoomAmount = 1;

    @FXML
    public void initialize() {
        webEngine = webView.getEngine();
        goHomePage(null);
    }

    public void goToPage(ActionEvent event) {
        if (urlTextField != null && !urlTextField.getText().isEmpty()) {
            String url = urlTextField.getText().trim();
        
            // Ensure proper URL format because if not it will not load
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            webEngine.load(url);
            
            // webHistory = webEngine.getHistory();
            // updateTitle(event, webHistory);
        }
    }

    public void reloadPage() {
        if (webEngine == null) return;
        webEngine.reload();
    }
    
    public void goHomePage(ActionEvent event) {
        String home = "https://bonjourr.fr";
        webEngine.load(home);

        urlTextField.setText(home);
        if (event != null) {
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).setTitle("Home");
        }
    }

    public void goForward(ActionEvent event) {
        if (webEngine == null) return;

        webHistory = webEngine.getHistory();

        if (webHistory.getEntries().isEmpty()) return;
        webHistory.go(1);
        updateTitle(event, webHistory);
    }

    public void goBack(ActionEvent event) {
        if (webEngine == null) return;

        webHistory = webEngine.getHistory();

        if (webHistory.getEntries().isEmpty()) return;

        webHistory.go(-1);
        updateTitle(event, webHistory);
    }

    private void updateTitle(ActionEvent event, WebHistory webHistory) {
        if (webHistory == null || webHistory.getEntries().isEmpty()) {
            return; // Avoid errors when history is empty
        }

        // Ensure the window title is updated even when no event is passed
        if (event != null) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else if (stage == null) {
            stage = (Stage) urlTextField.getScene().getWindow(); // Alternative way to get the Stage
        }

        var list = webHistory.getEntries();
        var pageUrl = list.get(webHistory.getCurrentIndex()).getUrl();
        var pageName = list.get(webHistory.getCurrentIndex()).getTitle();

        urlTextField.setText(pageUrl);
        stage.setTitle(pageName);
    }

    public void zoomIn() {
        if (webEngine == null) return;

        zoomAmount += 0.25f;
        webView.setZoom(zoomAmount);
    }

    public void zoomOut() {
        if (webEngine == null) return;

        zoomAmount -= 0.25f;
        webView.setZoom(zoomAmount);
    }

    public void getHistory() {
        if (webEngine == null) return;

        webHistory = webEngine.getHistory();

        var list = webHistory.getEntries();

        if (list.isEmpty()) return;

        for (var entry : list) {
            System.out.printf("Name: %s\nLast Date Visited: %s\n", entry.getTitle(), entry.getLastVisitedDate());
        }
    }
}
