/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import framework.problem.Benchmark;
import framework.problem.Problem;
import framework.solution.Solution;
import framework.solution.SolvingAssistant;
import framework.solution.StateSpaceSolver;
import framework.problem.State;
import framework.solution.AStarSolver;
import java.awt.Dimension;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author jonkl
 */
public class ProblemGUI extends VBox{
     public ProblemGUI(Problem problem, double width, double height) {
         
         this.problem = problem;
         solver = new SolvingAssistant(problem);
         Pad = Font.font("Dejavu Sans Mono", 15).getSize();
        
    // Making welcome message
         welcomeMessage = new Label("Welcome to the "+problem.getName()+" Problem");
         welcomeMessage.setFont(Font.font("Bold Dejavu Sans Mono", 25));
         welcomeMessage.setPadding(new Insets(Pad));
         welcomeMessage.setAlignment(Pos.CENTER);
         
    // making intro
         intro = new Label(problem.getIntroduction());
         intro.setPrefWidth(width-100);
         intro.setFont(Font.font("Bold Dejavu Sans Mono", 17));
         intro.setPadding(new Insets(Pad));
         intro.setWrapText(true);
        
    
    // makes a new horizontal box for the curstate then buttons then final state
        stateBox = new HBox();
        stateBox.setAlignment(Pos.CENTER);
        stateBox.setPadding(new Insets(Pad));
    
    // makes a new v box that the current state and text will go into
        curStateBox = new VBox();
        curStateBox.setAlignment(Pos.CENTER);
        curStateBox.setPadding(new Insets(Pad));
        
    // making current text 
         curText = new Label("Current State:");
         curText.setFont(Font.font("Bold Dejavu Sans Mono", 20));
         curText.setPadding(new Insets(Pad));
         

    // making current state
         curState = new Label(problem.getCurrentState().toString());
         curState.setFont(Font.font(java.awt.Font.MONOSPACED, 17));
         curState.setPadding(new Insets(Pad));
         curState.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                 CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    
    // adds the current text and current state into the curstate vbox
         curStateBox.getChildren().addAll(curText,curState);
         
    // makes a new v box to add the buttons into     
         buttonBox = new VBox();
         buttonBox.setPadding(new Insets(Pad));
         buttonBox.setAlignment(Pos.CENTER);
    
    // makes a new lable to go above the buttons which counts the number ov moves done         
         buttonLabel = new Label("Number of Moves: " + solver.getMoveCount());
         buttonLabel.setFont(Font.font("Bold Dejavu Sans Mono", 15));
         buttonLabel.setPadding(new Insets(Pad));
    
    // adds button label to the button box
         buttonBox.getChildren().add(buttonLabel);
     
    // mover gets the move names and adds them to moveNames List     
         moveNames = problem.getMover().getMoveNames();
         

    // makes button 1
             b1 = new Button(moveNames.get(0));             
             b1.setPrefWidth(this.width);
             b1.setPrefHeight(this.height);
             b1.setAlignment(Pos.CENTER);b1.setOnAction(e -> {solver.tryMove(moveNames.get(0));
                updateDisplay();});
             buttonBox.getChildren().add(b1);
    
    // makes button 2         
             b2 = new Button(moveNames.get(1));        
             b2.setPrefWidth(this.width);
             b2.setPrefHeight(this.height);
             b2.setAlignment(Pos.CENTER);
             b2.setOnAction(e -> {solver.tryMove(moveNames.get(1));
                updateDisplay();});
             buttonBox.getChildren().add(b2);
             
    // makes button 3
             b3 = new Button(moveNames.get(2));
             b3.setAlignment(Pos.CENTER);
             b3.setPrefWidth(this.width);
             b3.setPrefHeight(this.height);
             b3.setOnAction(e -> {solver.tryMove(moveNames.get(2));
                updateDisplay();});
             buttonBox.getChildren().add(b3);
            
             
    // makes button 4
             b4 = new Button(moveNames.get(3)); 
             b4.setPrefWidth(this.width);
             b4.setPrefHeight(this.height);
             b4.setAlignment(Pos.CENTER);
             b4.setOnAction(e -> {solver.tryMove(moveNames.get(3));
                updateDisplay();});
             buttonBox.getChildren().add(b4);
             
             
    //initializes button 5 but does not add it the the button vbox if there is no move name for it         
             b5 = new Button();
             
             if(moveNames.size() > 4){
                 
             b5.setText(moveNames.get(4));
             b5.setAlignment(Pos.CENTER);
             b5.setPrefWidth(this.width);
             b5.setPrefHeight(this.height);
             b5.setOnAction(e -> {solver.tryMove(moveNames.get(4));
                updateDisplay();}); 
             buttonBox.getChildren().add(b5);
             
             }
    // intialize but does not add button 6 if there is no need         
             b6 = new Button();
             if(moveNames.size() > 5){
                 
             b6.setText(moveNames.get(5));
             b6.setAlignment(Pos.CENTER);
             b6.setPrefWidth(this.width);
             b6.setPrefHeight(this.height);
             b6.setOnAction(e -> {solver.tryMove(moveNames.get(5));
                updateDisplay();}); 
             buttonBox.getChildren().add(b6);
             }
             
    // initailizes button 7 but does not add it if there is no need         
             b7 = new Button();
             if(moveNames.size() > 6){
                 
             b7.setText(moveNames.get(6));
             b7.setAlignment(Pos.CENTER);
             b7.setPrefWidth(this.width);
             b7.setPrefHeight(this.height);
             b7.setOnAction(e -> {solver.tryMove(moveNames.get(6));
                updateDisplay();}); 
             buttonBox.getChildren().add(b7);
             }
             
    // initializes button 8 but does not add it to vbox if there is no need         
             b8 = new Button();
             if(moveNames.size() > 7){
                 
             b8.setText(moveNames.get(7));
             b8.setAlignment(Pos.CENTER);
             b8.setPrefWidth(this.width);
             b8.setPrefHeight(this.height);
             b8.setOnAction(e -> {solver.tryMove(moveNames.get(7));
                updateDisplay();}); 
             buttonBox.getChildren().add(b8);
             }
             
    // initializes button 9 but does not add it to the vbox if there is no need
             b9 = new Button();
             if(moveNames.size() > 8){
                 
             b9.setText(moveNames.get(8));
             b9.setAlignment(Pos.CENTER);
             b9.setPrefWidth(this.width);
             b9.setPrefHeight(this.height);
             b9.setOnAction(e -> {solver.tryMove(moveNames.get(8));
                updateDisplay();}); 
             buttonBox.getChildren().add(b9);
             }
 
                             
             
             
    // makes a new v box for final text and final state box    
        finalStateBox = new VBox();
        finalStateBox.setPadding(new Insets(Pad));
        finalStateBox.setAlignment(Pos.CENTER);
    
    // makes final state text label to go at the top of final state box    
        finalStateText = new Label("Goal State: ");
        finalStateText.setFont(Font.font("Bold Dejavu Sans Mono", 17));
        finalStateText.setPadding(new Insets(Pad));
    
    // makes a new final state from the problem and makes it into a string and surrounds it by a box
        finalState = new Label(problem.getFinalState().toString());
        finalState.setFont(Font.font(java.awt.Font.MONOSPACED, 17));
        finalState.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                 CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        finalState.setPadding(new Insets(Pad));
        finalStateBox.getChildren().addAll(finalStateText,finalState);
     
    //adds all the state and buttons into the hbox made prev in the correct order
        stateBox.getChildren().addAll(curStateBox,buttonBox,finalStateBox);
    
    //make a new v box to center message and reset
        resetBox = new VBox();
        resetBox.setAlignment(Pos.CENTER);
        resetBox.setPadding(new Insets(10));
     
    // New v box for the message so it can be centered
        messageBox = new HBox();
        messageBox.setAlignment(Pos.CENTER);
        messageBox.setPadding(new Insets(10));
     
    // makes a new label message that only appears when it needs to say someting to the user    
        message = new Label("");
        message.setFont(Font.font("Red Bold Dejavu Sans Mono" , 16));
        message.setAlignment(Pos.CENTER);
        message.setTextFill(Color.RED);  
        messageBox.getChildren().add(message);
   
    
    
    
    // intialize combobox and add the appropriate items
        searchType = new ComboBox();
        searchType.getItems().addAll("Breadth-First Search",
                "Depth-First Search","A* Search");  
    
    //make a new combo box for the benchmarks
       
        
    //initialize the SSsolver and solution
        SSsolver = new StateSpaceSolver(problem,true);
        solution = SSsolver.getSolution();
        
    
    
    // makes a new button that cycles through the stats    
        next = new Button("Next");
        next.setFont(Font.font("Dejavu Sans Mono", 12));
        next.setPrefWidth(this.width);
        next.setPrefHeight(this.height);
        next.setAlignment(Pos.CENTER);
        next.setPadding(new Insets(Pad));
        next.setDisable(true);
        next.setOnAction(e -> {
            
            problem.setCurrentState( (State) solution.next().getData());
            updateDisplay();
        });
    
        // makes new button to auto solve the puzzels
        solve = new Button("Solve");
        solve.setFont(Font.font("Dejavu Sans Mono", 12));
        solve.setPrefWidth(this.width);
        solve.setPrefHeight(this.height);
        solve.setAlignment(Pos.CENTER);
        solve.setPadding(new Insets(Pad));
        solve.setOnAction(e -> {
        problem.setInitialState(problem.getCurrentState());
            if (searchType.getValue() == "Breadth-First Search"){
               SSsolver = new StateSpaceSolver(this.problem, true);
               SSsolver.solve(); 
               solution = SSsolver.getSolution();
               solution.next();
            }else if(searchType.getValue() == "Depth-First Search"){
               SSsolver = new StateSpaceSolver(this.problem, false);
               SSsolver.solve();
               solution = SSsolver.getSolution();
               solution.next();
            }else if(searchType.getValue() == "A* Search"){
               /*ASsolver = new AStarSolver(problem);
               b = (Benchmark) BenchChoice.getValue();
               problem.setCurrentState(b.getState());
               problem.setInitialState(b.getState());
               ASsolver.solve();
               solution = ASsolver.getSolution();
               solution.next();*/
            }
            solver.reset();
            next.setDisable(false);
            solve.setDisable(true);
            b1.setDisable(true);
            b2.setDisable(true);
            b3.setDisable(true);
            b4.setDisable(true);
            b5.setDisable(true);
            b6.setDisable(true);
            b7.setDisable(true);
            b8.setDisable(true);
            b9.setDisable(true);
            message.textProperty().setValue("");
            updateDisplay();
        });
        
        // makes and adds a new reset button to the button of the 
        reset = new Button("Reset");
        reset.setFont(Font.font("Dejavu Sans Mono", 12));
        reset.setPrefWidth(this.width);
        reset.setPrefHeight(this.height);
        reset.setAlignment(Pos.CENTER);
        reset.setPadding(new Insets(Pad));
        reset.setOnAction(e -> {solver.reset();
                                message.textProperty().setValue("");
                                next.setDisable(true);
                                solve.setDisable(false);
                                b1.setDisable(false);
                                b2.setDisable(false);
                                b3.setDisable(false);
                                b4.setDisable(false);
                                b5.setDisable(false);
                                b6.setDisable(false);
                                b7.setDisable(false);
                                b8.setDisable(false);
                                b9.setDisable(false);
                                updateDisplay();});
        
    // adds all the buttons to the reset box
        resetBox.getChildren().addAll(solve,next,reset);
    
    // makes a new hbox for the reset v box combobox and statistics
        buttonHbox = new HBox();
        buttonHbox.setAlignment(Pos.CENTER);
        buttonHbox.setPadding(new Insets(Pad));

      
    
    // statistics label for the statistics box
        statLabel = new Label("Statistics");
        statLabel.setFont(Font.font("Bold Dejavu Sans Mono", 17));
        statLabel.setPadding(new Insets(Pad));
    
    //makes the stats sting and puts it in a box
        statistics= new Label(SSsolver.getStatistics().toString());
        statistics.setFont(Font.font(java.awt.Font.MONOSPACED, 17));
        statistics.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                 CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        statistics.setPadding(new Insets(Pad));  
    
    // makes a statistics vbox and adds the label and the stats box
        statBox = new VBox();
        statBox.setAlignment(Pos.CENTER);
        statBox.setPadding(new Insets(Pad));
        statBox.getChildren().addAll(statLabel,statistics);
// add all the parts to the button hbox
        buttonHbox.setSpacing(10);
        buttonHbox.getChildren().addAll(resetBox,searchType,makeBenchmark(),statBox);
            
                
        
        
        
        
        
        super.getChildren().addAll(welcomeMessage,
                                   intro,
                                   stateBox,
                                   messageBox,
                                   buttonHbox);
        
    
         

     }
     
