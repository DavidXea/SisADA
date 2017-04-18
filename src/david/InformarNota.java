package david;

/**
 *
 * @author david
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
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
//        Avaliacao novaNota = new Avaliacao();
        
        avaliacaoDaVez.setNota(Double.parseDouble(textNotaProva.getText()));
        avaliacaoDaVez.atualizar();
    }
}