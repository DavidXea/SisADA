package david;
/**
 *
 * @author david
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class MinhasAvaliacoes extends InterfaceUsuario {
    
    FileOutputStream arquivo;
    public MinhasAvaliacoes() throws IOException {
        super("MinhasAvaliacoesFXML.fxml");
    }   
    
    @FXML
    private TableView<Avaliacao> tableAvaliacoes;
    
    @FXML
    private TableColumn<Avaliacao, String> tableColunaNomeProva;
    
    @FXML
    private TableColumn<Avaliacao , String> tableColunaMedia;

    @FXML
    private TableColumn<Avaliacao, String> tableColunaPeso;
    
    @FXML
    private TableColumn<Avaliacao , String> tableColunaNota;
    
    @FXML
    private TableColumn<Avaliacao , String> tableColunaDisciplina;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            carregaTabelaAvaliacoes();
            
        } catch (IOException ex) {
            Logger.getLogger(MinhasAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    private ObservableList<Avaliacao> observableListaAvaliacoes;

    public void carregaTabelaAvaliacoes() throws FileNotFoundException, IOException{
        
        tableColunaNomeProva.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColunaMedia.setCellValueFactory(new PropertyValueFactory<>("mediaString"));
        tableColunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        tableColunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        tableColunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        
        observableListaAvaliacoes = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());
        tableAvaliacoes.setItems(observableListaAvaliacoes);
                
    }
    
    
    @FXML
    public void onClickVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtInformarNota(){
            if(tableAvaliacoes.getSelectionModel().getSelectedItem() == null ){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("ITEM NÃO SELECIONADO");
            aviso.setContentText("É NECESSARIO SELECIONAR UMA PROVA PARA ADICIONAR UMA NOTA ");
            aviso.showAndWait();
        }else{
        Avaliacao itemSelecionada = (Avaliacao) tableAvaliacoes.getSelectionModel().getSelectedItem();
        InformarNota telaInformaNota = new InformarNota();
        telaInformaNota.setAvaliacaoDaVez(itemSelecionada);
                
        GerenciadorJanela.obterInstancia().abreJanela(telaInformaNota);
        }

    }
     
    @FXML
    public void onClickBtAdicionarNovaAvaliacao() throws FileNotFoundException{
        GerenciadorJanela.obterInstancia().abreJanela(new AdicionarNovaAvaliacao());
    } 
}

