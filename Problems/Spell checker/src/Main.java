// Posted from EduTools plugin
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> knownWords = new HashSet<>();
        Set<String> erroneousWords = new HashSet<>();

        int d = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < d; i++) {
            knownWords.add(scanner.nextLine().toLowerCase());
        }

        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < l; i++) {
            String line = scanner.nextLine().toLowerCase();
            erroneousWords.addAll(Arrays.asList(line.split(" ")));
        }

        erroneousWords.removeAll(knownWords);

        erroneousWords.forEach(word -> System.out.println(word));
    }
}