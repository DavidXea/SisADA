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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class MeuDesempenho extends InterfaceUsuario{

    public MeuDesempenho() {
        super("MeuDesempenhoFXML.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    public void onClickVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }

}