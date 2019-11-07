import controllers.TestScreenController;
import controls.planningview.PlanningUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parameters.ParameterProvider;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Test extends Application {

    private static List<PlanningUnit> planningUnits;

    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader innerLoader = new FXMLLoader(getClass().getResource("/controllers/TestScreen.fxml"));

        try {
            Stage stage = new Stage();
            Parent innerRoot = innerLoader.load();
            //TODO AS - SETTING ALL REQUIRED OBJECTS
            TestScreenController test = innerLoader.getController();

            stage.setTitle(ParameterProvider.WINDOW_TITLE);
            Scene scene = new Scene(innerRoot, 800, 500);
            stage.setScene(scene);
            stage.setMaximized(true);

            stage.show();

            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




        //TODO
//        //This will fill the Time Line Unit in your Gui
//        VBox vbox = new VBox();
//        for (TimeLineUnit timeUnit : listeTimeLine) {
//            //For each unit create a new instance
//            UnitController unitController = new UnitController();
//            unitController.getTitle().setText(timeUnit.getTitle());
//            unitController.getDetails().setText(timeUnit.getDetails());
//            unitController.getTime().setText(
//                    timeUnit.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
//            );
//            unitController.setIdTimeLine(timeUnit.getId());
//            vbox.getChildren().add(unitController);
//        }
//
//        ScrollPane scrollPane = new ScrollPane(vbox);
//        scrollPane.setFitToHeight(true);
//
//        BorderPane root = new BorderPane(scrollPane);
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//        primaryStage.setTitle("Time Line Example using JavaFX");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        //TODO
    }

    public static void main(String[] args) {

        //TODO
        //Fill your Time Line here
//        listeTimeLine = new LinkedList<>();
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(1).title("Install tools")
//                        .details("Install JDK 1.8, Netbeans 8.2, Scene Builder")
//                        .dateTime(LocalDateTime.parse("2018-02-06T13:45:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(2).title("Create An application")
//                        .details("Create new Maven JavaFx Applicaton")
//                        .dateTime(LocalDateTime.parse("2018-02-06T14:10:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(3).title("Gui design")
//                        .details("Create a Simple unity of your Timeline, use your imagination ;)")
//                        .dateTime(LocalDateTime.parse("2018-02-06T14:40:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(4).title("Take a break")
//                        .details("To refresh your brain, Take a break, move, take a coffé")
//                        .dateTime(LocalDateTime.parse("2018-02-06T15:00:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(5).title("Controller")
//                        .details("Create a controller for your GUI")
//                        .dateTime(LocalDateTime.parse("2018-02-06T15:30:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(6).title("The END")
//                        .details("Edit this class and fill this timeline")
//                        .dateTime(LocalDateTime.parse("2018-02-06T16:00:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(6).title("The END")
//                        .details("Edit this class and fill this timeline")
//                        .dateTime(LocalDateTime.parse("2018-02-06T16:00:00")).build()
//        );        listeTimeLine.add(
//                TimeLineUnit.builder().id(6).title("The END")
//                        .details("Edit this class and fill this timeline")
//                        .dateTime(LocalDateTime.parse("2018-02-06T16:00:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(6).title("The END")
//                        .details("Edit this class and fill this timeline")
//                        .dateTime(LocalDateTime.parse("2018-02-06T16:00:00")).build()
//        );
//        listeTimeLine.add(
//                TimeLineUnit.builder().id(6).title("The END")
//                        .details("Edit this class and fill this timeline")
//                        .dateTime(LocalDateTime.parse("2018-02-06T16:00:00")).build()
//        );

        planningUnits = new LinkedList<>();

        planningUnits.add(PlanningUnit.builder().title("Napisz swoj wlasny modul").person("Anna Nowak").progress(0.7).build());
        planningUnits.add(PlanningUnit.builder().title("Przetestuj modul").person("Jan Kowalski").progress(0.9).build());
        planningUnits.add(PlanningUnit.builder().title("Synchronizing different computers within a local network").person("Jan Kowal").progress(0.3).build());
        planningUnits.add(PlanningUnit.builder().title("Test").person("Jan Kowal").progress(0.3).build());
        planningUnits.add(PlanningUnit.builder().title("Add the option in the settings screens to Maintain").person("Adrian Staskiewicz").progress(0.3).build());
        planningUnits.add(PlanningUnit.builder().title("To jest testowy opis w celu przetestowania czy powyzszy tekst zostanie zawiniety zgodnie z oczekiwaniami po wprowadzeniu zmian To jest testowy opis w celu przetestowania czy powyzszy tekst zostanie zawiniety zgodnie z oczekiwaniami po wprowadzeniu zmian").person("Adrian Staskiewicz").progress(0.3).build());


        //TODO

        //Then launch your application
        launch(args);
    }

}