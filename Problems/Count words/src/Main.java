// Posted from EduTools plugin
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int input = reader.read();
            char previous = (char) input;
            int spaceCounter = 0;
            int generalCounter = 0;

            while (input != -1) {
                if ((char) input == ' ') {
                    if (previous != (char) input) {
                        spaceCounter++;
                        generalCounter++;
                    }
                } else {
                    generalCounter++;
                }
                previous = (char) input;
                input = reader.read();
            }

            if (spaceCounter == generalCounter) {
                System.out.println(0);
            } else {
                System.out.println(spaceCounter + 1);
            }
        }
    }

}