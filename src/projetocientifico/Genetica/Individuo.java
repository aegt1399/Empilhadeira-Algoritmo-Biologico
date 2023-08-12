
package projetocientifico.Genetica;

/**
 *
 * @author AEGT
 */
public class Individuo implements Comparable{
    private Cromossomo cromossomo;
    private int aptidao;
    private double taxa_crossover;
    private double taxa_mutacao;
    private int qtde_pontos_crossover;
    
    public Individuo(double taxa_crossover, double taxa_mutacao, int qtde_pontos_crossover){
        this.taxa_crossover = taxa_crossover;
        this.taxa_mutacao = taxa_mutacao;
        this.qtde_pontos_crossover = qtde_pontos_crossover;
    }
    
    public Individuo(Cromossomo cromossomo, double taxa_crossover, double taxa_mutacao, int qtde_pontos_crossover){
        this.cromossomo = cromossomo;
        this.taxa_crossover = taxa_crossover;
        this.taxa_mutacao = taxa_mutacao;
        this.qtde_pontos_crossover = qtde_pontos_crossover;
    }
    
    // nome do método apenas para ironizar
    // pois se nós criassemos algo, nós seriamos o divino desse ser
    public void CriaIndividuoPorPoderDivino(int qtde_genes){
        this.cromossomo = new Cromossomo(qtde_genes);
        this.cromossomo.GeraCromossomoAleatorio();
    }
    
    // retorna um vetor com dois indivíduos filhos a partir da cruza
    // entre o pai1(indivíduo atual) e o pai2(informado no argumento)
    public Individuo[] Cruza(Individuo pai2){
        Individuo filhos[] = new Individuo[2];
        Cromossomo cromossomosFilho[] = this.cromossomo.CruzaGenetica(pai2.cromossomo, this.qtde_pontos_crossover, this.taxa_crossover, this.taxa_mutacao);
        
        filhos[0] = new Individuo(cromossomosFilho[0], this.taxa_crossover, this.taxa_mutacao, this.qtde_pontos_crossover);
        filhos[1] = new Individuo(cromossomosFilho[1], this.taxa_crossover, this.taxa_mutacao, this.qtde_pontos_crossover);
        
        return filhos;
    }
 
    public String getGenotipo(int genes_por_alelo, boolean[][] variacoes, int[] alelos){
        return this.cromossomo.getGenotipo(genes_por_alelo, variacoes, alelos);
    }
    
    public int getAptidao(){
        return this.aptidao;
    }
    
    public void setAptidao(int aptidao){
        this.aptidao = aptidao;
    }

    @Override
    public int compareTo(Object o) {
        Individuo temp = (Individuo)o;
        
        if( this.aptidao > temp.aptidao){
            return -1;
        }else if(temp.aptidao > this.aptidao){
            return 1;
        }else{
            return 0;
        }
        
    }
}
