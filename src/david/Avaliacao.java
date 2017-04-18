package david;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    //private String media;
    private char[] media;
    private double nota ;
    private int identificadorDoArquivo;
   
        
public static List<Avaliacao> obterListaAvaliacoes() throws FileNotFoundException, IOException {
        
        List<Avaliacao> listAvaliacao = new ArrayList();
        String tamanhoString;
        int contador = 0;
        
        try (Scanner scanner = new Scanner(new FileReader("Avaliacoes.csv")).useDelimiter("\\,|\\n")) {
            while( scanner.hasNext() ){
                
                Avaliacao a1 = new Avaliacao();
                a1.identificadorDoArquivo = contador;
                a1.disciplina = scanner.next();
                a1.media = scanner.next().toCharArray();
                a1.nome = scanner.next();
                a1.peso= Double.parseDouble(scanner.next());
                tamanhoString = scanner.next();
                if(tamanhoString.length()<= 1 ){
                }else{
                    a1.nota = Double.parseDouble(tamanhoString);
                }
                contador++;
                listAvaliacao.add(a1);
            }
        }
        return listAvaliacao;
    }
    
    public static double calculaMediaDisciplina(String dis, String med) throws FileNotFoundException{
        
        Scanner scanner = new Scanner(new FileReader("Avaliacoes.csv")).useDelimiter("\\,|\\n");
        
        double nota;
        double p = 0;
        double MX = 0;
        int cont = 0;
        
        while( scanner.hasNext() ) {
            if(dis.equals(scanner.next())){
                
                if(med.equals(scanner.next())){
                    
                    scanner.next();
                    p = Double.parseDouble(scanner.next());
                    nota = Double.parseDouble(scanner.next());
                    MX +=nota*p;
                    cont+=p;
                }
            }else{
                scanner.nextLine();
            }
        }
        return MX/cont;
    }
    
        
    public void atualizar() throws IOException{
        int indice = this.identificadorDoArquivo;
        Path path = Paths.get("Avaliacoes.csv");
        List<String> linhas = Files.readAllLines(path);
        
        
        String novoConteudo = getDisciplina() + ","+getMediaString()+","+getNome() +","+getPeso()+","+ getNota();
        linhas.remove(indice);
        linhas.add(indice, novoConteudo);
        Files.write(path, linhas);

        GerenciadorJanela.obterInstancia().abreJanela(new MinhasAvaliacoes());
    }
        
    public void Salvar() throws IOException{

            FileWriter arquivo = new FileWriter("Avaliacoes.csv",true);
            PrintWriter pw = new PrintWriter(arquivo);

            pw.println(getDisciplina() + "," +getMediaString() +","+getNome() +","+getPeso()+",");
            pw.close();
            arquivo.close();
            
            GerenciadorJanela.obterInstancia().abreJanela(new MinhasAvaliacoes());
    }
    
    
    
    //GETs AND SETs
    public void setMedia(char[] novaMedia){
        this.media = novaMedia;
    }
    public String getMediaString(){
        return String.valueOf(this.media);
    }
    public char[] getMedia(){
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

