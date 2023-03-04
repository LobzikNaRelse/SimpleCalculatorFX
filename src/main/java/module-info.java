module com.kurs.obucheniekurscalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kurs.obucheniekurscalculator to javafx.fxml;
    exports com.kurs.obucheniekurscalculator;
}