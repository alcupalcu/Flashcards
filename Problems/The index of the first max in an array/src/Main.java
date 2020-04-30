import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] tab = new int[length];
        int maxElement = 0;
        int indexOfMaxElement = 0;

        for(int i = 0; i < length; i++) {
            tab[i] = scanner.nextInt();
            if(tab[i] > maxElement) {
                maxElement = tab[i];
                indexOfMaxElement = i;
            }
        }
        System.out.println(indexOfMaxElement);
    }
}