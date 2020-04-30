// Posted from EduTools plugin
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Character[] firstWord = scanner.nextLine().chars().mapToObj(c -> (char) Character.toLowerCase(c))
                .toArray(Character[]::new);
        Character[] secondWord = scanner.nextLine().chars().mapToObj(c -> (char) Character.toLowerCase(c))
                .toArray(Character[]::new);

        Map<Character, Integer> lettersWithOccurrences = new HashMap<>();

        for (Character character : firstWord) {
            if (lettersWithOccurrences.containsKey(character)) {
                lettersWithOccurrences.put(character, lettersWithOccurrences.get(character) + 1);
            } else {
                lettersWithOccurrences.put(character, 1);
            }
        }

        int differences = 0;

        for (Character character : secondWord) {
            if (lettersWithOccurrences.containsKey(character)) {
                lettersWithOccurrences.put(character, lettersWithOccurrences.get(character) - 1);
                if (lettersWithOccurrences.get(character) == 0) {
                    lettersWithOccurrences.remove(character);
                }
            } else {
                differences++;
            }
        }

        for (Integer value : lettersWithOccurrences.values()) {
            differences += value;
        }

        System.out.println(differences);
    }
}