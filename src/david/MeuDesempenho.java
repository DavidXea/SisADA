package david;
/**
 *
 * @author david
 */
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class MeuDesempenho extends InterfaceUsuario{

    public MeuDesempenho() {
        super("MeuDesempenhoFXML.fxml");
    }
    
    private ObservableList<String> disciplinas, medias;
    
    private ObservableList<String> addItem = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> comboBoxDisciplina, comboBoxMedias;
    
    
    @FXML
    private BarChart<?,?> barChart;
    
    @FXML
    private CategoryAxis categoryAxis;
    
    @FXML
    private NumberAxis numberAxis;

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barChart.setAnimated(false);
        carregaListaDisciplinasMedias();
            
    }
    
    public void carregaListaDisciplinasMedias(){
        disciplinas = FXCollections.observableArrayList("Arquitetura", "POO", "Estrutura");
        comboBoxDisciplina.setItems(disciplinas);
    }
    
    
    @FXML
    public void onClickAdd() throws FileNotFoundException{
        
        System.out.print(Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M2") );
        
        XYChart.Series series = new XYChart.Series<>();
        series.setName(comboBoxDisciplina.getSelectionModel().getSelectedItem());
        barChart.setLegendSide(Side.RIGHT);
        series.getData().add(new XYChart.Data("M1" , Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M1")));
        series.getData().add(new XYChart.Data("M2" , Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M2")));
        series.getData().add(new XYChart.Data("M3" , Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M3")));
        barChart.getData().addAll(series);
    }
    
    @FXML
    public void onClickVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }

}