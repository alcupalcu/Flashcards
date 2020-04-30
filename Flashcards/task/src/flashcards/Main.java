package flashcards;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static String filename;
    static File file;
    static Map<String, String> cardsMap = new LinkedHashMap<>();
    static Map<Integer, String> namesMap = new LinkedHashMap<>();
    static int namesCounter;

    public static void main(String[] args) {

        String command = "";
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("\nInput the action (add, remove, import, export, ask, exit):");
            command = scanner.nextLine();
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
                case "exit":
                    isRunning = false;
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Action unrecognized.");
            }
        }
    }

    static void cardAdd(){
        System.out.println("The card:");
        String cardName = scanner.nextLine();
        if (cardsMap.containsKey(cardName)) {
            System.out.println("The card \"" + cardName + "\" already exists.");
            return;
        }
        System.out.println("The definition of the card:");
        String cardDefinition = scanner.nextLine();
        if (cardsMap.containsValue(cardDefinition)) {
            System.out.println("The definition \"" + cardDefinition + "\" already exists.");
        } else {
            cardsMap.put(cardName, cardDefinition);
            System.out.println("The pair (\"" + cardName + "\":\"" + cardDefinition + "\") has been added.");
        }
    }

    static void cardRemove(){
        System.out.println("The card:");
        String cardName = scanner.nextLine();
        if (cardsMap.containsKey(cardName)) {
            cardsMap.remove(cardName);
            System.out.println("The card has been removed.");
        } else {
            System.out.println("Can't remove \"" + cardName + "\": there is no such card.");
        }
    }

    static void cardAsk(){
        namesCounter = 0;
        for (var card : cardsMap.entrySet()) {
            namesMap.put(namesCounter, card.getKey());
            namesCounter++;
        }
        System.out.println("How many times to ask?");
        int howManyTimes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < howManyTimes; i++) {
            Random random = new Random();
            int keyToGetFromNames = random.nextInt(namesCounter);
            String nameToAskFor = namesMap.get(keyToGetFromNames);
            if (cardsMap.containsKey(nameToAskFor)) {
                System.out.println("Print the definition of \"" + nameToAskFor + "\":");
                String answer = scanner.nextLine();
                if (answer.equals(cardsMap.get(nameToAskFor))) {
                    System.out.println("Correct answer");
                } else {
                    String intro = "Wrong answer. The correct one is \"";
                    String keyFound = "";
                    for (var card : cardsMap.entrySet()) {
                        if (card.getValue().equals(answer)) {
                            keyFound = card.getKey();
                            break;
                        }
                    }
                    if (keyFound.isEmpty()) {
                        System.out.println(intro + cardsMap.get(nameToAskFor) + "\".");
                    } else {
                        System.out.println(intro + cardsMap.get(nameToAskFor) + "\"" +
                                ", you've just written the definition of \"" + keyFound + "\".");
                    }
                }
            }
        }
    }

    static void cardExport(){
        System.out.println("File name:");
        filename = scanner.nextLine();
        file = new File(System.getProperty("user.dir") + File.separator + filename);
        try {
            PrintWriter out = new PrintWriter(file);
            for (var card: cardsMap.entrySet()) {
                out.println(card.getKey() + "\t" + card.getValue());
            }
            out.close();
            System.out.println(cardsMap.size() + " cards have been saved.");
        } catch (IOException e) {
            System.out.println("Error while writing.");
        }
    }

    static void cardImport(){
        System.out.println("File name:");
        filename = scanner.nextLine();
        file = new File(System.getProperty("user.dir") + File.separator + filename);
        try {
            try (Scanner scanner1 = new Scanner(file)) {
                int lineCounter = 0;
                while (scanner1.hasNextLine()) {
                    lineCounter++;
                    String[] nextLine = scanner1.nextLine().split("\t");
                    cardsMap.put(nextLine[0], nextLine[1]);
                }
                scanner1.close();
                System.out.println(lineCounter + " cards have been loaded.");
            }
        } catch (FileNotFoundException exc) {
            System.out.println("File not found.");
        }
    }
}