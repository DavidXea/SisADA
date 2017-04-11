package david;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class Principal extends InterfaceUsuario {

    public Principal() {
        super("PrincipalFXML.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    public void onClickBtMinhasAvaliacoes() throws IOException{
            GerenciadorJanela.obterInstancia().abreJanela(new MinhasAvaliacoes());
    }
    
    @FXML
    public void onClickBtMeuDesempenho(){
        GerenciadorJanela.obterInstancia().abreJanela(new MeuDesempenho());
    }
}