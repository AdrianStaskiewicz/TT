package controllers;

import controls.card.Card;
import controls.card.CardContainer;
import controls.releaseview.ReleaseUnit;
import controls.releaseview.ReleaseView;
import converters.ReleaseConverter;
import dtos.ReleaseDto;
import enums.TargetReleaseDateType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import lombok.Setter;
import requests.ReleaseRequest;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSubScreenController extends AbstractSubScreenController {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private Button upcomingReleases;
    @FXML
    private Button releasedReleases;
    @FXML
    private Button archivedReleases;
    @FXML
    private CardContainer<Card> cardContainer;

    private ReleaseRequest releaseRequest;

    @FXML
    public void createTask() {
        mainScreenController.enableAllButtons();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.releaseRequest = new ReleaseRequest();
    }

    @Override
    public void initializeData() {
        Card[] cards = new Card[0];
        ObservableList<Card> testItems = FXCollections.observableArrayList(cards);
        cardContainer.setItems(testItems);
    }

    @FXML
    public void onActionTest() {
        System.out.println("On Action Test");
    }

    @FXML
    public void onAddTest() {
        System.out.println("On Add Test");
    }

    @FXML
    public void onSaveTest() {
        System.out.println("On Save Test");
    }

    @FXML
    public void onDeleteTest() {
        System.out.println("On Delete Test");
    }

    @FXML
    public void upcomingReleases() {
//
    }

    @FXML
    public void releasedReleases() {
//
    }

    @FXML
    public void archivedReleases() {
//
    }

    @Override
    public void refreshData() {
        //
    }
}
