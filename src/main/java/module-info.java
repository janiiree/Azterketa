open module scenebuilder {

  requires java.sql;
  requires javafx.base;
  requires javafx.fxml;
  requires javafx.controls;
  requires com.google.gson;
  requires mysql.connector.java;
    requires org.apache.commons.codec;
    exports ehu.isad;
}
