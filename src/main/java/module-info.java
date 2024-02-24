module com.example.gameengine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    opens com.example.gameengine.Models to java.xml.bind;
    opens com.example.gameengine to javafx.fxml;
    exports com.example.gameengine;
}