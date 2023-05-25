module com.example.pong_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.pong_javafx to javafx.fxml;
    exports com.example.pong_javafx.main;
}
