
package projetocientifico.Genetica;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author AEGT
 */
public class Populacao {
    private Individuo individuos[];
    
    private double taxa_crossover;
    private double taxa_mutacao;
    private int qtde_pontos_crossover;
    private int qtde_genes;    
    private int qtde_gense_por_alelo;
    private int alelos[];
    private boolean variacoes[][];
    
    private int geracao;
    
    public Populacao(int qtde_individuos, double taxa_crossover, double taxa_mutacao, int qtde_pontos_crossover, int qtde_genes, int qtde_gense_por_alelo, int[] alelos, boolean[][] variacoes){
        this.individuos = new Individuo[qtde_individuos];
        
        this.taxa_crossover = taxa_crossover;
        this.taxa_mutacao = taxa_mutacao;
        this.qtde_pontos_crossover = qtde_pontos_crossover;
        this.qtde_genes = qtde_genes;
        this.qtde_gense_por_alelo = qtde_gense_por_alelo;
        this.alelos = alelos;
        this.variacoes = variacoes;
        
        this.geracao = 0;
        
    }
    
    public void GeraPopulacaoInicial(){
        
        for (int i = 0; i < this.individuos.length; i++) {
            this.individuos[i] = new Individuo(this.taxa_crossover, this.taxa_mutacao, this.qtde_pontos_crossover);
            this.individuos[i].CriaIndividuoPorPoderDivino(this.qtde_genes);
        }
    }
        
    public String getGenotipoIndividuo(int index){
        return this.individuos[index].getGenotipo(this.qtde_gense_por_alelo, this.variacoes, this.alelos);
    }
    
    public int getAptidaoIndividuo(int index){
        return this.individuos[index].getAptidao();
    }
    
    public void setAptidaoIndividuo(int index, int aptidao){
        this.individuos[index].setAptidao(aptidao);
    }
        
    public int IndividuoDestaque(){
        Individuo destaque = this.individuos[0];
        int index = 0;
        
        for (int i = 1; i < this.individuos.length; i++) {
            if( this.individuos[i].getAptidao() > destaque.getAptidao()){
                destaque = this.individuos[i];
                index = i;                
            }
        }
        
        return index;
    }
    
    
    // seleciona os 25% melhores e os mantém para a proxima geração
    // com os 75% realiza cruzas
    public void GeraNovaGeracao(){
        ArrayList<Individuo> selecionados = this.SelecaoQuaseNatural();
          
        // realiza a cruza
        Individuo novaGeracao[] = new Individuo[this.individuos.length];
        
        int n;
        
        ArrayList<Individuo> naoSelecionados = new ArrayList<Individuo>();
        for (int i = 0; i < this.individuos.length; i++) {
            if(!selecionados.contains(this.individuos[i])){
                naoSelecionados.add(this.individuos[i]);
            }
        }
        
        //adiciona os selecionas à nova geração
        for (n = 0; n < selecionados.size(); n++) {
            novaGeracao[n] = selecionados.get(n);
        }
                
        int index = n;
        for (int i = 0; i < naoSelecionados.size(); i+=2) {
            if(i+1 == naoSelecionados.size()){
                // nestes casos seleciona aleatoriamente um individuo dos não selecionados para cruzar
                Random rand = new Random();
                Individuo[] filhos = naoSelecionados.get(i).Cruza(naoSelecionados.get(rand.nextInt(naoSelecionados.size())));
                novaGeracao[index] = filhos[0];
                // descarta o segundo filho, ele não consseguiu nascer
                //novaGeracao[index+1] = filhos[1];
                
            }else{
                Individuo[] filhos = naoSelecionados.get(i).Cruza(naoSelecionados.get(i+1));
                novaGeracao[index] = filhos[0];
                novaGeracao[index+1] = filhos[1];
            }
           index +=2;
        }
        
        this.individuos = novaGeracao;
        this.geracao++;
    }
    
    // seleciona os 25% melhores individuos
    private ArrayList<Individuo> SelecaoQuaseNatural(){
        Individuo populacaoTeporaria[] = new Individuo[this.individuos.length];
        
        for (int i = 0; i < this.individuos.length; i++) {
            populacaoTeporaria[i] = this.individuos[i];
        }
        
        Arrays.sort(populacaoTeporaria);
               
        ArrayList<Individuo> selecionadosQuaseNaturalmente = new ArrayList<Individuo>();
        
        int n = this.individuos.length / 4;
        
        for (int i = 0; i < n; i++) {
            selecionadosQuaseNaturalmente.add(populacaoTeporaria[i]);
        }
        
        return selecionadosQuaseNaturalmente;
    }
    
    public int getGeracao(){
        return this.geracao;
    }
    
    public int getQtdeIndividuos(){
        return this.individuos.length;
    }
    
}
