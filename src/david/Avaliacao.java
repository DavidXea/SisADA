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
import java.util.List;
import java.util.Scanner;

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
    private double nota ;
    private int identificadorDoArquivo;
   
        
public static List<Avaliacao> obterListaAvaliacoes() throws FileNotFoundException, IOException {
        
        List<Avaliacao> listAvaliacao = new ArrayList();

        String atributo;
        double aDouble;
        int contador = 0;
        try (Scanner scanner = new Scanner(new FileReader("Avaliacoes.csv")).useDelimiter("\\,|\\n")) {
            while( scanner.hasNext() ){
                Avaliacao a1 = new Avaliacao();
                a1.identificadorDoArquivo = contador;
                a1.disciplina = scanner.next();
                a1.nome = scanner.next();
                atributo = scanner.next();
                aDouble = Double.parseDouble(atributo);
                a1.peso= aDouble;
                a1.media = scanner.next();
                atributo = scanner.next();
                System.out.print("\nLENGTH |"+atributo.length()+"|");
                if(atributo.length()<= 1 ){
                    System.out.print("\n NÃO TEM NOTA");
                }else{
                    aDouble = Double.parseDouble(atributo);
                    a1.nota = aDouble;
                }
                contador++;
                listAvaliacao.add(a1);
            }
        }
        return listAvaliacao;
    }
    

        
    public void atualizar(){
        
    }
        
    public void Salvar(){
    
    }
    
    
    
    
    
    


    //GETs AND SETs
    public void setMedia(String novaMedia){
        this.media = novaMedia;
    }
    public String getMedia(){
        return this.media;
    }
    public void setIdentificadorDoArquivo(int novoIndicador){
        this.identificadorDoArquivo = novoIndicador;
    }
    public int getIdentificadorDoArquivo(){
        return this.identificadorDoArquivo;
    }
    
    public void setDisciplina(String novaDisciplina){
        this.disciplina = novaDisciplina;
    }
    
    public String getDisciplina(){
        return this.disciplina;
    }
    public void setPeso(double novaPeso){
        this.peso = novaPeso;
    }
    
    public double getPeso(){
        return this.peso;
    }
    
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNota(double novaNota){
        this.nota = novaNota;
    }
    
    public double getNota(){
        return this.nota;
    }
}

