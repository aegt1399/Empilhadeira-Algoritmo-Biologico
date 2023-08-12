
package projetocientifico.Testes;

import projetocientifico.Genetica.Cromossomo;
import projetocientifico.Genetica.Individuo;
import projetocientifico.Utilitario.Util;

/**
 *
 * @author angel
 */
public class RotinaPrincipal {
    
    public  RotinaPrincipal(){
        
        //Teste_ArrayGenerator();
        //Teste_Cromossomo();
        //Teste_Individuo();
        //Teste_Distancia();
        //System.out.println(Util.CurrentDir());
    }
    
    // Testa se o método de geração de um array está correto
    private void Teste_ArrayGenerator(){//Verificado
        int[] pontos;
        for (int i = 0; i < 10000; i++) {
            pontos = Util.ArrayGenerator(13, 1, 13, true, true);
        }        
    }
    
    private void Teste_Cromossomo(){//Verificado
        Cromossomo c1 = new Cromossomo(14);
        Cromossomo c2 = new Cromossomo(14);
        c1.GeraCromossomoAleatorio();
        c2.GeraCromossomoAleatorio();
        
        Cromossomo filhos[] = c1.CruzaGenetica(c2, 4, 0.6, 0.01);
    }
    
    private void Teste_Individuo(){//Verificado   
        int alelos[] = {0,
                        1,
                        2,
                        3};

        boolean variacoes[][] = {{false, false},
                                 {false, true},
                                 {true, false},
                                 {true, true}};
        
        Individuo pai1 = new Individuo(0.6, 0.01, 4);    
        Individuo pai2 = new Individuo(0.6, 0.01, 4);
        
        pai1.CriaIndividuoPorPoderDivino(28);
        pai2.CriaIndividuoPorPoderDivino(28);

        System.out.println("Pai 1: " + pai1.getGenotipo(2, variacoes, alelos));   
        System.out.println("Pai 2: " + pai2.getGenotipo(2, variacoes, alelos));
        
        System.out.println("\nCruza Genética:");
        Individuo filhos[] = pai1.Cruza(pai2);
        
        System.out.println("Filho 1: " + filhos[0].getGenotipo(2, variacoes, alelos));   
        System.out.println("Filho 2: " + filhos[1].getGenotipo(2, variacoes, alelos));
                
    }
    
    private void Teste_Distancia(){
        System.out.println("Distancia entre a posicao incial e final: " + Util.Distancia(7, 0, 0, 7));
    }
}
