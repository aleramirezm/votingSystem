package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import model.SingletonCandidates;

import java.net.URL;
import java.util.ResourceBundle;

public class barController implements Initializable {
    private Stage stage;
    private SingletonCandidates candidates = SingletonCandidates.createInstance();

    @FXML private BarChart<?,?> barChart; @FXML private CategoryAxis xAxis; @FXML private NumberAxis yAxis;


    public void initData(Stage stage) {
        this.stage=stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showData(){
        barChart.getData().clear();
        XYChart.Series set1 = new XYChart.Series<>();
        for(int i = 0; i< candidates.candidateList().size(); i++){
            set1.getData().add(new XYChart.Data(candidates.candidateList().get(i).getName(),
                    candidates.candidateList().get(i).getVotes()));
        }
        barChart.getData().addAll(set1);
    }
}
