package factories;

import controller.barController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class barChartStage extends ChartStages {
    private FXMLLoader loader;
    private Stage newStage;
    private barController bc;

    public barChartStage(FXMLLoader fxmlLoader, Stage stage) {
        loader = fxmlLoader;
        newStage = stage;
    }

    @Override
    public void init() throws IOException {
        Pane root=loader.load(getClass().getResource("/view/barChart.fxml").openStream());
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.DECORATED);
        bc = loader.getController();
        bc.initData(newStage);
        newStage.show();
        newStage.setResizable(false);
    }
    @Override
    public void showData() {
        bc = loader.getController();
        bc.showData();
    }
}
