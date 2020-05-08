package factories;


import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class FactoryStage {
   public ChartStages init(FXMLLoader fxmlLoader, Stage stage, String type){
       if(type.equalsIgnoreCase("pie")) return new pieChartStage(fxmlLoader, stage);
       if(type.equalsIgnoreCase("bar")) return new barChartStage(fxmlLoader, stage);
       return null;
   }
}
