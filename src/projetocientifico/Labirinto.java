
package projetocientifico;

import projetocientifico.Genetica.Populacao;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projetocientifico.Testes.RotinaPrincipal;
import projetocientifico.Utilitario.Util;


/**
 *
 * @author AEGT
 */
public class Labirinto extends javax.swing.JFrame {

    private boolean stop;
    private Ambiente ambiente;
    private Populacao populacao;
    
    private int aptidaoMaxima;
    
    private int li;
    private int ci;
    
    private int lf;
    private int cf;

    private double taxa_crossover;
    private double taxa_mutacao;
    private int qtde_pontos_crossover;
    private int qtde_individuos;
    
    private int punicao_suicidio;
    private int punicao_batida_parede;
    private int punicao_distancia;
    
    private JPanel[][] matrizVisual;
    
    /**
     * Creates new form Labirinto
     */
    public Labirinto() {
        initComponents();
        
        // utilizado para executar testes, para utilizar basta descomentar e criar
        // uma rotina na classe Testes.RotinaPrincipal e chamar o mesmo
        // no método construtor
        RotinaPrincipal teste = new RotinaPrincipal();
               
        this.InicializaMatrizVisual();
        
        this.li = 7;
        this.ci = 0;
        
        this.lf = 0;
        this.cf = 7;
        
        this.aptidaoMaxima = 100;
        
        this.BTParar.setVisible(false);
        
        this.setParametrosIniciais();
    }

    private void setParametrosIniciais(){
        this.setLeste(7, 0);
        
        this.RBMelhoDaGeracao.setSelected(true);
     
        this.Slider_Individuos.setValue(500);
        this.Slider_TaxaCrossover.setValue(600);
        this.Slider_TaxaMutacao.setValue(10);
        this.Slider_PontosCrossover.setValue(4);
        
        this.Slider_PunicaoSuicidio.setValue(50);    
        this.Slider_PunicaoBatidaParede.setValue(20);  
        this.Slider_PunicaoDistancia.setValue(10);


        
    }
    
