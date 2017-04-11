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
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class InformarNota extends InterfaceUsuario{

    @FXML
    private Button voltarMinhasAvaliacoesBT;


    public InformarNota() {
        super("InformarNotaFXML.fxml");
    }
    


    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    public void onClickVoltaMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtSalvar(){
        //GerenciadorJanela.obterInstancia().abreJanela(new InformarNota());
    }
}