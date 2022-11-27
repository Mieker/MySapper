module com.mieker.saperui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires lombok;

    opens com.mieker.mysapper to javafx.fxml;
    exports com.mieker.mysapper;
    exports com.mieker.mysapper.model;
    opens com.mieker.mysapper.model to javafx.fxml;
}