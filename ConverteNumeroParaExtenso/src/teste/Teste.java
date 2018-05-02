package teste;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        int count = 0;
        String num = "10";
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número Inteiro para fazer a conversão dele para texto (Favor digitar números entre 1 e 99): ");
        num = sc.next();
        if (IntTest(num) == true) {
            count = num.length();
        } else {
            System.out.println("Valor digitado é Inválido, programa finalizado!");
            System.exit(0);
        }
        System.out.println(IntName(count, num));
        System.out.println("Fim do programa!");
    }

    static String IntName(int count, String num) {
        String completeIntName = "";
        char localString;
        while (count > 0) {
            switch (count) {
                case 1: {                    
                    num += num.charAt(0);
                    localString = num.charAt(1);
                    if(num.charAt(1) != '0' && completeIntName != ""){
                        completeIntName += " e ";
                    }
                    switch (localString) {
                        case '1': {
                            completeIntName += "Um";
                        }
                        break;
                        case '2': {
                            completeIntName += "Dois";
                        }
                        break;
                        case '3': {
                            completeIntName += "Três";
                        }
                        break;
                        case '4': {
                            completeIntName += "Quatro";
                        }
                        break;
                        case '5': {
                            completeIntName += "Cinco";
                        }
                        break;
                        case '6': {
                            completeIntName += "Seis";
                        }
                        break;
                        case '7': {
                            completeIntName += "Sete";
                        }
                        break;
                        case '8': {
                            completeIntName += "Oito";
                        }
                        break;
                        case '9': {
                            completeIntName += "Nove";
                        }
                        break;
                        default: {}
                    }

                }
                break;
                case 2: {
                    localString = num.charAt(count - 2);
                    switch (localString) {
                        case '1': {
                            switch(num){
                                case "11":{
                                    completeIntName += "Onze";
                                    count = 0;
                                }break;
                                case "12":{
                                    completeIntName += "Doze";
                                    count = 0;
                                }break;
                                case "13":{
                                    completeIntName += "Treze";
                                    count = 0;
                                }break;
                                case "14":{
                                    completeIntName += "Quatorze";
                                    count = 0;
                                }break;
                                case "15":{
                                    completeIntName += "Quinze";
                                    count = 0;
                                }break;
                                case "16":{
                                    completeIntName += "Dezesseis";
                                    count = 0;
                                }break;
                                case "17":{
                                    completeIntName += "Dezessete";
                                    count = 0;
                                }break;
                                case "18":{
                                    completeIntName += "Dezoito";
                                    count = 0;
                                }break;
                                case "19":{
                                    completeIntName += "Dezenove";
                                    count = 0;
                                }break;
                                default:{
                                    completeIntName += "Dez";
                                    count = 0;
                                }
                            }                            
                        }
                        break;
                        case '2': {
                            completeIntName += "Vinte";
                        }
                        break;
                        case '3': {
                            completeIntName += "Trinta";
                        }
                        break;
                        case '4': {
                            completeIntName += "Quarenta";
                        }
                        break;
                        case '5': {
                            completeIntName += "Cinquenta";
                        }
                        break;
                        case '6': {
                            completeIntName += "Sessenta";
                        }
                        break;
                        case '7': {
                            completeIntName += "Setenta";
                        }
                        break;
                        case '8': {
                            completeIntName += "Oitenta";
                        }
                        break;
                        case '9': {
                            completeIntName += "Noventa";
                        }
                        break;
                    }
                }
                break;
            }
            count--;
        }

        return completeIntName;
    }

    static boolean IntTest(String recebida) {
        boolean response = false;
        try {
            int integer = Integer.parseInt(recebida);
            response = true;
        } catch (NumberFormatException ex) {
            response = false;
        }
        return response;
    }
}
