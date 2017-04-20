package david;

/**
 *
 * @author david
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InformarNota extends InterfaceUsuario{

    @FXML
    private TextField textNotaProva;

    @FXML
    private Label labelNomeProva, labelDisciplina, labelMedia;
    
    private Avaliacao avaliacaoDaVez;

    public InformarNota() {
        super("InformarNotaFXML.fxml");
    }
    
    public void setAvaliacaoDaVez(Avaliacao avaliacaoDaVez){
        this.avaliacaoDaVez = avaliacaoDaVez;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
            labelNomeProva.setText("Nome : "+this.avaliacaoDaVez.getNome());
            labelDisciplina.setText("Disciplina : "+this.avaliacaoDaVez.getDisciplina());
            labelMedia.setText("Media : "+this.avaliacaoDaVez.getMediaString());
    }
    
    @FXML
    public void onClickVoltaMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtSalvar() throws IOException{
        if("".equals(textNotaProva.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("CAMPO VAZIO");
            aviso.setContentText("É NECESSARIO IMFORMAR A NOTA");
            aviso.showAndWait();
        }else{
            avaliacaoDaVez.setNota(Double.parseDouble(textNotaProva.getText()));
            avaliacaoDaVez.atualizar();
        }     
    }
}