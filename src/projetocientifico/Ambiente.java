
package projetocientifico;

/**
 *
 * @author angel
 */
public class Ambiente {
    private int[][][] mapa;
    private int linhas;
    private int colunas;
        
    public Ambiente(int linhas, int colunas){
        // tridimensional pois:
        //      é necessário projetar as 4 paredes
        //      o teto e o solo são desconsiderados.
        this.mapa = new int[linhas][colunas][4];
        this.linhas = linhas;
        this.colunas = colunas;
        
        this.DefinePrecipicios();
    }
    
    private void DefinePrecipicios(){
        // define precipicio NORTE e SUL;
        for (int i = 0; i < this.colunas; i++) {
            this.mapa[0][i][0] = -1;
            this.mapa[this.linhas-1][i][2] = -1;
        }
        
        // define precipicio LESTE e OESTE;
        for (int i = 0; i < this.linhas; i++) {
            this.mapa[i][this.colunas-1][1] = -1;
            this.mapa[i][0][3] = -1;
        }        
    }
    
    // o obtáculo é considerado intransponível
    public void DefineObstaculo(int linha, int coluna, int lado){        
        this.mapa[linha][coluna][lado] = 1;        
    }
    
    // retornos:
    // -1 --> precipicio
    //  0 --> caminho sem ostaculo, ou seja, é válido
    //  1 --> caminho com obstaculo, neste caso é considerado uma parede como o obstaculo
    public int CaminhoValido(int linha, int coluna, int lado){        
        return this.mapa[linha][coluna][lado];
    }
    
}
