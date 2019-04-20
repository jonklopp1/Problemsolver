package framework.ui;

import domains.arithmetic.ArithmeticGUI;
import domains.dummy.DummyGUI;
import domains.farmer.FarmerGUI;
import domains.puzzle.PuzzleGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * This class presents problem solving domains in a tabbed pane.
 */
public class ProblemApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        primaryStage.setHeight(900);
        primaryStage.setWidth(1001);
        
	/* Add tabs using the following */

	Tab arithmetic = new Tab();
        arithmetic.setText("Arithmetic");
        arithmetic.setContent(new ArithmeticGUI());
        tabPane.getTabs().add(arithmetic);

	Tab farmer = new Tab();
        farmer.setText("Farmer");
        farmer.setContent(new FarmerGUI());
        tabPane.getTabs().add(farmer);
        
        Tab dummy = new Tab();
        dummy.setText("Dummy");
        dummy.setContent(new DummyGUI());
        tabPane.getTabs().add(dummy);
        
        Tab puzzle = new Tab();
        puzzle.setText("Puzzle");
        puzzle.setContent(new PuzzleGUI());
        tabPane.getTabs().add(puzzle);
        
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}