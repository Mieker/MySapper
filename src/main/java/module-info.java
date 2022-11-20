module com.mieker.saperui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires lombok;

    opens com.mieker.saperui to javafx.fxml;
    exports com.mieker.saperui;
    exports com.mieker.saperui.model;
    opens com.mieker.saperui.model to javafx.fxml;
}