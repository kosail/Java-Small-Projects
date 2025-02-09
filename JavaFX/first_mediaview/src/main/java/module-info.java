module com.korealm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.korealm to javafx.fxml;
    exports com.korealm;
}
