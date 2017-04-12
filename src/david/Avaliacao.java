/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author david
 */
public class Avaliacao {
    private String nome;
    private String disciplina;
    private double peso;
    private String media;
    //private char[] media = new char[2];
    private String nota;
    private int identificadorDoArquivo;
    

    

        
public static List<Avaliacao> obterListaAvaliacoes() throws FileNotFoundException, IOException {
        List<Avaliacao> listAvaliacao = new ArrayList();
    
        char ch;
        String atributo = "";
        double aDouble;
        
        FileReader arquivo =  new FileReader("Avaliacoes.csv");
        BufferedReader lerArquivo = new BufferedReader(arquivo);
        
        String linha = "";
        
        while(linha != null){
            Avaliacao a1 = new Avaliacao();
            for(int i = 1; i<5; i++){
                
                while((ch = (char)lerArquivo.read()) != ';'){
                    atributo += ch;
                    System.out.print("\n"+atributo);
                }
                
                switch (i)
                {
                    //Arquitetura;provaum;1;M2;
                    //Estrutura;provadois;1;M1;
                    case 1:
                        a1.setDisciplina(atributo);
                        break;
                    case 2:
                        a1.setNome(atributo);
                        break;
                   case 3:
                        aDouble = Double.parseDouble(atributo); 
                        a1.setPeso(aDouble);
                        break;
                    case 4:
                        a1.setMedia(atributo);

                        //li.media[0] = palavra.charAt(0);
                        //li.media[1] = palavra.charAt(1);
                        break;
                    case 5:
                        a1.setNota(atributo);
                }
                atributo = "";
            }
            System.out.print("\nPRINTE DA LINHA|" + linha+ "|\n");
            linha = lerArquivo.readLine();
            System.out.print("\nPRINTE DA LINHA|" + linha+ "|\n");
            listAvaliacao.add(a1);
        }
        lerArquivo.close();
        return listAvaliacao;
    }
    
    public double calculaMediaDaDisciplina(String m, char n){
        return 0;
    }   
        
    
    public void Salvar(){}
    
    public void atualizar(){}
    
    public void setNome(String novoCriterio){
        this.nome = novoCriterio;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setMedia(String novaMedia){
        this.media = novaMedia;
    }
    
    public String getMedia(){
        return this.media;
    }
    
    public void setDisciplina(String novaDisciplina){
        this.disciplina = novaDisciplina;
    }
    
    public String getDisciplina(){
        return this.disciplina;
    }
    
    public void setPeso(double novoPeso){
        this.peso = novoPeso;
    }
    
    public double getPeso(){
        return this.peso;
    }
    
    public void setNota(String novaNota){
        this.nota = novaNota;
    }
    
    public String getNota(){
        return this.nota;
    }
}

