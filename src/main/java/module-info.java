module com.example.imccalculatorfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
            
                            
    opens com.example.imccalculatorfx to javafx.fxml;
    opens com.example.imccalculatorfx.entity to javafx.fxml;

    exports com.example.imccalculatorfx.entity;
    exports com.example.imccalculatorfx;

}