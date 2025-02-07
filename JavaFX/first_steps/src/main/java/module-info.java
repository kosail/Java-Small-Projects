module com.korealm {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.korealm to javafx.fxml;
    exports com.korealm;
}
