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
import javafx.application.Application;
import javafx.stage.Stage;

public class SisADA extends Application{

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {   
        Principal telaPrincipal = new Principal();      
        GerenciadorJanela.obterInstancia().inicializaPalco(palco, telaPrincipal);        
    }
}
