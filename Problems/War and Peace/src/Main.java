import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] wordsInLine = line.split(" ");

        Map<String, Integer> uniqueAndCounts = new LinkedHashMap<>();

        for (String word : wordsInLine) {
            if (uniqueAndCounts.containsKey(word.toLowerCase())) {
                uniqueAndCounts.put(word.toLowerCase(), uniqueAndCounts.get(word.toLowerCase()) + 1);
            } else {
                uniqueAndCounts.put(word.toLowerCase(), 1);
            }
        }

        for (var element : uniqueAndCounts.entrySet()) {
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }
}