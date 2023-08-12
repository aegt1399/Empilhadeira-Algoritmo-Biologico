
package projetocientifico.Genetica;

import java.util.Random;
import projetocientifico.Utilitario.Util;

/**
 *
 * @author AEGT
 */
public class Cromossomo {
    private boolean genes[];
    private Random rand;
    
    public Cromossomo(int qtde_genes){
        this.genes = new boolean[qtde_genes];
        this.rand = new Random();     
    }

    public void GeraCromossomoAleatorio(){                
        // boolean[] temp = {false, true, false, true, false, true, false, false, false, false, false, true, false,true,false,true, false, false, false, false, false, false, false, false, false, false, false, true};
        // this.genes = temp;
        // as linhas a cima são para teste
        
        for (int i = 0; i < this.genes.length; i++) {
            this.genes[i] = rand.nextBoolean();
        }               
    }
    
    public Cromossomo[] CruzaGenetica(Cromossomo cromossomo, int qtde_pontos_crossover, double taxa_crossover, double taxa_mutacao){
        
        Cromossomo filho[];
        
        if(this.rand.nextDouble() <= taxa_crossover){
            filho = Crossover(this, cromossomo, qtde_pontos_crossover);
        }else{
            filho = new Cromossomo[2];
            filho[0] = this.Clone();
            filho[1] = cromossomo.Clone();
        }
        
        filho[0].Mutacao(taxa_mutacao);
        filho[1].Mutacao(taxa_mutacao);
        
        return filho;
    }
    
    private Cromossomo[] Crossover(Cromossomo c1, Cromossomo c2, int qtde_pontos){
        Cromossomo filho[] = new Cromossomo[2];
        filho[0] = new Cromossomo(this.genes.length);
        filho[1] = new Cromossomo(this.genes.length);
        
        int[] pontos = Util.ArrayGenerator(qtde_pontos, 1, this.genes.length-1, true, true);
        
        int index = 0;
        boolean inverte = false;
        for (int i = 0; i < qtde_pontos; i++) {
            
            while(index < pontos[i]){
                
                if(inverte){
                    filho[0].genes[index] = c1.genes[index];
                    filho[1].genes[index] = c2.genes[index];
                }else{
                    filho[0].genes[index] = c2.genes[index];
                    filho[1].genes[index] = c1.genes[index];
                }
                    
                index++;
            }
        
            inverte = !inverte;
        }
        
        return filho;
    }
    
    // realiza mutações no cromossomo atual com base em uma taxa de aleatoriedade
    private void Mutacao(double taxa){        
        for (int index = 0; index < this.genes.length; index++) {
            if(rand.nextDouble() <= taxa){
                this.genes[index] = !this.genes[index];
            }
        }
    }
    
    // retorna um clone do cromossomo atual
    private Cromossomo Clone(){
        Cromossomo clone = new Cromossomo((this.genes.length));
        System.arraycopy(this.genes, 0, clone.genes, 0, this.genes.length);
        return clone;
    }
    
    // a quantidade de  variações precisa se equivalente a quantidade de alelos
    public String getGenotipo(int genes_por_alelo, boolean[][] variacoes, int[] alelos) {
        if(variacoes.length != alelos.length){
            return null;
        }
        
        String genotipo = "";
        
        for (int i = 0; i < this.genes.length; i+=genes_por_alelo) {
            
            for (int j = 0; j < variacoes.length; j++) {
                if(variacoes[j][0] == this.genes[i] && variacoes[j][1] == this.genes[i+1]){
                    genotipo += alelos[j];
                }
            }
        }
        
        return genotipo;
    }
}
