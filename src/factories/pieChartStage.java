package factories;

import controller.pieController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class pieChartStage extends ChartStages {
    private FXMLLoader loader;
    private Stage newStage;
    private pieController pc;

    public pieChartStage(FXMLLoader fxmlLoader, Stage stage){
        loader = fxmlLoader;
        newStage = stage;
    }
    @Override
    public void init() throws IOException {
        Pane root=loader.load(getClass().getResource("/view/piechart.fxml").openStream());
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.DECORATED);
        pc = loader.getController();
        pc.initData(newStage);
        newStage.show();
        newStage.setResizable(false);
    }

    @Override
    public void showData() {
        pc = loader.getController();
        pc.showData();
    }
}
