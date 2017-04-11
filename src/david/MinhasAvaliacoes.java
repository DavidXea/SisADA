package david;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MinhasAvaliacoes extends InterfaceUsuario {
    
    FileOutputStream arquivo;
    public MinhasAvaliacoes() throws IOException {
        super("MinhasAvaliacoesFXML.fxml");
        this.listaAvaliacoes = Avaliacao.obterListaAvaliacoes();
    }
    
    @FXML
    private TableView<Avaliacao> tableAvaliacoes;
    
    @FXML
    private TableColumn<Avaliacao , String> tableColunaMedia, tableColunaPeso , tableColunaNomeProva , tableColunaMinhaNota;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            carregaTabelaAvaliacoes();
        } catch (IOException ex) {
            Logger.getLogger(MinhasAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private final List<Avaliacao> listaAvaliacoes;

    private ObservableList<Avaliacao> observableListaAvaliacoes;
    
    public void carregaTabelaAvaliacoes() throws FileNotFoundException, IOException{
        tableColunaNomeProva.setCellValueFactory(new PropertyValueFactory<>("nome"));
       
        observableListaAvaliacoes = FXCollections.observableArrayList(listaAvaliacoes);
        
        tableAvaliacoes.setItems(observableListaAvaliacoes);
    }
    
    
    
    
    @FXML
    public void onClickVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtInformarNota(){
        GerenciadorJanela.obterInstancia().abreJanela(new InformarNota());
    }    
    
    @FXML
    public void onClickBtAdicionarNovaAvaliacao() throws FileNotFoundException{
        GerenciadorJanela.obterInstancia().abreJanela(new AdicionarNovaAvaliacao());
    }
    
}

