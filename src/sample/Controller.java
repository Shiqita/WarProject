package sample;


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
    private Slider slider;

    @FXML
    private Button count;

    @FXML
    private Text textout;

    int Combat(int a0,int at,int b0, int Bt, int E){

        return kek;
    }

    @FXML
    void click(ActionEvent event) {
        int humanFactor = (int)slider.getValue();
        int kpd = (int) (Math.random() * (humanFactor - humanFactor*0.63) + humanFactor*0.63);
        int A0 = Integer.parseInt(A_side1.getText());
        int At = Integer.parseInt(A_side2.getText());
        int Ea = Integer.parseInt(A_side3.getText());
        int B0 = Integer.parseInt(B_side1.getText());
        int Bt = Integer.parseInt(B_side2.getText());
        int Eb = Integer.parseInt(B_side3.getText());

        Combat();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}