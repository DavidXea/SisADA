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

    public InformarNota() {
        super("InformarNotaFXML.fxml");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            labelNomeProva.setText("Nome : "+Avaliacao.obterListaAvaliacoes().get(GerenciadorJanela.getIndice()).getNome());
            labelDisciplina.setText("Disciplina : "+Avaliacao.obterListaAvaliacoes().get(GerenciadorJanela.getIndice()).getDisciplina());
            labelMedia.setText("Media : "+Avaliacao.obterListaAvaliacoes().get(GerenciadorJanela.getIndice()).getMedia());
        } catch (IOException ex) {
            Logger.getLogger(InformarNota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void onClickVoltaMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtSalvar() throws IOException{
        Avaliacao novaNota = new Avaliacao();
        novaNota.setNota(Double.parseDouble(textNotaProva.getText()));
        novaNota.atualizar();
    }
}