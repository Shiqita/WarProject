//////////////////////////////////////////////////////////////////////////////////////////////////
// A0 - At = E2*(B0 - Bt)                                                                       //
// ? = E2*(B0 - Bt)                                                                             //
// ? = (сила оружия) * (убитых Б)                                                               //
// (убойная сила А за бой) = (сила оружия) * (убитых Б)                                         //
// => сторона А не может убить больше (убитых Б) за один бой                                    //
// => (убойная сила А) - почти статична                                                         //
// Fa = E2 * (B0 - B1)                                                                          //
// Fb = E1 * (A0 - A1)                                                                          //
// как спрогнозировать следующий бой?                                                           //
// Fa = A0 - A1                                                                                 //
// Fa = A1 - A2                                                                                 //
// A0 - A1 = E2*(B0 - B1) знаем как посчитать сколько у нас погибло                             //
// A1 - A2 = E2*(B1 - B2)                                                                       //
// A2 - A3 = E2*(B2 - B3)                                                                       //
//                                                                                              //
// A1 - A2 = ?                                                                                  //
// A2 = A1 - E2 * (B1 - B2) но мы знаем только результаты предыдущего боя =>                    //
// A2 = A1 - E2 * (B0 - B1) тем самым предпологая что сила будет той же                         //
// A2 = A1 - Fa //узнаем сколько выжило в первой битве                                          //
//                                                                                              //
// B1 - B2 = ?                                                                                  //
// B2 = B1 - E1 * (A1 - A2) но мы не знаем результаты, так же предпологаем результаты прошлого  //
// B2 = B1 - E1 * (A0 - A1)                                                                     //
// B2 = B1 - Fb //узнаем сколько умерло после двух войн                                         //
//...                                                                                           //
//////////////////////////////////////////////////////////////////////////////////////////////////
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
    private Button clearGr;

    @FXML
    private Text textResUnder;

    @FXML
    private Text textResTitle;

    double kpd(int k) {
        return (1-((int)(Math.random() * (k - k*0.63) + k*0.63))*0.01);
    }

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    //переменные для графика
    private int CountBattle;
    //private int[] A_array, B_array;
    private final long[] A_array = new long[1000];
    private final long[] B_array = new long[1000];

    @FXML
    void click(ActionEvent event) {

        CountBattle = 0;

        int humanFactor = (int)slider.getValue();
        long A0 = Long.parseLong(A_side1.getText());
        long B0 = Long.parseLong(B_side1.getText());
        long At = Long.parseLong(A_side2.getText());
        long Bt = Long.parseLong(B_side2.getText());
        double Ea = Double.parseDouble(A_side3.getText());
        double Eb = Double.parseDouble(B_side3.getText());

//        humanFactor = 50;
//        A0 =1000;
//        At =750;
//        Ea =0.98;
//        B0 =2000;
//        Bt =1500;
//        Eb =0.97;

        System.out.println("--input start--");
        System.out.println(A0);
        System.out.println(At);
        System.out.println(Ea);
        System.out.println(B0);
        System.out.println(Bt);
        System.out.println(Eb);
        System.out.println("--input end--");

//        buf = At;
//        At=A0-(long)(E2*(Bt));
//        Bt=B0-(long)(E1*(At));

        double E1,E2;
        long A2 = 1,B2 = 1;
        long A1 = At, B1 = Bt;

        while((A0 > 0) && (B0 > 0))
        {
            //для избежания переполнения в массиве для графа, маловероятно, но, береженого бог бережет!
            if (CountBattle == 999) break;

            E1=(Ea*kpd(humanFactor))/(Eb*kpd(humanFactor));
            E2=(Eb*kpd(humanFactor))/(Ea*kpd(humanFactor));

            A2 = A1 - Math.abs((long)(E2 * (B0 - B1)));
            B2 = B1 - Math.abs((long)(E1 * (A0 - A1)));

            //if (A1 < 0) A1 = 0; else if (B1 < 0) B1 = 0; //чтобы небыло отрицательной смертности
            A_array[CountBattle] = A0;
            B_array[CountBattle] = B0;

            System.out.println("\n--Бой " + CountBattle + "--");
            System.out.println("погибло A2|\t" + (A0 - A1));
            System.out.println("погибло B2|\t" + (B0 - B1));
            System.out.println("выжило A|\t" + (A1/* - Math.abs(A2)*/));
            System.out.println("выжило B|\t" + (B1/* - Math.abs(B2)*/));

            B0 = B1;
            A0 = A1;
            B1 = B2;
            A1 = A2;

            CountBattle += 1;
        }
        //собрать последние данные
        A_array[CountBattle] = A0;
        B_array[CountBattle] = B0;

        // Данные для итога
        String wName = "ничья";;
        long wArm = 0;
        if (CountBattle != 999)
            if (A0 > B0) { wName = "A"; wArm = A0; } else
                if (A0 < B0) { wName = "B"; wArm = B0;} //простите

        // Вывод итога
        textResUnder.setText("В результате посленей войны было совершено " + Integer.toString(CountBattle) + " сражений.\n" +
                             "Победила сторона " + wName + " в количестве " + Long.toString(wArm) + " единиц.");

        // Строим график
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        lineChart.setTitle("График");
        series1.setName("сторона A");
        series2.setName("сторона B");
        for (int i = 0; i < CountBattle + 1; i++) {
            series1.getData().add(new XYChart.Data(Integer.toString(i), A_array[i]));
            series2.getData().add(new XYChart.Data(Integer.toString(i), B_array[i]));
        }
        lineChart.getData().addAll(series1, series2);
    }

    //Обработчик очистка графика
    public void clickClearGr(ActionEvent actionEvent) {
        lineChart.getData().clear();
        textResUnder.setText("");
    }

    //Обработчик очистка полей
    public void clickClearField(ActionEvent actionEvent) {
        A_side1.setText("");
        A_side2.setText("");
        A_side3.setText("");
        B_side1.setText("");
        B_side2.setText("");
        B_side3.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}