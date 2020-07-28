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
import javafx.scene.chart.LineChart;
//библиотеки для графа
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;




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

    long Combat(long a0,long at, double E){
        long res= (long)(E*(a0-at));
        return res;
    }

    double kpd(int k){
        return (1-((int) (Math.random() * (k - k*0.63) + k*0.63))*0.01);
    }

    @FXML
    void click(ActionEvent event) {
        int humanFactor = (int)slider.getValue();
        long A0 = Long.parseLong(A_side1.getText());
        long At = Long.parseLong(A_side2.getText());
        double Ea = Double.parseDouble(A_side3.getText());
        long B0 = Long.parseLong(B_side1.getText());
        long Bt = Long.parseLong(B_side2.getText());
        double Eb = Double.parseDouble(B_side3.getText());


        humanFactor = 50;
        A0 =1000;
        At =750;
        Ea =0.98;
        B0 =2000;
        Bt =1500;
        Eb =0.97;



        System.out.println(A0);
        System.out.println(At);
        System.out.println(Ea);
        System.out.println(B0);
        System.out.println(Bt);
        System.out.println(Eb);
        System.out.println("========================================\n");

        double E1,E2,K1,K2;
        long y;

        while(At>0 && Bt>0){

            E1=(Ea*kpd(humanFactor))/(Eb*kpd(humanFactor));
            E2=(Eb*kpd(humanFactor))/(Ea*kpd(humanFactor));

                y=At;

                At=A0-(long)(E2*(B0));
                Bt=B0-(long)(E1*(A0));

                System.out.println(At+"    At");
                System.out.println(Bt+"    Bt");
                System.out.println("++++++++++++++++++++++++\n");

                A0=At;
                B0=Bt;

                System.out.println(At+"    At");
                System.out.println(Bt+"    Bt");
        }
    }


    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    //переменные для графика
    private int MaxYear;
    private int[] A_array, B_array;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //тест
//        MaxYear = 10;
//        A_array = new int[MaxYear];
//        B_array = new int[MaxYear];
//        for (int i = 0; i < 10; i++){
//            A_array[i] = 10 + i;
//            B_array[i] = i + 1;
//        }
        //конец теста

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        for (int i = 1; i < MaxYear; i++) {
            String str = Integer.toString(i);
            series1.getData().add(new XYChart.Data(str,A_array[i-1]));
            series2.getData().add(new XYChart.Data(str,B_array[i-1]));
        }
        lineChart.getData().addAll(series1, series2);
    }
}