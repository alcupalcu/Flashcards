import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];

        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean isNotPair = true;

        for (int i = 0, j = 1; i < array.length-1; i++, j++) {
            if(array[i] == n && array[i+1] == m) {
                isNotPair = false;
                break;
            }
            if(array[j] == n && array[j-1] == m) {
                isNotPair = false;
                break;
            }
        }
        System.out.println(isNotPair);
    }
}