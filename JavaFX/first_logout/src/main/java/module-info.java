module com.kosail {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.kosail to javafx.fxml;
    exports com.kosail;
}
