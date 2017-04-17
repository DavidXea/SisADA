package david;
/**
 *
 * @author david
 */
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
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

    //private ObservableList<String> observablelistDisciplinas = FXCollections.observableArrayList();
    
    XYChart.Series series = new XYChart.Series<>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            carregaListaDisciplinasMedias();
            
    }
    
    public void carregaListaDisciplinasMedias(){
        disciplinas = FXCollections.observableArrayList("Arquitetura", "POO", "Estrutura");
        //medias = FXCollections.observableArrayList("M1","M2","M3");
        comboBoxDisciplina.setItems(disciplinas);
        //comboBoxMedias.setItems(medias);
    }
    
    
    @FXML
    public void onClickAdd() throws FileNotFoundException{
        
        //addItem.add(comboBoxDisciplina.getSelectionModel().getSelectedItem());
        System.out.print(Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "Media") );
        
        //categoryAxis.setCategories(addItem);
        //numberAxis.setTickUnit(11);
        
        series.getData().add(new XYChart.Data(comboBoxDisciplina.getSelectionModel().getSelectedItem() , Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "Media")));
        
        barChart.getData().add(series);
    }
    
    @FXML
    public void onClickVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }

}