    private void InicializaMatrizVisual(){
        this.matrizVisual = new JPanel[8][8];
                
        this.matrizVisual[0][0] = this.jp_0_0;
        this.matrizVisual[0][1] = this.jp_0_1;
        this.matrizVisual[0][2] = this.jp_0_2;
        this.matrizVisual[0][3] = this.jp_0_3;
        this.matrizVisual[0][4] = this.jp_0_4;
        this.matrizVisual[0][5] = this.jp_0_5;
        this.matrizVisual[0][6] = this.jp_0_6;
        this.matrizVisual[0][7] = this.jp_0_7;
        
        this.matrizVisual[1][0] = this.jp_1_0;
        this.matrizVisual[1][1] = this.jp_1_1;
        this.matrizVisual[1][2] = this.jp_1_2;
        this.matrizVisual[1][3] = this.jp_1_3;
        this.matrizVisual[1][4] = this.jp_1_4;
        this.matrizVisual[1][5] = this.jp_1_5;
        this.matrizVisual[1][6] = this.jp_1_6;
        this.matrizVisual[1][7] = this.jp_1_7;
        
        this.matrizVisual[2][0] = this.jp_2_0;
        this.matrizVisual[2][1] = this.jp_2_1;
        this.matrizVisual[2][2] = this.jp_2_2;
        this.matrizVisual[2][3] = this.jp_2_3;
        this.matrizVisual[2][4] = this.jp_2_4;
        this.matrizVisual[2][5] = this.jp_2_5;
        this.matrizVisual[2][6] = this.jp_2_6;
        this.matrizVisual[2][7] = this.jp_2_7;
        
        this.matrizVisual[3][0] = this.jp_3_0;
        this.matrizVisual[3][1] = this.jp_3_1;
        this.matrizVisual[3][2] = this.jp_3_2;
        this.matrizVisual[3][3] = this.jp_3_3;
        this.matrizVisual[3][4] = this.jp_3_4;
        this.matrizVisual[3][5] = this.jp_3_5;
        this.matrizVisual[3][6] = this.jp_3_6;
        this.matrizVisual[3][7] = this.jp_3_7;
        
        this.matrizVisual[4][0] = this.jp_4_0;
        this.matrizVisual[4][1] = this.jp_4_1;
        this.matrizVisual[4][2] = this.jp_4_2;
        this.matrizVisual[4][3] = this.jp_4_3;
        this.matrizVisual[4][4] = this.jp_4_4;
        this.matrizVisual[4][5] = this.jp_4_5;
        this.matrizVisual[4][6] = this.jp_4_6;
        this.matrizVisual[4][7] = this.jp_4_7;
        
        this.matrizVisual[5][0] = this.jp_5_0;
        this.matrizVisual[5][1] = this.jp_5_1;
        this.matrizVisual[5][2] = this.jp_5_2;
        this.matrizVisual[5][3] = this.jp_5_3;
        this.matrizVisual[5][4] = this.jp_5_4;
        this.matrizVisual[5][5] = this.jp_5_5;
        this.matrizVisual[5][6] = this.jp_5_6;
        this.matrizVisual[5][7] = this.jp_5_7;
        
        this.matrizVisual[6][0] = this.jp_6_0;
        this.matrizVisual[6][1] = this.jp_6_1;
        this.matrizVisual[6][2] = this.jp_6_2;
        this.matrizVisual[6][3] = this.jp_6_3;
        this.matrizVisual[6][4] = this.jp_6_4;
        this.matrizVisual[6][5] = this.jp_6_5;
        this.matrizVisual[6][6] = this.jp_6_6;
        this.matrizVisual[6][7] = this.jp_6_7;
        
        this.matrizVisual[7][0] = this.jp_7_0;
        this.matrizVisual[7][1] = this.jp_7_1;
        this.matrizVisual[7][2] = this.jp_7_2;
        this.matrizVisual[7][3] = this.jp_7_3;
        this.matrizVisual[7][4] = this.jp_7_4;
        this.matrizVisual[7][5] = this.jp_7_5;
        this.matrizVisual[7][6] = this.jp_7_6;
        this.matrizVisual[7][7] = this.jp_7_7;
        
        java.awt.BorderLayout BL;
        JLabel JL;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BL = new java.awt.BorderLayout(1,1); 
                JL = new JLabel();
                //JL.setBackground(new Color(255,255,255,1));
                
                this.matrizVisual[i][j].setLayout(BL);  
                this.matrizVisual[i][j].setOpaque(false);
                //this.matrizVisual[i][j].setBackground(new Color(255,255,255,1));
                this.matrizVisual[i][j].setPreferredSize(new Dimension(50, 50));
                                        
                this.matrizVisual[i][j].add(JL);
            }                    
        }
        
        /*this.jp_0_7.setBackground(new Color(51, 255, 51, 95));  
        this.jp_0_7.setOpaque(true);
        this.jp_7_0.setBackground(new Color(255,255,51, 95));
        this.jp_7_0.setOpaque(true);*/
    }
    
    private void CriaAmbiente(){
        this.ambiente = new Ambiente(8,8);
                
        this.ambiente.DefineObstaculo(0, 1, 1);
        this.ambiente.DefineObstaculo(0, 1, 2);        
        this.ambiente.DefineObstaculo(0, 2, 3);        
        this.ambiente.DefineObstaculo(0, 4, 1);
        this.ambiente.DefineObstaculo(0, 5, 3);
        
        this.ambiente.DefineObstaculo(1, 1, 0);
        this.ambiente.DefineObstaculo(1, 2, 1);
        this.ambiente.DefineObstaculo(1, 2, 2);
        this.ambiente.DefineObstaculo(1, 4, 2);
        this.ambiente.DefineObstaculo(1, 5, 1);
        this.ambiente.DefineObstaculo(1, 6, 3);
        
        this.ambiente.DefineObstaculo(2, 1, 2);
        this.ambiente.DefineObstaculo(2, 2, 0);
        this.ambiente.DefineObstaculo(2, 3, 1);
        this.ambiente.DefineObstaculo(2, 4, 0);
        this.ambiente.DefineObstaculo(2, 4, 3);
        this.ambiente.DefineObstaculo(2, 6, 1);
        this.ambiente.DefineObstaculo(2, 7, 2);
        this.ambiente.DefineObstaculo(2, 7, 3);
        
        this.ambiente.DefineObstaculo(3, 0, 1);
        this.ambiente.DefineObstaculo(3, 1, 0);
        this.ambiente.DefineObstaculo(3, 1, 1);
        this.ambiente.DefineObstaculo(3, 1, 3);
        this.ambiente.DefineObstaculo(3, 2, 1);
        this.ambiente.DefineObstaculo(3, 2, 3);
        this.ambiente.DefineObstaculo(3, 3, 3);
        this.ambiente.DefineObstaculo(3, 4, 2);
        this.ambiente.DefineObstaculo(3, 7, 0);
        
        this.ambiente.DefineObstaculo(4, 1, 1);
        this.ambiente.DefineObstaculo(4, 2, 1);
        this.ambiente.DefineObstaculo(4, 2, 3);
        this.ambiente.DefineObstaculo(4, 3, 2);
        this.ambiente.DefineObstaculo(4, 3, 3);
        this.ambiente.DefineObstaculo(4, 4, 0);
        this.ambiente.DefineObstaculo(4, 5, 1);
        this.ambiente.DefineObstaculo(4, 5, 2);
        this.ambiente.DefineObstaculo(4, 6, 1);
        this.ambiente.DefineObstaculo(4, 6, 3);
        this.ambiente.DefineObstaculo(4, 7, 3);
        
        this.ambiente.DefineObstaculo(5, 2, 2);
        this.ambiente.DefineObstaculo(5, 3, 0);
        this.ambiente.DefineObstaculo(5, 5, 0);
        this.ambiente.DefineObstaculo(5, 6, 2);
        
        this.ambiente.DefineObstaculo(6, 0, 1);
        this.ambiente.DefineObstaculo(6, 1, 3);
        this.ambiente.DefineObstaculo(6, 2, 0);
        this.ambiente.DefineObstaculo(6, 2, 1);
        this.ambiente.DefineObstaculo(6, 3, 3);
        this.ambiente.DefineObstaculo(6, 4, 1);
        this.ambiente.DefineObstaculo(6, 4, 2);
        this.ambiente.DefineObstaculo(6, 5, 1);
        this.ambiente.DefineObstaculo(6, 5, 3);
        this.ambiente.DefineObstaculo(6, 6, 0);
        this.ambiente.DefineObstaculo(6, 6, 3);
        
        this.ambiente.DefineObstaculo(7, 4, 0);
        this.ambiente.DefineObstaculo(7, 6, 1);
        this.ambiente.DefineObstaculo(7, 7, 3);
        
    }
    
    private void CriaPopulacao( int qtde_genes, int qtde_genes_por_alelo){
        int alelos[] = {0,
                        1,
                        2,
                        3};

        boolean variacoes[][] = {{false, false},
                                 {false, true},
                                 {true, false},
                                 {true, true}};
        
        this.populacao = new Populacao( this.qtde_individuos, this.taxa_crossover, this.taxa_mutacao, this.qtde_pontos_crossover, qtde_genes, qtde_genes_por_alelo, alelos, variacoes);
        
        this.populacao.GeraPopulacaoInicial();
    }
    
    private void Executar(){
        this.stop = false;
        
        this.BTParar.setVisible(true);        
        this.BTExecutar.setVisible(false);
        
        this.Slider_Individuos.setEnabled(false);
        this.Slider_TaxaCrossover.setEnabled(false);
        this.Slider_TaxaMutacao.setEnabled(false);
        this.Slider_PontosCrossover.setEnabled(false); 
        this.Slider_PunicaoSuicidio.setEnabled(false);        
        this.Slider_PunicaoBatidaParede.setEnabled(false);        
        this.Slider_PunicaoDistancia.setEnabled(false);        
        
        this.BTResetParametrosIniciais.setEnabled(false);
        this.RBTodos.setEnabled(false);
        this.RBMelhoDaGeracao.setEnabled(false);
        this.RBMelhor.setEnabled(false);
        
        ExecutaAlgoritmoGenetico();
                
        this.Slider_PunicaoSuicidio.setEnabled(true);        
        this.Slider_PunicaoBatidaParede.setEnabled(true);        
        this.Slider_PunicaoDistancia.setEnabled(true); 
        this.Slider_Individuos.setEnabled(true);
        this.Slider_TaxaCrossover.setEnabled(true);
        this.Slider_TaxaMutacao.setEnabled(true);
        this.Slider_PontosCrossover.setEnabled(true);        
        this.BTResetParametrosIniciais.setEnabled(true);
        this.RBTodos.setEnabled(true);
        this.RBMelhoDaGeracao.setEnabled(true);        
        this.RBMelhor.setEnabled(true);
        
        this.BTParar.setVisible(false);        
        this.BTExecutar.setVisible(true);
        
    }
    
    private void ExecutaAlgoritmoGenetico(){
        this.setLeste(7, 0);
        
        this.CriaAmbiente();
        
        this.CriaPopulacao(28, 2);        
        
        this.AvaliaIndividuosDaPopulacao();
        
        int indexDestaque = this.populacao.IndividuoDestaque();
        this.Atualiza_View(indexDestaque);
        
        if(this.RBMelhoDaGeracao.isSelected()){
            ColocaIndividuoNoLabirinto(indexDestaque);
        }
        
        while( this.populacao.getAptidaoIndividuo(indexDestaque) < aptidaoMaxima){
            if(this.stop){
                return;
            }
            this.populacao.GeraNovaGeracao();
                        
            this.AvaliaIndividuosDaPopulacao();
            
            indexDestaque = this.populacao.IndividuoDestaque();
            this.Atualiza_View(indexDestaque);
            
            if(this.RBMelhoDaGeracao.isSelected()){
                ColocaIndividuoNoLabirinto(indexDestaque);
            }
            
        }
        
        if(this.RBMelhor.isSelected()){
            ColocaIndividuoNoLabirinto(indexDestaque);
        }
        
    }
    
    private void AvaliaIndividuosDaPopulacao(){
        
        for (int i = 0; i < this.populacao.getQtdeIndividuos(); i++) {
            AvaliaIndividuo(i);
            if(this.RBTodos.isSelected()){
                this.ColocaIndividuoNoLabirinto(i);
            }
        }
        
    }
    
    private void AvaliaIndividuo(int index){
        int linha_atual = this.li;
        int coluna_atual = this.ci;
        int aptidao_temporaria = this.aptidaoMaxima; // garante a aptidão máxima quem não perder pontos
                                                     // ou seja, chegar o mais per possível do obetivo
                                                     // não bater nos obstaculos e principalmente
                                                     // não ter ataque de panico e se suicidar no precipicio
        
        String genotipo = this.populacao.getGenotipoIndividuo(index);
        
        boolean invividuoCometeuSuicidio;
        int temp;
        for (int i = 0; i < genotipo.length(); i++) {
            invividuoCometeuSuicidio = false;
            temp = this.ambiente.CaminhoValido(linha_atual, coluna_atual, Character.getNumericValue(genotipo.charAt(i))); 
            
            if(temp == 0){//caminho possível
                
                switch (genotipo.charAt(i)) {                        
                    case '0': //norte
                        linha_atual--;
                        break;                        
                    case '1': //leste
                        coluna_atual++;
                        break;                        
                    case '2': //sul
                        linha_atual++;
                        break;                        
                    default: //oeste
                        coluna_atual--;
                        break;
                }
                
            }else if(temp == -1){ // caminho suicida (precipicio)
                // recebe uma punição alta por ter se suicidado
                // porém, se estiver se suicidade perto da chegada
                // não perde tantos pontos;
                // assim quem prmanecer no inicio e bater em várias paredes
                // possuirá uma aptidão menor do que aquele que se suicidou
                // faltando apenas uma ação correta
                aptidao_temporaria -= this.punicao_suicidio;
                invividuoCometeuSuicidio = true;
                
            }else{ // obstaculo
                // não conssegue sair do lugar, e ganha uma punição
                // morre de fome se ficar muito tempo batendo nos obstaculos
                aptidao_temporaria -= this.punicao_batida_parede;
            }
            
            if(invividuoCometeuSuicidio){// quando isso acontece, para de analizar o caminho
                break;
            }
        }
        
        // calcula distancia entre a ultima posicao e a posicao final
        // quanto mais perto da posicao final, menos pontos de aptidao
        // o individuo perde
        aptidao_temporaria -= (Util.Distancia(linha_atual, coluna_atual, this.lf, this.cf) * this.punicao_distancia);
            
            
        this.populacao.setAptidaoIndividuo(index, aptidao_temporaria);
                
    }
    
    private void setNorte(int l, int c){        
        ((JLabel)this.matrizVisual[l][c].getComponent(0)).setIcon(getImageIcon("\\Imagens\\empilhadeira_norte.png"));
        ((JLabel)this.matrizVisual[l][c].getComponent(0)).setVisible(true);
    }
    
    private void setLeste(int l, int c){
        ((JLabel)this.matrizVisual[l][c].getComponent(0)).setIcon(getImageIcon("\\Imagens\\empilhadeira_leste.png")); 
  
    }
    
    private void setSul(int l, int c){
        ((JLabel)this.matrizVisual[l][c].getComponent(0)).setIcon(getImageIcon("\\Imagens\\empilhadeira_sul.png"));
      
    }
    
    private void setOeste(int l, int c){       
        ((JLabel)this.matrizVisual[l][c].getComponent(0)).setIcon(getImageIcon("\\Imagens\\empilhadeira_oeste.png"));
       
    }
    
    private void SaiDe(int l, int c){
        ((JLabel)this.matrizVisual[l][c].getComponent(0)).setIcon(null);
    }
    
    private void Atualiza_View(int indexIndividuo){
        this.LBGeracao.setText(this.populacao.getGeracao() + "");        
        this.LBAptidao.setText("" + this.populacao.getAptidaoIndividuo(indexIndividuo));                 
    }
    
    // é utilizada para mostrar o individuo executando na interface de usuario
    private void ColocaIndividuoNoLabirinto(int index){
        this.Atualiza_View(index);
        
        try{
            
            int linha_atual = this.li;
            int coluna_atual = this.ci;

            this.setLeste(linha_atual, coluna_atual);        
            Thread.sleep(1500);

            String genotipo = this.populacao.getGenotipoIndividuo(index);

            boolean invividuoCometeuSuicidio;
            int temp;
            for (int i = 0; i < genotipo.length(); i++) {
                if(this.stop){
                    this.SaiDe(linha_atual, coluna_atual);
                    return;
                }
                invividuoCometeuSuicidio = false;
                temp = this.ambiente.CaminhoValido(linha_atual, coluna_atual, Character.getNumericValue(genotipo.charAt(i))); 

                switch (genotipo.charAt(i)) {                        
                        case '0': //norte
                            this.setNorte(linha_atual, coluna_atual);
                            break;                        
                        case '1': //leste
                            this.setLeste(linha_atual, coluna_atual);
                            break;                        
                        case '2': //sul
                            this.setSul(linha_atual, coluna_atual);
                            break;                        
                        default: //oeste
                            this.setOeste(linha_atual, coluna_atual);
                            break;
                }
                
                Thread.sleep(300);

                if(temp == 0){//caminho possível
                    this.SaiDe(linha_atual, coluna_atual);

                    switch (genotipo.charAt(i)) {                        
                        case '0': //norte
                            linha_atual--;
                            this.setNorte(linha_atual, coluna_atual);
                            break;                        
                        case '1': //leste
                            coluna_atual++;
                            this.setLeste(linha_atual, coluna_atual);
                            break;                        
                        case '2': //sul
                            linha_atual++;
                            this.setSul(linha_atual, coluna_atual);
                            break;                        
                        default: //oeste
                            coluna_atual--;
                            this.setOeste(linha_atual, coluna_atual);
                            break;
                    }

                }else if(temp == -1){ // caminho suicida (precipicio)
                    invividuoCometeuSuicidio = true;
                }

                if(invividuoCometeuSuicidio){// quando isso acontece, para de analizar o caminho
                    break;
                }
                
                Thread.sleep(300);
            }
        
            Thread.sleep(1500);
            this.SaiDe(linha_atual, coluna_atual);
            Thread.sleep(500);
            
        }catch(Exception e){
            
        }
                        
    }
    
    private ImageIcon getImageIcon(String endereco) {
        return new ImageIcon(getClass().getResource(endereco));        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JPParametros = new javax.swing.JPanel();
        BTExecutar = new javax.swing.JButton();
        RBTodos = new javax.swing.JRadioButton();
        RBMelhoDaGeracao = new javax.swing.JRadioButton();
        RBMelhor = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        LBGeracao = new javax.swing.JLabel();
        BTParar = new javax.swing.JButton();
        LBAptidao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BTResetParametrosIniciais = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LBIndividuos = new javax.swing.JLabel();
        Slider_Individuos = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        LBTaxaCrossover = new javax.swing.JLabel();
        Slider_TaxaCrossover = new javax.swing.JSlider();
        Slider_TaxaMutacao = new javax.swing.JSlider();
        LBTaxaMutacao = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Slider_PontosCrossover = new javax.swing.JSlider();
        LBPontoCrossover = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LBPunicaoSuicidio = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Slider_PunicaoSuicidio = new javax.swing.JSlider();
        LBPunicaoBatidaParede = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Slider_PunicaoBatidaParede = new javax.swing.JSlider();
        LBPunicaoDistancia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Slider_PunicaoDistancia = new javax.swing.JSlider();
        JPForaDoMapa = new projetocientifico.PainelFundo();
        Fundo = new projetocientifico.PainelFundo();
        jp_0_0 = new javax.swing.JPanel();
        jp_0_1 = new javax.swing.JPanel();
        parede1 = new javax.swing.JPanel();
        parede3 = new projetocientifico.PainelFundo();
        jp_0_2 = new javax.swing.JPanel();
        jp_0_3 = new javax.swing.JPanel();
        jp_0_4 = new javax.swing.JPanel();
        parede2 = new projetocientifico.PainelFundo();
        jp_0_5 = new javax.swing.JPanel();
        jp_0_7 = new projetocientifico.PainelFundo();
        jp_0_6 = new javax.swing.JPanel();
        jp_1_0 = new javax.swing.JPanel();
        jp_1_1 = new javax.swing.JPanel();
        jp_1_2 = new javax.swing.JPanel();
        parede6 = new javax.swing.JPanel();
        parede4 = new projetocientifico.PainelFundo();
        jp_1_3 = new javax.swing.JPanel();
        jp_1_4 = new javax.swing.JPanel();
        parede7 = new projetocientifico.PainelFundo();
        jp_1_5 = new javax.swing.JPanel();
        parede5 = new projetocientifico.PainelFundo();
        jp_1_6 = new javax.swing.JPanel();
        jp_1_7 = new javax.swing.JPanel();
        jp_2_0 = new javax.swing.JPanel();
        parede10 = new projetocientifico.PainelFundo();
        jp_2_1 = new javax.swing.JPanel();
        jp_2_2 = new javax.swing.JPanel();
        jp_2_3 = new javax.swing.JPanel();
        parede8 = new projetocientifico.PainelFundo();
        jp_2_4 = new javax.swing.JPanel();
        jp_2_5 = new javax.swing.JPanel();
        jp_2_6 = new javax.swing.JPanel();
        parede9 = new projetocientifico.PainelFundo();
        jp_3_6 = new javax.swing.JPanel();
        jp_3_0 = new javax.swing.JPanel();
        parede12 = new projetocientifico.PainelFundo();
        jp_3_1 = new javax.swing.JPanel();
        parede13 = new projetocientifico.PainelFundo();
        jp_3_2 = new javax.swing.JPanel();
        parede14 = new javax.swing.JPanel();
        jp_3_3 = new javax.swing.JPanel();
        jp_3_4 = new javax.swing.JPanel();
        parede15 = new javax.swing.JPanel();
        jp_3_5 = new javax.swing.JPanel();
        jp_4_0 = new javax.swing.JPanel();
        jp_5_0 = new javax.swing.JPanel();
        jp_6_0 = new javax.swing.JPanel();
        parede24 = new projetocientifico.PainelFundo();
        jp_7_0 = new projetocientifico.PainelFundo();
        jp_4_1 = new javax.swing.JPanel();
        parede16 = new projetocientifico.PainelFundo();
        jp_5_1 = new javax.swing.JPanel();
        jp_4_2 = new javax.swing.JPanel();
        parede17 = new projetocientifico.PainelFundo();
        jp_4_3 = new javax.swing.JPanel();
        parede18 = new projetocientifico.PainelFundo();
        jp_6_1 = new javax.swing.JPanel();
        jp_5_2 = new javax.swing.JPanel();
        parede22 = new projetocientifico.PainelFundo();
        jp_4_4 = new javax.swing.JPanel();
        jp_6_2 = new javax.swing.JPanel();
        parede25 = new javax.swing.JPanel();
        jp_5_3 = new javax.swing.JPanel();
        jp_6_3 = new javax.swing.JPanel();
        jp_5_4 = new javax.swing.JPanel();
        jp_6_4 = new javax.swing.JPanel();
        parede27 = new javax.swing.JPanel();
        parede26 = new projetocientifico.PainelFundo();
        jp_4_5 = new javax.swing.JPanel();
        parede20 = new javax.swing.JPanel();
        parede19 = new projetocientifico.PainelFundo();
        jp_5_5 = new javax.swing.JPanel();
        jp_6_5 = new javax.swing.JPanel();
        parede28 = new projetocientifico.PainelFundo();
        parede21 = new projetocientifico.PainelFundo();
        jp_4_6 = new javax.swing.JPanel();
        parede11 = new projetocientifico.PainelFundo();
        jp_2_7 = new javax.swing.JPanel();
        jp_3_7 = new javax.swing.JPanel();
        jp_4_7 = new javax.swing.JPanel();
        parede23 = new javax.swing.JPanel();
        jp_5_6 = new javax.swing.JPanel();
        jp_6_6 = new javax.swing.JPanel();
        jp_7_6 = new javax.swing.JPanel();
        parede29 = new projetocientifico.PainelFundo();
        jp_7_5 = new javax.swing.JPanel();
        jp_7_4 = new javax.swing.JPanel();
        jp_5_7 = new javax.swing.JPanel();
        jp_6_7 = new javax.swing.JPanel();
        jp_7_7 = new javax.swing.JPanel();
        jp_7_1 = new javax.swing.JPanel();
        jp_7_2 = new javax.swing.JPanel();
        jp_7_3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        JPParametros.setBackground(new java.awt.Color(255, 255, 255));

        BTExecutar.setBackground(new java.awt.Color(0, 255, 0));
        BTExecutar.setText("Executar");
        BTExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExecutarActionPerformed(evt);
            }
        });

        buttonGroup1.add(RBTodos);
        RBTodos.setText("Ver Todos os Individuos");

        buttonGroup1.add(RBMelhoDaGeracao);
        RBMelhoDaGeracao.setText("Ver o Melhor da Geração");

        buttonGroup1.add(RBMelhor);
        RBMelhor.setText("Ver o Melhor");

        jLabel1.setText("Geração:");

        LBGeracao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LBGeracao.setForeground(new java.awt.Color(0, 204, 0));
        LBGeracao.setText("0");

        BTParar.setBackground(new java.awt.Color(255, 0, 0));
        BTParar.setText("Parar");
        BTParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTPararActionPerformed(evt);
            }
        });

        LBAptidao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LBAptidao.setForeground(new java.awt.Color(0, 204, 0));
        LBAptidao.setText("0");

        jLabel2.setText("Aptidão:");

        BTResetParametrosIniciais.setBackground(new java.awt.Color(0, 204, 204));
        BTResetParametrosIniciais.setText("Resetar Parametros");
        BTResetParametrosIniciais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTResetParametrosIniciaisActionPerformed(evt);
            }
        });

        jLabel3.setText("Individuos:");

        LBIndividuos.setText("10");

        Slider_Individuos.setMaximum(10000);
        Slider_Individuos.setMinimum(1);
        Slider_Individuos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_IndividuosStateChanged(evt);
            }
        });

        jLabel4.setText("Taxa Crossover:");

        LBTaxaCrossover.setText("0.6");

        Slider_TaxaCrossover.setMaximum(1000);
        Slider_TaxaCrossover.setMinimum(1);
        Slider_TaxaCrossover.setToolTipText("");
        Slider_TaxaCrossover.setValue(-1);
        Slider_TaxaCrossover.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_TaxaCrossoverStateChanged(evt);
            }
        });

        Slider_TaxaMutacao.setMaximum(1000);
        Slider_TaxaMutacao.setMinimum(1);
        Slider_TaxaMutacao.setValue(-1);
        Slider_TaxaMutacao.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_TaxaMutacaoStateChanged(evt);
            }
        });

        LBTaxaMutacao.setText("0.01");

        jLabel5.setText("Taxa Mutacao:");

        Slider_PontosCrossover.setMaximum(10);
        Slider_PontosCrossover.setMinimum(1);
        Slider_PontosCrossover.setValue(-1);
        Slider_PontosCrossover.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_PontosCrossoverStateChanged(evt);
            }
        });

        LBPontoCrossover.setText("4");

        jLabel6.setText("Ponto de Crossover:");

        LBPunicaoSuicidio.setText("50");

        jLabel7.setText("Punição Saída Mapa:");

        Slider_PunicaoSuicidio.setValue(-1);
        Slider_PunicaoSuicidio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_PunicaoSuicidioStateChanged(evt);
            }
        });

        LBPunicaoBatidaParede.setText("10");

        jLabel8.setText("Punição Batida Parede:");

        Slider_PunicaoBatidaParede.setValue(-1);
        Slider_PunicaoBatidaParede.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_PunicaoBatidaParedeStateChanged(evt);
            }
        });

        LBPunicaoDistancia.setText("5");

        jLabel9.setText("Punição Distância:");

        Slider_PunicaoDistancia.setValue(-1);
        Slider_PunicaoDistancia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Slider_PunicaoDistanciaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout JPParametrosLayout = new javax.swing.GroupLayout(JPParametros);
        JPParametros.setLayout(JPParametrosLayout);
        JPParametrosLayout.setHorizontalGroup(
            JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTExecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBGeracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(RBTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RBMelhoDaGeracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RBMelhor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTParar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBAptidao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BTResetParametrosIniciais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBIndividuos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBTaxaCrossover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBPontoCrossover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBTaxaMutacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBPunicaoSuicidio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBPunicaoBatidaParede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBPunicaoDistancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPParametrosLayout.createSequentialGroup()
                        .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Slider_Individuos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slider_TaxaCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slider_PontosCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slider_TaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slider_PunicaoSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slider_PunicaoBatidaParede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slider_PunicaoDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JPParametrosLayout.setVerticalGroup(
            JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPParametrosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(BTResetParametrosIniciais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RBTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RBMelhoDaGeracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RBMelhor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LBIndividuos))
                .addGap(0, 0, 0)
                .addComponent(Slider_Individuos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LBTaxaCrossover))
                .addGap(0, 0, 0)
                .addComponent(Slider_TaxaCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LBPontoCrossover))
                .addGap(0, 0, 0)
                .addComponent(Slider_PontosCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LBTaxaMutacao))
                .addGap(0, 0, 0)
                .addComponent(Slider_TaxaMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(LBPunicaoSuicidio))
                .addGap(0, 0, 0)
                .addComponent(Slider_PunicaoSuicidio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LBPunicaoBatidaParede))
                .addGap(0, 0, 0)
                .addComponent(Slider_PunicaoBatidaParede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(LBPunicaoDistancia))
                .addGap(0, 0, 0)
                .addComponent(Slider_PunicaoDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LBGeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LBAptidao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTParar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTExecutar)
                .addContainerGap())
        );

        JPForaDoMapa.setBackground(new java.awt.Color(255, 102, 102));
        JPForaDoMapa.setImg(getImageIcon("\\Imagens\\parede_externa.jpg"));

        Fundo.setBackground(new java.awt.Color(255, 255, 255));
        Fundo.setImg(getImageIcon("\\Imagens\\fundo.jpg"));

        javax.swing.GroupLayout jp_0_0Layout = new javax.swing.GroupLayout(jp_0_0);
        jp_0_0.setLayout(jp_0_0Layout);
        jp_0_0Layout.setHorizontalGroup(
            jp_0_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_0Layout.setVerticalGroup(
            jp_0_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_0_1Layout = new javax.swing.GroupLayout(jp_0_1);
        jp_0_1.setLayout(jp_0_1Layout);
        jp_0_1Layout.setHorizontalGroup(
            jp_0_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_0_1Layout.setVerticalGroup(
            jp_0_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede1Layout = new javax.swing.GroupLayout(parede1);
        parede1.setLayout(parede1Layout);
        parede1Layout.setHorizontalGroup(
            parede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede1Layout.setVerticalGroup(
            parede1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        parede3.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede3Layout = new javax.swing.GroupLayout(parede3);
        parede3.setLayout(parede3Layout);
        parede3Layout.setHorizontalGroup(
            parede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede3Layout.setVerticalGroup(
            parede3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_0_2Layout = new javax.swing.GroupLayout(jp_0_2);
        jp_0_2.setLayout(jp_0_2Layout);
        jp_0_2Layout.setHorizontalGroup(
            jp_0_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_2Layout.setVerticalGroup(
            jp_0_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_0_3Layout = new javax.swing.GroupLayout(jp_0_3);
        jp_0_3.setLayout(jp_0_3Layout);
        jp_0_3Layout.setHorizontalGroup(
            jp_0_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_3Layout.setVerticalGroup(
            jp_0_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_0_4Layout = new javax.swing.GroupLayout(jp_0_4);
        jp_0_4.setLayout(jp_0_4Layout);
        jp_0_4Layout.setHorizontalGroup(
            jp_0_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_4Layout.setVerticalGroup(
            jp_0_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede2Layout = new javax.swing.GroupLayout(parede2);
        parede2.setLayout(parede2Layout);
        parede2Layout.setHorizontalGroup(
            parede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede2Layout.setVerticalGroup(
            parede2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_0_5Layout = new javax.swing.GroupLayout(jp_0_5);
        jp_0_5.setLayout(jp_0_5Layout);
        jp_0_5Layout.setHorizontalGroup(
            jp_0_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_5Layout.setVerticalGroup(
            jp_0_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jp_0_7.setBackground(new java.awt.Color(51, 255, 51));
        jp_0_7.setImg(getImageIcon("\\Imagens\\palete.png"));

        javax.swing.GroupLayout jp_0_7Layout = new javax.swing.GroupLayout(jp_0_7);
        jp_0_7.setLayout(jp_0_7Layout);
        jp_0_7Layout.setHorizontalGroup(
            jp_0_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_7Layout.setVerticalGroup(
            jp_0_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_0_6Layout = new javax.swing.GroupLayout(jp_0_6);
        jp_0_6.setLayout(jp_0_6Layout);
        jp_0_6Layout.setHorizontalGroup(
            jp_0_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_0_6Layout.setVerticalGroup(
            jp_0_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_0Layout = new javax.swing.GroupLayout(jp_1_0);
        jp_1_0.setLayout(jp_1_0Layout);
        jp_1_0Layout.setHorizontalGroup(
            jp_1_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_1_0Layout.setVerticalGroup(
            jp_1_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_1Layout = new javax.swing.GroupLayout(jp_1_1);
        jp_1_1.setLayout(jp_1_1Layout);
        jp_1_1Layout.setHorizontalGroup(
            jp_1_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_1_1Layout.setVerticalGroup(
            jp_1_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_2Layout = new javax.swing.GroupLayout(jp_1_2);
        jp_1_2.setLayout(jp_1_2Layout);
        jp_1_2Layout.setHorizontalGroup(
            jp_1_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_1_2Layout.setVerticalGroup(
            jp_1_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede6.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede6Layout = new javax.swing.GroupLayout(parede6);
        parede6.setLayout(parede6Layout);
        parede6Layout.setHorizontalGroup(
            parede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede6Layout.setVerticalGroup(
            parede6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        parede4.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede4Layout = new javax.swing.GroupLayout(parede4);
        parede4.setLayout(parede4Layout);
        parede4Layout.setHorizontalGroup(
            parede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede4Layout.setVerticalGroup(
            parede4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_3Layout = new javax.swing.GroupLayout(jp_1_3);
        jp_1_3.setLayout(jp_1_3Layout);
        jp_1_3Layout.setHorizontalGroup(
            jp_1_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_1_3Layout.setVerticalGroup(
            jp_1_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_4Layout = new javax.swing.GroupLayout(jp_1_4);
        jp_1_4.setLayout(jp_1_4Layout);
        jp_1_4Layout.setHorizontalGroup(
            jp_1_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_1_4Layout.setVerticalGroup(
            jp_1_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede7.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede7Layout = new javax.swing.GroupLayout(parede7);
        parede7.setLayout(parede7Layout);
        parede7Layout.setHorizontalGroup(
            parede7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede7Layout.setVerticalGroup(
            parede7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_5Layout = new javax.swing.GroupLayout(jp_1_5);
        jp_1_5.setLayout(jp_1_5Layout);
        jp_1_5Layout.setHorizontalGroup(
            jp_1_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_1_5Layout.setVerticalGroup(
            jp_1_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede5.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede5Layout = new javax.swing.GroupLayout(parede5);
        parede5.setLayout(parede5Layout);
        parede5Layout.setHorizontalGroup(
            parede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede5Layout.setVerticalGroup(
            parede5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_6Layout = new javax.swing.GroupLayout(jp_1_6);
        jp_1_6.setLayout(jp_1_6Layout);
        jp_1_6Layout.setHorizontalGroup(
            jp_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_1_6Layout.setVerticalGroup(
            jp_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_1_7Layout = new javax.swing.GroupLayout(jp_1_7);
        jp_1_7.setLayout(jp_1_7Layout);
        jp_1_7Layout.setHorizontalGroup(
            jp_1_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_1_7Layout.setVerticalGroup(
            jp_1_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_0Layout = new javax.swing.GroupLayout(jp_2_0);
        jp_2_0.setLayout(jp_2_0Layout);
        jp_2_0Layout.setHorizontalGroup(
            jp_2_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_0Layout.setVerticalGroup(
            jp_2_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede10.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede10Layout = new javax.swing.GroupLayout(parede10);
        parede10.setLayout(parede10Layout);
        parede10Layout.setHorizontalGroup(
            parede10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede10Layout.setVerticalGroup(
            parede10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_1Layout = new javax.swing.GroupLayout(jp_2_1);
        jp_2_1.setLayout(jp_2_1Layout);
        jp_2_1Layout.setHorizontalGroup(
            jp_2_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_2_1Layout.setVerticalGroup(
            jp_2_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_2Layout = new javax.swing.GroupLayout(jp_2_2);
        jp_2_2.setLayout(jp_2_2Layout);
        jp_2_2Layout.setHorizontalGroup(
            jp_2_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_2Layout.setVerticalGroup(
            jp_2_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_3Layout = new javax.swing.GroupLayout(jp_2_3);
        jp_2_3.setLayout(jp_2_3Layout);
        jp_2_3Layout.setHorizontalGroup(
            jp_2_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_3Layout.setVerticalGroup(
            jp_2_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede8.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede8Layout = new javax.swing.GroupLayout(parede8);
        parede8.setLayout(parede8Layout);
        parede8Layout.setHorizontalGroup(
            parede8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede8Layout.setVerticalGroup(
            parede8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_4Layout = new javax.swing.GroupLayout(jp_2_4);
        jp_2_4.setLayout(jp_2_4Layout);
        jp_2_4Layout.setHorizontalGroup(
            jp_2_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_4Layout.setVerticalGroup(
            jp_2_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_5Layout = new javax.swing.GroupLayout(jp_2_5);
        jp_2_5.setLayout(jp_2_5Layout);
        jp_2_5Layout.setHorizontalGroup(
            jp_2_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_5Layout.setVerticalGroup(
            jp_2_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_6Layout = new javax.swing.GroupLayout(jp_2_6);
        jp_2_6.setLayout(jp_2_6Layout);
        jp_2_6Layout.setHorizontalGroup(
            jp_2_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_6Layout.setVerticalGroup(
            jp_2_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede9.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede9Layout = new javax.swing.GroupLayout(parede9);
        parede9.setLayout(parede9Layout);
        parede9Layout.setHorizontalGroup(
            parede9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede9Layout.setVerticalGroup(
            parede9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_6Layout = new javax.swing.GroupLayout(jp_3_6);
        jp_3_6.setLayout(jp_3_6Layout);
        jp_3_6Layout.setHorizontalGroup(
            jp_3_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_6Layout.setVerticalGroup(
            jp_3_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_0Layout = new javax.swing.GroupLayout(jp_3_0);
        jp_3_0.setLayout(jp_3_0Layout);
        jp_3_0Layout.setHorizontalGroup(
            jp_3_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_0Layout.setVerticalGroup(
            jp_3_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede12.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede12Layout = new javax.swing.GroupLayout(parede12);
        parede12.setLayout(parede12Layout);
        parede12Layout.setHorizontalGroup(
            parede12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede12Layout.setVerticalGroup(
            parede12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_1Layout = new javax.swing.GroupLayout(jp_3_1);
        jp_3_1.setLayout(jp_3_1Layout);
        jp_3_1Layout.setHorizontalGroup(
            jp_3_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_1Layout.setVerticalGroup(
            jp_3_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede13.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede13Layout = new javax.swing.GroupLayout(parede13);
        parede13.setLayout(parede13Layout);
        parede13Layout.setHorizontalGroup(
            parede13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede13Layout.setVerticalGroup(
            parede13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_2Layout = new javax.swing.GroupLayout(jp_3_2);
        jp_3_2.setLayout(jp_3_2Layout);
        jp_3_2Layout.setHorizontalGroup(
            jp_3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_2Layout.setVerticalGroup(
            jp_3_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede14.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede14Layout = new javax.swing.GroupLayout(parede14);
        parede14.setLayout(parede14Layout);
        parede14Layout.setHorizontalGroup(
            parede14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede14Layout.setVerticalGroup(
            parede14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_3Layout = new javax.swing.GroupLayout(jp_3_3);
        jp_3_3.setLayout(jp_3_3Layout);
        jp_3_3Layout.setHorizontalGroup(
            jp_3_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_3Layout.setVerticalGroup(
            jp_3_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_4Layout = new javax.swing.GroupLayout(jp_3_4);
        jp_3_4.setLayout(jp_3_4Layout);
        jp_3_4Layout.setHorizontalGroup(
            jp_3_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_3_4Layout.setVerticalGroup(
            jp_3_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede15.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede15Layout = new javax.swing.GroupLayout(parede15);
        parede15.setLayout(parede15Layout);
        parede15Layout.setHorizontalGroup(
            parede15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede15Layout.setVerticalGroup(
            parede15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_5Layout = new javax.swing.GroupLayout(jp_3_5);
        jp_3_5.setLayout(jp_3_5Layout);
        jp_3_5Layout.setHorizontalGroup(
            jp_3_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_5Layout.setVerticalGroup(
            jp_3_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_0Layout = new javax.swing.GroupLayout(jp_4_0);
        jp_4_0.setLayout(jp_4_0Layout);
        jp_4_0Layout.setHorizontalGroup(
            jp_4_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_4_0Layout.setVerticalGroup(
            jp_4_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_0Layout = new javax.swing.GroupLayout(jp_5_0);
        jp_5_0.setLayout(jp_5_0Layout);
        jp_5_0Layout.setHorizontalGroup(
            jp_5_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_5_0Layout.setVerticalGroup(
            jp_5_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_0Layout = new javax.swing.GroupLayout(jp_6_0);
        jp_6_0.setLayout(jp_6_0Layout);
        jp_6_0Layout.setHorizontalGroup(
            jp_6_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_0Layout.setVerticalGroup(
            jp_6_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede24.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede24Layout = new javax.swing.GroupLayout(parede24);
        parede24.setLayout(parede24Layout);
        parede24Layout.setHorizontalGroup(
            parede24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede24Layout.setVerticalGroup(
            parede24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jp_7_0.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jp_7_0Layout = new javax.swing.GroupLayout(jp_7_0);
        jp_7_0.setLayout(jp_7_0Layout);
        jp_7_0Layout.setHorizontalGroup(
            jp_7_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_7_0Layout.setVerticalGroup(
            jp_7_0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_1Layout = new javax.swing.GroupLayout(jp_4_1);
        jp_4_1.setLayout(jp_4_1Layout);
        jp_4_1Layout.setHorizontalGroup(
            jp_4_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_4_1Layout.setVerticalGroup(
            jp_4_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede16.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede16Layout = new javax.swing.GroupLayout(parede16);
        parede16.setLayout(parede16Layout);
        parede16Layout.setHorizontalGroup(
            parede16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede16Layout.setVerticalGroup(
            parede16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_1Layout = new javax.swing.GroupLayout(jp_5_1);
        jp_5_1.setLayout(jp_5_1Layout);
        jp_5_1Layout.setHorizontalGroup(
            jp_5_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_5_1Layout.setVerticalGroup(
            jp_5_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_2Layout = new javax.swing.GroupLayout(jp_4_2);
        jp_4_2.setLayout(jp_4_2Layout);
        jp_4_2Layout.setHorizontalGroup(
            jp_4_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_4_2Layout.setVerticalGroup(
            jp_4_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede17.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede17Layout = new javax.swing.GroupLayout(parede17);
        parede17.setLayout(parede17Layout);
        parede17Layout.setHorizontalGroup(
            parede17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede17Layout.setVerticalGroup(
            parede17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_3Layout = new javax.swing.GroupLayout(jp_4_3);
        jp_4_3.setLayout(jp_4_3Layout);
        jp_4_3Layout.setHorizontalGroup(
            jp_4_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_4_3Layout.setVerticalGroup(
            jp_4_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede18.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede18Layout = new javax.swing.GroupLayout(parede18);
        parede18.setLayout(parede18Layout);
        parede18Layout.setHorizontalGroup(
            parede18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede18Layout.setVerticalGroup(
            parede18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_1Layout = new javax.swing.GroupLayout(jp_6_1);
        jp_6_1.setLayout(jp_6_1Layout);
        jp_6_1Layout.setHorizontalGroup(
            jp_6_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_1Layout.setVerticalGroup(
            jp_6_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_2Layout = new javax.swing.GroupLayout(jp_5_2);
        jp_5_2.setLayout(jp_5_2Layout);
        jp_5_2Layout.setHorizontalGroup(
            jp_5_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_5_2Layout.setVerticalGroup(
            jp_5_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede22.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede22Layout = new javax.swing.GroupLayout(parede22);
        parede22.setLayout(parede22Layout);
        parede22Layout.setHorizontalGroup(
            parede22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede22Layout.setVerticalGroup(
            parede22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_4Layout = new javax.swing.GroupLayout(jp_4_4);
        jp_4_4.setLayout(jp_4_4Layout);
        jp_4_4Layout.setHorizontalGroup(
            jp_4_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_4_4Layout.setVerticalGroup(
            jp_4_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_2Layout = new javax.swing.GroupLayout(jp_6_2);
        jp_6_2.setLayout(jp_6_2Layout);
        jp_6_2Layout.setHorizontalGroup(
            jp_6_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_2Layout.setVerticalGroup(
            jp_6_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede25.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede25Layout = new javax.swing.GroupLayout(parede25);
        parede25.setLayout(parede25Layout);
        parede25Layout.setHorizontalGroup(
            parede25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede25Layout.setVerticalGroup(
            parede25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_3Layout = new javax.swing.GroupLayout(jp_5_3);
        jp_5_3.setLayout(jp_5_3Layout);
        jp_5_3Layout.setHorizontalGroup(
            jp_5_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_5_3Layout.setVerticalGroup(
            jp_5_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_3Layout = new javax.swing.GroupLayout(jp_6_3);
        jp_6_3.setLayout(jp_6_3Layout);
        jp_6_3Layout.setHorizontalGroup(
            jp_6_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_3Layout.setVerticalGroup(
            jp_6_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_4Layout = new javax.swing.GroupLayout(jp_5_4);
        jp_5_4.setLayout(jp_5_4Layout);
        jp_5_4Layout.setHorizontalGroup(
            jp_5_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_5_4Layout.setVerticalGroup(
            jp_5_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_4Layout = new javax.swing.GroupLayout(jp_6_4);
        jp_6_4.setLayout(jp_6_4Layout);
        jp_6_4Layout.setHorizontalGroup(
            jp_6_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_6_4Layout.setVerticalGroup(
            jp_6_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede27.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede27Layout = new javax.swing.GroupLayout(parede27);
        parede27.setLayout(parede27Layout);
        parede27Layout.setHorizontalGroup(
            parede27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede27Layout.setVerticalGroup(
            parede27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        parede26.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede26Layout = new javax.swing.GroupLayout(parede26);
        parede26.setLayout(parede26Layout);
        parede26Layout.setHorizontalGroup(
            parede26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede26Layout.setVerticalGroup(
            parede26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_5Layout = new javax.swing.GroupLayout(jp_4_5);
        jp_4_5.setLayout(jp_4_5Layout);
        jp_4_5Layout.setHorizontalGroup(
            jp_4_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_4_5Layout.setVerticalGroup(
            jp_4_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede20.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede20Layout = new javax.swing.GroupLayout(parede20);
        parede20.setLayout(parede20Layout);
        parede20Layout.setHorizontalGroup(
            parede20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede20Layout.setVerticalGroup(
            parede20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        parede19.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede19Layout = new javax.swing.GroupLayout(parede19);
        parede19.setLayout(parede19Layout);
        parede19Layout.setHorizontalGroup(
            parede19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede19Layout.setVerticalGroup(
            parede19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_5Layout = new javax.swing.GroupLayout(jp_5_5);
        jp_5_5.setLayout(jp_5_5Layout);
        jp_5_5Layout.setHorizontalGroup(
            jp_5_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_5_5Layout.setVerticalGroup(
            jp_5_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_5Layout = new javax.swing.GroupLayout(jp_6_5);
        jp_6_5.setLayout(jp_6_5Layout);
        jp_6_5Layout.setHorizontalGroup(
            jp_6_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_5Layout.setVerticalGroup(
            jp_6_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede28.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede28Layout = new javax.swing.GroupLayout(parede28);
        parede28.setLayout(parede28Layout);
        parede28Layout.setHorizontalGroup(
            parede28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede28Layout.setVerticalGroup(
            parede28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        parede21.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede21Layout = new javax.swing.GroupLayout(parede21);
        parede21.setLayout(parede21Layout);
        parede21Layout.setHorizontalGroup(
            parede21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede21Layout.setVerticalGroup(
            parede21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_6Layout = new javax.swing.GroupLayout(jp_4_6);
        jp_4_6.setLayout(jp_4_6Layout);
        jp_4_6Layout.setHorizontalGroup(
            jp_4_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_4_6Layout.setVerticalGroup(
            jp_4_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede11.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede11Layout = new javax.swing.GroupLayout(parede11);
        parede11.setLayout(parede11Layout);
        parede11Layout.setHorizontalGroup(
            parede11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede11Layout.setVerticalGroup(
            parede11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_2_7Layout = new javax.swing.GroupLayout(jp_2_7);
        jp_2_7.setLayout(jp_2_7Layout);
        jp_2_7Layout.setHorizontalGroup(
            jp_2_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_2_7Layout.setVerticalGroup(
            jp_2_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_3_7Layout = new javax.swing.GroupLayout(jp_3_7);
        jp_3_7.setLayout(jp_3_7Layout);
        jp_3_7Layout.setHorizontalGroup(
            jp_3_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_3_7Layout.setVerticalGroup(
            jp_3_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_4_7Layout = new javax.swing.GroupLayout(jp_4_7);
        jp_4_7.setLayout(jp_4_7Layout);
        jp_4_7Layout.setHorizontalGroup(
            jp_4_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_4_7Layout.setVerticalGroup(
            jp_4_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede23.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede23Layout = new javax.swing.GroupLayout(parede23);
        parede23.setLayout(parede23Layout);
        parede23Layout.setHorizontalGroup(
            parede23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        parede23Layout.setVerticalGroup(
            parede23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_6Layout = new javax.swing.GroupLayout(jp_5_6);
        jp_5_6.setLayout(jp_5_6Layout);
        jp_5_6Layout.setHorizontalGroup(
            jp_5_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_5_6Layout.setVerticalGroup(
            jp_5_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_6Layout = new javax.swing.GroupLayout(jp_6_6);
        jp_6_6.setLayout(jp_6_6Layout);
        jp_6_6Layout.setHorizontalGroup(
            jp_6_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_6Layout.setVerticalGroup(
            jp_6_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_6Layout = new javax.swing.GroupLayout(jp_7_6);
        jp_7_6.setLayout(jp_7_6Layout);
        jp_7_6Layout.setHorizontalGroup(
            jp_7_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_7_6Layout.setVerticalGroup(
            jp_7_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        parede29.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout parede29Layout = new javax.swing.GroupLayout(parede29);
        parede29.setLayout(parede29Layout);
        parede29Layout.setHorizontalGroup(
            parede29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        parede29Layout.setVerticalGroup(
            parede29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_5Layout = new javax.swing.GroupLayout(jp_7_5);
        jp_7_5.setLayout(jp_7_5Layout);
        jp_7_5Layout.setHorizontalGroup(
            jp_7_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_7_5Layout.setVerticalGroup(
            jp_7_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_4Layout = new javax.swing.GroupLayout(jp_7_4);
        jp_7_4.setLayout(jp_7_4Layout);
        jp_7_4Layout.setHorizontalGroup(
            jp_7_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_7_4Layout.setVerticalGroup(
            jp_7_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_5_7Layout = new javax.swing.GroupLayout(jp_5_7);
        jp_5_7.setLayout(jp_5_7Layout);
        jp_5_7Layout.setHorizontalGroup(
            jp_5_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_5_7Layout.setVerticalGroup(
            jp_5_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_6_7Layout = new javax.swing.GroupLayout(jp_6_7);
        jp_6_7.setLayout(jp_6_7Layout);
        jp_6_7Layout.setHorizontalGroup(
            jp_6_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_6_7Layout.setVerticalGroup(
            jp_6_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_7Layout = new javax.swing.GroupLayout(jp_7_7);
        jp_7_7.setLayout(jp_7_7Layout);
        jp_7_7Layout.setHorizontalGroup(
            jp_7_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_7_7Layout.setVerticalGroup(
            jp_7_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_1Layout = new javax.swing.GroupLayout(jp_7_1);
        jp_7_1.setLayout(jp_7_1Layout);
        jp_7_1Layout.setHorizontalGroup(
            jp_7_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_7_1Layout.setVerticalGroup(
            jp_7_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_2Layout = new javax.swing.GroupLayout(jp_7_2);
        jp_7_2.setLayout(jp_7_2Layout);
        jp_7_2Layout.setHorizontalGroup(
            jp_7_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jp_7_2Layout.setVerticalGroup(
            jp_7_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_7_3Layout = new javax.swing.GroupLayout(jp_7_3);
        jp_7_3.setLayout(jp_7_3Layout);
        jp_7_3Layout.setHorizontalGroup(
            jp_7_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_7_3Layout.setVerticalGroup(
            jp_7_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_6_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_6_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_6_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_6_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jp_6_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parede26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_7_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_6_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_6_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jp_0_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parede3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_0_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_0_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_0_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jp_1_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parede6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jp_1_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parede7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jp_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_1_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jp_1_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FundoLayout.createSequentialGroup()
                                .addComponent(jp_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jp_2_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(parede10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jp_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parede8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jp_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_2_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parede9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FundoLayout.createSequentialGroup()
                                .addComponent(jp_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parede16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jp_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parede17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jp_4_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(parede18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jp_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jp_4_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(parede19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parede20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jp_4_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parede21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FundoLayout.createSequentialGroup()
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(FundoLayout.createSequentialGroup()
                                        .addComponent(jp_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(parede12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jp_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(parede13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jp_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(parede14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jp_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FundoLayout.createSequentialGroup()
                                        .addComponent(jp_7_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jp_7_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jp_7_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jp_7_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FundoLayout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(jp_7_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jp_7_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(parede29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(FundoLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jp_3_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(parede15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addComponent(jp_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jp_3_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(FundoLayout.createSequentialGroup()
                                .addComponent(jp_5_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jp_5_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(parede22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jp_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_5_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jp_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jp_5_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(parede23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jp_2_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_3_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_4_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_5_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parede11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_6_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_7_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parede1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_0_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_0_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_0_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parede4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_1_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_1_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_2_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_2_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_3_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_3_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parede20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_4_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_4_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_5_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addComponent(jp_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_5_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jp_5_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_5_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_6_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_6_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_6_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_6_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FundoLayout.createSequentialGroup()
                        .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parede27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp_6_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parede26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(parede28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_6_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_6_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_6_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jp_7_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(parede29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jp_7_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp_7_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp_7_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp_7_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp_7_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jp_7_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_7_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout JPForaDoMapaLayout = new javax.swing.GroupLayout(JPForaDoMapa);
        JPForaDoMapa.setLayout(JPForaDoMapaLayout);
        JPForaDoMapaLayout.setHorizontalGroup(
            JPForaDoMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPForaDoMapaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        JPForaDoMapaLayout.setVerticalGroup(
            JPForaDoMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPForaDoMapaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPForaDoMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPForaDoMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExecutarActionPerformed
                
        new Thread() {
            @Override
            public void run() {
                Executar();
            }
        }.start();
        
    }//GEN-LAST:event_BTExecutarActionPerformed

    private void BTPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTPararActionPerformed
        this.stop = true;        
    }//GEN-LAST:event_BTPararActionPerformed

    private void BTResetParametrosIniciaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTResetParametrosIniciaisActionPerformed
        this.setParametrosIniciais();
    }//GEN-LAST:event_BTResetParametrosIniciaisActionPerformed

    private void Slider_IndividuosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_IndividuosStateChanged
        this.qtde_individuos = this.Slider_Individuos.getValue();
        this.LBIndividuos.setText(this.qtde_individuos + "");
    }//GEN-LAST:event_Slider_IndividuosStateChanged

    private void Slider_TaxaCrossoverStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_TaxaCrossoverStateChanged
        this.taxa_crossover = this.Slider_TaxaCrossover.getValue()/1000.0;
        this.LBTaxaCrossover.setText(this.Slider_TaxaCrossover.getValue()/10.0 + "%");
    }//GEN-LAST:event_Slider_TaxaCrossoverStateChanged

    private void Slider_TaxaMutacaoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_TaxaMutacaoStateChanged
        this.taxa_mutacao = this.Slider_TaxaMutacao.getValue()/1000.0;
        this.LBTaxaMutacao.setText(this.Slider_TaxaMutacao.getValue()/10.0 + "%");        
    }//GEN-LAST:event_Slider_TaxaMutacaoStateChanged

    private void Slider_PontosCrossoverStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_PontosCrossoverStateChanged
        this.qtde_pontos_crossover = this.Slider_PontosCrossover.getValue();
        this.LBPontoCrossover.setText(this.qtde_pontos_crossover + "");
    }//GEN-LAST:event_Slider_PontosCrossoverStateChanged

    private void Slider_PunicaoSuicidioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_PunicaoSuicidioStateChanged
        this.punicao_suicidio = this.Slider_PunicaoSuicidio.getValue();
        this.LBPunicaoSuicidio.setText(this.punicao_suicidio + "");
    }//GEN-LAST:event_Slider_PunicaoSuicidioStateChanged

    private void Slider_PunicaoBatidaParedeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_PunicaoBatidaParedeStateChanged
        this.punicao_batida_parede = this.Slider_PunicaoBatidaParede.getValue();
        this.LBPunicaoBatidaParede.setText(this.punicao_batida_parede + "");
    }//GEN-LAST:event_Slider_PunicaoBatidaParedeStateChanged

    private void Slider_PunicaoDistanciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Slider_PunicaoDistanciaStateChanged
        this.punicao_distancia = this.Slider_PunicaoDistancia.getValue();
        this.LBPunicaoDistancia.setText(this.punicao_distancia + "");
    }//GEN-LAST:event_Slider_PunicaoDistanciaStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Labirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Labirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Labirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Labirinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Labirinto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTExecutar;
    private javax.swing.JButton BTParar;
    private javax.swing.JButton BTResetParametrosIniciais;
    private projetocientifico.PainelFundo Fundo;
    private projetocientifico.PainelFundo JPForaDoMapa;
    private javax.swing.JPanel JPParametros;
    private javax.swing.JLabel LBAptidao;
    private javax.swing.JLabel LBGeracao;
    private javax.swing.JLabel LBIndividuos;
    private javax.swing.JLabel LBPontoCrossover;
    private javax.swing.JLabel LBPunicaoBatidaParede;
    private javax.swing.JLabel LBPunicaoDistancia;
    private javax.swing.JLabel LBPunicaoSuicidio;
    private javax.swing.JLabel LBTaxaCrossover;
    private javax.swing.JLabel LBTaxaMutacao;
    private javax.swing.JRadioButton RBMelhoDaGeracao;
    private javax.swing.JRadioButton RBMelhor;
    private javax.swing.JRadioButton RBTodos;
    private javax.swing.JSlider Slider_Individuos;
    private javax.swing.JSlider Slider_PontosCrossover;
    private javax.swing.JSlider Slider_PunicaoBatidaParede;
    private javax.swing.JSlider Slider_PunicaoDistancia;
    private javax.swing.JSlider Slider_PunicaoSuicidio;
    private javax.swing.JSlider Slider_TaxaCrossover;
    private javax.swing.JSlider Slider_TaxaMutacao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jp_0_0;
    private javax.swing.JPanel jp_0_1;
    private javax.swing.JPanel jp_0_2;
    private javax.swing.JPanel jp_0_3;
    private javax.swing.JPanel jp_0_4;
    private javax.swing.JPanel jp_0_5;
    private javax.swing.JPanel jp_0_6;
    private projetocientifico.PainelFundo jp_0_7;
    private javax.swing.JPanel jp_1_0;
    private javax.swing.JPanel jp_1_1;
    private javax.swing.JPanel jp_1_2;
    private javax.swing.JPanel jp_1_3;
    private javax.swing.JPanel jp_1_4;
    private javax.swing.JPanel jp_1_5;
    private javax.swing.JPanel jp_1_6;
    private javax.swing.JPanel jp_1_7;
    private javax.swing.JPanel jp_2_0;
    private javax.swing.JPanel jp_2_1;
    private javax.swing.JPanel jp_2_2;
    private javax.swing.JPanel jp_2_3;
    private javax.swing.JPanel jp_2_4;
    private javax.swing.JPanel jp_2_5;
    private javax.swing.JPanel jp_2_6;
    private javax.swing.JPanel jp_2_7;
    private javax.swing.JPanel jp_3_0;
    private javax.swing.JPanel jp_3_1;
    private javax.swing.JPanel jp_3_2;
    private javax.swing.JPanel jp_3_3;
    private javax.swing.JPanel jp_3_4;
    private javax.swing.JPanel jp_3_5;
    private javax.swing.JPanel jp_3_6;
    private javax.swing.JPanel jp_3_7;
    private javax.swing.JPanel jp_4_0;
    private javax.swing.JPanel jp_4_1;
    private javax.swing.JPanel jp_4_2;
    private javax.swing.JPanel jp_4_3;
    private javax.swing.JPanel jp_4_4;
    private javax.swing.JPanel jp_4_5;
    private javax.swing.JPanel jp_4_6;
    private javax.swing.JPanel jp_4_7;
    private javax.swing.JPanel jp_5_0;
    private javax.swing.JPanel jp_5_1;
    private javax.swing.JPanel jp_5_2;
    private javax.swing.JPanel jp_5_3;
    private javax.swing.JPanel jp_5_4;
    private javax.swing.JPanel jp_5_5;
    private javax.swing.JPanel jp_5_6;
    private javax.swing.JPanel jp_5_7;
    private javax.swing.JPanel jp_6_0;
    private javax.swing.JPanel jp_6_1;
    private javax.swing.JPanel jp_6_2;
    private javax.swing.JPanel jp_6_3;
    private javax.swing.JPanel jp_6_4;
    private javax.swing.JPanel jp_6_5;
    private javax.swing.JPanel jp_6_6;
    private javax.swing.JPanel jp_6_7;
    private projetocientifico.PainelFundo jp_7_0;
    private javax.swing.JPanel jp_7_1;
    private javax.swing.JPanel jp_7_2;
    private javax.swing.JPanel jp_7_3;
    private javax.swing.JPanel jp_7_4;
    private javax.swing.JPanel jp_7_5;
    private javax.swing.JPanel jp_7_6;
    private javax.swing.JPanel jp_7_7;
    private javax.swing.JPanel parede1;
    private projetocientifico.PainelFundo parede10;
    private projetocientifico.PainelFundo parede11;
    private projetocientifico.PainelFundo parede12;
    private projetocientifico.PainelFundo parede13;
    private javax.swing.JPanel parede14;
    private javax.swing.JPanel parede15;
    private projetocientifico.PainelFundo parede16;
    private projetocientifico.PainelFundo parede17;
    private projetocientifico.PainelFundo parede18;
    private projetocientifico.PainelFundo parede19;
    private projetocientifico.PainelFundo parede2;
    private javax.swing.JPanel parede20;
    private projetocientifico.PainelFundo parede21;
    private projetocientifico.PainelFundo parede22;
    private javax.swing.JPanel parede23;
    private projetocientifico.PainelFundo parede24;
    private javax.swing.JPanel parede25;
    private projetocientifico.PainelFundo parede26;
    private javax.swing.JPanel parede27;
    private projetocientifico.PainelFundo parede28;
    private projetocientifico.PainelFundo parede29;
    private projetocientifico.PainelFundo parede3;
    private projetocientifico.PainelFundo parede4;
    private projetocientifico.PainelFundo parede5;
    private javax.swing.JPanel parede6;
    private projetocientifico.PainelFundo parede7;
    private projetocientifico.PainelFundo parede8;
    private projetocientifico.PainelFundo parede9;
    // End of variables declaration//GEN-END:variables
}
