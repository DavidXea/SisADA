package david;
/**
 *
 * @author david
 */

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    
    private boolean verificaCondicao(){
        if("".equals(textNomeProva.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("CAMPO VAZIO");
            aviso.setContentText("É NECESSARIO PREENCHER O CAMPO NOME");
            aviso.showAndWait();
        return false;
        }        
        if("".equals(textPesoProva.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("CAMPO VAZIO");
            aviso.setContentText("É NECESSARIO PREENCHER O CAMPO PESO");
            aviso.showAndWait();
        return false;
        }
        if(comboBoxDisciplina.getSelectionModel().getSelectedItem() == null){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("DISCIPLINA NÃO SELECIONADA");
            aviso.setContentText("É NECESSARIO SELECIONAR UMA DISCIPLINA");
            aviso.showAndWait();
        return false;
        }
        if(comboBoxMedias.getSelectionModel().getSelectedItem()== null){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("MEDIA NÃO SELECIONADA");
            aviso.setContentText("É NECESSARIO SELECIONAR UMA MEDIA");
            aviso.showAndWait();
        return false;
        }
        return true;
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        try {
            carregaListaDisciplinasMedias();
        } catch (IOException ex) {
            Logger.getLogger(AdicionarNovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregaListaDisciplinasMedias() throws IOException{
        
        Path path = Paths.get("Disciplinas.csv");
        List<String> linhas = Files.readAllLines(path);

        disciplinas = FXCollections.observableArrayList(linhas);
        comboBoxDisciplina.setItems(disciplinas);
        medias = FXCollections.observableArrayList("M1","M2","M3");
        comboBoxMedias.setItems(medias);
    }
    
    @FXML
    public void onClickBTSalvarNovaAvaliacao() throws IOException{
        if(verificaCondicao()){
        Avaliacao novaProva = new Avaliacao();
        
        novaProva.setNome(textNomeProva.getText());
        novaProva.setDisciplina(comboBoxDisciplina.getSelectionModel().getSelectedItem());
        novaProva.setMedia(comboBoxMedias.getSelectionModel().getSelectedItem().toCharArray());
        novaProva.setPeso(Double.parseDouble(textPesoProva.getText()));
        
        novaProva.Salvar();
        }
    }    
    
    @FXML
    public void onClickVoltaBTMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
}