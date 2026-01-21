import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main() {
        Random numbersort = new Random();
        Scanner input = new Scanner(System.in);
        int number = numbersort.nextInt(1, 50);

        int numberUser = 0;
        do {
            System.out.println("tente acerta o número: ");
            numberUser = input.nextInt();

            if (numberUser > number) {
                System.out.println("é menor");
            } else if (numberUser < number) {
                System.out.println("é maior");
            } else {
                System.out.println("Win");
            }
        } while (numberUser != number);
    }
}

