// Posted from EduTools plugin
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] newspaperLine = scanner.nextLine().split(" ");
        String[] blackmailNote = scanner.nextLine().split(" ");

        Map<String, Integer> newsPaperLineMap = new HashMap<>();
        for (String word : newspaperLine) {
            if (newsPaperLineMap.containsKey(word)) {
                newsPaperLineMap.put(word, newsPaperLineMap.get(word) + 1);
            } else {
                newsPaperLineMap.put(word, 1);
            }
        }

        boolean canPrepareNote = true;

        for (String word : blackmailNote) {
            if (newsPaperLineMap.containsKey(word)) {
                newsPaperLineMap.put(word, newsPaperLineMap.get(word) - 1);
                if (newsPaperLineMap.get(word) == 0) {
                    newsPaperLineMap.remove(word);
                }
            } else {
                canPrepareNote = false;
                break;
            }
        }

        System.out.println(canPrepareNote ? "You get money" : "You are busted");
    }
}