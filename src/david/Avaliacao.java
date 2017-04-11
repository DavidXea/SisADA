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
    private String peso;
    private char[] media = new char[2];
    private String nota;
    private int identificadorDoArquivo;

    
    public void Salvar(){}
    
    public void atualizar(){}
    
    private static Avaliacao li = new  Avaliacao();
    
    
    public static List<Avaliacao> obterListaAvaliacoes() throws FileNotFoundException, IOException{
        List<Avaliacao>  listaAvaliacao = new ArrayList<>();
//        char ch;
//        String linha = "";
//        String palavra = null;
//        FileReader arquivo =  new FileReader("Avaliacoes.csv");
//        BufferedReader lerArquivo = new BufferedReader(arquivo);
//        
//       linha = lerArquivo.readLine();
//       
//        while(linha!= null){
//            for(int i = 0; i<5; i++){
//                while((ch = (char)lerArquivo.read())!= ';'){
//                palavra += ch;
//                }
//             switch (i)
//             {
//                 case 1:
//                     li.nome = palavra;
//                     break;
//                 case 2:
//                     li.disciplina = palavra;
//                     break;
//                 case 3:
//                     li.media[0] = palavra.charAt(0);
//                     li.media[1] = palavra.charAt(1);
//                     break;
//                 case 4:
//                     li.peso = (palavra);
//                     break;
//                 case 5:
//                     li.nota = (palavra);
//                     break;
//             }
//            }
//            listaAvaliacao.add(li);
//        }
//        return  listaAvaliacao;
    }
    
    public double calculaMediaDaDisciplina(String m, char n){
        return 0;
    }
    
    
    
}

