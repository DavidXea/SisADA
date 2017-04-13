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


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AdicionarNovaAvaliacao extends InterfaceUsuario{



    public AdicionarNovaAvaliacao() {
        super("AdicionarNovaAvaliacaoFXML.fxml");
    }
    
    private ObservableList<String> disciplinas, medias;
    
    @FXML
    private ComboBox<String> comboBoxDisciplina, comboBoxMedias;
    
    @FXML
    private TextField textNomeProva, textPesoProva;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        carregaListaDisciplinasMedias();
    }
    
    public void carregaListaDisciplinasMedias(){
        disciplinas = FXCollections.observableArrayList("Arquitetura", "POO", "Estrutura");
        medias = FXCollections.observableArrayList("M1","M2","M3");
        comboBoxDisciplina.setItems(disciplinas);
        comboBoxMedias.setItems(medias);
    }
    
    @FXML
    public void onClickBTSalvarNovaAvaliacao(){
        
        try{
            FileWriter arquivo = new FileWriter("Avaliacoes.csv",true);
            PrintWriter pw = new PrintWriter(arquivo);

            pw.print(comboBoxDisciplina.getSelectionModel().getSelectedItem() + ";"+ textNomeProva.getText() +";"+ textPesoProva.getText() +";"+comboBoxMedias.getSelectionModel().getSelectedItem() + ";"+"\n");
            pw.close();
            arquivo.close();
                                
        }catch(IOException e ){
            e.printStackTrace();
        }
        
        GerenciadorJanela.obterInstancia().voltar();
    }    
    
    @FXML
    public void onClickVoltaBTMinhasAvaliacoes(){
        
        GerenciadorJanela.obterInstancia().voltar();
    }
}