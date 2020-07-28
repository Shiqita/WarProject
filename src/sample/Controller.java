package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Controller implements Initializable {

    public VBox group;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollBar ScrollPane;

    @FXML
    private NumberTextField A_side1;

    @FXML
    private NumberTextField A_side2;

    @FXML
    private NumberTextField A_side3;

    @FXML
    private NumberTextField B_side1;

    @FXML
    private NumberTextField B_side2;

    @FXML
    private NumberTextField B_side3;

    @FXML
    public Slider slider;

    @FXML
    private Button count;

    @FXML
    private Text textout;


    @FXML
    void click(ActionEvent event) {
        int humanFactor = (int)slider.getValue();
      //  int nextInt(int n);
      //  Random();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}