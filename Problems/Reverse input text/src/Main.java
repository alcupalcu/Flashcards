// Posted from EduTools plugin
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int nextInput = reader.read();
            while (nextInput != -1) {
                sb.append((char) nextInput);
                nextInput = reader.read();
            }

            reader.close();

            String sbAppended = new String(sb);
            char[] output = sbAppended.toCharArray();

            for (int i = output.length - 1; i >= 0; i--) {
                System.out.print(output[i]);
            }
        }
    }
}