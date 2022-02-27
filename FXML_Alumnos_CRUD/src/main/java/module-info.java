module com.mycompany.fxml_alumnos_crud {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.fxml_alumnos_crud to javafx.fxml;
    exports com.mycompany.fxml_alumnos_crud;
}
