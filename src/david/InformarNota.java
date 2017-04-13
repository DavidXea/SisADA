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
import javafx.scene.control.Button;

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
        Avaliacao a1 = new Avaliacao();
        //MinhasAvaliacoes.selecionarItemTableAvaliacoes();
        
        
        
        GerenciadorJanela.obterInstancia().abreJanela(new InformarNota());
    }
}