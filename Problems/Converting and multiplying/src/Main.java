// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String next = null;
            try {
                next = scanner.nextLine();
                int val = Integer.parseInt(next);

                if (val == 0) {
                    break;
                }

                System.out.println(val * 10);

            } catch (Exception exc) {
                System.out.println("Invalid user input: " + next);
            }
        }
    }
}