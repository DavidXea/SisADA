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
    private double nota;
    private int identificadorDoArquivo;
    
public static boolean NullOuVazio(String s) {
            return (s == null || s.trim().equals(""));
        }

        
public static List<Avaliacao> obterListaAvaliacoes() throws FileNotFoundException, IOException {
        List<Avaliacao> listAvaliacao = new ArrayList();
    

        String atributo = "";
        double aDouble;
        
        FileReader arquivo =  new FileReader("Avaliacoes.csv");
        BufferedReader lerString = new BufferedReader(arquivo);

        String linha  = lerString.readLine();
        int intPercorreString = 0;
        char divisorDeCelula = ';';

        while(NullOuVazio( linha ) == false ){
            System.out.print("\nPRINTE DA LINHA|" + linha+ "|");
            Avaliacao a1 = new Avaliacao();
            for(int i = 1; i<6; i++){
                System.out.print("\nNNNNOOOOOTAAAAAAA"+linha.charAt(intPercorreString)+"\n");
                while( linha.charAt(intPercorreString) != divisorDeCelula){
                    atributo += linha.charAt(intPercorreString);
                    System.out.print("\n"+atributo);
                    intPercorreString++;
                }

                switch (i)
                {
                    case 1:
                        a1.disciplina = atributo;
                        break;
                        
                    case 2:
                        a1.nome = atributo;
                        break;
                        
                   case 3:
                        aDouble = Double.parseDouble(atributo); 
                        a1.peso= aDouble;
                        break;
                        
                    case 4:
                        a1.media = atributo;

                        //li.media[0] = palavra.charAt(0);
                        //li.media[1] = palavra.charAt(1);
                        break;
                    case 5:
                        System.out.print("NOTAAAAAAAAAA");
//                        if("".equals(atributo)){
//                            break;
//                        }else{
//                            aDouble = Double.parseDouble(atributo);
//                            a1.setNota(aDouble);
//                        }

                }
                intPercorreString++;
                atributo = "";
            }
            intPercorreString=0;
            linha = lerString.readLine();
            listAvaliacao.add(a1);
        }
        lerString.close();
        arquivo.close();
        return listAvaliacao;
    }
    
    public double calculaMediaDaDisciplina(String m, char n){
        return 0;
    }   
        
    public void atualizar(){
        
    
    
    }
        
        
    public void Salvar(){
    
    }
    

    
    
    public void setDisciplina(String novaDisciplina){
        this.disciplina = novaDisciplina;
    }
    
    public String getDisciplina(){
        return this.disciplina;
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

