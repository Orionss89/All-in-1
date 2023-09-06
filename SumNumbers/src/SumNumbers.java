import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ile liczb chcesz wyświetlić: ");
        int numbers = scanner.nextInt();

        int sum =0;
       while (numbers > 0){
           System.out.println("Podaj kolejną liczbę");
           sum = sum + scanner.nextInt();
           numbers--;
        }
        System.out.println("Suma wszystkich podanych liczb to " + sum);
        scanner.close();
    }

}
