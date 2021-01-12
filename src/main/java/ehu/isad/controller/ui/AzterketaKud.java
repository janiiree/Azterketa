package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.AzterketaDBKud;
import ehu.isad.model.URLModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class AzterketaKud implements Initializable {

    private Main mainApp;

    @FXML
    private Button btnCheck;
    @FXML
    private TextField text;

    @FXML
    private TableView<URLModel> taula;
    @FXML
    private TableColumn<URLModel, String> urlCol;
    @FXML
    private TableColumn<URLModel, String> md5Col;
    @FXML
    private TableColumn<URLModel, String> versionCol;

    public void setMainApp(Main main) {
        this.mainApp = main;
    }

    public void onClickCheck(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        String url = text.getText();
        AzterketaDBKud azterketaDBKud =AzterketaDBKud.getInstance();
        URLModel urlModel = azterketaDBKud.datuBaseanDago(url + "/README");
        if (urlModel == null) {
            urlModel.setUrl(url);
            urlModel.setMd5(azterketaDBKud.md5Lortu(url));
            versionCol.setEditable(true);
            text.setText("Ez da datubasean aurkitu");
            //DATUBASEAN GORDE
        } else {
            versionCol.setEditable(false);
            text.setText("Datubasean zegoen");
        }

        taula.setItems((ObservableList<URLModel>) urlModel);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setEditable(true);
        taula.setEditable(false);

        urlCol.setCellValueFactory(new PropertyValueFactory<>("url"));
        md5Col.setCellValueFactory(new PropertyValueFactory<>("md5"));
        versionCol.setCellValueFactory(new PropertyValueFactory<URLModel, String>("version"));

        versionCol.setCellFactory(TextFieldTableCell.<URLModel> forTableColumn());
    }
}
