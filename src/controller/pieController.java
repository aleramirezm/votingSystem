package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import model.SingletonCandidates;


public class pieController {
    @FXML
    PieChart pieChart;
    SingletonCandidates candidates = SingletonCandidates.createInstance();

    Stage stage;
    public void initData(Stage stage) {
        this.stage = stage;
    }
    public void showData(){
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        for(int i = 0; i< candidates.candidateList().size();i++){
            list.add(new PieChart.Data(candidates.candidateList().get(i).getName(),
                    candidates.candidateList().get(i).getVotes()));
        }
        pieChart.setData(list);
    }
}
