module com.korealm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.korealm to javafx.fxml;
    exports com.korealm;
}
