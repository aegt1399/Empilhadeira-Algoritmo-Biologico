
package projetocientifico.Utilitario;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author angel
 */
public class Util {
    
    public static int[] ArrayGenerator(int size, int inicio, int fim, boolean cantRepet, boolean sorted){
        
        if(fim < inicio){
            return null;
        }
        
        if (inicio < 0){
            return null;
        }
        
        if(size < 1){
            return null;
        }
        
        // quando 'cantRepet' for true, é obrigatório ter uma quantidade de 
        // elementos possíveis igual ou superior ao tamanho do vetor resultante
        // quando 'cantRepet' for false, é obrigatório ter no mínimo 1 elemento
        // possível
        if(cantRepet && (fim - inicio+1) < size){
            return null;
        }else if(!cantRepet && (fim - inicio+1) < 1){
            return null;
        }
                
        int vet[] = new int[size];
        Random rand = new Random();
        
        int temp;
        boolean repetido;
        for (int i = 0; i < size; i++) {
                        
            do{
                repetido = false;
                
                temp = rand.nextInt(fim-inicio+1);
                temp +=inicio;
                
                if(cantRepet){
                    for (int j = 0; j < i; j++) {
                        if(vet[j] == temp){
                            repetido = true;
                            break;
                        }
                    }
                }
                
            }while(cantRepet && repetido); // continua executando enquanto não 
                                           //puder repetir o valor e estiver repetido
            vet[i] = temp;         
            
        }        
        
        if(sorted){
            Arrays.sort(vet);
        }
        return vet;
    }
    
    public static String CurrentDir(){
        //return System.getProperty("user.dir");
        return new File("").getAbsolutePath();
    }
    
    public static int Distancia(int l1, int c1, int l2, int c2){
        int l = l2 - l1;
        int c = c2 - c1;
        double temp = Math.sqrt((l*l) + (c*c));
        
        return (int)Math.sqrt((l*l) + (c*c));
    }
        
}
