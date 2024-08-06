import java.util.Scanner;

public class practice {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the input");
        int input = s.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(input + " * " + i + " = " + input * i);
        }
    }
}
