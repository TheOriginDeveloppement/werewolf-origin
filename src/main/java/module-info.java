module fr.theorigindev.werewolforigin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.management;

    opens fr.theorigindev.werewolforigin to javafx.fxml;
    exports fr.theorigindev.werewolforigin;

    opens fr.theorigindev.werewolforigin.controllers to javafx.fxml;
    exports fr.theorigindev.werewolforigin.controllers;
}