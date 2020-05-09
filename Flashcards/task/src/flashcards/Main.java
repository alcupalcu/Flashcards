package flashcards;

import java.io.*;
import java.util.*;

public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static String filename;
    static File file;
    static Map<String, String> cards = new LinkedHashMap<>();
    static Map<Integer, String> names = new LinkedHashMap<>();
    static Map<String, Integer> mistakes = new LinkedHashMap<>();
    static Map<String, String> hardestCards = new LinkedHashMap<>();
    static ArrayList<String> IOLog = new ArrayList<>();
    static int namesCounter;

    public static void main(String[] args) {

        String command = "";
        boolean isRunning = true;

        while(isRunning) {
            System.out.println(addToIOLogAndReturn("\nInput the action (add, remove, import, export, ask, exit, " +
                    "log, hardest card, reset stats):"));
            command = addToIOLogAndReturn(scanner.nextLine());
            switch (command) {
                case "add":
                    cardAdd();
                    break;
                case "remove":
                    cardRemove();
                    break;
                case "import":
                    cardImport();
                    break;
                case "export":
                    cardExport();
                    break;
                case "ask":
                    cardAsk();
                    break;
                case "log":
                    log();
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStats();
                    break;
                case "exit":
                    isRunning = false;
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Action unrecognized.");
            }
        }
    }

    private static void cardAdd(){
        System.out.println(addToIOLogAndReturn("The card:"));
        String cardName = addToIOLogAndReturn(scanner.nextLine());
        if (cards.containsKey(cardName)) {
            System.out.println(addToIOLogAndReturn("The card \"" + cardName + "\" already exists."));
            return;
        }
        System.out.println(addToIOLogAndReturn("The definition of the card:"));
        String cardDefinition = addToIOLogAndReturn(scanner.nextLine());
        if (cards.containsValue(cardDefinition)) {
            System.out.println(addToIOLogAndReturn("The definition \"" + cardDefinition + "\" already exists."));
        } else {
            cards.put(cardName, cardDefinition);
            System.out.println(addToIOLogAndReturn("The pair (\"" + cardName + "\":\"" + cardDefinition +
                    "\") has been added."));
        }
    }

    private static void cardRemove(){
        System.out.println(addToIOLogAndReturn("The card:"));
        String cardName = addToIOLogAndReturn(scanner.nextLine());
        if (cards.containsKey(cardName)) {
            cards.remove(cardName);
            mistakes.remove(cardName);
            System.out.println(addToIOLogAndReturn("The card has been removed."));
        } else {
            System.out.println(addToIOLogAndReturn("Can't remove \"" + cardName + "\": there is no such card."));
        }
    }

    private static void cardAsk(){
        namesCounter = 0;
        for (var card : cards.entrySet()) {
            names.put(namesCounter, card.getKey());
            namesCounter++;
        }
        System.out.println(addToIOLogAndReturn("How many times to ask?"));
        int howManyTimes = Integer.parseInt(addToIOLogAndReturn(scanner.nextLine()));
        for (int i = 0; i < howManyTimes; i++) {
            Random random = new Random();
            int keyToGetFromNames = random.nextInt(namesCounter);
            String nameToAskFor = names.get(keyToGetFromNames);
            if (cards.containsKey(nameToAskFor)) {
                System.out.println(addToIOLogAndReturn("Print the definition of \"" + nameToAskFor + "\":"));
                String answer = addToIOLogAndReturn(scanner.nextLine());
                if (answer.equals(cards.get(nameToAskFor))) {
                    System.out.println(addToIOLogAndReturn("Correct answer"));
                } else {
                    if (mistakes.containsKey(nameToAskFor)) {
                        mistakes.put(nameToAskFor, mistakes.get(nameToAskFor) + 1);
                    } else {
                        mistakes.put(nameToAskFor, 1);
                    }
                    String intro = "Wrong answer. The correct one is \"";
                    String keyFound = "";
                    for (var card : cards.entrySet()) {
                        if (card.getValue().equals(answer)) {
                            keyFound = card.getKey();
                            break;
                        }
                    }
                    if (keyFound.isEmpty()) {
                        System.out.println(addToIOLogAndReturn(intro + cards.get(nameToAskFor) + "\"."));
                    } else {
                        System.out.println(addToIOLogAndReturn(intro + cards.get(nameToAskFor) + "\"" +
                                ", you've just written the definition of \"" + keyFound + "\"."));
                    }
                }
            }
        }
    }

    private static void cardExport(){
        System.out.println(addToIOLogAndReturn("File name:"));
        filename = scanner.nextLine();
        file = new File(System.getProperty("user.dir") + File.separator + filename);
        try {
            PrintWriter out = new PrintWriter(file);
            for (var card: cards.entrySet()) {
                int mistakesCounter = 0;
                if (mistakes.containsKey(card.getKey())) {
                    mistakesCounter = mistakes.get(card.getKey());
                }
                out.println(card.getKey() + "\t" + card.getValue() + "\t" + mistakesCounter);
            }
            out.close();
            System.out.println(addToIOLogAndReturn(cards.size() + " cards have been saved."));
        } catch (IOException e) {
            System.out.println("Error while writing.");
        }
    }

    private static void cardImport(){
        System.out.println(addToIOLogAndReturn("File name:"));
        filename = scanner.nextLine();
        file = new File(System.getProperty("user.dir") + File.separator + filename);
        try {
            try (Scanner scanner1 = new Scanner(file)) {
                int lineCounter = 0;
                while (scanner1.hasNextLine()) {
                    lineCounter++;
                    String[] nextLine = scanner1.nextLine().split("\t");
                    cards.put(nextLine[0], nextLine[1]);
                    mistakes.put(nextLine[0], Integer.parseInt(nextLine[2]));
                }
                scanner1.close();
                System.out.println(addToIOLogAndReturn(lineCounter + " cards have been loaded."));
            }
        } catch (FileNotFoundException exc) {
            System.out.println(addToIOLogAndReturn("File not found."));
        }
    }

    private static String addToIOLogAndReturn(String line) {
        IOLog.add(line);
        return line;
    }

    private static void log() {
        System.out.println(addToIOLogAndReturn("File name:"));
        filename = scanner.nextLine();
        file = new File(System.getProperty("user.dir") + File.separator + filename);
        try {
            PrintWriter out = new PrintWriter(file);
            for (String log: IOLog) {
                out.println(log);
            }
            out.close();
            System.out.println(addToIOLogAndReturn("The log has been saved."));
        } catch (IOException e) {
            System.out.println("Error while writing.");
        }
    }

    private static void hardestCard() {

        if (mistakes.size() == 0) {
            System.out.println(addToIOLogAndReturn("There are no cards with errors."));
            return;
        }

        int max = Collections.max(mistakes.values());
        int mistakesCounter = 0;
        hardestCards.clear();
        for (var mistake : mistakes.entrySet()) {
            if (mistake.getValue() == max && cards.containsKey(mistake.getKey())) {
                hardestCards.put(mistake.getKey(), cards.get(mistake.getKey()));
                mistakesCounter = mistake.getValue();
            }
        }

        if (hardestCards.size() == 1) {
            String keyName = (String) hardestCards.keySet().toArray()[0];
            System.out.println(addToIOLogAndReturn("The hardest card is \"" + keyName +
                    "\". You have " + mistakes.get(keyName) + " errors answering it."));
        } else {
            List<String> hardestCardsNames = new ArrayList<>();
            for (var card : hardestCards.entrySet()) {
                hardestCardsNames.add(card.getKey());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The hardest cards are ");
            for (int i = 0; i < hardestCardsNames.size() - 1; i++) {
                sb.append("\"").append(hardestCardsNames.get(i)).append("\", ");
            }
            sb.append("\"").append(hardestCardsNames.get(hardestCardsNames.size() - 1)).append("\". ")
                    .append("You have ").append(mistakesCounter).append(" errors answering them.");
            System.out.println(sb);
        }
    }

    private static void resetStats() {
        mistakes.clear();
        System.out.println("Card statistics has been reset.");
    }
}