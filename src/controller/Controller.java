package controller;

import factories.ChartStages;
import factories.FactoryStage;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Candidate;
import model.SingletonCandidates;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML AnchorPane welcomePane; @FXML AnchorPane systemPane;
    Candidate first = new Candidate("Jane Doe", 10);
    Candidate second = new Candidate("Marak Obana", 25);
    Candidate third = new Candidate("John Doe", 14);
    SingletonCandidates singletonCandidates = SingletonCandidates.createInstance();
    FactoryStage factoryStage = new FactoryStage();
    Stage pieStage =new Stage();
    Stage barStage = new Stage();
    FXMLLoader pieLoader=new FXMLLoader();
    FXMLLoader barLoader=new FXMLLoader();
    ChartStages stage1 = factoryStage.init(pieLoader, pieStage, "pie");
    ChartStages stage2 = factoryStage.init(barLoader, barStage, "bar");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startSystem(MouseEvent event) {
        welcomePane.setVisible(false);
        systemPane.setVisible(true);
        adding();
        try {
            stage1.init();
            stage2.init();
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadData(){
        stage1.showData();
        stage2.showData();
    }

    private void adding(){
        singletonCandidates.addCandidate(first);
        singletonCandidates.addCandidate(second);
        singletonCandidates.addCandidate(third);
    }

    public void voteFirst(MouseEvent event){
        int actualVotes = singletonCandidates.candidateList().get(0).getVotes();
        singletonCandidates.candidateList().get(0).setVotes(actualVotes+1);
        loadData();
    }

    public void voteSecond(MouseEvent event){
        int actualVotes = singletonCandidates.candidateList().get(1).getVotes();
        singletonCandidates.candidateList().get(1).setVotes(actualVotes+1);
        loadData();
    }
    public void voteThird(MouseEvent event){
        int actualVotes = singletonCandidates.candidateList().get(2).getVotes();
        singletonCandidates.candidateList().get(2).setVotes(actualVotes+1);
        loadData();
    }


    public void exitSystem(MouseEvent event) {
        System.exit(1);
    }
}
