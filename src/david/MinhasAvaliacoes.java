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
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        tableColunaMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
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
        GerenciadorJanela.obterInstancia().abreJanela(new InformarNota());
    }    
    
    @FXML
    public void onClickBtAdicionarNovaAvaliacao() throws FileNotFoundException{
        GerenciadorJanela.obterInstancia().abreJanela(new AdicionarNovaAvaliacao());
    }
    
}

