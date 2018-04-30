package aplicacao1;

import java.util.Random;
import java.util.Scanner;

public class Advinhe {

    public static void main(String[] args) {
        boolean hit = false;
        int rand, choice = 0, attempts = 0;
        String attemp;
        Random random = new Random();
        rand = random.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Tente advinhar o número que eu pensei!");
        while (hit == false) {
            attemp = sc.next();
            try {
                choice = Integer.parseInt(attemp);
                if (choice == rand) {
                    System.out.println("Parabéns, você acertou o número que eu pensei!");
                    hit = true;
                } else if (choice < rand) {
                    System.out.println("O número que eu pensei é um pouco maior do que esse, tente novamente!");
                } else {
                    System.out.println("O número que eu pensei é menor do que esse, tente novamente!");
                }
                attempts++;
            } catch (NumberFormatException ex) {
                System.out.println("Caractere digitado não é um número Inteiro!");
                System.out.println("Digite novamente: ");
            }
        }
        System.out.println("Fim do jogo, você acertou a resposta em " + attempts + " tentativas!");
    }
}
