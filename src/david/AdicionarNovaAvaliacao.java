package david;
/**
 *
 * @author david
 */

import java.io.IOException;
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
        comboBoxDisciplina.setItems(disciplinas);
        medias = FXCollections.observableArrayList("M1","M2","M3");
        comboBoxMedias.setItems(medias);
    }
    
    @FXML
    public void onClickBTSalvarNovaAvaliacao() throws IOException{

        Avaliacao novaProva = new Avaliacao();
        novaProva.setNome(textNomeProva.getText());
        novaProva.setDisciplina(comboBoxDisciplina.getSelectionModel().getSelectedItem());
        novaProva.setMedia(comboBoxMedias.getSelectionModel().getSelectedItem().toCharArray());
        novaProva.setPeso(Double.parseDouble(textPesoProva.getText()));
        
        novaProva.Salvar();
    }    
    
    @FXML
    public void onClickVoltaBTMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
}