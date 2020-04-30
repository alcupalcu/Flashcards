import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arrayOfStrings = input.split(" ");
        int rotationLevel = scanner.nextInt() % arrayOfStrings.length;
        int tempIndex = 0;
        for(int i = 0; i < arrayOfStrings.length; i++) {
            tempIndex = arrayOfStrings.length - rotationLevel + i;
            if(tempIndex >= arrayOfStrings.length) {
                tempIndex -= arrayOfStrings.length;
            }
            System.out.print(arrayOfStrings[tempIndex] + " ");
        }
    }
}