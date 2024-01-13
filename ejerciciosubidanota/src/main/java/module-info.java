module com.example.ejerciciosubidanota {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.json;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.ejerciciosubidanota.model to javafx.base;
    opens com.example.ejerciciosubidanota to javafx.fxml;
    exports com.example.ejerciciosubidanota;
}