    private SolvingAssistant solver;
    private final List<String> moveNames; 
    private final Label welcomeMessage, intro, curState, curText, message,finalStateText,finalState,buttonLabel,statLabel,statistics;
    private final HBox stateBox, buttonHbox,messageBox;
    private final VBox curStateBox, buttonBox, finalStateBox, resetBox,statBox;
    private final ComboBox<String> searchType;
    private StateSpaceSolver SSsolver;
    private final double width = 150;
    private final double height = 30;
    private final double Pad;
    private final Button reset, b1, b2, b3, b4,b5,b6,b7,b8,b9, solve, next;
    private final Problem problem;
    private Solution solution;
    private AStarSolver ASsolver;
    private ChoiceBox BenchChoice;
    private Benchmark b;
    
    
    private ChoiceBox makeBenchmark(){
        BenchChoice = new ChoiceBox<>(FXCollections.observableArrayList(problem.getBenchmarks()));
        BenchChoice.setPrefHeight(20);
        BenchChoice.setPrefWidth(150);
        return BenchChoice;
    }
    
    
    
    private void updateDisplay() {
        
        curState.textProperty().setValue(problem.getCurrentState().toString());
        buttonLabel.textProperty().setValue("Number of Moves: " + solver.getMoveCount());
        statistics.textProperty().setValue(SSsolver.getStatistics().toString());
        message.textProperty().setValue("");
        if(solver.isProblemSolved()){
                message.textProperty().setValue("Congratulations! You have solved the problem!");
        }
       
        if(!solver.isMoveLegal()){
            message.textProperty().setValue("Illegal move, Try again.");
        }
    }
 
}
