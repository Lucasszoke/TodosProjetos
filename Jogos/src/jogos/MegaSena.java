package jogos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MegaSena {

    public static void main(String[] args) {
        int[] sorteio; //Número de 1 a 60
        int[] numerosJogados = new int[6];
        String testaInt;
        boolean intVerdadeiro = false;
        int numeros = 0, acertos = 0; 
        Scanner sc = new Scanner(System.in);
        
        while(intVerdadeiro == false){
            System.out.println("Digite quantos números você quer apostar (mínimo 6 e máximo 15): ");
            testaInt = sc.nextLine();
            try{
                numeros = Integer.parseInt(testaInt);
                if(numeros >= 6 && numeros <= 15){
                    numerosJogados = new int[numeros];
                    for(int i=0;i<numeros;i++){
                        System.out.println("Digite um número de cada vez para apostar (Números de 1 a 60): ");
                        testaInt = sc.nextLine();
                        try{
                            numerosJogados[i] = Integer.parseInt(testaInt);
                            if(numerosJogados[i] > 0 && numerosJogados[i] <= 60){
                                //Testa se o valor está dentro do desejado
                                if(i>0){
                                    for(int j=0; j<i; j++){
                                        //Testa o número escolhido, para ver se já foi selecionado
                                        if(numerosJogados[j] == numerosJogados[i]){
                                            System.out.println("Número já foi escolhido anteriormente!\n"
                                                    + "Digite novamente.");
                                            i--;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Os números devem corresponder a no máximo 60 e no mínimo 1!");
                                i--;
                            }                            
                        } catch(Exception ex){
                            System.out.println("Não foi digitado um número inteiro, digite novamente!");
                            i--;
                        }
                    }
                    intVerdadeiro = true;
                } else {
                    //Número excede ou não chega ao desejado
                    System.out.println("Número excede ou não corresponde ao pedido");
                }
            } catch(NumberFormatException ex){
                System.out.println("Valor digitado não é um inteiro!");                
            }
        }
        Arrays.sort(numerosJogados);
        System.out.println("\n--------------------------------------------------------");
        System.out.println("Números jogados: ");
        for(int i=0;i<numeros;i++){
            System.out.print(numerosJogados[i] + "\t");
        }
        System.out.println("\n--------------------------------------------------------");
        sorteio = sorteioNumeros();
        System.out.println("Números sorteados: ");
        for(int i=0;i<sorteio.length;i++){
            System.out.print(sorteio[i] + "\t");
        }
        System.out.println("\n--------------------------------------------------------");
        for(int i=0;i<numeros;i++){
            for(int j=0;j<sorteio.length;j++){
                if(numerosJogados[i] == sorteio[j]){
                    acertos++;
                }
            }
        }
        System.out.println("Você obteve um total de: " + acertos + " acertos!");
        System.out.println("\t\tFIM!");
    }
    
    static int[] sorteioNumeros(){
        int[] numerosSorteados = new int[6];
        Random gerador = new Random();
        
        for(int i=0;i<numerosSorteados.length;i++){
            numerosSorteados[i] = gerador.nextInt(60) + 1;
            for(int j=0;j<i;j++){
                if(numerosSorteados[j] == numerosSorteados[i]){
                    i--;
                }
            }
        }        
        Arrays.sort(numerosSorteados);
        
        return numerosSorteados;
    }
}
