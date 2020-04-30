// Posted from EduTools plugin
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> randomValues = new LinkedHashMap<>();

        int seedSetStart = scanner.nextInt();
        int seedSetEnd = scanner.nextInt();
        int numbersToProduce = scanner.nextInt();
        int pseudoNumbersSetEnd = scanner.nextInt();

        for (int i = seedSetStart; i < seedSetEnd; i++) {
            Random random = new Random(i);
            Map<Integer, Integer> numbersMap = new LinkedHashMap<>();
            for (int j = 0; j < numbersToProduce; j++) {
                numbersMap.put(j, random.nextInt(pseudoNumbersSetEnd));
            }
            randomValues.put(i, Collections.max(numbersMap.values()));
        }

        int maxMinimum = pseudoNumbersSetEnd;
        int seed = seedSetEnd;
        for (var entry : randomValues.entrySet()) {
            int nextMaximum = entry.getValue();
            if (nextMaximum < maxMinimum) {
                maxMinimum = nextMaximum;
                seed = entry.getKey();
            }
        }

        System.out.println(seed);
        System.out.println(maxMinimum);
    }
}